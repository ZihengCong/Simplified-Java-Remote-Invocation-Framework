package client;
import Contract.CSMessage;
import Contract.CalculateGCD;
import Contract.CalculatePi;
import Contract.CalculatePrime;
import Contract.Task;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 * 
 * @author Ziheng Cong
 */

public class MainFrame extends javax.swing.JFrame 
{
    String taskFileName;
    Socket socketObject;
    Socket socket = null;
    OutputStream fileOut = null;
    ObjectOutputStream os = null;
    ObjectInputStream is = null;
    Boolean isConnected = false;
       
    public MainFrame() 
    {
        initComponents();
        UploadButton.setEnabled(false);
        CalculateButton.setEnabled(false);
        TaskComboBox.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ServerNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ServerPortFileTextField = new javax.swing.JTextField();
        ServerPortObjectTextField = new javax.swing.JTextField();
        SetButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TaskComboBox = new javax.swing.JComboBox<>();
        CalculateButton = new javax.swing.JButton();
        UploadButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTextArea = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simplified Remote Invocation Framework");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel1.setText("Server Name");

        ServerNameTextField.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        ServerNameTextField.setText("localhost");
        ServerNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerNameTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel2.setText("Server Port (File)");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel3.setText("Server Port (Object)");

        ServerPortFileTextField.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        ServerPortFileTextField.setText("6790");
        ServerPortFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerPortFileTextFieldActionPerformed(evt);
            }
        });

        ServerPortObjectTextField.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        ServerPortObjectTextField.setText("6789");
        ServerPortObjectTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerPortObjectTextFieldActionPerformed(evt);
            }
        });

        SetButton.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        SetButton.setText("Set");
        SetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel4.setText("Task List");

        TaskComboBox.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        TaskComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calculate Pi", "Calculate Prime", "Calculate the Greatest Common Divisor" }));
        TaskComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskComboBoxActionPerformed(evt);
            }
        });

        CalculateButton.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        CalculateButton.setText("Calculate");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });

        UploadButton.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        UploadButton.setText("Upload");
        UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });

        ResultTextArea.setColumns(20);
        ResultTextArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        ResultTextArea.setLineWrap(true);
        ResultTextArea.setRows(5);
        jScrollPane1.setViewportView(ResultTextArea);

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Calculation Results");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(35, 35, 35)
                                .addComponent(TaskComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ServerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ServerPortObjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ServerPortFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(SetButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(323, 323, 323))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ServerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ServerPortFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ServerPortObjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(SetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TaskComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalculateButton)
                    .addComponent(UploadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ServerNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ServerNameTextFieldActionPerformed

    private void ServerPortFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerPortFileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ServerPortFileTextFieldActionPerformed

    private void ServerPortObjectTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerPortObjectTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ServerPortObjectTextFieldActionPerformed

    private void SetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetButtonActionPerformed
        /**
         * @SetButtonAction: The two connection with server will be set up 
         */
        // Get ObjectServerPort, FileServerPort, SererName from GUI input
        int objectServerPort = Integer.parseInt(ServerPortObjectTextField.getText());
        int fileServerPort = Integer.parseInt(ServerPortFileTextField.getText());
        String serverName = ServerNameTextField.getText();
        
        if (isConnected == false) 
        {
            // Set Buttons Available
            UploadButton.setEnabled(true);
            CalculateButton.setEnabled(true);
            TaskComboBox.setEnabled(true);
            // Use thread to set up two connection
            Thread A = new Thread(() -> {
                try 
                {
                    socket = new Socket(serverName, objectServerPort);
                } catch (Exception ex){
                    ResultTextArea.append("Object Port Cannot Connect. Try Again Later.\n");
                }
            });
            Thread B = new Thread(() -> {
                try 
                {
                    socketObject = new Socket(serverName, fileServerPort);
                    fileOut = socketObject.getOutputStream();
                    isConnected = true; 
                }catch (Exception ex){
                    ResultTextArea.append("File Port Cannot Connect. Try Again Later.\n");
                }
            });
            // Start two thread
            A.start();
            B.start(); 
        } else if (isConnected = true) 
        {   
            // If the connection has been set up and hit Set button agian
            JOptionPane.showMessageDialog(null, "It's Already Connected", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_SetButtonActionPerformed

    private void UploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButtonActionPerformed
        /**
         * @UploadButtonAction: The task file will be uploaded from client side to server
         */
        // Get the chosen task from taskcombo box
        String TaskFromComboBox = TaskComboBox.getSelectedItem().toString();
        // Set the taskFilename reltaed to the chisce from combobox
        if (TaskFromComboBox == "Calculate Pi"){
            taskFileName = "CalculatePi.class";
        } 
        else if (TaskFromComboBox == "Calculate Prime"){
            taskFileName = "CalculatePrime.class";
        } 
        else if (TaskFromComboBox == "Calculate the Greatest Common Divisor"){
            taskFileName = "CalculateGCD.class";
        }
        // Upload start from here
        try{
            //Read the class file into a byte array
            String ClassName = taskFileName;
            CSMessage csm = new CSMessage();
            File ClassFile = new File("Contract/"+taskFileName);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ClassFile));
            DataInputStream dis = new DataInputStream(bis);   
            byte[] mybytearray = new byte[(int) ClassFile.length()]; 
            dis.readFully(mybytearray, 0, mybytearray.length);
            
            //Use a data output stream to send the class file
            DataOutputStream dos = new DataOutputStream(fileOut);
            
            //Send the class file name
            dos.writeUTF(ClassName);
            
            //Send the class file length
            dos.writeInt(mybytearray.length);
            
            //Send the class file
            dos.write(mybytearray, 0, mybytearray.length);   
            dos.flush();
            ResultTextArea.append("Uploading "+taskFileName+" is done.\n");
        }catch (UnknownHostException uhe){
            System.out.println("UnknowHost:"+uhe.getMessage());;
        } catch (IOException e){
            System.out.println("IO errors:"+e.getMessage());
        }
    }//GEN-LAST:event_UploadButtonActionPerformed

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        /**
         * @CalculateButton: This will calculate what been chose from combo box
         */
        //Get input from GUI
        int objectServerPort = Integer.parseInt(ServerPortObjectTextField.getText());
        int fileServerPort = Integer.parseInt(ServerPortFileTextField.getText());
        String serverName = ServerNameTextField.getText();
        String TaskFromComboBox = TaskComboBox.getSelectedItem().toString();
        //When the combo box choose Pi to calculate
        if (TaskFromComboBox == "Calculate Pi"){
            {   
                //Where the tiny input box come out to ask input integer
                JTextField integer = new JTextField(10);
                JPanel piPanel = new JPanel();
                piPanel.add(new JLabel("Integer 1:"));
                piPanel.add(integer);
                int primeInput = JOptionPane.showConfirmDialog(this, piPanel, "Please enter an integers", JOptionPane.OK_CANCEL_OPTION);
                //Action when hit ok button to continue
                if (primeInput == JOptionPane.OK_OPTION){
                    int pinum = Integer.parseInt(integer.getText());
                    try {
                        socket = new Socket(serverName, objectServerPort);
                        os = new ObjectOutputStream(socket.getOutputStream());
                        CalculatePi user = new CalculatePi(pinum);
                        os.writeObject(user);
                        //Send CalculatePi Object to server
                        os.flush();
                        //Receive object from server
                        is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                        Object obj = is.readObject();
                        //if object contains CalculatePi
                        if (obj.toString().contains("Contract.CalculatePi")) {
                            user = (CalculatePi)obj;
                            //Output to GUI textfield
                            ResultTextArea.append("Result: " + user.getResult() + "\n");
                            ResultTextArea.append("-----------------------------\n");
                        }else if (obj.toString().contains("Contract.CSMessage")){
                            CSMessage msg = (CSMessage)obj;
                            //java.lang.ClassNotFoundException: Contract.CalculatePi
                            ResultTextArea.append("Result: Please upload the compute-task "+msg.getResult().toString().split(": ")[1] + " before calling the server.\n");
                            ResultTextArea.append("-----------------------------\n");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
            }
        }
        
        else if (TaskFromComboBox == "Calculate Prime")
        {
            //Where the tiny input box come out to ask input integer
            JTextField integer = new JTextField(10);
            JPanel primePanel = new JPanel();
            primePanel.add(new JLabel("Integer 1:"));
            primePanel.add(integer);
            int primeInput = JOptionPane.showConfirmDialog(this, primePanel, "Please enter an integers", JOptionPane.OK_CANCEL_OPTION);
            //Action when hit ok button to continue
            if (primeInput == JOptionPane.OK_OPTION){
                int prinum = Integer.parseInt(integer.getText());
                try {
                    socket = new Socket(serverName, objectServerPort);
                    os = new ObjectOutputStream(socket.getOutputStream());
                    CalculatePrime user = new CalculatePrime(prinum);
                    os.writeObject(user);
                    //Send CalculatePrime object to server
                    os.flush();
                    //Receive from server
                    is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                    Object obj = is.readObject();
                    //if its CalculatePrime object
                    if (obj.toString().contains("Contract.CalculatePrime")) {	
                        user = (CalculatePrime)obj;
                        //Result: 19:2:3:5:7:11:13:17:19:23:29:31:37:41:43:47:53:59:61:67:
                        //To reorganise the format in textfield
                        String primeResult = user.getResult().toString();
                        ResultTextArea.append("Result: The number of primes is: " + primeResult.split(":")[0] + ", " +"and they are:  ");
                        int num = Integer.parseInt(primeResult.split(":")[0]);
                        for(int i = 1; i <= num-1; i++ ) {
                            String combo = primeResult.split(":")[i]+", ";
                            ResultTextArea.append(combo);
                        }
                        String lastone = primeResult.split(":")[num];
                        ResultTextArea.append(lastone+".\n");
                        ResultTextArea.append("-----------------------------\n");
                    }else if (obj.toString().contains("Contract.CSMessage")){
                        CSMessage msg = (CSMessage)obj;
                        //System.out.println("Pi: " + msg.getResult());
                        // java.lang.ClassNotFoundException: Contract.CalculatePi
                        ResultTextArea.append("Result: Please upload the compute-task "+msg.getResult().toString().split(": ")[1] + " before calling the server.\n");
                        ResultTextArea.append("-----------------------------\n");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        else if (TaskFromComboBox == "Calculate the Greatest Common Divisor")
        {
            //Where the tiny input box come out to ask input integer
            JTextField integer1 = new JTextField(10);
            JTextField integer2 = new JTextField(10);
            JPanel gcdPanel = new JPanel();
            gcdPanel.add(new JLabel("Integer 1"));
            gcdPanel.add(integer1);
            gcdPanel.add(Box.createHorizontalStrut(20));
            gcdPanel.add(new JLabel("Integer 2:"));
            gcdPanel.add(integer2);
            int gcdInput = JOptionPane.showConfirmDialog(this, gcdPanel, "Please enter 2 integers", JOptionPane.OK_CANCEL_OPTION);
            //Action when hit ok button to continue
            if (gcdInput == JOptionPane.OK_OPTION){
                int gcdnum1 = Integer.parseInt(integer1.getText());
                int gcdnum2 = Integer.parseInt(integer2.getText());
                try {
                    socket = new Socket(serverName, objectServerPort);
                    os = new ObjectOutputStream(socket.getOutputStream());
                    CalculateGCD user = new CalculateGCD(gcdnum1,gcdnum2);
                    os.writeObject(user);
                    //Send Object to server
                    os.flush();
                    //Receive Object from server
                    is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                    Object obj = is.readObject();
                    //if its the object of gcd
                    if (obj.toString().contains("Contract.CalculateGCD")) {
                        user = (CalculateGCD)obj;
                        ResultTextArea.append("Result: The Greatest Common Divisor of " + gcdnum1 + " and "+ gcdnum2 +" is "+ user.getResult()+ ".\n");
                        ResultTextArea.append("-----------------------------\n");

                    }else if (obj.toString().contains("Contract.CSMessage")){
                        CSMessage msg = (CSMessage)obj;
                        // java.lang.ClassNotFoundException: Contract.CalculatePi
                        ResultTextArea.append("Result: Please upload the compute-task "+msg.getResult().toString().split(": ")[1] + " before calling the server.\n");
                        ResultTextArea.append("-----------------------------\n");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void TaskComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaskComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalculateButton;
    private javax.swing.JTextArea ResultTextArea;
    private javax.swing.JTextField ServerNameTextField;
    private javax.swing.JTextField ServerPortFileTextField;
    private javax.swing.JTextField ServerPortObjectTextField;
    private javax.swing.JButton SetButton;
    private javax.swing.JComboBox<String> TaskComboBox;
    private javax.swing.JButton UploadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
