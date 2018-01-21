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
			rear = (rear + 1) % N;
		}
		arr[rear] = value;
		System.out.println("After enQueue: " + value);
		printQueue();
	}

	private Object deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty , deQueue Failed: ");
			return null;
		} else if (isHaveSingleElement()) {
			System.out
					.println("Before deQueue , Queue has only 1 element, deQueus is Successful, Now its EMPTY ");
			makeQueueEmpty();
			return null;
		} else {
			front = (front + 1) % N;
			Object value = arr[front];
			System.out.println("After deQueue: " + value);
			printQueue();
			return value;
		}
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
		return !isEmpty() && (rear + 1) % N == front;
	}

	private void printQueue() {
		for (int i = front; i < N; i++) {
			System.out.print(" " + arr[i]);
		}
		if (front > rear) {
			for (int i = 0; i <= rear; i++) {
				System.out.print(" : " + arr[i]);
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		CircularArrayQueue queue = new CircularArrayQueue(5);
		queue.enQueue("Balu1");
		queue.enQueue("Balu2");
		queue.deQueue();
		queue.enQueue("Balu3");
		queue.enQueue("Balu4");
		queue.deQueue();
	}
}
