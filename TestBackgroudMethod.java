import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class TestBackgroudMethod {

    public static void main(final String[] args) {

        new SwingBackgroupWorker().execute();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.setSize(200, 200);
                jFrame.setVisible(true);
            }
        });
    }

    public static class SwingBackgroupWorker extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {
            while (true) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                	 public void run() {
                         try {
                        	 Internetconection.isactive=InternetConnection.IsConnected();	
                        	 if(Internetconection.isactive==true)
                        	 {
                        		 if(postaqsn.someqsn==true)
                        			 postaqsn.postwhenonline();
                        		 
                        	 }
                        	 else	 {
                        		 
                        		//  Jframe = 
                        	 }
             			} catch (InterruptedException e) {
             				// TODO Auto-generated catch block
             				e.printStackTrace();
             			}
                     }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}