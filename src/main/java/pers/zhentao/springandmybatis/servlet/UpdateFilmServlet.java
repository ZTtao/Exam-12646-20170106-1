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

import pers.zhentao.springandmybatis.pojo.Film;
import pers.zhentao.springandmybatis.service.IFilmService;

public class UpdateFilmServlet extends HttpServlet{
	@Autowired
	private IFilmService filmService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter w = resp.getWriter();
		try{
			String filmId = req.getParameter("filmId");
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String sLanguageId = req.getParameter("languageId");
			Film film = new Film();
			film.setFilmId(Short.valueOf(filmId));
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguageId(Byte.parseByte(sLanguageId));
			if(filmService.updateOrInsertFilm(film)){
				w.write("success");
			}else{
				w.write("faild");
			}
		}catch(Exception e){
			w.write("出现异常");
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
