import java.util.*;

public class Main {
    public int tahun;

    /* TODO: menambahkan fitur menghitung rata rata dan varian.
     *
     * @param args
     */


    public static void main(String[] args) {

        ArrayList<Sapi> kandang = new ArrayList<>();
        ArrayList<Integer> rata2 = new ArrayList<>();


        perhitungan hitung = new perhitungan();

        Scanner input = new Scanner(System.in);


        int mati = 0;
        int lahirjantan = 0;
        int lahirbetina = 0;
        int lahirjantantahunini = 0;
        int lahirbetinatahunini = 0;
        int matitahunini = 0;
        double sum = 0.0;
        double nilairata2 = 0.0;
        double varian = 0.0;

        kandang.addAll(Sapi.kandang("jantan", 5));
        kandang.addAll(Sapi.kandang("betina", 10));
//        for (int j = 0; j<20; j++) {
        System.out.print("Input tahun : ");
        int n = input.nextInt();
        for (int tahun = 1; tahun <= n; tahun++) {

            perhitungan rata;
            System.out.println();
            System.out.println("tahun ke - " + tahun + " ====================== ");
            for (int i = 0; i < kandang.size(); i++) {
                Sapi sapi = kandang.get(i);
                System.out.println("umur sapi " + sapi.umur + " berjenis kelamin " + sapi.jenisKelamin);
                int peluang = Sapi.getProbmati(sapi);
                if (sapi.setMati(peluang)) {
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
                sapi.nambahUmur(sapi);

            }
            // display

            System.out.println();
            System.out.print("sapi jantan lahir tahun ini ada ");
            hitung.display(lahirjantantahunini);
            System.out.print("sapi betina lahir tahun ini ada ");
            hitung.display(lahirbetinatahunini);
            System.out.print("sapi mati tahun ini ada ");
            hitung.display(matitahunini);
            System.out.println();
            System.out.print("Total sapi tewas : ");
            hitung.display(mati);
            System.out.print("Total sapi  jantan yang pernah lahir  : ");
            hitung.display(lahirjantan);
            System.out.print("Total sapi  betina yang pernah lahir : ");
            hitung.display(lahirbetina);
            System.out.print("ukuran populasi saat ini : ");
            hitung.display(kandang.size());

            int A = kandang.size();
            rata2.add(A);

            lahirjantantahunini = hitung.reset(lahirjantantahunini);
            lahirbetinatahunini = hitung.reset(lahirbetinatahunini);
            matitahunini = hitung.reset(matitahunini);

            if (tahun == n) {
                System.out.println();
                nilairata2 = hitung.ratarata(rata2);
                System.out.println("Nilai rata rata dari siklus ini adalah " + nilairata2);
                varian = hitung.standarDeviasi(rata2);
                System.out.println("Nilai varian dari siklus ini adalah " + varian);

            }


        }
//        }

    }

}

