class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
class header:
    def __init__(self):
        self.head = None
class operations:
    def insAtBeg(self,d):
        temp = Node(d)
        temp.next = h.head
        h.head = temp
    def insAtEnd(self,d):
        temp = Node(d)
        trav = h.head
        if(h.head == None):
            insAtBeg(self,d)
        else:
            while(trav.next != None):
                trav = trav.next
            trav.next = temp
    def insAtPos(self,pos,d):
        temp = Node(d)
        if(pos == 1):
            insAtBeg(self,d)
        else:
            c= 2
            trav = h.head
            while(c != pos):
               c+=1
               trav = trav.next
            temp.next = trav.next
            trav.next = temp
    def delAtBeg(self):
        temp = h.head
        h.head = temp.next
        del temp
    def delAtEnd(self):
        trav = h.head
        while(trav.next.next != None):
            trav = trav.next
        temp = trav.next
        trav.next = None
        del temp
    def delAtPos(self,pos):
        if(pos == 1):
            delAtBeg(self)
        else:
            c= 2
            trav = h.head
            while(c!=pos):
                c+=1
                trav = trav.next
            temp = trav.next
            trav.next = temp.next
            del temp
    def search(self,pos):
        if(pos ==1):
            print(h.head.data)
        else:
            c= 2
            trav = h.head
            while(c != pos):
                trav = trav.next
            print(trav.data)
    def print(self):
        trav = h.head
        while(trav != None):
            print(trav.data,end =" ")
            trav = trav.next
            
                



h = header()
op = operations()
print("Linked list implementation")
choice = int(input("1. Insert at beginning \n2.Insert at end\n3.Insert at pos\n4.Selection at beginning\n5.Deletion at end\n6.Deletion at position\n7.Search\n8.Print elements\n9.Exit\n"))
while(choice != 9):
    if(choice == 1):
        data = int(input("Enter the data to enter"))
        op.insAtBeg(data)
    elif(choice == 2):
        data = int(input("Enter the data to enter"))
        op.insAtEnd(data)
    elif(choice == 3):
        data = int(input("Enter the data to enter"))
        pos =  int(input("Enter the pos to enter"))
        op.insAtPos(pos,data)
    elif(choice == 4):
        op.delAtBeg()
    elif(choice == 5):
        op.delAtEnd()
    elif(choice == 6):
        pos = int(input("Enter the pos to delete"))
        op.delAtPos(pos)
    elif(choice == 7):
        pos = int(input("Enter the pos to search"))
        op.search(pos)
    elif(choice == 8):
        op.print()
    choice = int(input("Enter your choice"))
