package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amaker.dao.UserDao;
import com.amaker.entity.User;
import com.amaker.util.DBUtil;
/**
 * 
 * @author ����־
 * �û���¼DAOʵ����
 */
public class UserDaoImpl implements UserDao {
	
	/**
	 * ͨ���û����ƺ������¼����¼�ɹ�����User���󣬵�¼ʧ�ܷ���null
	 */
	public User login(String account, String password) {
		// ��ѯSQL���
		String sql = " select id,account,password,name,permission,remark "+
						" from usertbl "+
						" where account=? and password=? ";
		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		// �������
		Connection conn = util.openConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò�ѯ����
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			// ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery();
			// �ж��û��Ƿ����
			if (rs.next()) {
				// ����û���Ϣ
				int id = rs.getInt(1);
				String name = rs.getString(4);
				int permission = rs.getInt(5);
				String remark = rs.getString(6);
				// ��װ�û���Ϣ
				User u = new User();
				
				u.setId(id);
				u.setAccount(account);
				u.setPassword(password);
				u.setName(name);
				u.setPermission(permission);
				u.setRemark(remark);
				
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		User u = dao.login("admin", "123");
		System.out.println(u.getAccount());
	}

}
