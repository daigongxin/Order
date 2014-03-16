package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amaker.dao.UpdateDao;
import com.amaker.entity.Menu;
import com.amaker.entity.Table;
import com.amaker.util.DBUtil;

/**
 * @author ����־
 *	��ɸ������ݹ���
 */
public class UpdateDaoImpl implements UpdateDao {
	// ��ò˵��б�
	public List getMenuList() {
		// ��ѯSQL���
		String sql =" select id,typeId,price,name,pic,remark from MenuTbl ";
		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		// �������
		Connection conn = util.openConnection();
		try {
			// ���Ԥ�������
			Statement pstmt = conn.createStatement();
			// ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery(sql);
			// �ж϶�����ϸ
			List list = new ArrayList();
			while (rs.next()) {
				// ��ò˵���Ϣ
				
				int id = rs.getInt(1);
				int typeId = rs.getInt(2);
				int price = rs.getInt(3);
				String name = rs.getString(4);
				String pic = rs.getString(5);
				String remark = rs.getString(6);
				
				Menu m = new Menu();
				m.setId(id);
				m.setName(name);
				m.setPic(pic);
				m.setPrice(price);
				m.setRemark(remark);
				m.setTypeId(typeId);
				
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}
	// ��ò����б�
	public List getTableList() {
		// ��ѯSQL���
				String sql =" select id,num,flag,description from TableTbl ";
				// ���ݿ����ӹ�����
				DBUtil util = new DBUtil();
				// �������
				Connection conn = util.openConnection();
				try {
					// ���Ԥ�������
					Statement pstmt = conn.createStatement();
					// ִ�в�ѯ
					ResultSet rs = pstmt.executeQuery(sql);
					// �ж϶�����ϸ
					List list = new ArrayList();
					while (rs.next()) {
						// ��ò˵���Ϣ
						
						int id = rs.getInt(1);
						int num = rs.getInt(2);
						int flag = rs.getInt(3);
						String description = rs.getString(4);
						
						Table t = new Table();
						t.setId(id);
						t.setNum(num);
						t.setFlag(flag);
						t.setDescription(description);
						
						list.add(t);
					}
					return list;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					util.closeConn(conn);
				}
				return null;
	}

}
