package com.fqy.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fqy.shop.category.dao.CategoryDao;
import com.fqy.shop.category.vo.Category;

/**
 * Ŀ¼ҵ���
 * @author acer
 *
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}
	/**
	 * ��ѯ����һ������
	 * @return
	 */
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

}
