/**
 * jantan = false
 * betina = true
 */

import java.util.*;

public class Main {


    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int inputuser = input.nextInt();
        Sapi sapi;
        sapi = new Sapi(5, 10);
        for (int tahun = 1; tahun <= 5; tahun++) {
            System.out.println("Ini adalah tahun ke "+ tahun +" ================================ ");
            sapi.gantiTahun();
            sapi.nambahUmur();
            sapi.display();

        }
//        sapi.hitung();

//        sapi.display();

    }
}
