import java.util.Scanner;
import java.lang.String;
/**
 * The program build bank Of Customers ,the Name of Customer LastName ,id and How much money he wants to put in the bank account .
 * The program Can return Who is the richest Customer in the bank ,How much money he have in bank account .
 * The customer can also put money into the account and spend money from the account .
 * The program Can return Who owes money to the bank and how much.
 * The program Can Print all customer in Bank ,also The program Can Delete a customer or all customers at the bank .
 * --------------------------------------------------------------------------------------------------------------------------------------------
 * Algorithm use the red-black tree to Build Bank O(log n), Insert to tree O(log n) ,Delete customer O(log n),Search customer in tree O(log n) ,
 * FIX tree O(log n) ,Delete all tree o(1)
 * Rotate left and right 0(1) .
 * To get all the customer who have minus in bank We use linked list , Build linked list o(n),Search customer in linked list o(n)
 * To get the rich customer in tree we use max-heap ,build max-heap o(n) 
 * Search for rich customer o(1).
 * --------------------------------------------------------------------------------------------------------------------------------------------
 * @author (Vladimir Geytman) 
 */
public class RedBlackTree
 {   //Start of a program
    
   private final int RED = 0;   // color of Tree
   private final int BLACK = 1;
    
    /**
     * Constructor of RedBlackTree
     * @param  key .
     * @param  color.
     * @param  sum of money.
     * @param  nam .
     * @param  LastName
     */
    public class Node 
    {
      int key = -1, color = BLACK ;
      Node left = nil, right = nil, parent = nil;
      int sumofmoney;
      String name ;
      String LastName;

      Node(String name,String LastName,int key,int sumofmoney)
      {
            this.name = name;
            this.LastName = LastName;
            this.key = key;
            this.sumofmoney = sumofmoney;
       } 
 }
    
     /**
     * Constructor of Linked list   
     * @param  key .
     * @param  sum of money.
     * @param  nam .
     * @param  LastName
     */
    public class Nodemin
    {	
      int id ;
      int _data;
      String name ;
      String LastName;
      public  Nodemin _next;
	  public Nodemin(String name,String LastName,int id,int _data)
	   {
		   this.name = name;
           this.LastName = LastName;
           this.id = id;
           this._data = _data;
           _next = null;  // next Linked list 
	   }
 } 
 
 /**
     * Constructor of id in Tree Node
     * @param  id .
     * @param  gold.
     */
 
 public static class TreeNode 
   {  
   int data;
   int idid;
   TreeNode left;  
   TreeNode right;  
  
   TreeNode(int data,int idid) 
   {  
    this.data = data;
    this.idid = idid;
   }  
  } 
 
    /** Constructor of Id in Tree Node for max 
     * @param  id .
     * @param  gold.
     */
   class Nodemax 
   {
    Nodemax next;
    int num;
    int id;

    public Nodemax(int val,int id) {
        num = val;
        this.id=id;
        next = null;
    }
  }
   public  Nodemax headmax; //head to max in tree node 
  
  public Nodemin _head;  // head to  Linked list
 /**
   * Constructor of head Linked list   
   * @param  head
   */
  public RedBlackTree() 
  {
	     _head = null;
  }
     
 public boolean isEmpty()
  {
	   return (_head == null);
 }
    
    
 // Get  Maximum element in binary search tree  for id
   public static TreeNode MaximumElement(TreeNode root) 
   {  
   if (root.left == null)  
    return root;  
   else {  
    return MaximumElement(root.left);  
   }  
 }  
 
  //DeleteNode node of id !!
  
   public static TreeNode deleteNode(TreeNode root, int value) {  
   if (root == null)  
   return null;  
   if (root.data < value) {  
    root.left = deleteNode(root.left, value);  
   } else if (root.data > value) {  
    root.right = deleteNode(root.right, value);  
  
    } else {  
     // if nodeToBeDeleted have both children  
     if (root.left != null && root.right != null) {  
      TreeNode temp = root;  
      // Finding minimum element from right  
      TreeNode minNodeForRight = MaximumElement(temp.right);  
      // Replacing current node with minimum node from right subtree  
      root.data = minNodeForRight.data;  
      // Deleting minimum node from right now  
      deleteNode(root.right, minNodeForRight.data);  
  
     }  
                   // if nodeToBeDeleted has only left child  
       else if (root.left != null) {  
        root = root.left;  
       }  
           // if nodeToBeDeleted has only right child  
          else if (root.right != null) {  
           root = root.right;  
             }  
                // if nodeToBeDeleted do not have child (Leaf node)  
          else  
              root = null;  
    }  
    return root;  
 }  
 
 public static TreeNode insert(TreeNode root, TreeNode nodeToBeInserted) 
 {                //   insert in node of Id for my id
  if (root == null) {  
   root = nodeToBeInserted;  
   return root;  
  }  
  
  if (root.data < nodeToBeInserted.data) {  
   if (root.left == null)  
    root.left = nodeToBeInserted;  
   else  
    insert(root.left, nodeToBeInserted);  
  } else if (root.data > nodeToBeInserted.data)  
   if (root.right == null)  
    root.right = nodeToBeInserted;  
   else  
    insert(root.right, nodeToBeInserted);  
  return root;  
 }  
 
    public static void inOrder(TreeNode root) // print in inOrder for me
    {  
     if (root == null)  
      return;  
     inOrder(root.left);  
     System.out.print(root.data + " ");  
     inOrder(root.right);  
 }  
    
 /**
     * The method will add  people to Linked list min .
     * @param name
     * @param LastName
     * @param id
     * @param data
     */
    public void addElement(String name,String LastName,int id,int _data)
    {
	          if(isEmpty())
	          {
		         _head = new  Nodemin(name,LastName, id, _data);
	          }
	     else 
	     {
		    Nodemin newNode = new Nodemin(name,LastName, id, _data);
		    newNode._next = _head;
		      _head = newNode;
	     }
     }
     
 /**
     * The method will remove  people of Linked list min .
     */ 
    public boolean removeElement(int id)
       {
	   if(isEmpty()) 
	   {
	       return false;
	   }
	    Nodemin runner = _head;
	   // If the data is in the head - we can just remove the head
	    if(runner.id == id) 
	    {
		  _head = _head._next;
		  return true;
	    }
	     // The data is not in the first node
	   else
	   {
		 Nodemin prev = _head;
		 runner = _head._next;
		 while(runner != null) 
		 {
		  if(runner.id == id) 
		  {
		    // Now the previous node points on the one after
		    // the one we removed
		    prev._next = runner._next;
		    return true;
		  }
		  runner = runner._next;
		  prev = prev._next;
		}
	     }
	   // The element we wanted to remove is not in list
	   return false;
     }
     private final Node nil = new Node("0","0",-1,0); 
     private Node root = nil;
 /**
     * The method will print Tree Red Black Treepeople of people in banke
     * @param  node
     */ 

    public void printTree(Node node) 
    {
        if (node == nil) 
        {
            return;
        }
        printTree(node.left);
        System.out.print(((node.color==RED)?"Color: Red ":"Color: Black ")+"Key: "+node.key+" Parent: "+node.parent.key+"\n");
        printTree(node.right);
    }
    
 /**
     * The method boolean
     * @param  id
     * @return false or true
     */ 
    public boolean contains(int id)
    {
	    Nodemin runner = _head ;
	      while(runner != null) 
	      {
		    if(runner.id == id)
		    {
			    return true;
		    }
		      runner = runner._next;
	    }
	         return false;
	}
	
    /**
     * The method find for Deleted
     * @param  id
     * @param  node
     * @return sum of money
     */ 
 private int findD(int id, Node node)
    {
        if (root == nil) {
            return 0;
        }
        if ( id< node.key) 
        {
            if (node.left != nil)
            {
                return findD(id, node.left);
            }
        } 
        else if (id > node.key)
        {
            if (node.right != nil) 
            {
                return findD(id, node.right);
            }
        }
        else if (id == node.key)
        {
               if(node.sumofmoney<0)
               {
                    System.out.println(" ");  // Just for  beauty
                    System.out.println("You must To put money in to bank Before you leave "+node.sumofmoney+" $"); 
                    System.out.println(" ");   // Just for  beauty
                    return node.sumofmoney;
               }
               if(node.sumofmoney>0)
                {
                     System.out.println(" ");   // Just for  beauty
                     System.out.println("You must to Take all you'r money Before you leave "+node.sumofmoney+" $");
                     System.out.println(" ");  // Just for  beauty
                     return node.sumofmoney;
                }
        }
        return 0;
    }
    
    /**
     * The method find id in my  node
     * @param  id
     * @param  node
     */ 
 private Node onlifind(int id, Node node)
    {
        if (root == nil) {
            return null;
        }

        if ( id< node.key) {
            if (node.left != nil) {
                return onlifind(id, node.left);
            }
        } else if (id > node.key) {
            if (node.right != nil) {
                return onlifind(id, node.right);
            }
        } else if (id == node.key) {
            System.out.println("Several money on account : "+node.name+" "+node.LastName+" Num-Id "+node.key+" is->> ** "+node.sumofmoney+" **");
            return node;
        }
        return null;
    }
    
    /**
     * The method find id in my  node for all RedBlackTree
     * @param  id
     * @param  node
     * @return node
     */ 
 private Node findid(int id, Node node)
     {
        if (root == nil) {
            return null;
        }

        if ( id< node.key) {
            if (node.left != nil) {
                return findid(id, node.left);
            }
        } else if (id > node.key) {
            if (node.right != nil) {
                return findid(id, node.right);
            }
        } else if (id == node.key) {
            return node;
        }
        return null;
     }
    
    /**
     * The method will print  Linked list of people in banke have min
     * 
     */ 
 public  void printList() 
      {
		Nodemin runner = _head;
		while(runner != null)
		{
			System.out.println("name " + runner.name + " gold " + runner._data + " di "+runner.id+" =>");
			runner = runner._next;
		}
        System.out.print("null");
        System.out.println("");  // Just for  beauty
	 }
    
    /**
     * The method add sum to  sum of money in for sam  customer in RedBlackTree
     * @param  id
     * @param  shum
     * @param node
     */ 
 private Node addshum(int idd,int shum ,Node node,TreeNode rootNode)
  {
        if (root == nil) 
        {
            return null;
        }
        if ( idd< node.key) {
            if (node.left != nil) {
                return addshum(idd,shum ,node.left,rootNode);
            }
        } else if (idd > node.key) {
            if (node.right != nil) {
                return addshum(idd,shum ,node.right,rootNode);
            }
        } else if (idd == node.key) {
            node.sumofmoney= node.sumofmoney+(shum);
            deleteNode(rootNode, idd);
            System.out.println(" ");
            TreeNode rootNode1 = new TreeNode(idd,node.sumofmoney); 
            insert(rootNode, rootNode1);
            delete(idd);
            insert(node.sumofmoney,idd);
          
            System.out.println(" ") ;                
            System.out.print("The Account customer is : ");
            System.out.println(node.name+" "+node.LastName+" "+node.key+" "+node.sumofmoney);
            if(node.sumofmoney<0)
            {
                 if(contains(node.key)==true)
                 {
                     removeElement(node.key);
                     addElement(node.name,node.LastName,node.key,node.sumofmoney);
                 }
                 else{
                       addElement(node.name,node.LastName,node.key,node.sumofmoney);
                     }
            }
            if(node.sumofmoney>=0)
            {
                if(contains(node.key)==true)
                {
                    removeElement(node.key);
                }
            }
            if(shum>0)
            {
              System.out.println(" ");
              System.out.println("The Customer "+node.name+" His account number is "+node.key+" put "+shum+" $");
              System.out.println(" ");
            }
            if(shum<=0)
            {
              System.out.println(" ");
              System.out.println("The Customer "+node.name+" His account number is "+node.key+" tak out "+shum+" $");
              System.out.println(" ");
            }
            return node;
        }
        return null;
    }
    
    /**
     * The method find Node for all RedBlackTree
     * @param  id
     * @param Node
     * @param Node
     */
    private Node findNode(Node findNode, Node node) {
        if (root == nil) {
            return null;
        }

        if (findNode.key < node.key) {
            if (node.left != nil) {
                return findNode(findNode, node.left);
            }
        } else if (findNode.key > node.key) {
            if (node.right != nil) {
                return findNode(findNode, node.right);
            }
        } else if (findNode.key == node.key) {
            return node;
        }
        return null;
 }
    
    /**
     * The method insert Red Black Tree
     * @param Node
     */
    private void insert(Node node) {
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
            
        } else {
            node.color = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key >= temp.key) {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixTree(node);
        }
 }
    
     /**
     * The method fix Tree
     * @param Node
     */
     private void fixTree(Node node) 
     {  //Takes as argument the newly inserted node
        while (node.parent.color == RED) {
            Node uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                } 
                if (node == node.parent.right) {
                    //Double rotation needed
                    node = node.parent;
                    rotateLeft(node);
                } 
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation 
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                 if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.color = BLACK;
 }
    
     /**
     * The method fix Tree rotate Left
     * @param Node
     */
    void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else { //Need to rotate root
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
 }
    
    /**
     * The method fix Tree rotateRight
     * @param Node
     */
    void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else { //Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
 }
 
    /**
     *  method for max tree
     * @param  val
     * @param  id
     */
 
 public RedBlackTree(int val,int id) 
    {
        headmax = new Nodemax(val,id);
    }

 public void append(int val,int id) {
        
        Nodemax tmpNode = headmax;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
        }
        tmpNode.next = new Nodemax(val,id);
    }

    /**
     * insert to max tree
     * @param  val
     * @param  id
     */   
 public void insert(int val,int id) {
        Nodemax currentNode = headmax;
        Nodemax nextNode = headmax.next;

        if (currentNode.num < val) {
            Nodemax tmpNode = headmax;
            headmax = new Nodemax(val,id);
            headmax.next = tmpNode;
            return;
        }

        if (nextNode != null && nextNode.num < val) {
            currentNode.next = new Nodemax(val,id);
            currentNode.next.next = nextNode;
            return;
        }

        while (nextNode != null && nextNode.num > val) {
            currentNode = nextNode;
            nextNode = nextNode.next;
        }

        currentNode.next = new Nodemax(val,id);
        currentNode.next.next = nextNode;
    }

    
    /**
     * Delete of max tree
     * @param  val
     * @param  id
     */   
 public void delete(int id)
    {
        Nodemax prevNode = null;
        Nodemax currNode = headmax;

        if (headmax.id == id) {
            headmax = headmax.next;
            return;
        }

        while (currNode != null && currNode.id != id) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("A node with that value does not exist.");
        }
        else {
            prevNode.next = currNode.next;
        }

    }

 public void print()
            //print node in max Tree
 {
        Nodemax tmpNode = headmax;
        while (tmpNode != null) {
            System.out.print(tmpNode.num+" , "+tmpNode.id + " -> ");
            tmpNode = tmpNode.next;
        }
        System.out.print("null");
        System.out.println(" ");
    }
    
 public void printmax()  // //print the max in nood Tree
    {
        Nodemax tmpNode = headmax;
        System.out.println(" ");
        if( tmpNode==null)
        {
            System.out.println("Sorry No max" );
        }
        else{
        System.out.print("The richest Man in my bank is: "+tmpNode.id+" He have "+tmpNode.num+" $ ");
        System.out.println(" ");
       }
       System.out.println(" " );
    }
 
 

 void deleteTree()
    {            //Deletes whole tree
        root = nil;
    }
    
    //Deletion Code .
    //This operation doesn't care about the new Node's connections
    //with previous node's left and right. The caller has to take care
    //of that.
 void transplant(Node target, Node with)
    { 
          if(target.parent == nil){
              root = with;
          }else if(target == target.parent.left){
              target.parent.left = with;
          }else
              target.parent.right = with;
          with.parent = target.parent;
    }
    
    /**
     * The method  Delete node in Tree 
     * @param Node
     */
    boolean delete(Node z)
    {
        if((z = findNode(z, root))==null)return false;
        Node x;
        Node y = z; // temporary reference y
        int y_original_color = y.color;
        
        if(z.left == nil){
            x = z.right;  
            transplant(z, z.right);  
        }else if(z.right == nil){
            x = z.left;
            transplant(z, z.left); 
        }else{
            y = treeMinimum(z.right);
            y_original_color = y.color;
            x = y.right;
            if(y.parent == z)
                x.parent = y;
            else{
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color; 
        }
        if(y_original_color==BLACK)
            deleteFixup(x);  
        return true;
 }
     
    /**
     * The method Delete fix in Tree 
     * @param Node
     */
 void deleteFixup(Node x){
        while(x!=root && x.color == BLACK){ 
            if(x == x.parent.left){
                Node w = x.parent.right;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == BLACK && w.right.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.right.color == BLACK){
                    w.left.color = BLACK;
                    w.color = RED;
                    rotateRight(w);
                    w = x.parent.right;
                }
                if(w.right.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            }else{
                Node w = x.parent.left;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == BLACK && w.left.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.left.color == BLACK){
                    w.right.color = BLACK;
                    w.color = RED;
                    rotateLeft(w);
                    w = x.parent.left;
                }
                if(w.left.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK; 
    }
    
 Node treeMinimum(Node subTreeRoot)
    {  // tree Minimum
        while(subTreeRoot.left!=nil){
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
  }
  /********************************************************************************************************************************************/
  /********************************************************************************************************************************************/
  /**                                                 The Consol OF Program                                                                  **/
  /********************************************************************************************************************************************/
 /********************************************************************************************************************************************/
 /********************************************************************************************************************************************/
 public void consoleUI()
     {    //Start of a console
       Scanner scan = new Scanner(System.in);
       Scanner y = new Scanner(System.in);
       Scanner l = new Scanner(System.in);
       String str_y;
       String str_l;
       int id;
       int shum;
       int count=0 ; //arr.length       
       Node node;
       Nodemin head ;
       headmax = new Nodemax(0,0);
       TreeNode rootNode = new TreeNode(0,0);
       while (true)
       { // Press 1-8
        System.out.println("**************************************************************************");   
        System.out.println("-If the client wants to put money in the account or take money Press 1 \n-New customer Press 2 \n-Delete customer (ID) Press 3");
        System.out.println("-Print the rich customer at the bank Press 4 "); //Print max
        System.out.println("-Checking the Balances in the customer's account (by id ) Press 5 "); 
        System.out.println("-Print all customer in Bank  Press 6 ");
        System.out.println("-Printing all customers With Negative balance in Bank Press 7 ");
        System.out.println("- * Delete all tree all customer Press 8 * ");
        System.out.println("**************************************************************************"); 
        System.out.println(" ");  // Just for  beauty
        int choice = scan.nextInt();
        switch (choice) 
        {   // num choice = 1 of case .
          case 1:
          System.out.println(" ");  // Just for  beauty
          System.out.println("Insert your ID");
          id = scan.nextInt();
         if((findid(id, root))== null)
         {
             System.out.println("-------------------------");
             System.out.println("-Id Does not exist sorry ");
             System.out.println("-------------------------");
             System.out.println(" ");  // Just for  beauty
             break;
         }
         System.out.println(" ");
         System.out.println("If the client wants to spend money from the account (Add a minus(-) before )");
         System.out.println("if you want to put money to account Enter the desired amount of money (only int()) ") ;
         shum = scan.nextInt();
         System.out.println(" ");  // Just for  beauty
         addshum(id,shum ,root, rootNode);
         break;
         case 2:
         System.out.println(" ");  // Just for  beauty
         System.out.println("Insert a new customer ");
         System.out.println("Insert name ");
         str_y=y.nextLine();
         System.out.println("Insert LastName ");
         str_l=l.nextLine();
         System.out.println("Insert id --> (id >1000000) and (id <9999999)");
         id = scan.nextInt();
         while ((id<1000000)||(id>9999999)) // you'r id need be > 1000000 and < 9999999
          {
            System.out.println("Insert Correct id!! (id >1000000) and (id <9999999)");
            id = scan.nextInt();
         }
         System.out.println("Enter the desired amount of money , money need to be >=0 ");
         shum = scan.nextInt();
         while( shum <(0)) // money > 0
         {
            System.out.println("Enter the desired amount of money , money need to be >=0");
            shum = scan.nextInt();
            
         }
         node = new Node(str_y,str_l,id,shum);
         
         if((findNode(node, root))== null)
         {
           insert(node);
           count=count+1;
           System.out.println(" ");   // Just for  beauty
           System.out.print("+ New Client is Added: ");
           System.out.println(str_y+" "+str_l+" "+id+" "+id+" "+shum); // Customer number equal to the number of his identity
           printTree(root);
           System.out.println(" ");   // Just for  beauty
           insert(shum,id);
           if(count==0)
           {
            TreeNode rootNode1 = new TreeNode(id,shum) ; 
            insert(null, rootNode);
               
           }
           
           else
           {
             TreeNode rootNode1 = new TreeNode(id,shum); 
             insert(rootNode, rootNode1);
               
           }
           
           System.out.println(" ");
           break;
         }
         
         else  // id not exists   
         {
             System.out.println("Id is already exists  !! sorry ");
             System.out.println(" ");     // Just for  beauty
             break;
         }
         case 3:
         System.out.println("Enter the ID of the customer who wants to leave : ");
         id = scan.nextInt();
         node = new Node("0","0",id,0);
         if((findNode(node, root))== null)
         {             // id not exists
             System.out.println(" ");      // Just for  beauty
             System.out.print("this ID not exist ! Sorry ! ");
             System.out.println(" ");     // Just for  beauty
             break; 
         }
         else
         {
            while((findD( id,root))!=0) //while you dont have 0 in banke
            {
               System.out.println(" ");     // Just for  beauty
               System.out.println("if you want to put money to account Enter the desired amount of money  ") ;
               System.out.println("if you wants to spend money from the account (Add a minus(-) before ) ");
               System.out.println(" ");    // Just for  beauty
               shum = scan.nextInt();
               System.out.println(" ");  // Just for  beauty
               addshum(id,shum ,root,rootNode); 
           }
            if (delete(node)) // delete nude in tree
            {
               System.out.print("- "+id+" The id ( Account) is delete...  Goodbye :( ");
               System.out.println(" ");
               deleteNode(rootNode, id);
               System.out.println(" ");     
               System.out.println(" ");    // Just for  beauty
               System.out.println(" ");  // Just for  beauty
               count=count-1;
               delete( id);
              break;
            } 
             else
            { // id not exists
               System.out.println(" ");   // Just for  beauty
               System.out.print("this ID not exist! ");
               System.out.println(" ");  // Just for  beauty
              break;
           }
         }

         case 4: 
         printmax();    // o(1)
         break;
         case 5:
         System.out.println("Insert your ID");
         id = scan.nextInt();
         System.out.println(" ");  // Just for  beauty
         System.out.println((onlifind(id,root) != null) ? " ----> found <-----" : " not exist sorry!!");
         System.out.println(" ");  // Just for  beauty
         break;
         case 6:
         System.out.println(" ");  // Just for  beauty
         System.out.println("Num of customer in My bank is->> "+count);
         System.out.println(" ");  // Just for  beauty
         break;
         case 7:
         System.out.println(" "); // Just for  beauty
         printList();      //  print  Linked list  min
         System.out.println(" ");   // Just for  beauty
         break;
         
         case 8:  // Deleted all Tree and Linked list 
         System.out.println(" ");  // Just for  beauty
         deleteTree();
         System.out.println("Tree Deleted!");
         System.out.println(" ");  // Just for  beauty
         count=0;
         _head = null ;
         rootNode=null;
         rootNode = new TreeNode(0,0);
         headmax=null ;
         headmax = new Nodemax(0,0);
         break;
         default : 
         System.out.println("Wrong Entry sorry!! (Press 1-7)\n ");
         
         break;
         
         }
       }
 }// End of console
  /********************************************************************************************************************************************/
  /********************************************************************************************************************************************/
  /**                                                        Main OF Program                                                                 **/
  /********************************************************************************************************************************************/

 public static void main(String[] args) 
       {
        RedBlackTree rbt = new RedBlackTree();
        rbt.consoleUI();
  }
 /********************************************************************************************************************************************/
 /********************************************************************************************************************************************/
  
} //End of program