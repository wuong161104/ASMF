class Stack {
    int size;
    int top;
    int[] stackArray;

    public Stack(int size) {
        this.size = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    public void push(int value) {
        if (top >= size - 1) {
            System.out.println("Stack is full!");
        } else {
            stackArray[++top] = value;
            System.out.println("Pushed: " + value);
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);  // Create a stack with size 5
        stack.push(10);  // Add 10 to the stack
        stack.push(20);  // Add 20 to the stack
        System.out.println("Top element: " + stack.peek()); // Print the top element
        stack.pop();  // Remove the top element from the stack
        System.out.println("Is stack empty? " + stack.isEmpty()); // Check if the stack is empty
    }

    static class StackLinkedList {
        Node top;

        public StackLinkedList() {
            top = null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            System.out.println("Pushed " + data);
        }

        public int pop() {
            if (top == null) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int popped = top.data;
            top = top.next;
            return popped;
        }

        public int peek() {
            if (top == null) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public static void main(String[] args) {
            StackLinkedList stack = new StackLinkedList();
            stack.push(10);
            stack.push(20);
            System.out.println("Top element is: " + stack.peek());
            stack.pop();
        }
    }
}
