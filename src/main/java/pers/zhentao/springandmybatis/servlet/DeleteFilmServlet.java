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

import pers.zhentao.springandmybatis.service.IFilmService;
import pers.zhentao.springandmybatis.utils.MyStringUtil;

public class DeleteFilmServlet extends HttpServlet{
	@Autowired
	private IFilmService filmService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sIds = req.getParameter("ids");
		PrintWriter w = resp.getWriter();
		try {
			if(filmService.deleteFilmById(MyStringUtil.sIdsToList(sIds))){
				w.write("success");
			}else{
				w.write("faild");
			}
		} catch (Exception e) {
			e.printStackTrace();
			w.write(e.getMessage());
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
