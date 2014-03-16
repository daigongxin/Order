package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amaker.dao.PayDao;
import com.amaker.entity.QueryOrder;
import com.amaker.entity.QueryOrderDetail;
import com.amaker.util.DBUtil;
/**
 * @author ����־
 * ����DAOʵ����
 */
public class PayDaoImpl implements PayDao {
	
	// ���ݶ�����ţ���ѯ������Ϣ
	public QueryOrder getOrderById(int id) {
		// ��ѯSQL���
		String sql =" 	select ot.`orderTime`, "+
					" 	ut.`name`, "+
					" 	ot.`personNum`, "+
					" 	ot.`tableId` "+
					" 	from orderTbl as ot "+
					" 	left join userTbl as ut on ot.`userID` = ut.id "+
					" 	where ot.`id`=? ";

		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		// �������
		Connection conn = util.openConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò�ѯ����
			pstmt.setInt(1, id);
			// ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery();
			// �ж϶����Ƿ����
			if (rs.next()) {
				// ��ö�����Ϣ
				String orderTime = rs.getString(1);
				String userName = rs.getString(2);
				int personNum =rs.getInt(3);
				int tableId = rs.getInt(4);
				QueryOrder qo = new QueryOrder();
				qo.setName(userName);
				qo.setOrderTime(orderTime);
				qo.setPersonNum(personNum);
				qo.setTableId(tableId);
				return qo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		
		return null;
	}
	// ���ݶ�����ţ���ѯ������ϸ�б�
	public List getOrderDetailList(int id) {
		//	��ѯSQL���
		String sql =" 	select mt.`name`, "+
					" 	mt.`price`, "+
					" 	odt.`num`, "+
					" 	mt.price*odt.num as total, "+
					" 	odt.`remark` "+
					" 	from orderdetailTbl as odt "+
					" 	left join menuTbl as mt on odt.`menuId` = mt.id "+
					" 	where odt.`orderId`= ?"+
		
					" 	union "+
					
					" 	select          '',"+
					" 	'',"+
					" 	'',"+
					" 	sum(mt.price*odt.num) as total1,"+
					" 	'' "+
					" 	from orderdetailTbl as odt"+
					" 	left join menuTbl as mt on odt.`menuId` = mt.id"+
					" 	where odt.`orderId`= ? ";
		
		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		// �������
		Connection conn = util.openConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò�ѯ����
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			// ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery();
			// �ж϶�����ϸ
			
			List list = new ArrayList();
			
			while (rs.next()) {
				// ��ö�����ϸ��Ϣ
				String name = rs.getString(1);
				int price = rs.getInt(2);
				int num = rs.getInt(3);
				int total = rs.getInt(4);
				String remark = rs.getString(5);
				
				QueryOrderDetail qod = new QueryOrderDetail();
				
				qod.setName(name);
				qod.setNum(num);
				qod.setPrice(price);
				qod.setTotal(total);
				qod.setRemark(remark);
				
				list.add(qod);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}
	
	// ����
	public void pay(int id) {
		// ��ѯSQL���
		String sql =" update OrderTbl set isPay=1 where id = ?";
		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		// �������
		Connection conn = util.openConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò�ѯ����
			pstmt.setInt(1, id);
			// ִ�и���
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}
}
