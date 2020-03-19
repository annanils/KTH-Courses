import java.net.*;
import java.io.*;

public class HTTPEcho {
    public static void main( String[] args) throws UnknownHostException, IOException {
        int port = Integer.parseInt(args[0]); 
        ServerSocket newsocket = new ServerSocket(port); //the serversocket 
        

        while(true){
            Socket connection = newsocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //creates a inputstream
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
           
            String character = "";

            try{
                String t = "HTTP/1.1 200 OK \r\n\r\n"; //servens godkännande till client, 200 OK är headern 
                output.write(t.getBytes());
                while((character =  reader.readLine()) != null && character.length() != 0){
                    
                    System.out.println(character); // servern skriver till sig själv 
                    character += "\r\n";
                    output.write(character.getBytes()); //skriver till clienten 
                    
                }   
               
            }
            catch(IOException e){

                connection.close();
                
           }
             
           connection.close();
           output.close();
             
        }
   }
}
