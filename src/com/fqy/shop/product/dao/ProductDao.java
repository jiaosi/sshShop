package com.fqy.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fqy.shop.product.vo.Product;
import com.fqy.shop.utils.PageBean;
import com.fqy.shop.utils.PageHibernateCallback;

/**
 * 商品持久层
 * @author acer
 *
 */
public class ProductDao extends HibernateDaoSupport{
	//查找热门商品
	public List<Product> findHotProduct() {
		//使用离线条件查询热门商品.获得对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		//添加查询条件
		detachedCriteria.add(Restrictions.eq("is_hot", 1));
		//倒序排序
		detachedCriteria.addOrder(Order.desc("pdate"));
		//查询结果
		List<Product> hotProductList = (List<Product>) this.getHibernateTemplate().findByCriteria(detachedCriteria, 0, 10);
		return hotProductList;
	}
	
	//查找最新商品
	public List<Product> findNewProduct() {
		//使用离线条件查询最新商品.获得对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		//倒序排序
		detachedCriteria.addOrder(Order.desc("pdate"));
		//查询结果
		List<Product> newProductList = (List<Product>) this.getHibernateTemplate().findByCriteria(detachedCriteria, 0, 10);
		return newProductList;
	}
	
	//根据商品pid查询商品
	public Product findByPid(int pid) {
//		//hql语句
//		String hql = "from Product where pid=?";
//		//执行hql
//		List<Product> products = (List<Product>) this.getHibernateTemplate().find(hql, pid);
//		if(products != null && products.size() > 0){
//			return products.get(0);
//		}
//		return null;
		
		//get方法获取单条记录，返回对象
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	//按cid查询，分页显示商品
	public List<Product> findByPageCid(int cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs " +
				"join cs.category c where c.cid=?";
		List<Product> productList = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(productList != null && productList.size() > 0){
			return productList;
		}
		return null;
	}
	
	//按cid查询商品总记录数
	public int findCountByCid(int cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> countList = (List<Long>) this.getHibernateTemplate().find(hql, cid);
		if(countList != null && countList.size() > 0){
			return countList.get(0).intValue();
		}
		return 0;
	}
	
	//根据二级分类id查询商品记录数
	public int findCountByCsid(int csid) {
		//hql查询总记录数
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		//执行hql
		List<Long> countList = (List<Long>) this.getHibernateTemplate().find(hql, csid);
		if(countList != null && countList.size() > 0){
			return countList.get(0).intValue();
		}
		return 0;
	}

	//根据二级分类id查询商品对象
	public List<Product> findByPageCsid(int csid, int begin, int limit) {
		//hql语句根据二级分类id查询商品对象
		String hql = "select p from Product p join p.categorySecond cs where cs.csid=?";
		//执行hql
		List<Product> products = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit ));
		if(products != null && products.size() > 0){
			return products;
		}
		return null;
	}
}
