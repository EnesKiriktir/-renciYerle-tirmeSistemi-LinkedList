
public class SingleLinkedList {

	NodeSingleLinkedList head;

	public void add(Object data) {// this method adds a student into the single linked list.
		if (head == null) { 
			NodeSingleLinkedList newNode = new NodeSingleLinkedList(data);
			head = newNode;

		} else {
			NodeSingleLinkedList temp = head;
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			NodeSingleLinkedList newNode = new NodeSingleLinkedList(data);
			temp.setLink(newNode);
		}
	}

	public int size() { // this method gives us the size of single linked list.
		if (head == null)
			return 0;
		else {
			int count = 0;// for calculating size
			NodeSingleLinkedList temp = head;
			while (temp != null) {
				temp = temp.getLink();
				count++;
			}
			return count;

		}
	}

	public void display() { // this method displays a single linked list's data.
		if (head == null)
			System.out.println("List is empty");
		else {
			NodeSingleLinkedList temp = head;
			while (temp != null) {
				System.out.println(temp.getData());
				temp = temp.getLink();
			}
		}
	}
}
