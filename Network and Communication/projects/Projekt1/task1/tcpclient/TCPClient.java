package tcpclient;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    
    
    public static String askServer(String hostname, int port, String toServer) throws  IOException {
        if(toServer == null) {
            return askServer(hostname, port); 
        }  
        
        Socket socket = new Socket(hostname, port);
        socket.setSoTimeout(3000); 
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
   
        InputStream instr = socket.getInputStream(); //Read data from the server
   
        BufferedReader reader = new BufferedReader(new InputStreamReader(instr));
   
        toServer += "\n";
        out.write(toServer.getBytes());
        //out.writeUTF(toServer + '\n'); //writes toServer to the server. what we write to the server is kth.se
        
        int character;
        StringBuilder sb = new StringBuilder("");
           
   
           try{
           while((character = reader.read()) != -1){
   
               sb.append((char)character);
               
   
           }   
   
           socket.close();
   
          return sb.toString();
       }
           catch(IOException e){
            
            socket.close();
            return sb.toString();
       }
   
    }

    public static String askServer(String hostname, int port) throws  IOException {
        Socket socket = new Socket(hostname, port);
        //Set timer 
        socket.setSoTimeout(3000); 

        

        InputStream instr = socket.getInputStream(); //Read data from the server

        BufferedReader reader = new BufferedReader(new InputStreamReader(instr));

        int character;
        StringBuilder sb = new StringBuilder();
        
        try{
        while((character = reader.read()) != -1){
            sb.append((char)character);
        }   

        socket.close();

       return sb.toString();

    }
     catch(IOException e){
        socket.close();
        return sb.toString();
    }    
    }
}

