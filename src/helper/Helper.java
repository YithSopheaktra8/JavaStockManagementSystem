package helper;

import java.util.Scanner;

public class Helper {
    public static void pressEnter(){
        Scanner input = new Scanner(System.in);
        System.out.println("=========>> Press Enter to Continue <<=========");
        input.nextLine();
    }
}
