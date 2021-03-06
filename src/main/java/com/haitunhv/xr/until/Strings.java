package com.haitunhv.xr.until;

/**
 * @Author: gss
 * @Date: 2021/3/4 22:29
 */
public class Strings {
    public static String underlineCase(String str){
        if (str == null) return null;
        int len = str.length();
        if (len == 0) return str;

        StringBuffer sb = new StringBuffer();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
