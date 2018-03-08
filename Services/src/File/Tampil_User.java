package File;

import F.AutoSetJtable;
import F.Jktable;
import static F.VarJFrame.resetPassword;
import static F.VarJFrame.tambah_User;
import static F.VarJFrame.ubah_Kata_Sandi;
import static F.Variablebanking.hak;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author JACK
 */
public class Tampil_User extends javax.swing.JFrame {

    /**
     *
     */
    public Tampil_User() {
        initComponents();
        refresh();
        setTitle("MASTER USER");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        BTambah.setVisible(hak[31]);
        BUbah.setVisible(hak[32]);
        BReset.setVisible(hak[33]);
    }

    private void refresh() {
        jktable1.setQuery("select `User`,'************' as 'Password', `Level` from tuser");
        jktable1.tampilkan();
        AutoSetJtable autoSetJtable = new F.AutoSetJtable();
        autoSetJtable.resizeColumnWidth(jktable1);
    }

     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {
          bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

          BTambah = new javax.swing.JButton();
          BUbah = new javax.swing.JButton();
          BReset = new javax.swing.JButton();
          jScrollPane2 = new javax.swing.JScrollPane();
          jktable1 = new F.Jktable();
          jButton1 = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          addWindowListener(new java.awt.event.WindowAdapter()
          {
               public void windowClosing(java.awt.event.WindowEvent evt)
               {
                    formWindowClosing(evt);
               }
          });

          BTambah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          BTambah.setText("Tambah");

          org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jktable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement== null}"), BTambah, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          BTambah.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    BTambahActionPerformed(evt);
               }
          });

          BUbah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          BUbah.setText("Ubah");

          binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jktable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), BUbah, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          BUbah.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    BUbahActionPerformed(evt);
               }
          });

          BReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          BReset.setText("Reset Kata Sandi");

          binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jktable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), BReset, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          BReset.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    BResetActionPerformed(evt);
               }
          });

          jktable1.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][]
               {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
               },
               new String []
               {
                    "Title 1", "Title 2", "Title 3", "Title 4"
               }
          ));
          jktable1.setQuery("select `User`,'************' as 'Password', `Level` from tuser");
          jktable1.tampilkan();
          jScrollPane2.setViewportView(jktable1);
          jktable1.getSelectionModel().addListSelectionListener(new
               ListSelectionListener()
               {
                    public void valueChanged(ListSelectionEvent e)
                    {
                         getSelectedData(jktable1);
                    }
               });

               jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jButton1.setText("Refresh");
               jButton1.addActionListener(new java.awt.event.ActionListener()
               {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         jButton1ActionPerformed(evt);
                    }
               });

               javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
               getContentPane().setLayout(layout);
               layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addGap(10, 10, 10)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jScrollPane2)
                              .addGroup(layout.createSequentialGroup()
                                   .addComponent(jButton1)
                                   .addGap(6, 6, 6)
                                   .addComponent(BReset)
                                   .addGap(6, 6, 6)
                                   .addComponent(BUbah)
                                   .addGap(6, 6, 6)
                                   .addComponent(BTambah)
                                   .addGap(0, 0, Short.MAX_VALUE)))
                         .addContainerGap())
               );
               layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(3, 3, 3)
                                   .addComponent(jButton1))
                              .addComponent(BReset)
                              .addComponent(BUbah)
                              .addComponent(BTambah))
                         .addContainerGap())
               );

               bindingGroup.bind();

               pack();
          }// </editor-fold>//GEN-END:initComponents

     private void BTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambahActionPerformed
         if (tambah_User == null) {
             tambah_User = new Tambah_User();
         }
     }//GEN-LAST:event_BTambahActionPerformed

     private void BUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUbahActionPerformed
         if (ubah_Kata_Sandi == null) {
             ubah_Kata_Sandi = new Ubah_Kata_Sandi(setuser);
         }
     }//GEN-LAST:event_BUbahActionPerformed

     private void BResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BResetActionPerformed
         if (resetPassword == null) {
             resetPassword = new ResetPassword(setuser, setpassword);
         }
     }//GEN-LAST:event_BResetActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
     {//GEN-HEADEREND:event_jButton1ActionPerformed
         jktable1.setQuery("select `User`,'************' as 'Password', `Level` from tuser");
         jktable1.tampilkan();
         jktable1.clearSelection();
// TODO add your handling code here:
     }//GEN-LAST:event_jButton1ActionPerformed

     private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
     {//GEN-HEADEREND:event_formWindowClosing
         F.VarJFrame.tampil_User = null;          // TODO add your handling code here:
     }//GEN-LAST:event_formWindowClosing

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton BReset;
     private javax.swing.JButton BTambah;
     private javax.swing.JButton BUbah;
     private javax.swing.JButton jButton1;
     private javax.swing.JScrollPane jScrollPane2;
     private F.Jktable jktable1;
     private org.jdesktop.beansbinding.BindingGroup bindingGroup;
     // End of variables declaration//GEN-END:variables
    private String setuser = "";

    /**
     *
     */
    public String setpassword = "";

    /**
     *
     * @param table
     */
    public void getSelectedData(Jktable table) {
        int selectedRow = table.getSelectedRow();
        setuser = table.getstring(selectedRow, 0);
        setpassword = table.getstring(selectedRow, 1);
    }
    private static final Logger LOG = Logger.getLogger(Tampil_User.class.getName());
}
