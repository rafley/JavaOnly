import java.util.Arrays;

class UnrolledLinkedList<T> {
    private int nodeCapacity;
    private Node head;
    
    public UnrolledLinkedList(int nodeCapacity) {
        this.nodeCapacity = nodeCapacity;
        head = new Node();
    }

    public void add(T element) {
        Node node = findTail();
        if (node.isFull()) {
            Node newNode = new Node();
            node.next = newNode;
            newNode.prev = node;
            node = newNode;
        }
        node.add(element);
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        Node current = head;
        while (current != null) {
            if (index < current.size()) {
                return current.get(index);
            }
            index -= current.size();
            current = current.next;
        }
        return null;
    }

    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size += current.size();
            current = current.next;
        }
        return size;
    }

    private Node findTail() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private class Node {
        private T[] elements;
        private int size;
        private Node prev;
        private Node next;

        @SuppressWarnings("unchecked")
        public Node() {
            elements = (T[]) new Object[nodeCapacity];
            size = 0;
            prev = null;
            next = null;
        }

        public void add(T element) {
            elements[size] = element;
            size++;
        }

        public T get(int index) {
            return elements[index];
        }

        public int size() {
            return size;
        }

        public boolean isFull() {
            return size == nodeCapacity;
        }
    }
}

// public class Main {
//     public static void main(String[] args) {
//         UnrolledLinkedList<Integer> list = new UnrolledLinkedList<>(3);

//         list.add(1);
//         list.add(2);
//         list.add(3);
//         list.add(4);
//         list.add(5);

//         for (int i = 0; i < list.size(); i++) {
//             System.out.println("Element at index " + i + ": " + list.get(i));
//         }
//     }
// }
