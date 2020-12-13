import java.util.*;
import java.util.zip.DeflaterOutputStream;

public class Main {
    public int tahun;

    /* !! Eror di tracking penambahan umur,kadang benar kadang engga
     *
     * @param args
     */


    public static void main(String[] args) {

        ArrayList<Sapi> kandang = new ArrayList<>();
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        ArrayList<Double> varians = new ArrayList<>();
        ArrayList<Double> dataA = new ArrayList<>();
        Perhitungan hitung = new Perhitungan();
        Scanner input = new Scanner(System.in);

        int mati = 0;
        int lahirjantan = 0;
        int lahirbetina = 0;
        int lahirjantantahunini = 0;
        int lahirbetinatahunini = 0;
        int totallahirtahunini = 0;
        int matitahunini = 0;
        double sum = 0.0;
        double nilairata2 = 0.0;
        Sapi sapi;

        System.out.print("Input tahun : ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++)
            data.add(new ArrayList<>());
//        Double[][] dataArray = new Double[n][20];
        for (int p = 1; p <= 20; p++) {
            System.out.println();
            System.out.println("======================== Siklus ke " + p + " ===========================");
            kandang.addAll(Sapi.kandang("jantan", 5));
            kandang.addAll(Sapi.kandang("betina", 10));
            for (int tahun = 1; tahun <= n; tahun++) {
                System.out.println("------ tahun ke - " + tahun + " ------ ");
                for (int i = 0; i < kandang.size(); i++) {
                    sapi = kandang.get(i);
                    int peluang = Sapi.getProbmati(sapi);
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
                System.out.print("sapi jantan lahir tahun ini ada ");
                hitung.display(lahirjantantahunini);
                System.out.print("sapi betina lahir tahun ini ada ");
                hitung.display(lahirbetinatahunini);
                System.out.print("Total sapi lahir tahun ini ");
                hitung.display(totallahirtahunini);
                System.out.print("sapi mati tahun ini ada ");
                hitung.display(matitahunini);
                System.out.print("Total sapi tewas : ");
                hitung.display(mati);
                System.out.print("Total sapi  jantan yang pernah lahir  : ");
                hitung.display(lahirjantan);
                System.out.print("Total sapi  betina yang pernah lahir : ");
                hitung.display(lahirbetina);
                System.out.print("ukuran populasi saat ini : ");
                hitung.display(kandang.size());

                lahirjantantahunini = hitung.reset(lahirjantantahunini);
                lahirbetinatahunini = hitung.reset(lahirbetinatahunini);
                matitahunini = hitung.reset(matitahunini);
                totallahirtahunini = hitung.reset(totallahirtahunini);

            }
            kandang.clear();
            lahirjantan = hitung.reset(lahirjantan);
            lahirbetina = hitung.reset(lahirbetina);
            mati = hitung.reset(mati);

        }
        System.out.println(" _______________________ ");
        for (int i = 0; i < data.size(); i++) {
            int tahun = i + 1;
            double jumlah = 0.0;
            double sigma = 0.0;
            dataA = data.get(i);
            for (int j = 0; j < dataA.size(); j++) {
                jumlah += dataA.get(j);
            }
            double mean = jumlah / dataA.size();
            System.out.println("mean tahun ke " + tahun + " = " + mean);
            for (int k = 0; k < dataA.size(); k++) {
                sigma = dataA.get(k) - mean;
                sigma += sigma;
            }

            double varian = (Math.sqrt((sigma * sigma) / dataA.size()));
            varians.add(varian);


        }
        for (int i = 0; i < data.size(); i++) {
            int tahun = i + 1;
            System.out.println("varian tahun ke " + tahun + " = " + varians.get(i));
        }
    }

}

