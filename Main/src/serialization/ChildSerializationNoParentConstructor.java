package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ChildSerializationNoParentConstructor {
	static class Father {

		int parent = 1;

		public Father(String test) {
			System.out.println("Father Constructor");
			parent = 3;
		}

		{
			System.out.println("Initialization Block..");
			parent = 2;
		}
	}

	static class Son extends Father implements Serializable {

		public Son(String test) {
			super(test);
			System.out.println("Son Constructor...");
		}

		int child = 4;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//Serialize
		Son son = new Son("");
		son.parent = 101;
		son.child = 102;
		FileOutputStream fileOutputStream = new FileOutputStream("son.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(son);
		
		//Deserialize
		
		 FileInputStream fileInputStream = new FileInputStream("son.ser");
		 ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		 Son sonDeseralized = (Son)inputStream.readObject();
		 System.out.println(sonDeseralized.parent);
		 System.out.println(sonDeseralized.child);

	}
}
