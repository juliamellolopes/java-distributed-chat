/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package middleware;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author julia
 */
public class MessageReaderServerThread extends Thread{
    private ServerSocket server;
    private Socket client;
    private boolean statusServidor;
    private int numCliente;
    
    public static long ultimaAtualizacao = System.currentTimeMillis();

    public MessageReaderServerThread()  {
        statusServidor = false;
        numCliente = 0;
    }
    
    public void run(){
        try{
            server = new ServerSocket(3323);
            server.setReuseAddress(true);
            statusServidor = true;
            
            while(statusServidor && !isInterrupted()){
                client = server.accept();
                numCliente++;
                
                try {
                    DataInputStream reader = new DataInputStream(client.getInputStream());
                    DataOutputStream writer = new DataOutputStream(client.getOutputStream());
                    
                    String comando = reader.readUTF();
                    
                    if (comando.equals("update?")) {
                        writer.writeLong(ultimaAtualizacao);
                    } else if (comando.equals("get")) {
                        String path = "C:\\Users\\julia\\Documents\\Faculdade\\Sistemas Distribuidos\\repositorio.txt";
                        StringBuilder sb = new StringBuilder(8 * 1024);
                        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                            String linha;
                            while ((linha = br.readLine()) != null) {
                                sb.append(linha);
                            }
                        }
                        writer.writeUTF(sb.toString());
                    }

                    writer.flush();
                    writer.close();
                    reader.close();
                    client.close();
                } catch (Exception error) {
                    if (statusServidor) {
                        JOptionPane.showMessageDialog(null, "Erro ao atender cliente leitura: " + error.getMessage());
                    }
                }
            }
        }catch(Exception error){
            if(statusServidor == true){
                JOptionPane.showMessageDialog(null,"Erro no modulo web: "+error.getMessage());
            }
        }
        
    }
    
    public static void atualizar() {
        ultimaAtualizacao = System.currentTimeMillis();
    }
    
    public void FecharServer() {
        statusServidor = false;
        numCliente = 0;
        try {
            if ((client != null) && (!client.isClosed())) {
                client.close();
            }
            if ((server != null) && !server.isClosed()) {
                server.close();
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error parar modulo leitura " + error.getMessage());
        }
    }
    
}
