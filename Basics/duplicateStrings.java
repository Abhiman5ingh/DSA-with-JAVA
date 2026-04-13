package Basics;
import java.util.Scanner;
public class duplicateStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = sc.nextLine().toLowerCase();

        int[] c = new int[26];
        String newstr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) { // check only letters
                if (c[ch - 'a'] == 0) {
                    newstr += ch;
                    c[ch - 'a']++;
                }
            } else {
                newstr += ch; // keep spaces or punctuation as is
            }
        }

        System.out.println("String without duplicate letters: " + newstr);
        sc.close();
    }
}