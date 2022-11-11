import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MenuContent {
	static Scanner sc = new Scanner(System.in);

	private MenuContent() {

	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void notification(String str) {
		MenuContent.clearScreen();
		System.out.println(str);

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		MenuContent.clearScreen();
	}

	public static void showMenuLogin() {
		System.out.println(" -------------------------------- [Login] -------------------------------");
		System.out.println("|  Bạn có muốn đăng nhập không ?                                         |");
		System.out.println("|      1. Có                                                             |");
		System.out.println("|      0. Không                                                          |");
		System.out.println(" ------------------------------------------------------------------------");
	}

	public static void showMenuLoginFailed() {
		System.out.println(" ---------------------------- [Login Failed] ----------------------------");
		System.out.println("|  Đăng nhập thất bại, đăng nhập lại ?                                   |");
		System.out.println("|      1. Có                                                             |");
		System.out.println("|      0. Không                                                          |");
		System.out.println(" ------------------------------------------------------------------------");
	}

	public static void showMenuReadDataFailed() {
		System.out.println(" -------------------------- [Read Data Failed] --------------------------");
		System.out.println("|  Có lỗi trong quá trình đọc dữ liệu!. Tạo dữ liệu mới?                 |");
		System.out.println("|      1. Có                                                             |");
		System.out.println("|      0. Kết thúc chương trình                                          |");
		System.out.println(" ------------------------------------------------------------------------");
	}

	public static void showMenuCustomer() {
		System.out.println(" ---------------------------- [Menu Customer] ---------------------------");
		System.out.println("|  1. Hiện danh sách sản phẩm.                                           |");
		System.out.println("|  2. Thông tin người dùng.                                              |");
		System.out.println("|  0. Thoát.                                                             |");
		System.out.println(" ------------------------------------------------------------------------");
	}

	public static void showMenuSalesman() {
		System.out.println("-------------------PERMISSION MANAGER -----------------------");
		System.out.println("| 1. Tạo hóa đơn.                                           |");
		System.out.println("| 2. Tra cứu thông tin người dùng.                          |");
		System.out.println("| 3. Kết ca.                                                |");
		System.out.println("| 0. Thoát.                                                 |");
		System.out.println("-------------------------------------------------------------");
	}

	public static void showMenuManager() {
		System.out.println("-------------------PERMISSION MANAGER -----------------------");
		System.out.println("| 1. Quản lý Sản phẩm.                                      |");
		System.out.println("| 2. Quản lý Nhân viên.                                     |");
		System.out.println("| 3. Quản lý Người dùng.                                    |");
		System.out.println("| 0. Thoát.                                                 |");
		System.out.println("-------------------------------------------------------------");
	}

	public static void showMenuPermissionCustomerProduct(ProductList productList) {
		System.out.println(" ----------------------------- [Product Menu] ---------------------------");
		productList.display();
		System.out.println(" ------------------------------------------------------------------------");
		System.out.println("|  1. Chọn sản phẩm.                                                     |");
		System.out.println("|  2. Chỉnh sửa giỏ hàng.                                                |");
		System.out.println("|  3. Thanh toán.                                                        |");
		System.out.println("|  0. Quay lại.                                                          |");
		System.out.println(" ------------------------------------------------------------------------");
	}

	public static void showMenuPermissionCustomerProduct(Bill bill) {
		System.out.println(" ------------------------------- [Bill Menu] ----------------------------");
		bill.display();
		System.out.println(" ------------------------------------------------------------------------");
		System.out.println("|  1. Chỉnh sửa số lượng.                                                |");
		System.out.println("|  2. Xóa sản phẩm                                                       |");
		System.out.println("|  0. Quay lại.                                                          |");
		System.out.println(" ------------------------------------------------------------------------");
	}

	public static void showMenuPermissionCustomerInfo(Account account) {
		System.out.println(" ----------------------------- [Account Menu] ---------------------------");
		account.display();
		System.out.println(" ------------------------------------------------------------------------");
		System.out.println("|  1. Xem lịch sử mua hàng.                                              |");
		System.out.println("|  2. Thay đổi thông tin.                                                |");
		System.out.println("|  0. Quay lại.                                                          |");
		System.out.println(" ------------------------------------------------------------------------");
	}

}