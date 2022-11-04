# Food & Drink Ordering Management System

Nguyen Minh Tuan
Bui Hong Bao

## Login (Y/N)

    Y {
        Nhập tài khoản: root
        Nhập mật khẩu: 1234
    }

    N {
        Show ra: Bạn đang dùng tài khoản anonymous
    }

    => truy xuất id => lưu thông tin vô phiên hiện tại

## Với quyền người dùng

    1, Hiện danh sách sản phẩm
    2, Thông tin người dùng
    3, Thoát

### 1, Hiện danh sách sản phẩm

    Show sách sản phẩm (id, Tên, Giá, Mô tả)
    Show Giỏ hàng
        1, Chọn sản phẩm {
            Nhập: id, số lượng -> tự động quay lại
        }

        2, Chỉnh sửa giỏ hàng {
            Show giỏ hàng

            1, Chọn sản phẩm muốn sửa {
                1, xóa sản phẩm
                2, chỉnh sửa số lượng
                3, quay lại
            }
        }

        3, Thanh Toán {
            Show giỏ hàng
            Show số tiền phải thanh toán

            1, Thanh toán bằng tiền mặt, mời đút tiền vô :))
            2, Thanh toán bằng thẻ, mời đút thẻ vô
            1, 2 {
                Sử dụng điểm (Y/N) {
                    Y: Trừ điểm
                    N: DO NOT THING
                }

                Hiện quay mòng mòng

                Show Thanh toán thành công {
                    Mua tiếp (Y/N)
                }
            }

            3, Quay lại
        }

        4, Quay lại

### 2, Thông tin người dùng

        Show thông tin người dùng

            1, Xem lịch sử {
                Show sản phẩm đã mua
            }

            2, Thay đổi thông tin {
                1, Đổi mật khẩu
                2, quay lại
            }

            3, Quay lại

## Với quyền Salesman

    1, Tạo hóa đơn
    2, Tra cứu thông tin người dùng
    3, Kết ca

### 1, Tạo hóa đơn

        Show sách sản phẩm (id, Tên, Giá, Mô tả)
        Show Giỏ hàng

            1, Chọn sản phẩm {
                Nhập: id, số lượng -> tự động quay lại
            }

            2, Chỉnh sửa giỏ hàng {
                Show giỏ hàng
                1, Chọn sản phẩm muốn sửa {
                    1, xóa sản phẩm
                    2, chỉnh sửa số lượng
                    3, quay lại
                }
            }

            3, Thanh Toán {
                Show giỏ hàng
                Show số tiền phải thanh toán

                1, Thanh toán bằng tiền mặt
                2, Thanh toán bằng thẻ

                1, 2 {
                    Hỏi id (Y/N) {
                        Sử dụng điểm (Y/N) {
                            Y: Trừ điểm
                        }
                    }

                    Hiện quay mòng mòng

                    Show Thanh toán thành công
                    Tích điểm
                }

                3, Quay lại
            }
            4, Quay lại

### 2 Tra cứu thông tin người dùng

    1, Show danh sách người dùng
    2, Chọn người dùng {
        Show thông tin người dùng

        1, Xem lịch sử {
            Show sản phẩm đã mua
        }

        2, Thay đổi thông tin {
            1, Đổi mật khẩu
            2, quay lại
        }

        3, Quay lại
    }
    3, Quay lại

### 3, Kết ca

    -Show số tiền đã bán
    -Thoát

## Với quyền Manager

    1, Sản phẩm
    2, Nhân viên
    3, Người dùng
    4, Thoát

### 1, Sản phẩm

    1, Show danh sách sản phẩm
    2, Thêm sản phẩm
    3, Tạo sản phẩm mới
    4, Xóa sản phẩm
    5, quay lại

### 2, Nhân viên

    1, Show danh sách nhân viên
    2, Thêm nhân viên
    3, Xóa nhân viên
    4, Quay lại

### 3, Người dùng

    1, Show danh sách người dùng
    2, Thêm người dùng
    3, Xóa người dùng
    4, Quay lại

### 4, Thoát
