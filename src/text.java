
import java.util.Scanner;

public class text {
    static Scanner sc = new Scanner(System.in);

    public static void showMenuLogin() {
        System.out.println("--------------- LOGIN --------------");
        System.out.println("|  Bạn có muốn đăng nhập không ?    |");
        System.out.println("|       1. Có                       |");
        System.out.println("|       0. Không                    |");
        System.out.println("------------------------------------");
    }

    public static void showMenuCustomer() {
        System.out.println("----------------------PERMISSION CUSTOMER ---------------");
        System.out.println("1. Hiện danh sách sản phẩm.");
        System.out.println("2. Thông tin người dùng.");
        System.out.println("0. Thoát.");
        System.out.print("Choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.println(" này mình gọi hàm để show danh sách sp và giỏ hàng");
                System.out.println("|     1. Chọn sản phẩm                                   |");
                System.out.println("|     2. Chỉnh sửa giỏ hàng                              |");
                System.out.println("|     3. Thanh toán                                      |");
                System.out.println("|     0. Thoát                                           |");
                System.out.print("Choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("trong này cho chọn id sản phẩm và nhập số lượng");
                    }
                    case 2 -> {
                        System.out.println(" đoạn này mình show giỏ hàng ra");
                        
                        System.out.println("|             1/ Xóa sản phẩm                            |");
                        System.out.println("|             2/ Chỉnh sửa số lượng                      |");
                        System.out.println("|             0/ Quay lại                                |");
                        System.out.print("Choice: ");
                        choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1 -> {
                                System.out.println(" đoạn này mình cho nhập id cần xóa sau đó gọi hàm thực hiện xóa");
                            }
                            case 2 -> {
                                System.out.println(" đoạn này mình cho nhập id cần chỉnh sửa số lượng sau đó gọi hàm thực hiện");
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println(" đoạn này mình show giỏ hàng ra và số tiền phải thanh toán");
                    }
                }
            }

            case 2 -> {
                System.out.println("|     1. Xem lịch sử                                     |");
                System.out.println("|     2. Thay đổi thông tin                              |");
                System.out.println("|     0. Thoát                                           |");
            }
            case 0 -> System.out.println("Ket thuc!");
            default -> System.out.println("Nhap lai!");
        }
    }

    public static void main(String[] args) {
        showMenuLogin();
        showMenuCustomer();
    }
}
