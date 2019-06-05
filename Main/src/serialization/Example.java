package serialization;

//Base class 
class Example implements java.io.Serializable { 


//private static final long serialVersionUID = 3163629259976998298L;


public int emp_id; 
 public String emp_name; 

 // Default constructor 
 public Example(int emp_id, String emp_name) 
 { 
     this.emp_id = emp_id; 
     this.emp_name = emp_name; 
 }


 
 
} 
