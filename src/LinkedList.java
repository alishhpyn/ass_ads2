public class LinkedList {
    Node head;

    public void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null){
            head = node;
        }
        else {
            Node n = head;
            while (n.next!=null)
            {
                n = n.next;
            }
            n.next = node;
        }

    }
    public void show(){
        Node n = head;
        while (n.next!=null){
            System.out.print(n.data+" -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
    public void insertAtStart(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }
    public void insertAt(int index ,int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (index == 0){
            insertAtStart(data);
        }
        else {
        Node n = head   ;
        for (int i = 0; i<index-1; i++){
            n=n.next;
        }
        node.next = n.next;
        n.next = node;
    }}
    public void searchElement(int data){
        Node n = head;
        while (n !=null){
            if (n.data == data){
                System.out.println("Found");
                return;
            }
            n = n.next;
        }
        System.out.println("Not Found");
    }
    public void removeTheLastElement(){
        if (head == null) {
        return;
        }
        Node n = head;
        while (n.next.next != null){
            n = n.next;
        }
        n.next = null;
    }
    public void removeByValue(int data){
        if (head==null){
            return;
        }

        if (head.data == data){
            head = head.next;
            return;
        }
        Node n = head;
        while (n!=null){
            if (n.next.data == data){
             n.next=n.next.next;
            return;}
            n = n.next;
        }
    }
    public void combineLists(LinkedList list,LinkedList list1){
        if (list.head == null){
            list.head = list1.head;
            return;
        }
        Node n = list.head;

        while (n.next !=null){
                n = n.next;}
        n.next = list1.head;

    }
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
    }


