public class CircularArrayQueue {
	private int front;
	private int rear;
	private Object[] arr;
	private final int N;

	public CircularArrayQueue(int N) {
		this.N = N;
		front = -1;
		rear = -1;
		arr = new Object[N];
	}

	private void enQueue(Object value) {
		if (isEmpty()) {
			front = 0;
			rear = 0;
		} else if (isFull()) {
			System.out.println("Queue is Full , enQueue Failed: " + value);
			return;
		} else {
			rear++;
		}
		arr[rear] = value;
		System.out.println("After enQueue: " + value);
		printQueue();
	}

	private Object deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty , deQueue Failed: ");
			return null;
		}
		if (isHaveSingleElement())
			makeQueueEmpty();

		front++;
		Object value = arr[front];
		System.out.println("After deQueue: " + value);
		printQueue();
		return value;
	}

	private boolean isHaveSingleElement() {
		return (front == rear) && !isEmpty();
	}

	private boolean isNoSpace() {
		return (rear + 1) % N == front;
	}

	private void makeQueueEmpty() {
		front = -1;
		rear = -1;
	}

	private boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	private boolean isFull() {
		return !isEmpty() && (rear + 1) % N == 0;
	}

	private void printQueue() {
		for (int i = front; i <= rear; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}
}
