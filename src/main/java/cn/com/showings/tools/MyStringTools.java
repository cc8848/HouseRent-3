package cn.com.showings.tools;

import cn.com.showings.pojo.exception.ParameterException;
import org.springframework.util.StringUtils;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/24
 * 类说明:
 * 更新记录：
 */
public class MyStringTools {

    /**
     * 参数的非空验证
     *
     * @param str          被检验字符串
     * @param exceptionMsg 报错提示信息
     * @return str 被检验字符串
     */
    public static String checkParameter(String str, String exceptionMsg) throws Exception {
        if (StringUtils.isEmpty(str)) {
            throw new ParameterException(exceptionMsg);
        } else {
            return str;
        }
    }


}
