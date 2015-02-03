package simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import simple.service.DeptService;

@Controller
public class HelloController {
	@Autowired
	DeptService service;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("message", "hello MVC" + service.serviceMessage());
		return "showMessage";
	}
	
	@RequestMapping("/args")
	public String argTest(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("message", req.getServletPath());
		return "showMessage";
	}
	
	@RequestMapping("/minus")
	public String add(Model model, @RequestParam int a, @RequestParam(required=false) Integer b) {
		String key = "message";
		int realB = b == null ? 0 : b;
		String message = "" + (a - realB);
		model.addAttribute(key, message);
		return "showMessage";
	}
	
	@RequestMapping("/info/{id}")
	public String showDepartmentInfo(Model model, @PathVariable("id") String departmentId) {
		String key = "message";
		String message = departmentId;
		model.addAttribute(key, message);
		return "showMessage";
	}
}
