import java.net.*;
import java.io.*;
import tcpclient.TCPClient;

public class MyRunnable implements Runnable{

    Socket client;

    public MyRunnable(Socket s){
        client = s; 
    }

    public void run(){               //run method contains the code executed in the thread        
        //System.out.println("Thread says Hello");
try{
        String header = "HTTP/1.1 200 OK \r\n\r\n"; //servens godkännande till client, 200 OK är headern 
        String br = "HTTP/1.1 400 Bad Request\r\n";
        String nf = "HTTP/1.1 404 File Not Found\r\n"; 

        while(true){

            String character = null;
            String hostname = null;
            String portnr = null; 

            
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream())); //creates a inputstream
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

           
            String newstring = reader.readLine();
            String [] strings = newstring.split("[ =&?/]");

            

                for (int i = 0; i <strings.length; i++){
                        if (strings[i].equals("hostname")){
                            hostname = strings[i+1]; //Put the char after the hostname to be equal to hostname
                            i++;
                        }
                        else if (strings[i].equals("port")){
                            portnr = strings[i+1];
                            i++;

                        }
                        else if(strings[i].equals("string")){
                            character = strings[i+1];
                            i++;
                            
                        }
                    }
                    String serverAnswer = null;
                    if(strings[2].equals("ask") && hostname != null && portnr != null){

                    try{
                    String t = "HTTP/1.1 200 OK \r\n\r\n";
                    serverAnswer = TCPClient.askServer(hostname, Integer.parseInt(portnr), character);
                    StringBuilder data = new StringBuilder();
                    data.append(t + serverAnswer);
                    output.write(data.toString().getBytes());
                        
                        
                    }

                    catch(IOException e){

                        output.writeBytes(nf);

                    }
                }
                else{
                    output.writeBytes(br);
                }

            client.close();
            output.close();
             
            }

        }

        catch(IOException e){
           // System.out.println("Error" + e);        
        }

    }

}