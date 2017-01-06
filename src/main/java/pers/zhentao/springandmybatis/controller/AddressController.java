package pers.zhentao.springandmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pers.zhentao.springandmybatis.pojo.Address;
import pers.zhentao.springandmybatis.service.IAddressService;

@Controller
public class AddressController {
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping("/getCountry")
	@ResponseBody
	public String getCountry(){
		try{
			return (new JSONArray().fromObject(addressService.getCountry())).toString();
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
	}
	
	@RequestMapping("/getCity")
	@ResponseBody
	public String getCity(@RequestParam(value="countryId",required=true)Integer countryId){
		try{
			return new JSONArray().fromObject(addressService.getCityByCountryId(countryId)).toString();
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
	}
	
	@RequestMapping("/changeAddress")
	@ResponseBody
	public String changeAddress(Address address){
		try{
			if(addressService.updateAddress(address))
				return "success";
			else
				return "faild";
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
	}
}
