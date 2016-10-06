package com.magic.rent.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/10/6
 * 类说明:
 */
public class UTF8Util {
    /**
     * "/"分隔符
     *
     * @param str
     * @return
     */
    public static String GBK2Unicode(String str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if (!isNeedConvert(chr)) {
                result.append(chr);
                continue;
            }
            result.append("\\u" + Integer.toHexString((int) chr));
        }
        return result.toString();
    }

    public static boolean isNeedConvert(char para) {
        return ((para & (0x00FF)) != para);
    }

    /**
     * &#分隔符
     *
     * @param str
     * @return
     */
    public static String GBK2Unicode2(String str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            result.append("&#" + Integer.toString((int) chr) + ";");
        }
        return result.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println("UTF-8:" + GBK2Unicode(str));
        System.out.println("UTF-82:" + GBK2Unicode2(str));
    }
}
