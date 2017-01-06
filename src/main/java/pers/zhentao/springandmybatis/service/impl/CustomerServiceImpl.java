package pers.zhentao.springandmybatis.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.zhentao.springandmybatis.dao.CustomerMapper;
import pers.zhentao.springandmybatis.pojo.Customer;
import pers.zhentao.springandmybatis.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	
	@Override
	public boolean hasCustomer(String userName) throws Exception{
		try{
			int count = customerMapper.countOfCustomer(userName);
			if(count > 0 )return true;
			else return false;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public boolean login(String userName, String password) throws Exception {
		try{
			int count = customerMapper.countOfCustomer(userName);
			if(count > 0 )return true;
			else return false;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public Customer getCustomerInfo(String userName) throws Exception {
		Customer cus = null;
		try{
			cus = customerMapper.selectByUserName(userName);
			return cus;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public boolean updateCustomerBasic(String firstNameOld,String firstName, String lastName, String email)throws Exception {
		try{
				int count = customerMapper.updateByOldFirstName(firstNameOld,firstName,lastName,email,new Date());
				if(count > 0)return true;
				else return false;
		}catch(Exception e){
			throw e;
		}
	}
}
