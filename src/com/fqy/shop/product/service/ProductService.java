package com.fqy.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fqy.shop.product.dao.ProductDao;
import com.fqy.shop.product.vo.Product;
import com.fqy.shop.utils.PageBean;

/**
 * ��Ʒҵ���
 * @author acer
 *
 */
@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//����������Ʒ
	public List<Product> findHotProduct() {
		
		return productDao.findHotProduct();
	}
	
	//����������Ʒ
	public List<Product> findNewProduct() {
		
		return productDao.findNewProduct();
	}
	
	//����pid��ѯ��Ʒ
	public Product findByPid(int pid) {
		
		return productDao.findByPid(pid);
	}
	
	//��ѯ��Ʒ����ҳ��ʾ
	public PageBean findByCid(int cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ
		pageBean.setPage(page);
		//�����ܼ�¼��
		int totalCount = productDao.findCountByCid(cid);
		pageBean.setTotalCount(totalCount);
		//����ÿҳ��ʾ����
		int limit = 8;
		pageBean.setLimit(limit);
		//������ҳ��
		int totalPage = (int) Math.ceil(totalCount / limit)+1;//����ȡ��
		pageBean.setTotalPage(totalPage);
		//����ÿҳ���ݼ���
		int begin = (page - 1) * limit;
		List<Product> products = productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(products);
		
		return pageBean;
	}
	
	//���ݶ�������id��ѯ��Ʒ
	public PageBean<Product> findByPageCsid(int page, int csid) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ
		pageBean.setPage(page);
		//�����ܼ�¼��
		int totalCount = productDao.findCountByCsid(csid);
		pageBean.setTotalCount(totalCount);
		//����ÿҳ��ʾ����
		int limit = 8;
		pageBean.setLimit(limit);
		//������ҳ��
		int totalPage = (int) Math.ceil(totalCount / limit)+1;//����ȡ��
		pageBean.setTotalPage(totalPage);
		//����ÿҳ���ݼ���
		int begin = (page - 1) * limit;
		List<Product> products = productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(products);
		
		return pageBean;
	}
	
}
