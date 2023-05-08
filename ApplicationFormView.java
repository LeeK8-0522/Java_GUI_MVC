package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Rectangle;

public class ApplicationFormView extends JFrame {

	private JPanel contentPane;
	private JPanel Wallpaper_panel;
	private JPanel ApplicantForm_pannel;
	private JLabel Wallpaper_label;
	private JPanel InputArea_panel;
	private JPanel ApplicantName_panel;
	private JPanel BirthDate_panel;
	private JPanel Email_panel;
	private JPanel Degree_panel;
	private JPanel AttendedUniversity_panel;
	private JPanel GPA_panel;
	private JPanel PersonalStatement_panel;
	private JPanel PersonalStatementInput_panel;
	private JPanel HomeAddress_panel;
	private JPanel SubmitApplicant_panel;
	
	private JLabel ApplicantName_label;
	private JTextField ApplicantName_textField;
	private JLabel BirthDate_label;
	private JTextField BirthDate_textField;
	private JLabel Email_label;
	private JTextField Email_textField;
	private JLabel Degree_label;
	private JComboBox Degree_comboBox;
	private JLabel AttendedUniversity_label;
	private JTextField AttendedUniversity_textField;
	private JPanel Title_panel;
	private JLabel Title_label;
	private JLabel GPA_label;
	private JTextField GPA_textField;
	private JLabel PersonalStatement_label;
	private JTextArea PersonalStatementInput_textArea;
	private JLabel HomeAddress_label;
	private JTextField HomeAddress_textField;
	private JButton SubmitApplicant_button;
	private JPanel Major_panel;
	private JLabel Major_label;
	private JTextField Major_textField;
	private JPanel PhoneNumber_panel;
	private JLabel PhoneNumber_label;
	private JTextField PhoneNumber_textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ApplicationFormView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 541);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Wallpaper_panel = new JPanel();
		contentPane.add(Wallpaper_panel, BorderLayout.WEST);
		Wallpaper_panel.setLayout(new BorderLayout(0, 0));
		
		Wallpaper_label = new JLabel("");
		Wallpaper_label.setPreferredSize(new Dimension(200, 0));
		Wallpaper_label.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\assignment3\\skku_wallpaper.png"));
		Wallpaper_panel.add(Wallpaper_label, BorderLayout.CENTER);
		
		ApplicantForm_pannel = new JPanel();
		contentPane.add(ApplicantForm_pannel, BorderLayout.CENTER);
		ApplicantForm_pannel.setLayout(new BorderLayout(0, 0));
		
		Title_panel = new JPanel();
		Title_panel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_Title_panel = (FlowLayout) Title_panel.getLayout();
		fl_Title_panel.setVgap(0);
		fl_Title_panel.setHgap(0);
		ApplicantForm_pannel.add(Title_panel, BorderLayout.NORTH);
		
		Title_label = new JLabel("");
		Title_label.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\assignment3\\title_label.png"));
		Title_panel.add(Title_label);
		
		InputArea_panel = new JPanel();
		ApplicantForm_pannel.add(InputArea_panel, BorderLayout.CENTER);
		InputArea_panel.setLayout(new BoxLayout(InputArea_panel, BoxLayout.Y_AXIS));
		
		ApplicantName_panel = new JPanel();
		ApplicantName_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(ApplicantName_panel);
		ApplicantName_panel.setLayout(new BorderLayout(5, 5));
		
		ApplicantName_label = new JLabel("Applicant Name:");
		ApplicantName_label.setHorizontalAlignment(SwingConstants.RIGHT);
		ApplicantName_label.setPreferredSize(new Dimension(220, 15));
		ApplicantName_label.setFont(new Font("굴림", Font.BOLD, 12));
		ApplicantName_panel.add(ApplicantName_label, BorderLayout.WEST);
		
		ApplicantName_textField = new JTextField();
		ApplicantName_panel.add(ApplicantName_textField, BorderLayout.CENTER);
		ApplicantName_textField.setColumns(10);
		
		BirthDate_panel = new JPanel();
		BirthDate_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(BirthDate_panel);
		BirthDate_panel.setLayout(new BorderLayout(5, 5));
		
		BirthDate_label = new JLabel("Birth Date:");
		BirthDate_label.setHorizontalAlignment(SwingConstants.RIGHT);
		BirthDate_label.setPreferredSize(new Dimension(220, 15));
		BirthDate_label.setFont(new Font("굴림", Font.BOLD, 12));
		BirthDate_panel.add(BirthDate_label, BorderLayout.WEST);
		
		BirthDate_textField = new JTextField();
		BirthDate_panel.add(BirthDate_textField, BorderLayout.CENTER);
		BirthDate_textField.setColumns(10);
		
		Email_panel = new JPanel();
		Email_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(Email_panel);
		Email_panel.setLayout(new BorderLayout(5, 5));
		
		Email_label = new JLabel("Email:");
		Email_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Email_label.setFont(new Font("굴림", Font.BOLD, 12));
		Email_label.setPreferredSize(new Dimension(220, 15));
		Email_panel.add(Email_label, BorderLayout.WEST);
		
		Email_textField = new JTextField();
		Email_panel.add(Email_textField, BorderLayout.CENTER);
		Email_textField.setColumns(10);
		
		Degree_panel = new JPanel();
		Degree_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(Degree_panel);
		Degree_panel.setLayout(new BorderLayout(5, 5));
		
		Degree_label = new JLabel("Degree:");
		Degree_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Degree_label.setPreferredSize(new Dimension(220, 15));
		Degree_label.setFont(new Font("굴림", Font.BOLD, 12));
		Degree_panel.add(Degree_label, BorderLayout.WEST);
		
		Degree_comboBox = new JComboBox();
		Degree_comboBox.setModel(new DefaultComboBoxModel(new String[] {"(empty)", "Bachelor", "Master", "PhD"}));
		Degree_panel.add(Degree_comboBox, BorderLayout.CENTER);
		
		AttendedUniversity_panel = new JPanel();
		AttendedUniversity_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(AttendedUniversity_panel);
		AttendedUniversity_panel.setLayout(new BorderLayout(5, 5));
		
		AttendedUniversity_label = new JLabel("Attended university (for Graduates):");
		AttendedUniversity_label.setHorizontalAlignment(SwingConstants.RIGHT);
		AttendedUniversity_label.setFont(new Font("굴림", Font.BOLD, 12));
		AttendedUniversity_label.setPreferredSize(new Dimension(220, 15));
		AttendedUniversity_panel.add(AttendedUniversity_label, BorderLayout.WEST);
		
		AttendedUniversity_textField = new JTextField();
		AttendedUniversity_panel.add(AttendedUniversity_textField, BorderLayout.CENTER);
		AttendedUniversity_textField.setColumns(10);
		
		GPA_panel = new JPanel();
		GPA_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(GPA_panel);
		GPA_panel.setLayout(new BorderLayout(5, 5));
		
		GPA_label = new JLabel("GPA (for Graduates):");
		GPA_label.setHorizontalAlignment(SwingConstants.RIGHT);
		GPA_label.setPreferredSize(new Dimension(220, 15));
		GPA_label.setFont(new Font("굴림", Font.BOLD, 12));
		GPA_panel.add(GPA_label, BorderLayout.WEST);
		
		GPA_textField = new JTextField();
		GPA_panel.add(GPA_textField, BorderLayout.CENTER);
		GPA_textField.setColumns(10);
		
		Major_panel = new JPanel();
		Major_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(Major_panel);
		Major_panel.setLayout(new BorderLayout(5, 5));
		
		Major_label = new JLabel("Major:");
		Major_label.setHorizontalAlignment(SwingConstants.RIGHT);
		Major_label.setFont(new Font("굴림", Font.BOLD, 12));
		Major_label.setPreferredSize(new Dimension(220, 15));
		Major_panel.add(Major_label, BorderLayout.WEST);
		
		Major_textField = new JTextField();
		Major_panel.add(Major_textField, BorderLayout.CENTER);
		Major_textField.setColumns(10);
		
		PhoneNumber_panel = new JPanel();
		PhoneNumber_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(PhoneNumber_panel);
		PhoneNumber_panel.setLayout(new BorderLayout(5, 5));
		
		PhoneNumber_label = new JLabel("Phone Number:");
		PhoneNumber_label.setFont(new Font("굴림", Font.BOLD, 12));
		PhoneNumber_label.setHorizontalAlignment(SwingConstants.RIGHT);
		PhoneNumber_label.setPreferredSize(new Dimension(220, 15));
		PhoneNumber_panel.add(PhoneNumber_label, BorderLayout.WEST);
		
		PhoneNumber_textField = new JTextField();
		PhoneNumber_panel.add(PhoneNumber_textField, BorderLayout.CENTER);
		PhoneNumber_textField.setColumns(10);
		
		PersonalStatement_panel = new JPanel();
		PersonalStatement_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(PersonalStatement_panel);
		PersonalStatement_panel.setLayout(new BorderLayout(5, 5));
		
		PersonalStatement_label = new JLabel("Personal Statement");
		PersonalStatement_label.setFont(new Font("굴림", Font.BOLD, 12));
		PersonalStatement_label.setHorizontalAlignment(SwingConstants.CENTER);
		PersonalStatement_panel.add(PersonalStatement_label, BorderLayout.CENTER);
		
		PersonalStatementInput_panel = new JPanel();
		PersonalStatementInput_panel.setBorder(new EmptyBorder(5, 50, 5, 50));
		InputArea_panel.add(PersonalStatementInput_panel);
		PersonalStatementInput_panel.setLayout(new BorderLayout(5, 5));
		
		PersonalStatementInput_textArea = new JTextArea();
		PersonalStatementInput_textArea.setBackground(new Color(254, 245, 254));
		PersonalStatementInput_panel.add(PersonalStatementInput_textArea, BorderLayout.CENTER);
		
		HomeAddress_panel = new JPanel();
		HomeAddress_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		InputArea_panel.add(HomeAddress_panel);
		HomeAddress_panel.setLayout(new BorderLayout(5, 5));
		
		HomeAddress_label = new JLabel("Home Address:");
		HomeAddress_label.setHorizontalAlignment(SwingConstants.RIGHT);
		HomeAddress_label.setFont(new Font("굴림", Font.BOLD, 12));
		HomeAddress_label.setPreferredSize(new Dimension(220, 15));
		HomeAddress_panel.add(HomeAddress_label, BorderLayout.WEST);
		
		HomeAddress_textField = new JTextField();
		HomeAddress_panel.add(HomeAddress_textField, BorderLayout.CENTER);
		HomeAddress_textField.setColumns(10);
		
		SubmitApplicant_panel = new JPanel();
		SubmitApplicant_panel.setBorder(new EmptyBorder(30, 100, 30, 100));
		InputArea_panel.add(SubmitApplicant_panel);
		SubmitApplicant_panel.setLayout(new BorderLayout(5, 5));
		
		SubmitApplicant_button = new JButton("Submit Application");
		SubmitApplicant_button.setForeground(new Color(0, 0, 255));
		SubmitApplicant_button.setFont(new Font("굴림", Font.BOLD, 12));
		SubmitApplicant_button.setBackground(new Color(0, 128, 255));
		SubmitApplicant_panel.add(SubmitApplicant_button, BorderLayout.CENTER);
		
	}
	
	public void setActionListener(ActionListener action_listener, ItemListener item_listener) {
		Degree_comboBox.addItemListener(item_listener);
		SubmitApplicant_button.addActionListener(action_listener);
	}//add action listener to Degree_comboBox and SubmitApplicant_button
	 
	public void freezeTextField() {
		GPA_textField.setText(""); 
		GPA_textField.setEditable(false);
		GPA_textField.setBackground(new Color(220, 220, 220));
		GPA_label.setForeground(new Color(180, 180, 180));
		
		AttendedUniversity_textField.setText("");
		AttendedUniversity_textField.setEditable(false);
		AttendedUniversity_textField.setBackground(new Color(220, 220 , 220));
		AttendedUniversity_label.setForeground(new Color(180, 180 ,180));
	}
	
	public void activateTextField() {
		GPA_textField.setEditable(true);
		GPA_textField.setBackground(null);
		GPA_label.setForeground(null);
		
		AttendedUniversity_textField.setEditable(true);
		AttendedUniversity_textField.setBackground(null);
		AttendedUniversity_label.setForeground(null);
	}

	//Below are getter-methods
	public String getApplicantName() {
		return ApplicantName_textField.getText();
	}
	
	public String getBirthDate() {
		return BirthDate_textField.getText();
	}
	
	public String getEmail() {
		return Email_textField.getText();	
	}
	
	public String getDegree() {
		return (String)Degree_comboBox.getSelectedItem();
	}
	
	public String getAttendedUniversity() {
		return AttendedUniversity_textField.getText();
	}
	
	public String getGPA() {
		return GPA_textField.getText();
	}
	
	public String getMajor() {
		return Major_textField.getText();
	}
	
	public String getPhoneNumberNumber() {
		return PhoneNumber_textField.getText();
	}
	
	public String getPersonalStatement() {
		return PersonalStatementInput_textArea.getText();
	}
	
	public String getHomeAddress() {
		return HomeAddress_textField.getText();
	}
	//finish implementing getter-method
}
