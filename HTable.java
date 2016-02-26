/*
 * This class will only hold the binary tree that will be used with the hashtable
 */
package hashtablelab2;

public class HTable {

    public Node[] HashArray; // initializes an array of nodes
    public Node HNode; // initializes a node
    public Node Blah = new Node(0);
    
    public HTable(int maxSize) {
        HashArray = new Node[maxSize]; // creates a node called HNode
    } // ends HTable()

    public void insert(Node n) {

       // System.out.println("Value of n: " + n.value);
        //System.out.println("Hash Array Length: " + HashArray.length);
        int hash = n.value % HashArray.length; // calls hash index.
        //System.out.println("Result hash value: " + hash);
        
        if (HashArray[hash] == null) {
            Node x = new Node(n.value); // makes new node.
            insertBinaryTree(hash, x);
        } else {
            insertBinaryTree(hash, n);
        } // end else
    } // end insert ()

    public void insertBinaryTree(int root, Node insert) {
        //System.out.println("Current Hash Position " + root);
        
        if (HashArray[root] == null) {
            HashArray[root] = insert;
        } // ends null insert
        if (HashArray[root].value == insert.value) {
            HashArray[root] = insert;
        } else {
            if (HashArray[root].value > insert.value) {
                if (HashArray[root].leftChild == null) {
                    HashArray[root].leftChild = insert;
                } else {
                    boolean finished = false;
                    Node traversal = HashArray[root].leftChild;
                    while(!finished){
                        if(insert.value < traversal.value){
                            if (traversal.leftChild == null){
                                traversal.leftChild = insert;
                                finished = true;
                            }else{
                                traversal = traversal.leftChild;
                            }
                        }else if(insert.value > traversal.value){
                            if (traversal.rightChild == null){
                                traversal.rightChild = insert;
                                finished = true;
                            }else{
                                traversal = traversal.rightChild;
                            }
                        }
                    }
                } // ends left else
            } // ends left if 
            if (HashArray[root].value < insert.value) {
                if (HashArray[root].rightChild == null) {
                    HashArray[root].rightChild = insert;
                } else {
                    
                    boolean finished = false;
                    Node traversal = HashArray[root].rightChild;
                    while(!finished){
                        if(insert.value < traversal.value){
                            if (traversal.leftChild == null){
                                traversal.leftChild = insert;
                                finished = true;
                            }else{
                                traversal = traversal.leftChild;
                            }
                        }else if(insert.value > traversal.value){
                            if (traversal.rightChild == null){
                                traversal.rightChild = insert;
                                finished = true;
                            }else{
                                traversal = traversal.rightChild;
                            }
                        }
                    }

                } // ends right else

            } // ends right if

        } // ends left else

    } // End insertBinarytree ()

    public boolean find(int i) // command for menu to find a node in the tree.
    {

        int hash = i % HashArray.length;
        
        if (hash >= HashArray.length)
        {
        System.out.println("Error. Hash value is " + hash + " Maximum length is " + HashArray.length);
        }
        
        return FindNode(HashArray[hash], i);

    } // end find()

    public boolean FindNode(Node NodeValue, int i) {
        if (NodeValue != null) {
            if (NodeValue.value == i) {
                System.out.println(i + " was found!");
                return true;
            } else { // searching the whole tree...

                if (NodeValue.value > i) {
                   return FindNode(NodeValue.leftChild,i);
                } else {
                    return FindNode (NodeValue.rightChild,i);
                } // end else 2
            } //end else 1
        } // end if
        System.out.println(i + " was not found.");
        return false;

    } // end FindNode()
    
    public void inOrder(Node x) // inOrder traversal
    {
        if (x != null) {
            inOrder(x.leftChild);
            System.out.print(x.value + " ");
            inOrder(x.rightChild);

        } // end if
    } // end inOrder()
    
    // public show
    
    
    public void show_HTable(){
        
        for(int i = 0; i < HashArray.length; i++){
            System.out.print(i + ": ");
            inOrder(HashArray[i]);
            System.out.println();
        } // end for
        
    } // end show()
    

// public delete

} // end class HTable 
