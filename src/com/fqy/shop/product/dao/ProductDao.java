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
 * ��Ʒ�־ò�
 * @author acer
 *
 */
public class ProductDao extends HibernateDaoSupport{
	//����������Ʒ
	public List<Product> findHotProduct() {
		//ʹ������������ѯ������Ʒ.��ö���
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		//��Ӳ�ѯ����
		detachedCriteria.add(Restrictions.eq("is_hot", 1));
		//��������
		detachedCriteria.addOrder(Order.desc("pdate"));
		//��ѯ���
		List<Product> hotProductList = (List<Product>) this.getHibernateTemplate().findByCriteria(detachedCriteria, 0, 10);
		return hotProductList;
	}
	
	//����������Ʒ
	public List<Product> findNewProduct() {
		//ʹ������������ѯ������Ʒ.��ö���
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		//��������
		detachedCriteria.addOrder(Order.desc("pdate"));
		//��ѯ���
		List<Product> newProductList = (List<Product>) this.getHibernateTemplate().findByCriteria(detachedCriteria, 0, 10);
		return newProductList;
	}
	
	//������Ʒpid��ѯ��Ʒ
	public Product findByPid(int pid) {
//		//hql���
//		String hql = "from Product where pid=?";
//		//ִ��hql
//		List<Product> products = (List<Product>) this.getHibernateTemplate().find(hql, pid);
//		if(products != null && products.size() > 0){
//			return products.get(0);
//		}
//		return null;
		
		//get������ȡ������¼�����ض���
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	//��cid��ѯ����ҳ��ʾ��Ʒ
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
	
	//��cid��ѯ��Ʒ�ܼ�¼��
	public int findCountByCid(int cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> countList = (List<Long>) this.getHibernateTemplate().find(hql, cid);
		if(countList != null && countList.size() > 0){
			return countList.get(0).intValue();
		}
		return 0;
	}
	
	//���ݶ�������id��ѯ��Ʒ��¼��
	public int findCountByCsid(int csid) {
		//hql��ѯ�ܼ�¼��
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		//ִ��hql
		List<Long> countList = (List<Long>) this.getHibernateTemplate().find(hql, csid);
		if(countList != null && countList.size() > 0){
			return countList.get(0).intValue();
		}
		return 0;
	}

	//���ݶ�������id��ѯ��Ʒ����
	public List<Product> findByPageCsid(int csid, int begin, int limit) {
		//hql�����ݶ�������id��ѯ��Ʒ����
		String hql = "select p from Product p join p.categorySecond cs where cs.csid=?";
		//ִ��hql
		List<Product> products = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit ));
		if(products != null && products.size() > 0){
			return products;
		}
		return null;
	}
}
