package com.amaker.entity;

/**
 * 
 * @author hz.guo
 *	���ڷ�װUserTbl���ʵ����
 */
public class User {
	// ���
	private int id;
	// �˺�
	private String account;
	// ����
	private String password;
	// �û�����
	private String name;
	// �Ա�
	private String gender;
	// Ȩ��
	private int permission;
	// ��ע
	private String remark;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
