package pers.zhentao.springandmybatis.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.zhentao.springandmybatis.dao.AddressMapper;
import pers.zhentao.springandmybatis.dao.CityMapper;
import pers.zhentao.springandmybatis.dao.CountryMapper;
import pers.zhentao.springandmybatis.pojo.Address;
import pers.zhentao.springandmybatis.pojo.City;
import pers.zhentao.springandmybatis.pojo.Country;
import pers.zhentao.springandmybatis.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private CountryMapper countryMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public List<Country> getCountry() throws Exception {
		try{
			return countryMapper.selectAllCountry();
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public List<City> getCityByCountryId(int countryId) throws Exception {
		try{
			return cityMapper.selectCityByCountryId(countryId);
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public boolean updateAddress(Address address) throws Exception {
		try{
			address.setLastUpdate(new Date());
			int count = addressMapper.updateByPrimaryKeySelective(address);
			if(count > 0)return true;
			else return false;
		}catch(Exception e){
			throw e;
		}
	}

}
