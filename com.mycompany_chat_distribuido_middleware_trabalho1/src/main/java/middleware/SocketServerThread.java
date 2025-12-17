/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package middleware;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author julia
 */
public class SocketServerThread extends Thread{
    private ServerSocket server;
    private Socket client;
    private int numCliente;
    private boolean statusServidor = false;
    
    public SocketServerThread(){
        this.numCliente = 1;
    }
   
    @Override
    public void run(){
        try{
            server = new ServerSocket(3322);
            server.setReuseAddress(true);
            statusServidor = true;
            while(statusServidor && !isInterrupted()){
                client = server.accept();
                DataInputStream reader = new DataInputStream(client.getInputStream());
                String msg = reader.readUTF();
                msg = msg.replace("s2", "&#128151;");
                msg = msg.replace(":)", "&#128512;");
                msg = msg.replace(":-)", "&#128514;");
                
                client.close();
                
                String path = "C:\\Users\\julia\\Documents\\Faculdade\\Sistemas Distribuidos\\repositorio.txt";
                FileWriter fwriter = new FileWriter(path, true);
                fwriter.write(msg);
                fwriter.close();
                
                MessageReaderServerThread.atualizar();
                MessageReaderDesktopServerThread.atualizar();
            }
        }catch(Exception error){
            if(statusServidor == true){
                JOptionPane.showMessageDialog(null,"Erro no modulo web: "+error.getMessage());
            }
        }
    }
    
    public void FecharServidor(){
        statusServidor = false;
        numCliente = 0;
        try{
            if((client != null) && (!client.isClosed())){
               client.close(); 
            }
            if((server != null) &&!server.isClosed()){
                server.close();
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(null,"Error parar modulo web "+error.getMessage());
        }
    }
}
