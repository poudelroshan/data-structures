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
		insert(this.root, d);
	}

	// Helper method to insert an item to the binary tree
	private void insert(Node<T> node, T d) {
		if (node == null)
			node = new Node<>(d);
		else if (d.compareTo(node.data) < 0)
			insert(node.left, d);
		else if (d.compareTo(node.data) > 0)
			insert(node.right, d);
		this.n++;
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
				Node<T> successor = Sucessor(node);
				node =  successor.data; // replace node with its sucessor
				node.right = remove(node.right, sucessor.data); // remove sucessor
			}
		}
		return node;
	}

	public boolean contains(T d) {
		return contains(this.root, d);
	}

	private boolean contains(Node<T> node, T d) {
		if (node == null)
			return false;
		if (d.compareTo(node.data) < 0)
			return contains(node.left, d);
		else
			return contains(node.right, d);
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
		System.out.println("Done testing!");
	}
}
