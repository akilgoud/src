import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GridLayoutExample{

    public JPanel createContentPane (){
        
        JPanel totalGUI = new JPanel();
        
        // We create a JPanel with the GridLayout.
        JPanel mainPanel = new JPanel(new GridLayout(0, 3, 50, 50));
        for (int i = 0; i < 100; i++) {
        	 JLabel fff = new JLabel("akil");
        	 
             mainPanel.add(fff);
		}
       
         

        totalGUI.add(mainPanel);
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // In this method, we create a square JPanel of a colour and set size
    // specified by the arguments.
    
    private JPanel createSquareJPanel(Color color, int size)
    {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
        return tempPanel;
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] GridLayout [=]");

        GridLayoutExample demo = new GridLayoutExample();
        frame.setContentPane(demo.createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}