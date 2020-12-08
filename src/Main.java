/**
 * jantan = false
 * betina = true
 */

public class Main {
    public int tahun;


    public static void main(String[] args) {

        Sapi sapi;
        sapi = new Sapi(5, 10);

        for (int tahun = 1; tahun <= 20; tahun++) {
            System.out.println(" tahun ke - " + tahun + " ====================== ");

            if (tahun > 1)
                sapi.nambahUmur();
            sapi.mati();
            sapi.anak();
//            sapi.melahirkanAnak();
            sapi.display(tahun);


        }

    }
}
