package jdbc.dao;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.entity.Department;
import jdbc.entity.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DepartmentDaojdbcImpl implements DepartmentDao {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate npjdbcTemplate;
	
	class DepartmentRowMapper implements RowMapper<Department> {
		@Override
		public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
			Department dept = new Department();
			dept.setDepartmentId(rs.getInt("department_id"));
			dept.setDepartmentName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
			return dept;
		}
	}
	
	private final static Logger LOG = LoggerFactory
			.getLogger(DepartmentDaojdbcImpl.class);
	
	@Override
	public Integer getDepartmentCount() {
		String sql = "select count(*) from departments";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
		LOG.trace("수업: getDepartmentCount " + result);
		return result;
	}

	@Override
	public Map<String, Object> getDepartmentByIdNoMapping(int departmentId) {
		String sql = "select * from departments where department_id=:departmentId";
		MapSqlParameterSource mapSource = new MapSqlParameterSource();
		mapSource.addValue("departmentId", departmentId);
		Map<String, Object> result = npjdbcTemplate.queryForMap(sql, mapSource);
		return result;

//		String sql = "select * from departments where department_id=?";
//		Map<String, Object> result = jdbcTemplate.queryForMap(sql, departmentId);
//		LOG.trace("수업: getDepartmentByIdNoMapping " + result);
//		return result;
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		String sql = "select * from departments where department_id=?";
		Department result = jdbcTemplate.queryForObject(sql, new DepartmentRowMapper(), departmentId);
		return result;
	}

	@Override
	public Integer getDepartmentCountByLocationId(int locationId) {
		String sql = "select count(*) from departments where location_id=?";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class, locationId);
		return result;
	}

	@Override
	public List<Map<String, Object>> getDepartmentsByLocationId(int locationId) {
		String sql = "select * from departments where location_id=?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, locationId);
		LOG.trace("수업: getDepartmentsByLocationId " + result);
		return result;
	}

	@Override
	public List<Department> getAllDepartments() {
		String sql = "select * from departments";
		List<Department> result = jdbcTemplate.query(sql, new DepartmentRowMapper());
		return result;
	}

	@Override
	public List<Department> getDepartmentsByManagerId(int managerId) {
		String sql = "select * from departments where manager_id=?";
		List<Department> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Department>(Department.class), managerId);
		return result;
	}

	@Override
	public void saveDepartments(OutputStream out) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department getDepartmentByIdWithEmployees(int departmentId) {
		String sql = "select * from departments join employees using (department_id) where department_id=?";
		LOG.trace("시작");
		
		Department dept = jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {
			@Override
			public Department extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Department dept = null;
				DepartmentRowMapper mapper = new DepartmentRowMapper();
				if(rs.next()) {
					dept = mapper.mapRow(rs, 1);
					ArrayList<Employee> list = new ArrayList<Employee>();
					do {
						Employee emp = new Employee();
						emp.setFirstName(rs.getString("first_name"));
						emp.setLastName(rs.getString("last_name"));
						list.add(emp);
					}while(rs.next());
					dept.setEmployees(list);
				}
				return dept;
			}
		}, departmentId);
		
		LOG.trace(dept.toString());
		
		return dept;
	}

	@Override
	public int insertDepartment(Department dept) {
		int result = 0;
		String sql = "insert into departments values(?, ?, ?, ?)";
		result = jdbcTemplate.update(sql, dept.getDepartmentId(), dept.getDepartmentName(),
				dept.getManagerId(), dept.getLocationId());
		return result;
	}

	@Override
	public int updateDepartment(Department dept) {
		int result = 0;
		String sql = "update departments set department_name=?, manager_id=?, location_id=? where department_id=?";
		result = jdbcTemplate.update(sql, dept.getDepartmentName(), dept.getManagerId(),
				dept.getLocationId(), dept.getDepartmentId());
		return result;
	}

	@Override
	public int deleteDepartment(int departmentId) {
		int result = 0;
		String sql = "delete from departments where department_id=?";
		result = jdbcTemplate.update(sql, departmentId);
		return result;
	}

}
