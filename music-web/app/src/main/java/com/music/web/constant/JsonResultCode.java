package com.music.web.constant;

/**
 * @author wangfucai
 */
public class JsonResultCode {

	/**
	 * 成功
	 */
	public static final String SUCCESS="200";

	/**
	 * 失败
	 */
	public static final String FAILURE="201";
	
	/**
	 * 可用
	 */
	public static final int ENABLE=1;
	
	/**
	 * 不可用
	 *
	 */
	public static final int DISABLE=-1;
	
	/**
	 * 仅仅用于新建账号界面，304代表新建的账号拥有全部的线路权限
	 */
	public static final String ALLWORKPOINT="304";
}