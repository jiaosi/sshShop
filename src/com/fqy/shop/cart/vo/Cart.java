package com.fqy.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fqy.shop.product.vo.Product;

/**
 * 购物车实体
 * @author acer
 *
 */
public class Cart implements Serializable{//cart存放于session中，需要序列化
	//map形式存放购物条目项,key用来表示唯一条目，所以用商品id作key
	//LinkedHashMap为有序
	private Map<Integer, CartItem> cartItems = new 
			LinkedHashMap<Integer, CartItem>();
	//获得map中values部分，适用于页面访问获得
	public Collection<CartItem> getCartItems(){
		return cartItems.values();
	}
	
	//总计
	private double total;
	
	//页面获得总计
	public double getTotal() {
		return total;
	}

	/*
	 * 购物车功能
	 */
	//1.将购物项添加到购物车
	public void addCart(CartItem newCartItem){
		//新条目id
		Integer pid = newCartItem.getProduct().getPid();
		//判断是否存在此条目项
		if(cartItems.containsKey(pid)){
			//已存在此条目
			//获得购物车中原来的购物项
			CartItem cartItem = cartItems.get(pid);
			//更改数量
			int count = cartItem.getCount() + newCartItem.getCount();
			newCartItem.setCount(count);
			
		}else{
			//不存在此条目
			//添加条目项到购物车，增加总计
			cartItems.put(pid, newCartItem);
		}
		//增加总计
		total += newCartItem.getSubtotal();
		
	}
	
	//2.将购物项从购物车移除
	public void removeCart(Integer pid){
		//将指定条目项移除
		//返回的即为删除的条目项
		CartItem removeCartItem = cartItems.remove(pid);
		//将总计减少此条目项价格
		total -= removeCartItem.getSubtotal();
	}
	
	//3.清空购物车
	public void clearCart(){
		//将购物项清空
		cartItems.clear();
		//将总价设为0
		total = 0;
	}
}
