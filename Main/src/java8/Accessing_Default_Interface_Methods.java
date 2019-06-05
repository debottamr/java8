package java8;



/*
 Default methods cannot be accessed from within lambda expressions. The following code does not compile:


 */
public class Accessing_Default_Interface_Methods {

	public static void main(String[] args) {
		//For the above reason the next line doesn't compile
		//Formula1 formula = (a) -> sqrt( a * 100);
	}
}


interface Formula1 {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
