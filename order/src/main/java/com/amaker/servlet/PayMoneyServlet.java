package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.OrderDao;
import com.amaker.dao.PayDao;
import com.amaker.dao.impl.OrderDaoImpl;
import com.amaker.dao.impl.PayDaoImpl;
/**
 * @author ����־
 * ʵ�ֽ��㹦��
 */
public class PayMoneyServlet extends HttpServlet {
	// ���췽��
	public PayMoneyServlet() {
		super();
	}
	// ���ٷ���
	public void destroy() {
		super.destroy(); 
	}
	// ��ӦGet����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ʵ����PayDao
		PayDao dao = new PayDaoImpl();
		// ��ö������
		String id = request.getParameter("id");
		// ����
		dao.pay(Integer.parseInt(id));
		// ʵ����OrderDao
		OrderDao dao2 = new OrderDaoImpl();
		// ������״̬����Ϊ��λ
		dao2.updateTableStatus2(Integer.parseInt(id));
		// ��ͻ��˷�����Ϣ
		out.print("�ѽ��㣡");
		out.flush();
		out.close();
	}
	// ��ӦPost����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	// ��ʼ������
	public void init() throws ServletException {
	}
}
