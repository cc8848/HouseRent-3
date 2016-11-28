package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.CompanyMapper;
import com.magic.rent.mapper.HouseFileMapper;
import com.magic.rent.mapper.HouseMapper;
import com.magic.rent.mapper.HouseRelateUserMapper;
import com.magic.rent.pojo.*;
import com.magic.rent.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 2016/10/13
 * 类说明:
 */
@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private HouseRelateUserMapper houseRelateUserMapper;

    @Autowired
    private HouseFileMapper houseFileMapper;

    @Autowired
    private CompanyMapper companyMapper;


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int issueHouse(House house, int userID) throws Exception {
        int houseRows = houseMapper.insertSelective(house);

        if (houseRows <= 0) {
            throw new BusinessException("添加房屋信息失败！");
        }

        HouseRelateUser relate = new HouseRelateUser();
        relate.setUserId(userID);
        relate.setHouseId(house.getId());

        int relateRows = houseRelateUserMapper.insert(relate);

        if (relateRows <= 0) {
            throw new BusinessException("建立房屋与用户关系失败！");
        }

        return house.getId();
    }

    public Map<String, Object> showHouseDetails(int houseID) throws Exception {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        House house = houseMapper.selectHouseDetails(houseID);
        dataMap.put("house", house);

        Company company = companyMapper.selectByPrimaryKey(house.getCommunity().getCompanyId());
        dataMap.put("company", company);

        return dataMap;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean saveFile(int houseID, int viewMode, String newFileName, String oldFileName) throws Exception {

        HouseFile houseFile = new HouseFile();
        houseFile.setHouseId(houseID);
        houseFile.setFileName(newFileName);
        houseFile.setNickName(oldFileName);

        House house = new House();
        house.setId(houseID);

        switch (viewMode) {
            case ViewMode.VRMode:
                house.setVrMode(true);
                houseFile.setViewMode(ViewMode.VRMode);
                break;
            case ViewMode.thumbnailMode:
                house.setThumbnailMode(true);
                houseFile.setViewMode(ViewMode.thumbnailMode);
                break;
            default:
                throw new BusinessException("未找到符合的浏览模式!");
        }
        int row = houseMapper.updateByPrimaryKeySelective(house);
        if (row <= 0) {
            throw new BusinessException("修改房屋预览模式失败！");
        }

        int row2 = houseFileMapper.insertSelective(houseFile);

        if ((row2 <= 0)) {
            throw new BusinessException("记录文件名失败！");
        }

        return row > 0 && row2 > 0;
    }

}
