package com.fqy.shop.category.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fqy.shop.categorysecond.vo.CategorySecond;

/**
 * 分类实体层
 * @author acer
 *
 */
public class Category implements Serializable{//实现序列化接口，用于读取session异常关闭后形成的本地文件
	private Integer cid;
	private String cname;
	//一对多：一个一级分类下有多个二级分类
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
