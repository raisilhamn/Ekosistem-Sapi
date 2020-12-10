import java.util.*;


public class Sapi {

    boolean mati;
    String jenisKelamin;
    int umur;
    boolean subur;
    int jeniskel;


    public Sapi(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
        this.umur = 0;
        this.subur = false;
        this.mati = false;

    }

    public static ArrayList<Sapi> kandang(String jenisKelamin, int ada) {
        ArrayList<Sapi> kandang = new ArrayList<>();
        for (int i = 0; i < ada; i++) {
            Sapi anak = new Sapi(jenisKelamin);
            kandang.add(anak);
        }
        return kandang;
    }

    public static int probangka() {
        Random rn = new Random();
        int hasil = rn.nextInt(10);
//        0->9 ,, 0.5 : 5
        return hasil;
    }

    public static int getProbmati(Sapi sapi) {
        int probmati;
        switch (sapi.umur) {
            case 0:
                probmati = 0;
                break;
            case 1:
                probmati = 1;
                break;
            case 2:
                probmati = 1;
                break;
            case 3:
                probmati = 2;
                break;
            case 4:
                probmati = 2;
                break;
            case 5:
                probmati = 3;
                break;
            case 6:
                probmati = 3;
                break;
            case 7:
                probmati = 4;
                break;
            case 8:
                probmati = 5;
                break;
            default:
                probmati = 10;
                break;
        }
        return probmati;
    }

    public boolean setMati(int prob) {
        Random acak = new Random();
        if (prob == 10)
            this.mati = true;
        else if (prob == 0)
            this.mati = false;
        else {
            int hasil = acak.nextInt(10);
            this.mati = hasil < prob;
        }
        return this.mati;
    }

    public boolean masaSubur(Sapi sapi) {
        if (sapi.jenisKelamin.equals("betina")){
            if (sapi.umur >= 3 && sapi.umur <= 7) {
                this.subur = true;
            } else
                this.subur = false;
        }
        return this.subur;
    }

    public int melahirkan(Sapi sapi) {
        if (sapi.mati == false) {
            if (sapi.masaSubur(sapi)) {
                if (sapi.jenisKelamin.equals("betina")) {
                    Random acak = new Random();
                    sapi.jeniskel = acak.nextInt(101);
                    return sapi.jeniskel;

                }
            }
        }
        return sapi.jeniskel = 102;
    }

    public void nambahUmur(Sapi sapi) {
        sapi.umur += 1;
    }


//    public Sapi melahirkanAnak() {
//        Sapi anak;
////        this.jumlahtotal = this.jumlahjantan + jumlahbetina;
//        anak = new Sapi(this.jumlahlahirjantan, this.jumlahlahirbetina);
//        return anak;
//    }
//
//    public void anak() {
//        for (int i = 0; i < umursapi.length; i++) {
//            if (this.hidup[i] == false) {
//                this.jumlahmati +=1;
//                if (jeniskelamin[i].equals("jantan"))
//                    jumlahjantan -=1;
//                else
//                    jumlahbetina

//            } else {
//
//                if (masaSubur(this.umursapi[i])) {
//                    melahirkan();
//                    if (kelamin.equals("jantan"))
//                        this.jumlahlahirjantan += 1;
//                    else
//                        this.jumlahlahirbetina += 1;
//                }
//
//                this.jumlahlahirtotal = this.jumlahlahirjantan + jumlahlahirbetina;
//                melahirkanAnak();
//
//            }
//
//        }
//
//    }


//    public void display(int tahun) {
//        System.out.println("jumlah sapi yang mati " + this.jumlahmati);
//        System.out.println("jumlah jantan  " + this.jumlahjantan);
//        System.out.println("jumlah betina  " + this.jumlahbetina);
//        System.out.println("jumlah sapi total saat ini " + (this.jumlahtotal));
//        System.out.println("jumlah lahir sapi jantan "+this.jumlahlahirjantan);
//        System.out.println("jumlah lahir sapi betina "+this.jumlahlahirbetina);
//
////        if (this.hidup[tahun] == true) {
////            for (int i = 0; i < this.hidup.length; i++)
////                System.out.println("umur sapi " + this.umursapi[i]);
////            for (int i = 0; i < this.hidup.length; i++)
////                System.out.println("jenis sapi "+this.jeniskelamin[i]);
////        }
//
//    }
//
//
//}
}