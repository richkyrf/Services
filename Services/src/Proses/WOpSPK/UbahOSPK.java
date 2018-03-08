package Proses.WOpSPK;

import static F.Datetostringwidthformat.getstringfromdate;
import F.FLaporan;
import F.RunMultiUpd;
import F.RunSelct2;
import F.RunUpd;
import static F.VarJFrame.ubahOpnameSPK;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JACK
 */
public class UbahOSPK extends javax.swing.JFrame {

    /**
     *
     * @param NoPeintahKerja
     */
    public UbahOSPK(String NoPeintahKerja) {
        initComponents();
        setTitle("Ubah Opname SPK");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTNOOpnameSPK.setText(NoPeintahKerja);
        getdata(NoPeintahKerja);
        setVisible(true);
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

    void Refresh(String NoPeintahKerja) {
        JTable.clearSelection();
        JTNOOpnameSPK.setText(NoPeintahKerja);
        getdata(NoPeintahKerja);
    }

    private void getdata(String NoOpnameSPK) {
        RunSelct2 runSelct2 = new F.RunSelct2();
        runSelct2.setQuery("SELECT `No`, `NoOpnameSPK`, `NoPerintahKerja`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User`,`CatKhusus`,`KaMekanik`, `Mekanik`  FROM `tbopnamespk` WHERE `NoOpnameSPK` ='" + NoOpnameSPK + "'");
        try {
            ResultSet rs = runSelct2.excute();
            if (!rs.isBeforeFirst()) {
                JTNOOpnameSPK.setText("");
                JTNoSPK.setText("");
                JdTGL.setDate(new Date());
                JcPlat.setText("");
                JtSopir.setText("");
                JcPermintaan.setSelectedIndex(0);
                JcPekerjaan.setSelectedIndex(0);
                JcTingkatPek.setSelectedIndex(0);
                JTKMMobil.setInt(0);
                JTCatatanKhusus.setText("");
                JcCariKaMekanik.setText("");
                JcCariMekanik.setText("");
                JcKaMekanik.setSelectedIndex(0);
                JcMekanik.setSelectedIndex(0);
            }
            while (rs.next()) {
                JTNOOpnameSPK.setText(rs.getString("NoOpnameSPK"));
                JTNoSPK.setText(rs.getString("NoPerintahKerja"));
                JdTGL.setDate(new Date());
                JcPlat.setText(rs.getString("Plat"));
                JtSopir.setText(rs.getString("Sopir"));
                JcPermintaan.setSelectedIndex(rs.getInt("JPermintaan"));
                JcPekerjaan.setSelectedIndex(rs.getInt("JPekerjaan"));
                JcTingkatPek.setSelectedIndex(rs.getInt("TingkatPekerjaan"));
                JTKMMobil.setInt(rs.getInt("KMT"));
                JTCatatanKhusus.setText(rs.getString("CatKhusus"));
                JcKaMekanik.setSelectedItem("KaMekanik");
                if (JcKaMekanik.getSelectedItem().toString() == null ? rs.getString("KaMekanik") != null : !JcKaMekanik.getSelectedItem().toString().equals(rs.getString("KaMekanik"))) {
                    JcKaMekanik.addItem(rs.getString("KaMekanik"));
                    JcKaMekanik.setSelectedItem(rs.getString("KaMekanik"));
                }
                JcMekanik.setSelectedItem("Mekanik");
                if (JcMekanik.getSelectedItem().toString() == null ? rs.getString("Mekanik") != null : !JcMekanik.getSelectedItem().toString().equals(rs.getString("Mekanik"))) {
                    JcMekanik.addItem(rs.getString("Mekanik"));
                    JcMekanik.setSelectedItem(rs.getString("Mekanik"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "gagal Menampilkan Data");
            e.printStackTrace();
        } finally {
            runSelct2.closecon();
        }
        JTable.setQuery("SELECT `NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`, `Status` FROM `tbdetailopnamespk` WHERE `NoOpnameSPK` = '" + NoOpnameSPK + "' order by `No` Asc");
        JTable.useboolean(true);
        JTable.seteditable(3);
        JTable.setbooleanfield(4);
        JTable.tampilkan();
        JTable1.setQuery("SELECT `NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan`,false as 'sesesai' FROM `tbdetailopnamespk2` WHERE `NoOpnameSPK` = '" + NoOpnameSPK + "' order by `No` Asc");
        JTable1.useboolean(true);
        JTable1.setbooleanfield(5);
        JTable1.tampilkan();
    }

    void getSelectedData() {
        if (JTable.getSelectedRow() != -1) {
            int row = JTable.getSelectedRow();
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

          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          JdTGL = new com.toedter.calendar.JDateChooser();
          jButton1 = new javax.swing.JButton();
          jLabel17 = new javax.swing.JLabel();
          jLabel18 = new javax.swing.JLabel();
          jLabel21 = new javax.swing.JLabel();
          jLabel22 = new javax.swing.JLabel();
          jLabel23 = new javax.swing.JLabel();
          jLabel24 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          jScrollPane2 = new javax.swing.JScrollPane();
          JTable = new F.Jktable();
          JcPermintaan = new F.JcomFromDb();
          JcTingkatPek = new F.JcomFromDb();
          JcPekerjaan = new F.JcomFromDb();
          jLabel6 = new javax.swing.JLabel();
          jScrollPane3 = new javax.swing.JScrollPane();
          JTable1 = new F.Jktable();
          JTKMMobil = new F.RibuanTextField();
          JcPlat = new F.JackTextField();
          jtUser = new F.JackTextField();
          JTNOOpnameSPK = new F.JackTextField();
          JTNoSPK = new F.JackTextField();
          JtSopir = new F.JackTextField();
          jLabel19 = new javax.swing.JLabel();
          JTCatatanKhusus = new F.JackTextField();
          jButton2 = new javax.swing.JButton();
          JTTime = new javax.swing.JFormattedTextField();
          jLabel7 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          JcKaMekanik = new F.JcomFromDb();
          JcCariMekanik = new F.JKTextfield();
          JcCariKaMekanik = new F.JKTextfield();
          JcMekanik = new F.JcomFromDb();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          addWindowListener(new java.awt.event.WindowAdapter()
          {
               public void windowClosing(java.awt.event.WindowEvent evt)
               {
                    formWindowClosing(evt);
               }
          });

          jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel2.setText("PLAT");

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel3.setText("Waktu & Tanggal ");

          jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel4.setText("No SPK");

          JdTGL.setDate(new Date());
          JdTGL.setDateFormatString("dd-MM-yyyy");
          JdTGL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
          jLabel21.setText("SOPIR");

          jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel22.setText("Jenis Permintaan");

          jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel23.setText("Jenis Pekerjaan");

          jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jLabel24.setText("Prioritas Perbaikan");

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
          JTable.getSelectionModel().addListSelectionListener(new
               ListSelectionListener()
               {
                    public void valueChanged(ListSelectionEvent e)
                    {
                         getSelectedData();
                    }
               });
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

               jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jLabel6.setText("No OSPK");

               JTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                    jScrollPane3.setViewportView(JTable1);

                    JTKMMobil.setText("0");
                    JTKMMobil.setDisabledTextColor(new java.awt.Color(0, 0, 102));
                    JTKMMobil.setEnabled(false);
                    JTKMMobil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    JcPlat.setDisabledTextColor(new java.awt.Color(0, 0, 102));
                    JcPlat.setEnabled(false);
                    JcPlat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    jtUser.setText(F.Variablebanking.SUsername);
                    jtUser.setEnabled(false);
                    jtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    JTNOOpnameSPK.setEnabled(false);
                    JTNOOpnameSPK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    JTNoSPK.setEnabled(false);
                    JTNoSPK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    JtSopir.setEnabled(false);
                    JtSopir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    jLabel19.setText("Catatan Khusus :");

                    JTCatatanKhusus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    jButton2.setText("CETAK");
                    jButton2.addActionListener(new java.awt.event.ActionListener()
                    {
                         public void actionPerformed(java.awt.event.ActionEvent evt)
                         {
                              jButton2ActionPerformed(evt);
                         }
                    });

                    JTTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
                    JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(),"HH:mm"));
                    JTTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    jLabel7.setText("KA Mekanik");

                    jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    jLabel8.setText("Mekanik");

                    JcKaMekanik.setQuery("SELECT `Nama` FROM `tbkamekanik` WHERE Status = 0");
                    JcKaMekanik.excute();
                    JcKaMekanik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    JcKaMekanik.addItemListener(new java.awt.event.ItemListener()
                    {
                         public void itemStateChanged(java.awt.event.ItemEvent evt)
                         {
                              JcKaMekanikItemStateChanged(evt);
                         }
                    });
                    JcKaMekanik.addActionListener(new java.awt.event.ActionListener()
                    {
                         public void actionPerformed(java.awt.event.ActionEvent evt)
                         {
                              JcKaMekanikActionPerformed(evt);
                         }
                    });

                    JcCariMekanik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    JcCariMekanik.addActionListener(new java.awt.event.ActionListener()
                    {
                         public void actionPerformed(java.awt.event.ActionEvent evt)
                         {
                              JcCariMekanikActionPerformed(evt);
                         }
                    });
                    JcCariMekanik.addKeyListener(new java.awt.event.KeyAdapter()
                    {
                         public void keyReleased(java.awt.event.KeyEvent evt)
                         {
                              JcCariMekanikKeyReleased(evt);
                         }
                    });

                    JcCariKaMekanik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    JcCariKaMekanik.addActionListener(new java.awt.event.ActionListener()
                    {
                         public void actionPerformed(java.awt.event.ActionEvent evt)
                         {
                              JcCariKaMekanikActionPerformed(evt);
                         }
                    });
                    JcCariKaMekanik.addKeyListener(new java.awt.event.KeyAdapter()
                    {
                         public void keyReleased(java.awt.event.KeyEvent evt)
                         {
                              JcCariKaMekanikKeyReleased(evt);
                         }
                    });

                    JcMekanik.setQuery("SELECT `Nama` FROM `tbmekanik` WHERE Status = 0");
                    JcMekanik.excute();
                    JcMekanik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    JcMekanik.addItemListener(new java.awt.event.ItemListener()
                    {
                         public void itemStateChanged(java.awt.event.ItemEvent evt)
                         {
                              JcMekanikItemStateChanged(evt);
                         }
                    });
                    JcMekanik.addActionListener(new java.awt.event.ActionListener()
                    {
                         public void actionPerformed(java.awt.event.ActionEvent evt)
                         {
                              JcMekanikActionPerformed(evt);
                         }
                    });

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jScrollPane3)
                                   .addComponent(jScrollPane2)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JTNoSPK, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jLabel6)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(JTNOOpnameSPK, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JcPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JcPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JcTingkatPek, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                  .addComponent(jLabel17)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addComponent(jButton2)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(jButton1))
                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                  .addComponent(jLabel19)
                                                  .addGap(4, 4, 4)
                                                  .addComponent(JTCatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                       .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(JcCariMekanik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                       .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(JcCariKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                       .addComponent(JcKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addComponent(JcMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                              .addContainerGap())
                    );
                    layout.setVerticalGroup(
                         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
                              .addGap(11, 11, 11)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4))
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTNoSPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTNOOpnameSPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel3)
                                   .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel2))
                                   .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(6, 6, 6)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel21))
                                   .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(6, 6, 6)
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
                              .addGap(6, 6, 6)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel24))
                                   .addComponent(JcTingkatPek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(6, 6, 6)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel5))
                                   .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(5, 5, 5)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel7)
                                   .addComponent(JcKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(JcCariKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel8)
                                   .addComponent(JcCariMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(JcMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel19))
                                   .addComponent(JTCatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel17))
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                  .addComponent(jButton1)
                                                  .addComponent(jButton2))
                                             .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                              .addContainerGap())
                    );

                    pack();
               }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<String> list = new ArrayList<>();
        list.add("UPDATE `tbopnamespk` set `NoPerintahKerja`= '" + JTNoSPK.getText() + "',`Tgl`= '" + getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                + " `Plat` = '" + JcPlat.getText() + "' , `Sopir` = '" + JtSopir.getText() + "', `JPermintaan`='" + JcPermintaan.getSelectedIndex() + "',"
                + " `JPekerjaan` = " + JcPekerjaan.getSelectedIndex() + " , `TingkatPekerjaan` = " + JcTingkatPek.getSelectedIndex() + ","
                + " `KMT` = '" + JTKMMobil.getInt() + "',`User`= '" + jtUser.getText() + "',`CatKhusus` = '" + JTCatatanKhusus.getText() + "', `KaMekanik`='" + JcKaMekanik.getSelectedItem() + "', `Mekanik`='" + JcMekanik.getSelectedItem() + "' where `NoOpnameSPK` = '" + JTNOOpnameSPK.getText() + "'");
        list.add("DELETE FROM `tbdetailopnamespk` WHERE `NoOpnameSPK` = '" + JTNOOpnameSPK.getText() + "'");
        list.add("DELETE FROM `tbdetailopnamespk2` WHERE `NoOpnameSPK` = '" + JTNOOpnameSPK.getText() + "'");
        Object[][] b = getTableData(JTable);
        for (Object[] b1 : b) {
            String bb = "";
            for (int j = 0; j <= b1.length; j++) {
                if (j == b1.length) {
                    bb += "'" + JTNOOpnameSPK.getText() + "'";
                } else if ((j == b1.length - 1) || (j == b1.length - 2) || (j == b1.length - 5)) {
                    bb += "" + b1[j] + ",";
                } else {
                    bb += "'" + b1[j] + "',";
                }
            }
            list.add("INSERT INTO `tbdetailopnamespk`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`Status`,`NoOpnameSPK`) VALUES (" + bb + ")");
        }
        Object[][] c = getTableData(JTable1);

        for (int i = 0; i < c.length; i++) {
            String cc = "";
            for (int j = 0; j < c[i].length + 1; j++) {
                if (j == c[i].length) {
                    cc += "'" + JTNOOpnameSPK.getText() + "'";
                } else if ((j == c[i].length - 3) || (j == c[i].length - 6) || (j == c[i].length - 1)) {
                    cc += "" + c[i][j] + ",";
                } else {
                    cc += "'" + c[i][j] + "',";
                }
            }
            list.add("INSERT INTO `tbdetailopnamespk2`(`NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan`,`Status`,`NoOpnameSPK`) VALUES (" + cc + ")");
        }
        RunMultiUpd runMultiUpd = new F.RunMultiUpd();
        runMultiUpd.setQuery(list);
        runMultiUpd.seterorm("Gagal Ubah Data !");
        int no = runMultiUpd.excute();
        if (no != 0) {
            showMessageDialog(this, "Data berhasil di simpan !!");
            F.History.STambah("Ubah Data OSPK " + JTNOOpnameSPK.getText());
            F.VarJFrame.menuOpnameSPK.refresh();
            ubahOpnameSPK.dispose();
            ubahOpnameSPK = null;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ubahOpnameSPK = null;
        if (F.VarJFrame.menuOpnameSPK != null) {
            F.VarJFrame.menuOpnameSPK.refresh();
        }
    }//GEN-LAST:event_formWindowClosing

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
     {//GEN-HEADEREND:event_jButton2ActionPerformed
         List<String> list = new ArrayList<>();
         list.add("UPDATE `tbopnamespk` set `NoPerintahKerja`= '" + JTNoSPK.getText() + "',`Tgl`= '" + getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                 + " `Plat` = '" + JcPlat.getText() + "' , `Sopir` = '" + JtSopir.getText() + "', `JPermintaan`='" + JcPermintaan.getSelectedIndex() + "',"
                 + " `JPekerjaan` = " + JcPekerjaan.getSelectedIndex() + " , `TingkatPekerjaan` = " + JcTingkatPek.getSelectedIndex() + ","
                 + " `KMT` = '" + JTKMMobil.getInt() + "',`User`= '" + jtUser.getText() + "',`CatKhusus` = '" + JTCatatanKhusus.getText() + "', `KaMekanik`='" + JcKaMekanik.getSelectedItem() + "', `Mekanik`='" + JcMekanik.getSelectedItem() + "' where `NoOpnameSPK` = '" + JTNOOpnameSPK.getText() + "'");
         list.add("DELETE FROM `tbdetailopnamespk` WHERE `NoOpnameSPK` = '" + JTNOOpnameSPK.getText() + "'");
         list.add("DELETE FROM `tbdetailopnamespk2` WHERE `NoOpnameSPK` = '" + JTNOOpnameSPK.getText() + "'");
         Object[][] b = getTableData(JTable);
         for (Object[] b1 : b) {
             String bb = "";
             for (int j = 0; j <= b1.length; j++) {
                 if (j == b1.length) {
                     bb += "'" + JTNOOpnameSPK.getText() + "'";
                 } else if ((j == b1.length - 1) || (j == b1.length - 2) || (j == b1.length - 5)) {
                     bb += "" + b1[j] + ",";
                 } else {
                     bb += "'" + b1[j] + "',";
                 }
             }
             list.add("INSERT INTO `tbdetailopnamespk`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`Status`,`NoOpnameSPK`) VALUES (" + bb + ")");
         }
         Object[][] c = getTableData(JTable1);

         for (int i = 0; i < c.length; i++) {
             String cc = "";
             for (int j = 0; j < c[i].length + 1; j++) {
                 if (j == c[i].length) {
                     cc += "'" + JTNOOpnameSPK.getText() + "'";
                 } else if ((j == c[i].length - 3) || (j == c[i].length - 6) || (j == c[i].length - 1)) {
                     cc += "" + c[i][j] + ",";
                 } else {
                     cc += "'" + c[i][j] + "',";
                 }
             }
             list.add("INSERT INTO `tbdetailopnamespk2`(`NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan`,`Status`,`NoOpnameSPK`) VALUES (" + cc + ")");
         }
         RunMultiUpd runMultiUpd = new F.RunMultiUpd();
         runMultiUpd.setQuery(list);
         runMultiUpd.seterorm("Gagal Ubah Data !");
         int no = runMultiUpd.excute();
         if (no != 0) {
             showMessageDialog(this, "Data berhasil di simpan !!");
             F.History.STambah("Ubah Data OSPK " + JTNOOpnameSPK.getText());
             ubahOpnameSPK.dispose();
             ubahOpnameSPK = null;
             HashMap hashs = new HashMap();
             String Statusjcom;
             String StatusOrder;
             String Cari;
             hashs.put("Title", "OPNAME SPK");
             hashs.put("NoOpnameSPK", JTNOOpnameSPK.getText());
             hashs.put("KaMekanik", F.Variablebanking.Mechanik);
             hashs.put("Pimpinan", F.Variablebanking.Pimpinan);
             hashs.put("PrintedBy", "Di Print Oleh " + F.Variablebanking.SUsername + " Pada " + F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy HH:mm"));
             FLaporan fLaporan = new F.FLaporan();
             fLaporan.sethashmap(hashs);
             fLaporan.setfilename("OpnameSPK");
             fLaporan.setErorm("Gagal Menampilkan Laporan " + this.getTitle());
             fLaporan.excute();
             if (!"admin".equals(F.Variablebanking.Slevel)) {
                 RunUpd runUpd = new RunUpd();
                 runUpd.setQuery("UPDATE `tbopnamespk` SET `Print`='Yes' WHERE `NoOpnameSPK`='" + JTNOOpnameSPK.getText() + "'");
                 runUpd.excute();
             }
             F.VarJFrame.menuOpnameSPK.refresh();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_jButton2ActionPerformed

     private void JcKaMekanikItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_JcKaMekanikItemStateChanged
     {//GEN-HEADEREND:event_JcKaMekanikItemStateChanged
         // TODO add your handling code here:
     }//GEN-LAST:event_JcKaMekanikItemStateChanged

     private void JcKaMekanikActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcKaMekanikActionPerformed
     {//GEN-HEADEREND:event_JcKaMekanikActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_JcKaMekanikActionPerformed

     private void JcCariMekanikActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcCariMekanikActionPerformed
     {//GEN-HEADEREND:event_JcCariMekanikActionPerformed
         if (!"".equals(JcCariMekanik.getText()) && JcMekanik.getSelectedIndex() == -1) {
             if (F.JackOptionpane.jackop("Apakah Anda Yakin Mau Menambah Data Mekanik")) {
                 RunUpd runupd = new RunUpd();
                 runupd.setQuery("INSERT INTO `tbmekanik`(`Nama`, `Status`) VALUES ('" + JcCariMekanik.getText() + "',0)");
                 int stu = runupd.excute();
                 if (stu != 0) {
                     JOptionPane.showMessageDialog(this, "berhasil Tambah Data Mekanik");
                 } else {
                     JOptionPane.showMessageDialog(this, "gagal Tambah Data Mekanik");
                 }
             } else {
                 JOptionPane.showMessageDialog(null, "batal Menambah Data");
             }
         } else {
             JcMekanik.hidePopup();
             JTable.requestFocus();
         }
     }//GEN-LAST:event_JcCariMekanikActionPerformed

     private void JcCariMekanikKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JcCariMekanikKeyReleased
     {//GEN-HEADEREND:event_JcCariMekanikKeyReleased
         JcMekanik.setQuery("SELECT `Nama` FROM `tbmekanik` WHERE Status = 0 and `Nama` Like '%" + JcCariMekanik.getText() + "%'");
         JcMekanik.setaawalkosong(false);
         JcMekanik.excute();
         JcMekanik.showPopup();         // TODO add your handling code here:
     }//GEN-LAST:event_JcCariMekanikKeyReleased

     private void JcCariKaMekanikActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcCariKaMekanikActionPerformed
     {//GEN-HEADEREND:event_JcCariKaMekanikActionPerformed
         JcKaMekanik.hidePopup();
         JcCariMekanik.requestFocus();     // TODO add your handling code here:
     }//GEN-LAST:event_JcCariKaMekanikActionPerformed

     private void JcCariKaMekanikKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JcCariKaMekanikKeyReleased
     {//GEN-HEADEREND:event_JcCariKaMekanikKeyReleased
         JcKaMekanik.setQuery("SELECT `Nama` FROM `tbkamekanik` WHERE Status = 0 and `Nama` Like '%" + JcCariKaMekanik.getText() + "%'");
         JcKaMekanik.setaawalkosong(false);
         JcKaMekanik.excute();
         JcKaMekanik.showPopup();// TODO add your handling code here:
     }//GEN-LAST:event_JcCariKaMekanikKeyReleased

     private void JcMekanikItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_JcMekanikItemStateChanged
     {//GEN-HEADEREND:event_JcMekanikItemStateChanged
         // TODO add your handling code here:
     }//GEN-LAST:event_JcMekanikItemStateChanged

     private void JcMekanikActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcMekanikActionPerformed
     {//GEN-HEADEREND:event_JcMekanikActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_JcMekanikActionPerformed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private F.JackTextField JTCatatanKhusus;
     private F.RibuanTextField JTKMMobil;
     private F.JackTextField JTNOOpnameSPK;
     private F.JackTextField JTNoSPK;
     private javax.swing.JFormattedTextField JTTime;
     private F.Jktable JTable;
     private F.Jktable JTable1;
     private F.JKTextfield JcCariKaMekanik;
     private F.JKTextfield JcCariMekanik;
     private F.JcomFromDb JcKaMekanik;
     private F.JcomFromDb JcMekanik;
     private F.JcomFromDb JcPekerjaan;
     private F.JcomFromDb JcPermintaan;
     private F.JackTextField JcPlat;
     private F.JcomFromDb JcTingkatPek;
     private com.toedter.calendar.JDateChooser JdTGL;
     private F.JackTextField JtSopir;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
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
     private javax.swing.JLabel jLabel8;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JScrollPane jScrollPane3;
     private F.JackTextField jtUser;
     // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(UbahOSPK.class.getName());

}
