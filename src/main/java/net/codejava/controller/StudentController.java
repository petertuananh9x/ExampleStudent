package net.codejava.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.exception.ResourceNotFoundException;
import net.codejava.model.Student;
import net.codejava.service.student.StudentService;



@RestController
@RequestMapping("api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	 //lấy tất cả danh sách sinh viên và khoa
	@GetMapping("student/all")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> listStudent = studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(listStudent, HttpStatus.OK);
	}
	//tim kiếm theo tên
	@GetMapping("/student/{name}")
	public ResponseEntity<List<Student>> getStudentsByName(@PathVariable("name") String name) {
		return new ResponseEntity<List<Student>>(studentService.findStudentByKeyword(name), HttpStatus.OK);
	}
	
	@PostMapping("student/add")
	public ResponseEntity<?> addStudent(@RequestBody Student std){
		System.out.println(std.getKhoa());
		Student dataStd = studentService.addStudent(std);
		return new ResponseEntity<Student>(dataStd, HttpStatus.OK);
	}
	@PutMapping("student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student std){
		Student dataStd = studentService.getStudent(id);
		 if(dataStd == null) {
			 	return ResponseEntity.notFound().build();
		    }
		 else {
			dataStd.setName(std.getName());
			dataStd.setBirthday(std.getBirthday());
			dataStd.setGender(std.getGender());
			dataStd.setKhoa(std.getKhoa());
			studentService.updateStudent(dataStd);
			return new ResponseEntity<Student>(dataStd, HttpStatus.OK);
		}
	}
	
	
	
		
		
	
	
	

	
}
