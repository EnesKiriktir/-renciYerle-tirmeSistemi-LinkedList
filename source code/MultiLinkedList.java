
public class MultiLinkedList {
	private DepartmentNode head;
	
	public MultiLinkedList() {
		head = null;
	}

	public void addStudents(DoubleLinkedList dlist) { // this method adds students in multilinked list

		if (head == null) {
			System.out.println("Add a course before Student");
		}
		else {
			
			NodeDoubleLinkedList temp = dlist.getHead();
			DepartmentNode tempDep = this.head;
			while(temp.getNext()!=null) {//For per student this loop turns
				int counter=0; //
				boolean badStudent=false;//if a student may not join in any department.
				boolean isFull=false;//if student's selected department is full, isFull is false. 
				tempDep=this.head;
				while(tempDep!=null) {
					isFull=false;
					if(counter==0 &&((Student)temp.getData()).getC1() == tempDep.getDepartment().getDepartmantid()) { // if student's choice is equals to deparment id
						if (tempDep.getDepartment().getQuota()==0) { // if there isn't any student in department
							counter++;
							tempDep=this.head;	
							isFull=true;
						}
						else {
							((Student)temp.getData()).setJoinedchoice(1);
							break;
						}
					}
					else if(counter==1 &&((Student)temp.getData()).getC2() == tempDep.getDepartment().getDepartmantid()) {
						if (tempDep.getDepartment().getQuota()==0) {
							counter++;
							tempDep=this.head;	
							isFull=true;
						}
						else {
							((Student)temp.getData()).setJoinedchoice(2);
							break;
						}
					}
					else if(counter==2 &&((Student)temp.getData()).getC3() == tempDep.getDepartment().getDepartmantid()) {
						if (tempDep.getDepartment().getQuota()==0) {
							badStudent=true;
							break;
						}
						else {
							((Student)temp.getData()).setJoinedchoice(3);
							break;
						}
					}				
					if(isFull==false) {
						tempDep=tempDep.getDown();
					}						
				}
				
				
				if (badStudent==false) {
					if (tempDep.getRight()!=null) {//if department is not empty, sn takes last student
						StudentNode sn=tempDep.getRight();					
							while (sn.getNext()!=null) {//this loop finds on the far right student 
								sn=sn.getNext();
							}
							StudentNode newnode=new StudentNode(((Student)temp.getData()));
							sn.setNext(newnode);																	
					}
					else {
							StudentNode sn=new StudentNode(((Student)temp.getData()));
							tempDep.setRight(sn);						
					}		
					tempDep.getDepartment().setQuota(tempDep.getDepartment().getQuota()-1);
				}
				badStudent=false;			
				temp=temp.getNext();//next student
			}
		}
		
	}

	   
	
	public void addDepartment(Department dp) { // this method adds department in multilinked list
		DepartmentNode newnode = new DepartmentNode(dp);
		
		if(head == null) {
			head = newnode;
		}
		else {
			DepartmentNode temp = head;
			while(temp.getDown() != null) {// this loop finds first null node 
				temp = temp.getDown();
			}
			
			temp.setDown(newnode);
		}
		
	}


	public void highestAndLowestGradeDisplay() {//this method finds lowest and highest grade for per department
		if (head==null) {
			System.out.println("Department is empty!");
		}
		else{
			DepartmentNode dpnode=head;
			while(dpnode!=null) {
				System.out.print(dpnode.getDepartment().getDepartmantname() + " --> ");
				if(dpnode.getRight()!=null) {
					System.out.print( " Department's Highest Grade: " + dpnode.getRight().getStudent().getGrade() + "  ---  ");
				}
				if(dpnode.getRight()!=null) {
					StudentNode snode=dpnode.getRight();
					while(snode!=null) {
						
						if(snode.getNext()==null && snode.getStudent().getGrade()!=dpnode.getRight().getStudent().getGrade()) {
							System.out.println("Department's Lowest Grade: " + snode.getStudent().getGrade());
						}
						else if(snode.getNext()==null && snode.getStudent().getGrade()==dpnode.getRight().getStudent().getGrade()) {
							System.out.println(snode.getStudent().getGrade() + "  There is only one student in this department! ");
						}
						
							snode= snode.getNext();
						
					}
				}
				dpnode = dpnode.getDown();
		}
			
		}
	}

	public void display() {//this method displays department and its student.
			DepartmentNode tempDep = this.head;
			int counter = 0;

			while(tempDep != null) {
				counter=0;
				StudentNode tempRight = tempDep.getRight();
				System.out.println(tempDep.getDepartment().getDepartmantname());
				while(tempRight!= null) {
					counter++;
					System.out.println("   "+counter+"-" + tempRight.getStudent().getName() +" - Grade: " +tempRight.getStudent().getGrade()+ " - Choice Rank: " +tempRight.getStudent().getJoinedchoice());
					tempRight = tempRight.getNext();
				}
				tempDep = tempDep.getDown();
			}
		}
	public void fullnessRatioDisplay() {//this method finds the fullness ratio for departments.
		DepartmentNode dpnode=head;
		double counter = 0;// this variable keeps the students in department. 
		double percentage=0;//this variable keeps the fullness ratio.
		double quota = 0;//this ratio keeps the quota for department as a double type.
		
		while(dpnode!=null) {
			StudentNode snode = dpnode.getRight();
			while(snode!=null) {
				counter++;
				snode=snode.getNext();
			}
			quota =(double)dpnode.getDepartment().getTempquota();
			percentage = (counter/quota)*100;
			System.out.println(dpnode.getDepartment().getDepartmantname()+ ": %" + percentage);
			counter=0;
			dpnode= dpnode.getDown();
		}
		
	}
}
