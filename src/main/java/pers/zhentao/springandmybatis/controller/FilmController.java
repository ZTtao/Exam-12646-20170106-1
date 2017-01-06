package pers.zhentao.springandmybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pers.zhentao.springandmybatis.pojo.Film;
import pers.zhentao.springandmybatis.pojo.Language;
import pers.zhentao.springandmybatis.service.IFilmService;
import pers.zhentao.springandmybatis.utils.MyStringUtil;

@Controller
public class FilmController {

	@Autowired
	private IFilmService filmService;
	
	@RequestMapping("/deleteFilm")
	@ResponseBody
	public String deleteFilm(@RequestParam(value="ids",required=false)String sIds){
		try {
			if(filmService.deleteFilmById(MyStringUtil.sIdsToList(sIds))){
				return "success";
			}else{
				return "faild";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping("/getLanguage")
	@ResponseBody
	public String getLanguage(){
		try{
			List<Language> lan = filmService.getAllLanguage();
			String str = JSONArray.fromObject(lan).toString();
			System.out.println();
			return JSONArray.fromObject(lan).toString();
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping("/showFilms")
	@ResponseBody
	public String showFilms(@RequestParam(value="offset",required=false)String sOffset,@RequestParam(value="limit",required=false)String sLimit,
			@RequestParam(value="sort",required=false)String orderBy,@RequestParam(value="order",required=false)String order,@RequestParam(value="search",required=false)String search){
		List<Film> list = new ArrayList<Film>();
		int count = 0;
		try{
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
		JSONObject obj = JSONObject.fromObject(map);
		return obj.toString();
	}
	
	@RequestMapping("/updateFilm")
	@ResponseBody
	public String updateFilm(@RequestParam(value="filmId",required=true)String filmId,@RequestParam(value="title",required=true)String title,
			@RequestParam(value="description",required=false)String description,@RequestParam(value="languageId",required=true)String sLanguageId){
		try{
			Film film = new Film();
			film.setFilmId(Integer.valueOf(filmId));
			film.setTitle(title);
			film.setDescription(description);
			Language language = new Language();
			language.setLanguageId(Integer.parseInt(sLanguageId));
			film.setLanguage(language);
			if(filmService.updateOrInsertFilm(film)){
				return "success";
			}else{
				return "faild";
			}
		}catch(Exception e){
			return "出现异常";
		}
	}
}
