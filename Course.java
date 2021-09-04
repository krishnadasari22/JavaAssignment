import java.util.ArrayList;
public class Course {

	private String courseName;
	// the list of students in the course is maintained using an ArrayList:
	private ArrayList<Student> students;

	public Course(String courseName){
		this.courseName = courseName;
		// make an empty list of students: 
		students = new ArrayList<Student>();
	}

	public String getCourseName() {
		return courseName;
	}
	
	public int size() {
		return students.size();
	}
	public boolean add(Student student){

		if (!students.contains(student)){
			students.add(student);
			return true;
		}
		return false;
	}
	public void remove(Student student){
		students.remove(student);
	}
	public void remove(int i){
		students.remove(i);
	}
	public Student getStudent(int i){
		return students.get(i);
	}	
	public int indexOf(Student student){
		return students.indexOf(student);
	}
	
	public boolean contains(Student student) {
		return students.contains(student);
	}
	public String toString(){
		String res = "course: " + courseName + "  number of students: " + size();
		for (Student s: students) {
			res = res + "\n" + s;
		}
		// alternative implementation:
		//res = res + "\n" + students;
        return res;
	}
	public Course intersect(Course other){
		Course intersection = new Course("intersection");
		for (Student s: students) {
			if (other.contains(s)) {
				intersection.add(s);
			}
		}
		return intersection;
	}
	
	public static void main(String[] args) {
		
		Course course = new Course("cs161");
		
		Student jim = new Student(0, "Jim", "1234");
		Student jane = new Student(0, "Jane", "5678");
		Student aaron = new Student(0, "Aaron", "2576");
		Student zeke = new Student(0, "Zeke", "8382");
		Student mary = new Student(0, "Mary", "8283");
		course.add(jim);
		course.add(jane);
		course.add(aaron);
		course.add(zeke);
		course.add(mary);
		
		System.out.println(course);

		System.out.println("contains Jim: " + course.contains(jim));
		System.out.println("contains Jim: " + course.students.contains(jim));

		System.out.println("indexOf Jim: " + course.students.indexOf(jim));
		Student otherJim = new Student(jim);
		System.out.println("indexOf otherJim: " + course.indexOf(otherJim));
		
		System.out.println("Attempting to insert Aaron again");
		if (course.add(aaron)){
			System.out.println( "**ERROR Aaron is inserted but is already in student database");
		}
		else {
			System.out.println("OK Aaron not inserted again");
		}
		
		course.remove(1);
		System.out.println(course);
		
		Course course2 = new Course("cs192");
		
		course2.add(jim);
		course2.add(jane);
		System.out.println(course2);
		
		Course course3 = course.intersect(course2);
		System.out.println(course3);
		
	}
}