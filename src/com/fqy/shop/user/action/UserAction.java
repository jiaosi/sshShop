package com.fqy.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fqy.shop.user.service.UserService;
import com.fqy.shop.user.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 用户模块的action类
 * 1.要实现模型驱动接口
 * @author acer
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动获得实体类对象
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	//模型驱动获得属性
	private String vCode;
	public void setVCode(String vCode){
		this.vCode = vCode;
	}
	
	//注入service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 跳转到注册页面的action方法
	 */
	public String registerPage(){
		
		return "registerPage";
	}
	/**
	 * ajax异步校验用户名是否已存在
	 * @return
	 * @throws IOException 
	 */
	public String findByUsername() throws IOException{
		//查询用户
		User existUser = userService.findByUsername(user.getUsername());
		//获得response对象，向页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//判断用户是否存在
		if(existUser != null){
			//用户存在
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		}else{
			//用户不存在
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	/**
	 * 用户注册后台校验
	 * @return
	 */
	public String regist(){
		//判断验证码
		String inputVCode = (String) ServletActionContext.getRequest().getSession().getAttribute("vCode");
		if(!inputVCode.equalsIgnoreCase(vCode)){
			//验证码错误
			this.addActionError("验证码错误！");
			return "registerPage";
		}
		
		//保存注册信息
		userService.save(user);
		this.addActionMessage("注册成功！");
		return "msg";
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	public String loginPage(){
		return "login";
	}
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		
		//判断验证码
		String inputvCode = (String) ServletActionContext.getRequest().getSession().getAttribute("vCode");
		if(!inputvCode.equalsIgnoreCase(vCode)){
			//验证码不正确
			this.addActionError("验证码不正确！");
			return LOGIN;
		}
		
		//查询用户
		User existUser = userService.login(user);
		//判断用户是否存在
		if(existUser != null){
			//存在，保存用户信息至session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			//页面跳转返回首页
			return "loginSuccess";
		}else{
			//不存在
			//保存错误信息
			this.addActionError("用户名或密码错误，或者未激活！");
			//返回登录页面
			return LOGIN;
		}
	}
	
	/**
	 * 退出
	 * @return
	 */
	public String quit(){
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	
}
