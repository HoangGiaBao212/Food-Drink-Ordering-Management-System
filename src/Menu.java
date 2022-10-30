import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static Account login() {
        System.out.println("LOGIN (Y/N)");
        char choose = sc.nextLine().charAt(0);
        choose = Character.toLowerCase(choose);
        if(choose == 'y')
        {
            // Call method login in AccountList
            // return account
        }
        System.out.println(" Bạn đang dùng tài khoản khách");
        return null; // @TODO new person
    }
}