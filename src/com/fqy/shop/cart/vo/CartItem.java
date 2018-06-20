package com.fqy.shop.cart.vo;

import com.fqy.shop.product.vo.Product;

/**
 * ���ﳵ��Ŀ��
 * @author acer
 *
 */
public class CartItem {
	private Product product;//��Ʒ
	private Integer count;//��������
	private double subtotal;//С��
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
