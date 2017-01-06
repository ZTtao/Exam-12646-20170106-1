package pers.zhentao.springandmybatis.dao;

import java.util.List;

import pers.zhentao.springandmybatis.pojo.City;

public interface CityMapper {
	List<City> selectCityByCountryId(Integer countryId);
	City selectByPrimaryKey(Integer cityId);
}