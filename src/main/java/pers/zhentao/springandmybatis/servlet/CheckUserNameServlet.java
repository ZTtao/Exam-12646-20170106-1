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

public class CheckUserNameServlet extends HttpServlet {
	@Autowired
	private ICustomerService customerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		PrintWriter writer = resp.getWriter();
		try{
			if(customerService.hasCustomer(userName)){
				writer.write("true");
			}else{
				writer.write("false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		writer.flush();
		writer.close();
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
