public class Node {
    int data;
    Node next;
  
    Node(int d)
    {
        data = d;
        next = null;
    }

}
public class SinglyLinkedList {
    Node head = null;
       
    static int data,pos;
     private void InsertAtEnd(int data) {
        if(head == null)
        {
            InsertAtBeg(data);
        }
        else
        {
            Node node = new Node(data);
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    private void InsertAtBeg(int data) {
        if(head == null)
        {
            Node node = new Node(data);
            head = node;
        }
        else
        {
            Node node = new Node(data);
            //Node temp = Node.head;
            node.next = head;
            head = node;
        }
    }

    private void InsertAtPos(int data, int pos) {
        if(pos == 1)
            InsertAtBeg(data);
        else
        {
            Node node = new Node(data);
            int count = 1;
            Node temp = head;
            while(temp.next!=null && count<pos)
            {
                temp = temp.next;
                count++;
            }
            Node chnge = temp.next;
            temp.next = node;
            node.next = chnge;
        }
    }

    private void DelAtBeg() {
        if(head != null)
        {
            Node temp = head;
            head = head.next;
        }
    }

    private void DelAtEnd() {
        if(head.next == null)
        {
            head = null;
        }
        else
        {
            Node temp = head;
            while(temp.next.next != null)
                temp = temp.next;
            temp.next = null;
        }
    }

    private void DelAtPos(int pos) {
        int count = 1;
        Node trav = head;
        while(count< pos-2)
            trav = trav.next;
        Node temp = trav.next.next;
        trav.next = temp;
    }
    private void Display() {
        Node trav = head;
        while(trav != null)
        {
            System.out.println(trav.data);
            trav = trav.next;
        }
    }

    private void search(int data) {
        Node trav = head;
        pos = 1;
        int flag =  0;
        while(trav != null)
        {
            if(trav.data == data)
            {   
                flag = 1;
                System.out.println("The data is present in position "+ pos);
            }
            trav = trav.next;
            pos++;
        }
        if(flag == 0)
            System.out.println("The data is not present");
        
    }

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        Scanner scan  =  new Scanner(System.in);
        System.out.println("Enter your choice");
        System.out.println("1.Insert at beginning \n 2.Insert at end \n 3.Insert at position \n 4.Delete at beginning \n 5.Delete at end \n 6.Delete at position \n 7.Search \n 8.Displayt \n9.Exit");
        int choice = scan.nextInt();
        while(choice != 9)
        {
            if(choice == 1)
            {
                System.out.println("Enter the data to insert");
                data = scan.nextInt();
                sl.InsertAtBeg(data); 
                 sl.Display();
            }
            if(choice == 2)
            {
                System.out.println("Enter the data to insert");
                data = scan.nextInt();
                sl.InsertAtEnd(data);
                 sl.Display();
            }
            if(choice == 3)
            {
                System.out.println("Enter the data to insert");
                data = scan.nextInt();
                System.out.println("Enter the position to enter data");
                pos= scan.nextInt();
                sl.InsertAtPos(data,pos);
                 sl.Display();
            }
            if(choice == 4)
            {
                sl.DelAtBeg();
                 sl.Display();
            }
            if(choice == 5)
            {
                sl.DelAtEnd();
                 sl.Display();
            }
            if(choice == 6)
            {
                System.out.println("Enter the position to enter data");
                pos= scan.nextInt();
                sl.DelAtPos(pos);
                 sl.Display();
            }
            if(choice == 7)
            {
                System.out.print("Enter the data to print");
                data = scan.nextInt();
                sl.search(data);
            }
            if(choice == 8)
            {
                sl.Display();
            }
            System.out.println("1.Insert at beginning \n 2.Insert at end \n 3.Insert at position \n 4.Delete at beginning \n 5.Delete at end \n 6.Delete at position \n 7.Search \n 8.Display \n 9.Exit");
            choice= scan.nextInt();
        }
    }
    
}
