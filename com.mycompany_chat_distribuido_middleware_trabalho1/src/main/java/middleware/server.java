/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package middleware;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author julia
 */
public class server {
    Menu mnuAcoes;
    CheckboxMenuItem mnuItemExecutar;
    PopupMenu mnuPopup;
    MenuItem mnuItemSobre;
    TrayIcon trayicon;
    SystemTray tray;
    
    
    CheckboxMenuItem mnuItemExecWeb;
    SocketServerThread Tweb;
    MessageReaderServerThread Mweb;
    
    CheckboxMenuItem mnuItemExecDesktop;
    SocketServerDesktopThread Tdesktop;               
    MessageReaderDesktopServerThread Mdesktop;
    
    CheckboxMenuItem mnuItemPublicidade;
    PublicidadeMulticastServer pubServer;
    public server(){
        try{
            //"opcional"
            if(SystemTray.isSupported() == false){
                System.out.println("Sem suporte a system tray");
            }else{
                mnuAcoes = new Menu("Ações");
                
                mnuItemExecutar = new CheckboxMenuItem("Executar todos");
                mnuAcoes.add(mnuItemExecutar);
                
                mnuItemExecWeb = new CheckboxMenuItem("Modulo Web");
                mnuAcoes.add(mnuItemExecWeb);
                
                mnuItemExecDesktop = new CheckboxMenuItem("Módulo Desktop");
                mnuAcoes.add(mnuItemExecDesktop);
                
                mnuItemPublicidade = new CheckboxMenuItem("Publicidade");
                mnuAcoes.add(mnuItemPublicidade);
                
                mnuPopup = new PopupMenu();
                mnuPopup.add(mnuAcoes);
                mnuPopup.addSeparator();
                mnuItemSobre = new MenuItem("sobre");
                mnuPopup.add(mnuItemSobre);
                
                mnuItemExecWeb.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            Tweb = new SocketServerThread();
                            Tweb.start();
                            
                            Mweb = new MessageReaderServerThread();
                            Mweb.start();
                            
                            JOptionPane.showMessageDialog(null, "Modulo web rodando");
                        }else {
                            Tweb.FecharServidor();
                            Mweb.FecharServer();
                            pubServer.pararServidor();
                            JOptionPane.showMessageDialog(null, "Modulo web parado");
                        }
                    }
                });
                
                mnuItemExecDesktop.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e){
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            Tdesktop = new SocketServerDesktopThread();     
                            Tdesktop.start();

                            Mdesktop = new MessageReaderDesktopServerThread();
                            Mdesktop.start();
                            
                            JOptionPane.showMessageDialog(null, "Módulo Desktop rodando");
                        }else {
                            Tdesktop.FecharServidor();
                            Mdesktop.FecharServer();
                            pubServer.pararServidor();
                            JOptionPane.showMessageDialog(null, "Módulo Desktop parado");
                        }
                    }
                });
                
                mnuItemPublicidade.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            pubServer = new PublicidadeMulticastServer();
                            pubServer.start();
                            JOptionPane.showMessageDialog(null, "Publicidade iniciada");
                        } else {
                            if (pubServer != null) {
                                pubServer.pararServidor();
                            }
                            JOptionPane.showMessageDialog(null, "Publicidade parada");
                        }
                    }
                });

                
                ImageIcon icone = new ImageIcon("Imagens/servidor.ico");
                trayicon = new TrayIcon(icone.getImage());
                trayicon.setPopupMenu(mnuPopup);
                tray = SystemTray.getSystemTray();
                tray.add(trayicon);
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(null,"Erro ao iniciar "+error.getMessage());
        }
    }
}
