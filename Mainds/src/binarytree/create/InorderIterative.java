package binarytree.create;
/*
 1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
 */
/*
   			1
          /   \
        2      3
      /  \
    4     5

Step 1 Creates an empty stack: S = NULL

Step 2 sets current as address of root: current -> 1

Step 3 Pushes the current node and set current = current->left until current is NULL
     current -> 1
     push 1: Stack S -> 1
     current -> 2
     push 2: Stack S -> 2, 1
     current -> 4
     push 4: Stack S -> 4, 2, 1
     current = NULL

Step 4 pops from S
     a) Pop 4: Stack S -> 2, 1
     b) print "4"
     c) current = NULL right of 4  and go to step 3
Since current is NULL step 3 doesn't do anything. 

Step 4 pops again.
     a) Pop 2: Stack S -> 1
     b) print "2"
     c) current -> 5 right of 2  and go to step 3

Step 3 pushes 5 to stack and makes current NULL
     Stack S -> 5, 1
     current = NULL

Step 4 pops from S
     a) Pop 5: Stack S -> 1
     b) print "5"
     c) current = NULL right of 5  and go to step 3
Since current is NULL step 3 doesn't do anything

Step 4 pops again.
     a) Pop 1: Stack S -> NULL
     b) print "1"
     c) current -> 3 /*right of 5   

Step 3 pushes 3 to stack and makes current NULL
     Stack S -> 3
     current = NULL

Step 4 pops from S
     a) Pop 3: Stack S -> NULL
     b) print "3"
     c) current = NULL right of 3   

Traversal is done now as stack S is empty and current is NULL.
*/

import java.util.Stack;

public class InorderIterative {
	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/* Class to print the inorder traversal */

	Node root;

	void inorder() {
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		Node curr = root;

		// traverse the tree
		while (curr != null || s.size() > 0) {

			/*
			 * Reach the left most Node of the curr Node
			 */
			while (curr != null) {
				/*
				 * place pointer to a tree node on the stack before traversing the node's left subtree
				 */
				s.push(curr);
				curr = curr.left;
			}

			/* Current must be NULL at this point */
			curr = s.pop();

			System.out.print(curr.data + " ");

			/*
			 * we have visited the node and its left subtree. Now, it's right subtree's turn
			 */
			curr = curr.right;
		}
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		InorderIterative tree = new InorderIterative();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorder();
	}
}
