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
     * Show customer function and return customer choice
     * 
     * @return int
     */
    public static int showMenuCustomer() {
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

    /**
     * show salesman function and return salesman choice
     * 
     * @return int
     */
    public static int showMenuSalesman() {
        /**
         * TODO:
         * [x] display salesman function list
         * [x] get salesman choice
         * [x] check salesman choice
         * [x] return salesman choice if valid
         */
        System.out.println("1. Tạo hóa đơn.");
        System.out.println("2. Tra cứu thông tin người dùng.");
        System.out.println("3. Kết ca.");
        System.out.println("0. Thoát.");

        int salesmanChoice;
        do {
            System.out.print("Lựa chọn: ");
            salesmanChoice = Integer.parseInt(sc.nextLine());
        } while (salesmanChoice < 0 || salesmanChoice > 3);
        return salesmanChoice;
    }

}