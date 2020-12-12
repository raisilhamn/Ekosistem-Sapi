import java.util.*;


public class Sapi {

    public boolean mati;
    public String jenisKelamin;
    public int umur;
    public boolean subur;
    public int jeniskel;


    public Sapi(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
        this.umur = 0;
        this.subur = false;
        this.mati = false;

    }

    public static ArrayList<Sapi> kandang(String jenisKelamin, int nambah) {
        ArrayList<Sapi> kandang = new ArrayList<>();

        for (int i = 0; i < nambah; i++) {
            Sapi anak = new Sapi(jenisKelamin);
            kandang.add(anak);
        }
        return kandang;
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
            // misal
            // 5 prob 3 => menghasilkan false
            // false = tidak mati
        }
        return this.mati;
    }

    public boolean masaSubur(Sapi sapi) {
        if (sapi.jenisKelamin.equals("betina")) {
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
                    sapi.jeniskel = acak.nextInt(100);
                    return sapi.jeniskel;
                }
            }
        }
        return sapi.jeniskel = 101;
    }

    public void nambahUmur(Sapi sapi) {
        sapi.umur++;
    }

}