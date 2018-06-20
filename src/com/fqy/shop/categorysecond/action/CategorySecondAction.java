package com.fqy.shop.categorysecond.action;

import com.fqy.shop.categorysecond.service.CategorySecondService;
import com.fqy.shop.categorysecond.vo.CategorySecond;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��������action
 * @author acer
 *
 */
public class CategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	private CategorySecondService categorySecondService;
	private CategorySecond categorySecond = new CategorySecond();

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	//��ѯ����
	public String findAll(){
		categorySecond = categorySecondService.findAll(categorySecond.getCategory().getCid());
		
		return "findAll";
	}
}






