import java.net.*;
import java.io.*;
import tcpclient.TCPClient;

public class ConcHTTPAsk{
    public static void main(String[] args){

        try{

        int port = Integer.parseInt(args[0]); 
        ServerSocket newsocket = new ServerSocket(port); //creates a new server socket 

            while(true){
                Socket client = newsocket.accept();
                new Thread(new MyRunnable(client)).start(); //The MyRunnable object is passed into the Thread concstructor 
            }
        }
        catch(IOException e)
        {
        }
        
    }

}