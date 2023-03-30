package pojo;

public class Application {

	public String firstName;
	public String middleName;
	public String lastName;
	public String email;
	public String birthday;
	public String gender;
	public String phoneNumber;
	public String course;
	public String howDidYouHear;
	public boolean robot;

	public Application(String firstName, String middleName, String lastName, String email, String birthday, String gender,
			String phoneNumber, String course, String howDidYouHear, boolean robot) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday; 
		this.gender = gender; 
		this.phoneNumber = phoneNumber;
		this.course = course; 
		this.howDidYouHear = howDidYouHear; 
		this.robot = robot; 
	}
}
