package File;

import F.RunUpd;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.toUpperCase;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author JACK
 */
public class Tambah_User extends javax.swing.JFrame {

    /**
     *
     */
    public Tambah_User() {
        initComponents();
        setTitle("TAMBAH PENGGUNA BARU");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     *
     * @param S
     */
    public void Refresh(String S) {
        txtUsername.setText(S);
        Txtpassword.setText("");
    }
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jButton1 = new javax.swing.JButton();
          Txtpassword = new javax.swing.JPasswordField();
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
          jLabel2.setText("User");

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel3.setText("Password");

          jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jButton1.setText("Tambah");
          jButton1.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton1ActionPerformed(evt);
               }
          });

          Txtpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          Txtpassword.setDisabledTextColor(new java.awt.Color(0, 0, 153));
          Txtpassword.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyTyped(java.awt.event.KeyEvent evt)
               {
                    TxtpasswordKeyTyped(evt);
               }
          });

          txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(Txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createSequentialGroup()
                              .addGap(134, 134, 134)
                              .addComponent(jButton1)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(3, 3, 3)
                              .addComponent(jLabel2))
                         .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(3, 3, 3)
                              .addComponent(jLabel3))
                         .addComponent(Txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addComponent(jButton1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if ("".equals(txtUsername.getText()) || "".equals(new String(Txtpassword.getPassword()))) {
             showMessageDialog(this, "username atau password tidak boleh kosong !");
         } else {
             String User = txtUsername.getText();
             String Pass = new String(Txtpassword.getPassword());
             tambahuser(User, Pass);
         }

     }//GEN-LAST:event_jButton1ActionPerformed

     private void TxtpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtpasswordKeyTyped
         if (new String(Txtpassword.getPassword()).length() == 45) {
             evt.consume();
         }
         char keyChar = evt.getKeyChar();
         if (isLowerCase(keyChar)) {
             evt.setKeyChar(toUpperCase(keyChar));
         }
     }//GEN-LAST:event_TxtpasswordKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        F.VarJFrame.tambah_User = null;
    }//GEN-LAST:event_formWindowClosing

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JPasswordField Txtpassword;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private F.JackTextField txtUsername;
     // End of variables declaration//GEN-END:variables

    private void tambahuser(String Username, String Password) {
        RunUpd runUpd = new F.RunUpd();
        runUpd.setQuery("INSERT INTO `tuser`(`User`, `Password`, `Level`) VALUES ('" + txtUsername.getText() + "','" + F.Enc.getEncryptedPassword(Password) + "','" + "user" + "')");
        runUpd.seterorm("Gagal Tambah User");
        int no = runUpd.excute();
        if (no != 0) {
            showMessageDialog(this, "Berhasil tambah User");
            if (F.VarJFrame.tampil_User == null) {
                F.VarJFrame.tampil_User = new File.Tampil_User();
            }
            F.History.STambah("Tambah User " + txtUsername.getText());
            F.VarJFrame.tambah_User.dispose();
            F.VarJFrame.tambah_User = null;
        }
    }
    private static final Logger LOG = Logger.getLogger(Tambah_User.class.getName());
}
