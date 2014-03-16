package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.CheckTableDao;
import com.amaker.dao.impl.CheckTableDaoImpl;
import com.amaker.entity.CheckTable;
/**
 * @author ����־
 * ʵ�ֲ�̨����
 */
public class CheckTableServlet extends HttpServlet {
	// ���췽��
	public CheckTableServlet() {
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
		// ʵ����CheckTableDao
		CheckTableDao dao = new CheckTableDaoImpl();
		// ��ò�����Ϣ�б�
		List list = dao.getTableList();
		// ת��Ϊ�ַ���
		String msg = build(list);
		// ���ظ��ͻ���
		out.print(msg);
		out.flush();
		out.close();
	}
	// ��List�б�ת��Ϊ�ַ���
	private String build(List list){
		String msg = "";
		for (int i = 0; i < list.size(); i++) {
			CheckTable ct = (CheckTable) list.get(i);
			int num = ct.getNum();
			int flag = ct.getFlag();
			msg+=num+","+flag;
			if(i<(list.size()-1))msg+=";";
		}
		return msg;
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
