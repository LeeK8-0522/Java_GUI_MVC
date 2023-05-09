package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class ApplicationFormControl implements ActionListener, ItemListener {//implement ActionListener and ItemListener interfaces
	private ApplicationFormModel model;//model for MVC pattern
	private ApplicationFormView view;//view for MVC pattern
	private String errorMessage = "";//store list of error message
	private int countOfError = 0;//count of error message to put a number on each line in error message

	public ApplicationFormControl(ApplicationFormModel model, ApplicationFormView view) {
		this.model = model;
		this.view = view;

		this.view.setListener(this, this);// add listeners to submit button and combo box
	}//initialize model and view and add listener to button and combo-box

	@Override//override actionPerformed method of ActionListener interface
	public void actionPerformed(ActionEvent e) {
		Exception exceptionStack = new Exception();//generate exception instance for stacking up exceptions
		int state = 0;//indicate the step of checking input data
		
		String input = "";//store input data in text-fields
		float GPA = 0;//store GPA input data
		
		try {//try block
		while(state < 10) {
			switch(state) {
				case 0://check applicant name input data
					input = view.getApplicantName();//get text from text-field
					input = refineString(input);//refine string input data
					if(input.equals("")) {//if input data is empty, generate new empty-exception and add to stack
						EmptyException empty_ex = new EmptyException("name");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						if(countWords(input) >= 2) model.setApplicantName(input);//if there are both name and surname, set name of applicant in model
						else {//if format of input data is incorrect, generate new applicant-name-exception and add to stack
							ApplicantNameException ex = new ApplicantNameException();
							exceptionStack.addSuppressed(ex);
						}
					}
					input = "";//reset input data
					state++;//increase value of state for next step
					break;
				case 1://check birth date input data
					input = view.getBirthDate();
					input = refineString(input);
					if(input.equals("")) {
						EmptyException empty_ex = new EmptyException("birth-date");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						if(checkBirthDate(input) == true) model.setBirthDate(input);
						else {
							BirthDateException ex = new BirthDateException();
							exceptionStack.addSuppressed(ex);
						}
					}
					input = "";
					state++;
					break;
				case 2://check email input data
					input = view.getEmail();
					input = refineString(input);
					if(input.equals("")) {
						EmptyException empty_ex = new EmptyException("email");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						if(checkEmail(input) == true) model.setEmail(input);//if email input data format is correct, set email address in model
						else {
							EmailException ex = new EmailException();
							exceptionStack.addSuppressed(ex);
						}
						}
					input = "";
					state++;
					break;
				case 3://check major input data
					input = view.getMajor();
					input = refineString(input);
					if(input.equals("")) {
						EmptyException empty_ex = new EmptyException("major");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						model.setMajor(input);
					}
					input = "";
					state++;
					break;
				case 4://check phone number input data
					input = view.getPhoneNumberNumber();
					input = refineString(input);
			
					if(input.equals("")) {
						EmptyException empty_ex = new EmptyException("phone-number");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						if(checkPhoneNumber(input)) model.setPhoneNumber(input);
						else {
							PhoneNumberException ex = new PhoneNumberException();
							exceptionStack.addSuppressed(ex);
						}
					}
					input = "";
					state++;
					break;
				case 5://check home address input data
					input = view.getHomeAddress();
					input = refineString(input);
					if(input.equals("")) {
						EmptyException empty_ex = new EmptyException("home-address");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						model.setHomeAddress(input);
					}
					input = "";
					state++;
					break;
				case 6://check personal statement input data
					input = view.getPersonalStatement();
					input = refineString(input);
					if(input.equals("")) {
						EmptyException empty_ex = new EmptyException("personal-statement");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						if(countWords(input) < 100) {
							PersonalStatementException ex = new PersonalStatementException();
							exceptionStack.addSuppressed(ex);
						}
						else {
							model.setPersonalStatement(input);
						}
					}
					input = "";
					state++;
					break;
				case 7://check whether degree input data is '(empty)'
					input = view.getDegree();
					input = refineString(input);
					if(input.equals("(empty)")) {
						EmptyException empty_ex = new EmptyException("degree");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						model.setDegree(input);
					}
					input = "";
					state++;
					break;
				case 8:
					state++;
					break;
				case 9:
					state++;
					break;
				default:
					state++;
					break;
				}
			}
		
			if(exceptionStack.getSuppressed().length > 0) {//check if there are any accumulated exceptions
					throw exceptionStack;
			}//if there is exception, throw it
		}
		catch(Exception exception) {//catch block
			JOptionPane.showMessageDialog(null, errorMessage, "You have following problem(s).", JOptionPane.ERROR_MESSAGE);//show the problem message in pop-up window
			exception.printStackTrace();//print stack-trace of exceptions
		}
		finally {//finally block
			errorMessage = "";//reset error message
			countOfError = 0;//reset count of error
		}
	}

	@Override//override itemStateChanged method of ItemListener interface
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String selectedChoice = (String) e.getItem();
			if (selectedChoice.equals("Bachelor")) {
				view.freezeTextField();//if user choose 'Bachelor' item, it will change the colors(background, foreground) of two text-fields(GPA, attended-university) and change them to non-editable
			} else {
				view.activateTextField();//if user choose item except 'Bachelor' item, it will restore the colors and edit-ability of two text-fields(GPA, attended-university)
			}
		}
	}

	public int countWords(String input) {
		String[] words = input.trim().split("\\s+");
		return words.length;
	}//count words in string input data

	public String refineString(String input) {
		String[] words = input.trim().split("\\s+");//trim and split string for refining
		String result = "";

		for (int i = 0; i < words.length; i++) {
			result += words[i] + " ";
		}

		return result;
	}//refine string input data(ex. erase double blanks) 

	public boolean checkBirthDate(String input) {
		if (input.length() != 10)
			return false;//if length of input string is not correct, return false
		else {
			int day = Integer.parseInt(input.substring(0, 2));//slice input string and convert it to integer
			int month = Integer.parseInt(input.substring(3, 5));
			int year = Integer.parseInt(input.substring(6, 10));
			
			if(input.charAt(2) != '/' || input.charAt(5) != '/')
				return false;//if there are no '/' character in correct indexes, return false

			if (day < 1 || day > 31)
				return false;//if day is not within correct range, return false
			if (month < 1 || month > 12)
				return false;//if month is not within correct range, return false
			if (year > 2023)
				return false;//if year is not within correct range, return false
		}

		return true;
	}//check if format of birth-date input data is correct

	public boolean checkEmail(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '@') {//check if there is '@' character
				for (int k = i; k < input.length(); k++) {
					if (input.charAt(k) == '.')//check if there is '.' character on the right side of '@' character 
						return true;
				}
			}
		}
		return false;
	}//check if format of email input data is correct

	public boolean checkPhoneNumber(String input) {
		if (input.length() != 13)
			return false;//if length of input data is not correct, return false
		if (input.charAt(3) != '-' || input.charAt(8) != '-')
			return false;//if there are no '-' characters in correct indexes, return false
		else {
			for (int i = 0; i < 13; i++) {
				if (i != 3 && i != 8) {
					if (!Character.isDigit(input.charAt(i))) {
						return false;//if character of according index is not a number, return false
					}
				}
			}
		}
		return true;
	}//check if format of phone number input data is correct

	// Below are user-defined exception classes
	public class EmptyException extends Exception {
		public EmptyException(String field) {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "You forgot to fill the " + field
					+ " text field. Please fill it.\n";
		}
	}//throw this exception if input data is empty

	public class ApplicantNameException extends Exception {
		public ApplicantNameException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "You forgot to write your name or surname.\n";
		}
	}//throw this exception if format of name input data is not correct

	public class BirthDateException extends Exception {
		public BirthDateException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "Birthdate must be in '06/06/1995' format.\n";
		}
	}//throw this exception if format of birth-date input data is not correct

	public class EmailException extends Exception {
		public EmailException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "Email must be in example@some.some.\n";
		}
	}//throw this exception if format of email input data is not correct

	public class DegreeException extends Exception {
		public DegreeException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". "
					+ "For graduate, you have to enter previous university and GPA.\n";
		}
	}//throw this exception if user didn't choose any item in degree combo-box

	public class GPAException extends Exception {
		public GPAException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "GPA must be between 0 and 4.5.\n";
		}
	}//throw this exception if GPA input data is not between 0 and 4.5

	public class PersonalStatementException extends Exception {
		public PersonalStatementException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". "
					+ "Your Personal Statement must be at least 100 words.\n";
		}
	}//throw this exception if personal-statement input data does not have more than 100 words

	public class PhoneNumberException extends Exception {
		public PhoneNumberException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". "
					+ "Proper format for a phone number is 010-2335-0155.\n";
		}
	}//throw this exception if format of phone-number input data is not correct 
	// finish implementing user-defined classes
}
