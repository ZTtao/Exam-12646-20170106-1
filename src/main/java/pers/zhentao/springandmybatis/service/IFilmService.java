package pers.zhentao.springandmybatis.service;

import java.util.List;
import java.util.Map;

import pers.zhentao.springandmybatis.pojo.Film;
import pers.zhentao.springandmybatis.pojo.FilmResult;

public interface IFilmService {
	List<FilmResult> getFilmByOrderbyLimit(String orderByClause,int offset,int limit,String search)throws Exception;
	int getFilmCount(String search)throws Exception;
	boolean deleteFilmById(List<Integer> idList)throws Exception;
	Map<String,String> getAllLanguage()throws Exception;
	boolean updateOrInsertFilm(Film film)throws Exception;
}
