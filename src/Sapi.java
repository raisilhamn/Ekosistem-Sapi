/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/* Sapi betina setiap tahun ber anak satu dengan prob jantan / betina sesuai ketentuan
 * Prob mati usia ke 6 : 0.2
 *
 *  boolean jantan = false;
    boolean betina = true;
 *
 */

public class Sapi {
    private final Random acak = new Random();
    int[] umursapi;
    //    int[] umuranaksapi;
    String[] jeniskelaminanaksapi;
    boolean[] jeniskelanaksapi;
    String[] jeniskelamin;
    boolean[] jeniskel;
    boolean subur = false;
    //    private int jumlahbetina;
//    private int jumlahjantan;
    int jumlahsaatini = 0;
    private boolean mati;
    //    private boolean lahir;
    private String kelamin;
    private int umur;
    private int tahun;
    private int anak;
    private boolean[] populasisapi;


    public Sapi(int jumlahjantan, int jumlahbetina) {
        jeniskelamin = new String[jumlahjantan + jumlahbetina];
        umursapi = new int[jumlahjantan + jumlahbetina];
        jeniskel = new boolean[jumlahjantan + jumlahbetina];
        int n = jumlahjantan + jumlahbetina;

        for (int i = 0; i < jumlahjantan; i++) {
            jeniskelamin[i] = "jantan";
            jeniskel[i] = false;
            umursapi[i] = 0;
        }

        for (int i = jumlahjantan; i < n; i++) {
            jeniskelamin[i] = "betina";
            jeniskel[i] = true;
            umursapi[i] = 0;
        }

    }

    public Sapi(int anak) {
        int[] umuranaksapi;
        String[] jeniskelaminanaksapi;
        jeniskelaminanaksapi = new String[anak];
        umuranaksapi = new int[anak];
        jeniskelanaksapi = new boolean[anak];
        int n = anak;

        for (int i = 0; i <= n - 1; i++) {
            if (kelamin == "jantan") {
                jeniskelaminanaksapi[i] = "jantan";
                jeniskelanaksapi[i] = false;
                umuranaksapi[i] = 0;
            } else {
                jeniskelaminanaksapi[i] = "betina";
                jeniskelanaksapi[i] = true;
                umuranaksapi[i] = 0;
            }
        }

    }


    public boolean kemungkinanMati(int umur) {
        double probmati;
        switch (umur) {
            case 0:
                probmati = 0.0;
                break;
            case 1:
                probmati = 0.1;
                break;
            case 2:
                probmati = 0.1;
                break;
            case 3:
                probmati = 0.2;
                break;
            case 4:
                probmati = 0.2;
                break;
            case 5:
                probmati = 0.3;
                break;
            case 6:
                probmati = 0.3;
                break;
            case 7:
                probmati = 0.4;
                break;
            case 8:
                probmati = 0.5;
                break;
            default:
                probmati = 1.0;
                break;
        }
        if (probmati == 1.0)
            mati = true;
        else
            mati = acak.nextDouble() < probmati;

        return mati;
    }

    public boolean masaSubur(int umur) {
        if (umur >= 3 && umur <= 7) {
            subur = true;
        }
        return subur;
    }

    public void melahirkan() {
        boolean subur = masaSubur(umur);
        if (subur) {
            int variabel = acak.nextInt(100);
            if (variabel >= 60) {
//                lahir = false;
                kelamin = "jantan";
            } else {
                kelamin = "betina";
//                lahir = true;
            }

        }
    }

    public void nambahUmur() {
        for (int i = 0; i < jeniskelamin.length; i++) {
            umursapi[i] += 1;
        }
    }

    public void gantiTahun() {


        for (int i = 0; i < jeniskelamin.length; i++) {
            boolean keadaan = kemungkinanMati(umursapi[i]);
            if (keadaan) {
                jeniskelamin[i] = "mati";
            }
        }

        for (int i = 0; i < jeniskelamin.length; i++) {
            boolean keadaan = masaSubur(umursapi[i]);
            if (keadaan) {
                melahirkan();
                if (kelamin.equals("jantan")) {
                    anak += 1;
                    System.out.println("jantan");
                } else {
                    anak += 1;
                    System.out.println("betina");
                }
            }
        }

    }

//    public int hitung() {
//        for (int i = 0; i < jeniskelamin.length; i++) {
//            if (jeniskelamin[i].equals("mati"))
//                jumlahsaatini += 1;
//        }
//        System.out.println("Jumlah sapi ini " + jumlahsaatini);
//        return jumlahsaatini;
//    }


    public void display() {


        for (int i = 0; i < jeniskelamin.length; i++) {
            int n = i + 1;
            if (jeniskelamin[i].equals("mati")) {
                System.out.println("sapi ke " + n + " sudah mati ");
            } else {
                System.out.println("sapi ke " + n + " berjenis kelamin " + jeniskelamin[i]);
                n = 0;
            }

        }

        System.out.println();
        for (int i = 0; i < jeniskelamin.length; i++) {
            int n = i + 1;

            System.out.println("sapi ke " + n + " Berumur  " + umursapi[i]);
            n = 0;
        }

        for (int i = 0; i < jeniskelamin.length; i++) {
            int n = i + 1;
            if (jeniskelamin[i].equals("mati")) {
                continue;
            } else {
                jumlahsaatini += 1;
                System.out.println("sapi ke " + n + " Berumur  " + umursapi[i]);

                n = 0;
            }

        }

        try {
            for (int i = 0; i < anak; i++) {
                int n = i;
                System.out.println("sapi ke " + n + " jenis kel  " + jeniskelanaksapi[i]);
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Eror di metod anak");
        }


//            for (int i = 0; i < anak; i++) {
//                int n = i +1;
//                System.out.println("Anak sapi ke " + n + " berjenis kelamin " + jeniskelamin[i]);
//                n = 0;
//            }
//            for (int i = 0; i < jeniskelamin.length; i++) {
//                int n = i +1;
//                System.out.println("sapi ke " + n + " Berumur  " + umursapi[i]);
//                n = 0;
//            }
//            for (int i = 0; i < jeniskelamin.length; i++) {
//                int n = i +1;
//                System.out.println("sapi ke " + n + " Berumur  " + jeniskel[i]);
//                n = 0;
//            }
        System.out.println();

    }



}
