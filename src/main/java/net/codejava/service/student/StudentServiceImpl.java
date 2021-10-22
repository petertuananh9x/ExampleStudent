package net.codejava.service.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Khoa;
import net.codejava.model.Student;
import net.codejava.repositories.KhoaRepository;
import net.codejava.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private KhoaRepository khoaRepository;
	
	@Override
	public List<Student> getAllStudent() {
		List<Student> listStudent = studentRepository.findAll();
		return listStudent;
	}
	@Override
	public Student getStudent(long id) {
		Student student = studentRepository.getOne(id);
		return student;
	}

	@Override
	public List<Student> findStudentByKeyword(String keyword ) {
        if (keyword != null) {
            return studentRepository.findStudentByKeyword(keyword);
        }
        return studentRepository.findAll();
    }

	@Override
	public Student addStudent(Student student) {
		Optional<Khoa> khoa = khoaRepository.findById(student.getKhoa().getId());
		student.setKhoa(khoa.get());
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Khoa> khoa = khoaRepository.findById(student.getKhoa().getId());
		student.setKhoa(khoa.get());
		student = studentRepository.save(student);
		return student;
	}

	@Override
	public boolean delStudent(long id) {
		Student student = studentRepository.getOne(id);
		if (student != null) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}
    
    @Override
	public List<Student> getStudentOfKhoa(long khoa_id) {
		List<Student> listStd = studentRepository.getStudentKhoa(khoa_id);
		return listStd;
	}
}
