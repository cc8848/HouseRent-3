package com.magic.rent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.rent.exception.custom.AuthorityOverstepException;
import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.exception.custom.HouseImageSaveException;
import com.magic.rent.exception.custom.TargetNotFoundException;
import com.magic.rent.mapper.HandHouseMapper;
import com.magic.rent.mapper.HouseImageMapper;
import com.magic.rent.pojo.*;
import com.magic.rent.service.IHandHouseService;
import com.magic.rent.tools.CompressTools;
import com.magic.rent.tools.FileTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 2016/12/22
 * 类说明: 二手房相关服务实现
 * 更新记录：
 */
@Service
public class HandHouseService implements IHandHouseService {

    @Autowired
    private HandHouseMapper handHouseMapper;

    @Autowired
    private HouseImageMapper houseImageMapper;

    public PageInfo<HandHouseInfo> getHandHouseByUser(Integer userID, int pageSize, int pageNum) throws Exception {
        HandHouseInfo houseDetail = new HandHouseInfo();
        houseDetail.setUserId(userID);
        PageHelper.startPage(pageNum, pageSize);
        List<HandHouseInfo> houseDetailList = handHouseMapper.selectBySelective(houseDetail);
        return new PageInfo<HandHouseInfo>(houseDetailList);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean issueHouse(HandHouseInfo handHouseInfo, List<HouseImage> houseImages) throws Exception {
        int rows = handHouseMapper.insert(handHouseInfo);
        if (rows > 0) {
            List<HouseImage> errorImages = new ArrayList<HouseImage>();
            for (HouseImage houseImage : houseImages) {
                //连续查询数据库这样其实是不合适的，但是当前还想不到更好的办法解决这个问题，暂且先这样处理
                HouseImage result = houseImageMapper.selectByImageAndUserID(houseImage);
                if (null == result) {
                    errorImages.add(houseImage);
                } else {
                    houseImage.setHouseId(handHouseInfo.getHouseId());
                    int row = houseImageMapper.updateByPrimaryKeySelective(houseImage);
                    if (row <= 0) {
                        errorImages.add(houseImage);
                    }
                }
            }
            if (errorImages.isEmpty()) {
                return true;
            } else {
                throw new HouseImageSaveException("房源图片保存失败！", errorImages);
            }
        } else {
            return false;
        }
    }

    public boolean deleteHouse(Integer houseID, Integer userID) throws Exception {
        HandHouse handHouse = handHouseMapper.selectBaseByPrimaryKey(houseID);
        if (null == handHouse) {//判断房源是否存在
            throw new TargetNotFoundException("对应房源不存在！");
        } else if (!handHouse.getUserId().equals(userID)) {//判断房屋对应的用户ID是否与当前操作用户相同
            throw new AuthorityOverstepException("您没有权限删除他人的房源！");
        } else {
            return handHouseMapper.deleteByPrimaryKey(houseID) > 0;
        }
    }

    public boolean modifyPrice(HandHousePrice housePrice) throws Exception {
        HandHouse handHouse = handHouseMapper.selectBaseByPrimaryKey(housePrice.getHouseId());
        if (null == handHouse) {
            throw new TargetNotFoundException("对应房源不存在！");
        } else if (!handHouse.getUserId().equals(housePrice.getUserId())) {//判断房屋对应的用户ID是否与当前操作用户相同
            throw new AuthorityOverstepException("您没有权限修改他人的房源！");
        } else {
            return handHouseMapper.updateByPrimaryKeyForPrice(housePrice) > 0;
        }
    }

    public boolean modifyDetail(HandHouseDetail houseDetail) throws Exception {
        HandHouse handHouse = handHouseMapper.selectBaseByPrimaryKey(houseDetail.getHouseId());
        if (null == handHouse) {
            throw new TargetNotFoundException("对应房源不存在！");
        } else if (!handHouse.getUserId().equals(houseDetail.getUserId())) {//判断房屋对应的用户ID是否与当前操作用户相同
            throw new AuthorityOverstepException("您没有权限修改他人的房源！");
        } else {
            return handHouseMapper.updateByPrimaryKeyForDetail(houseDetail) > 0;
        }
    }

    public boolean modifyInfo(HandHouseInfo houseInfo) throws Exception {
        HandHouse handHouse = handHouseMapper.selectBaseByPrimaryKey(houseInfo.getHouseId());
        if (null == handHouse) {
            throw new TargetNotFoundException("对应房源不存在！");
        } else if (!handHouse.getUserId().equals(houseInfo.getUserId())) {//判断房屋对应的用户ID是否与当前操作用户相同
            throw new AuthorityOverstepException("您没有权限修改他人的房源！");
        } else {
            return handHouseMapper.updateByPrimaryKeyForInfo(houseInfo) > 0;
        }
    }

    public List<HouseImage> saveHousePictures(List<MultipartFile> multipartFileList, Integer userID) throws Exception {

        List<HouseImage> houseImageList = new ArrayList<HouseImage>();

        for (MultipartFile multipartFile : multipartFileList) {
            // 创建存储路径并重命名文件名
            String path = FileTools.getHousePicPath(userID) + FileTools.getPicFileName(multipartFile.getOriginalFilename());

            File file = new File(path);

            // 写入磁盘
            multipartFile.transferTo(file);

            //压缩图片
            CompressTools compressTools = new CompressTools(file);
            compressTools.startCompress();

            //创建图片对象
            HouseImage houseImage = new HouseImage();
            houseImage.setUserId(userID);
            houseImage.setImageSrc(FileTools.filePathToSRC(path, FileTools.IMG));

            int rows = houseImageMapper.insert(houseImage);

            if (rows > 0) {//操作成功后，将对象添加到集合当中
                houseImageList.add(houseImage);
            }
        }

        return houseImageList;
    }
}
