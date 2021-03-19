
public class NodeDoubleLinkedList {

	private Object data;
	private NodeDoubleLinkedList prev;
	private NodeDoubleLinkedList next;

	public NodeDoubleLinkedList (Object data) {
		
		this.data = data;
		prev=null;
		next=null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public NodeDoubleLinkedList getPrev() {
		return prev;
	}

	public void setPrev(NodeDoubleLinkedList prev) {
		this.prev = prev;
	}

	public NodeDoubleLinkedList getNext() {
		return next;
	}

	public void setNext(NodeDoubleLinkedList next) {
		this.next = next;
	}
	
	
	
}
