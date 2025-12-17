/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pacote;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

/**
 *
 * @author julia
 */
public class FRMLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FRMLogin.class.getName());

    /**
     * Creates new form FRMLogin
     */
    public FRMLogin() {
        initComponents();
        
        personalizarUI();
    }
    
    private void personalizarUI(){
        Color bgNavy      = new Color(10, 25, 47);  
        Color primaryBlue = new Color(33, 150, 243); 
        Color textLight   = Color.WHITE;
        
        java.awt.Font fontLabel   = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14);
        java.awt.Font fontText    = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);
        java.awt.Font fontRadio   = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13);
        java.awt.Font fontButton  = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15);

        getContentPane().setBackground(bgNavy);

        ldlNick.setForeground(textLight);
        ldlNick.setFont(fontLabel);

        ldlCor.setForeground(textLight);
        ldlCor.setFont(fontLabel);

        txtNick.setBackground(Color.WHITE);
        txtNick.setForeground(Color.DARK_GRAY);
        txtNick.setCaretColor(Color.DARK_GRAY);
        txtNick.setFont(fontText);
        
        radAzul.setBackground(bgNavy);
        radVerde.setBackground(bgNavy);
        radPreto.setBackground(bgNavy);

        radAzul.setForeground(textLight);
        radVerde.setForeground(textLight);
        radPreto.setForeground(textLight);
        
        radAzul.setFont(fontRadio);
        radVerde.setFont(fontRadio);
        radPreto.setFont(fontRadio);

        btnEntrar.setBackground(primaryBlue);
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFont(fontButton);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(6, 18, 6, 18)
        );
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEntrar.setOpaque(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        grpcor = new javax.swing.ButtonGroup();
        ldlNick = new javax.swing.JLabel();
        ldlCor = new javax.swing.JLabel();
        txtNick = new javax.swing.JTextField();
        radAzul = new javax.swing.JRadioButton();
        radVerde = new javax.swing.JRadioButton();
        radPreto = new javax.swing.JRadioButton();
        btnEntrar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        ldlNick.setText("Nick Name:");

        ldlCor.setText("Cor:");

        txtNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickActionPerformed(evt);
            }
        });

        grpcor.add(radAzul);
        radAzul.setForeground(java.awt.Color.blue);
        radAzul.setText("Azul");

        grpcor.add(radVerde);
        radVerde.setForeground(java.awt.Color.green);
        radVerde.setText("Verde");
        radVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radVerdeActionPerformed(evt);
            }
        });

        grpcor.add(radPreto);
        radPreto.setSelected(true);
        radPreto.setText("Preto");

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ldlCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ldlNick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radPreto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrar)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldlNick)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldlCor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radAzul)
                    .addComponent(radVerde)
                    .addComponent(radPreto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNickActionPerformed

    private void radVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radVerdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radVerdeActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        Util.nick = txtNick.getText();
        if (radAzul.isSelected()){
            Util.cor = "blue";
        } else if(radVerde.isSelected()) {
            Util.cor = "green";
        } else {
            Util.cor = "black";
        }
        
        FRMSala frmsala = new FRMSala();
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        frmsala.setBounds((toolkit.getScreenSize().width / 2) - (frmsala.getWidth() / 2),
                (toolkit.getScreenSize().height / 2) - (frmsala.getHeight() / 2), frmsala.getWidth(), frmsala.getHeight());
        
        frmsala.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnEntrarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.ButtonGroup grpcor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel ldlCor;
    private javax.swing.JLabel ldlNick;
    private javax.swing.JRadioButton radAzul;
    private javax.swing.JRadioButton radPreto;
    private javax.swing.JRadioButton radVerde;
    private javax.swing.JTextField txtNick;
    // End of variables declaration//GEN-END:variables
}
