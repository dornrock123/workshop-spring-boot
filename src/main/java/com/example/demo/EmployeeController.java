package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.trainTable;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<trainTable> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	
	
	@PostMapping("/employeesInsert")
	public String insertEmployee(@RequestBody trainTable train) {
	    String sql = "INSERT INTO train_table (stucd, stunname, stufname, stulname) VALUES (?, ?, ?, ?)";
	    jdbcTemplate.update(sql, train.code, train.name, train.fname, train.lname);
	    return "Employee inserted successfully";
	}
	

	@GetMapping("/employeesSearch")
	public List<trainTable> getAllStudents() {
	    List<trainTable> result = jdbcTemplate.query("SELECT * FROM train_table",
	            (rs, rowNum) -> {
	            	trainTable train = new trainTable();
	                train.setId(rs.getInt("stuid"));
	                train.setCode(rs.getString("stucd"));
	                train.setName(rs.getString("stunname"));
	                train.setFname(rs.getString("stufname"));
	                train.setLname(rs.getString("stulname"));
	                return train;
	            }
	    );
	    return result;
	}
	
	@GetMapping("/employeesDelete")
	public void deleteById() {
		employeeRepository.deleteById((int)23);
	}
	
	@GetMapping("/employeesExec")
	public List<trainTable> getAllStudent(){
		List<trainTable> result = jdbcTemplate.query("EXEC dbo.test 'NEW'",
				(rs, rowNum) -> {
					trainTable train = new trainTable();
					train.setId(rs.getInt("stuid"));
					train.setCode(rs.getString("stucd"));
					train.setName(rs.getString("stunname"));
					train.setFname(rs.getString("stufname"));
					train.setLname(rs.getString("stulname"));
					return train;
				});
		return result;
	}
		
}
