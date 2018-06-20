package com.fqy.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.fqy.shop.user.dao.UserDao;
import com.fqy.shop.user.vo.User;
import com.fqy.shop.utils.UUIDUtils;

/**
 * �û�ģ��ҵ���
 * 1.����ע��
 * @author acer
 *
 */
@Transactional
public class UserService {
	//ע��dao
	private UserDao userDao;
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	//���û�����ѯ�û�
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	/**
	 * ����ע���û���Ϣ
	 * @param user
	 */
	public void save(User user) {
		/*
		 * �����ݴ������ݿ�
		 */
		user.setState(0);//0��ʾδ���1��ʾ����
		//����64λuuid������
		user.setCode(UUIDUtils.getUUID()+UUIDUtils.getUUID());
		
		userDao.save(user);
		
	}
	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public User login(User user) {
		
		return userDao.login(user);
	}
}
