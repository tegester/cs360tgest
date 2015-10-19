import java.util.Objects;

//similar to LinkedList gone over in cs260, but generic implementation 
//no removal required for this project 
//toString() requires all objects in the list to be cast-able to string 
public class LinkedList <T> {
	//pointer node
	private Node<T> head = new Node<T>(null,null);
	private int size;
	private Node<T> cur;

//Class<T> c
	public  LinkedList() {
		//make list circular 
		head.next = head;
		cur = head;
		size = 0;
	}
	
	//add a new node 
	public void add(T data){
		head.next = head.addNode(data);
		size++;
	}

	//look for the same object in the list
	public Boolean contains(T data){
		for(Node<T> n = head.next; n != head; n = n.next){
			//needs to be objects.equals() due to generic implementation and issues with string and '=='
			if(Objects.equals(data, n.data)){
				return true;
			}
		}
		return false;
	}
	
	//calls toString() of the data
	public String toString(){
		String st = "";
		for(Node<T> n = head.next; n != head; n = n.next){
			st = st+ n.data +"\n";
		}
		return st;
	}

	//need to call newWalk() before looking for object 
	public void newWalk(){
		cur = head;
	}

	//checks if there is a next node to the current walk
	public Boolean isNext(){
		if(head != this.cur.next){
			return true;
		}
		else{
			return false;
		}
	}
	// returns the next node on a walk (user should check if there is one before calling nextNode()
	public T nextNode(){
		cur = cur.next;
		return cur.data;
	}
	
	//checks to see if any node has been added to the list 
	public Boolean isList(){
		if(size >0){
			return true;
		}
		else{
			return false;
		}
	}
	
	//node for the linked list
	private class Node <K> {
		Node<K> next;
		K data;
 
        // Node constructor
        public Node(K newData, Node<K> next) {
            this.next = next;
            this.data = newData;
        }
        
        //adds node to the front of the list
        public Node<K> addNode (K newData){
            Node<K> newNode = new Node<K>(newData, this.next);
            return newNode;
        } 
	}
}
