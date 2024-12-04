class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class StackLinkedList {
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
