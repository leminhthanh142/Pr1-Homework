package Tutorials03;

public class tut0301 {
    public static void main(String[] args) {

        // declare the amount of money
        String price1 = "427384 VND";
        String price2 = "$3.5";
        String price3 = "10.2 EUR";

        // declare total money
        double totalPrice, totalCost;

        // covert number in string into real number
        int price_1_VND = Integer.parseInt(price1.substring(0, 6));
        double price_2 = Double.parseDouble(price2.substring(1, 4));
        double price_3 = Double.parseDouble(price3.substring(0, 4));

        // change USD and EUR into VND
        double price_2_VND = price_2 * 23500;
        double price_3_VND = price_3 * 27100;

        // calculate total price and convert it into USD
        totalPrice = (price_1_VND + price_2_VND + price_3_VND) / 23500;


        // this way works too, but it rounds the number ---> 33.45
        //totalCost = Double.parseDouble(new DecimalFormat("##.##").format(totalPrice));


        // format the total cost
        totalCost = Math.floor(totalPrice * 100) / 100;
        System.out.println(totalCost);
    }
}
