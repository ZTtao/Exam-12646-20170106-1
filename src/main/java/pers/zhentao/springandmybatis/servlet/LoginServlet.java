package pers.zhentao.springandmybatis.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pers.zhentao.springandmybatis.service.ICustomerService;

public class LoginServlet extends HttpServlet {
	@Autowired
	private ICustomerService customerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter w = resp.getWriter();
		if(userName != null && !userName.equals("")){
			try{
				if(customerService.login(userName, password)){
					w.write("success");
					req.getSession().setAttribute("user", userName);
				}
				else
					w.write("fail");
			}catch(Exception e){
				e.printStackTrace();
				w.write("exception");
			}
		}else{
			w.write("fail");
		}
		w.flush();
		w.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
}
