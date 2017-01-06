package pers.zhentao.springandmybatis.service;

import java.util.List;

import pers.zhentao.springandmybatis.pojo.Film;
import pers.zhentao.springandmybatis.pojo.Language;

public interface IFilmService {
	List<Film> getFilmByOrderbyLimit(String orderByClause,int offset,int limit,String search)throws Exception;
	int getFilmCount(String search)throws Exception;
	boolean deleteFilmById(List<Integer> idList)throws Exception;
	List<Language> getAllLanguage()throws Exception;
	boolean updateOrInsertFilm(Film film)throws Exception;
}
