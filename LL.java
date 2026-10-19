class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;

    }
}

public class LL {
    Node head = null;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void swapNodes() {
        if (head == null && head.next == null) {
            return;
        }
        Node current = head;
        Node previous = null;
        head = head.next;

        while (current != null && current.next != null) {
            Node nextNode = current.next;
            Node remaining = nextNode.next;

            nextNode.next = current;
            current.next = remaining;

            if (previous != null) {
                previous.next = nextNode;
            }
            previous = current;
            current = remaining;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        LL list = new LL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        System.out.println("our list before swapping");
        list.printList();
        System.out.println("our list after swapping adjacent nodes");
        list.swapNodes();
        list.printList();
    }
}