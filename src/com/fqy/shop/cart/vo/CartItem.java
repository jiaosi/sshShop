package com.fqy.shop.cart.vo;

import com.fqy.shop.product.vo.Product;

/**
 * 购物车条目项
 * @author acer
 *
 */
public class CartItem {
	private Product product;//商品
	private Integer count;//购买数量
	private double subtotal;//小计
	public double getSubtotal() {
		return count*product.getShop_price();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
