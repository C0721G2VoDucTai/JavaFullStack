package _10_dsa_danh_sach.practice.trien_khai_lop_linked_list_don_gian;


public class MyLinkedList {
    private Node head;
    private int numNodes; // tương đương size ArrayList

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        //khai báo 1 biến temp tham chiếu đến giá trị head
        Node temp = head; // tạm thời gán giá trị hiện tại của head cho temp
        //Tạo giá trị mới cho head
        head = new Node(data);
        // gán giá trị head ban đầu lại cho biến head cũ h là head mới
        head.next = temp;
        // tăng kích số lượng phần tử lên 1
        numNodes++;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private class Node {
        private Node next;
        private final Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}
