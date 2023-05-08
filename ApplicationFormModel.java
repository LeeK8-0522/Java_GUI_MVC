package Main;

public class ApplicationFormModel {

	private String applicantName;
	private String birthDate;
	private String Email;
	private String Degree;
	private String attendedUniversity;
	private float GPA;
	private String Major;
	private String phoneNumber;
	private String personalStatement;
	private String homeAddress;
	
	//Below are getter-methods
	public String getApplicantName() {
		return this.applicantName;
	}
	
	public String getBirthDate() {
		return this.birthDate;
	}
	
	public String getEmail() {
		return this.Email;
	}
	
	public String getDegree() {
		return this.Degree;
	}
	
	public String getAttenededUniversity() {
		return this.attendedUniversity;
	}
	
	public float getGPA() {
		return this.GPA;
	}
	
	public String getMajor() {
		return this.Major;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getPersonalStatement() {
		return this.personalStatement;
	}
	
	public String getHomeAddress() {
		return this.homeAddress;
	}
	//finish implementing getter-methods
	
	//Below are setter-methods
	public void setApplicantName(String input) {
		this.applicantName = input;
	}
	
	public void setBirthDate(String input) {
		this.birthDate = input;
	}
	
	public void setEmail(String input) {
		this.Email = input;
	}
	
	public void setDegree(String input) {
		this.Degree = input;
	}
	
	public void setAttendedUniversity(String input) {
		this.attendedUniversity = input;
	}
	
	public void setGPA(float input) {
		this.GPA = input;
	}
	
	public void setMajor(String input) {
		this.Major = input;
	}
	
	public void setPhoneNumber(String input) {
		this.phoneNumber = input;
	}
	
	public void setPersonalStatement(String input) {
		this.personalStatement = input;
	}
	
	public void setHomeAddress(String input) {
		this.homeAddress = input;
	}
	//finish implementing setter-methods
}

