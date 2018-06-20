package com.fqy.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.fqy.shop.cart.vo.Cart;
import com.fqy.shop.cart.vo.CartItem;
import com.fqy.shop.product.service.ProductService;
import com.fqy.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 购物车action
 * @author acer
 *
 */
public class CartAction extends ActionSupport{
	private Integer pid;//表单的pid
	private Integer count;//表单的数量
	private ProductService productService;//用以根据pid查询商品

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	//添加购物车
	public String addCart(){
		/*
		 * 1.封装购物车
		 * 		*订单条目
		 * 		*总计
		 * 2.发送到jsp页面
		 */
		//订单条目
		CartItem cartItem = new CartItem();
		//设置购买数量
		cartItem.setCount(count);
		//根据pid查询商品
		Product product = productService.findByPid(pid);
		//设置购买的商品
		cartItem.setProduct(product);
		
		//将订单条目添加到购物车
		//Cart购物车存放于session,获得cart
		Cart cart = getCart();
		//cart添加订单条目
		cart.addCart(cartItem);
		
		return "addCart";
	}
	
	//从session获得购物车
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest()
				.getSession().getAttribute("cart");
		//判断cart是否存在
		if(cart == null){
			//cart不存在
			//创建cart
			cart = new Cart();
			//存放到session
			ServletActionContext.getRequest()
			.getSession().setAttribute("cart", cart);
		}
		
		return cart;
	}
	
	//清空购物车
	public String clearCart(){
		//得到购物车对象
		Cart cart = getCart();
		//调用方法清空
		cart.clearCart();
		
		return "clearCart";
	}
	
	//删除购物项
	public String removeCart(){
		//得到购物车对象
		Cart cart = getCart();
		//删除指定条目
		cart.removeCart(pid);
		
		return "removeCart";
	}
}
