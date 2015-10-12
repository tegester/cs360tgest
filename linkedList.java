import java.util.Objects;

//Similar to  linked list gone over in cs260 
//no remove required
//to string requires all objects to be strings 
public class LinkedList <T> {
	private Node<T> head = new Node<T>(null,null);
	private int size;
	private Node<T> cur;

//Class<T> c
	public  LinkedList() {
		head.next = head;
		cur = head;
		size = 0;
	}
	
	public void add(T data){
		head.next = head.addNode(data);
		size++;
	}

	public Boolean contains(T data){
		for(Node<T> n = head.next; n != head; n = n.next){
			if(Objects.equals(data, n.data)){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		String st = "";
		for(Node<T> n = head.next; n != head; n = n.next){
			st = st+ n.data +"\n";
		}
		return st;
	}

	public void newWalk(){
		cur = head;
	}

	public Boolean isNext(){
		if(head != this.cur.next){
			return true;
		}
		else{
			return false;
		}
	}
	public T nextNode(){
		cur = cur.next;
		return cur.data;
	}
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
        
        public Node<K> addNode (K newData){
            Node<K> newNode = new Node<K>(newData, this.next);
            return newNode;
        } 
	}
}
