public class ArrayList<T>{

    private T[] arr;
    private static int capacity = 10;
    private static int size;

    // Constructor
    @SuppressWarnings("unchecked")
    public ArrayList(){
	arr = (T[]) new Object[capacity];
	size = 0;
    }

    // Add e to the end of the array
    public boolean add(T e){

	if (size < capacity){
	    arr[size] = e;
	}
	else {
	    capacity *= 2;
	    arr = copyArray();
	    arr[size] = e;
	}
	size++;
	return true;
    }

    // copies the content of the current array to a new array and returns it
    @SuppressWarnings("unchecked")
    private T[] copyArray(){
	T[] temp = (T[]) new Object[capacity];
	for (int i = 0; i < size; i++){
	    temp[i] = arr[i];
	}
	return temp;
    }

    // Deletes the element at index i
    public T remove(int j){
	T temp = arr[j];
	for (int i = j; i < size - 1; i++){
	    arr[i] = arr[i + 1];
	}
	arr[j] = null;
	size--;

	if (size < capacity / 2){
	    capacity /= 2;
	    arr = copyArray();
	}
	return temp;
    }

    // Returns the size of the array
    public int size(){
	return size;
    }
	

    // Returns the array in string form for printing
    public String toString(){
	if (this.size == 0)
	    return "[]";
	String toSend = "[";
	for (int i = 0; i < size - 1; i++){
	    toSend += arr[i] + ", ";
	}
	toSend += arr[size - 1] + "]";
	return toSend;
    }

    // Testing
    public static void main(String[] args){
	ArrayList<Integer> arr = new ArrayList<>();
	// Testing dynamic increase of size
	for (int i = 0; i < 100; i++){
	    arr.add(i);
	    System.out.println(arr);
	}
	

	for (int i = 0; i < 100; i++){
	    arr.remove(arr.size() - 1);
	    System.out.println(arr);
	    System.out.println(arr.size());
		    
	}   
	
    }
}

