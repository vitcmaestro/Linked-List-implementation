/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackimplementation;

import java.util.Scanner;

/**
 *
 * @author MS
 */
public class StackImplementation {

    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    Node head;
    Node tail;
    private void push(int data)
    {
        Node node  = new Node(data);
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }
    private void pop()
    {
        if(head.next == null)
            head = tail = null;
        else
        {
            Node trav = head;
            while(trav.next.next != null)
                trav = trav.next;
            trav.next = null;
        }
    }
    private void display()
    {
        Node trav = head;
        while(trav != null)
        {
            System.out.print(trav.data+" ");
            trav = trav.next;
            
        }
    }
    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        System.out.println("Stack implementation using linked list\n");
        Scanner scan = new Scanner(System.in);
        int data;
        System.out.println("Enter your choice\n 1.push\n2.pop\n3.Display\n4.exit");
        int choice = scan.nextInt();
        while(choice != 4)
        {
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the data");
                    data = scan.nextInt();
                    stack.push(data);
                    stack.display();
                    break;
                case 2:
                    stack.pop();
                    stack.display();
                    break;
                case 3:
                    stack.display();
                    break;
                default:
                    System.out.println("Wrong choice");
                        
            }
            System.out.println("Do you want to continue");
            choice = scan.nextInt();
        }
    }
    
}
