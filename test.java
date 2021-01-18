import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1, s2 = "";
        s1 = sc.nextLine();

        for (int i=s1.length() - 1; i>=0; i--) {
            s2 += s1.charAt(i);
        }

        if (s2.equals(s1)) System.out.println("okay");
        else System.out.println("not okay");

    }
}
