package pers.zhentao.springandmybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.zhentao.springandmybatis.pojo.Film;

public interface FilmMapper {
	
	int deleteByIdList(List<Integer> list);
	/**
     * 分页方法
     */
    List<Film> selectByOrderByLimit(@Param("orderByClause")String orderByClause,@Param("offset")int offset,@Param("limit")int limit,@Param("search")String search);
    int insertSelective(Film record);
    int updateByPrimaryKeySelective(Film record);
}