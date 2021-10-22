package net.codejava.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "khoa")
public class Khoa {
	@Id
    
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;
    
    @OneToMany(mappedBy="khoa")
	private Set<Student> listSV = new HashSet<>();
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


	

   
	    

}
