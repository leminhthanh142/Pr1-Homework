public class RSA {
    public static void main(String[] args) {
        System.out.println("p: " + pFinder());
        System.out.println("q: " + qFinder());
        System.out.println("n: " + nCalculator());
        System.out.println("z: " + zCalculator());
        System.out.println("e: " + eRandom());
        dFinder();
    }

    public static boolean isPrime (int a) {
        if (a<2) return false;
        for (int i=2; i<Math.sqrt(a) + 1; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static int pFinder () {
        int p = 1;
        while (!isPrime(p)) {
            p = (int) (Math.random() * 100);
        }
        return p;
    }

    public static int qFinder () {
        int q = 1;
        while (!isPrime(q)) {
            q = (int) (Math.random() * 100);
        }
        return q;
    }

    public static int nCalculator () {
        int p = pFinder();
        System.out.println(p);
        int q = qFinder();
        System.out.println(q);
        int n = p*q;
        return n;
    }

    public static int zCalculator () {
        int p = pFinder();
        int q = qFinder();
        int z = (p-1)*(q-1);
        return z;
    }

    public static int eRandom () {
        int e, z = zCalculator();
        int max = z, min = 1, range = max - min + 1;
        e = (int) (Math.random() * z);
        while (relativePrimeChecker(z, e) != 1) e = (int) (Math.random() * range) + min;
        return e;
    }

    public static int relativePrimeChecker(int z, int e) {
        return (e == 0)? z : relativePrimeChecker(e, z % e);
    }

    public static void dFinder () {
        int e = eRandom(), z = zCalculator(), c;
        System.out.print(e + " " + z);
        System.out.println();
        System.out.printf("%s   |%s     |%s     |%s", "Dvd", "Dvs", "Q", "R");
        System.out.println("");
        while (e != 0) {
            c = z;
            z = e;
            e = c % e;
            System.out.printf("%d   |%d     |%d     |%d", c, z, c/z, e);
            System.out.println("");
        }
    }
}
