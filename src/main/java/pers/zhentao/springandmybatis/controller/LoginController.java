package pers.zhentao.springandmybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import pers.zhentao.springandmybatis.service.ICustomerService;

@Controller
public class LoginController {
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/toLogin")
	@ResponseBody
	public String login(@RequestParam(value="username",required=true)String userName,@RequestParam(value="password",required=false)String password,HttpServletRequest req){
		if(userName != null && !userName.equals("")){
			try{
				if(customerService.login(userName, password)){
					req.getSession().setAttribute("user", userName);
					return "success";
				}
				else
					return "fail";
			}catch(Exception e){
				e.printStackTrace();
				return "exception";
			}
		}else{
			return "fail";
		}
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.getSession().removeAttribute("user");
		resp.sendRedirect("login.html");
	}
	
	@RequestMapping("/isLogin")
	@ResponseBody
	public String isLogin(HttpServletRequest request){
		Object user = request.getSession().getAttribute("user");
		Map<String,String> map = new HashMap<String,String>();
		if(user == null){
			map.put("result", "false");
			map.put("userName", "");
		}else {
			map.put("result", "true");
			map.put("userName", (String)user);
		}
		return new JSONObject().fromObject(map).toString();
	}
}
