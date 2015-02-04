package jdbc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jdbc.entity.Department;
import jdbc.service.IService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("dept")
@SessionAttributes(value={"editDept"})
public class DepartmentController {
	
	private final static Logger LOG = LoggerFactory
			.getLogger(DepartmentController.class);
	
	@Autowired
	private IService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAllDeptList(Model model) {
		List<Department> depts = service.getAllDepartments();
		model.addAttribute("depts", depts);
		return "dept/list";
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"departmentId"})
	public String getDepartmentDetail(@RequestParam int departmentId, Model model) {
		Department dept = service.getDepartment(departmentId);
		model.addAttribute("dept", dept);
		return "dept/detail";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String redirToEntryForm(@RequestParam int departmentId, Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Department dept = service.getDepartment(departmentId);
		model.addAttribute("editDept", dept);
		return "dept/enter";
	}
	
	@RequestMapping(value="/enter", method=RequestMethod.POST)
	public String verify(@ModelAttribute("editDept") Department dept) {
		return "redirect:/dept/review";
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public String showReview() {
		return "dept/review";
	}
	
	@RequestMapping(value="/review", params="_event_confirmed", method=RequestMethod.POST)
	public String update(@ModelAttribute("editDept") Department dept, HttpServletRequest request, HttpSession session) {
		service.updateDepartment(dept);
		return "redirect:/dept/edited";
	}
	
	@RequestMapping(value="/review", params="_event_reverse", method=RequestMethod.POST)
	public String reinput(@ModelAttribute("editDept") Department dept) {
		return "dept/enter";
	}
	
	@RequestMapping(value="/edited", method=RequestMethod.GET)
	public String showEdited(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "dept/edited";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String errorHandling() {
		return "error";
	}
}
