
  package com.jesse.bookclub.models;
  
  import javax.persistence.Entity; import javax.persistence.FetchType; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.JoinColumn; import
  javax.persistence.ManyToOne; import javax.persistence.Table; import
  javax.validation.constraints.NotEmpty;
  
  @Entity
  
  @Table(name="books") public class Book { // MEMBER VARIABLES
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  
  @NotEmpty(message="Title must not be blank") private String title;
  
  @NotEmpty(message="Thoughts must not be blank") private String thought;
  
  @NotEmpty(message="Author must not be blank") private String author;
  
  // RELATIONSHIPS
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="user_id")
  private User creator;
  
  
  
  
  // CONSTRUCTORS
  
  public Book() {
  
  } public Book (String title, String thought, String userName, String author,
  User creator) { 
	  this.title = title;
	  this.thought = thought;
	  this.creator =creator; 
	  this.author = author; }
  
  
  ///Getters & Setters///
  public Long getId() { return id; } public void
  setId(Long id) { this.id = id; } public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; } public String
  getThought() { return thought; } public void setThought(String thought) {
  this.thought = thought; } public String getAuthor() { return author; } public
  void setAuthor(String author) { this.author = author; } public User
  getCreator() { return creator; } public void setCreator(User creator) {
  this.creator = creator; }
  
  
  
  }
 