package com.fqy.shop.categorysecond.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fqy.shop.categorysecond.vo.CategorySecond;

/**
 * ��������־ò�
 * @author acer
 *
 */
public class CategorySecondDao extends HibernateDaoSupport{
	//����һ������id��ѯ��������
	public CategorySecond findAll(Integer cid) {
		this.getHibernateTemplate().get(CategorySecond.class, cid);
		return null;
	}

}
