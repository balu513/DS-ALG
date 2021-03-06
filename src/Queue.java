public class Queue {

	private int front;
	private int rear;
	private Object[] arr;
	private final int size;

	public Queue(int size) {
		this.size = size;
		front = -1;
		rear = -1;
		arr = new Object[size];
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

	private void makeQueueEmpty() {
		front = -1;
		rear = -1;
	}

	private boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	private boolean isFull() {
		return rear == size;
	}

	private void printQueue() {
		for (int i = front; i <= rear; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue queue = new Queue(10);
		queue.enQueue("Balu1");
		queue.enQueue("Balu2");
		queue.deQueue();
		queue.enQueue("Balu3");
		queue.enQueue("Balu4");
		queue.deQueue();
	}

}
