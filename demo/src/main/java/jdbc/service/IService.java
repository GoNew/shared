package jdbc.service;

import java.util.List;
import java.util.Map;

import jdbc.entity.Department;

public interface IService {
	public Integer getDeptCnt();
	public  Map<String, Object> getDepartmentById(int departmentId);
	public List<Map<String, Object>> getDepartmentsByLocationId(int locationId);
	public Integer getDepartmentCountByLocationId(int locationId);
	public Department getDepartment(int departmentId);
	public List<Department> getAllDepartments();
	public List<Department> getDepartmentsByManagerId(int managerId);
	public Department getDepartmentByIdWithEmployees(int departmentId);
	
	public int insertDepartment(Department dept);
	public int updateDepartment(Department dept);
	public int deleteDepartment(int departmentId);
	
	public int transectionTest();
}
