package com.es2.login;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; // I use scanner because it's command line.


public class Main {
    public void run() throws FileNotFoundException {
        Scanner scan = new Scanner (new File("the\\dir\\myFile.extension"));
        Scanner keyboard = new Scanner (System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine(); // looks at selected file in scan

        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user

        if (inpUser.equals(user) && inpPass.equals(pass)) {
            System.out.print("your login message");
        } else {
            System.out.print("your error message");
        }
    }
}