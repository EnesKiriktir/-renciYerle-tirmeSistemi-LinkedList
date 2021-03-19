
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Management {
	MultiLinkedList multiList = new MultiLinkedList();
	DoubleLinkedList StudentList = new DoubleLinkedList();
	
	public void Manage() throws IOException {
		boolean control = true; //With this code the user have to use "load" command to proceed 
	
		while(control==true) { // Until "load" is used the code wont exit this loop
			Scanner scanLoad = new Scanner(System.in);
			System.out.print("Please enter loading command :  ");
			
			String loadCommand = scanLoad.nextLine();
			if(loadCommand.equalsIgnoreCase("load") && control) {
				loadAnswerSheet();
				
				System.out.println("Files are loaded!");
				control = false;
			}
			else {
				System.err.println("\n You should first load the files with 'load' command!\n");
			}
		}
		control=true;
		while(control) {
		
			
				Scanner scanResult = new Scanner(System.in); 
				System.out.print("Please enter statistics command :  ");
				String resultCommand = scanResult.nextLine();
				
				if(resultCommand.equalsIgnoreCase("results") ) {
					System.out.println();
					System.out.println("-----Top 5 students ordered by their exam scores :\n");
					StudentList.display5();
				    multiList.addStudents(StudentList);
				    System.out.println();
				    System.out.println();
				    System.out.println("-----List of multiList with highest and lowest grades of accepted students : \n");
				    multiList.highestAndLowestGradeDisplay();
				    System.out.println();
				    System.out.println();
				    System.out.println("-----List of multiList with their fullness ratio : \n");
				    multiList.fullnessRatioDisplay();
				    System.out.println();
				    System.out.println();
				    multiList.display();
				    
				}
				else if(resultCommand.equalsIgnoreCase("students")  ) {
					StudentList.displayAll();
					
				}
				else if( resultCommand.equalsIgnoreCase("commands")) {
					System.out.println("Please enter to see the statistics : 'results'");
					System.out.println("Please enter to see all the students : 'students'");
				}
				else {
					System.out.println("Please enter a valid command! Type 'commands' to see commands.");
				}
			
			
		
		}
		
		
	}
	
	public int calculateGrade(Student student,SingleLinkedList answerSheet){ // this method calculates the student exam grade.	
		SingleLinkedList s = student.getAnswers();
		int grade=0,bestGrade=0,counter=0;// bestGrade keeps the highest grade. counter uses for shifting.
		NodeSingleLinkedList tempS = s.head;
		NodeSingleLinkedList tempAns = answerSheet.head;
		
		for (int i = 0; i < 20; i++) {// if there is no shifting.
			if (tempS.getData().toString().equalsIgnoreCase(tempAns.getData().toString())) {
				grade=grade+5;
			}
			tempS=tempS.getLink();
			tempAns=tempAns.getLink();
		}
		
		bestGrade= grade;
		grade = 0;
				
		for(int i = 0;i<20;i++) {// if tehre is shifting.
			tempS = s.head;	
			tempAns = answerSheet.head;
			for (int j = 0; j < 20; j++) {
				if (j==counter) {					
				}
				else {
					if (tempS.getData().toString().equalsIgnoreCase(tempAns.getData().toString())) {
						grade=grade+5;
					}
					tempAns=tempAns.getLink();
				}
				tempS=tempS.getLink();
			}
			
			if (grade>bestGrade) {
				bestGrade=grade;
			}

			grade=0;
			counter++;			
		}	
		return bestGrade;
	}
	
	public void loadAnswerSheet() throws IOException { // Warning the Answer Sheet.txt is modified to AnswerSheet.txt just like the other txt's
		
		SingleLinkedList answerSheet = new SingleLinkedList();

		
		FileReader fr = new FileReader("AnswerSheet.txt"); // reading answer sheet file.
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		line = br.readLine();
		String[] array = line.split(",");
		
		for (int j = 0; j < 20; j++) {
			answerSheet.add(array[j]);
		}
		
		
		br = new BufferedReader(new FileReader("DepartmentInformation.txt")); // reading department information file. 
		
		while(line!=null) {
			line = br.readLine();
			if(line == null) {
				break;
			}
			array = line.split(",");
			
			Department department = new Department(Integer.parseInt(array[0]),Integer.parseInt(array[2]),array[1]);
			multiList.addDepartment(department);
		}
		boolean flag=false;
		int id=0;
		FileReader fr1 = new FileReader("StudentInformation.txt"); // reading student information file.
		BufferedReader br1 = new BufferedReader(fr1);
		String line2 ="";
		while((line2 = br1.readLine()) != null ) {
		
			String[] array2 =line2.split(",");
			SingleLinkedList answer = new SingleLinkedList();
			if(array2.length == 26) {
				for (int i = 6; i <26 ; i++) {
					answer.add(array2[i]);
				}
			}
			if(!flag) {
				id = Integer.parseInt(array2[0].substring(3));flag=true;
			}
			else {
				id = Integer.parseInt(array2[0]);
			}
			
			Double diplomaGrade = Double.parseDouble(array2[2]);// diploma grade parsed.
			int choose1=Integer.parseInt(array2[3]);
			int choose2=Integer.parseInt(array2[4]);
			int choose3=Integer.parseInt(array2[5]);
			
			if(array2.length==26) {
				Student student = new Student(id,array2[1],diplomaGrade,choose1,choose2,choose3,answer);
				student.setGrade(calculateGrade(student, answerSheet));
				StudentList.add(student);
			}

			else {
				System.err.println("One of the files does not work. Please find and fix it!");
			}
			
		
			
		}
	}
	
}