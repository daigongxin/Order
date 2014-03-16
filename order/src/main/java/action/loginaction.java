package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.UserDao;
import com.amaker.dao.impl.UserDaoImpl;
import com.amaker.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class loginaction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2831940937850366865L;
	private String account;
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	HttpServletRequest request;

	HttpServletResponse response;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
	

	/*
	
	Map<String, String> message = new HashMap<String, String>();
	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}
  */
	/*
	public String login() throws IOException {

		if ("admin".equals(account) && "123456".equals(password)) {
			message.put("message", "欢迎管理员登陆");

		} else if ((!"admin".equals(account)) && "123456".equals(password)) {
			message.put("message", "欢迎" + account + "登陆！");
		} else {
			message.put("message", "非法登陆信息！");
		}
		byte[] jsonBytes = message.toString().getBytes("utf-8");
		return SUCCESS;
	}
	
	*/
   private  String   userMsg;
	
   public String getUserMsg() {
		return userMsg;
	}

	public void setUserMsg(String userMsg) {
		this.userMsg = userMsg;
	}

public  String  login()  throws IOException{
	   UserDao dao = new UserDaoImpl();
	   User u = dao.login(account, password);
	   build(u);
	   return  SUCCESS;
   }	

   
   
	private String build(User u){
	    userMsg = "";
		userMsg+="id="+u.getId();
		userMsg+=";";
		userMsg+="name="+u.getName();
		return userMsg;
	}
	
}
