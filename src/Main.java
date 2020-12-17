import java.util.*;

public class Main {
    public int tahun;

    /* !! Eror di tracking penambahan umur,kadang benar kadang engga
     *
     * @param args
     */


    public static void main(String[] args) {

        ArrayList<Sapi> kandang = new ArrayList<>();
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        ArrayList<ArrayList<Double>> dataCuaca = new ArrayList<>();
        ArrayList<Double> varians = new ArrayList<>();
        Perhitungan hitung = new Perhitungan();
        Scanner input = new Scanner(System.in);

        int mati = 0;
        int lahirjantan = 0;
        int lahirbetina = 0;
        int lahirjantantahunini = 0;
        int lahirbetinatahunini = 0;
        int totallahirtahunini = 0;
        int matitahunini = 0;
        int cuacaburuk = 0;
        double sum = 0.0;
        Sapi sapi;

        System.out.print("Input tahun : ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++)
            data.add(new ArrayList<>());
        for (int p = 1; p <= 20; p++) {
            dataCuaca.add(new ArrayList<>());
            System.out.println();
            System.out.println("======================== Siklus ke " + p + " ===========================");
            kandang.addAll(Sapi.kandang("jantan", 5));
            kandang.addAll(Sapi.kandang("betina", 10));
            for (int tahun = 1; tahun <= n; tahun++) {
                System.out.println("------  tahun ke - " + tahun + " ------ ");
                boolean cuaca = Sapi.cuaca();
                if (cuaca == true) {
                    cuacaburuk += 1;
                    System.out.println("---------------");
                    System.out.println("| cuaca buruk |");
                    System.out.println("---------------");
                }
                for (int i = 0; i < kandang.size(); i++) {
                    sapi = kandang.get(i);
                    int peluang = Sapi.getProbmati(sapi, cuaca);
                    if (sapi.setMati(peluang) == true) {
                        kandang.remove(kandang.get(i));
                        mati++;
                        matitahunini++;
                    }
                    if (sapi.masaSubur(sapi) == true) {
                        int anak = sapi.melahirkan(sapi);
                        if (anak >= 60) {
                            kandang.addAll(Sapi.kandang("jantan", 1));
                            lahirjantan++;
                            lahirjantantahunini++;
                        } else if (anak < 60) {
                            kandang.addAll(Sapi.kandang("betina", 1));
                            lahirbetina++;
                            lahirbetinatahunini++;
                        } else if (anak == 102)
                            continue;
                    }
                    if (sapi.mati == false)
                        sapi.nambahUmur(sapi);
                }
                data.get(tahun - 1).add((double) kandang.size());
                totallahirtahunini = lahirbetinatahunini + lahirjantantahunini;
                System.out.println("sapi jantan lahir tahun ini ada " + lahirjantantahunini);
                System.out.println("sapi betina lahir tahun ini ada " + lahirbetinatahunini);
                System.out.println("Total sapi lahir tahun ini " + totallahirtahunini);
                System.out.println("sapi mati tahun ini ada " + matitahunini);
                System.out.println("Total sapi tewas : " + mati);
                System.out.println("Total sapi  jantan yang pernah lahir  : " + lahirjantan);
                System.out.println("Total sapi  betina yang pernah lahir : " + lahirbetina);
                System.out.println("ukuran populasi saat ini : " + kandang.size());
                lahirjantantahunini = hitung.reset();
                lahirbetinatahunini = hitung.reset();
                matitahunini = hitung.reset();
                totallahirtahunini = hitung.reset();
            }
            dataCuaca.get(p - 1).add((double) cuacaburuk);
            System.out.println("terjadi cuaca buruk sebanyak : " + cuacaburuk + " kali dalam siklus ini");
            cuacaburuk = hitung.reset();
            kandang.clear();
            lahirjantan = hitung.reset();
            lahirbetina = hitung.reset();
            mati = hitung.reset();
        }
        System.out.println(" _______________________ ");
        for (int i = 0; i < data.size(); i++) {
            int tahun = i + 1;
            double mean = hitung.Mean(data, i);
            System.out.println("Rata rata jumlah sapi tahun ke " + tahun + " = " + mean);
            double varian = hitung.varian(data, i, mean);
            varians.add(varian);
        }
        System.out.println();
        for (int i = 0; i < data.size(); i++) {
            int tahun = i + 1;
            System.out.println("varian jumlah sapi tahun ke " + tahun + " = " + varians.get(i));
        }
        System.out.println();
        for (int i = 0; i < dataCuaca.size(); i++) {
            int tahun = i + 1;
            double mean = hitung.Mean(dataCuaca, i);
            System.out.println("Rata rata terjadinya cuaca buruk di siklus ke " + tahun + " = " + mean);
        }

    }

}

