import java.util.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) {

        ArrayList<Sapi> kandang = new ArrayList<>();
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        ArrayList<Double> dataCuaca = new ArrayList<>();
        ArrayList<Double> varians = new ArrayList<>();
        Perhitungan hitung = new Perhitungan();
        Scanner input = new Scanner(System.in);
        int cuacaburuk = 0;
        Sapi sapi;

        System.out.print("Input tahun : ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++)
            data.add(new ArrayList<>());
        for (int p = 1; p <= 20; p++) {
            int totalcuacaburuksiklusini = 0;
            System.out.println();
            System.out.println(ANSI_BLUE + "======================== Siklus ke " + p + " ===========================" + ANSI_RESET);
            kandang.addAll(Sapi.kandang("jantan", 5));
            kandang.addAll(Sapi.kandang("betina", 10));
            for (int tahun = 1; tahun <= n; tahun++) {
                int populasijantantahunini = 0;
                int populasibetinatahunini = 0;
                int matitahunini = 0;
                int lahirjantantahunini = 0;
                int lahirbetinatahunini = 0;
                int totallahirtahunini = 0;
                System.out.println("------  tahun ke - " + tahun + " ------ ");
                boolean cuaca = Sapi.cuaca();
                if (cuaca) {
                    cuacaburuk += 1;
                    totalcuacaburuksiklusini += 1;
                    System.out.println(ANSI_RED + "---------------" + ANSI_RESET);
                    System.out.println(ANSI_RED + "| cuaca buruk |" + ANSI_RESET);
                    System.out.println(ANSI_RED + "---------------" + ANSI_RESET);
                }
                for (int i = 0; i < kandang.size(); i++) {
                    sapi = kandang.get(i);
                    int peluang = Sapi.getProbmati(sapi, cuaca);
                    if (sapi.setMati(peluang)) {
                        kandang.remove(kandang.get(i));
                        matitahunini++;
                    }
                    if (sapi.masaSubur(sapi)) {
                        int anak = sapi.melahirkan(sapi);
                        if (anak >= 60) {
                            kandang.addAll(Sapi.kandang("jantan", 1));
                            lahirjantantahunini++;
                        } else if (anak < 60) {
                            kandang.addAll(Sapi.kandang("betina", 1));
                            lahirbetinatahunini++;
                        }
                    }
                    if (!sapi.mati)
                        sapi.nambahUmur(sapi);
                    if (sapi.jenisKelamin.equals("jantan"))
                        populasijantantahunini += 1;
                    else if (sapi.jenisKelamin.equals("betina"))
                        populasibetinatahunini += 1;

                }
                totallahirtahunini = lahirjantantahunini + lahirbetinatahunini;
                data.get(tahun - 1).add((double) kandang.size());
                System.out.println("jumlah sapi mati tahun ini : " + matitahunini);
                System.out.println("jumlah sapi jantan lahir tahun ini : " + lahirjantantahunini);
                System.out.println("jumlah sapi betina lahir tahun ini : " + lahirbetinatahunini);
                System.out.println("total lahir tahun ini : " + totallahirtahunini);
                System.out.println("jumlah sapi jantan tahun ini : " + populasijantantahunini);
                System.out.println("jumlah sapi betina tahun ini : " + populasibetinatahunini);
                System.out.println("ukuran populasi saat ini : " + kandang.size());


            }
            dataCuaca.add((double) cuacaburuk);
            System.out.println();
            System.out.println(ANSI_RED + "terjadi cuaca buruk sebanyak : " + cuacaburuk + " kali dalam siklus ini" + ANSI_RESET);
            cuacaburuk = hitung.reset();
            kandang.clear();
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
            double mean = hitung.MeanCuaca(dataCuaca, i, n);
            System.out.println("Rata rata terjadinya cuaca buruk di siklus ke " + tahun + " = " + mean);
        }

    }

}

