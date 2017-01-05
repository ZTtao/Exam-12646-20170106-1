package pers.zhentao.springandmybatis.service;

import java.util.List;

import pers.zhentao.springandmybatis.pojo.Address;
import pers.zhentao.springandmybatis.pojo.City;
import pers.zhentao.springandmybatis.pojo.Country;

public interface IAddressService {
	List<Country> getCountry()throws Exception;
	List<City> getCityByCountryId(int countryId)throws Exception;
	boolean updateAddress(Address address)throws Exception;
}
