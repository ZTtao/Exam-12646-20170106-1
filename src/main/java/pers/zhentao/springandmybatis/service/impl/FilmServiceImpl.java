package pers.zhentao.springandmybatis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.zhentao.springandmybatis.dao.FilmMapper;
import pers.zhentao.springandmybatis.dao.LanguageMapper;
import pers.zhentao.springandmybatis.pojo.Film;
import pers.zhentao.springandmybatis.pojo.Language;
import pers.zhentao.springandmybatis.service.IFilmService;

@Service
public class FilmServiceImpl implements IFilmService {

	@Autowired
	private FilmMapper filmMapper;
	
	@Autowired
	private LanguageMapper languageMapper;
	
	@Override
	public List<Film> getFilmByOrderbyLimit(String orderByClause,int offset, int limit,String search)throws Exception {
		try{
			return filmMapper.selectByOrderByLimit(orderByClause, offset, limit,search);
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public int getFilmCount(String search)throws Exception {
		try{
			return filmMapper.selectByOrderByLimit(null, 0, 0, search).size();
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public boolean deleteFilmById(List<Integer> idList)throws Exception {
		try{
			if(idList != null && idList.size()>0){
				int count = filmMapper.deleteByIdList(idList);
				if(count == idList.size())return true;
				else return false;
			}
			return true;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public List<Language> getAllLanguage() throws Exception {
		try{
			return languageMapper.selectAll();
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public boolean updateOrInsertFilm(Film film) throws Exception {
		try{
			int count = 0;
			if(film.getFilmId() == 0){
				count = filmMapper.insertSelective(film);
			}else{
				count = filmMapper.updateByPrimaryKeySelective(film);
			}
			if(count > 0)return true;
			else return false;
		}catch(Exception e){
			throw e;
		}
	}

}
