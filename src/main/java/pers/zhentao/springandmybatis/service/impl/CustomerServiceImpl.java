package pers.zhentao.springandmybatis.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.zhentao.springandmybatis.dao.AddressMapper;
import pers.zhentao.springandmybatis.dao.CityMapper;
import pers.zhentao.springandmybatis.dao.CountryMapper;
import pers.zhentao.springandmybatis.dao.CustomerMapper;
import pers.zhentao.springandmybatis.pojo.Address;
import pers.zhentao.springandmybatis.pojo.City;
import pers.zhentao.springandmybatis.pojo.Country;
import pers.zhentao.springandmybatis.pojo.Customer;
import pers.zhentao.springandmybatis.pojo.CustomerExample;
import pers.zhentao.springandmybatis.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private CityMapper cityMapper;
	
	@Autowired
	private CountryMapper countryMapper;
	
	@Override
	public boolean hasCustomer(String userName) throws Exception{
		try{
			CustomerExample example = new CustomerExample();
			example.or().andFirstNameEqualTo(userName);
			List<Customer> list = customerMapper.selectByExample(example);
			if(list != null && list.size() > 0 )return true;
			else return false;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public boolean login(String userName, String password) throws Exception {
		try{
			CustomerExample example = new CustomerExample();
			example.or().andFirstNameEqualTo(userName);
			List<Customer> list = customerMapper.selectByExample(example);
			if(list != null && list.size() > 0 )return true;
			else return false;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public Map<String,Object> getCustomerInfo(String userName) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		Customer cus = null;
		Address addr = null;
		City city = null;
		Country country = null;
		try{
			CustomerExample example = new CustomerExample();
			example.or().andFirstNameEqualTo(userName);
			List<Customer> list = customerMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				cus = list.get(0);
				addr = addressMapper.selectByPrimaryKey(cus.getAddressId());
				if(addr != null){
					city = cityMapper.selectByPrimaryKey(addr.getCityId());
					if(city != null){
						country = countryMapper.selectByPrimaryKey(city.getCountryId());
					}
				}
			}
			map.put("customer", cus);
			map.put("address", addr);
			map.put("city", city);
			map.put("country", country);
			return map;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public boolean updateCustomerBasic(String firstNameOld,String firstName, String lastName, String email)throws Exception {
		try{
			CustomerExample example = new CustomerExample();
			example.or().andFirstNameEqualTo(firstNameOld);
			List<Customer> list = customerMapper.selectByExample(example);
			if(list != null && list.size() > 0){
				list.get(0).setFirstName(firstName);
				list.get(0).setLastName(lastName);
				list.get(0).setEmail(email);
				list.get(0).setLastUpdate(new Date());
				int count = customerMapper.updateByPrimaryKey(list.get(0));
				if(count > 0)return true;
				else return false;
			}else return false;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public List<Customer> getCustomerByOrderbyLimit(String orderByClause, int offset, int limit, String search)
			throws Exception {
		try{
			return customerMapper.selectByOrderByLimit(orderByClause, offset, limit,search);
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public int getCustomerCount(String search) throws Exception {
		try{
			return customerMapper.selectByOrderByLimit(null, 0, 0, search).size();
		}catch(Exception e){
			throw e;
		}
	}
}
