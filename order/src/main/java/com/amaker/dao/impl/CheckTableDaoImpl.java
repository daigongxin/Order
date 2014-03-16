package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amaker.dao.CheckTableDao;
import com.amaker.entity.CheckTable;
import com.amaker.util.DBUtil;
/**
 * @author ����־
 * ��̨DAOʵ����
 */
public class CheckTableDaoImpl implements CheckTableDao {

	// ��ò����б�
	public List getTableList() {
		// ��ѯSQL���
		String sql =" select num,flag from tableTbl";
		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		// �������
		Connection conn = util.openConnection();
		try {
			// ���Ԥ�������
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			List list = new ArrayList();
			while (rs.next()) {
				int num = rs.getInt(1);
				int flag = rs.getInt(2);
				CheckTable ct = new CheckTable();
				ct.setFlag(flag);
				ct.setNum(num);
				list.add(ct);
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
