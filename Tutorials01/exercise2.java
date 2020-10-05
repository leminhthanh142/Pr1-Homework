package Tutorials01;



// import Scanner library to take the input from the keyboard;

public class exercise2 {
    public static int nthPower(int[] array, int n) {
        return n >= (array.length)? -1 : (int) Math.pow(array[n], n);
    }
    public static void main (String[] args) {
        System.out.println(nthPower(new int[]{1, 2, 3}, 3));
    }
}