package Tutorials02;
public class tut0202 {
    public static void main(String[] args) {
        String pokedex = "This Pokemon  is Pikachu.It is the electric mouse.  " +
                "It lives in forests  with others." +
                "It has  small electric sacs on  both its cheeks.";
        String replaceString = pokedex.replace("  ", " ");
        String replaceString2 = replaceString.replace(". ", ".");
        String replaceString3 = replaceString2.replace(".", ". ");
        System.out.println(replaceString3);
    }
}
