# A Model of Bank Algorithm Using RedBlackTree 

![Screenshot](include/A_Model_of_Bank.JPEG)

# Runtime efficiency
 * Algorithm use the [red-black tree](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree) to Build Bank O(log n), Insert to tree O(log n) ,Delete customer O(log n),Search customer in tree O(log n) ,FIX tree O(log n) ,Delete all tree o(1)
 * Rotate left and right 0(1) .
 * To get all the customer who have minus in bank We use [linked list](https://en.wikipedia.org/wiki/Linked_list) , Build linked list o(n),Search customer in linked list o(n)
 * To get the rich customer in tree we use [max-heap](https://en.wikipedia.org/wiki/Min-max_heap) ,build max-heap o(n) 
 * Search for rich customer o(1).



# Simulation of a program run

    **************************************************************************
    -If the client wants to put money in the account or take money Press 1 
    -New customer Press 2 
    -Delete customer (ID) Press 3
    -Print the rich customer at the bank Press 4 
    -Checking the Balances in the customer's account (by id ) Press 5 
    -Print all customer in Bank  Press 6 
    -Printing all customers With Negative balance in Bank Press 7 
    - * Delete all tree all customer Press 8 * 
    **************************************************************************
 
    2
 
    Insert a new customer 
    Insert name 
    vova 
    Insert LastName 
    g
    Insert id --> (id >1000000) and (id <9999999)
    1234567
    Enter the desired amount of money , money need to be >=0 
    10
 
    + New Client is Added: vova  g 1234567 1234567 10
    Color: Black Key: 1234567 Parent: -1

    **************************************************************************
    -If the client wants to put money in the account or take money Press 1 
    -New customer Press 2 
    -Delete customer (ID) Press 3
    -Print the rich customer at the bank Press 4 
    -Checking the Balances in the customer's account (by id ) Press 5 
    -Print all customer in Bank  Press 6 
    -Printing all customers With Negative balance in Bank Press 7 
    - * Delete all tree all customer Press 8 * 
    **************************************************************************
 

    4
 
    The richest Man in my bank is: 1234567 He have 10 $ 

    **************************************************************************
    -If the client wants to put money in the account or take money Press 1 
    -New customer Press 2 
    -Delete customer (ID) Press 3
    -Print the rich customer at the bank Press 4 
    -Checking the Balances in the customer's account (by id ) Press 5 
    -Print all customer in Bank  Press 6 
    -Printing all customers With Negative balance in Bank Press 7 
    - * Delete all tree all customer Press 8 * 
    **************************************************************************
 

    1
 
    Insert your ID
    1234567
 
    If the client wants to spend money from the account (Add a minus(-) before )
    if you want to put money to account Enter the desired amount of money (only int()) 
    30
 
    The Account customer is : vova  g 1234567 40
 
    The Customer vova  His account number is 1234567 put 30 $

    **************************************************************************
    -If the client wants to put money in the account or take money Press 1 
    -New customer Press 2 
    -Delete customer (ID) Press 3
    -Print the rich customer at the bank Press 4 
    -Checking the Balances in the customer's account (by id ) Press 5 
    -Print all customer in Bank  Press 6 
    -Printing all customers With Negative balance in Bank Press 7 
    - * Delete all tree all customer Press 8 * 
    **************************************************************************

    8

    Tree Deleted! 
 

