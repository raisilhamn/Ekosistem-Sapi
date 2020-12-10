/**
 * jantan = false
 * betina = true
 */

import java.util.*;

public class Main {
    public int tahun;


    public static void main(String[] args) {
//        Sapi sapi;
        ArrayList<Sapi> kandang = new ArrayList<>();
        kandang.addAll(Sapi.kandang("jantan", 5));
        kandang.addAll(Sapi.kandang("betina", 10));
//        int tahun = 1;
        for (int tahun = 1; tahun < 20; tahun++){
            System.out.println(" tahun ke - " + tahun + " ====================== ");
            for(int i = 0; i < kandang.size(); i++){
                Sapi sapi = kandang.get(i);
                sapi.nambahUmur(sapi);
                Sapi.probmati(sapi);
                if (sapi.melahirkan(sapi) > 60)
                    kandang.addAll(Sapi.kandang("jantan", 1));
                else if (sapi.melahirkan(sapi)<60)
                    kandang.addAll(Sapi.kandang("betina", 1));
                else if (sapi.melahirkan(sapi) == 102)
                    continue;
                kandang.removeIf(sapi1 -> sapi.mati ==true);
                tahun += 1;
                int jumlahtotal = kandang.size();
                System.out.println("populasi sapi sekarang " + jumlahtotal);

            }


//            int anak = Sapi.
        }

    }
}
