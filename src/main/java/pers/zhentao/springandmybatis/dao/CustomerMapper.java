package pers.zhentao.springandmybatis.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import pers.zhentao.springandmybatis.pojo.Customer;

public interface CustomerMapper {
	int countOfCustomer(String userName);
	Customer selectByUserName(String userName);
	int updateByOldFirstName(@Param("userName")String userName,@Param("firstName")String firstName,@Param("lastName")String lastName,@Param("email")String email,@Param("lastUpdate")Date lastUpdate);
}