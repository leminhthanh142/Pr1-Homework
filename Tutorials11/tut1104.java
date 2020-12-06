package Tutorials11;

import java.io.*;
import java.util.ArrayList;

public class tut1104 {
    public static void main(String[] args) throws Exception {

        // load data.bin file
        FileInputStream fis = new FileInputStream("./src/Tutorials11/data.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Object> list = new ArrayList<>();
        list.add(ois.readObject());

        // cast list to array of object
        Object[] obj = list.toArray();

        for (Object i:obj) {
            System.out.println(i);
        }
    }
}
