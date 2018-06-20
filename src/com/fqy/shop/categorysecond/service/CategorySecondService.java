package com.fqy.shop.categorysecond.service;

import org.springframework.transaction.annotation.Transactional;

import com.fqy.shop.categorysecond.dao.CategorySecondDao;
import com.fqy.shop.categorysecond.vo.CategorySecond;

/**
 * ��������ҵ���
 * @author acer
 *
 */
@Transactional
public class CategorySecondService {
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	//��ѯ����
	public CategorySecond findAll(Integer cid) {
		
		return categorySecondDao.findAll(cid);
	}
}
