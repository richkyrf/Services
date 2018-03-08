/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses.SPK;

import F.FLaporan;
import F.RunMultiUpd;
import F.RunSelct;
import F.RunSelct2;
import F.RunUpd;
import Proses.PS.Cek;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JACK
 */
public class UbahSPK extends javax.swing.JFrame {

    /**
     *
     * @param NoPeintahKerja
     */
    public UbahSPK(String NoPeintahKerja) {
        initComponents();
        setTitle("Ubah Perintah Kerja");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JtNoPerintahKerja.setText(NoPeintahKerja);
        getdata(NoPeintahKerja);
        setKMfromPlat(JcPlat.getText());
        setVisible(true);
    }

    void setKMfromPlat(Object Plat) {
        RunSelct runSelct = new F.RunSelct();
        try {
            runSelct.setQuery("SELECT `KMO`FROM `ttruck` WHERE `NoPolisi`='" + Plat + "' limit 1");
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                JcKMO.setText("");
            }
            while (rs.next()) {
                JcKMO.setText(rs.getString("KMO"));
            }
        } catch (SQLException e) {
        } finally {
            runSelct.closecon();
        }
    }
    String QJcP1 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=2 order by `NoCol`";
    String QJcP2 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=3 order by `NoCol`";
    String QJcP3 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=4 order by `NoCol`";

    /**
     *
     * @param table
     * @return
     */
    public Object[][] getTableData(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                tableData[i][j] = dtm.getValueAt(i, j);
            }
        }
        return tableData;
    }

    void RefreshJtable() {
        JTable.clearSelection();
        JCjenis.setSelectedIndex(0);
        JTKet.setText("");
        JTBiaya.setInt(0);
    }

    private void getdata(String NoPerintahKerja) {
        RunSelct2 runSelct2 = new F.RunSelct2();
        runSelct2.setQuery("SELECT `No`,`NoPerintahKerja`,`NoPermintaan`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User`,`CatKhusus` FROM `tbperintahkerja` WHERE `NoPerintahKerja` ='" + NoPerintahKerja + "'");
        try {
            ResultSet rs = runSelct2.excute();
            if (!rs.isBeforeFirst()) {
                JtNoPerintahKerja.setText("");
                JTPermintaanKerja.setText("");
                JdTGL.setDate(new Date());
                JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(), "HH:mm"));
                JcPlat.setText("");
                JtSopir.setText("");
                JcPermintaan.setSelectedIndex(0);
                JcPekerjaan.setSelectedIndex(0);
                JcTingkatPek.setSelectedIndex(0);
                JTKMMobil.setInt(0);
                JTCatatatanKhusus.setText("");
            }
            while (rs.next()) {
                JtNoPerintahKerja.setText(rs.getString("NoPerintahKerja"));
                JTPermintaanKerja.setText(rs.getString("NoPermintaan"));
                JdTGL.setDate(rs.getDate("Tgl"));
                JTTime.setText(F.Datetostringwidthformat.getstringfromdate(rs.getTimestamp("Tgl"), "HH:mm"));
                JcPlat.setText(rs.getString("Plat"));
                JtSopir.setText(rs.getString("Sopir"));
                JcPermintaan.setSelectedIndex(rs.getInt("JPermintaan"));
                JcPekerjaan.setSelectedIndex(rs.getInt("JPekerjaan"));
                JcTingkatPek.setSelectedIndex(rs.getInt("TingkatPekerjaan"));
                JTKMMobil.setInt(rs.getInt("KMT"));
                JTCatatatanKhusus.setText(rs.getString("CatKhusus"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "gagal Menampilkan Data");
        } finally {
            runSelct2.closecon();
        }
        JTable.setQuery("SELECT `NoCol` as 'No', `JenisPermintaan` as 'Jenis Permintaan', `Keterangan` as 'Keterangan', `Ongkos` as 'OngkosServices' FROM `tbdetailperintahkerja` WHERE `NoPerintahKerja` = '" + NoPerintahKerja + "' order by `No` Asc");
        JTable.tampilkan();
    }

    void getSelectedData() {
        if (JTable.getSelectedRow() != -1) {
            int row = JTable.getSelectedRow();
            JCjenis.setSelectedItem(JTable.getValueAt(row, 1));
            JTKet.setText(JTable.getValueAt(row, 2).toString());
            JTBiaya.setInt(Integer.parseInt(JTable.getValueAt(row, 3).toString()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {
          bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          JdTGL = new com.toedter.calendar.JDateChooser();
          jLabel12 = new javax.swing.JLabel();
          jLabel13 = new javax.swing.JLabel();
          jLabel14 = new javax.swing.JLabel();
          jButton1 = new javax.swing.JButton();
          jLabel17 = new javax.swing.JLabel();
          jLabel18 = new javax.swing.JLabel();
          jLabel21 = new javax.swing.JLabel();
          jLabel22 = new javax.swing.JLabel();
          jLabel23 = new javax.swing.JLabel();
          jLabel24 = new javax.swing.JLabel();
          jButton2 = new javax.swing.JButton();
          jButton3 = new javax.swing.JButton();
          JCjenis = new F.JcomFromDb();
          JTCari = new F.JackTextField();
          jLabel5 = new javax.swing.JLabel();
          jScrollPane2 = new javax.swing.JScrollPane();
          JTable = new F.Jktable();
          JcPermintaan = new F.JcomFromDb();
          JcTingkatPek = new F.JcomFromDb();
          JcPekerjaan = new F.JcomFromDb();
          BtnUbah = new javax.swing.JButton();
          jButton5 = new javax.swing.JButton();
          jLabel6 = new javax.swing.JLabel();
          JTBiaya = new F.RibuanTextField();
          JTKMMobil = new F.RibuanTextField();
          JcPlat = new F.JackTextField();
          JTKet = new F.JackTextField();
          JtNoPerintahKerja = new F.JackTextField();
          JTPermintaanKerja = new F.JackTextField();
          JtSopir = new F.JackTextField();
          jtUser = new F.JackTextField();
          JTTime = new javax.swing.JFormattedTextField();
          jLabel19 = new javax.swing.JLabel();
          JTCatatatanKhusus = new F.JackTextField();
          jButton4 = new javax.swing.JButton();
          jLabel7 = new javax.swing.JLabel();
          JcKMO = new F.RibuanTextField();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          addWindowListener(new java.awt.event.WindowAdapter()
          {
               public void windowClosing(java.awt.event.WindowEvent evt)
               {
                    formWindowClosing(evt);
               }
          });

          jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel2.setText("Plat");

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel3.setText("Waktu & Tanggal");

          jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel4.setText("No Permintaan Kerja");

          JdTGL.setDate(new Date());
          JdTGL.setDateFormatString("dd-MM-yyyy");
          JdTGL.setEnabled(false);
          JdTGL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel12.setText("Keterangan");
          jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel13.setText("Jenis Pekerjaan");
          jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel14.setText("Ongkos Service");
          jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jButton1.setText("SIMPAN");
          jButton1.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton1ActionPerformed(evt);
               }
          });

          jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel17.setText("USER :");

          jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

          jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel21.setText("Sopir");

          jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel22.setText("Jenis Permintaan");

          jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel23.setText("Jenis Pekerjaan");

          jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel24.setText("Prioritas Perbaikan");

          jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jButton2.setText("Tambah");
          jButton2.setFocusable(false);

          org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement == null}"), jButton2, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          jButton2.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton2ActionPerformed(evt);
               }
          });

          jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jButton3.setText("Hapus");
          jButton3.setFocusable(false);

          binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButton3, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          jButton3.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton3ActionPerformed(evt);
               }
          });

          JCjenis.setQuery("SELECT `Jenis Service` FROM `tjenisservice` order by `No` asc");
          JCjenis.excute();
          JCjenis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          JCjenis.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyReleased(java.awt.event.KeyEvent evt)
               {
                    JCjenisKeyReleased(evt);
               }
          });

          JTCari.setmaxtText(50);
          JTCari.setDisabledTextColor(new java.awt.Color(0, 0, 102));
          JTCari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          JTCari.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyReleased(java.awt.event.KeyEvent evt)
               {
                    JTCariKeyReleased(evt);
               }
          });

          jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel5.setText("KM Mobil");

          JTable.setModel(new javax.swing.table.DefaultTableModel(
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
          JTable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "startEditing");
          JTable.getSelectionModel().addListSelectionListener(new
               ListSelectionListener()
               {
                    public void valueChanged(ListSelectionEvent e)
                    {
                         getSelectedData();
                    }
               });
               JTable.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTableKeyReleased(evt);
                    }
               });
               JTable.setrender(3,"Number");
               jScrollPane2.setViewportView(JTable);

               JcPermintaan.setQuery(QJcP1);
               JcPermintaan.setaawalkosong(false);
               JcPermintaan.excute();
               JcPermintaan.setEnabled(false);
               JcPermintaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JcTingkatPek.setQuery(QJcP3);
               JcTingkatPek.setaawalkosong(false);
               JcTingkatPek.excute();
               JcTingkatPek.setEnabled(false);
               JcTingkatPek.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JcPekerjaan.setQuery(QJcP2);
               JcPekerjaan.setaawalkosong(false);
               JcPekerjaan.excute();
               JcPekerjaan.setEnabled(false);
               JcPekerjaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               BtnUbah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               BtnUbah.setText("Ubah");
               BtnUbah.setFocusable(false);

               binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), BtnUbah, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
               bindingGroup.addBinding(binding);

               BtnUbah.addActionListener(new java.awt.event.ActionListener()
               {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         BtnUbahActionPerformed(evt);
                    }
               });

               jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jButton5.setText("Refresh");
               jButton5.setFocusable(false);
               jButton5.addActionListener(new java.awt.event.ActionListener()
               {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         jButton5ActionPerformed(evt);
                    }
               });

               jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jLabel6.setText("No SPK");

               JTBiaya.setmaxnum(1000000000);
               JTBiaya.setDisabledTextColor(new java.awt.Color(0, 0, 102));
               JTBiaya.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               JTBiaya.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTBiayaKeyReleased(evt);
                    }
               });

               JTKMMobil.setText("0");
               JTKMMobil.setDisabledTextColor(new java.awt.Color(0, 0, 102));
               JTKMMobil.setEnabled(false);
               JTKMMobil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JcPlat.setDisabledTextColor(new java.awt.Color(0, 0, 102));
               JcPlat.setEnabled(false);
               JcPlat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JTKet.setmaxtText(100);
               JTKet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               JTKet.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTKetKeyReleased(evt);
                    }
               });

               JtNoPerintahKerja.setEnabled(false);
               JtNoPerintahKerja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JTPermintaanKerja.setEnabled(false);
               JTPermintaanKerja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JtSopir.setEnabled(false);
               JtSopir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jtUser.setText(F.Variablebanking.SUsername);
               jtUser.setEnabled(false);
               jtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JTTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
               JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(),"HH:mm"));
               JTTime.setEnabled(false);
               JTTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jLabel19.setText("Catatan Khusus :");

               JTCatatatanKhusus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jButton4.setText("CETAK");
               jButton4.addActionListener(new java.awt.event.ActionListener()
               {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         jButton4ActionPerformed(evt);
                    }
               });

               jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jLabel7.setText("KM Ganti Oli");

               JcKMO.setText("0");
               JcKMO.setDisabledTextColor(new java.awt.Color(0, 0, 102));
               JcKMO.setEnabled(false);
               JcKMO.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
               getContentPane().setLayout(layout);
               layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addGap(10, 10, 10)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                  .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                       .addComponent(JTCari, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(JCjenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                  .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                                                  .addComponent(JTKet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                  .addComponent(JTBiaya, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))))
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel2)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(jLabel21)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel22)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JcPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel23)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JcPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel17)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jButton4)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(jButton1))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel19)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JTCatatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JcTingkatPek, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JcKMO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                   .addGap(0, 175, Short.MAX_VALUE))
                              .addGroup(layout.createSequentialGroup()
                                   .addComponent(jLabel4)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(JTPermintaanKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel6)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(JtNoPerintahKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addContainerGap())
               );

               layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel22, jLabel23, jLabel24, jLabel3, jLabel4, jLabel5, jLabel7});

               layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnUbah, jButton2, jButton3, jButton5});

               layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addGap(11, 11, 11)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel4)
                              .addComponent(JTPermintaanKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(JtNoPerintahKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel6))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(3, 3, 3)
                                   .addComponent(jLabel3))
                              .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(0, 0, 0)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel2)
                              .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel21)
                              .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel22)
                              .addComponent(JcPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(6, 6, 6)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel23)
                              .addComponent(JcPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(6, 6, 6)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel24)
                              .addComponent(JcTingkatPek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(6, 6, 6)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel7)
                              .addComponent(JcKMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel5)
                              .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel13)
                              .addComponent(jLabel12)
                              .addComponent(jLabel14))
                         .addGap(11, 11, 11)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(JTCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(JCjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(JTKet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(JTBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jButton2)
                                   .addGap(6, 6, 6)
                                   .addComponent(BtnUbah)
                                   .addGap(6, 6, 6)
                                   .addComponent(jButton3)
                                   .addGap(6, 6, 6)
                                   .addComponent(jButton5)
                                   .addGap(40, 40, 40)))
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(3, 3, 3)
                                   .addComponent(jLabel19))
                              .addComponent(JTCatatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(13, 13, 13)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(4, 4, 4)
                                   .addComponent(jLabel17))
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(1, 1, 1)
                                   .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jButton1)
                                   .addComponent(jButton4)))
                         .addContainerGap())
               );

               layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnUbah, JCjenis, JTBiaya, JTCari, JTCatatatanKhusus, JTKMMobil, JTKet, JTPermintaanKerja, JTTime, JcKMO, JcPekerjaan, JcPermintaan, JcPlat, JcTingkatPek, JdTGL, JtNoPerintahKerja, JtSopir, jButton1, jButton2, jButton3, jButton4, jButton5, jLabel12, jLabel13, jLabel14, jLabel17, jLabel19, jLabel2, jLabel21, jLabel22, jLabel23, jLabel24, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jtUser});

               bindingGroup.bind();

               pack();
          }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a = Cek.isadaopname(JtNoPerintahKerja.getText());
        if (a == null) {
            if (JTable.getRowCount() != 0) {

                int km = 0;
                if (JTKMMobil.isEnabled()) {
                    km = JTKMMobil.getInt();
                } else if (JcKMO.isEnabled()) {
                    km = JTKMMobil.getInt();
                }
                List<String> list = new ArrayList<>();
                list.add("update `tbperintahkerja` set `NoPermintaan`= '" + JTPermintaanKerja.getText() + "',`Tgl`= '" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                        + " `Plat` = '" + JcPlat.getText() + "' , `Sopir` = '" + JtSopir.getText() + "', `JPermintaan`='" + JcPermintaan.getSelectedIndex() + "',"
                        + " `JPekerjaan` = " + JcPekerjaan.getSelectedIndex() + " , `TingkatPekerjaan` = " + JcTingkatPek.getSelectedIndex() + ","
                        + " `KMT` = " + km + ",`User`= '" + jtUser.getText() + "',`CatKhusus`= '" + JTCatatatanKhusus.getText() + "' where `NoPerintahKerja` = '" + JtNoPerintahKerja.getText() + "'");
                list.add("DELETE FROM `tbdetailperintahkerja` WHERE `NoPerintahKerja` = '" + JtNoPerintahKerja.getText() + "'");
                Object[][] b = getTableData(JTable);
                for (int i = 0; i < b.length; i++) {
                    String bb = "";
                    for (int j = 0; j < b[i].length + 1; j++) {
                        if (j == b[i].length) {
                            bb += "'" + JtNoPerintahKerja.getText() + "'";
                        } else if ((j == b[i].length - 4) || (j == b[i].length - 1)) {
                            bb += "" + b[i][j] + ",";
                        } else {
                            bb += "'" + b[i][j] + "',";
                        }
                    }
                    list.add("INSERT INTO `tbdetailperintahkerja`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`NoPerintahKerja`) VALUES (" + bb + ")");
                }
                RunMultiUpd runMultiUpd = new F.RunMultiUpd();
                runMultiUpd.setQuery(list);
                runMultiUpd.seterorm("Gagal Ubah Data !");
                int no = runMultiUpd.excute();
                if (no != 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil di simpan !!");
                    F.History.STambah("Ubah Data SPK " + JtNoPerintahKerja.getText());
                    F.VarJFrame.ubahPerintahKerja.dispose();
                    F.VarJFrame.menuPerintahKerja.refresh();
                    F.VarJFrame.ubahPerintahKerja = null;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Permintaan Kerja Tidak Boleh Kosong !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tidak Dapat Merubah Data Perintah Kerja \n Karena Telah Di buat Opname SPK Dengan NO " + a);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getText()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getText()) != -1)) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
        } else if (JCjenis.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
        } else {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.addRow(new Object[]{JTable.getRowCount() + 1, JCjenis.getSelectedItem(), JTKet.getText(), JTBiaya.getInt()});
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Data");
            RefreshJtable();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            for (int a = 0; a < JTable.getRowCount(); a++) {
                JTable.setValueAt(a + 1, a, 0);
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hapus Data");
            RefreshJtable();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JTCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTCariKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JCjenis.requestFocus();
            JCjenis.setSelectedIndex(0);
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if (JTable.getSelectedRow() != -1) {
                JTable.clearSelection();
                JCjenis.setSelectedIndex(0);
                JTKet.setText("");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCjenis.hidePopup();
            JTKet.requestFocus();
        } else {
            JCjenis.setQuery("SELECT `Jenis Service`  FROM `tjenisservice` where `Jenis Service` like '%" + JTCari.getText() + "%'order by `No` asc");
            JCjenis.setaawalkosong(false);
            JCjenis.excute();
            JCjenis.showPopup();
        }
    }//GEN-LAST:event_JTCariKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        F.VarJFrame.ubahPerintahKerja = null;
        if (F.VarJFrame.menuPerintahKerja != null) {
            F.VarJFrame.menuPerintahKerja.refresh();
        }
    }//GEN-LAST:event_formWindowClosing

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getText()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getText()) != -1)) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
        } else if (JTable.getSelectedRow() != -1) {
            JTable.setValueAt(JCjenis.getSelectedItem(), JTable.getSelectedRow(), 1);
            JTable.setValueAt(JTKet.getText(), JTable.getSelectedRow(), 2);
            JTable.setValueAt(JTBiaya.getInt(), JTable.getSelectedRow(), 3);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Data");
            RefreshJtable();
        }

    }//GEN-LAST:event_BtnUbahActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JTable.clearSelection();
        JCjenis.setSelectedIndex(0);
        JTKet.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

     private void JCjenisKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JCjenisKeyReleased
     {//GEN-HEADEREND:event_JCjenisKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             JTKet.requestFocus();
         }          // TODO add your handling code here:          // TODO add your handling code here:
     }//GEN-LAST:event_JCjenisKeyReleased

     private void JTKetKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTKetKeyReleased
     {//GEN-HEADEREND:event_JTKetKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             JTBiaya.requestFocus();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_JTKetKeyReleased

     private void JTBiayaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTBiayaKeyReleased
     {//GEN-HEADEREND:event_JTBiayaKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             if (BtnUbah.isEnabled() == false) {
                 if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getText()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getText()) != -1)) {
                     JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
                 } else if (JCjenis.getSelectedItem() == "") {
                     JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
                 } else {
                     DefaultTableModel model = (DefaultTableModel) JTable.getModel();
                     model.addRow(new Object[]{JTable.getRowCount() + 1, JCjenis.getSelectedItem(), JTKet.getText(), JTBiaya.getInt()});
                     JOptionPane.showMessageDialog(this, "Berhasil Tambah Permintaan");
                     RefreshsJtable();
                     JTCari.requestFocus();
                 }
             } else if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getText()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getText()) != -1)) {
                 JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
             } else if (JCjenis.getSelectedItem() == "") {
                 JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
             } else if (JTable.getSelectedRow() != -1) {
                 JTable.setValueAt(JCjenis.getSelectedItem(), JTable.getSelectedRow(), 1);
                 JTable.setValueAt(JTKet.getText(), JTable.getSelectedRow(), 2);
                 JTable.setValueAt(JTBiaya.getInt(), JTable.getSelectedRow(), 3);
                 JOptionPane.showMessageDialog(this, "Berhasil Ubah Permintaan");
                 RefreshsJtable();
                 JTCari.requestFocus();
             }
         }
         if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         }          // TODO add your handling code here:
     }//GEN-LAST:event_JTBiayaKeyReleased

     private void JTableKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTableKeyReleased
     {//GEN-HEADEREND:event_JTableKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             if (JTable.getSelectedRow() != -1) {
                 JTCari.requestFocus();
             }
         } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         }
         deleterowjtable(evt);          // TODO add your handling code here:
     }//GEN-LAST:event_JTableKeyReleased

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
     {//GEN-HEADEREND:event_jButton4ActionPerformed
         String a = Cek.isadaopname(JtNoPerintahKerja.getText());
         if (a == null) {
             if (JTable.getRowCount() != 0) {

                 int km = 0;
                 if (JTKMMobil.isEnabled()) {
                     km = JTKMMobil.getInt();
                 } else if (JcKMO.isEnabled()) {
                     km = JTKMMobil.getInt();
                 }
                 List<String> list = new ArrayList<>();
                 list.add("update `tbperintahkerja` set `NoPermintaan`= '" + JTPermintaanKerja.getText() + "',`Tgl`= '" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                         + " `Plat` = '" + JcPlat.getText() + "' , `Sopir` = '" + JtSopir.getText() + "', `JPermintaan`='" + JcPermintaan.getSelectedIndex() + "',"
                         + " `JPekerjaan` = " + JcPekerjaan.getSelectedIndex() + " , `TingkatPekerjaan` = " + JcTingkatPek.getSelectedIndex() + ","
                         + " `KMT` = " + km + ",`User`= '" + jtUser.getText() + "',`CatKhusus`= '" + JTCatatatanKhusus.getText() + "' where `NoPerintahKerja` = '" + JtNoPerintahKerja.getText() + "'");
                 list.add("DELETE FROM `tbdetailperintahkerja` WHERE `NoPerintahKerja` = '" + JtNoPerintahKerja.getText() + "'");
                 Object[][] b = getTableData(JTable);
                 for (int i = 0; i < b.length; i++) {
                     String bb = "";
                     for (int j = 0; j < b[i].length + 1; j++) {
                         if (j == b[i].length) {
                             bb += "'" + JtNoPerintahKerja.getText() + "'";
                         } else if ((j == b[i].length - 4) || (j == b[i].length - 1)) {
                             bb += "" + b[i][j] + ",";
                         } else {
                             bb += "'" + b[i][j] + "',";
                         }
                     }
                     list.add("INSERT INTO `tbdetailperintahkerja`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`NoPerintahKerja`) VALUES (" + bb + ")");
                 }
                 RunMultiUpd runMultiUpd = new F.RunMultiUpd();
                 runMultiUpd.setQuery(list);
                 runMultiUpd.seterorm("Gagal Ubah Data !");
                 int no = runMultiUpd.excute();
                 if (no != 0) {
                     JOptionPane.showMessageDialog(this, "Data berhasil di simpan !!");
                     F.History.STambah("Ubah Data SPK " + JtNoPerintahKerja.getText());
                     F.VarJFrame.ubahPerintahKerja.dispose();
                     F.VarJFrame.ubahPerintahKerja = null;
                     HashMap hashs = new HashMap();
                     String Statusjcom;
                     String StatusOrder;
                     String Cari;
                     hashs.put("Title", "SURAT PERINTAH KERJA");
                     hashs.put("NoPerintahKerja", JtNoPerintahKerja.getText());
                     hashs.put("KaMekanik", F.Variablebanking.Mechanik);
                     hashs.put("Pimpinan", F.Variablebanking.Pimpinan);
                     hashs.put("PrintedBy", "Di Print Oleh " + F.Variablebanking.SUsername + " Pada " + F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy HH:mm"));
                     FLaporan fLaporan = new F.FLaporan();
                     fLaporan.sethashmap(hashs);
                     fLaporan.setfilename("PerintahKerja");
                     fLaporan.setErorm("Gagal Menampilkan Laporan " + this.getTitle());
                     fLaporan.excute();
                     fLaporan.excute();
                     RunUpd runUpd = new RunUpd();
                     runUpd.setQuery("UPDATE `tbperintahkerja` SET `Print`='Yes' WHERE `NoPerintahKerja`='" + JtNoPerintahKerja.getText() + "'");
                     runUpd.excute();
                     F.VarJFrame.menuPerintahKerja.refresh();
                 }
             } else {
                 JOptionPane.showMessageDialog(this, "Permintaan Kerja Tidak Boleh Kosong !");
             }
         } else {
             JOptionPane.showMessageDialog(this, "Tidak Dapat Merubah Data Perintah Kerja \n Karena Telah Di buat Opname SPK Dengan NO " + a);
         }      // TODO add your handling code here:
     }//GEN-LAST:event_jButton4ActionPerformed

    void deleterowjtable(KeyEvent evt) {
        if (JTable.getSelectedRow() != -1) {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                if (JTable.getSelectedRow() != -1) {
                    ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
                    for (int a = 0; a < JTable.getRowCount(); a++) {
                        JTable.setValueAt(a + 1, a, 0);
                    }
                    JOptionPane.showMessageDialog(this, "Berhasil Hapus Permintaan");
                    RefreshsJtable();
                    JTCari.requestFocus();
                }
            }
        }
    }

    void RefreshsJtable() {
        JTable.clearSelection();
        JCjenis.setSelectedIndex(0);
        JTKet.setText("");
        JTBiaya.setInt(0);
    }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton BtnUbah;
     private F.JcomFromDb JCjenis;
     private F.RibuanTextField JTBiaya;
     private F.JackTextField JTCari;
     private F.JackTextField JTCatatatanKhusus;
     private F.RibuanTextField JTKMMobil;
     private F.JackTextField JTKet;
     private F.JackTextField JTPermintaanKerja;
     private javax.swing.JFormattedTextField JTTime;
     private F.Jktable JTable;
     private F.RibuanTextField JcKMO;
     private F.JcomFromDb JcPekerjaan;
     private F.JcomFromDb JcPermintaan;
     private F.JackTextField JcPlat;
     private F.JcomFromDb JcTingkatPek;
     private com.toedter.calendar.JDateChooser JdTGL;
     private F.JackTextField JtNoPerintahKerja;
     private F.JackTextField JtSopir;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
     private javax.swing.JButton jButton5;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel14;
     private javax.swing.JLabel jLabel17;
     private javax.swing.JLabel jLabel18;
     private javax.swing.JLabel jLabel19;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel21;
     private javax.swing.JLabel jLabel22;
     private javax.swing.JLabel jLabel23;
     private javax.swing.JLabel jLabel24;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JScrollPane jScrollPane2;
     private F.JackTextField jtUser;
     private org.jdesktop.beansbinding.BindingGroup bindingGroup;
     // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(UbahSPK.class.getName());

}
