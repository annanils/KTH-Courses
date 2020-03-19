import java.net.*;
import java.io.*;
import tcpclient.TCPClient;

public class HTTPAsk  {
    public static void main( String[] args) throws IOException{

        int port = Integer.parseInt(args[0]); 
        ServerSocket newsocket = new ServerSocket(port);

        String header = "HTTP/1.1 200 OK \r\n\r\n"; //servens godkännande till client, 200 OK är headern 
        String br = "HTTP/1.1 400 Bad Request\r\n";
        String nf = "HTTP/1.1 404 File Not Found\r\n"; 

        
        while(true){

            String character = null;
            String hostname = null;
            String portnr = null; 

            Socket connection = newsocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //creates a inputstream
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());

           
            String newstring = reader.readLine();
            String [] strings = newstring.split("[ =&?]");

            

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
            if(strings[0].equals("GET") && (strings[6].equals("HTTP/1.1") || (strings.length >= 8 && strings[8].equals("HTTP/1.1")))){
                
                String serverAnswer = null;
                try{
                    if(strings[1].equals("/ask") && hostname != null && portnr != null){

                        String t = "HTTP/1.1 200 OK \r\n\r\n";
                        serverAnswer = TCPClient.askServer(hostname, Integer.parseInt(portnr), character);
                        StringBuilder data = new StringBuilder();
                        data.append(t + serverAnswer);
                        output.write(data.toString().getBytes());
                    }

                    else{
                        output.writeBytes(nf);
                    }
                }
    
                catch(IOException e){
                    output.writeBytes(nf);
                }
                
            }
            else{
                output.writeBytes(br);
            }
            

             
            connection.close();
            output.close();
             
            
        
        
        
        }
    }

}



