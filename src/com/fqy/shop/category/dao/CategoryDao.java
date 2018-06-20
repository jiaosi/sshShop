package com.fqy.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fqy.shop.category.vo.Category;

/**
 * Ŀ¼�־ò�
 * @author acer
 *
 */
public class CategoryDao extends HibernateDaoSupport{
	/**
	 * ��ѯ����һ������
	 * @return
	 */
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> categoryList = (List<Category>) this.getHibernateTemplate().find(hql);
		if(categoryList != null && categoryList.size() > 0){
			return categoryList;
		}
		return null;
	}

}
