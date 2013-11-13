import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * This snippet shows how to changes the look an feel 
 * of the gui application.
 * 
 * @author mvohra
 * 
 */
public class LookAndFeel {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		try {

			// use one of the following method based on the desired look& feel

			// set the look & feel based on OS itself
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			// java metal look and feel works across platform
		//	UIManager.setLookAndFeel(UIManager
		//			.getCrossPlatformLookAndFeelClassName());

			// set the Motif look and feel
			//String motifClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			//UIManager.setLookAndFeel(motifClassName);

			// set the look & feel based on
		} catch (Exception e) {
			System.out.println("Error failed to set the Look & Feel"
					+ e.getMessage());
			e.printStackTrace();
		}

	 

	}
}
