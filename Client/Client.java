import java.io.*;
import java.net.*;

public class Client
{
    public static void main() throws IOException 
    { 
        Socket sock = new Socket(InetAddress.getLocalHost(),9001);    
        Envoi(sock.getOutputStream(), true);        
        sock.close();
    } 
    
    public static void Envoi(OutputStream out, boolean closeOnExit) throws IOException
    {
	File fic = new File("Doc/essai.txt");
        byte buf[] = new byte[1024];         
        FileInputStream in = new FileInputStream(fic);       
        int n;
        while((n=in.read(buf))!=-1)  out.write(buf,0,n);
        
        if (closeOnExit)
        {
            in.close();
            out.close();
        }
    }
}
