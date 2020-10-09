package btree;

public class BTree<T extends Comparable<T>> {

	private static class Node<T> {

		public T data;
		public Node<T> left;
		public Node<T> right;

		public Node(T d) {
			this.data = d;
		}

	}

	// fields for btree
	private Node<T> root;
	private int n;

	public BTree() {
		this.root = null;
		this.n = 0;
	}

	// Public method to insert an item to the binary tree
	public void insert(T d) {
		this.root = insert(this.root, d);
		this.n++;
	}

	// Helper method to insert an item to the binary tree
	private Node<T> insert(Node<T> node, T d) {
		if (node == null)
			node = new Node<>(d);
		else if (d.compareTo(node.data) < 0)
			node.left = insert(node.left, d);
		else if (d.compareTo(node.data) > 0)
			node.right = insert(node.right, d);
		return node;
	}

	// Public method to remove an item from the binary tree
	public boolean remove(T d) {
		if (!contains(d))
			return false;
		this.root = remove(this.root, d);
		return true;
	}

	// Helper method to remove an item from the binary tree
	private Node<T> remove(Node<T> node, T d) {
		if (d.compareTo(node.data) < 0) // node.data > d
			node.left = remove(node.left, d);

		else if (d.compareTo(node.data) > 0) // node.data < d
			node.right = remove(node.right, d);
		
		else { // node found
			if (isLeaf(node)) // leaf node is easiy removed
				node = null;

			else if (isRightRooted(node)) { // if node only has right child
				Node<T> rightChild = node.right;
				node = null;
				return rightChild;
			}
			else if (isLeftRooted(node)) { // if node only has left child
				Node<T> leftChild = node.left;
				node = null;
				return leftChild;
			}
			else { // node has both left and right child
				Node<T> successor = successor(node);
				node.data =  successor.data; // replace node with its sucessor
				node.right = remove(node.right, successor.data); // remove sucessor
			}
		}
		return node;
	}

	// Helper method to check if a given node is a leaf node
	private boolean isLeaf(Node<T> node) {
		return (node.left == null && node.right == null);
	}
	
	// Helper method to check if a given node only has left child
	private boolean isLeftRooted(Node<T> node) {
		return (node.left != null && node.right == null);
	}
	
	// Helper method to check if a given node only has right child
	private boolean isRightRooted(Node<T> node) {
		return (node.left == null && node.right != null);
	}
	
	// Helper method to find the sucessor of a node
	private Node<T> successor(Node<T> node){
		Node<T> temp = node.right;
		while (!isLeaf(temp))
			temp = temp.left;
		return temp;
	}
	
	// Public method to check if an item exists in the binary tree
	public boolean contains(T d) {
		return contains(this.root, d);
	}

	private boolean contains(Node<T> node, T d) {
		if (this.root == node)
			System.out.print("Root ");
		if (node == null) {
			System.out.println(	"Given node is null");
			return false;	
		}
		if (d.compareTo(node.data) < 0) {
//			System.out.println("Searching on the left of " + node.data);
			System.out.print("Left ");
			return contains(node.left, d);			
		}
		else if (d.compareTo(node.data) > 0) {
//			System.out.println("Searching on the right of " + node.data);
			System.out.print("Right ");
			return contains(node.right, d);
		}
		else
			return node.data.equals(d);
	}

	public static void main(String[] args) {
		System.out.println("Testing for binary tree");
		BTree<Integer> tree = new BTree<>();
		tree.insert(7);
		tree.insert(5);
		tree.insert(9);
		tree.insert(4);
		tree.insert(6);
		tree.insert(2);
		tree.insert(10);
		tree.insert(30);
		tree.insert(0);
		tree.insert(16);
		System.out.println("\nContains 16?: " + tree.contains(16));
		System.out.println("Done testing!");
	}
}
