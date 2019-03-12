import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student {
	private int token;
	private String fname;
	private double cgpa;

	public Student(int token, String fname, double cgpa) {
		this.token = token;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

}

class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalEvents = in.nextInt();
		
		
		PriorityQueue<Student> pQ = new PriorityQueue<Student>(
				
				new Comparator<Student>() {
					
					public int compare(Student student1, Student student2) {
						// step 1: if cgpa are not
			
						if (student1.getCgpa() != student2.getCgpa()){ // cannot   use   o1.equals(o2)   because   it   compares   only  int
							if(student1.getCgpa() > student2.getCgpa())
								return -1;
							else
								return 1;		// (int) casting as ans may in double; -ve to decending order						
						}else {// step 2 : if CGPA are same sort according to Fname
							if (  ( student1.getFname().compareTo(student2.getFname()) ) != 0){ // step 3: if first name also equal, sort according to Token();
								return student1.getFname().compareTo(student2.getFname());
						}else
								return student1.getToken() - student2.getToken(); // step 2:L cont.. if Fname are not same, sort accordingly and return
						}
					}
				}
		);
		
		
		
		for (int i = 0; i < totalEvents; i++) {
			String event = in.next();
            
            if (event.equals("ENTER")) {
                String name = in.next();
                double cgpa = in.nextDouble();
                int token = in.nextInt();
                
                Student student = new Student(token, name, cgpa);
                
                pQ.add(student);				//add() throws exception but offer() doesnot. bot methods adds object to queue
            } else if (event.equals("SERVED")) {
            	pQ.poll(); 	// poll() ,This method retrieves and removes the head of this queue, or returns null if this queue is  empty.
            }
		}
		
	
		
		
		
		if ( pQ.isEmpty() ) {
			System.out.println("EMPTY");
		} else {
			for (;;) {
				Student stu = pQ.poll();

				try {
					System.out.println(stu.getFname());		//when empty throws NullPointerException, so in catch break the loop;
				} catch (NullPointerException  e) {
					//e.printStackTrace();
					break;
				}
			}
		}
	}
}