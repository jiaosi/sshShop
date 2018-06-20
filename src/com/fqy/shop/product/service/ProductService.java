package com.fqy.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fqy.shop.product.dao.ProductDao;
import com.fqy.shop.product.vo.Product;
import com.fqy.shop.utils.PageBean;

/**
 * 商品业务层
 * @author acer
 *
 */
@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//查找热门商品
	public List<Product> findHotProduct() {
		
		return productDao.findHotProduct();
	}
	
	//查找最新商品
	public List<Product> findNewProduct() {
		
		return productDao.findNewProduct();
	}
	
	//根据pid查询商品
	public Product findByPid(int pid) {
		
		return productDao.findByPid(pid);
	}
	
	//查询商品，分页显示
	public PageBean findByCid(int cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setPage(page);
		//设置总记录数
		int totalCount = productDao.findCountByCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置每页显示数量
		int limit = 8;
		pageBean.setLimit(limit);
		//设置总页数
		int totalPage = (int) Math.ceil(totalCount / limit)+1;//向上取整
		pageBean.setTotalPage(totalPage);
		//设置每页数据集合
		int begin = (page - 1) * limit;
		List<Product> products = productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(products);
		
		return pageBean;
	}
	
	//根据二级分类id查询商品
	public PageBean<Product> findByPageCsid(int page, int csid) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setPage(page);
		//设置总记录数
		int totalCount = productDao.findCountByCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置每页显示数量
		int limit = 8;
		pageBean.setLimit(limit);
		//设置总页数
		int totalPage = (int) Math.ceil(totalCount / limit)+1;//向上取整
		pageBean.setTotalPage(totalPage);
		//设置每页数据集合
		int begin = (page - 1) * limit;
		List<Product> products = productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(products);
		
		return pageBean;
	}
	
}
