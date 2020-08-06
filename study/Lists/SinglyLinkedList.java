public class SinglyLinkedList<E>{

    // --------------Nested Node class----------------------
    private static class Node<E>{
	private E e;
	private Node<E> next;

	public Node(E e, Node<E> next){
	    this.e = e;
	    this.next = next;
	}

	public E getElement(){
	    return this.e;
	}

	public Node<E> getNext(){
	    return this.next;

	}

	public void setNext(Node<E> next){
	    this.next = next;
	}
		
    }
    // --------------End of Nested Node class----------------------

    // State variables
    private Node<E> head;
    private int size;

    // Constructor
    public SinglyLinkedList(){
	size = 0;
    }

    // returns the size of the linked list
    public int size(){
	return this.size;
    }

    // returns true if linked list is empty
    public boolean isEmpty(){
	return this.size == 0;
    }

    // adds element to the beginning of the list
    public void addFirst(E e){
	head = new Node<>(e, head);
	this.size++;
    }

    // adds element to the end of the list
    public void addLast(E e){
	if (head == null)
	    head = new Node<>(e, head);
	else{
	    Node<E> t = head;
	    for(; t.next != null; t = t.next)
		; // do nothing
	    t.next = new Node<>(e, t.next);
	}
	this.size++;
    }

    // Removes the first item
    public E removeFirst(){
	if (size == 0)
	    return null;
	E temp = head.e;
	head = head.next;
	size--;
	return temp;
    }

    // Removes the Last item
    public E removeLast(){
	E temp;
	if (size == 0)
	    return null;
	else if (size == 1){
	    temp = head.e;
	    head = null;
	}
	else{
	    Node<E> n = head;
	    for (; n.next.next != null; n = n.next)
		; // Do nothing
	    temp = n.next.e;
	    n.next = null;
	}
	size--;
	return temp;
    }
    
    // returns a String to print linked list
    public String toString(){
	if (size == 0)
	    return "Head -> Null";
	String temp = "Head -> ";
	Node<E> n = head;
	for (; n != null; n = n.next)
	    temp += n.e + " -> ";
	temp += "Null";
	return temp;
    }

    // Test the methods
    public static void main(String[] args){
	SinglyLinkedList<String> list = new SinglyLinkedList<>();
	System.out.println(list);

	// Add items to the list
	for (int i = 0; i < 10; i++){
	    list.addLast("Item: " + i);
	    System.out.println(list);
	}

	// Remove items from the list
	for (int i = 0; i < 5; i++){
	    list.removeFirst();
	    System.out.println(list);
	    list.removeLast();
	    System.out.println(list);
	}

    }
}
	    


