/*
 * STACK -  LastIn FirstOut
 */
public class Stack {

	private Object[] arr;
	private int top;
	private final int size;
	private static String val;

	public Stack(int size) {
		this.size = size;
		arr = new Object[10];
		top = -1;
	}

	private void push(Object val) {
		if (isStackFull()) {
			System.out.println("Stack Full, Push failed " + val + " \n");
			return;
		}
		top++;
		arr[top] = val;
		System.out
				.println("Stack After Push-  top: " + top + "  size: " + size);
		printStack();
	}

	private Object pop() {

		if (isStackEmpty()) {
			System.out.println("Stack Empty, Pop failed  \n");
			return null;
		}
		Object object = arr[top];
		top--;
		System.out.println("Stack After Pop-  top: " + top + "  size: " + size);
		printStack();
		return object;

	}

	private boolean isStackEmpty() {
		return top == -1 ? true : false;
	}

	private boolean isStackFull() {
		return top == size - 1 ? true : false;
	}

	private Object peek() {
		return arr[top];
	}

	private void printStack() {
		for (int i = top; i > -1; i--) {
			System.out.print("  " + arr[i]);
		}
		System.out.println("\n");

	}

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push("balu1");
		stack.push("balu2");
		stack.push("balu3");
		stack.pop();
		stack.push("balu4");
		stack.push("balu5");
		stack.push("balu6");
		stack.push("balu7");
		stack.pop();

		stack.push("balu8");

		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

	}

}
