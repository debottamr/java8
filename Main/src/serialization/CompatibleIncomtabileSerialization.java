package serialization;

/*
 Compatible Changes :  Compatible changes are those changes which does not affect deSerialization process even if class was updated after being serialized (provided serialVersionUID has been declared)
 Adding new fields - We can add new member variables in class.
 Adding writeObject()/readObject()  methods - We may add these methods to customize serialization process.
 Removing writeObject()/readObject() methods - We may remove these methods and then default customization process will be used.
 Changing access modifier of a field - The change to access modifiers i.e. public, default, protected, and private have no effect on the ability of serialization to assign values to the fields.
 Changing a field from static to non static OR changing transient filed to non transient field. - it’s like addition of fields.

 InCompatible Changes :  InCompatible changes are those changes which affect deSerialization process if class was updated after being serialized (provided serialVersionUID has been declared)
 Deletion of fields.
 Changing a nonstatic field to static or  non transient field to transient field. - it’s equal to deletion of fields.
 Modifying the writeObject() / readObject() method - we must not modify these method, though adding or removing them completely is compatible change.
 */
//https://www.javamadesoeasy.com/2015/02/serialization-top-25-interview.html
public class CompatibleIncomtabileSerialization {

}
