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
        int mati = 0;
        for (int tahun = 1; tahun < 20; tahun++) {
            System.out.println("tahun ke - " + tahun + " ====================== ");
            for (int i = 0; i < kandang.size(); i++) {
                Sapi sapi = kandang.get(i);
                sapi.nambahUmur(sapi);
//                System.out.println("umur sapi : "+sapi.umur);
                int peluang = Sapi.getProbmati(sapi);
                System.out.println(peluang);
                if (sapi.setMati(peluang)){
                    kandang.remove(kandang.get(i));
                    mati++;

                }

                if (sapi.masaSubur(sapi)==true){
                    int anak = sapi.melahirkan(sapi);
                    if (anak >= 60)
                        kandang.addAll(Sapi.kandang("jantan",1));
                    else if (anak <60)
                        kandang.addAll(Sapi.kandang("betina",1));
                    else if (anak == 102)
                        continue;
                }


            }

            System.out.println("jumlah sapi tewas "+ mati);
            System.out.println("ukuran populasi saat ini "+kandang.size());


        }


//            int anak = Sapi.
    }

}

