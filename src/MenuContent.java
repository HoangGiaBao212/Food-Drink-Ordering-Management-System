import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MenuContent {
	static Scanner sc = new Scanner(System.in);

	private MenuContent() {

	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		try {
			String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public static void showMenuCustomer() {
		int choice = -1;
		while (choice != 0) {
			System.out.println("----------------------PERMISSION CUSTOMER ---------------");
			System.out.println("1. Hiện danh sách sản phẩm.");
			System.out.println("2. Thông tin người dùng.");
			System.out.println("0. Thoát.");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
				case 1 -> {
					System.out.println("| 1. Hiện danh sách sản phẩm.                            |");
					System.out.println("|     1. Chọn sản phẩm                                   |");
					System.out.println("|     2. Chỉnh sửa giỏ hàng                              |");
					System.out.println("|     3. Thanh toán                                      |");
					System.out.println("|     0. Thoát                                           |");
				}

				case 2 -> {
					System.out.println("| 2. Thông tin người dùng.                               |");
					System.out.println("|     1. Xem lịch sử                                     |");
					System.out.println("|     2. Thay đổi thông tin                              |");
					System.out.println("|     0. Thoát                                           |");
				}
				case 0 -> System.out.println("Ket thuc!");
				default -> System.out.print("Nhap lai!");
			}
		}
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

	public static void showMenuPermissionCustomer() {
		System.out.println(" ---------------------------- [Menu Customer] ---------------------------");
		System.out.println("|  1. Hiện danh sách sản phẩm.                                           |");
		System.out.println("|  2. Thông tin người dùng.                                              |");
		System.out.println("|  0. Thoát.                                                             |");
		System.out.println(" ------------------------------------------------------------------------");
		// System.out.println("----------------------PERMISSION CUSTOMER
		// ---------------");
		// System.out.println("| 1. Hiện danh sách sản phẩm. |");
		// System.out.println("| 1. Chọn sản phẩm |");
		// System.out.println("| 2. Chỉnh sửa giỏ hàng |");
		// System.out.println("| 1, Chọn sản phẩm muôn sửa |");
		// System.out.println("| 1/ Xóa sản phẩm |");
		// System.out.println("| 2/ Chỉnh sửa số lượng |");
		// System.out.println("| 0/ Quay lại |");
		// System.out.println("| 3. Thanh toán |");
		// System.out.println("| 1, Thanh toán bằng tiền mặt |");
		// System.out.println(" 2, Thanh toán bằng thẻ |");
		// System.out.println("| 1/ Bạn có muôn sử dụng điểm không ? |");
		// System.out.println("| Y. Có |");
		// System.out.println("| N. Không |");
		// System.out.println("| 2/ Thoát |");
		// System.out.println("| 4. Thoát |");
		// System.out.println("| |");
		// System.out.println("| 2. Thông tin người dùng. |");
		// System.out.println("| 1. Xem lịch sử |");
		// System.out.println("| 2. Thay đổi thông tin |");
		// System.out.println("| 1/ Đổi mật khẩu |");
		// System.out.println("| 0/ Thoát |");
		// System.out.println("| 3. Thoát |");
		// System.out.println("| |");
		// System.out.println("| 0. Thoát. |");
		// System.out.println("----------------------------------------------------------");
	}

	// public static void showMenuPermissionCustomer() {
	// System.out.println("----------------------PERMISSION CUSTOMER
	// ---------------");
	// System.out.println("| 1. Hiện danh sách sản phẩm. |");
	// System.out.println("| 1. Chọn sản phẩm |");
	// System.out.println("| 2. Chỉnh sửa giỏ hàng |");
	// System.out.println("| 1, Chọn sản phẩm muôn sửa |");
	// System.out.println("| 1/ Xóa sản phẩm |");
	// System.out.println("| 2/ Chỉnh sửa số lượng |");
	// System.out.println("| 0/ Quay lại |");
	// System.out.println("| 3. Thanh toán |");
	// System.out.println("| 1, Thanh toán bằng tiền mặt |");
	// System.out.println(" 2, Thanh toán bằng thẻ |");
	// System.out.println("| 1/ Bạn có muôn sử dụng điểm không ? |");
	// System.out.println("| Y. Có |");
	// System.out.println("| N. Không |");
	// System.out.println("| 2/ Thoát |");
	// System.out.println("| 4. Thoát |");
	// System.out.println("| |");
	// System.out.println("| 2. Thông tin người dùng. |");
	// System.out.println("| 1. Xem lịch sử |");
	// System.out.println("| 2. Thay đổi thông tin |");
	// System.out.println("| 1/ Đổi mật khẩu |");
	// System.out.println("| 0/ Thoát |");
	// System.out.println("| 3. Thoát |");
	// System.out.println("| |");
	// System.out.println("| 0. Thoát. |");
	// System.out.println("----------------------------------------------------------");
	// }

	// public static void showMenuPermissionSalesman() {
	// System.out.println("-----------------PERMISSION SALESMAN
	// ----------------------");
	// System.out.println("| 1. Tạo hóa đơn. |");
	// System.out.println("| 1. Chọn sản phẩm |");
	// System.out.println("| 2. Chỉnh sửa giỏ hàng |");
	// System.out.println("| 1, Chọn sản phẩm muôn sửa |");
	// System.out.println("| 1/ Xóa sản phẩm |");
	// System.out.println("| 2/ Chỉnh sửa số lượng |");
	// System.out.println("| 0/ Quay lại |");
	// System.out.println("| 3. Thanh toán |");
	// System.out.println("| 1, Thanh toán bằng tiền mặt |");
	// System.out.println(" 2, Thanh toán bằng thẻ |");
	// System.out.println("| 1/ Bạn có muôn sử dụng điểm không ? |");
	// System.out.println("| Y. Có |");
	// System.out.println("| N. Không |");
	// System.out.println("| 2/ Thoát |");
	// System.out.println("| 4. Thoát |");
	// System.out.println("| |");
	// System.out.println("| 2. Tra cứu thông tin người dùng. |");
	// System.out.println("| 1. Xem danh sách người dùng |");
	// System.out.println("| 2. Chọn người dùng |");
	// System.out.println("| 1, Xem lịch sử |");
	// System.out.println("| 2, Thay đổi thông tin |");
	// System.out.println("| 1/ Đổi mật khẩu |");
	// System.out.println("| 0/ Thoát |");
	// System.out.println("| 3, Thoát |");
	// System.out.println("| 3. Thoát |");
	// System.out.println("| |");
	// System.out.println("| 3. Kết ca. |");
	// System.out.println("| |");
	// System.out.println("|0. Thoát. |");
	// System.out.println("----------------------------------------------------------");
	// }

	// public static void showMenuPermissionManager() {
	// System.out.println("-------------------PERMISSION MANAGER
	// ----------------------");
	// System.out.println("| 1. Quản lý Sản phẩm. |");
	// System.out.println("| 1. Xem danh sách sản phẩm. |");
	// System.out.println("| 2. Thêm sản phẩm. |");
	// System.out.println("| 3. Tạo sản phẩm mới. |");
	// System.out.println("| 4. Xóa sản phẩm. |");
	// System.out.println("| 0. Quay lại. |");
	// System.out.println("| |");
	// System.out.println("| 2. Quản lý Nhân viên. |");
	// System.out.println("| 1. Xem danh sách nhân viên. |");
	// System.out.println("| 2. Thêm nhân viên. |");
	// System.out.println("| 3. Xóa nhân viên. |");
	// System.out.println("| 0. Quay lại. |");
	// System.out.println("| |");
	// System.out.println("| 3. Quản lý Người dùng. |");
	// System.out.println("| 1. Xem danh sách người dùng. |");
	// System.out.println("| 2. Thêm người dùng. |");
	// System.out.println("| 3. Xóa người dùng. |");
	// System.out.println("| 4. Quay lại. |");
	// System.out.println("| |");
	// System.out.println("|0. Thoát. |");
	// System.out.println("-------------------------------------------------------------");
	// }
	// }
	public static void showMenuPermissionManager() {
		System.out.println("-------------------PERMISSION MANAGER ----------------------");
		System.out.println("| 1. Quản lý Sản phẩm.                                      |");
		System.out.println("|       1. Xem danh sách sản phẩm.                          |");
		System.out.println("|       2. Thêm sản phẩm.                                   |");
		System.out.println("|       3. Tạo sản phẩm mới.                                |");
		System.out.println("|       4. Xóa sản phẩm.                                    |");
		System.out.println("|       0. Quay lại.                                        |");
		System.out.println("|                                                           |");
		System.out.println("| 2. Quản lý Nhân viên.                                     |");
		System.out.println("|       1. Xem danh sách nhân viên.                         |");
		System.out.println("|       2. Thêm nhân viên.                                  |");
		System.out.println("|       3. Xóa nhân viên.                                   |");
		System.out.println("|       0. Quay lại.                                        |");
		System.out.println("|                                                           |");
		System.out.println("| 3. Quản lý Người dùng.                                    |");
		System.out.println("|       1. Xem danh sách người dùng.                        |");
		System.out.println("|       2. Thêm người dùng.                                 |");
		System.out.println("|       3. Xóa người dùng.                                  |");
		System.out.println("|       4. Quay lại.                                        |");
		System.out.println("|                                                           |");
		System.out.println("|0. Thoát.                                                  |");
		System.out.println("-------------------------------------------------------------");
	}

	public static void showMenuPermissionCustomerProduct(ProductList productList) {
		productList.display();
		System.out.println("1. Chọn sản phẩm.");
		System.out.println("2. Chỉnh sửa giỏ hàng");
		System.out.println("3. Thanh toán");
		System.out.println("0. Quay lại");
	}

	public static void showMenuPermissionCustomerInfo(Account account) {
		account.display();
		System.out.println("1. Xem lịch sử");
		System.out.println("2. Thay đổi thông tin");
		System.out.println("3. Thanh toán");
		System.out.println("0. Quay lại");
	}
}
