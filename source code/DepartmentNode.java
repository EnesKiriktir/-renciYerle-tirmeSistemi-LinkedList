
public class DepartmentNode {

	private Department department;
	private DepartmentNode down;
	private StudentNode right;
	public DepartmentNode(Department department) {
		this.department = department;
		this.down = null;
		this.right = null;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public DepartmentNode getDown() {
		return down;
	}
	public void setDown(DepartmentNode down) {
		this.down = down;
	}
	public StudentNode getRight() {
		return right;
	}
	public void setRight(StudentNode right) {
		this.right = right;
	}
	
	
}
