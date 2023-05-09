package Main;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {//run Runnable object
				try {
					ApplicationFormView view = new ApplicationFormView();//generate ApplicantFormView instance for view in MVC pattern.
					ApplicationFormModel model = new ApplicationFormModel();//generate ApplicantFormModel instance for model in MVC pattern.
					ApplicationFormControl control = new ApplicationFormControl(model, view);//generate ApplicantFormControl instance for control in MVC pattern and initialize it by referencing model and view 
					view.setVisible(true);//set view visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
