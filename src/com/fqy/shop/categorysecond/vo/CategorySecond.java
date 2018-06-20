package com.fqy.shop.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import com.fqy.shop.category.vo.Category;
import com.fqy.shop.product.vo.Product;

/**
 * 二级分类
 * @author acer
 *`csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `categorysecond_ibfk_1` (`cid`),
  CONSTRAINT `categorysecond_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
 */
public class CategorySecond {
	private Integer csid;
	private String csname;
	//多个二级分类对应一个一级分类
	private Category category;
	//一个二级分类对应多个商品，一对多
	private Set<Product> products = new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
