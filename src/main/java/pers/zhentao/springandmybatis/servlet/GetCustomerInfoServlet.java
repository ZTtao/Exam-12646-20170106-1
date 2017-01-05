package pers.zhentao.springandmybatis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.alibaba.fastjson.JSON;

import pers.zhentao.springandmybatis.service.ICustomerService;

public class GetCustomerInfoServlet extends HttpServlet{
	@Autowired
	private ICustomerService customerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = (String)req.getSession().getAttribute("user");
		PrintWriter w = resp.getWriter();
		try{
			Map<String,Object> result = customerService.getCustomerInfo(firstName);
			if(result.get("customer") == null)
				w.write("null");
			else
				w.write(JSON.toJSONString(result));
		}catch(Exception e){
			e.printStackTrace();
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
