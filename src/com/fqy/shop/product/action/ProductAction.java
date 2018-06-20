package com.fqy.shop.product.action;

import com.fqy.shop.category.vo.Category;
import com.fqy.shop.product.service.ProductService;
import com.fqy.shop.product.vo.Product;
import com.fqy.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品action
 * @author acer
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	private ProductService productService;
	private Product product = new Product();
	private int cid;// 页面传参，分页用
	private int page;// 页面传参，分页用
	private int csid;// 二级分类id
	private int pid;

	public int getPid() {
		return pid;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public Product getModel() {
		return product;
	}
	
	//点击显示商品详细信息
	public String showProductDetails(){
		/*
		 * 根据pid查询相应商品
		 */
//		//获得pid
//		int pid = product.getPid();
//		//调用service查询商品，得到商品
//		Product product = productService.findByPid(pid);
//		//将商品存入值栈
//		ActionContext.getContext().getValueStack().set("product", product);
		
		//模型驱动直接用，product会被存放于session->model
		product = productService.findByPid(product.getPid());
		return "showProductDetails";
	}

	//按照一级分类id查询所有二级分类和商品
	public String findByCid(){
		//session中已经有category，但是要将hibernate映射文件set集合属性延迟加载lazy改为false
		
		//查询商品
		PageBean pageBean = productService.findByCid(cid, page);
		//保存pageBean到值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	
	//按照二级分类id查询商品，带分页
	public String findByPageCsid(){
		//二级分类id查询商品
		PageBean<Product> pageBean = productService.findByPageCsid(page, csid);
		//将pageBean保存到值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByPageCsid";
	}
	
	//跳转到购物车
	public String toCart(){
		//模型驱动直接用，product会被存放于session->model
		product = productService.findByPid(product.getPid());
		
		return "toCart";
	}
	
}
