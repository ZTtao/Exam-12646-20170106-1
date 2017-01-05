package pers.zhentao.springandmybatis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.alibaba.fastjson.JSON;

import pers.zhentao.springandmybatis.pojo.FilmResult;
import pers.zhentao.springandmybatis.service.IFilmService;
import pers.zhentao.springandmybatis.utils.MyStringUtil;

public class ShowFilmServlet extends HttpServlet {
	@Autowired
	private IFilmService filmService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter w = resp.getWriter();
		List<FilmResult> list = new ArrayList<FilmResult>();
		int count = 0;
		try{
			String sOffset = req.getParameter("offset");
			String sLimit = req.getParameter("limit");
			String orderBy = req.getParameter("sort");
			String order = req.getParameter("order");
			String search = req.getParameter("search");
			if(orderBy != null){
				orderBy = MyStringUtil.camelToUnderLine(orderBy);
				orderBy=orderBy+" "+order;
			}
			if(sOffset == null)sOffset = "0";
			if(sLimit == null)sLimit = "10";
			int offset = Integer.parseInt(sOffset);
			int limit = Integer.parseInt(sLimit);
			list = filmService.getFilmByOrderbyLimit(orderBy, offset, limit,search);
			count = filmService.getFilmCount(search);
		}catch(Exception e){
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		w.write(JSON.toJSONString(map));
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
