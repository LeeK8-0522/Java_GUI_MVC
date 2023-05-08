package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class ApplicationFormControl implements ActionListener, ItemListener {
	private ApplicationFormModel model;
	private ApplicationFormView view;
	private String errorMessage = "";
	private int countOfError = 0;

	public ApplicationFormControl(ApplicationFormModel model, ApplicationFormView view) {
		this.model = model;
		this.view = view;

		this.view.setActionListener(this, this);// add action listener to submit button
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Exception exceptionStack = new Exception();
		int state = 0;
		
		String input = "";
		float GPA = 0;
		
		try {
		while(state < 10) {
			switch(state) {
				case 0://check applicant name input data
					input = view.getApplicantName();
					input = refineString(input);
					if(input.equals("")) {
						EmptyException empty_ex = new EmptyException("name");
						exceptionStack.addSuppressed(empty_ex);
					}
					else {
						if(countWords(input) >= 2) model.setApplicantName(input);
						else {
							ApplicantNameException ex = new ApplicantNameException();
							exceptionStack.addSuppressed(ex);
						}
					}
					input = "";
					state++;
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
						if(checkEmail(input) == true) model.setEmail(input);
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
		
			if(exceptionStack.getSuppressed().length > 0) {
					throw exceptionStack;
			}
		}
		catch(Exception exception) {
			JOptionPane.showMessageDialog(null, errorMessage, "You have following problem(s).", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String selectedChoice = (String) e.getItem();
			if (selectedChoice.equals("Bachelor")) {
				view.freezeTextField();
			} else {
				view.activateTextField();
			}
		}
	}

	public int countWords(String input) {
		String[] words = input.trim().split("\\s+");
		return words.length;
	}

	public String refineString(String input) {
		String[] words = input.trim().split("\\s+");
		String result = "";

		for (int i = 0; i < words.length; i++) {
			result += words[i] + " ";
		}

		return result;
	}

	public boolean checkBirthDate(String input) {
		if (input.length() != 10)
			return false;
		else {
			int day = Integer.parseInt(input.substring(0, 1));
			int month = Integer.parseInt(input.substring(3, 4));
			int year = Integer.parseInt(input.substring(6, 9));

			if (day < 1 || day > 31)
				return false;
			if (month < 1 || month > 12)
				return false;
			if (year > 2023)
				return false;
		}

		return true;
	}

	public boolean checkEmail(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '@') {
				for (int k = i; k < input.length(); k++) {
					if (input.charAt(k) == '.')
						return true;
				}
			}
		}
		return false;
	}

	public boolean checkPhoneNumber(String input) {
		if (input.length() != 13)
			return false;
		if (input.charAt(3) != '-' || input.charAt(8) != '-')
			return false;
		else {
			for (int i = 0; i < 13; i++) {
				if (i != 3 && i != 8) {
					if (!Character.isDigit(input.charAt(i))) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// Below are user-defined exception classes
	public class EmptyException extends Exception {
		public EmptyException(String field) {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "You forgot to fill the " + field
					+ " text field. Please fill it.\n";
		}
	}

	public class ApplicantNameException extends Exception {
		public ApplicantNameException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "You forgot to write your name or surname.\n";
		}
	}

	public class BirthDateException extends Exception {
		public BirthDateException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "Birthdate must be in '06/06/1995' format.\n";
		}
	}

	public class EmailException extends Exception {
		public EmailException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "Email must be in example@some.some.\n";
		}
	}

	public class DegreeException extends Exception {
		public DegreeException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". "
					+ "For graduate, you have to enter previous university and GPA.\n";
		}
	}

	public class GPAException extends Exception {
		public GPAException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". " + "GPA must be between 0 and 4.5.\n";
		}
	}

	public class PersonalStatementException extends Exception {
		public PersonalStatementException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". "
					+ "Your Personal Statement must be at least 100 words.\n";
		}
	}

	public class PhoneNumberException extends Exception {
		public PhoneNumberException() {
			countOfError++;
			errorMessage += Integer.toString(countOfError) + ". "
					+ "Proper format for a phone number is 010-2335-0155.\n";
		}
	}
	// finish implementing user-defined classes
}
