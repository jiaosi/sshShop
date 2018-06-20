package com.fqy.shop.categorysecond.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fqy.shop.categorysecond.vo.CategorySecond;

/**
 * 二级分类持久层
 * @author acer
 *
 */
public class CategorySecondDao extends HibernateDaoSupport{
	//根据一级分类id查询二级分类
	public CategorySecond findAll(Integer cid) {
		this.getHibernateTemplate().get(CategorySecond.class, cid);
		return null;
	}

}
