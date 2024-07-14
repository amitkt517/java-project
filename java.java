import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class java {

    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>();

        System.out.println("Inserting 10 into the stack...");
        myStack.push(10);

        if (!myStack.empty()) {
            System.out.println("Removing element from the stack: " + myStack.peek());
            myStack.pop();
        } else {
            System.out.println("Stack is empty!");
        }

        Queue<Integer> myQueue = new LinkedList<>();

        System.out.println("\nInserting 20 into the queue...");
        myQueue.add(20);

        if (!myQueue.isEmpty()) {
            System.out.println("Element at the front of the queue: " + myQueue.peek());
        } else {
            System.out.println("Queue is empty!");
        }

        if (!myQueue.isEmpty()) {
            System.out.println("Removing element from the queue: " + myQueue.peek());
            myQueue.poll();
        } else {
            System.out.println("Queue is empty!");
        }
    }
}
