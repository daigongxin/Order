package com.amaker.dao;

import java.util.List;

import com.amaker.entity.QueryOrder;

public interface PayDao {
	// ��ѯ������Ϣ
	public QueryOrder getOrderById(int id);
	// ��ѯ������ϸ
	public List getOrderDetailList(int id);
	// ����
	public void pay(int id);
}
