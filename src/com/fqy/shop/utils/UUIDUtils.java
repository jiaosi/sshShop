package com.fqy.shop.utils;

import java.util.UUID;

/**
 * ������
 * @author acer
 *
 */
public class UUIDUtils {
	/**
	 * �������32λ�ַ���
	 */
	public static String getUUID(){
		//UUID�к����Ҫ�滻
		return UUID.randomUUID().toString().replace("-", "");
	}
}
