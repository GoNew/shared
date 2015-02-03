package jdbc.dao;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import jdbc.entity.Department;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentDaoMybatisImpl implements DepartmentDao{
	@Autowired
	private SqlSession sqlSession;
	
	private String namespace = "com.mybatis.mapper.department";
	
	private final static Logger LOG = LoggerFactory
			.getLogger(DepartmentDaoMybatisImpl.class);
	
	@Override
	public Integer getDepartmentCount() {
		String stmt = namespace + ".selectDepartmentCount";
		Integer result = sqlSession.selectOne(stmt);
		return result;
	}

	@Override
	public Map<String, Object> getDepartmentByIdNoMapping(int departmentId) {
		String stmt = namespace + ".selectDepartmentMapById";
		Map<String, Object> result = sqlSession.selectOne(stmt, departmentId);
		return result;
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		String stmt = namespace + ".selectDepartmentById";
		Department result = sqlSession.selectOne(stmt, departmentId);
		return result;
	}

	@Override
	public Integer getDepartmentCountByLocationId(int locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getDepartmentsByLocationId(int locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAllDepartments() {
		String stmt = namespace + ".selectAllDepartments";
		List<Department> result = sqlSession.selectList(stmt);
		return result;
	}

	@Override
	public List<Department> getDepartmentsByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDepartments(OutputStream out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department getDepartmentByIdWithEmployees(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertDepartment(Department dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDepartment(int departmentId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
