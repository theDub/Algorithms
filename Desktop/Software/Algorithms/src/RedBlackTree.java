/**
 * Lab 2: Debugging with Eclipse and Red Black Tree) <br />
 * The {@code RedBlackTree} class of integers only <br />
 * Reference: <a href="https://en.wikipedia.org/wiki/Red%E2%80%93black_tree">
 *              https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
 *            </a>
 */
public class RedBlackTree {

    /**
     * Root node of the red black tree
     */
    private Node root = null;
    /**
     * Size of the tree
     */
    private int size = 0;

    /**
     * Search the tree to find if the value is contained
     * @param value     {@code int} the value to be checked
     * @return          {@code boolean} If contains, return {@code true}, otherwise return {@code false}
     */
    public boolean contains(int value) {
        // TODO: Lab 2 Part 2-1 -- find an integer from the tree
    	Node temp = this.root;
    	while(true){
    		if(temp.value == null || temp==null) return false;
    		if(temp.value == value) return true;
    		else if (value<temp.value) {
    			temp = temp.lChild;
    		} else {
    			temp = temp.rChild;
    		}
    		return false;
    	}
    }

    /**
     * Insert an integer to the tree
     * @param data      {@code int} New element to be inserted
     */
    public void insert(int value) {
    	System.out.println(value);
    	Node insert = new Node(value);
    	if(this.root == null) {
    		this.root = insert;
    		return;
    	}
    	Node current = this.root;
    	Node parent = null;
    	while(true){
    		parent = current;
    		if(current.value!=null && value<current.value){
    			current = current.lChild;
    			if(current == null) {
    				parent.lChild = insert;
    				return;
    			}
    		} else { 
    			current = current.rChild;
    			if(current==null) {
    				parent.rChild = insert;
    				return;
    			}
    			
    		}
    	}
    }

    /**
     * Get the size of the tree
     * @return          {@code int} size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Cast the tree into a string
     * @return          {@code String} Printed format of the tree
     */
    @Override public String toString() {
        // TODO: Lab 2 Part 2-3 -- print the tree, where each node contains both value and color
        // You can print it by in-order traversal

        return null;
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(30);
        rbt.insert(10);

        System.out.println(rbt.contains(10));
        for (int i = 0; i < 100; i++)
            rbt.insert((int) (Math.random() * 200));

        System.out.println(rbt.contains(30));
       // assert rbt.root.color == RedBlackTree.Node.BLACK;
        System.out.println(rbt.root);           // This helps to figure out the tree structure
        System.out.println(rbt.root.value);
    }


    /**
     * The {@code Node} class for {@code RedBlackTree}
     */
    public class Node {
        public static final boolean BLACK = true;
        public static final boolean RED = false;

        public Integer value;
        public boolean color = BLACK;
        public Node parent = null, lChild = null, rChild = null;

        public Node(Integer value) {             // By default, a new node is black with two NIL children
            this.value = value;
            if (value != null) {
                lChild = new Node(null);         // And the NIL children are both black
                lChild.parent = this;
                rChild = new Node(null);
                rChild.parent = this;
            }
        }

        /**
         * Print the tree node: red node wrapped by "<>"; black node by "[]"
         * @return          {@code String} The printed string of the tree node
         */
        @Override public String toString() {
            if (value == null)
                return "";
            return (color == RED) ? "<" + value + ">" : "[" + value + "]";
        }
    }

}
