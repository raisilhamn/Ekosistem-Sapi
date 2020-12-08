import java.util.*;


public class Sapi {
    Random acak = new Random();
    private int[] umursapi;
    private String kelamin = "";
    private String[] jeniskelamin;
    private int jumlahjantan;
    private int jumlahbetina;
    private int jumlahtotal;
    private boolean subur = false;
    private int jumlahmati;
    private boolean[] hidup;
    private boolean mati;
    private int jumlahlahirbetina;
    private int jumlahlahirjantan;
    private int jumlahlahirtotal;

    /**
     *
     * TODO: yang jadi masalah adalah bagaimana cara menyimpan data anak yang lahir
     * TODO: anak tersebut juga memiliki kemampuan untuk melahirkan
     *
     *
     *
     * @param jumlahjantan
     * @param jumlahbetina
     */
    public Sapi(int jumlahjantan, int jumlahbetina) {
        this.jumlahjantan = jumlahjantan;
        this.jumlahbetina = jumlahbetina;
        this.jumlahtotal = jumlahjantan + jumlahbetina;
        this.umursapi = new int[this.jumlahtotal];
        this.jeniskelamin = new String[this.jumlahtotal];
        this.hidup = new boolean[this.jumlahtotal];
        for (int i = 0; i < jumlahjantan; i++) {
            this.jeniskelamin[i] = "jantan";
            this.umursapi[i] = 0;
            this.hidup[i] = true;
        }
        for (int i = jumlahjantan; i < jumlahtotal; i++) {
            this.jeniskelamin[i] = "betina";
            this.umursapi[i] = 0;
            this.hidup[i] = true;
        }

    }


    public void nambahUmur() {
        for (int i = 0; i < umursapi.length; i++) {
            this.umursapi[i] += 1;
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
            return true;
        else if (probmati == 0.0)
            return false;
        else
            return acak.nextDouble() <= probmati;

    }


    public boolean masaSubur(int umur) {
        if (umur >= 3 && umur <= 7) {
            return true;
        } else
            return false;
    }

    public String melahirkan() {
            int variabel = acak.nextInt(100);
            if (variabel <= 60) {
                this.kelamin = "jantan";
            } else {
                this.kelamin = "betina";
            }
        return kelamin;
    }


    public void mati() {
        for (int i = 0; i < umursapi.length; i++) {
            if (kemungkinanMati(this.umursapi[i]) == true) {
                this.hidup[i] = false;
            }
        }
    }
    public Sapi melahirkanAnak() {
        Sapi anak;
//        this.jumlahtotal = this.jumlahjantan + jumlahbetina;
        anak = new Sapi(this.jumlahlahirjantan, this.jumlahlahirbetina);
        return anak;
    }

    public void anak() {
        for (int i = 0; i < umursapi.length; i++) {
            if (this.hidup[i] == false) {
                this.jumlahmati +=1;
//                if (jeniskelamin[i].equals("jantan"))
//                    jumlahjantan -=1;
//                else
//                    jumlahbetina

            } else {

                if (masaSubur(this.umursapi[i])) {
                    melahirkan();
                    if (kelamin.equals("jantan"))
                        this.jumlahlahirjantan += 1;
                    else
                        this.jumlahlahirbetina += 1;
                }

                this.jumlahlahirtotal = this.jumlahlahirjantan + jumlahlahirbetina;
                melahirkanAnak();

            }

        }

    }




    public void display(int tahun) {
        System.out.println("jumlah sapi yang mati " + this.jumlahmati);
        System.out.println("jumlah jantan  " + this.jumlahjantan);
        System.out.println("jumlah betina  " + this.jumlahbetina);
        System.out.println("jumlah sapi total saat ini " + (this.jumlahtotal));
        System.out.println("jumlah lahir sapi jantan "+this.jumlahlahirjantan);
        System.out.println("jumlah lahir sapi betina "+this.jumlahlahirbetina);

//        if (this.hidup[tahun] == true) {
//            for (int i = 0; i < this.hidup.length; i++)
//                System.out.println("umur sapi " + this.umursapi[i]);
//            for (int i = 0; i < this.hidup.length; i++)
//                System.out.println("jenis sapi "+this.jeniskelamin[i]);
//        }

    }


}