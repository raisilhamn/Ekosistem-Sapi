import java.util.*;

public class Main {
    public int tahun;


    public static void main(String[] args) {
        ArrayList<Sapi> kandang = new ArrayList<>();
        kandang.addAll(Sapi.kandang("jantan", 5));
        kandang.addAll(Sapi.kandang("betina", 10));
        int mati = 0;
        int lahirjantan = 0;
        int lahirbetina = 0;
        for (int tahun = 1; tahun < 20; tahun++) {
            System.out.println("============== tahun ke - " + tahun + " ====================== ");
            for (int i = 0; i < kandang.size(); i++) {
                Sapi sapi = kandang.get(i);
                System.out.println("umur sapi : " + sapi.umur);
                int peluang = Sapi.getProbmati(sapi);
                if (sapi.setMati(peluang)) {
                    kandang.remove(kandang.get(i));
                    mati++;

                }

                if (sapi.masaSubur(sapi) == true) {
                    int anak = sapi.melahirkan(sapi);
                    if (anak >= 60) {
                        kandang.addAll(Sapi.kandang("jantan", 1));
                        lahirjantan++;
                    } else if (anak < 60) {
                        kandang.addAll(Sapi.kandang("betina", 1));
                        lahirbetina++;
                    } else if (anak == 102)
                        continue;
                }
                sapi.nambahUmur(sapi);

            }


            System.out.println("total sapi tewas : " + mati);
            System.out.println("Total sapi  jantan yang pernah lahir  : " + lahirjantan);
            System.out.println("Total sapi  betina yang pernah lahir : " + lahirbetina);
            System.out.println("ukuran populasi saat ini : " + kandang.size());


        }

    }

}

