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

public class ChangeBasicInfoServlet extends HttpServlet {
	@Autowired
	private ICustomerService customerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstNameOld = (String)req.getSession().getAttribute("user");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		PrintWriter w = resp.getWriter();
		try{
			if(!firstName.equals(firstNameOld) && customerService.hasCustomer(firstName)){
				w.write("firstNameExist");
			}else if(customerService.updateCustomerBasic(firstNameOld, firstName, lastName, email)){
				if(firstName.equals(firstNameOld)){
					w.write("success");
				}else{
					w.write("success1");
					req.getSession().removeAttribute("user");
				}
			}
		}catch(Exception e){
			w.write("exception");
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
