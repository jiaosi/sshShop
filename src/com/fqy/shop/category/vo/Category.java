package com.fqy.shop.category.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fqy.shop.categorysecond.vo.CategorySecond;

/**
 * ����ʵ���
 * @author acer
 *
 */
public class Category implements Serializable{//ʵ�����л��ӿڣ����ڶ�ȡsession�쳣�رպ��γɵı����ļ�
	private Integer cid;
	private String cname;
	//һ�Զࣺһ��һ���������ж����������
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
