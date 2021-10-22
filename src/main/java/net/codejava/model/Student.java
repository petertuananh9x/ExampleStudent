package net.codejava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





@Entity
@Table(name = "student")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
    private Long id;

	@NotNull
    @Size(max = 255)
    @Column(unique = true)
    private String name;
	
	@NotNull
    @Size(max = 255)
    @Column(unique = true)
    private String birthday;
	
	@NotNull
    @Column(unique = true)
    private int gender;
	
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "khoa_id")
	private Khoa khoa;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public Khoa getKhoa() {
		return khoa;
	}


	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	
	

}
