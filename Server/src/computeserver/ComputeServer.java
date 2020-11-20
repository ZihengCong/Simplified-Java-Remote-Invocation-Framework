package computeserver;
import java.net.*;
import java.io.*;
import Contract.Task;
import Contract.CSMessage;
import Contract.CalculateGCD;
import Contract.CalculatePi;
import Contract.CalculatePrime;
import java.rmi.RemoteException;

/**
 * 
 * @author Ziheng Cong
 */

public class ComputeServer 
{
    /**
    * 
    * @MainMethodForServer
    */
    public static void main (String args[]) throws RemoteException
    {
        //ThreadA is the thread for object transfer
        Thread A = new Thread(() -> {
        try
        {
            System.out.println("------------------------------");
            System.out.println("The server is listening on port 6789 for object transfer...");
            ServerSocket server = new ServerSocket(6789);
            while (true) {
                    Socket socket = server.accept();
                    invoke(socket);
            }
        }catch (IOException ex1) {
            System.out.println("Connection:"+ex1.getMessage());
        }
        });
        A.start();
        //ThreadB is the thread for file transfer
        Thread B = new Thread(() -> {
            try
            {
                System.out.println("The server is listening on port 6790 for file transfer...");
                System.out.println("------------------------------");
                ServerSocket listenSocket = new ServerSocket(6790);
                while(true) 
                {
                    Socket clientSocket = listenSocket.accept();
                    Connection c2 = new Connection(clientSocket);
                } 
            } 
            catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
        });
        B.start();
    }
    
    /**
    * 
    * @ObjectResponse
    */
    private static void invoke(final Socket socket) throws IOException {
        new Thread(new Runnable() { //This will add new thread if new client come in
                public void run() {
                    ObjectInputStream is = null;
                    ObjectOutputStream os = null;
                    CSMessage csm = new CSMessage();
                    try {
                        is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                        os = new ObjectOutputStream(socket.getOutputStream());
                        //Receive Object
                        Object obj = is.readObject();
                        if (obj.toString().contains("CalculatePi")) {
                            CalculatePi user = (CalculatePi)obj;
                            user.executeTask();
                            //Contract.CalculatePi@75c71fdc
                            System.out.println("Performing a client task of "+obj.toString().split("@")[0]);
                            System.out.println("------------------------------");
                            //Send CalculatePi Object
                            os.writeObject(user);
                        }else if(obj.toString().contains("CalculatePrime")) {
                            CalculatePrime user = (CalculatePrime)obj;
                            user.executeTask();
                            System.out.println("Performing a client task of "+obj.toString().split("@")[0]);
                            System.out.println("------------------------------");
                            //Send CalculatePrime Object
                            os.writeObject(user);
                        }else if(obj.toString().contains("CalculateGCD")) {
                            CalculateGCD user = (CalculateGCD)obj;
                            user.executeTask();
                            System.out.println("Performing a client task of "+obj.toString().split("@")[0]);
                            System.out.println("------------------------------");
                            //Send CalculateGCD Object
                            os.writeObject(user);
                        }
                        os.flush();
                    } catch (IOException ex) {
                        csm.setMessage(ex.toString());
                        //Save error msg to CSMessage
                    } catch(ClassNotFoundException ex) {
                        csm.setMessage(ex.toString());
                        System.out.print("The compute-task "+csm.getResult().toString().split(": ")[1]+" cannot be found\n");
                        System.out.println("------------------------------");
                        try {
                            os.writeObject(csm);
                            //Send CSMessage to client which saves error msg
                            os.flush();
                        } catch (IOException ex1) {
                            System.out.println("Connection:"+ex.getMessage());
                        }
                    } 
                }
        }).start();
    }
}

/**
 * 
 * @FileTransferring
 */
class Connection extends Thread {
    InputStream in;
    OutputStream out;
    Socket clientSocket;
       	
    public Connection (Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = clientSocket.getInputStream();
            //Start the thread
            this.start();
        } catch(IOException e) {
            System.out.println("Connection:"+e.getMessage());
        }
    }
	
    public void run() {
        String ClassName=new String();
        while (true) {	
            try {			                
                //Construct data input stream to receive class files
                DataInputStream clientData = new DataInputStream(in);

                //Receive the class file name
                ClassName = clientData.readUTF();

                //Receive the class file length
                int size = clientData.readInt();

                //Construct a byte array to receive the class file
                byte[] buffer = new byte[size];
                int bytesRead = clientData.read(buffer, 0, buffer.length);

                //Construct a file output stream to save the class file
                FileOutputStream fo=new FileOutputStream("Contract/"+ClassName);
                BufferedOutputStream bos = new BufferedOutputStream(fo);
                bos.write(buffer,0,bytesRead);
                bos.close();
                System.out.println("The class file of "+ClassName+" has been uploaded.");
                
            } catch (EOFException e) {
                System.out.println("EOF"+e.getMessage()); 
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File "+ClassName+" cannot find."); 
                break;
            } catch (SocketException e) {
                System.out.println("Client closed."); 
                break;
            } catch(IOException e) {
                e.printStackTrace(); 
                break;
            }
        }
    }
}

