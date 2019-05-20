class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
class header:
    def __init__(self):
        self.head = None
class operations:
    def push(self,d):
        temp = Node(d)
        trav = h.head
        if(h.head == None):
            h.head = temp
        else:
            while(trav.next != None):
                trav = trav.next
            trav.next = temp
    def pop(self):
        trav = h.head
        while(trav.next.next != None):
            trav = trav.next
        temp = trav.next
        trav.next = None
        del temp
    def print(self):
        trav = h.head
        while(trav != None):
            print(trav.data,end =" ")
            trav = trav.next
            

h = header()
op = operations()
print("Stack implementation")
choice = int(input("Do you want to 1.push or 2.pop 3. print 4.exit"))
while(choice != 4):
    if(choice == 1):
        data = input("Enter the data")
        op.push(data)
        op.print()
    elif(choice == 2):
        op.pop()
        op.print()
    elif(choice == 3):
        op.print()
    else:
        pass
    choice = int(input("Enter your choice\t"))
