/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import static F.Variablebanking.Variablebanking;
import static F.Variablebanking.setVarBanking;
import File.Login;
import File.ResetPassword;
import File.Tambah_User;
import File.Tampil_User;
import File.Ubah_Kata_Sandi;
import Laporan.LDOPKS;
import Laporan.LDOTRIP;
import Laporan.LKartuService;
import Laporan.LMaster;
import Laporan.LOpSPK;
import Laporan.LPB;
import Laporan.LPS;
import Laporan.LSPK;
import MU.MU;
import Master.JenisService;
import Master.KaMekanik;
import Master.Mekanik;
import Master.PKS;
import Master.T;
import Proses.PS.MPService;
import Proses.PS.TambahPS;
import Proses.PS.UbahPS;
import Proses.SPK.MSPK;
import Proses.SPK.TambahSPK;
import Proses.SPK.UbahSPK;
import Proses.WOpSPK.MOSPK;
import Proses.WOpSPK.TambahOSPK;
import Proses.WOpSPK.UbahOSPK;
import Proses.XSPB.MPB;
import Proses.XSPB.TambahPB;
import java.io.IOException;
import static java.lang.System.exit;
import static java.lang.System.out;
import java.net.BindException;
import static java.net.InetAddress.getLocalHost;
import java.net.ServerSocket;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.UIManager.setLookAndFeel;

/**
 *
 * @author JACK
 */
public class VarJFrame {

    public static Login login;
    public static ResetPassword resetPassword;
    public static Tambah_User tambah_User;
    public static Tampil_User tampil_User;
    public static Ubah_Kata_Sandi ubah_Kata_Sandi;
    public static MU menuUtama;
    public static JenisService jenisService;
    public static PKS pks;
    public static T truck;
    public static KaMekanik kaMekanik;
    public static Mekanik stockKeeper;
    public static MSPK menuPerintahKerja;
    public static UbahSPK ubahPerintahKerja;
    public static MPService menuPermintaanKerja;
    public static TambahPS tambahPermintaanKerja;
    public static UbahPS ubahPermintaanKerja;
    public static MPB menuPermintaanBarang;
    public static TambahPB tambahPermintaanBarang;
    public static TambahPB ubahPermintaanBarang;
    public static MOSPK menuOpnameSPK;
    public static TambahOSPK tambahOpnameSPK;
    public static UbahOSPK ubahOpnameSPK;
    public static TambahSPK tambahPerintahKerja;
    public static Laporan.LKartuService lKartuService;
    public static Laporan.LOpSPK lOpnameSPK;
    public static Laporan.LPS lPermintaanKerja;
    public static Laporan.LSPK lPerintahKerja;
    public static Laporan.LMaster laporanMaster;
    public static Laporan.LPB lpermintaanBarang;
    public static Laporan.LaporanTruckKM LaporanTruckKM;
    public static Laporan.LDOPKS LaporanLDOPKS;
    public static Laporan.LDOTRIP LaporanLDOTRIP;

    public static void createVar() {
        LaporanTruckKM = new Laporan.LaporanTruckKM();
        login = new File.Login();
        resetPassword = new File.ResetPassword("", "");
        tambah_User = new File.Tambah_User();
        tampil_User = new File.Tampil_User();
        ubah_Kata_Sandi = new File.Ubah_Kata_Sandi("");
        menuUtama = new MU();
        jenisService = new JenisService();
        pks = new PKS();
        truck = new T();
        kaMekanik = new KaMekanik();
        stockKeeper = new Mekanik();
        menuPerintahKerja = new MSPK();
        ubahPerintahKerja = new UbahSPK(null);
        menuPermintaanKerja = new MPService();
        tambahPermintaanKerja = new TambahPS();
        ubahPermintaanKerja = new UbahPS(null);
        menuPermintaanBarang = new MPB();
        tambahPermintaanBarang = new TambahPB();
        ubahPermintaanBarang = new TambahPB(null);
        menuOpnameSPK = new MOSPK();
        tambahOpnameSPK = new TambahOSPK();
        ubahOpnameSPK = new UbahOSPK(null);
        tambahPerintahKerja = new TambahSPK();
        lKartuService = new LKartuService();
        lOpnameSPK = new LOpSPK();
        lPerintahKerja = new LSPK();
        lPermintaanKerja = new LPS();
        laporanMaster = new LMaster();
        lpermintaanBarang = new LPB();
        LaporanLDOPKS = new LDOPKS();
        LaporanLDOTRIP = new LDOTRIP();
    }

    public static void main(String args[]) {
        try {
            setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            out.println("E42" + ex);
        }
        try {
            ServerSocket serverSocket = new ServerSocket(65535, 1, getLocalHost());
            login = new File.Login();
            //createVar();
            Variablebanking();
            setVarBanking();
        } catch (BindException ex) {
            showMessageDialog(null, "Aplikasi Sudah Terbuka . . . \n");
            exit(0);
        } catch (IOException ex) {
            showMessageDialog(null, "Aplikasi Sudah Terbuka . . . \n");
            exit(0);
        }
    }
}
