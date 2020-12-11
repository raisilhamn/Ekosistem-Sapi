import java.util.ArrayList;

public class perhitungan {
    double sum;
    double varian;
    double nilairata2;
    int lahirjantantahunini;
    int lahirbetinatahunini;
    int matitahunini;
    ArrayList<Integer> tahunke;


    public double ratarata(ArrayList<Integer> rata2) {
        for (int p = 0; p < rata2.size(); p++) {
            sum += rata2.get(p);
        }
        nilairata2 = sum / rata2.size();
        return nilairata2;
    }
    public ArrayList<Integer> tahunke(int tahun) {


        return tahunke;

    }


    public String toString(int tahunke){
        String tahunberapa = Integer.toString(tahunke);
        return tahunberapa;

    }



    public double standarDeviasi(ArrayList<Integer> rata2) {
        for (int p = 0; p < rata2.size(); p++) {
            varian += Math.pow(rata2.get(p) - nilairata2, 2);
        }
        varian = Math.sqrt(varian / rata2.size());
        return varian;
    }
    public int reset(int a){
        a = 0;
        return a;
    }
    public void display(int a){
        System.out.println(a);
    }


}
