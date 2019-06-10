package binarytree.create;
/*
 1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack
 */

import java.util.Stack;

/*
1. Push 1 to first stack.
      First stack: 1
      Second stack: Empty

2. Pop 1 from first stack and push it to second stack. 
   Push left and right children of 1 to first stack
      First stack: 2, 3
      Second stack: 1

3. Pop 3 from first stack and push it to second stack. 
   Push left and right children of 3 to first stack
      First stack: 2, 6, 7
      Second stack: 1, 3

4. Pop 7 from first stack and push it to second stack.
      First stack: 2, 6
      Second stack: 1, 3, 7

5. Pop 6 from first stack and push it to second stack.
      First stack: 2
      Second stack: 1, 3, 7, 6

6. Pop 2 from first stack and push it to second stack. 
   Push left and right children of 2 to first stack
      First stack: 4, 5
      Second stack: 1, 3, 7, 6, 2

7. Pop 5 from first stack and push it to second stack.
      First stack: 4
      Second stack: 1, 3, 7, 6, 2, 5

8. Pop 4 from first stack and push it to second stack.
      First stack: Empty
      Second stack: 1, 3, 7, 6, 2, 5, 4

The algorithm stops here since there are no more items in the first stack. 
Observe that the contents of second stack are in postorder fashion. Print them. 
 */
public class IterativePostOrder {
	static class node {
		int data;
		node left, right;

		public node(int data) {
			this.data = data;
		}
	}

	// Two stacks as used in explanation
	static Stack<node> s1, s2;

	static void postOrderIterative(node root) {
		// Create two stacks
		s1 = new Stack<>();
		s2 = new Stack<>();

		if (root == null)
			return;

		// push root to first stack
		s1.push(root);

		// Run while first stack is not empty
		while (!s1.isEmpty()) {
			// Pop an item from s1 and push it to s2
			node temp = s1.pop();
			s2.push(temp);

			// Push left and right children of
			// removed item to s1
			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);
		}

		// Print all elements of second stack
		while (!s2.isEmpty()) {
			node temp = s2.pop();
			System.out.print(temp.data + " ");
		}
	}

	public static void main(String[] args) {
		// Let us construct the tree
		// shown in above figure

		node root = null;
		root = new node(1);
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		root.left.right = new node(5);
		root.right.left = new node(6);
		root.right.right = new node(7);

		postOrderIterative(root);
	}
}
