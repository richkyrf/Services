package File;

import static F.Enc.getEncryptedPassword;
import F.RunUpd;
import static F.VarJFrame.resetPassword;
import static F.VarJFrame.tampil_User;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.toUpperCase;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class ResetPassword extends javax.swing.JFrame {

    /**
     *
     * @param User
     * @param Pass
     */
    public ResetPassword(String User, String Pass) {
        username = User;
        password = Pass;
        initComponents();
        setTitle("RESET KATA SANDI");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     *
     * @param S
     */
    public void Refresh(String S) {
        txtUsername.setText(S);
        txtpassbaru.setText("");
        txtpassbaru2.setText("");
    }
    private final String username;

    /**
     *
     */
    protected String password;

     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          txtUsername = new javax.swing.JTextField();
          jButton1 = new javax.swing.JButton();
          txtpassbaru2 = new javax.swing.JPasswordField();
          txtpassbaru = new javax.swing.JPasswordField();
          jLabel5 = new javax.swing.JLabel();

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

          txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txtUsername.setText(username);
          txtUsername.setDisabledTextColor(new java.awt.Color(0, 0, 153));
          txtUsername.setEnabled(false);

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
          txtpassbaru2.setDisabledTextColor(new java.awt.Color(0, 0, 153));
          txtpassbaru2.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyTyped(java.awt.event.KeyEvent evt)
               {
                    txtpassbaru2KeyTyped(evt);
               }
          });

          txtpassbaru.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txtpassbaru.setDisabledTextColor(new java.awt.Color(0, 0, 153));
          txtpassbaru.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyTyped(java.awt.event.KeyEvent evt)
               {
                    txtpassbaruKeyTyped(evt);
               }
          });

          jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel5.setText("Password Baru");

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
                              .addComponent(jLabel5)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtpassbaru, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addComponent(jLabel3)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtpassbaru2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(261, 261, 261)
                              .addComponent(jButton1)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5});

          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
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

          layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5});

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if ("".equals(new String(txtpassbaru.getPassword())) || ("".equals(new String(txtpassbaru2.getPassword())))) {
             showMessageDialog(this, "Password  Tidak Boleh Kosong ! ");
         } else if (!new String(txtpassbaru.getPassword()).equals(new String(txtpassbaru2.getPassword()))) {
             showMessageDialog(this, "password baru dan konfirmasi password baru harus sama !");
         } else {
             String dialogbaru = "Apakah Anda Yakin Mau Mereset Password user - '" + txtUsername.getText() + " ? ";
             int reply = showConfirmDialog(null, dialogbaru, "konfirmasi", YES_NO_OPTION);
             if (reply == YES_OPTION) {
                 simpan();
             }
         }
     }//GEN-LAST:event_jButton1ActionPerformed

     private void txtpassbaruKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassbaruKeyTyped
         if (new String(txtpassbaru.getPassword()).length() == 45) {
             evt.consume();
         }
         char keyChar = evt.getKeyChar();
         if (isLowerCase(keyChar)) {
             evt.setKeyChar(toUpperCase(keyChar));
         }
     }//GEN-LAST:event_txtpassbaruKeyTyped

     private void txtpassbaru2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassbaru2KeyTyped
         if (new String(txtpassbaru2.getPassword()).length() == 45) {
             evt.consume();
         }
         char keyChar = evt.getKeyChar();
         if (isLowerCase(keyChar)) {
             evt.setKeyChar(toUpperCase(keyChar));
         }
     }//GEN-LAST:event_txtpassbaru2KeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        resetPassword = null;
    }//GEN-LAST:event_formWindowClosing

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JTextField txtUsername;
     private javax.swing.JPasswordField txtpassbaru;
     private javax.swing.JPasswordField txtpassbaru2;
     // End of variables declaration//GEN-END:variables

    public void simpan() {
        int no;
        RunUpd runUpd = new F.RunUpd();
        runUpd.setQuery("Update `tuser` set  `Password`= '" + getEncryptedPassword(new String(txtpassbaru2.getPassword())) + "' where `User`='" + txtUsername.getText() + "'");
        runUpd.excute();
        runUpd.seterorm("Gagal Reset Password User");
        no = runUpd.excute();
        if (no != 0) {
            showMessageDialog(this, "Berhasil Reset  Password");
            if (tampil_User == null) {
                tampil_User = new File.Tampil_User();
            }
            F.History.STambah("Reset Password " + txtUsername.getText());
            resetPassword.dispose();
            resetPassword = null;
        }
    }
    private static final Logger LOG = Logger.getLogger(ResetPassword.class.getName());
}
