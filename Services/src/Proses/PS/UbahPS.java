/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses.PS;

import static F.Datetostringwidthformat.getstringfromdate;
import F.FLaporan;
import F.RunMultiUpd;
import F.RunSelct;
import F.RunSelct2;
import F.RunSelctOne;
import F.RunUpd;
import static F.Variablebanking.Mechanik;
import static F.Variablebanking.Pimpinan;
import static F.Variablebanking.SUsername;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JACK
 */
public class UbahPS extends javax.swing.JFrame {

    /**
     *
     * @param NoPermintaanKerja
     */
    public UbahPS(String NoPermintaanKerja) {
        initComponents();
        setTitle("Ubah Permintaan Service");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JtNoPermintaan.setText(NoPermintaanKerja);
        setVisible(true);
        getdata(NoPermintaanKerja);
    }

    String QJcP1 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=2 order by `NoCol`";
    String QJcP2 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=3 order by `NoCol`";
    String QJcP3 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=4 order by `NoCol`";

    private void GetJcomPlat(String Cari) {
        if (Cari == null) {
            JcPlat.setQuery("SELECT `NoPolisi` FROM `ttruck`");
            JcPlat.excute();
        } else {
            JcPlat.setQuery("SELECT `NoPolisi` FROM `ttruck` where `NoPolisi` like '%" + Cari + "%' ");
            JcPlat.excute();
        }

    }

    void setKMfromPlat(Object Plat) {
        RunSelct runSelct = new F.RunSelct();
        try {
            runSelct.setQuery("SELECT `KMO` FROM `ttruck` WHERE `NoPolisi`='" + Plat + "' limit 1");
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

    private void getdata(String NoPermintaan) {
        String Plat = "";
        RunSelct2 runSelct2 = new F.RunSelct2();
        runSelct2.setQuery("SELECT `No`, `NoPermintaan`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User` , `CatKhusus` FROM `tbpermintaan` WHERE `NoPermintaan` ='" + NoPermintaan + "'");
        try {
            ResultSet rs = runSelct2.excute();
            while (rs.next()) {
                JcPlat.setSelectedItem(rs.getString("Plat"));
                JtNoPermintaan.setText(rs.getString("NoPermintaan"));
                JdTGL.setDate(new Date());
                JtSopir.setText(rs.getString("Sopir"));
                JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(), "HH:mm"));
                JcPermintaan.setSelectedIndex(rs.getInt("JPermintaan"));
                JcPekerjaan.setSelectedIndex(rs.getInt("JPekerjaan"));
                JcTingkatPek.setSelectedIndex(rs.getInt("TingkatPekerjaan"));
                JTKMMobil.setInt(rs.getInt("KMT"));
                JTCatatanKhusus.setText(rs.getString("CatKhusus"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "gagal Menampilkan Data");
            e.printStackTrace();
        } finally {
            runSelct2.closecon();
        }
        JTable.setQuery("SELECT `NoCol` as 'No', `JenisPermintaan` as 'Jenis Permintaan', `Keterangan` as 'Keterangan', `Ongkos` as 'Ongkos Servis' FROM `tbdetailpermintaan` WHERE `NoPermintaan` = '" + NoPermintaan + "' order by `No` Asc");
        JTable.tampilkan();
    }

    void setenabdisabtextkm() {
        if (!"".equals(JcPlat.getSelectedItem().toString())) {
            RunSelctOne runSelctOne = new F.RunSelctOne();
            runSelctOne.setQuery("SELECT `Stat` FROM `ttruck` WHERE `NoPolisi`= '" + JcPlat.getSelectedItem() + "'");
            String x = runSelctOne.excute();
            if (x.equals("1")) {
                JTKMMobil.setEnabled(false);
            } else {
                JTKMMobil.setEnabled(true);
            }
        }
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
          jLabel16 = new javax.swing.JLabel();
          jButton1 = new javax.swing.JButton();
          jLabel17 = new javax.swing.JLabel();
          jLabel18 = new javax.swing.JLabel();
          jLabel21 = new javax.swing.JLabel();
          jLabel22 = new javax.swing.JLabel();
          jLabel23 = new javax.swing.JLabel();
          jLabel24 = new javax.swing.JLabel();
          jButton2 = new javax.swing.JButton();
          jButton3 = new javax.swing.JButton();
          JcPlat = new F.JcomFromDb();
          JCjenis = new F.JcomFromDb();
          JTCari = new F.JackTextField();
          jLabel5 = new javax.swing.JLabel();
          JcKMO = new F.JNumberTextField();
          jScrollPane2 = new javax.swing.JScrollPane();
          JTable = new F.Jktable();
          JcPermintaan = new F.JcomFromDb();
          JcTingkatPek = new F.JcomFromDb();
          JcPekerjaan = new F.JcomFromDb();
          BtnUbah = new javax.swing.JButton();
          jButton5 = new javax.swing.JButton();
          JTBiaya = new F.RibuanTextField();
          JTKMMobil = new F.RibuanTextField();
          JTTime = new javax.swing.JFormattedTextField();
          JtNoPermintaan = new F.JackTextField();
          JtSopir = new F.JackTextField();
          jtUser = new F.JackTextField();
          JTKet = new F.JackTextField();
          jLabel25 = new javax.swing.JLabel();
          JTCatatanKhusus = new F.JackTextField();
          jButton7 = new javax.swing.JButton();

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
          jLabel4.setText("NoPermintaan");

          JdTGL.setDate(new Date());
          JdTGL.setDateFormatString("dd-MM-yyyy");
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

          jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel16.setText("KM Ganti Oli");

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
          jLabel17.setText("Catatan Khusus :");

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

          JcPlat.setQuery("SELECT `NoPolisi`FROM `ttruck`");
          JcPlat.excute();
          JcPlat.setEnabled(false);
          JcPlat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          JcPlat.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JcPlatActionPerformed(evt);
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

          JcKMO.setDisabledTextColor(new java.awt.Color(0, 51, 102));
          JcKMO.setEnabled(false);
          JcKMO.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
               jScrollPane2.setViewportView(JTable);

               JcPermintaan.setQuery(QJcP1);
               JcPermintaan.setaawalkosong(false);
               JcPermintaan.excute();
               JcPermintaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JcTingkatPek.setQuery(QJcP3);
               JcTingkatPek.setaawalkosong(false);
               JcTingkatPek.excute();
               JcTingkatPek.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JcPekerjaan.setQuery(QJcP2);
               JcPekerjaan.setaawalkosong(false);
               JcPekerjaan.excute();
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

               JTBiaya.setmaxnum(1000000000);
               JTBiaya.setDisabledTextColor(new java.awt.Color(0, 51, 102));
               JTBiaya.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               JTBiaya.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTBiayaKeyReleased(evt);
                    }
               });

               JTKMMobil.setText("0");
               JTKMMobil.setDisabledTextColor(new java.awt.Color(0, 51, 102));
               JTKMMobil.setEnabled(false);
               JTKMMobil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JTTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
               JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(),"HH:mm"));
               JTTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JtNoPermintaan.setEnabled(false);
               JtNoPermintaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JtSopir.setmaxtText(50);
               JtSopir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jtUser.setText(F.Variablebanking.SUsername);
               jtUser.setEnabled(false);
               jtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JTKet.setmaxtText(100);
               JTKet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               JTKet.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTKetKeyReleased(evt);
                    }
               });

               jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jLabel25.setText("USER :");

               JTCatatanKhusus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jButton7.setText("CETAK");
               jButton7.addActionListener(new java.awt.event.ActionListener()
               {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         jButton7ActionPerformed(evt);
                    }
               });

               javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
               getContentPane().setLayout(layout);
               layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addContainerGap()
                                             .addComponent(JTCari, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                             .addGroup(layout.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(jLabel25)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jButton7)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(jButton1))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addGap(10, 10, 10)
                                                  .addComponent(jLabel17)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JTCatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                   .addGap(0, 0, Short.MAX_VALUE))
                              .addGroup(layout.createSequentialGroup()
                                   .addContainerGap()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(4, 4, 4)
                                                       .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(6, 6, 6)
                                                       .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(4, 4, 4)
                                                       .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(4, 4, 4)
                                                       .addComponent(JcPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(4, 4, 4)
                                                       .addComponent(JcPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(4, 4, 4)
                                                       .addComponent(JcTingkatPek, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(JCjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                 .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addGap(4, 4, 4)
                                                                 .addComponent(JcKMO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(4, 4, 4)
                                                       .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                             .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JtNoPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addGap(358, 358, 358)
                                                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(JTKet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(JTBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                  .addComponent(jScrollPane2))
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(BtnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                         .addContainerGap())
               );

               layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnUbah, jButton2, jButton3, jButton5});

               layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addGap(11, 11, 11)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel4)
                                   .addComponent(JtNoPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(3, 3, 3)
                                             .addComponent(jLabel2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addComponent(jLabel21)
                                             .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(3, 3, 3)
                                             .addComponent(jLabel22))
                                        .addComponent(JcPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(3, 3, 3)
                                             .addComponent(jLabel23))
                                        .addComponent(JcPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(9, 9, 9)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(3, 3, 3)
                                             .addComponent(jLabel24))
                                        .addComponent(JcTingkatPek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(JcKMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(3, 3, 3)
                                             .addComponent(jLabel5))
                                        .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                              .addGroup(layout.createSequentialGroup()
                                   .addComponent(jLabel13)
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JCjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel12))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTKet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                         .addGap(6, 6, 6)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                   .addComponent(jButton2)
                                   .addGap(6, 6, 6)
                                   .addComponent(BtnUbah)
                                   .addGap(6, 6, 6)
                                   .addComponent(jButton3)
                                   .addGap(6, 6, 6)
                                   .addComponent(jButton5)
                                   .addGap(0, 17, Short.MAX_VALUE))
                              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(3, 3, 3)
                                   .addComponent(jLabel17))
                              .addComponent(JTCatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(6, 6, 6)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel25)
                              .addComponent(jButton1)
                              .addComponent(jButton7)))
               );

               layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnUbah, JCjenis, JTBiaya, JTCari, JTCatatanKhusus, JTKMMobil, JTKet, JTTime, JcKMO, JcPekerjaan, JcPermintaan, JcPlat, JcTingkatPek, JdTGL, JtNoPermintaan, JtSopir, jButton1, jButton2, jButton3, jButton5, jButton7, jLabel12, jLabel13, jLabel14, jLabel16, jLabel17, jLabel2, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel3, jLabel4, jLabel5, jtUser});

               jLabel2.getAccessibleContext().setAccessibleName("");
               jLabel3.getAccessibleContext().setAccessibleName("");
               jLabel4.getAccessibleContext().setAccessibleName("");
               jLabel16.getAccessibleContext().setAccessibleName("");
               jLabel21.getAccessibleContext().setAccessibleName("");
               jLabel22.getAccessibleContext().setAccessibleName("");
               jLabel23.getAccessibleContext().setAccessibleName("");
               jLabel24.getAccessibleContext().setAccessibleName("");
               jLabel5.getAccessibleContext().setAccessibleName("");

               bindingGroup.bind();

               pack();
          }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (JcPlat.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(this, "Plat Harus Di Pilih Terlebih Dahulu");
        } else {
            String a = Proses.PS.Cek.isadaperintahkerja(JtNoPermintaan.getText());
            if (a == null) {
                if (JTable.getRowCount() != 0) {

                    int km = 0;
                    if (JTKMMobil.isEnabled()) {
                        km = JTKMMobil.getInt();
                    } else if (JcKMO.isEnabled()) {
                        km = JTKMMobil.getInt();
                    }
                    List<String> list = new ArrayList<>();
                    list.add("update `tbpermintaan` set `Tgl`= '" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                            + " `Plat` = '" + JcPlat.getSelectedItem() + "' , `Sopir` = '" + JtSopir.getText() + "', `JPermintaan`='" + JcPermintaan.getSelectedIndex() + "',"
                            + " `JPekerjaan` = " + JcPekerjaan.getSelectedIndex() + " , `TingkatPekerjaan` = " + JcTingkatPek.getSelectedIndex() + ","
                            + " `KMT` = " + km + ",`User`= '" + jtUser.getText() + "',`CatKhusus`= '" + JTCatatanKhusus.getText() + "' where `NoPermintaan` = '" + JtNoPermintaan.getText() + "'");
                    list.add("DELETE FROM `tbdetailpermintaan` WHERE `NoPermintaan` = '" + JtNoPermintaan.getText() + "'");
                    Object[][] b = getTableData(JTable);
                    for (int i = 0; i < b.length; i++) {
                        String bb = "";
                        for (int j = 0; j < b[i].length + 1; j++) {
                            if (j == b[i].length) {
                                bb += "'" + JtNoPermintaan.getText() + "'";
                            } else if ((j == b[i].length - 4) || (j == b[i].length - 1)) {
                                bb += "" + b[i][j] + ",";
                            } else {
                                bb += "'" + b[i][j] + "',";
                            }
                        }
                        list.add("INSERT INTO `tbdetailpermintaan`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`NoPermintaan`) VALUES (" + bb + ")");
                    }
                    RunMultiUpd runMultiUpd = new F.RunMultiUpd();
                    runMultiUpd.setQuery(list);
                    runMultiUpd.seterorm("Gagal Ubah Data !");
                    int no = runMultiUpd.excute();
                    if (no != 0) {
                        JOptionPane.showMessageDialog(this, "Data berhasil di simpan !!");
                        F.History.STambah("Ubah Data permintaan Service " + JtNoPermintaan.getText());
                        F.VarJFrame.ubahPermintaanKerja.dispose();
                        F.VarJFrame.menuPermintaanKerja.refresh();
                        F.VarJFrame.ubahPermintaanKerja = null;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Permintaan Service Tidak Boleh Kosong !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "tidak dapat merubah data permintaan kerja \n karena telah di buat spk dengan no " + a);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
        } else if (JCjenis.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
        } else {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.addRow(new Object[]{JTable.getRowCount() + 1, JCjenis.getSelectedItem(), JTKet.getText(), JTBiaya.getInt()});
            JOptionPane.showMessageDialog(this, "Berhasil Tambah Permintaan");
            RefreshJtable();
            JTCari.requestFocus();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            for (int a = 0; a < JTable.getRowCount(); a++) {
                JTable.setValueAt(a + 1, a, 0);
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hapus Permintaan");
            RefreshJtable();
            JTCari.requestFocus();
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
        F.VarJFrame.ubahPermintaanKerja = null;
        if (F.VarJFrame.menuPermintaanKerja != null) {
            F.VarJFrame.menuPermintaanKerja.refresh();
        }
    }//GEN-LAST:event_formWindowClosing

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
        } else if (JCjenis.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
        } else if (JTable.getSelectedRow() != -1) {
            JTable.setValueAt(JCjenis.getSelectedItem(), JTable.getSelectedRow(), 1);
            JTable.setValueAt(JTKet.getText(), JTable.getSelectedRow(), 2);
            JTable.setValueAt(JTBiaya.getInt(), JTable.getSelectedRow(), 3);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Permintaan");
            RefreshJtable();
            JTCari.requestFocus();
        }
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JTable.clearSelection();
        JCjenis.setSelectedIndex(0);
        JTKet.setText("");
        JTBiaya.setInt(0);// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void JcPlatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcPlatActionPerformed
    {//GEN-HEADEREND:event_JcPlatActionPerformed
        setenabdisabtextkm();
        setKMfromPlat(JcPlat.getSelectedItem());    // TODO add your handling code here:
    }//GEN-LAST:event_JcPlatActionPerformed

     private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
     {//GEN-HEADEREND:event_jButton7ActionPerformed
         if (JcPlat.getSelectedItem() == "") {
             JOptionPane.showMessageDialog(this, "Plat Harus Di Pilih Terlebih Dahulu");
         } else {
             String a = Proses.PS.Cek.isadaperintahkerja(JtNoPermintaan.getText());
             if (a == null) {
                 if (JTable.getRowCount() != 0) {

                     int km = 0;
                     if (JTKMMobil.isEnabled()) {
                         km = JTKMMobil.getInt();
                     } else if (JcKMO.isEnabled()) {
                         km = JTKMMobil.getInt();
                     }
                     List<String> list = new ArrayList<>();
                     list.add("update `tbpermintaan` set `Tgl`= '" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                             + " `Plat` = '" + JcPlat.getSelectedItem() + "' , `Sopir` = '" + JtSopir.getText() + "', `JPermintaan`='" + JcPermintaan.getSelectedIndex() + "',"
                             + " `JPekerjaan` = " + JcPekerjaan.getSelectedIndex() + " , `TingkatPekerjaan` = " + JcTingkatPek.getSelectedIndex() + ","
                             + " `KMT` = " + km + ",`User`= '" + jtUser.getText() + "',`CatKhusus`= '" + JTCatatanKhusus.getText() + "' where `NoPermintaan` = '" + JtNoPermintaan.getText() + "'");
                     list.add("DELETE FROM `tbdetailpermintaan` WHERE `NoPermintaan` = '" + JtNoPermintaan.getText() + "'");
                     Object[][] b = getTableData(JTable);
                     for (int i = 0; i < b.length; i++) {
                         String bb = "";
                         for (int j = 0; j < b[i].length + 1; j++) {
                             if (j == b[i].length) {
                                 bb += "'" + JtNoPermintaan.getText() + "'";
                             } else if ((j == b[i].length - 4) || (j == b[i].length - 1)) {
                                 bb += "" + b[i][j] + ",";
                             } else {
                                 bb += "'" + b[i][j] + "',";
                             }
                         }
                         list.add("INSERT INTO `tbdetailpermintaan`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`NoPermintaan`) VALUES (" + bb + ")");
                     }
                     RunMultiUpd runMultiUpd = new F.RunMultiUpd();
                     runMultiUpd.setQuery(list);
                     runMultiUpd.seterorm("Gagal Ubah Data !");
                     int no = runMultiUpd.excute();
                     if (no != 0) {
                         JOptionPane.showMessageDialog(this, "Data berhasil di simpan !!");
                         F.History.STambah("Ubah Data permintaan Service " + JtNoPermintaan.getText());
                         F.VarJFrame.ubahPermintaanKerja.dispose();
                         F.VarJFrame.ubahPermintaanKerja = null;
                         HashMap hashs = new HashMap();
                         String Statusjcom;
                         String StatusOrder;
                         String Cari;
                         hashs.put("Title", "SURAT PERMINTAAN SERVICE");
                         hashs.put("NoPermintaanKerja", JtNoPermintaan.getText());
                         hashs.put("KaMekanik", Mechanik);
                         hashs.put("Pimpinan", Pimpinan);
                         hashs.put("PrintedBy", "Di Print Oleh " + SUsername + " Pada " + getstringfromdate(new Date(), "dd/MM/yyyy HH:mm"));
                         FLaporan fLaporan = new F.FLaporan();
                         fLaporan.sethashmap(hashs);
                         fLaporan.setfilename("PermintaanKerja");
                         fLaporan.setErorm("Gagal Menampilkan Laporan " + this.getTitle());
                         fLaporan.excute();
                         RunUpd runUpd = new RunUpd();
                         runUpd.setQuery("UPDATE `tbpermintaan` SET `Print`='Yes' WHERE `NoPermintaan`='" + JtNoPermintaan.getText() + "'");
                         runUpd.excute();
                         F.VarJFrame.menuPermintaanKerja.refresh();
                     }
                 } else {
                     JOptionPane.showMessageDialog(this, "Permintaan Service Tidak Boleh Kosong !");
                 }
             } else {
                 JOptionPane.showMessageDialog(this, "tidak dapat merubah data permintaan kerja \n karena telah di buat spk dengan no " + a);
             }
         }
     }//GEN-LAST:event_jButton7ActionPerformed

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
         }          // TODO add your handling code here:
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
                 if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
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
             } else if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
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
         deleterowjtable(evt);
         // TODO add your handling code here:
     }//GEN-LAST:event_JTableKeyReleased

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
     private F.JackTextField JTCatatanKhusus;
     private F.RibuanTextField JTKMMobil;
     private F.JackTextField JTKet;
     private javax.swing.JFormattedTextField JTTime;
     private F.Jktable JTable;
     private F.JNumberTextField JcKMO;
     private F.JcomFromDb JcPekerjaan;
     private F.JcomFromDb JcPermintaan;
     private F.JcomFromDb JcPlat;
     private F.JcomFromDb JcTingkatPek;
     private com.toedter.calendar.JDateChooser JdTGL;
     private F.JackTextField JtNoPermintaan;
     private F.JackTextField JtSopir;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton5;
     private javax.swing.JButton jButton7;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel14;
     private javax.swing.JLabel jLabel16;
     private javax.swing.JLabel jLabel17;
     private javax.swing.JLabel jLabel18;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel21;
     private javax.swing.JLabel jLabel22;
     private javax.swing.JLabel jLabel23;
     private javax.swing.JLabel jLabel24;
     private javax.swing.JLabel jLabel25;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JScrollPane jScrollPane2;
     private F.JackTextField jtUser;
     private org.jdesktop.beansbinding.BindingGroup bindingGroup;
     // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(UbahPS.class.getName());

}
