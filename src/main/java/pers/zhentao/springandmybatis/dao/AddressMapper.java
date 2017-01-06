package pers.zhentao.springandmybatis.dao;

import pers.zhentao.springandmybatis.pojo.Address;

public interface AddressMapper {
	int updateByPrimaryKeySelective(Address record);
	Address selectByPrimaryKey(Integer addressId);
}