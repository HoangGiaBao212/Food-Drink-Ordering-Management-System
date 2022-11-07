
public class MenuContent {
    private static void showMenuLogin() {
        System.out.println("Bạn có muốn đăng nhập không ?");
        System.out.println("1. Có");
        System.out.println("0. Không");
    }
    public static void showMenuPermissionCustomer() {
        System.out.println("1. Hiện danh sách sản phẩm.");
        System.out.println("2. Thông tin người dùng.");
        System.out.println("0. Thoát.");
    }

    public static void showMenuPermissionSalesman() {
        System.out.println("1. Tạo hóa đơn.");
        System.out.println("2. Tra cứu thông tin người dùng.");
        System.out.println("3. Kết ca.");
        System.out.println("0. Thoát.");
    }

    public static void showMenuPermissionManager() {
        System.out.println("1. Quản lý Sản phẩm");
        System.out.println("2. Quản lý Nhân viên");
        System.out.println("3. Quản lý Người dùng");
        System.out.println("0. Thoát");
    }
}