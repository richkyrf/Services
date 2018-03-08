package File;

import F.RunSelctOne;
import F.RunUpd;
import java.beans.PropertyChangeSupport;
import javax.swing.JOptionPane;

public class Ubah_Kata_Sandi extends javax.swing.JFrame {

    static final String PROP_USERNAME = "PROP_USERNAME";
    protected final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    public Ubah_Kata_Sandi(String User) {
        username = User;
        initComponents();
        setTitle("UBAH KATA SANDI");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void Refresh(String U) {
        username = U;
        txtUsername.setText(U);
        txtPasslama.setText("");
        txtpassbaru.setText("");
        txtpassbaru2.setText("");
    }
    protected String username;

     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jButton1 = new javax.swing.JButton();
          txtpassbaru2 = new javax.swing.JPasswordField();
          jLabel4 = new javax.swing.JLabel();
          txtPasslama = new javax.swing.JPasswordField();
          txtpassbaru = new javax.swing.JPasswordField();
          jLabel5 = new javax.swing.JLabel();
          txtUsername = new F.JackTextField();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter()
          {
               public void windowClosing(java.awt.event.WindowEvent evt)
               {
                    formWindowClosing(evt);
               }
          });

          jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel2.setText("Username");

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel3.setText("Ulangi Password Baru");

          jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jButton1.setText("Ubah");
          jButton1.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton1ActionPerformed(evt);
               }
          });

          txtpassbaru2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txtpassbaru2.setDisabledTextColor(new java.awt.Color(0, 0, 102));
          txtpassbaru2.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyTyped(java.awt.event.KeyEvent evt)
               {
                    txtpassbaru2KeyTyped(evt);
               }
          });

          jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel4.setText("Password Lama");

          txtPasslama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txtPasslama.setDisabledTextColor(new java.awt.Color(0, 0, 102));
          txtPasslama.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyTyped(java.awt.event.KeyEvent evt)
               {
                    txtPasslamaKeyTyped(evt);
               }
          });

          txtpassbaru.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txtpassbaru.setDisabledTextColor(new java.awt.Color(0, 0, 102));
          txtpassbaru.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyTyped(java.awt.event.KeyEvent evt)
               {
                    txtpassbaruKeyTyped(evt);
               }
          });

          jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel5.setText("Password Baru");

          txtUsername.setmaxtText(50);
          txtUsername.setText(username);
          txtUsername.setEnabled(false);
          txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addComponent(jLabel2)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addComponent(jLabel4)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtPasslama, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addComponent(jLabel5)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtpassbaru, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addComponent(jLabel3)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtpassbaru2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(261, 261, 261)
                              .addComponent(jButton1)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(txtPasslama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel5)
                         .addComponent(txtpassbaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(txtpassbaru2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addComponent(jButton1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if ("".equals(new String(txtPasslama.getPassword())) || "".equals(new String(txtpassbaru.getPassword())) || "".equals(new String(txtpassbaru2.getPassword()))) {
             JOptionPane.showMessageDialog(this, "password  tidak boleh kosong ! ");
         } else if (!new String(txtpassbaru.getPassword()).equals(new String(txtpassbaru2.getPassword()))) {
             JOptionPane.showMessageDialog(this, " password baru dan konfirmasi password baru harus sama !");
         } else {
             cariuser();
         }
     }//GEN-LAST:event_jButton1ActionPerformed

     private void txtPasslamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasslamaKeyTyped
         if (new String(txtPasslama.getPassword()).length() == 45) {
             evt.consume();
         }
         char keyChar = evt.getKeyChar();
         if (Character.isLowerCase(keyChar)) {
             evt.setKeyChar(Character.toUpperCase(keyChar));
         }
     }//GEN-LAST:event_txtPasslamaKeyTyped

     private void txtpassbaruKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassbaruKeyTyped
         if (new String(txtpassbaru.getPassword()).length() == 45) {
             evt.consume();
         }
         char keyChar = evt.getKeyChar();
         if (Character.isLowerCase(keyChar)) {
             evt.setKeyChar(Character.toUpperCase(keyChar));
         }
     }//GEN-LAST:event_txtpassbaruKeyTyped

     private void txtpassbaru2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassbaru2KeyTyped
         if (new String(txtpassbaru2.getPassword()).length() == 45) {
             evt.consume();
         }
         char keyChar = evt.getKeyChar();
         if (Character.isLowerCase(keyChar)) {
             evt.setKeyChar(Character.toUpperCase(keyChar));
         }
     }//GEN-LAST:event_txtpassbaru2KeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        F.VarJFrame.ubah_Kata_Sandi = null;
    }//GEN-LAST:event_formWindowClosing

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JPasswordField txtPasslama;
     private F.JackTextField txtUsername;
     private javax.swing.JPasswordField txtpassbaru;
     private javax.swing.JPasswordField txtpassbaru2;
     // End of variables declaration//GEN-END:variables

    protected void simpan() {
        RunUpd runUpd = new F.RunUpd();
        runUpd.setQuery("Update  `tuser` set  `Password`= '" + F.Enc.getEncryptedPassword(new String(txtpassbaru2.getPassword())) + "' where `User`= '" + txtUsername.getText() + "' ");
        runUpd.seterorm("Gagal Mengubah Password");
        int no = runUpd.excute();
        if (no == 1) {
            JOptionPane.showMessageDialog(this, "Berhasil ubah  password");
            F.History.STambah("Ubah Pass " + txtUsername.getText() + " " + txtpassbaru.getText());
            if (F.VarJFrame.tampil_User == null) {
                F.VarJFrame.tampil_User = new File.Tampil_User();
            }
            this.dispose();
            F.VarJFrame.tampil_User = null;
        }
    }

    void cariuser() {
        RunSelctOne runSelctOne = new F.RunSelctOne();
        runSelctOne.setQuery("Select * from tuser where `user`= '" + txtUsername.getText().toUpperCase() + "' and `password`= '" + F.Enc.getEncryptedPassword(new String(txtPasslama.getPassword())) + "'");
        runSelctOne.seterorm("gagal Ganti Pass");
        String a = runSelctOne.excute();
        if (a != null) {
            simpan();
        } else {
            JOptionPane.showMessageDialog(null, " Password lama salah", "Pesan Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
