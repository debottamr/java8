import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.MethodUtils;




public class Main {

	
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String[] arr= {"a"};
		Object obj = (java.lang.Object)arr;
		Object params [] = {null,obj}; 
		
		
		Main m = new Main();
		
		
        final Class<?>[] parameterTypes = ClassUtils.toClass(params);

		Method accessibleMethod = MethodUtils.getMatchingAccessibleMethod(m.getClass(), "test", parameterTypes);
		if(accessibleMethod == null){
			System.out.println("1");
			MethodUtils.invokeMethod(m, true ,"test", params);
		}else{
			System.out.println("2");
			MethodUtils.invokeMethod(m, false ,"test", params);
		}
			
		
		/*Object params1 [] = {null};
		
		final Class<?>[] parameterTypes1 = ClassUtils.toClass(params1);
		
		Method accessibleMethod1 = MethodUtils.getMatchingAccessibleMethod(m.getClass(), "test1", parameterTypes1);
		//Method accessibleMethod1 = MethodUtils.getMatchingAccessibleMethod(m.getClass(), "test1", parameterTypes1);
		if(accessibleMethod1 == null){
			MethodUtils.invokeMethod(m, true ,"test1", params1);
			System.out.println("3");
		}else{
			System.out.println("4");
			MethodUtils.invokeMethod(m, false ,"test1", params1);
		}*/

		

	}
	public void test(List<String> a,String... b){
		System.out.println("list");
	}
	
	public void test(int a, String... b){
		System.out.println("arraylist");
	}
	
	public void test1(List<String> a){
		System.out.println("list");
	}
	
	public void test1(Integer a){
		System.out.println("arraylist");
	}
	
	public static void invoke(){
		
		
	}
	
	/*
	public void test(Integer i){
		System.out.println("Integer");
	}*/
}
