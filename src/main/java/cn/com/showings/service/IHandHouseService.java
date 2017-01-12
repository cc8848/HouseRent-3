package cn.com.showings.service;

import com.github.pagehelper.PageInfo;
import cn.com.showings.pojo.HandHouseDetail;
import cn.com.showings.pojo.HandHouseInfo;
import cn.com.showings.pojo.HandHousePrice;
import cn.com.showings.pojo.HouseImage;
import org.springframework.web.multipart.MultipartFile;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: Wu   创建时间: 2016/12/22
 * 类说明: 二手房相关服务接口
 * 更新记录：
 */
public interface IHandHouseService {

    /**
     * 获取指定用户的房源清单
     *
     * @param userID   指定用户的ID
     * @param pageSize 分页大小
     * @param pageNum  页码
     * @return
     * @throws Exception
     */
    PageInfo<HandHouseInfo> getHandHouseByUser(Integer userID, int pageSize, int pageNum) throws Exception;

    /**
     * 发布二手房信息
     *
     * @param handHouseInfo 房源信息
     * @return
     * @throws Exception
     */
    boolean issueHouse(HandHouseInfo handHouseInfo) throws Exception;

    /**
     * 删除房源信息
     *
     * @param houseID 删除房屋的ID
     * @param userID  当前操作用户的ID
     * @return
     * @throws Exception
     */
    boolean deleteHouse(Integer houseID, Integer userID) throws Exception;

    /**
     * 修改房源价格信息
     *
     * @param housePrice 新房源价格信息
     * @return
     * @throws Exception
     */
    boolean modifyPrice(HandHousePrice housePrice) throws Exception;

    /**
     * 修改房源详细情况
     *
     * @param houseDetail 新房源情况信息
     * @return
     * @throws Exception
     */
    boolean modifyDetail(HandHouseDetail houseDetail) throws Exception;

    /**
     * 修改房源基础信息
     *
     * @param houseInfo 新房源基础信息
     * @return
     * @throws Exception
     */
    boolean modifyInfo(HandHouseInfo houseInfo) throws Exception;

    /**
     * 将图片存入硬盘
     *
     * @param multipartFile 分部文件
     * @param userID        用户ID
     * @return
     * @throws Exception
     */
    HouseImage saveHousePictures(MultipartFile multipartFile, Integer userID) throws Exception;
}
