import java.util.Arrays;
import java.util.Scanner;

public class RSA {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        dFinder();
    }

    public static boolean isPrime(int a) {
        if (a < 2) return false;
        for (int i = 2; i < Math.sqrt(a) + 1; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static int relativePrimeChecker(int z, int e) {
        return (e == 0) ? z : relativePrimeChecker(e, z % e);
    }

    public static void dFinder() {

        // pick random p, q
//        int p = 1, q = 1;
//        while (!isPrime(p)) {
//            p = (int) (Math.random() * 100);
//        }
//        while (!isPrime(q)) {
//            q = (int) (Math.random() * 100);
//        }

        // compute n, z
//        int n = p * q, z = (p - 1) * (q - 1);
//        int zCopy = z;
//        int e = 2;

        // check if e is relative prime with z
//        while (relativePrimeChecker(z, e) != 1) e = (int) (Math.random() * z) + 1;

//        System.out.println("p:" + p + " q:" + q + " n:" + n + " z:" + z + " e:" + e);
//        System.out.printf("%5s   |%5s     |%5s     |%5s", "Dvd", "Dvs", "Q", "R");
//        System.out.println();
        int c, count = 0;
        int[] Quotient = new int[0];

        int p=5, q=13, e=11;
        int n = p * q, z = (p - 1) * (q - 1);
        int zCopy = z;

        // GCD finder and total number of Quotient
        while (e != 0) {

            c = z;
            z = e;
            e = c % e;
            count++;

            int[] arr = new int[Quotient.length + 1];
            arr[Quotient.length] = c/z;
            System.arraycopy(Quotient, 0, arr, 0, Quotient.length);
            Quotient = arr;

            System.out.printf("%5d   |%5d     |%5d     |%5d", c, z, c / z, e);
            System.out.println();

        }

        int [] P = new int[count + 1];
        P[0] = 0; P[1] = 1;

        int x;
        for (int i=2; i<P.length; i++) {
            x = P[i-2] - Quotient[i-2]*P[i-1];
            P[i] = Math.floorMod(x, zCopy);
        }

        System.out.println();
        int index = 0;
        for (int j : P) {
            System.out.println("p" + index +"=" + j);
            index++;
        }

        int d = P[P.length - 1];
        System.out.println(d);
        System.out.print("Enter encrypted message: ");
        String [] encrypted = input.nextLine().split(" ");
        int [] num = new int[encrypted.length];

        for (int i=0; i<num.length; i++) {
            num[i] = Integer.parseInt(encrypted[i]);
        }

        int j=0, k;
        for (int i=0; i< num.length; i++) {
            while (num[i] != 0) {
                k = num[i] % 2;
                num[i] = num[i] / 2;
            }
        }
    }
}
