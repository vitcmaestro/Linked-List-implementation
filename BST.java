
package binarytree;

public class Node 
    {
        int data;
        Node left;
        Node right;
        Node(int d)
        {
            this.data = d;
            this.left = null;
            this.right = null;
            
        }
    }


public class BinaryTree {
    static int data,pos;
    public Node insert(Node root,int data)
    {
        
        if(root == null)
        {
            return new Node(data);
        }
        else if(data < root.data)
        {
            root.left = insert(root.left,data);
        }
        else
        {
            root.right = insert(root.right,data);
        }
        return root;
    }
    
    private  Node minimumlast(Node tochange) {
        while(tochange.left != null)
            tochange = tochange.left;
        return tochange;
    }
    public Node delete(Node root,int key)
    {
        Node current = root;
        Node parent = null;
        
        while(current != null && current.data != key)
        {
            parent = current;
            if(key<current.data)
                current = current.left;
            else
                current = current.right;
        }
        if(current == null)
                return root;
        if(current.left == null && current.right == null)
        {
            if(current != root)
            {
                if(parent.left == current)
                    parent.left = null;
                else
                    parent.right = null;
            }
            else
            {
                root = null;
            }
        }
        else if(current.left != null && current.right != null)
        {
            Node exchange = minimumlast(current.right);
            int val = exchange.data;
            delete(root,exchange.data);
            current.data = val;
        }
        else{
            Node child = (current.left != null)? current.left:current.right;
            if(current != root){
            if(parent.left == current)
                parent.left = child;
            else
                parent.right = child;
        }
        else
        root = child;
        }
        return root;
        }
    public void postorder(Node node)
    {
        if(node != null)
        {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
        else 
            return;
    }
    
    public void preorder(Node node)
    {
        if(node != null)
        {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
        else
            return;
    }
    public void inorder(Node node)
    {
        if(node != null)
        {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
        else
            return;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your choice\n1.Insert\n2.Delete\n3.Inorder\n4.preorder\n5.Postorder\n6.Exit");
        int choice = scan.nextInt();
        Node root = null;
        while(choice != 6)
        {
            switch(choice){
                    case 1:
                        System.out.println("Enter the data");
                        data = scan.nextInt();
                        root = bt.insert(root,data);
                        break;
                    case 2:
                        System.out.println("Enetr the key to deleete");
                        data = scan.nextInt();
                        root = bt.delete(root,data);
                        break;
                    case 3:
                        bt.inorder(root);
                        break;
                    case 4:
                        bt.preorder(root);
                        break;
                    case 5:
                        bt.postorder(root);
                        break;
               
            }
            System.out.println("Enter your choice");
            choice = scan.nextInt();
        }
    }
}
