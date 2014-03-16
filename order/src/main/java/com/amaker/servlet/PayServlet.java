package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.PayDao;
import com.amaker.dao.impl.PayDaoImpl;
import com.amaker.entity.QueryOrder;
import com.amaker.entity.QueryOrderDetail;

/**
 * @author ����־
 * ���ݶ�����ţ���ѯ������ϸ��Ϣ
 */
public class PayServlet extends HttpServlet {
	// ���췽��
	public PayServlet() {
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
		// ʵ����DAO
		PayDao dao = new PayDaoImpl();
		// ��ö���ID
		String id = request.getParameter("id");
		// ��ѯ������Ϣ
		QueryOrder qo = dao.getOrderById(Integer.parseInt(id));
		// ��ѯ������ϸ�б�
		List list = dao.getOrderDetailList(Integer.parseInt(id));
		
		// ƴHTMLҳ��չʾ
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD></HEAD>");
		out.println("  <BODY>");
		out.print("<table>");
			out.print("<tr>");
			
				out.print("<th>");
					out.print("�������");
				out.print("</th>");
				
				out.print("<th>");
					out.print("�µ�ʱ��");
				out.print("</th>");
				
				out.print("<th>");
					out.print("����Ա");
				out.print("</th>");
				
				out.print("<th>");
					out.print("����");
				out.print("</th>");
				
				out.print("<th>");
					out.print("����");
				out.print("</th>");
				
			out.print("</tr>");
			
			out.print("<tr>");
				
				out.print("<td>");
					out.print(id);
				out.print("</td>");
				
				out.print("<td>");
					out.print(qo.getOrderTime());
				out.print("</td>");
				
				out.print("<td>");
					out.print(qo.getName());
				out.print("</td>");
				
				out.print("<td>");
					out.print(qo.getPersonNum());
				out.print("</td>");
				
				out.print("<td>");
					out.print(qo.getTableId());
				out.print("</td>");
				
			out.print("</tr>");
			
			
			out.print("<tr>");
			
			out.print("<th>");
				out.print("����");
			out.print("</th>");
			
			out.print("<th>");
				out.print("�۸�");
			out.print("</th>");
			
			out.print("<th>");
				out.print("����");
			out.print("</th>");
			
			out.print("<th>");
				out.print("�ܼ�");
			out.print("</th>");
			
			out.print("<th>");
				out.print("��ע");
			out.print("</th>");
			
		out.print("</tr>");
			
			for (int i = 0; i < list.size(); i++) {
				QueryOrderDetail qod = (QueryOrderDetail) list.get(i);
				String name = qod.getName();
				int price = qod.getPrice();
				int num = qod.getNum();
				int total = qod.getTotal();
				String remark = qod.getRemark();
				
				out.print("<tr>");
				
					out.print("<td>");
						out.print(name);
					out.print("</td>");
					
					out.print("<td>");
						out.print(price==0? "" :price+"Ԫ");
					out.print("</td>");
					
					out.print("<td>");
						out.print(num==0? "" :num+"Ԫ");
					out.print("</td>");
					
					out.print("<td>");
						out.print(total);
					out.print("</td>");
					
					out.print("<td>");
						out.print(remark);
					out.print("</td>");
					
				out.print("</tr>");
			}
		out.print("</table>");
		out.println("  </BODY>");
		out.println("</HTML>");
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
