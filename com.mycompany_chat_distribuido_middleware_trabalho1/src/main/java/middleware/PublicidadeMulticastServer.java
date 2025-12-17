/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package middleware;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
/**
 *
 * @author julia
 */
public class PublicidadeMulticastServer extends Thread{
    private final String[] anuncios = {
        "coca.jpg",
        "frango.jpg"
    };

    private boolean rodando = true;

    @Override
    public void run() {
        MulticastSocket socket = null;
        try {
            socket = new MulticastSocket();
            InetAddress grupo = InetAddress.getByName("230.0.0.1");
            int porta = 5000;

            while (rodando) {
                int idx = (int) (Math.random() * anuncios.length);
                String msg = anuncios[idx];

                byte[] dados = msg.getBytes(StandardCharsets.UTF_8);
                DatagramPacket pacote = new DatagramPacket(
                        dados, dados.length, grupo, porta);

                socket.send(pacote);

                System.out.println("Enviando anuncio multicast: " + msg);

                Thread.sleep(7000);
            }
            socket.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no servidor de publicidade multicast: " + e.getMessage());
        }   
    }

    public void pararServidor() {
        rodando = false;
    }
}
