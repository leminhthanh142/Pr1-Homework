package Tutorials12;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class tut12 {

    static String[] loadVocab() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Tutorials12/vocab.bin"));
        String[] vocab = (String[]) ois.readObject();
        ois.close();
        return vocab;
    }

    static ArrayList<String> loadLines() throws Exception {
        ArrayList<String> lines = new ArrayList<>();
        File f = new File("src/Tutorials12/vectors.txt");
        Scanner input = new Scanner(f);

        // add each line as a string to Arraylist lines
        while (input.hasNextLine()) {
            lines.add(input.nextLine());
        }
        input.close();
        return lines;
    }

    static int[] toIntVector(String line) {
        String[] strArr = line.split(" ");
        int[] index = new int[strArr.length];
        for (int i=0; i<strArr.length; i++) {
            index[i] = Integer.parseInt(strArr[i]);
        }
        return index;
    }

    static String toSentence(String[] vocab, int[] vector) {
        String result = "";

        /* combine each elements in vocab array with its index
         is the value of the element in vector array with the same index
        */
        for (int i : vector) {
           result += vocab[i] + " ";
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String[] vocab = loadVocab();
        System.out.println("---------------\n" +
                "Vocabulary has been loaded!\n" +
                "---------------\n");

        // print out the vocab
        for (int i=0; i<vocab.length; i++) {
            System.out.println("Vocab[" + i + "] = " + vocab[i]);

        }

        ArrayList<String> lines = loadLines();
        System.out.println("---------------\n" +
                "Loaded lines:\n" +
                "---------------\n");

        // print each line in Arraylist lines
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();

        // pass each line as a string into toIntVector() and invoke toSentence() at the same time
        for (String line : lines) {
            System.out.println(toSentence(vocab, toIntVector(line)));
        }
    }
}