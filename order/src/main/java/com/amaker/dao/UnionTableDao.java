package com.amaker.dao;

import java.util.List;
// ��̨���ܽӿ�
public interface UnionTableDao {
	// �����λ�б�
	public  List getTableList();
	// ���ºϲ��������
	public void updateStatus(int tableId1,int tableId2);
}
