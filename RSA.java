import java.util.Arrays;
import java.util.Scanner;

public class RSA {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter p: ");
        int p = input.nextInt();

        System.out.print("Enter q: ");
        int q = input.nextInt();

        System.out.print("Enter e: ");
        int e = input.nextInt();
        input.nextLine();

        System.out.print("Enter encrypted messages: ");
        String encryptedM = input.nextLine();

        int n = nCalculator(p, q);
        int z = zCalculator(p, q);
        int [] numEncrypted = numEncrypted(encryptedM);
        int [] pArr = pArr(e, z);
        int d = dFinder(pArr);
        String binary = binaryConverter(d);
        int [] indexArr = indexArr(binary);
        int [] decryptedM = decryptedM(indexArr, numEncrypted, n, binary);

        int count = 0;
        for (int i : pArr) {
            System.out.println("p" + count + "=" + i);
            count++;
        }

        System.out.println("-----> d=" + d);
        for (int i : decryptedM)
            System.out.println("Result: " + i);
    }

    public static int nCalculator (int p, int q) {
        return p*q;
    }

    public static int zCalculator (int p, int q) {
        return (p-1)*(q-1);
    }

    public static int [] numEncrypted (String encryptedM) {
        String [] encrypted = encryptedM.split(" ");
        int [] numEncrypted = new int[encrypted.length];

        for (int i=0; i<numEncrypted.length; i++)
            numEncrypted[i] = Integer.parseInt(encrypted[i]);

        return numEncrypted;
    }

    public static int [] pArr (int e, int z) {
        int c, count = 0, zCopy = z;
        int[] Quotient = new int[0];

        // GCD finder and total number of Quotient
        System.out.printf("%5s   |%5s     |%5s     |%5s", "Dvd", "Dvs", "Q", "R");
        System.out.println();
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
        P[0] = 0;
        P[1] = 1;

        int x;
        for (int i=2; i<P.length; i++) {
            x = P[i-2] - Quotient[i-2]*P[i-1];
            P[i] = Math.floorMod(x, zCopy);
        }

        return P;
    }

    public static int dFinder (int [] pArr) {
        return pArr[pArr.length - 1];
    }

    public static String binaryConverter (int d) {
        String binary ="";
        while (d != 0) {
            binary += d % 2;
            d = d / 2;
        }

        return binary;
    }

    public static int [] indexArr (String binary) {
        int [] indexArr = new int[0];
        for (int i=0; i<binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                int [] arr = new int[indexArr.length + 1];
                arr[indexArr.length] = i;
                System.arraycopy(indexArr, 0, arr, 0, indexArr.length);
                indexArr = arr;
            }
        }

        return indexArr;
    }

    public static int [] decryptedM (int [] indexArr, int [] numEncrypted, int n, String binary) {
        int [] powerPickUp = new int[indexArr.length];
        int [] resultArr = new int[numEncrypted.length];
        int count = 0;
        for (int i : numEncrypted) {
            int last;
            int finalMod = 1;
            int result ;

            last = Math.floorMod(i, n);
            powerPickUp[0] = last;

            int k=1;
            for (int j = 1; j < binary.length(); j++) {
                last = Math.floorMod((int) Math.pow(last, 2), n);
                if (j == indexArr[k]) {
                    powerPickUp[k] = last;
                    k++;
                }
            }

            for (int a : powerPickUp)
                finalMod = finalMod * a;

            result = Math.floorMod(finalMod, n);
            resultArr[count] = result;
            count++;
        }

        return resultArr;
    }

//    public static boolean isPrime(int a) {
//        if (a < 2) return false;
//        for (int i = 2; i < Math.sqrt(a) + 1; i++) {
//            if (a % i == 0) return false;
//        }
//        return true;
//    }

//    public static int relativePrimeChecker(int z, int e) {
//        return (e == 0) ? z : relativePrimeChecker(e, z % e);
//    }

//    public static void test() {
//
//        // pick random p, q
//        int p = 1, q = 1;
////        while (!isPrime(p)) {
////            p = (int) (Math.random() * 50);
////        }
////        while (!isPrime(q)) {
////            q = (int) (Math.random() * 50);
////        }
//
//        // compute n, z
//        int n = p * q, z = (p - 1) * (q - 1);
//        int zCopy = z;
//        int e = 2;
//
//        // check if e is relative prime with z
//        while (relativePrimeChecker(z, e) != 1) e = (int) (Math.random() * z) + 1;
//
//        System.out.println("p:" + p + " q:" + q + " n:" + n + " z:" + z + " e:" + e);
//        System.out.printf("%5s   |%5s     |%5s     |%5s", "Dvd", "Dvs", "Q", "R");
//        System.out.println();
//        int c, count = 0;
//        int[] Quotient = new int[0];
//
////        int p=5, q=13, e=11;
////        int n = p * q, z = (p - 1) * (q - 1);
////        int zCopy = z;
//
//        // GCD finder and total number of Quotient
//        while (e != 0) {
//
//            c = z;
//            z = e;
//            e = c % e;
//            count++;
//
//            int[] arr = new int[Quotient.length + 1];
//            arr[Quotient.length] = c/z;
//            System.arraycopy(Quotient, 0, arr, 0, Quotient.length);
//            Quotient = arr;
//
//            System.out.printf("%5d   |%5d     |%5d     |%5d", c, z, c / z, e);
//            System.out.println();
//
//        }
//
//        int [] P = new int[count + 1];
//        P[0] = 0; P[1] = 1;
//
//        int x;
//        for (int i=2; i<P.length; i++) {
//            x = P[i-2] - Quotient[i-2]*P[i-1];
//            P[i] = Math.floorMod(x, zCopy);
//        }
//
//        System.out.println();
//        int index = 0;
//        for (int j : P) {
//            System.out.println("p" + index +"=" + j);
//            index++;
//        }
//
//        int d = P[P.length - 1];
//        System.out.println(d);
//
//        String binary ="";
//        while (d != 0) {
//            binary += d % 2;
//            d = d / 2;
//        }
//
//        System.out.println(binary);
//        int [] indexArr = new int[0];
//        for (int i=0; i<binary.length(); i++) {
//
//            if (binary.charAt(i) == '1') {
//                int [] arr = new int[indexArr.length + 1];
//                arr[indexArr.length] = i;
//                System.arraycopy(indexArr, 0, arr, 0, indexArr.length);
//                indexArr = arr;
//            }
//        }
//
//        // 36^35
//        // 35 --> binary  110001  -----> 2^0 + 2^1 + 2^5 ----->36^2^0 mod
//        // last result^2 (mod n)
//        // 36^2^0 mod n 36^2 ---> result ^2 36^2^5
//        // 0 1 5 ---> 3 result -->arr --->
//
//        for (int i : indexArr)
//            System.out.println(i + " ");
//
//        int [] powerPickUp = new int[indexArr.length];
//        for (int i : numEncrypted) {
//            int last=1, finalMod = 1, result=1 ;
//            last = Math.floorMod(i, n);
//            powerPickUp[0] = last;
//            int k=1;
//            for (int j = 1; j < binary.length(); j++) {
//                last = Math.floorMod((int) Math.pow(last, 2), n);
//                if (j == indexArr[k]) {
//                    powerPickUp[k] = last;
//                    k++;
//                }
//            }
//
//            for (int a : powerPickUp)
//                finalMod = finalMod * a;
//
//            result = Math.floorMod(finalMod, n);
//            System.out.println( "final mod result: " + result);
//
//        }
//    }
}
