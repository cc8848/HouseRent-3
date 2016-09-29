package test;

import com.magic.rent.util.Log;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 16/9/23
 * 类说明:
 */
public class StringLength {

    public static void  main(String[] args){
        MessageDigestPasswordEncoder messageDigestPasswordEncoder =new MessageDigestPasswordEncoder("MD5");
        String passwordMD5=messageDigestPasswordEncoder.encodePassword("199176","18650155502");
        Log.info(StringLength.class,"MD5加密",passwordMD5);
    }
}
