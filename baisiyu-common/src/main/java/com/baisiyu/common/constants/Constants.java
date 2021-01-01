package com.baisiyu.common.constants;

public class Constants {
    // 项目名称
    public static String APP_NAME = "BAISIYU";

    // 项目字符集编码
    public  final static String CHARTER_NAME = "UTF-8";
    // 当前项目激活的环境
    public static String PROFILE_NAME = "prod";

    /**
     * 是否是生产环境
     * @return
     */
    public static boolean isProd(){
        return "prod".equalsIgnoreCase(PROFILE_NAME);
    }
}
