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
        for (int tahun = 1; tahun <= 8; tahun++) {
            System.out.println(" tahun ke - "+ tahun +" ================================ ");
            sapi.gantiTahun();
            sapi.nambahUmur();
            sapi.nambahUmurAnak();
            sapi.display();

        }
//        sapi.hitung();

//        sapi.display();

    }
}
