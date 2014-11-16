import java.io.*;
import java.net.*;

public class Serveur
{
    public static void main() throws IOException 
    { 
        Socket sock = new ServerSocket(9001).accept();        
        reception( sock.getInputStream(), true);        
        sock.close(); 
    } 
    
    public static void reception(InputStream in, boolean closeOnExit) throws IOException
    {
	File fic = new File("Doc/Test");
	FileOutputStream out = new FileOutputStream(fic);	
        byte buf[] = new byte[1024];        
        int n;
        while((n=in.read(buf))!=-1)  out.write(buf,0,n);
        
        if (closeOnExit)
        {
            in.close();
            out.close();
        }
    }
}
