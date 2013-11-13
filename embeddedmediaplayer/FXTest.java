package embeddedmediaplayer;
import java.io.File;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

class FXTest {  
	static File file = new File("E:\\Video\\unity.mp4");
	 static String MEDIA_URL ;
       
    private static void initFx(JFXPanel fxPanel) {  
    	MEDIA_URL = file.toURI().toString();
        Media media = new Media(MEDIA_URL);  
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
        mediaPlayer.setAutoPlay(true);  
        MediaView mediaView = new MediaView(mediaPlayer);  
        Group root = new Group();  
        Scene scene = new Scene(root,800,600); 
        MediaControl mediaControl = new MediaControl(mediaPlayer);
        scene.setRoot(mediaControl);
        root.getChildren().add(mediaView);  
        fxPanel.setScene(scene);  
    } 
    
    private static void initAndShowGui(JInternalFrame jFrame){  
     //   JFrame jFrame = new JFrame("FX Test");  
        jFrame.setSize(800, 600);  
        jFrame.setVisible(true);  
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
           
       final JFXPanel jFXPanel = new JFXPanel();  
        jFrame.add(jFXPanel);  
           
        Platform.runLater(new Runnable(){  
            @Override  
            public void run() {  
                initFx(jFXPanel);  
            }  
        });  
    }  
    public static void main(final JInternalFrame jInternalFrame1) {  
        SwingUtilities.invokeLater(new Runnable() {  
            @Override  
            public void run() {  
                initAndShowGui(jInternalFrame1);  
            }  
        });  
    }  
    
}