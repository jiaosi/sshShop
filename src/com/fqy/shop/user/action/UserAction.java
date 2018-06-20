package com.fqy.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fqy.shop.user.service.UserService;
import com.fqy.shop.user.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * �û�ģ���action��
 * 1.Ҫʵ��ģ�������ӿ�
 * @author acer
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//ģ���������ʵ�������
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	//ģ�������������
	private String vCode;
	public void setVCode(String vCode){
		this.vCode = vCode;
	}
	
	//ע��service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * ��ת��ע��ҳ���action����
	 */
	public String registerPage(){
		
		return "registerPage";
	}
	/**
	 * ajax�첽У���û����Ƿ��Ѵ���
	 * @return
	 * @throws IOException 
	 */
	public String findByUsername() throws IOException{
		//��ѯ�û�
		User existUser = userService.findByUsername(user.getUsername());
		//���response������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�ж��û��Ƿ����
		if(existUser != null){
			//�û�����
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		}else{
			//�û�������
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	
	/**
	 * �û�ע���̨У��
	 * @return
	 */
	public String regist(){
		//�ж���֤��
		String inputVCode = (String) ServletActionContext.getRequest().getSession().getAttribute("vCode");
		if(!inputVCode.equalsIgnoreCase(vCode)){
			//��֤�����
			this.addActionError("��֤�����");
			return "registerPage";
		}
		
		//����ע����Ϣ
		userService.save(user);
		this.addActionMessage("ע��ɹ���");
		return "msg";
	}
	
	/**
	 * ��¼ҳ��
	 * @return
	 */
	public String loginPage(){
		return "login";
	}
	
	/**
	 * ��¼
	 * @return
	 */
	public String login(){
		
		//�ж���֤��
		String inputvCode = (String) ServletActionContext.getRequest().getSession().getAttribute("vCode");
		if(!inputvCode.equalsIgnoreCase(vCode)){
			//��֤�벻��ȷ
			this.addActionError("��֤�벻��ȷ��");
			return LOGIN;
		}
		
		//��ѯ�û�
		User existUser = userService.login(user);
		//�ж��û��Ƿ����
		if(existUser != null){
			//���ڣ������û���Ϣ��session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			//ҳ����ת������ҳ
			return "loginSuccess";
		}else{
			//������
			//���������Ϣ
			this.addActionError("�û�����������󣬻���δ���");
			//���ص�¼ҳ��
			return LOGIN;
		}
	}
	
	/**
	 * �˳�
	 * @return
	 */
	public String quit(){
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	
}
