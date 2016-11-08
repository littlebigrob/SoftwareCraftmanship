import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Robert on 11/2/2016.
 */
public class Client {
    private static InputStream input;
    private static OutputStream output;
    private static Socket socket;
    private static String hostname;
    private static int portNumber;
    private static Scanner user_scanner;

    public static void main(String argv[]) throws IOException{
        user_scanner=new Scanner(System.in);
        /*
        System.out.print("Enter HostName: ");
        hostname=user_scanner.next();
        System.out.print("Enter Port #: ");
        portNumber=Integer.parseInt(user_scanner.next());
        */
        hostname="0.0.0.0";
        portNumber=6000;
        String output;
        Socket clientSocket = new Socket (hostname, portNumber);
        DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Boolean isRunning=true;
        while (isRunning){
            if(inFromServer.ready()) {
                if (inFromServer.readLine().equals("CHATOPEN")) {
                    chatWith(outToServer, inFromServer);
                    outToServer.writeBytes("CHATOPEN" + '\n');
                }
            }
            System.out.print("Command: ");
            output=user_scanner.next();
            if (output.equals("UserName")){
                createUserName(outToServer);
                System.out.print(inFromServer.readLine()+'\n');
            }
            else if (output.equals("ChatWith")){
                setChatUp(outToServer,inFromServer);
            }
            else if (output.equals("CloseConnection")){
                outToServer.writeBytes(output+'\n');
                System.out.print(inFromServer.readLine());
                isRunning=false;
            }
        }
        inFromServer.close();
        outToServer.close();
        clientSocket.close();
        }

    private static void createUserName(DataOutputStream outToServer)throws IOException{
        String output;
        System.out.print("what is your UserName: ");
        output=user_scanner.next();
        outToServer.writeBytes("SetUSERNAME"+'\n'+output+'\n');

    }

    private static void setChatUp(DataOutputStream outToServer, BufferedReader inFromServer) throws IOException{
        String output;
        System.out.print("who do you want to chat with: ");
        output=user_scanner.next();
        if (output.equals("Listener")){
            if(inFromServer.readLine().equals("OpenChatWindow")){
                chatWith(outToServer,inFromServer);
            }
        }
        outToServer.writeBytes("setChatUP"+'\n'+output+'\n');
        if (inFromServer.ready()){
            if(inFromServer.readLine().equals("Unavailable")) {
                System.out.print(output + " is unavailable right now"+'\n');
                return;
            }
        }
        chatWith(outToServer, inFromServer);
    }

    private static void chatWith(DataOutputStream outToServer, BufferedReader inFromServer)throws IOException{
        String output;
        boolean chatOpen=true;
        while (chatOpen) {
            System.out.print("Message: ");
            output = user_scanner.next();
            outToServer.writeBytes(output+'\n');
            if (output.equals("closeChat")){
                chatOpen=false;
            }
            if (output.equals("ChatWith")){
                chatOpen=false;
                outToServer.writeBytes("closeChat"+'\n');
                setChatUp(outToServer,inFromServer);
            }
            if(!inFromServer.ready()) {
            }
            System.out.print(inFromServer.readLine() + '\n');
        }
    }
}
