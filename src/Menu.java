import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static Account login() {
        System.out.println("LOGIN (Y/N)");
        char choose = sc.nextLine().charAt(0);
        choose = Character.toLowerCase(choose);
        if (choose == 'y') {
            // Call method login in AccountList
            // return account
        }
        System.out.println(" Bạn đang dùng tài khoản khách");
        return null; // @TODO new person
    }

    /**
     * 
     * @return int
     */
    public static int menuCustomer() {
        /**
         * TODO:
         * [x] display customer function list
         * [x] get customer choice
         * [x] return customer choice
         */
        System.out.println("1. Hiện danh sách sản phẩm.");
        System.out.println("2. Thông tin người dùng.");
        System.out.println("0. Thoát.");
        int choice = -1;
        while (choice < 0 || choice > 2) {
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
        }
        return choice;
    }
}