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
		System.out.println("┌─────────────────────────────────── [Notification] ─────────────────────────────────┐");
		System.out.println(String.format("│  %-82s│", str));
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		MenuContent.clearScreen();
	}

	public static void showMenuLogin() {
		System.out.println("┌────────────────────────────────────── [Login] ─────────────────────────────────────┐");
		System.out.println("│  Bạn có muốn đăng nhập không ?                                                     │");
		System.out.println("│      1. Có                                                                         │");
		System.out.println("│      0. Không                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuLoginFailed() {
		System.out.println("┌─────────────────────────────────── [Login Failed] ─────────────────────────────────┐");
		System.out.println("│  Đăng nhập thất bại !                                                              │");
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  Bạn có muốn đăng nhập không ?                                                     │");
		System.out.println("│      1. Có                                                                         │");
		System.out.println("│      0. Không                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuReadDataFailed() {
		System.out.println("┌───────────────────────────────── [Read Data Failed] ───────────────────────────────┐");
		System.out.println("│  Khởi tạo dữ liệu thất bại !                                                       │");
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  Bạn có muốn xóa toàn bộ dữ liệu và khởi tạo dữ liệu mới không ?                   │");
		System.out.println("│      1. Có                                                                         │");
		System.out.println("│      0. Không                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuCustomer() {
		System.out.println("┌────────────────────────────────── [Menu Customer] ─────────────────────────────────┐");
		System.out.println("│  1. Hiện danh sách sản phẩm.                                                       │");
		System.out.println("│  2. Thông tin người dùng.                                                          │");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");

	}

	public static void showMenuSalesman() {
		System.out.println("┌────────────────────────────────── [Menu Salesman] ─────────────────────────────────┐");
		System.out.println("│  1. Tạo hóa đơn.                                                                   │");
		System.out.println("│  2. Danh sách khách hàng.                                                          │");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuCustomerListInfo(AccountList accountList, String mode) {
		System.out.println("┌───────────────────────────────── [Infor Customer] ─────────────────────────────────┐");
		System.out.println("├────┬────────────────────┬──────────────────────────────────┬────────────┬──────────┤");
		System.out
				.println(String.format("│%-4s│%-20s│%-34s│%-12s│%-10s│", "ID", "Name", "Địa Chỉ", "Ngày sinh", "Điểm"));
		System.out.println("├────┼────────────────────┼──────────────────────────────────┼────────────┼──────────┤");
		accountList.display("Customer");
		System.out.println("├────┴────────────────────┴──────────────────────────────────┴────────────┴──────────┤");
		if (mode.equals("feature")) {
			System.out
					.println("│  1. Tìm kiếm theo ID.                                                              │");
			System.out
					.println("│  2. Tìm kiếm theo tên.                                                             │");
		}
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuCustomerListInfo(Account account) {
		System.out.println("┌───────────────────────────────── [Infor Customer] ─────────────────────────────────┐");
		account.display();
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuSalesmanListInfo() {
		System.out.println("┌───────────────────────────────── [Infor Salesman] ─────────────────────────────────┐");
		System.out.println("├─────┬─────────────┬─────────────────────────────────┬────────────────────┬─────────┤");
		System.out.println(
				String.format("│%-4s│%-20s│%-34s│%-12s│%-10s│", "ID", "Name", "Địa Chỉ", "Ngày sinh", "Lương"));
		System.out.println("├─────┼─────────────┼─────────────────────────────────┼────────────────────┼─────────┤");
	}

	public static void showMenuManager() {
		System.out.println("┌─────────────────────────────────── [Menu Manager] ─────────────────────────────────┐");
		System.out.println("│  1. Quản lý Sản phẩm.                                                              │");
		System.out.println("│  2. Quản lý Nhân viên.                                                             │");
		System.out.println("│  3. Quản lý Người dùng.                                                            │");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuManagerProduct(ProductList productList) {
		System.out.println("┌─────────────────────────────── [Menu Manager Product] ─────────────────────────────┐");
		productList.display();
		System.out.println("├────┴───────────────┴───────┴──────────┴────────────┴────────────┴─────┴────────────┤");
		System.out.println("│  1. Tạo sản phẩm mới.                                                              │");
		System.out.println("│  2. Sửa sản phẩm.                                                                  │");
		System.out.println("│  3. Xóa sản phẩm.                                                                  │");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuManagerSalesman() {
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("├─────────────────────────────────── [Menu Manager] ─────────────────────────────────┤");
		System.out.println("│  1. Thêm tài khoản người bán.                                                      │");
		System.out.println("│  2. Sửa thông tin người bán.                                                       │");
		System.out.println("│  3. Xóa người bán.                                                                 │");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuManagerCustomer() {
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("├─────────────────────────────────── [Menu Manager] ─────────────────────────────────┤");
		System.out.println("│  1. Thêm tài khoản khách hàng.                                                     │");
		System.out.println("│  2. Sửa thông tin khách hàng.                                                      │");
		System.out.println("│  3. Xóa khách hàng.                                                                │");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	// ─ │ ┌ ┐ ┘ └ ┬ ┴ ┤ ├ ┼
	public static void showMenuCustomerProduct(ProductList productList, Bill bill) {
		System.out.println("┌────────────────────────────────── [Product Menu] ──────────────────────────────────┐");
		productList.display(bill);
		System.out.println("├────┴───────────────┴───────┴──────────┴────────────┴────────────┴─────┴────────────┤");
		System.out.println("│  1. Chọn sản phẩm.                                                                 │");
		System.out.println("│  2. Chỉnh sửa giỏ hàng.                                                            │");
		System.out.println("│  3. Thanh toán.                                                                    │");
		System.out.println("│  0. Quay lại.                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuCustomerProduct(Bill bill, ProductList productList, AccountList accountList) {
		System.out.println("┌──────────────────────────────────── [Bill Menu] ───────────────────────────────────┐");
		bill.display(productList, accountList);
		System.out.println("├──────────────────────────────────────────────┴─────────────────────────────────────┤");
		System.out.println("│  1. Chỉnh sửa số lượng.                                                            │");
		System.out.println("│  2. Xóa sản phẩm.                                                                  │");
		System.out.println("│  0. Quay lại.                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuCustomerPurchaseHistory(AccountList accountList, ProductList productList,
			BillList billList, Account account) {
		System.out.println("┌────────────────────────────── [Purchase History Menu] ─────────────────────────────┐");
		billList.display(accountList, productList, account);
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  1. Chi tiết Bill                                                                  │");
		System.out.println("│  0. Quay lại.                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuCustomerPurchaseHistory(ProductList productList, Bill bill, AccountList accountList) {
		System.out.println("┌────────────────────────────── [Purchase History Menu] ─────────────────────────────┐");
		bill.display(productList, accountList);
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  0. Quay lại.                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuCustomerInfo(Account account) {
		System.out.println("┌────────────────────────────────── [Account Menu] ──────────────────────────────────┐");
		account.display();
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  1. Xem lịch sử mua hàng.                                                          │");
		System.out.println("│  2. Thay đổi thông tin.                                                            │");
		System.out.println("│  0. Quay lại.                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuSearchCustomer() {
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("├───────────────────────────────── [Search Customer] ────────────────────────────────┤");
		System.out.println("│  1. Tìm kiếm theo ID.                                                              │");
		System.out.println("│  2. Tìm kiếm theo tên.                                                             │");
		System.out.println("│  0. Thoát                                                                          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public static void showMenuSearchIdFailed() {
		System.out.println("┌───────────────────────────────── [Search Id Failed] ───────────────────────────────┐");
		System.out.println("│  Không tìm thấy id !                                                               │");
		System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  Bạn có muốn tiếp tục mà không có id không ?                                       │");
		System.out.println("│      1. Có                                                                         │");
		System.out.println("│      0. Không                                                                      │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────┘");
	}
}