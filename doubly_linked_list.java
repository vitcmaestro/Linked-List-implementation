package doublylinkedlist;

import java.util.Scanner;
public class Node {
    int data;
    Node right;
    Node left;
    Node(int d)
    {
        data = d;
        left = null;
        right = null;
    }
}


public class DoublyLinkedList {
     Node head;
    Node tail;
    
    private void InsertAtBeg(int data) {
        Node node = new Node(data);
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
         Node temp = head;
         node.right = temp;
         temp.left = node;
         head = node;
        }
    }
    private void InsertAtEnd(int data) {
        if(head == null){
         InsertAtBeg(data);   
        }
        else
        {
        Node node = new Node(data);
        node.left = tail;
        tail.right = node;
        tail = node;
        }
    }
    private void InsertAtPos(int data, int pos, int count) {
        if(pos == 1)
            InsertAtBeg(data);
        else if(pos == count+1)
            InsertAtEnd(data);
        else
        {
        Node node = new Node(data);
        int posfind = 2;
        if(count/2 > pos)
        {
         Node trav = head;
         while(posfind < pos-1)
         {
             trav = trav.right;
             posfind++;
         }
         Node temp = trav.right;
         trav.right = node;
         node.right = temp;
         temp.left = node;
         node.left = trav;
        }
        else
        {
            pos = count-pos;
            posfind = 1;
            Node trav = tail;
            while(posfind < pos-1)
            {
               trav = trav.left;
               posfind++;
            }
            Node temp = trav.left;
            trav.left = node;
            node.left = temp;
            temp.right = node;
            node.right = trav;
        }
        }
    }
    private void DeleteAtBeg() {
        Node temp = head;
        head = temp.right;
        head.left = null;
        
    }
    private void DeleteAtEnd() {
        Node temp = tail;
        tail = temp.left;
        tail.right = null;
    }
    private void DeleteAtPos(int pos, int count) {
        if(pos == 1)
        {
            DeleteAtBeg();
        }
        else if(pos == count)
        {
            DeleteAtEnd();
        }
        else if(pos< count/2)
        {
            int posfind = 1;
            Node trav = head;
            while(posfind <pos-1)
            {
                trav = trav.right;
                posfind++;
            }
            Node temp = trav.right;
            trav.right = temp.right;
            temp.right.left = trav;
            temp.right = null;
            temp.left = null;
        }
        else {
            pos = count-pos;
            int posfind = 1;
            Node trav = tail;
            while(posfind<pos-1)
            {
                trav = trav.left;
                posfind++;
            }
            Node temp = trav.left;
            trav.left = temp.left;
            temp.left.right = trav;
            temp.right = null;
            temp.left = null;
            
        }
    }
    private int Search(int data) {
        int res = -1;
        int posfind = 1;
        Node trav = head;
        while(trav != null)
        {
            if(trav.data == data)
            {
                res = posfind;
            }
            trav = trav.right;
            posfind++;
        }
        return res;
    }
    private void display() {
        Node trav = head;
        while(trav != null)
        {
            System.out.println(trav.data);
            trav = trav.right;
        }
    }

    
    public static void main(String[] args) {
        System.out.println("Doubly linked list\n");
        Scanner scan = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int count = 0;
        int data,pos;
        System.out.print("Enter your choice\n 1.Insert at beginning\n2.Insert at end\n3.Insert at pos\n4.Delete at beginning\n5.Delete at end\n6.Delete at pos\n7.Search\n8.Display\n9.Exit");
        int choice = scan.nextInt();
        while(choice != 9)
        {
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the data to insert");
                    data = scan.nextInt();
                    dll.InsertAtBeg(data);
                    count++;
                    dll.display();
                    break;
                case 2:
                    System.out.println("Enter the data to insert");
                    data = scan.nextInt();
                    dll.InsertAtEnd(data);
                    count++;
                    dll.display();
                    break;
                case 3:
                    System.out.println("Enter the data to insert");
                    data = scan.nextInt();
                    System.out.println("Enter the position to insert");
                    pos = scan.nextInt();
                    dll.InsertAtPos(data,pos,count);
                    count++;
                    dll.display();
                    break;
                case 4:
                    dll.DeleteAtBeg();
                    count--;
                    dll.display();
                    break;
                case 5:
                    dll.DeleteAtEnd();
                    count--;
                    dll.display();
                    break;
                case 6:
                    System.out.println("Enter the position to delete");
                    pos = scan.nextInt();
                    dll.DeleteAtPos(pos,count);
                    count--;
                    dll.display();
                    break;
                case 7:
                    System.out.println("Enter the element to search");
                    data = scan.nextInt();
                    pos = dll.Search(data);
                    if(pos == -1)
                        System.out.println("The eleement is not in the list");
                    else
                        System.out.println("The eleement is presenet in position "+pos);
                    break;
                case 8:
                    dll.display();
                    break;               
            }
            System.out.println("Enter your choice of number");
            choice = scan.nextInt();
        }
    }
    
}
