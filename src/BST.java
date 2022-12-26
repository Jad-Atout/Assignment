

import java.util.Stack;

public class BST<T extends Comparable<T>> {


    private int nodeCount = 0;


    private Node node = null;


    public boolean isEmpty() {
        return size() == 0;
    }

    public enum TreeTraversalOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }


    public int size() {
        return nodeCount;
    }

    public boolean add(T elem) {


        if (contains(elem)) {
            return false;

        } else {
            node = add(node, elem);
            nodeCount++;
            return true;
        }
    }


    private Node add(Node node, T elem) {

        // Base case: found a leaf node
        if (node == null) {
            node = new Node(null, null, elem);

        } else {
            // Pick a subtree to insert element
            if (elem.compareTo(node.data) < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }

        return node;
    }

    public boolean remove(T elem) {


        if (contains(elem)) {
            node = remove(node, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {

        if (node == null) return null;

        int cmp = elem.compareTo(node.data);


        if (cmp < 0) {
            node.left = remove(node.left, elem);

        } else if (cmp > 0) {
            node.right = remove(node.right, elem);

        } else {
            if (node.left == null) {

                Node rightChild = node.right;

                node.data = null;
                node = null;

                return rightChild;

            } else if (node.right == null) {

                Node leftChild = node.left;

                node.data = null;
                node = null;

                return leftChild;


            } else {


                Node tmp = findMin(node.right);


                node.data = tmp.data;


                node.right = remove(node.right, tmp.data);


            }
        }

        return node;
    }


    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }


  /*  private Node findMax(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }*/


    public boolean contains(T elem) {
        return contains(node, elem);
    }


    private boolean contains(Node node, T elem) {


        if (node == null) return false;

        int cmp = elem.compareTo(node.data);

        if (cmp < 0) return contains(node.left, elem);

        else if (cmp > 0) return contains(node.right, elem);


        else return true;
    }
   /* private Node getNode(Node node, T elem) {


        if (node == null) return null;

        int cmp = elem.compareTo(node.data);

        if(cmp == 0){
            return node;
        }else if (cmp < 0){
             contains(node.left, elem);
        }else if (cmp > 0) {
            contains(node.right, elem);
        }
        return null;
    }*/


    public int height() {
        return height(node);
    }


    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public boolean update(T oldValue, T newValue){
       Node node = remove(this.node,oldValue);
       if(node == null) return false;
       else return  add(newValue);
    }



    public void traverse() {
        inOrderTraversal(node);

    }



    private void inOrderTraversal(Node node) {
        if (this.node == null)
            return;


        Stack<Node> s = new Stack<Node>();
        Node curr = this.node;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {

            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.data + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
        System.out.println();
    }
    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }
}


