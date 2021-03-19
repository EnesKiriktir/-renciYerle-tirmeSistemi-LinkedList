
public class DoubleLinkedList {
	private NodeDoubleLinkedList head;
	private NodeDoubleLinkedList tail;

	public DoubleLinkedList() 
	{
		head=null;
		tail=null;
	}
	
	public void add(Student student) {// this method adds the student into doublelinked list sequentially.
		if(head == null && tail ==null) {
			NodeDoubleLinkedList  newNode = new NodeDoubleLinkedList (student);
			head = newNode;
			tail = newNode;
		}
		else {
			NodeDoubleLinkedList newnode = new NodeDoubleLinkedList (student);
			NodeDoubleLinkedList temp = head;
				/////// firstly head and newnode are compared (line 25-49).
					if(student.getGrade()>((Student)head.getData()).getGrade()) {
						newnode.setNext(head);
						head.setPrev(newnode);
						head = newnode;
					}
					else if (student.getGrade()==((Student)head.getData()).getGrade()) {
						if(student.getSchooldiplomagrade()> ((Student)head.getData()).getSchooldiplomagrade()) {
							newnode.setNext(head);
							head.setPrev(newnode);
							head = newnode;
						}
						else if(student.getSchooldiplomagrade()<((Student)head.getData()).getSchooldiplomagrade()) {
							newnode.setPrev(head);
							head.setNext(newnode);
							tail = newnode;
						}
						else {	
							newnode.setNext(head);
							head.setPrev(newnode);
							head = newnode;
						}
					}
					else  {
						 temp = head;	
						while(temp.getNext()!=null && student.getGrade() <=((Student)temp.getNext().getData()).getGrade()) {//this loop finds the place.
							if(student.getGrade() ==((Student)temp.getNext().getData()).getGrade())
							{
								if(student.getSchooldiplomagrade()>((Student)temp.getNext().getData()).getSchooldiplomagrade() ) 
								{
									break;
									}																						
							}						
						temp = temp.getNext();				
						}
						newnode.setPrev(temp);						
						if(temp.getNext()!=null) {
							newnode.setNext(temp.getNext());	
							temp.getNext().setPrev(newnode);
						}
						else {
							newnode.setNext(null);
							tail = newnode;
						}		
						temp.setNext(newnode);
					}
				}
		}


	public void display5() {//this method shows the top 5 students ordered by their exam scores.
		int x =0;
		if (head==null)
			System.out.println("There is no student in the list.");
		else {
			NodeDoubleLinkedList temp=head;
			for (int i = 0; i < 5; i++) {
				x = ((Student)temp.getData()).getGrade();
				System.out.println(x+" " +((Student)temp.getData()).getSchooldiplomagrade()+"  " +((Student)temp.getData()).getName());
				temp=temp.getNext();
			}	
		}		
	}
	public void displayAll() {// this method shows the all students.
		if (head==null)
			System.out.println("Linked is empty.");
		else {
			NodeDoubleLinkedList temp=head;
			while (temp!=null) {
				int x =0;
				x = ((Student)temp.getData()).getGrade();
				System.out.println(x+" " +((Student)temp.getData()).getSchooldiplomagrade()+"  " +((Student)temp.getData()).getName());
				temp=temp.getNext();						
			}
			System.out.println();
		}
	}	

	public int size() {// this method gives us the size of double linked list.
		int count=0;
		if (head==null)
			System.out.println("Linked is empty.");
		else 
		{
			NodeDoubleLinkedList temp=head;
			while (temp!=null) {
				count++;
				temp=temp.getNext();
			}
		}
		return count;
	}

	public NodeDoubleLinkedList getHead() {
		return head;
	}

	public void setHead(NodeDoubleLinkedList head) {
		this.head = head;
	}

	public NodeDoubleLinkedList getTail() {
		return tail;
	}

	public void setTail(NodeDoubleLinkedList tail) {
		this.tail = tail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


