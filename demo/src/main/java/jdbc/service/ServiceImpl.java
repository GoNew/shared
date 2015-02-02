package jdbc.service;

import java.util.List;
import java.util.Map;

import jdbc.dao.DepartmentDao;
import jdbc.entity.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceImpl implements IService {
	@Autowired
	DepartmentDao dao;

	@Override
	public Integer getDeptCnt() {
		Integer result = dao.getDepartmentCount();
		return result;
	}
	
	public  Map<String, Object> getDepartmentById(int departmentId) {
		Map<String, Object> result = dao.getDepartmentByIdNoMapping(departmentId);
		return result;
	}
	
	public List<Map<String, Object>> getDepartmentsByLocationId(int locationId) {
		List<Map<String, Object>> result = dao.getDepartmentsByLocationId(locationId);
		return result;
	}

	@Override
	public Integer getDepartmentCountByLocationId(int locationId) {
		Integer result = dao.getDepartmentCountByLocationId(locationId);
		return result;
	}

	@Override
	public Department getDepartment(int departmentId) {
		Department result = dao.getDepartmentById(departmentId);
		return result;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> result = dao.getAllDepartments();
		return result;
	}

	@Override
	public List<Department> getDepartmentsByManagerId(int managerId) {
		List<Department> result = dao.getDepartmentsByManagerId(managerId);
		return result;
	}

	@Override
	public Department getDepartmentByIdWithEmployees(int departmentId) {
		Department result = dao.getDepartmentByIdWithEmployees(departmentId);
		return result;
	}

	@Override
	public int insertDepartment(Department dept) {
		int result = dao.insertDepartment(dept);
		return result;
	}

	@Override
	public int updateDepartment(Department dept) {
		int result = dao.updateDepartment(dept);
		return result;
	}

	@Override
	public int deleteDepartment(int departmentId) {
		int result = dao.deleteDepartment(departmentId);
		return result;
	}

	@Override
	@Transactional()
	public int transectionTest() {
		insertDepartment(new Department(1239, "으하하하핳", 0, 0));
		return 0;
	}
	
}
