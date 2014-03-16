package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.UpdateDao;
import com.amaker.dao.impl.UpdateDaoImpl;
import com.amaker.entity.Menu;

/**
 * @author ����־
 * ������ݸ��¹���
 */
public class UpdateServlet extends HttpServlet {
	// ���췽��
	public UpdateServlet() {
		super();
	}
	// ���ٷ���
	public void destroy() {
		super.destroy();
	}
	// ��ӦGet����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		// ʵ����dao
		UpdateDao dao = new UpdateDaoImpl();
		// ��ò����б�
		List list = dao.getMenuList();
		
		// ƴXML��ʽ����
		out.println("<?xml version='1.0' encoding='UTF-8'?>");
		// ���ڵ�
		out.println("<menulist>");
			for (int i = 0; i <list.size(); i++) {
				Menu m = (Menu)list.get(i);
				out.println("<menu>");
					// ���ױ��
					out.print("<id>");
						out.print(m.getId());
					out.println("</id>");
					// ����
					out.print("<typeId>");
						out.print(m.getTypeId());
					out.println("</typeId>");
					// ����
					out.print("<name>");
						out.print(m.getName());
					out.println("</name>");
					// ͼƬ·��
					out.print("<pic>");
						out.print(m.getPic());
					out.println("</pic>");
					// �۸�
					out.print("<price>");
						out.print(m.getPrice());
					out.println("</price>");
					// ��ע
					out.print("<remark>");
						out.print(m.getRemark());
					out.println("</remark>");
					
				out.println("</menu>");
			}
		out.println("</menulist>");
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
