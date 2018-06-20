package com.fqy.shop.utils;

import java.util.UUID;

/**
 * 工具类
 * @author acer
 *
 */
public class UUIDUtils {
	/**
	 * 随机生成32位字符串
	 */
	public static String getUUID(){
		//UUID有横杠需要替换
		return UUID.randomUUID().toString().replace("-", "");
	}
}
