/**
 * @author Leejia James
 *
 * Implementing bounded-sized stack using arrays
 *
 * Ver 1.0: 2018/09/09
 */

package lxj171130;

import java.util.Scanner;

public class BoundedStack<T> {
	int top;
	int maxSize = 0;
	Object[] bstack;
	
    /**
     * Creates new stack of given size
     */
	BoundedStack(int size)
	{
		top = -1;
		maxSize = size;
		bstack = new Object[size];		
	}
	
    /**
     * Inserts a new element x at the top of the stack
     *
     * @param x element to add
     * 
     * @return true if the element is added, false if the element 
     * is not added because the stack is full
     */
	boolean push(T x)
	{
		if(top + 1 != maxSize)
		{
			bstack[++top] = x;
			return true;
		}
		return false;
	}
	
	/**
	 * Removes the element at the top of the stack
	 * 
	 * @return element at the top of the stack, null if the stack
	 * is empty
	 */
	T pop()
	{
		if(isEmpty()) {
			return null;
		}
		Object temp = bstack[top];
		bstack[top] = null;
		top--;
		return (T) temp;
	}
	
	/**
	 * Finds the number of elements in the stack
	 * 
	 * @return the number of elements in the stack
	 */
	int size()
	{
		return top + 1;
	}
	
	/**
	 * Checks if the stack is empty
	 * 
	 * @return true if stack is empty, false otherwise
	 */
	boolean isEmpty()
	{
		return top == -1? true : false;
	}
	
	void printStack()
	{
		System.out.print(size() + ": ");
		
		if(size() > 0) {
			for(int i=0; i<=top; i++) {
				System.out.print(bstack[i] + " ");
			}
		}
		
		System.out.println();
	}
	
	public static void main(String args[])
	{
		int n = 5;
		if(args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		
		BoundedStack<Integer> bs = new BoundedStack<>(10);
		for(int i=1; i<=n; i++) {
			bs.push(Integer.valueOf(i));
		}
		bs.printStack();
		
		Scanner in = new Scanner(System.in);
		whileloop:
		while(in.hasNext()) {
			int com = in.nextInt();
			switch(com) {
			case 1:  // Add a new element x at the top of the stack
				int elemAdd = in.nextInt();
				System.out.println(bs.push(elemAdd));
				bs.printStack();
				break;
			case 2:  // Remove and return the element at the top of the stack
				System.out.println(bs.pop());
				bs.printStack();
				break;
			case 3:  // Return the number of elements in the stack 
				System.out.println(bs.size());
				bs.printStack();
				break;
			case 4:  // Check if the stack is empty
				System.out.println(bs.isEmpty());
				bs.printStack();
				break;			
			default:  // Exit loop
				break whileloop;
			}
		}
		bs.printStack();
	}
}