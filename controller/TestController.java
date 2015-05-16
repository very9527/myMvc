package myMvc.controller;

import myMvc.base.RequestMapping;

public class TestController {
	
	@RequestMapping("/getArticleById")
	public String getArticleById() {
		System.out.println("我的第一个小框架撸成功了");
		return "";
	}
}
