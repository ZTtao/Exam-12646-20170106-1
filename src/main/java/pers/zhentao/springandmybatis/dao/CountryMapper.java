package pers.zhentao.springandmybatis.dao;

import java.util.List;

import pers.zhentao.springandmybatis.pojo.Country;

public interface CountryMapper {
	List<Country> selectAllCountry();
	Country selectByPrimaryKey(Integer country);
}