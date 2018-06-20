package com.fqy.shop.index.action;

import java.util.List;

import com.fqy.shop.category.service.CategoryService;
import com.fqy.shop.category.vo.Category;
import com.fqy.shop.product.service.ProductService;
import com.fqy.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ҳ�������ʵ�actioin
 * @author acer
 *
 */
public class IndexAction extends ActionSupport{
	private CategoryService categoryService;
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setCategoryService(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	/**
	 * ִ�з�����ҳ�ķ���
	 */
	public String execute(){
		//��ѯ�������һ������
		List<Category> categoryList = categoryService.findAll();
		//����ѯ������浽session��
		ActionContext.getContext().getSession().put("categoryList", categoryList);
		
		//����������Ʒ
		List<Product> hotProductList = productService.findHotProduct();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("hotProductList", hotProductList);
		
		//����������Ʒ
		List<Product> newProductList = productService.findNewProduct();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("newProductList", newProductList);
		return "index";
	}
	
	
}
