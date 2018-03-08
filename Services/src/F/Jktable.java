/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import Koneksi.MysqlCon;
import java.awt.KeyboardFocusManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author JACK
 */
public class Jktable extends JTable {

    String SQL;
    Connection con;
    boolean bf = false;
    int booleanfield = -1;
    Class[] types = new Class[]{null};
    java.sql.ResultSetMetaData md;
    int columnCount;
    Vector data;
    Vector columnNames;
    Vector row;
    int editable = -1;

    public Jktable() {
        setFont(new java.awt.Font("Tahoma", 0, 18));
        setRowHeight(20);
        setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
        setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
    }

    public int getintC(int x, int y) {
        int h = 0;
        if (getSelectedRow() != -1) {
            h = Integer.parseInt(getValueAt(x, y).toString().substring(0, (getValueAt(x, y).toString().replace(",", "").length() - 2)).replace(",", "").replace(".", ""));
        }
        return h;
    }

    public int getintcoma(int x, int y) {
        int h = 0;
        if (getSelectedRow() != -1) {
            h = Integer.parseInt(getValueAt(x, y).toString().substring((getValueAt(x, y).toString().replace(",", "").length() - 2), (getValueAt(x, y).toString().replace(",", "").length())).replace(",", "").replace(".", ""));
        }
        return h;
    }

    public void setrender(int x, String Type) {
        TableColumnModel m = this.getColumnModel();
        if ("Date".equals(Type)) {
            m.getColumn(x).setCellRenderer(FormatRenderer.getDateTimeRenderer());
        }

        if ("Time".equals(Type)) {
            m.getColumn(x).setCellRenderer(FormatRenderer.getTimeRenderer());
        }

        if ("Percent".equals(Type)) {
            m.getColumn(x).setCellRenderer(NumberRenderer.getPercentRenderer());
        }

        if ("Curency".equals(Type)) {
            m.getColumn(x).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        }
        if ("Number".equals(Type)) {
            m.getColumn(x).setCellRenderer(NumberRenderer.getumberrender());
        }
    }

    public void setQuery(String Query) {
        SQL = Query;
    }

    public void addNewRow() {
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        Vector row = new Vector();
        row.add(null);
        row.add(null);
        row.add(null);
        model.addRow(row);
    }

    public void useboolean(boolean f) {
        bf = f;
    }

    public void setbooleanfield(int i) {
        booleanfield = i;
    }

    public void seteditable(int i) {
        editable = i;
    }

    public void setclass(Class[] cv) {
        types = cv;
    }

    public void tampilkan() {
        MysqlCon koneksi = new MysqlCon();
        con = koneksi.getConnection();
        setAutoCreateRowSorter(true);
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = con.prepareStatement(SQL);
            //////system.out.printlnln(pstmt);
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            md = rs.getMetaData();
            columnCount = md.getColumnCount();
            data = new Vector(columnCount);
            columnNames = new Vector(columnCount);
            row = new Vector(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                columnNames.addElement(md.getColumnLabel(i));
            }
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i == booleanfield + 1) {
                        row.addElement(rs.getBoolean(booleanfield + 1));
                    } else {
                        row.addElement(rs.getObject(i));
                    }
                }
                data.addElement(row);
                row = new Vector(columnCount); // Create a new row Vector
            }
            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnIndex == booleanfield || columnIndex == editable;
                }
            };
            if (bf) {
                model = new DefaultTableModel(data, columnNames) {
                    @Override
                    public Class<?> getColumnClass(int column) {
                        if (column == booleanfield) {
                            return java.lang.Boolean.class;
                        }
                        return java.lang.Object.class;
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex == booleanfield || columnIndex == editable;
                    }
                };
            }
            setModel(model);
            setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            getTableHeader().setReorderingAllowed(false);
        } catch (SQLException e) {
            //////system.out.printlnln("E26" + e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data");
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                //////system.out.printlnln("E27" + ex);
            }
        }
        if (getColumnModel().getColumnCount() > 0) {
            getColumnModel().getColumn(0).setMaxWidth(40);
        }
    }

    public Vector getcoloumname() {
        return columnNames;
    }

    public Vector loaddata(Vector row, ResultSet rs, int i) throws SQLException {
        row.addElement(rs.getObject(i));
        return row;
    }

    public int getint(int x, int y) {
        int h = 0;
        if (getSelectedRow() != -1) {
            h = Integer.parseInt(getValueAt(x, y).toString().replace(",", "").replace(".", ""));
        }
        return h;
    }

    public float getFloat(int x, int y) {
        float h = 0;
        if (getSelectedRow() != -1) {
            h = Float.parseFloat(getValueAt(x, y).toString().replace(",", ""));
        }
        return h;
    }

    public String getstring(int x, int y) {
        String a = null;
        try {
            if (getSelectedRow() != -1) {
                a = getValueAt(x, y).toString();
            }
        } catch (Exception e) {
            //////system.out.printlnln("E28" + e);
        }
        return a;
    }

    public Date getdate(int x, int y) {
        Date tgl = new Date();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            tgl = format.parse(getValueAt(x, y).toString());
        } catch (ParseException ex) {
            //////system.out.printlnln("E29" + ex);
        }
        return tgl;
    }

}
