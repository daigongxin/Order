package com.amaker.dao;

import com.amaker.entity.Order;
import com.amaker.entity.OrderDetail;
public interface OrderDao {
	// ���濪����Ϣ
	public int saveOrder(Order o );
	// �������б���Ϣ
	public void saveOrderDetail(OrderDetail od);
	// ��������״̬������
	public void updateTableStatus(int tableId);
	// ��������״̬����λ
	public void updateTableStatus2(int orderId);
}
