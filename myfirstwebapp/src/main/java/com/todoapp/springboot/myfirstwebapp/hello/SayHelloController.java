package com.todoapp.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hi")
	@ResponseBody
	public String sayHello()
	{
		return "Hello!Goizzzz...Wassupp??.Yeah!YEAH!";
	}
	
	@RequestMapping("say-hi-html")
	@ResponseBody
	public String sayHelloHtml()
	{
		
		StringBuffer obj = new StringBuffer();
		
		obj.append("<html>");
		obj.append("<title> Hello Guysss!! </title>");
		obj.append("<head> Hello! What are you studying today?");
		obj.append("</html>");
		
		return obj.toString();
	}
	
	@RequestMapping("say-hi-jsp")
	public String sayHellojsp()
	{
		return "sayHi";
	}
}
