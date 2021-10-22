package net.codejava.service.student;

import java.util.List;
import net.codejava.model.Student;



public interface StudentService {
    //Get all students
	public List<Student> getAllStudent();
	//Get student by id
	public Student  getStudent(long id);
    //Get student by name
	public List<Student> findStudentByKeyword(String keyword);
    //Create new student
	public Student addStudent(Student student);
	//Update student
	public Student updateStudent(Student student);
    //Delete student
	public boolean delStudent(long id);
    //Get list student of Khoa
	public List<Student> getStudentOfKhoa(long khoa_id);
}
