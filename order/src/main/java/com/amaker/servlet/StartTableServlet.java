package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.OrderDao;
import com.amaker.dao.impl.OrderDaoImpl;
import com.amaker.entity.Order;

/**
 * @author ����־
 * ����Servlet��������Ա�������Ϣ���浽OrderTbl����
 */
public class StartTableServlet extends HttpServlet {
	// ���췽��
	public StartTableServlet() {
		super();
	}

	// ���ٷ���
	public void destroy() {
		super.destroy(); 
	}

	// ��ӦGet����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ���ʱ��
		String orderTime = request.getParameter("orderTime");
		// ����Ա���
		String userId = request.getParameter("userId");
		// ����
		String tableId = request.getParameter("tableId");
		// ����
		String personNum = request.getParameter("personNum");
		// ���DAO�ӿ�
		OrderDao dao = new OrderDaoImpl();
		// ʵ����������
		Order o = new Order();
		// ���ö�������
		o.setOrderTime(orderTime);
		o.setPersonNum(Integer.parseInt(personNum));
		o.setUserId(Integer.parseInt(userId));
		o.setTableId(Integer.parseInt(tableId));
		// ���ض���ID
		int id = dao.saveOrder(o);
		
		// ���²���״̬Ϊ ����
		dao.updateTableStatus(Integer.parseInt(tableId));
		// ����ID
		out.print(id);
		out.flush();
		out.close();
	}

	// ��ӦPost����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	// ��ʼ��
	public void init() throws ServletException {
	}

}
