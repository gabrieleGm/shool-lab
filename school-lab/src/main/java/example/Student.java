package example;

public class Student {

	private final String _name;
	
	public Student(String name) {
		_name = name;
	}

	public String getInfo() {
		return getFullName();
	}

	private String getFullName() {
		return _name;
	}
}
