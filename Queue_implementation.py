class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
class header:
    def __init__(self):
        self.head = None
class operations:
    def enq(self,d):
        temp = Node(d)
        trav = h.head
        if(h.head == None):
            h.head = temp
        else:
            while(trav.next != None):
                trav = trav.next
            trav.next = temp
    def deq(self):
        temp = h.head
        h.head = temp.next
        del temp
    def print(self):
        trav = h.head
        while(trav != None):
            print(trav.data,end =" ")
            trav = trav.next
            

h = header()
op = operations()
print("Queue implementation")
choice = int(input("Do you want to 1.enqueue or 2.dequeue 3. print 4.exit"))
while(choice != 4):
    if(choice == 1):
        data = input("Enter the data")
        op.enq(data)
        op.print()
    elif(choice == 2):
        op.deq()
        op.print()
    elif(choice == 3):
        op.print()
    else:
        pass
    choice = int(input("Enter your choice\t"))
