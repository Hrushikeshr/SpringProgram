package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{

// Jdbc Template object
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
//data Insert Method
	public int insert(Student student) {
		 String query = "insert into student(id, name, city) values(?,?,?)";
		return this.jdbcTemplate.update(query, student.getId(), student.getName(),student.getCity());
	}
//data Updating method
	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		return this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
	}
//Data delete Method
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		return this.jdbcTemplate.update(query, studentId);
	}

	@Override
	public Student getStudent(int studentId) {
		String querry="select * from student where id=?";
		RowMapper<Student> rowMpper= new RowMapperImpl();
		return this.jdbcTemplate.queryForObject(querry, rowMpper, studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		String querry="select * from student";
		return this.jdbcTemplate.query(querry, new RowMapperImpl());
	}

}
