package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.ChangeTableDao;
import com.amaker.dao.impl.ChangeTableDaoImpl;
/**
 * @author ����־
 * ���ת̨����
 */
public class ChangeTableServlet extends HttpServlet {
	// ���췽��
	public ChangeTableServlet() {
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
		// ����������
		String orderId = request.getParameter("orderId");
		String tableId = request.getParameter("tableId");
		// ʵ����ChangeTableDao
		ChangeTableDao dao = new ChangeTableDaoImpl();
		// ����ת̨����
		dao.changeTable(Integer.parseInt(orderId), Integer.parseInt(tableId));
		// ���ؿͻ�����Ϣ
		out.println("�����ɹ���");
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
