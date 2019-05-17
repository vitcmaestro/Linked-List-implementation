class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None
class header:
    def __init__(self):
        self.head = None
        self.tail = None
class operations:
    def insAtBeg(self,d,length):
        temp = Node(d)
        hdr = h.head
        if(hdr == None):
            h.head = temp
        else:
            temp.right = h.head
            hdr.left = temp
            h.head = temp
        if(length == 1):
            h.tail = temp
    def insAtEnd(self,d,length):
        temp = Node(d)
        h.tail.right = temp
        h.tail = temp
        
    def insAtPos(self,pos,d,length):
        temp = Node(d)
        if(pos == 1):
            self.insAtBeg(d,length)
        else:
            c= 2
            trav = h.head
            while(c != pos):
               c+=1
               trav = trav.right
            temp.right = trav.right
            x = temp.right
            x.left = temp
            trav.right = temp
            temp.left = trav
    def delAtBeg(self,length):
        temp = h.head
        h.head = temp.right
        if(h.head !=None):
            h.head.left = None
        del temp
        if(length == 1):
            h.tail = temp
    def delAtEnd(self,length):
        temp = h.tail
        h.tail = h.tail.left
        tail.right = None
        del temp
    def delAtPos(self,pos,length):
        if(pos == 1):
            self.delAtBeg(length)
        else:
            c= 2
            trav = h.head
            while(c!=pos):
                c+=1
                trav = trav.right
            temp = trav.right
            trav.right = temp.right
            x = trav.right
            if(x != None):
                x.left = trav
            else:
                h.tail = trav
            del temp
    def search(self,pos,length):
        if(pos> length//2):
            trav = h.tail
            c = length-pos
            while(c>0):
                c-=1
                trav = trav.left
            print(trav.data)
        else:
            c= 1
            trav = h.head
            while(c != pos):
                trav = trav.right
            print(trav.data)
    def print(self):
        trav = h.head
        while(trav != None):
            print(trav.data,end =" ")
            trav = trav.right
            
                



h = header()
op = operations()
length = 0
print("Linked list implementation")
choice = int(input("1. Insert at beginning \n2.Insert at end\n3.Insert at pos\n4.Deletion at beginning\n5.Deletion at end\n6.Deletion at position\n7.Search\n8.Print elements\n9.Exit\n"))
while(choice != 9):
    if(choice == 1):
        data = int(input("Enter the data to enter"))
        length+=1
        op.insAtBeg(data,length)
    elif(choice == 2):
        data = int(input("Enter the data to enter"))
        length+=1
        op.insAtEnd(data,length)
    elif(choice == 3):
        data = int(input("Enter the data to enter"))
        pos =  int(input("Enter the pos to enter"))
        length+=1
        op.insAtPos(pos,data,length)
    elif(choice == 4):
        length-=1
        op.delAtBeg(length)
    elif(choice == 5):
        length-=1
        op.delAtEnd(length)
    elif(choice == 6):
        length-=1
        pos = int(input("Enter the pos to delete"))
        op.delAtPos(pos,length)
    elif(choice == 7):
        pos = int(input("Enter the pos to search"))
        op.search(pos,length)
    elif(choice == 8):
        op.print()
    print(length,"is the length of the list")
    choice = int(input("Enter your choice"))
