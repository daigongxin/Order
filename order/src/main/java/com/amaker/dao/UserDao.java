package com.amaker.dao;

import com.amaker.entity.User;
// UesrDao �ӿ�
public interface UserDao {
	// ��¼����
	public User login(String account,String password);
}
