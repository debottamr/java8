package clone;

public class Test { 
	  
    public static void main(String args[]) 
    { 
  
        try { 
            Employee ob1 = new Employee("Tom", 201); 
  
            // Creating a new reference variable ob2 
            // which is pointing to the same address as ob1 
            Employee ob2 = (Employee)ob1.clone(); 
  
            System.out.println(ob1.emp_id + ", " + ob1.emp_name); 
            System.out.println(ob2.emp_id + ", " + ob2.emp_name); 
        } 
        catch (CloneNotSupportedException c) { 
            System.out.println("Exception: " + c); 
        } 
    } 
} 