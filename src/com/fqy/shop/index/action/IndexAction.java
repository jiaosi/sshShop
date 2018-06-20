package com.fqy.shop.index.action;

import java.util.List;

import com.fqy.shop.category.service.CategoryService;
import com.fqy.shop.category.vo.Category;
import com.fqy.shop.product.service.ProductService;
import com.fqy.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 首页进来访问的actioin
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
	 * 执行访问首页的方法
	 */
	public String execute(){
		//查询获得所有一级分类
		List<Category> categoryList = categoryService.findAll();
		//将查询结果保存到session中
		ActionContext.getContext().getSession().put("categoryList", categoryList);
		
		//查找热门商品
		List<Product> hotProductList = productService.findHotProduct();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("hotProductList", hotProductList);
		
		//查找最新商品
		List<Product> newProductList = productService.findNewProduct();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("newProductList", newProductList);
		return "index";
	}
	
	
}
