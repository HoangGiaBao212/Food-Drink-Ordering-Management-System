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
     * Display customer function
     * 
     * @return int
     */
    public static int menuCustomer() {
        /**
         * TODO:
         * [x] display customer function list
         * [x] get customer choice
         * [x] check customer choice
         * [x] return customer choice if valid
         */
        System.out.println("1. Hiện danh sách sản phẩm.");
        System.out.println("2. Thông tin người dùng.");
        System.out.println("0. Thoát.");
        int customerChoice;
        do {
            System.out.print("Lựa chọn: ");
            customerChoice = Integer.parseInt(sc.nextLine());
        } while (customerChoice < 0 || customerChoice > 2);
        return customerChoice;
    }
}