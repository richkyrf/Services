/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

import static java.lang.System.out;
import java.sql.SQLException;

public class ErorMessage {

    public static String cekeror(SQLException e) {
        int eror1 = e.getErrorCode();
        String errormessage;
        if (eror1 == 1062) {
            errormessage = "Data Sudah Ada yang Sama";
        } else if (eror1 == 1406) {
            errormessage = "data yang di input Terlalu Panjang !";
        } else if (eror1 == 1049) {
            errormessage = "Database Tidak Di temukan !";
        } else if (eror1 == 1045) {
            errormessage = "Memiliki Hak Akses";
        } else if (eror1 == 1451) {
            errormessage = "data telah terpakai tidak dapat di ubah/hapus";
        } else if (eror1 == 1452) {
            errormessage = "data yang di masukan salah atau belum ada di master";
        } else if (eror1 == 1064) {
            errormessage = "Eror Pada SQL Program";
        } else if (eror1 == 1366) {
            errormessage = "Input Ada yang salah Coba Cek Lagi";
        } else if (eror1 == 1292) {
            errormessage = "Input Ada yang salah Coba Cek Lagi";
        } else if (eror1 == 1048) {
            errormessage = "Data Tidak Boleh Kosong";
        } else if (eror1 == 1049) {
            errormessage = "Database Tidak Dikenali";
        } else if (eror1 == 0) {
            errormessage = "EROR 0 tidak diketahui" + e.getMessage();
        } else {
            errormessage = "EROR xxx tidak diketahui" + e.getMessage();
        }
        out.println("E4" + e);
        e.printStackTrace();
        return errormessage;
    }

    private ErorMessage() {
    }
}
