package com.example.mybatis.demomybatis.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class IndexController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, @RequestParam("name") String name){
		log.info("This is index, value is:{},reuqest URI is:{}",name,request.getRequestURI());
		return  String.format("This is index value is %s, request URI is %s",name,request.getRequestURI());
	}
}
