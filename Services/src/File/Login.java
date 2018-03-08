package File;

import F.Enc;
import F.RunSelct;
import F.RunSelctOne;
import F.Variablebanking;
import Koneksi.firebirdCon;
import MU.MU;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author JACK
 */
public class Login extends javax.swing.JFrame {

    /**
     *
     */
    public Login() {
       // firebirdCon.connectfirebirdfirst();
        initComponents();
        setTitle("LOGIN");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          jLabel3 = new javax.swing.JLabel();
          txtKataSandiLogin = new javax.swing.JPasswordField();
          jLabel4 = new javax.swing.JLabel();
          jToggleButton1 = new javax.swing.JToggleButton();
          jToggleButton2 = new javax.swing.JToggleButton();
          txtNamaLogin = new F.JackTextField();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter()
          {
               public void windowClosing(java.awt.event.WindowEvent evt)
               {
                    formWindowClosing(evt);
               }
          });

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel3.setText("USER");

          txtKataSandiLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txtKataSandiLogin.setDisabledTextColor(new java.awt.Color(0, 0, 153));
          txtKataSandiLogin.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    txtKataSandiLoginActionPerformed(evt);
               }
          });

          jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel4.setText("PASSWORD");

          jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jToggleButton1.setText("MASUK");
          jToggleButton1.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jToggleButton1ActionPerformed(evt);
               }
          });
          jToggleButton1.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyPressed(java.awt.event.KeyEvent evt)
               {
                    jToggleButton1KeyPressed(evt);
               }
          });

          jToggleButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jToggleButton2.setText("KELUAR");
          jToggleButton2.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jToggleButton2ActionPerformed(evt);
               }
          });
          jToggleButton2.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyPressed(java.awt.event.KeyEvent evt)
               {
                    jToggleButton2KeyPressed(evt);
               }
          });

          txtNamaLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txtNamaLogin.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyReleased(java.awt.event.KeyEvent evt)
               {
                    txtNamaLoginKeyReleased(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addGroup(layout.createSequentialGroup()
                              .addComponent(jToggleButton1)
                              .addGap(10, 10, 10)
                              .addComponent(jToggleButton2))
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                              .addGroup(layout.createSequentialGroup()
                                   .addContainerGap()
                                   .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(txtNamaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(10, 10, 10)
                                   .addComponent(jLabel4)
                                   .addGap(4, 4, 4)
                                   .addComponent(txtKataSandiLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(txtNamaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(3, 3, 3)
                              .addComponent(jLabel4))
                         .addComponent(txtKataSandiLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jToggleButton1)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(1, 1, 1)
                              .addComponent(jToggleButton2)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
         System.exit(0);
     }//GEN-LAST:event_jToggleButton2ActionPerformed

     private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
         Date dt = new Date();
         Calendar c = Calendar.getInstance();
         c.setTime(dt);
         c.add(Calendar.YEAR, +1);
         dt = c.getTime();
         Date dt2 = new Date();
         Calendar c2 = Calendar.getInstance();
         c2.setTime(dt2);
         c2.add(Calendar.YEAR, -1);
         dt2 = c2.getTime();
         //////system.out.printlnln("Dt" + dt);
         //////system.out.printlnln("Dt2" + dt2);
         if ((checktgl().after(dt)) || (checktgl().before(dt2))) {
             JOptionPane.showMessageDialog(this, "Eror !!!, Cek Server / CLient ");
         } else {
             PLogin();
         }
     }//GEN-LAST:event_jToggleButton1ActionPerformed

     private void txtKataSandiLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKataSandiLoginActionPerformed
         PLogin();
     }//GEN-LAST:event_txtKataSandiLoginActionPerformed

     private void jToggleButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jToggleButton1KeyPressed
         PLogin();
     }//GEN-LAST:event_jToggleButton1KeyPressed

     private void jToggleButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jToggleButton2KeyPressed
         System.exit(0);
     }//GEN-LAST:event_jToggleButton2KeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        F.VarJFrame.login = null;        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

     private void txtNamaLoginKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtNamaLoginKeyReleased
     {//GEN-HEADEREND:event_txtNamaLoginKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             txtKataSandiLogin.requestFocus();
         }
// TODO add your handling code here:
     }//GEN-LAST:event_txtNamaLoginKeyReleased

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JToggleButton jToggleButton1;
     private javax.swing.JToggleButton jToggleButton2;
     private javax.swing.JPasswordField txtKataSandiLogin;
     private F.JackTextField txtNamaLogin;
     // End of variables declaration//GEN-END:variables

    public void PLogin() {
        RunSelct runSelct = new F.RunSelct();
        try {
            ResultSet rs;
            runSelct.setQuery("SELECT `User`, `Password`, `Level` FROM `tuser` where `user`= '" + txtNamaLogin.getText() + "'  and `password`= '" + Enc.getEncryptedPassword(new String(txtKataSandiLogin.getPassword())) + "' limit 1");
            System.out.println();
            int no = 0;
            rs = runSelct.excute();
            if (runSelct.iskosong()) {
                JOptionPane.showMessageDialog(null, "Username dan Password salah", "Pesan Error", JOptionPane.ERROR_MESSAGE);
                txtNamaLogin.setText("");
                txtKataSandiLogin.setText("");
            } else {
                while (rs.next()) {
                    Variablebanking.Slevel = rs.getString("Level");
                }
                Variablebanking.SUsername = txtNamaLogin.getText();
                if (F.VarJFrame.menuUtama == null) {
                    F.VarJFrame.menuUtama = new MU();
                }
                F.History.STambah("Login");
                F.VarJFrame.login.dispose();
                F.VarJFrame.login = null;
            }
        } catch (Exception e) {
            //////system.out.printlnln("E43" + e);
            e.printStackTrace();
        } finally {
            runSelct.closecon();
        }
    }

    Date checktgl() {
        RunSelctOne runSelctOne = new F.RunSelctOne();
        runSelctOne.setQuery("select NOW()");
        return F.Datetostringwidthformat.getdatefromstring(runSelctOne.excute(), "yyyy-MM-dd");
    }

}
