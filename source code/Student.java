
public class Student {
	private int studentnumber,c1,c2,c3,grade,joinedchoice;
	private String name,surname;
	private double schooldiplomagrade;
	SingleLinkedList answers=new SingleLinkedList();
	
	Student (int studentnumber, String name,double schooldiplomagrade,int c1,int c2,int c3,SingleLinkedList answer){
		this.studentnumber=studentnumber;
		this.name=name;
		this.schooldiplomagrade=schooldiplomagrade;
		this.c1=c1;
		this.c2=c2;
		this.c3=c3;
		this.grade=0;
		this.answers = answer;
		
	}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(int studentnumber) {
		this.studentnumber = studentnumber;
	}
	public int getC1() {
		return c1;
	}
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public int getC3() {
		return c3;
	}
	public void setC3(int c3) {
		this.c3 = c3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public double getSchooldiplomagrade() {
		return schooldiplomagrade;
	}
	public void setSchooldiplomagrade(double schooldiplomagrade) {
		this.schooldiplomagrade = schooldiplomagrade;
	}
	public SingleLinkedList getAnswers() {
		return answers;
	}
	public void setAnswers(SingleLinkedList answers) {
		this.answers = answers;
	}

	public int getJoinedchoice() {
		return joinedchoice;
	}

	public void setJoinedchoice(int joinedchoice) {
		this.joinedchoice = joinedchoice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
