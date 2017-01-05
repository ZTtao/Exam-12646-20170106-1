package pers.zhentao.springandmybatis.service;

import java.util.List;

import pers.zhentao.springandmybatis.pojo.Store;

public interface IStoreService {
	public List<Store> getAllStore()throws Exception;
}
