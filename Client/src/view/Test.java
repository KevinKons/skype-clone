/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author dougl
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContact = new javax.swing.JPanel();
        btnTalk2 = new javax.swing.JButton();
        btnRemove2 = new javax.swing.JButton();
        lblStatus2 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        panelContact1 = new javax.swing.JPanel();
        btnTalk3 = new javax.swing.JButton();
        btnRemove3 = new javax.swing.JButton();
        lblStatus3 = new javax.swing.JLabel();
        lblName3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContact.setBackground(new java.awt.Color(255, 255, 255));

        btnTalk2.setText("Talk");
        btnTalk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTalk2ActionPerformed(evt);
            }
        });

        btnRemove2.setText("Remove");
        btnRemove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove2ActionPerformed(evt);
            }
        });

        lblStatus2.setText("status");

        lblName2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblName2.setText("Name");

        javax.swing.GroupLayout panelContactLayout = new javax.swing.GroupLayout(panelContact);
        panelContact.setLayout(panelContactLayout);
        panelContactLayout.setHorizontalGroup(
            panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContactLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStatus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContactLayout.createSequentialGroup()
                            .addComponent(btnRemove2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                            .addComponent(btnTalk2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        panelContactLayout.setVerticalGroup(
            panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContactLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTalk2)
                        .addComponent(btnRemove2))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panelContact1.setBackground(new java.awt.Color(255, 255, 255));

        btnTalk3.setText("Talk");
        btnTalk3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTalk3ActionPerformed(evt);
            }
        });

        btnRemove3.setText("Remove");
        btnRemove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove3ActionPerformed(evt);
            }
        });

        lblStatus3.setText("status");
        lblStatus3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblName3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblName3.setText("Name");

        javax.swing.GroupLayout panelContact1Layout = new javax.swing.GroupLayout(panelContact1);
        panelContact1.setLayout(panelContact1Layout);
        panelContact1Layout.setHorizontalGroup(
            panelContact1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
            .addGroup(panelContact1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContact1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelContact1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStatus3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContact1Layout.createSequentialGroup()
                            .addComponent(btnRemove3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                            .addComponent(btnTalk3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        panelContact1Layout.setVerticalGroup(
            panelContact1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(panelContact1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContact1Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelContact1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTalk3)
                        .addComponent(btnRemove3))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelContact1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelContact1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTalk2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTalk2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTalk2ActionPerformed

    private void btnRemove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemove2ActionPerformed

    private void btnTalk3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTalk3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTalk3ActionPerformed

    private void btnRemove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemove3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemove2;
    private javax.swing.JButton btnRemove3;
    private javax.swing.JButton btnTalk2;
    private javax.swing.JButton btnTalk3;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblStatus2;
    private javax.swing.JLabel lblStatus3;
    private javax.swing.JPanel panelContact;
    private javax.swing.JPanel panelContact1;
    // End of variables declaration//GEN-END:variables
}
