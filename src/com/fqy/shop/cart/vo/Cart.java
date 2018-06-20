package com.fqy.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fqy.shop.product.vo.Product;

/**
 * ���ﳵʵ��
 * @author acer
 *
 */
public class Cart implements Serializable{//cart�����session�У���Ҫ���л�
	//map��ʽ��Ź�����Ŀ��,key������ʾΨһ��Ŀ����������Ʒid��key
	//LinkedHashMapΪ����
	private Map<Integer, CartItem> cartItems = new 
			LinkedHashMap<Integer, CartItem>();
	//���map��values���֣�������ҳ����ʻ��
	public Collection<CartItem> getCartItems(){
		return cartItems.values();
	}
	
	//�ܼ�
	private double total;
	
	//ҳ�����ܼ�
	public double getTotal() {
		return total;
	}

	/*
	 * ���ﳵ����
	 */
	//1.����������ӵ����ﳵ
	public void addCart(CartItem newCartItem){
		//����Ŀid
		Integer pid = newCartItem.getProduct().getPid();
		//�ж��Ƿ���ڴ���Ŀ��
		if(cartItems.containsKey(pid)){
			//�Ѵ��ڴ���Ŀ
			//��ù��ﳵ��ԭ���Ĺ�����
			CartItem cartItem = cartItems.get(pid);
			//��������
			int count = cartItem.getCount() + newCartItem.getCount();
			newCartItem.setCount(count);
			
		}else{
			//�����ڴ���Ŀ
			//�����Ŀ����ﳵ�������ܼ�
			cartItems.put(pid, newCartItem);
		}
		//�����ܼ�
		total += newCartItem.getSubtotal();
		
	}
	
	//2.��������ӹ��ﳵ�Ƴ�
	public void removeCart(Integer pid){
		//��ָ����Ŀ���Ƴ�
		//���صļ�Ϊɾ������Ŀ��
		CartItem removeCartItem = cartItems.remove(pid);
		//���ܼƼ��ٴ���Ŀ��۸�
		total -= removeCartItem.getSubtotal();
	}
	
	//3.��չ��ﳵ
	public void clearCart(){
		//�����������
		cartItems.clear();
		//���ܼ���Ϊ0
		total = 0;
	}
}
