package net.codejava.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import net.codejava.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	 @Query(value = "SELECT * FROM student WHERE khoa_id = :k_id", nativeQuery = true)
		List<Student> getStudentKhoa(@Param("k_id") long khoa_id);
	 
	 @Query(value="select * from student s where s.name like %:keyword% ", nativeQuery=true)
	 List<Student> findStudentByKeyword(@Param("keyword") String keyword);
	
   
}
