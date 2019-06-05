package java8;

public class Lambda_Scopes {

	public static void main(String[] args) {
		final int num = 1;
		Converter3<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);

		stringConverter.convert(2);     // 3

		
		
		int num1 = 1;
		Converter3<Integer, String> stringConverter1 =
		        (from) -> String.valueOf(from + num1);

		stringConverter1.convert(2);     // 
		
		//Will not compile either its final or effectively final means num2 should not be changed after initialization
//		int num2 = 1;
//		
//		Converter3<Integer, String> stringConverter2 =
//		        (from) -> String.valueOf(from + num2);
//		num2 = 3;

	}
}

class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}

@FunctionalInterface
interface Converter3<F, T> {
	T convert(F from);
}