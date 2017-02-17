package cn.com.showings.service.impl.select;

import cn.com.showings.dao.mapper.HouseParameterMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/23
 * 类说明: 将房屋的相关属性下拉框在项目启动时从数据库中提前加载至内存中当缓存使用，避免每次
 * 都从数据库中获取数据，这部分数据属于很少会添加的数据，但不可避免的有可能会有做修改，提供
 * 了一个可以刷新内存数据的方法，当这部分需要修改时，可以调用该方法刷新内存中的值。
 * 更新记录：
 */
@Service
public class HouseItemsSource implements InitializingBean {

    @Autowired
    private HouseParameterMapper houseParameterMapper;

    public static final String UNDEFINED = "未定义";

    //朝向
    public static Map<Integer, String> ORIENTATION_MAP = new HashMap<Integer, String>();

    //装修情况
    public static Map<Integer, String> DECORATION_MAP = new HashMap<Integer, String>();

    //房屋类型
    public static Map<Integer, String> TYPE_MAP = new HashMap<Integer, String>();

    private Map<Integer, String> loadOrientation() {
        List<Map<Integer, String>> mapList = houseParameterMapper.getOrientationMap();
        Map<Integer, String> orientationMap = new HashMap<Integer, String>();
        for (Map<Integer, String> map : mapList) {
            orientationMap.putAll(map);
        }
        return orientationMap;
    }

    private Map<Integer, String> loadDecoration() {
        List<Map<Integer, String>> mapList = houseParameterMapper.getDecorationMap();
        Map<Integer, String> decorationMap = new HashMap<Integer, String>();
        for (Map<Integer, String> map : mapList) {
            decorationMap.putAll(map);
        }
        return decorationMap;
    }

    private Map<Integer, String> loadType() {
        List<Map<Integer, String>> mapList = houseParameterMapper.getTypeMap();
        Map<Integer, String> typeMap = new HashMap<Integer, String>();
        for (Map<Integer, String> map : mapList) {
            typeMap.putAll(map);
        }
        return typeMap;
    }

    public void afterPropertiesSet() throws Exception {
        ORIENTATION_MAP = loadOrientation();
        DECORATION_MAP = loadDecoration();
        TYPE_MAP = loadType();
    }

    public void refreshOrientationItems() {
        ORIENTATION_MAP = loadOrientation();
    }

    public void refreshDecorationItems() {
        DECORATION_MAP = loadDecoration();
    }

    public void refreshTypeItems() {
        TYPE_MAP = loadType();
    }

}
