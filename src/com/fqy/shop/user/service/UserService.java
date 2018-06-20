package com.fqy.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.fqy.shop.user.dao.UserDao;
import com.fqy.shop.user.vo.User;
import com.fqy.shop.utils.UUIDUtils;

/**
 * 用户模块业务层
 * 1.事务注解
 * @author acer
 *
 */
@Transactional
public class UserService {
	//注入dao
	private UserDao userDao;
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	//按用户名查询用户
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	/**
	 * 保存注册用户信息
	 * @param user
	 */
	public void save(User user) {
		/*
		 * 将数据存入数据库
		 */
		user.setState(0);//0表示未激活，1表示激活
		//生成64位uuid激活码
		user.setCode(UUIDUtils.getUUID()+UUIDUtils.getUUID());
		
		userDao.save(user);
		
	}
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user) {
		
		return userDao.login(user);
	}
}
