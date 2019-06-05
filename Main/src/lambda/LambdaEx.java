package lambda;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class LambdaEx {

	LambdaEx(i1 i){
		
	}
	LambdaEx(i2 i){
		
	}
	LambdaEx(i1 i, i2 iz){
		
	}
	LambdaEx(i2 i, i1 iz){
		
	}
	public static void main(String[] args) {


		//LambdaEx ex = new LambdaEx(()-> System.out.println("1"), ()-> System.out.println("2"));
		
		IntConsumer myIntConsumer = (value) -> System.out.println(value);

		LongConsumer myLongConsumer = (value) -> System.out.println(value);

		DoubleConsumer myDoubleConsumer = (value) -> System.out.println(value);

		Consumer<String> myStringConsumer = (value) -> System.out.println(value);
	}
}


interface i1{
	void test();
}

interface i2{
	void test2();
}