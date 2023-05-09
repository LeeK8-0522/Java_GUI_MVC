package Main;

public class ApplicationFormModel {

	// * Below are fields *
	private String applicantName;//store name of applicant 
	private String birthDate;//store birth-date of applicant
	private String Email;//store email address of applicant
	private String Degree;//store degree of applicant
	private String attendedUniversity;//store attended-university of applicant
	private float GPA;//store GPA of applicant
	private String Major;//store major of applicant
	private String phoneNumber;//store phone-number of applicant
	private String personalStatement;//store personal-statement of applicant
	private String homeAddress;//store home-address of applicant
	// * finish implementing fields *
	
	// * Below are getter-methods *
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
	// * finish implementing getter-methods *
	
	// * Below are setter-methods *
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
	// * finish implementing setter-methods *
}

