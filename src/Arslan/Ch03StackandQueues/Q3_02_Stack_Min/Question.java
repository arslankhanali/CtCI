package Arslan.Ch03StackandQueues.Q3_02_Stack_Min;

public class Question {
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		//StackWithMin2 stack2 = new StackWithMin2();
		Solution stack2 = new Solution();
		int[] array = {2, 1, 3, 1};
		for (int value : array) {
			stack.push(value);
			stack2.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
			System.out.println("New min is " + stack.min() + ", " + stack2.min());
		}
	}

}
