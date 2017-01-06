package pers.zhentao.springandmybatis.service;

import java.util.List;
import java.util.Map;

import pers.zhentao.springandmybatis.pojo.Customer;

public interface ICustomerService {
	boolean hasCustomer(String userName)throws Exception;
	boolean login(String userName,String password)throws Exception;
	Customer getCustomerInfo(String userName)throws Exception;
	boolean updateCustomerBasic(String firstNameOld,String firstName,String lastName,String email)throws Exception;
}
