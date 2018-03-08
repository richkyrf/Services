/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses.PS;

import F.RunSelctOne;
import java.util.logging.Logger;

public class Cek {

    private static final Logger LOG = Logger.getLogger(Cek.class.getName());

    /**
     *
     * @param NoPermintaan
     * @return
     */
    public static String isadaperintahkerja(String NoPermintaan) {
        RunSelctOne runSelctOne = new F.RunSelctOne();
        runSelctOne.setQuery("SELECT `NoPerintahKerja` FROM `tbperintahkerja` WHERE  `NoPermintaan` =  '" + NoPermintaan + "'");
        runSelctOne.seterorm("Eror SQL CEK Permintaan");
        return runSelctOne.excute();
    }

    /**
     *
     * @param NoPerintahKerja
     * @return
     */
    public static String isadaopname(String NoPerintahKerja) {
        RunSelctOne runSelctOne = new F.RunSelctOne();
        runSelctOne.setQuery("SELECT `NoOpnameSPK` FROM `tbopnamespk` WHERE  `NoPerintahKerja` =  '" + NoPerintahKerja + "'");
        runSelctOne.seterorm("Eror SQL CEK Permintaan");
        return runSelctOne.excute();
    }

    /**
     *
     * @param Plat
     * @return
     */
    public static float JmlahKMO(String Plat) {
        RunSelctOne runSelctOne = new F.RunSelctOne();
        runSelctOne.setQuery("SELECT `KMO` FROM `ttruck` WHERE `NoPolisi` = '" + Plat + "' and `Stat` =1 ");
        runSelctOne.seterorm("Eror SQL CEK KMO");
        float h = -1;
        String hasil = runSelctOne.excute();
        if (hasil != null) {
            h = Float.parseFloat(hasil);
        } else {
            h = 100000;
        }
        return h;
    }

}
