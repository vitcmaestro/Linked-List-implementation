
package stackusingarray;

import java.util.Scanner;

class Operations {
    int top;
    int[] array;
    Operations(int[] array)
    {
        this.array = array;
    }
    void push(int data,int top)
    {
        array[top] = data;
        //System.out.println(top);
    }
    void pop(int top)
    {
        System.out.println(array[top-1]+" is popped out");
        array[top-1] = 0;
       // System.out.println(top);
    }
    void display(int top)
    {
        for(int i=0;i < top;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        int[] array = new int[100];
        int top = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter tour choice\n1.Push\n2.Pop\n3.Display\n4.Exit");
        int choice = scan.nextInt();
        int data;
        Operations op = new Operations(array);
        while(choice != 4)
        {
            if(choice == 1)
            {
                System.out.println("Enter data to push");
                data = scan.nextInt();
                op.push(data,top);
                top++;
            }
            else if(choice == 2)
            {
                op.pop(top);
                top--;
            }
            else if(choice == 3)
            {
                op.display(top);
            }
            System.out.println("Enter your choice\n");
            choice = scan.nextInt();
        }
    }
    
}
