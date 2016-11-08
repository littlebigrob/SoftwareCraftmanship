import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by Robert on 11/2/2016.
 */
public class Server implements Runnable{
    private static Thread t;
    private static ServerSocket serverSocket;
    private static Socket connectionSocket;
    private static HashMap<String, Socket> usernameList = new HashMap<>();
    private static HashMap<String, String> chatting=new HashMap<>();
    Server(Socket connectionSocket){
        this.connectionSocket=connectionSocket;
    }

    public void start() {
        if (t==null) {
            t = new Thread();
            t.start();
        }
    }

    public void run() {
        try {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            serverReader(inFromClient, connectionSocket, outToClient);
            inFromClient.close();
            outToClient.close();
            connectionSocket.close();
        }
        catch (IOException e){
            System.out.print("IOEXPETION");
        }
    }

    public static void main(String arg[]) throws Exception {
        serverSocket = new ServerSocket(6000);
        while (true) {
            connectionSocket = serverSocket.accept();
            new Thread(new Server(connectionSocket)).start();
        }
    }

    private static void serverReader(BufferedReader inFromClient,
                                    Socket connectionSocket, DataOutputStream outToClient) throws IOException {
        Boolean connectionOpen=true;
        while (connectionOpen) {
            String clientSentence=inFromClient.readLine();
            if (clientSentence.equals("SetUSERNAME")) {
                String userName = inFromClient.readLine();
                usernameList.put(userName, connectionSocket);
                outToClient.writeBytes("User Name set to:  " + userName + '\n');
            }
            else if (clientSentence.equals("setChatUP")) {

                String username=inFromClient.readLine();

                checkValidity(username, outToClient);

                Socket client2 = usernameList.get(username);
                BufferedReader inFromClient2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));

                DataOutputStream outToClient2 = new DataOutputStream(client2.getOutputStream());
                chat(username, inFromClient, inFromClient2, outToClient, outToClient2);
            }
            else if (clientSentence.equals("closeConnection")){
                connectionOpen=false;
                outToClient.writeBytes("close connection"+'\n');
                return;
            }
            else{

            }
        }
    }

    private static void chat(String username, BufferedReader inFromClient, BufferedReader inFromClient2,
                             DataOutputStream outToClient1, DataOutputStream outToClient2) throws IOException {
        boolean chatOpen = true;
        outToClient1.writeBytes("chat with "+username+" started");
        outToClient2.writeBytes("OpenChatWindow");
        while (chatOpen) {
            chatOpen = openChat(inFromClient, inFromClient2, outToClient1, outToClient2);
        }
    }



    private static boolean openChat(BufferedReader inFromClient, BufferedReader inFromClient2,
                                 DataOutputStream outToClient1, DataOutputStream outToClient2) throws IOException {
        String client1Message;
        while (true){
            client1Message = inFromClient.readLine();
            if (client1Message.equals("closeChat"))
                return false;
            outToClient2.writeBytes(client1Message+'\n');
        }
    }

    public static void checkValidity(String username, DataOutputStream outToClient)throws IOException{
        if (!usernameList.containsKey(username)){
            outToClient.writeBytes("Not A User" + '\n');
            return;
        }
        else if (chatting.containsKey(username)||chatting.containsValue(username)){
            outToClient.writeBytes("Already chatting"+'\n');
            return;
        }
    }
}