package Main;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationFormView view = new ApplicationFormView();
					ApplicationFormModel model = new ApplicationFormModel();
					ApplicationFormControl control = new ApplicationFormControl(model, view);
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
