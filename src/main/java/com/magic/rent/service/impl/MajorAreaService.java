package com.magic.rent.service.impl;

import com.magic.rent.exception.custom.BusinessException;
import com.magic.rent.mapper.MajorAreaMapper;
import com.magic.rent.pojo.MajorArea;
import com.magic.rent.service.IMajorAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/16
 * 类说明:
 * 更新记录：
 */
@Service
public class MajorAreaService implements IMajorAreaService {

    @Autowired
    private MajorAreaMapper majorAreaMapper;

    public boolean add(int userID, int areaID) throws Exception {
        if (majorAreaMapper.countByUser(userID) >= 3) {
            throw new BusinessException("一个用户最多只能设置3个专业地区！");
        } else {
            MajorArea majorArea = new MajorArea();
            majorArea.setUserId(userID);
            majorArea.setAreaId(areaID);
            int row = majorAreaMapper.insert(majorArea);
            return row > 0;
        }
    }

    public boolean remove(int userID, int areaID) throws Exception {
        MajorArea majorArea = new MajorArea();
        majorArea.setAreaId(areaID);
        majorArea.setUserId(userID);

        List<MajorArea> majorAreas = majorAreaMapper.selectBySelective(majorArea);
        if (null == majorAreas || majorAreas.size() == 0) {
            throw new BusinessException("要删除的地区不存在，请重新核对！");
        } else {
            int rows = majorAreaMapper.deleteByPrimaryKey(majorAreas.get(0).getId());
            return rows > 0;
        }
    }

    public List<MajorArea> getMyMajorArea(int userID) throws Exception {
        MajorArea majorArea = new MajorArea();
        majorArea.setUserId(userID);
        return majorAreaMapper.selectBySelective(majorArea);
    }
}
