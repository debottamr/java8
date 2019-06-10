package binarytree.create;
/*

 		 1
 	    / \
 	   2   3
 	  / \ 
 	 4   5
 	
 */
public class TreeTraversal {

	static class Node<T> 
	{ 
	    T key; 
	    Node<T> left, right; 
	  
	    public Node(T item) 
	    { 
	        key = item; 
	        left = right = null; 
	    } 
	} 
	Node<Integer> root; 
	  
	TreeTraversal() 
    { 
        root = null; 
    } 
  
    /* Given a binary tree, print its nodes according to the 
      "bottom-up" postorder traversal. */
    void printPostorder(Node<Integer> node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.key + " "); 
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node<Integer> node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.key + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
  
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node<Integer> node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.key + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.left); 
  
        /* now recur on right subtree */
        printPreorder(node.right); 
    } 
  
    // Wrappers over above recursive functions 
    void printPostorder()  {     printPostorder(root);  } 
    void printInorder()    {     printInorder(root);   } 
    void printPreorder()   {     printPreorder(root);  } 
  
    // Driver method 
    public static void main(String[] args) 
    { 
    	TreeTraversal tree = new TreeTraversal(); 
        tree.root = new Node<Integer>(1); 
        tree.root.left = new Node<Integer>(2); 
        tree.root.right = new Node<Integer>(3); 
        tree.root.left.left = new Node<Integer>(4); 
        tree.root.left.right = new Node<Integer>(5); 
  
        System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreorder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInorder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostorder(); 
    } 
	
}
