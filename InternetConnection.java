import java.net.NetworkInterface;  
import java.net.SocketException;  
import java.util.Enumeration;  
  
public class InternetConnection {  
    public static boolean IsConnected() throws InterruptedException {  
    	boolean test=false;
        Enumeration<NetworkInterface> interfaces = null;  
        try {  
            interfaces = NetworkInterface.getNetworkInterfaces();  
        } catch (SocketException e) {  
            e.printStackTrace();  
        }    
        while (interfaces.hasMoreElements()) {    
            NetworkInterface nic = interfaces.nextElement();    
  if(!nic.getDisplayName().equals("Software Loopback Interface 1")){
            System.out.print("Interface Name : [" + nic.getDisplayName() + "]");    
            try {  
            	
            	if(nic.isUp()){
            	test=nic.isUp();
            break;
            	}
                System.out.println(", Is connected : [" + nic.isUp() + "]");  
            } catch (SocketException e) {  
                e.printStackTrace();  
            }    
        }    }
    return test;
    }    
    
}  