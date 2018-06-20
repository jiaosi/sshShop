package com.fqy.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.fqy.shop.cart.vo.Cart;
import com.fqy.shop.cart.vo.CartItem;
import com.fqy.shop.product.service.ProductService;
import com.fqy.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * ���ﳵaction
 * @author acer
 *
 */
public class CartAction extends ActionSupport{
	private Integer pid;//����pid
	private Integer count;//��������
	private ProductService productService;//���Ը���pid��ѯ��Ʒ

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	//��ӹ��ﳵ
	public String addCart(){
		/*
		 * 1.��װ���ﳵ
		 * 		*������Ŀ
		 * 		*�ܼ�
		 * 2.���͵�jspҳ��
		 */
		//������Ŀ
		CartItem cartItem = new CartItem();
		//���ù�������
		cartItem.setCount(count);
		//����pid��ѯ��Ʒ
		Product product = productService.findByPid(pid);
		//���ù������Ʒ
		cartItem.setProduct(product);
		
		//��������Ŀ��ӵ����ﳵ
		//Cart���ﳵ�����session,���cart
		Cart cart = getCart();
		//cart��Ӷ�����Ŀ
		cart.addCart(cartItem);
		
		return "addCart";
	}
	
	//��session��ù��ﳵ
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest()
				.getSession().getAttribute("cart");
		//�ж�cart�Ƿ����
		if(cart == null){
			//cart������
			//����cart
			cart = new Cart();
			//��ŵ�session
			ServletActionContext.getRequest()
			.getSession().setAttribute("cart", cart);
		}
		
		return cart;
	}
	
	//��չ��ﳵ
	public String clearCart(){
		//�õ����ﳵ����
		Cart cart = getCart();
		//���÷������
		cart.clearCart();
		
		return "clearCart";
	}
	
	//ɾ��������
	public String removeCart(){
		//�õ����ﳵ����
		Cart cart = getCart();
		//ɾ��ָ����Ŀ
		cart.removeCart(pid);
		
		return "removeCart";
	}
}
