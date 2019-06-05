package serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 During deserialization, new object will be created by executing No-argument constructor. 
 So if we didn’t have No-argument constructor, then InvalidClassException will be thrown.


 */
public class ExternizableEx {

	static class Apple implements Externalizable {

		private int appleOriginalCost;

		private int appleMRPCost;

		private String appleColor;

		public Apple(int i) {

			System.out.println("Apple Constructor...");

		}

		public int getAppleOriginalCost() {

			return appleOriginalCost;

		}

		public void setAppleOriginalCost(int appleOriginalCost) {

			this.appleOriginalCost = appleOriginalCost;

		}

		public int getAppleMRPCost() {

			return appleMRPCost;

		}

		public void setAppleMRPCost(int appleMRPCost) {

			this.appleMRPCost = appleMRPCost;

		}

		public String getAppleColor() {

			return appleColor;

		}

		public void setAppleColor(String appleColor) {

			this.appleColor = appleColor;

		}

		@Override

		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

			System.out.println("read External Starts");

			System.out.println(appleMRPCost);

			System.out.println(appleColor);

			appleMRPCost = in.readInt();

			appleColor = (String) in.readObject();

			System.out.println("read External Ends");

		}

		@Override

		public void writeExternal(ObjectOutput out) throws IOException {

			out.writeInt(appleMRPCost);

			out.writeObject(appleColor);

		}

	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Apple apple = new Apple(21);
		 
		apple.setAppleColor("RED");
		 
		apple.setAppleOriginalCost(10);
		 
		apple.setAppleMRPCost(25);
		 
		FileOutputStream fileOutputStream = new FileOutputStream("apple.ser");
		 
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		 
		objectOutputStream.writeObject(apple);
		objectOutputStream.close();
		
		 FileInputStream fis = new FileInputStream("apple.ser"); 
	     ObjectInputStream ois = new ObjectInputStream(fis); 
	  
	     // Method for de-serializing object of class Serial1      
	     Apple serobject = (Apple) ois.readObject(); 
	     System.out.println(apple.getAppleMRPCost());
	}
}
