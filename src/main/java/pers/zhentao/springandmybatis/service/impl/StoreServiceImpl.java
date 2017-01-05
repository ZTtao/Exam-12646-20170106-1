package pers.zhentao.springandmybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.zhentao.springandmybatis.dao.StoreMapper;
import pers.zhentao.springandmybatis.pojo.Store;
import pers.zhentao.springandmybatis.service.IStoreService;

@Service
public class StoreServiceImpl implements IStoreService{
	
	@Autowired
	private StoreMapper storeMapper;

	@Override
	public List<Store> getAllStore() throws Exception {
		try{
			return storeMapper.selectAllStore();
		}catch(Exception e){
			throw e;
		}
	}

}
