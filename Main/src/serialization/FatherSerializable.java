package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Driver class

import java.io.Serializable;



public class FatherSerializable {

	public static void main(String[] args) throws Exception {
		Son son = new Son();
		son.child = 11;
		son.parent = 21;
		System.out.println("Serialization Starts");
		FileOutputStream fileOutputStream = new FileOutputStream("inheritance.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(son);

		System.out.println("DeSerialization Starts");
		FileInputStream fileInputStream = new FileInputStream("inheritance.txt");
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		Son son1 = (Son) inputStream.readObject();

		System.out.println(son1.child);
		System.out.println(son1.parent);
	}
	static class Father implements Serializable {

		int parent = 1;

		public Father() {
			System.out.println("Father Constructor...");
			parent = 3;
		}

		{
			parent = 2;
			System.out.println("Instance Block....");
		}

	}

	static class Son extends Father {
		int child = 4;

		public Son() {
			System.out.println("Son Constructor...");
			child = 5;
		}

		{
			child = 6;
		}
	}
}