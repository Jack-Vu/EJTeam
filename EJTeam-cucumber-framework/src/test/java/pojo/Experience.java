package pojo;

public class Experience {

	public String jobTitle;
	public String company;
	public String location;
	public String fromDate;
	public boolean current;
	public String toDate;
	public String description;

	public Experience(String jobTitle, String company, String location, String fromDate, boolean current, String toDate,
			String description) {
		this.jobTitle = jobTitle;
		this.company = company;
		this.location = location;
		this.fromDate = fromDate;
		this.current = current;
		this.toDate = toDate;
		this.description = description;

	}

}
