import java.util.HashMap;

public class SchoolDB {
	public static void main(String[] args) {
		HashMap<String, String> students = new HashMap<String, String>(); 

		students.put("1", "John Doe");
		students.put("2", "Student 2");
		students.put("3", "Student 3");

		students.containsKey("1");

		students.containsValue("John Doe");

		Set keys = students.keySet();

		Set names = students.entrySet();
	}
}
