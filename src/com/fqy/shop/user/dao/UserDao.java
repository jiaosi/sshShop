package com.fqy.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fqy.shop.user.vo.User;

/**
 * �û�ģ��־ò�
 * 1.�̳�HibernateDaoSupport����hql��ѯ
 * @author acer
 *
 */
public class UserDao extends HibernateDaoSupport{
	/**
	 * ���û�����ѯ�����ض���
	 * @return
	 */
	public User findByUsername(String username){
		String hql = "from User where username=?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * �����ݴ������ݿ�
	 * @param user
	 */
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	/**
	 * �û���¼��ѯ
	 * @param user
	 * @return
	 */
	public User login(User user) {
		String hql = "from User where username=? and password=? and state=?";
		List<User> listUsers = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(), user.getPassword(), 1);
		if(listUsers != null && listUsers.size() > 0){
			return listUsers.get(0);
		}
		return null;
	}
}
