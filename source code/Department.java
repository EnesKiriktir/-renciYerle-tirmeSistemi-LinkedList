
public class Department {

	private int departmantid,quota,tempquota;//temp quota does not change
	private String departmantname;
	
	public Department(int departmantid, int quota, String departmantname) {
		this.departmantid = departmantid;
		this.quota = quota;
		this.departmantname = departmantname;
		this.tempquota=quota;
	}
	
	public int getDepartmantid() {
		return departmantid;
	}
	
	public void setDepartmantid(int departmantid) {
		this.departmantid = departmantid;
	}
	
	public int getQuota() {
		return quota;
	}
	
	public void setQuota(int quota) {
		this.quota = quota;
	}
	
	public String getDepartmantname() {
		return departmantname;
	}
	
	public void setDepartmantname(String departmantname) {
		this.departmantname = departmantname;
	}
	
	public int getTempquota() {
		return tempquota;
	}
	
	public void setTempquota(int tempquota) {
		this.tempquota = tempquota;
	}

	
	
	
	
}
