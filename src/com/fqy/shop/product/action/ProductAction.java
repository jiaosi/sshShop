package com.fqy.shop.product.action;

import com.fqy.shop.category.vo.Category;
import com.fqy.shop.product.service.ProductService;
import com.fqy.shop.product.vo.Product;
import com.fqy.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒaction
 * @author acer
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	private ProductService productService;
	private Product product = new Product();
	private int cid;// ҳ�洫�Σ���ҳ��
	private int page;// ҳ�洫�Σ���ҳ��
	private int csid;// ��������id
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
	
	//�����ʾ��Ʒ��ϸ��Ϣ
	public String showProductDetails(){
		/*
		 * ����pid��ѯ��Ӧ��Ʒ
		 */
//		//���pid
//		int pid = product.getPid();
//		//����service��ѯ��Ʒ���õ���Ʒ
//		Product product = productService.findByPid(pid);
//		//����Ʒ����ֵջ
//		ActionContext.getContext().getValueStack().set("product", product);
		
		//ģ������ֱ���ã�product�ᱻ�����session->model
		product = productService.findByPid(product.getPid());
		return "showProductDetails";
	}

	//����һ������id��ѯ���ж����������Ʒ
	public String findByCid(){
		//session���Ѿ���category������Ҫ��hibernateӳ���ļ�set���������ӳټ���lazy��Ϊfalse
		
		//��ѯ��Ʒ
		PageBean pageBean = productService.findByCid(cid, page);
		//����pageBean��ֵջ
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	
	//���ն�������id��ѯ��Ʒ������ҳ
	public String findByPageCsid(){
		//��������id��ѯ��Ʒ
		PageBean<Product> pageBean = productService.findByPageCsid(page, csid);
		//��pageBean���浽ֵջ
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByPageCsid";
	}
	
	//��ת�����ﳵ
	public String toCart(){
		//ģ������ֱ���ã�product�ᱻ�����session->model
		product = productService.findByPid(product.getPid());
		
		return "toCart";
	}
	
}
