/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pacote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 *
 * @author julia
 */
public class FRMSala extends javax.swing.JFrame {


    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FRMSala.class.getName());
    private Thread threadAtualizacao;
    private boolean executando = true;
    private long ultimaVersaoServidor = 0L;

    private javax.swing.JLabel lblPublicidade;
    private Thread threadPublicidade;
    private boolean publicidadeAtiva = true;
    private final String CAMINHO_IMAGENS = "C:\\Users\\julia\\Documents\\Faculdade\\Sistemas Distribuidos\\chat_distribuido_v3_g1\\src\\main\\java\\Imagens\\";

    public FRMSala() {
        initComponents();
        personalizarUI();
        inicializarPublicidade();
        iniciarPublicidadeMulticast();
        iniciarAtualizacaoAutomatica();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                executando = false;
                publicidadeAtiva = false;
            }
        });
    }

    private void personalizarUI() {
        Color bgNavy = new Color(10, 25, 47);
        Color primaryBlue = new Color(33, 150, 243);
        Color textLight = Color.WHITE;

        java.awt.Font fontLabel = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13);
        java.awt.Font fontText = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13);
        java.awt.Font fontButton = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13);

        getContentPane().setBackground(bgNavy);

        txtConversa.setBackground(Color.WHITE);
        txtConversa.setForeground(Color.DARK_GRAY);
        txtConversa.setFont(fontText);

        jScrollPane1.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(new Color(18, 32, 68), 1),
                        javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)
                )
        );

        ldlMsg.setForeground(textLight);
        ldlMsg.setFont(fontLabel);

        txtMsg.setBackground(Color.WHITE);
        txtMsg.setForeground(Color.DARK_GRAY);
        txtMsg.setCaretColor(Color.DARK_GRAY);
        txtMsg.setFont(fontText);
        txtMsg.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(primaryBlue, 1, true),
                        javax.swing.BorderFactory.createEmptyBorder(3, 6, 3, 6)
                )
        );

        btnEnviar.setBackground(primaryBlue);
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFont(fontButton);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(4, 14, 4, 14)
        );
        btnEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEnviar.setOpaque(true);

        pnlPublicidade.setBackground(Color.WHITE);
        pnlPublicidade.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(new Color(18, 32, 68), 1),
                        javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)
                )
        );
        pnlPublicidade.setPreferredSize(new java.awt.Dimension(180, 0));
        pnlPublicidade.setMinimumSize(new java.awt.Dimension(150, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConversa = new javax.swing.JTextPane();
        ldlMsg = new javax.swing.JLabel();
        txtMsg = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        pnlPublicidade = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FRMSala");

        txtConversa.setEditable(false);
        txtConversa.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(txtConversa);

        ldlMsg.setText("Mensagem:");

        txtMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsgActionPerformed(evt);
            }
        });
        txtMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMsgKeyReleased(evt);
            }
        });

        btnEnviar.setText("Enviar ");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPublicidadeLayout = new javax.swing.GroupLayout(pnlPublicidade);
        pnlPublicidade.setLayout(pnlPublicidadeLayout);
        pnlPublicidadeLayout.setHorizontalGroup(
            pnlPublicidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        pnlPublicidadeLayout.setVerticalGroup(
            pnlPublicidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ldlMsg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPublicidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPublicidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ldlMsg)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMsgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMsgActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        EnviarMsg();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtMsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EnviarMsg();
        }
    }//GEN-LAST:event_txtMsgKeyReleased

    public void EnviarMsg() {
        String texto = txtMsg.getText().trim();
        if (texto.isEmpty()) {
            return;
        }

        String msg = "<font color='" + Util.cor + "'>" + Util.nick + "</font> Diz: "
                + texto + "<br/>";

        try (Socket socket = new Socket("localhost", 3332); DataOutputStream writer = new DataOutputStream(socket.getOutputStream())) {

            writer.writeUTF(msg);
            writer.flush();
            txtMsg.setText("");
            txtMsg.requestFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao enviar mensagem para o servidor: " + e.getMessage());
            logger.log(Level.SEVERE, "Erro ao enviar mensagem para o servidor", e);
        }
    }

    private void iniciarAtualizacaoAutomatica() {
        threadAtualizacao = new Thread(new Runnable() {
            @Override
            public void run() {
                while (executando) {
                    try {
                        long ultimaServer = consultarUltimaAtualizacaoServidor();
                        if (ultimaServer > ultimaVersaoServidor) {
                            ultimaVersaoServidor = ultimaServer;
                            String html = obterMensagensDoServidor();
                            atualizarConversa(html);
                        }
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        logger.log(Level.WARNING, "Erro na thread de atualização do chat", e);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            executando = false;
                        }
                    }
                }
            }
        });
        threadAtualizacao.start();
    }

    private long consultarUltimaAtualizacaoServidor() throws Exception {
        try (Socket socket = new Socket("localhost", 3333); DataOutputStream writer = new DataOutputStream(socket.getOutputStream()); DataInputStream reader = new DataInputStream(socket.getInputStream())) {

            writer.writeUTF("update?");
            writer.flush();

            return reader.readLong();
        }
    }

    private String obterMensagensDoServidor() throws Exception {
        try (Socket socket = new Socket("localhost", 3333); DataOutputStream writer = new DataOutputStream(socket.getOutputStream()); DataInputStream reader = new DataInputStream(socket.getInputStream())) {

            writer.writeUTF("get");
            writer.flush();

            return reader.readUTF();
        }
    }

    private String aplicarEstiloBaloes(String html) {
        html = html.replace("\r\n", "\n");
        html = html.replace("\n", "<br/>");

        String[] linhas = html.split("(?i)<br\\s*/?>");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><body style='margin:0;padding:0;font-family:Segoe UI,sans-serif;font-size:12px;'>");

        for (String linha : linhas) {
            if (linha == null) {
                continue;
            }
            String lt = linha.trim();
            if (lt.isEmpty()) {
                continue;
            }

            sb.append("<div style=\"")
                    .append("background-color:#f3f6fb;")
                    .append("border-radius:5px;")
                    .append("padding:2px 5px;")
                    .append("margin:0 0 2px 0;")
                    .append("display:block;")
                    .append("font-size:10px;")
                    .append("\">");

            sb.append(lt);
            sb.append("</div>");
        }

        sb.append("</body></html>");
        return sb.toString();
    }

    private void atualizarConversa(final String html) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String h = html.replaceAll("<img[^>]*>", "");
                h = h.replace("&#128512;", ":)");
                h = h.replace("&#128514;", ":-)");
                h = h.replace("&#128151;", "s2");
                h = h.replaceAll("&#\\d+;", " ");
                h = aplicarEstiloBaloes(h);

                txtConversa.setContentType("text/html");
                txtConversa.setText(h);
                txtConversa.setCaretPosition(txtConversa.getDocument().getLength());
            }
        });
    }

    private void inicializarPublicidade() {
        lblPublicidade = new javax.swing.JLabel();
        lblPublicidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPublicidade.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblPublicidade.setOpaque(true);
        lblPublicidade.setBackground(java.awt.Color.WHITE);

        pnlPublicidade.setLayout(new BorderLayout());
        pnlPublicidade.add(lblPublicidade, BorderLayout.CENTER);

        pnlPublicidade.revalidate();
        pnlPublicidade.repaint();
    }

    private void iniciarPublicidadeMulticast() {
        threadPublicidade = new Thread(() -> {
            MulticastSocket socket = null;
            try {
                int porta = 5000;
                InetAddress grupo = InetAddress.getByName("230.0.0.1");
                socket = new MulticastSocket(porta);
                java.net.NetworkInterface ni = java.net.NetworkInterface.getByInetAddress(java.net.InetAddress.getLocalHost());
                java.net.SocketAddress addr = new java.net.InetSocketAddress(grupo, porta);
                socket.joinGroup(addr, ni);

                byte[] buffer = new byte[256];

                while (publicidadeAtiva) {
                    DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
                    socket.receive(pacote);

                    String anuncio = new String(
                            pacote.getData(),
                            0,
                            pacote.getLength(),
                            StandardCharsets.UTF_8
                    );

                    atualizarPublicidadeImagem(anuncio);
                }

                socket.leaveGroup(addr, ni);
                socket.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no cliente multicast de publicidade: " + e.getMessage());
            }
        });

        threadPublicidade.start();
    }

    private void atualizarPublicidadeImagem(String nomeArquivo) {
        SwingUtilities.invokeLater(() -> {
            try {
                String nome = nomeArquivo.trim();
                if (nome.isEmpty()) {
                    lblPublicidade.setText("Sem anúncio");
                    lblPublicidade.setIcon(null);
                    return;
                }

                // monta a URL base do servidor web
                String baseUrl = "http://" + Util.SERVER_HOST + ":8080/bate_papo/Imagens/";
                String urlCompleta = baseUrl + nome;

                System.out.println("Carregando publicidade de: " + urlCompleta);

                URL url = new URL(urlCompleta);
                ImageIcon icon = new ImageIcon(url);

                if (icon.getIconWidth() <= 0) {
                    System.out.println("Imagem não encontrada: " + urlCompleta);
                    lblPublicidade.setText("Sem anúncio");
                    lblPublicidade.setIcon(null);
                    return;
                }

                int largura = pnlPublicidade.getWidth() > 0 ? pnlPublicidade.getWidth() : 140;
                int altura = pnlPublicidade.getHeight() > 0 ? pnlPublicidade.getHeight() : 300;

                java.awt.Image img = icon.getImage().getScaledInstance(
                        largura - 10, altura - 20, java.awt.Image.SCALE_SMOOTH
                );

                lblPublicidade.setText(null);
                lblPublicidade.setIcon(new ImageIcon(img));
                pnlPublicidade.revalidate();
                pnlPublicidade.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar publicidade: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ldlMsg;
    private javax.swing.JPanel pnlPublicidade;
    private javax.swing.JTextPane txtConversa;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables
}
