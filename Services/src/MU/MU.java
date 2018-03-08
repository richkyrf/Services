/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MU;

import File.Tampil_User;
import Master.JenisService;
import Master.PKS;
import Master.T;
import Proses.PS.MPService;
import Proses.SPK.MSPK;
import Proses.WOpSPK.MOSPK;
import Proses.XSPB.MPB;
import java.util.logging.Logger;

/**
 *
 * @author JACK
 */
public class MU extends javax.swing.JFrame {

    /**
     * Creates new form MenuUtama
     */
    public MU() {
        initComponents();
        setTitle("Menu Utama");
        setLocationRelativeTo(null);
        JMImport.setVisible(F.Variablebanking.hak[0]);
        JMMUser.setVisible(F.Variablebanking.hak[1]);
        JMPKS.setVisible(F.Variablebanking.hak[2]);
        JMTruck.setVisible(F.Variablebanking.hak[3]);
        JMJServi.setVisible(F.Variablebanking.hak[4]);
        JMPermintaan.setVisible(F.Variablebanking.hak[6]);
        JMPerintah.setVisible(F.Variablebanking.hak[7]);
        JMPermintaanB.setVisible(F.Variablebanking.hak[8]);
        JMOpnameSPK.setVisible(F.Variablebanking.hak[9]);
        if (!"admin".equals(F.Variablebanking.Slevel)) {
            JMMUser.setVisible(false);
        }
        setVisible(true);
    }

     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {

          MenuBar = new javax.swing.JMenuBar();
          jMenu1 = new javax.swing.JMenu();
          JMMUser = new javax.swing.JMenuItem();
          JMImport = new javax.swing.JMenuItem();
          JMExit = new javax.swing.JMenuItem();
          jMenu2 = new javax.swing.JMenu();
          JMPKS = new javax.swing.JMenuItem();
          JMTruck = new javax.swing.JMenuItem();
          JMJServi = new javax.swing.JMenuItem();
          JMJServi1 = new javax.swing.JMenuItem();
          JMJServi2 = new javax.swing.JMenuItem();
          jMenu3 = new javax.swing.JMenu();
          JMPermintaan = new javax.swing.JMenuItem();
          JMPerintah = new javax.swing.JMenuItem();
          JMPermintaanB = new javax.swing.JMenuItem();
          JMOpnameSPK = new javax.swing.JMenuItem();
          jMenu4 = new javax.swing.JMenu();
          jMenuItem2 = new javax.swing.JMenuItem();
          jMenuItem3 = new javax.swing.JMenuItem();
          jMenuItem4 = new javax.swing.JMenuItem();
          jMenuItem5 = new javax.swing.JMenuItem();
          jMenuItem6 = new javax.swing.JMenuItem();
          jMenuItem1 = new javax.swing.JMenuItem();
          jMenuItem7 = new javax.swing.JMenuItem();
          jMenuItem9 = new javax.swing.JMenuItem();
          jMenuItem10 = new javax.swing.JMenuItem();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          jMenu1.setMnemonic('F');
          jMenu1.setText("FILE");
          jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

          JMMUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMMUser.setText("Master User");
          JMMUser.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMMUserActionPerformed(evt);
               }
          });
          jMenu1.add(JMMUser);

          JMImport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMImport.setText("Import DB Kilometer");
          JMImport.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMImportActionPerformed(evt);
               }
          });
          jMenu1.add(JMImport);

          JMExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMExit.setText("Exit");
          JMExit.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMExitActionPerformed(evt);
               }
          });
          jMenu1.add(JMExit);

          MenuBar.add(jMenu1);

          jMenu2.setMnemonic('M');
          jMenu2.setText("MASTER");
          jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

          JMPKS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMPKS.setText("PKS");
          JMPKS.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMPKSActionPerformed(evt);
               }
          });
          jMenu2.add(JMPKS);

          JMTruck.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMTruck.setText("Truck");
          JMTruck.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMTruckActionPerformed(evt);
               }
          });
          jMenu2.add(JMTruck);

          JMJServi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMJServi.setText("Jenis Service");
          JMJServi.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMJServiActionPerformed(evt);
               }
          });
          jMenu2.add(JMJServi);

          JMJServi1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMJServi1.setText("Ka Mekanik");
          JMJServi1.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMJServi1ActionPerformed(evt);
               }
          });
          jMenu2.add(JMJServi1);

          JMJServi2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMJServi2.setText("Mekanik");
          JMJServi2.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMJServi2ActionPerformed(evt);
               }
          });
          jMenu2.add(JMJServi2);

          MenuBar.add(jMenu2);

          jMenu3.setMnemonic('P');
          jMenu3.setText("PROSES");
          jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

          JMPermintaan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMPermintaan.setText("Permintaan Service");
          JMPermintaan.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMPermintaanActionPerformed(evt);
               }
          });
          jMenu3.add(JMPermintaan);

          JMPerintah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMPerintah.setText("Perintah Kerja");
          JMPerintah.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMPerintahActionPerformed(evt);
               }
          });
          jMenu3.add(JMPerintah);

          JMPermintaanB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMPermintaanB.setText("Permintaan Barang");
          JMPermintaanB.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMPermintaanBActionPerformed(evt);
               }
          });
          jMenu3.add(JMPermintaanB);

          JMOpnameSPK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          JMOpnameSPK.setText("Opname SPK");
          JMOpnameSPK.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JMOpnameSPKActionPerformed(evt);
               }
          });
          jMenu3.add(JMOpnameSPK);

          MenuBar.add(jMenu3);

          jMenu4.setMnemonic('L');
          jMenu4.setText("LAPORAN");
          jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

          jMenuItem2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
          jMenuItem2.setText("Laporan Kartu Service");
          jMenuItem2.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem2ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem2);

          jMenuItem3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
          jMenuItem3.setText("Laporan Opname SPK");
          jMenuItem3.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem3ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem3);

          jMenuItem4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
          jMenuItem4.setText("Laporan Perintah Kerja");
          jMenuItem4.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem4ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem4);

          jMenuItem5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
          jMenuItem5.setText("Laporan Permintaan Service");
          jMenuItem5.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem5ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem5);

          jMenuItem6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
          jMenuItem6.setText("Laporan Master");
          jMenuItem6.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem6ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem6);

          jMenuItem1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
          jMenuItem1.setText("Laporan Permintaan Barang");
          jMenuItem1.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem1ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem1);

          jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          jMenuItem7.setText("Laporan Truck Perlu Service Berdasarkan Data KM DO");
          jMenuItem7.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem7ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem7);

          jMenuItem9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          jMenuItem9.setText("Laporan Trip PKS Kendaraan");
          jMenuItem9.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem9ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem9);

          jMenuItem10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          jMenuItem10.setText("Laporan Jumlah Trip Kendaraan");
          jMenuItem10.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jMenuItem10ActionPerformed(evt);
               }
          });
          jMenu4.add(jMenuItem10);

          MenuBar.add(jMenu4);

          setJMenuBar(MenuBar);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 407, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 144, Short.MAX_VALUE)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void JMPKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMPKSActionPerformed
        if (F.VarJFrame.pks == null) {
            F.VarJFrame.pks = new PKS();
        }
    }//GEN-LAST:event_JMPKSActionPerformed

    private void JMTruckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMTruckActionPerformed
        if (F.VarJFrame.truck == null) {
            F.VarJFrame.truck = new T();
        }

    }//GEN-LAST:event_JMTruckActionPerformed

    private void JMJServiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMJServiActionPerformed
        if (F.VarJFrame.jenisService == null) {
            F.VarJFrame.jenisService = new JenisService();
        }
    }//GEN-LAST:event_JMJServiActionPerformed

    private void JMImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMImportActionPerformed
        F.ImportBKL.runimportbkl();
    }//GEN-LAST:event_JMImportActionPerformed

    private void JMMUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMMUserActionPerformed
        if (F.VarJFrame.tampil_User == null) {
            F.VarJFrame.tampil_User = new Tampil_User();
        }
    }//GEN-LAST:event_JMMUserActionPerformed

    private void JMPermintaanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JMPermintaanActionPerformed
    {//GEN-HEADEREND:event_JMPermintaanActionPerformed
        if (F.VarJFrame.menuPermintaanKerja == null) {
            F.VarJFrame.menuPermintaanKerja = new MPService();
        }
    }//GEN-LAST:event_JMPermintaanActionPerformed

    private void JMPerintahActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JMPerintahActionPerformed
    {//GEN-HEADEREND:event_JMPerintahActionPerformed
        if (F.VarJFrame.menuPerintahKerja == null) {
            F.VarJFrame.menuPerintahKerja = new MSPK();
        }
    }//GEN-LAST:event_JMPerintahActionPerformed

    private void JMPermintaanBActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JMPermintaanBActionPerformed
    {//GEN-HEADEREND:event_JMPermintaanBActionPerformed
        if (F.VarJFrame.menuPermintaanBarang == null) {
            F.VarJFrame.menuPermintaanBarang = new MPB();
        }
    }//GEN-LAST:event_JMPermintaanBActionPerformed

    private void JMOpnameSPKActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JMOpnameSPKActionPerformed
    {//GEN-HEADEREND:event_JMOpnameSPKActionPerformed
        if (F.VarJFrame.menuOpnameSPK == null) {
            F.VarJFrame.menuOpnameSPK = new MOSPK();
        }
    }//GEN-LAST:event_JMOpnameSPKActionPerformed

    private void JMExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JMExitActionPerformed
    {//GEN-HEADEREND:event_JMExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JMExitActionPerformed

     private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
         if (F.VarJFrame.lpermintaanBarang == null) {
             F.VarJFrame.lpermintaanBarang = new Laporan.LPB();
         }

     }//GEN-LAST:event_jMenuItem1ActionPerformed

     private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem2ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem2ActionPerformed
         if (F.VarJFrame.lKartuService == null) {
             F.VarJFrame.lKartuService = new Laporan.LKartuService();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_jMenuItem2ActionPerformed

     private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem3ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem3ActionPerformed
         if (F.VarJFrame.lOpnameSPK == null) {
             F.VarJFrame.lOpnameSPK = new Laporan.LOpSPK();
         }
     }//GEN-LAST:event_jMenuItem3ActionPerformed

     private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem4ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem4ActionPerformed
         if (F.VarJFrame.lPerintahKerja == null) {
             F.VarJFrame.lPerintahKerja = new Laporan.LSPK();
         }
     }//GEN-LAST:event_jMenuItem4ActionPerformed

     private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem5ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem5ActionPerformed
         if (F.VarJFrame.lPermintaanKerja == null) {
             F.VarJFrame.lPermintaanKerja = new Laporan.LPS();
         }
     }//GEN-LAST:event_jMenuItem5ActionPerformed

     private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem6ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem6ActionPerformed
         if (F.VarJFrame.laporanMaster == null) {
             F.VarJFrame.laporanMaster = new Laporan.LMaster();
         }
     }//GEN-LAST:event_jMenuItem6ActionPerformed

     private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem7ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem7ActionPerformed
         if (F.VarJFrame.LaporanTruckKM == null) {
             F.VarJFrame.LaporanTruckKM = new Laporan.LaporanTruckKM();
         }
     }//GEN-LAST:event_jMenuItem7ActionPerformed

     private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem9ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem9ActionPerformed
         if (F.VarJFrame.LaporanLDOPKS == null) {
             F.VarJFrame.LaporanLDOPKS = new Laporan.LDOPKS();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_jMenuItem9ActionPerformed

     private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem10ActionPerformed
     {//GEN-HEADEREND:event_jMenuItem10ActionPerformed
         if (F.VarJFrame.LaporanLDOTRIP == null) {
             F.VarJFrame.LaporanLDOTRIP = new Laporan.LDOTRIP();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_jMenuItem10ActionPerformed

     private void JMJServi1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JMJServi1ActionPerformed
     {//GEN-HEADEREND:event_JMJServi1ActionPerformed
         if (F.VarJFrame.kaMekanik == null) {
             F.VarJFrame.kaMekanik = new Master.KaMekanik();
         }
     }//GEN-LAST:event_JMJServi1ActionPerformed

     private void JMJServi2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JMJServi2ActionPerformed
     {//GEN-HEADEREND:event_JMJServi2ActionPerformed
         if (F.VarJFrame.stockKeeper == null) {
             F.VarJFrame.stockKeeper = new Master.Mekanik();
         }
     }//GEN-LAST:event_JMJServi2ActionPerformed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JMenuItem JMExit;
     private javax.swing.JMenuItem JMImport;
     private javax.swing.JMenuItem JMJServi;
     private javax.swing.JMenuItem JMJServi1;
     private javax.swing.JMenuItem JMJServi2;
     private javax.swing.JMenuItem JMMUser;
     private javax.swing.JMenuItem JMOpnameSPK;
     private javax.swing.JMenuItem JMPKS;
     private javax.swing.JMenuItem JMPerintah;
     private javax.swing.JMenuItem JMPermintaan;
     private javax.swing.JMenuItem JMPermintaanB;
     private javax.swing.JMenuItem JMTruck;
     private javax.swing.JMenuBar MenuBar;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenu jMenu3;
     private javax.swing.JMenu jMenu4;
     private javax.swing.JMenuItem jMenuItem1;
     private javax.swing.JMenuItem jMenuItem10;
     private javax.swing.JMenuItem jMenuItem2;
     private javax.swing.JMenuItem jMenuItem3;
     private javax.swing.JMenuItem jMenuItem4;
     private javax.swing.JMenuItem jMenuItem5;
     private javax.swing.JMenuItem jMenuItem6;
     private javax.swing.JMenuItem jMenuItem7;
     private javax.swing.JMenuItem jMenuItem9;
     // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(MU.class.getName());
}
