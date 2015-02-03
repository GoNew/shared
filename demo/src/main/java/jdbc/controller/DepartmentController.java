package jdbc.controller;

import java.util.List;

import jdbc.entity.Department;
import jdbc.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {
	
	@Autowired
	private IService service;
	
	@RequestMapping(value="dept/list", method=RequestMethod.GET)
	public String getAllDeptList(Model model) {
		List<Department> depts = service.getAllDepartments();
		model.addAttribute("depts", depts);
		return "dept/list";
	}
}
