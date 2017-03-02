package com.music.web.util;

import com.music.web.constant.CommonConstants;

/***
 * 文件工具类
 * @author Administrator
 *
 */

public class FileUtil {
	
    public static String getPostfix(String path) {
        if (path == null || CommonConstants.EMPTY.equals(path.trim())) {
            return CommonConstants.EMPTY;
        }
        if (path.contains(CommonConstants.POINT)) {
            return path.substring(path.lastIndexOf(CommonConstants.POINT) + 1, path.length());
        }
        return CommonConstants.EMPTY;
    }
}
