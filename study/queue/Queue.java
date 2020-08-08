/**
 * @author Roshan Poudel
 * Queue class is the implementation of Queue DS using 
 * Singly Linked List
 */
public class Queue<E>{
    

    /**
     * Node class is used to store data in singly linked list
     */
    private static class Node<E>{

	private E data;
	private Node<E> next;

	public Node(E data, Node<E> next){
	    this.data = data;
	    this.next = next;
	}
    }

    // Fields for Queue
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs an empty queue
     * using singly linked list as underlying data structure
     */
    public Queue(){
	this.head = null;
	this.tail = null;
	this.size = 0;
    }

    
    /**
     * Adds an item to the front of the queue
     * by adding it to the end of the singly linked list
     */
    public void enqueue(E data){
	Node<E> temp = new Node<>(data, null);
	if (this.size == 0){
	    this.head = temp;
	    this.tail = temp;
	}
	else {
	    this.tail.next = temp;
	    this.tail = temp;
	}
	this.size += 1;
    }


    /** 
     * Removes an item from the end of the queue
     * by removing it from the front of the singly linked list
     */
    public E dequeue(){
	if (this.size == 0)
	    throw new IllegalStateException("Cannot Dequeue: Queue is Empty");
	E temp = this.head.data;
	this.head = this.head.next;
	this.size -= 1;
	return temp;	
    }


    /** 
     * Returns the size of the queue
     */
    public int size(){
	return this.size;
    }

    /**
     * Returns whether the queue is empty or not
     */
    public boolean isEmpty(){
	return this.size == 0;
    }

    /**
     * Returns the string version of queue for printing
     */
    public String toString(){
	String temp = "";
	Node<E> node = this.head;
	while (node != null){
	    temp += node.data + " ";
	    node = node.next;
	}
	return temp;
    }
	  
    public static void main(String [] args){
	Queue<Integer> q = new Queue<>();
	for (int i = 0; i < 10; i++){
	    q.enqueue(i+10);
	    System.out.println(q);
	}
	System.out.println("Is Queue empty?: " + q.isEmpty());
	System.out.println("Size: " + q.size());
	for (int i = 0; i < 10; i++){
	    q.dequeue();
	    System.out.println(q);
	}
	System.out.println("Is Queue empty?: " + q.isEmpty());
	System.out.println(q.dequeue());
    }
	    
    

}
    
