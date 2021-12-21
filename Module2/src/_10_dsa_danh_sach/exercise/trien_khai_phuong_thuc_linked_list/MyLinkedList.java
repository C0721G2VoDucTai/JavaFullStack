package _10_dsa_danh_sach.exercise.trien_khai_phuong_thuc_linked_list;

public class MyLinkedList< E > {
    public MyLinkedList(int i) {
    }

    private static class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numberNodes;

    public void add(int index, Object data) {
        Node temp = head;
        // Khai bao Node holder
        Node holder;
        // holder tham chieu den vi tri index -1
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next; // biến temp đang ở vị trí index -1
        }
        // holder tham chieu den vi tri Node tai vi tri index
        holder = temp.next;
        // Node tai vi tri index-1 tro toi vị tri moi
        temp.next = new Node(data);
        // Node tro toi holder
        temp.next.next = holder;
        // tang size len 1.
        numberNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numberNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        Node holder;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numberNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index > numberNodes) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        Object data;
        if (index == 0) {
            data = temp.data;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
        }
        numberNodes--;
        return (E) data;
    }

    public boolean remove(E element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(element)) {

                    temp.next = temp.next.next;
                    numberNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public int size() {
        return numberNodes;
    }

    public MyLinkedList< E > clone() {
        if (numberNodes == 0) {
            throw new NullPointerException();
        }
        MyLinkedList< E > temp = new MyLinkedList< E >(10);
        Node tempNode = head;
        temp.addFirst((E) tempNode.data);
        tempNode = tempNode.next;
        while (tempNode != null) {
            temp.addLast((E) tempNode.data);
            tempNode = tempNode.next;
        }
        return temp;
    }

    public boolean contains(E elements) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(elements)) {
                return true;
            }
            temp = temp.next;
        }
        if (temp.next.data.equals(elements)) {
            return true;
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numberNodes; i++) {
            if ((E) temp.getData() == element) {
                return i;

            }
            temp = temp.next;
        }
        return -1;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return  (E) temp.data;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}
