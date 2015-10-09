import java.util.Objects;

//Similar to  linked list gone over in cs260 
//no remove required
//to string requires all objects to be strings 
public class linkedList <T> {
	private Node<T> head;
	private Node<T> tail;
	private int count;
	Node<T> current;

	public linkedList() {
		head = new Node<T>(null);
		current = head;
		tail = head;
		count =0;
	}
	public void add(T data){
		Node<T> temp = new Node<T> (data);
		tail.setN(temp);
		tail = temp;
		count++;
	}

	public Boolean contains(T data){
		Node<T> cur = head.nextN();
		for(int i = 0;i<count-1;i++){
			if(Objects.equals(cur.getData(), data)){
				return true;
			} 
			cur = cur.nextN();
		}		
		return false;
	}	

	public void newWalk(){
		current = head;
	}
	public Boolean isNext(){
		if(null != current.nextN()){
			return true;
		}
		else{
			return false;
		}
	}
	public T nextNode(){
		current =current.nextN();
		return current.data;
	}
	
	//node for the linked list
	private class Node <T> {
		private Node<T> next;
		private T data;
 
        // Node constructor
        public Node(T newData) {
            next = null;
            data = newData;
        }
        //Required methods for node
        public T getData(){
        	return data;
        }
        public Node<T> nextN(){
        	return next;
        }
        public void setN (Node<T> newN){
        	next = newN;
        }
	}
}
