

public class NodeSingleLinkedList {
	private Object data;
	private NodeSingleLinkedList link;
	
	public NodeSingleLinkedList(Object dataToAdd) {
		data = dataToAdd;
		link = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public NodeSingleLinkedList getLink() {
		return link;
	}

	public void setLink(NodeSingleLinkedList link) {
		this.link = link;
	}
	

}
