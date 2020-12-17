import java.util.ArrayList;

public class Perhitungan {

    /**
     * Memproses Mean dari data yang di simpan di Arraylist yang di dalamnya ada Arraylist
     *
     * @param data
     * @param i
     * @return
     */
    public static double Mean(ArrayList<ArrayList<Double>> data, int i) {
        double jumlah = 0.0;
        ArrayList<Double> dataA;
        dataA = data.get(i);
        for (int j = 0; j < dataA.size(); j++) {
            jumlah += dataA.get(j);
        }
        return jumlah / dataA.size();
    }

    /**
     * memproses mean dari cuaca setiap siklus (20 kali)
     *
     * @param data
     * @param i
     * @param tahun
     * @return
     */
    public static double MeanCuaca(ArrayList<Double> data, int i, int tahun) {
        double jumlah = 0.0;
        jumlah = data.get(i);
        return jumlah / tahun;
    }

    /**
     * Memproses Mean dari data yang di simpan di Arraylist yang di dalamnya ada Arraylist
     *
     * @param data
     * @param i
     * @param mean
     * @return
     */
    public static double varian(ArrayList<ArrayList<Double>> data, int i, double mean) {
        double sigma = 0.0;
        ArrayList<Double> dataA;
        dataA = data.get(i);
        for (int k = 0; k < dataA.size(); k++) {
            sigma = dataA.get(k) - mean;
            sigma += sigma;
        }
        return (Math.sqrt((sigma * sigma) / dataA.size()));
    }

    public int reset() {
        return 0;
    }

}
