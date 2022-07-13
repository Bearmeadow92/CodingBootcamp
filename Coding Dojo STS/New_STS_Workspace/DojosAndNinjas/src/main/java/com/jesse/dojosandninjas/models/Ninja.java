package com.jesse.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	// ------------------ MEMBER VARIABLES ---------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	// Ninja First Name
    @NotNull
    @Size(min=3, max=255)
    private String firstName;
    //Ninja Last Name
    @NotNull
    @Size(min=3, max=255)
    private String lastName;
    //Ninja Age
    @NotNull
    @Min(13)
    private Integer age;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;


	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    // RELATIONSHIPS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojolocation;
    
    
 
	// ------------------ MEMBER VARIABLES ---------------------//
    // EMPTY CONSTRUCTOR
    public Ninja() {
    	
    }
    // FULL CONSTRUCTOR
    
    
	public Ninja(@NotNull @Size(min = 2, max = 200) String firstName,
			@NotNull @Size(min = 2, max = 200) String lastName, @NotNull @Positive int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
    
    //FULL CONSTRUCTOR
    
    
    
 


	
	
	
	//getters & setters//
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Dojo getDojolocation() {
		return dojolocation;
	}


	public void setDojolocation(Dojo dojolocation) {
		this.dojolocation = dojolocation;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

		

}