/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoinguyen.mathutil.test.core;

import com.khoinguyen.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author kazaf
 */
//câu lệnh này là của junit báo hiệu phải loop qua cặp data báo hiệu rằng input cặp data nhồi vào các hàm
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {

    //ta sẽ trả về mảng hai chiều gồm nhiều cặp expected | input
    @Parameterized.Parameters //JUNIT ngầm chạy loop qua từng dòng của mảng để lấy ra được cặp data input 
    //expected 

    public static Object[][] initData() {
        return new Integer[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {7, 720},
//            {6, 720}
        };
    }
    /*
    giả sửa loop qua được từng dòng của mảng thì ta vẫn cần gán value của mảng vào từng dòng tương ứng 
    vào biến input expected để new feed cho các hàm 
     */

    @Parameterized.Parameter(value = 0) //là map với mảng data
    public int n; //biên map với value cột 0 của mảng

    @Parameterized.Parameter(value = 1)
    public long expected; //kiểu long vì giá trị trả về của getF là long

    @Test
    public void testGetFactorialGivenRightArgumentReturnWell() {
        Assert.assertEquals(expected, MathUtil.getFactorial(n));
    }
    /*
    Unit test framework thường có:
    - Nhóm hàm assertX()để so sánh expected
    - Nhóm hàm để bắt ngoại lệ, nếu kiểm soát nó là màu xanh
    - Tách data và câu lệnh test hàm ra riêng biệt - DDT
    - Chạy song song các testcase
    - Gài ràng buộc giữa các testcase
    */
    
    /*
    Linux Tovalds: 
    CI: Đảm bảo chất lượng code của 1 team, không riêng cá nhận nào
    Vì code của dự án là do sự đóng góp của nhiều team memmber, 1 dự án có nhiều dev cùng code
    Mỗi devv phải đảm bảo code của mình đều ngon  --> phải màu xanh --> code trên server phải xanh cho tất cả
    CI là kĩ thuật gom code lên server phải đảm bảo xanh cho tất cả khi gom: Intergration 
    Việc gom này diễn ra rất nhiều lần do code kéo dài thời gian và n người cùng làm cho nên việc kiểm tra màu xanh
    cho tất cả phải làm liên tục --> tích hợp liên tục xuất hiện 
    Tiến trình kiểm tra toàn dự án phải màu xanh khi dev nào đó chỉnh sửa code, mỗi lần ai sửa update code
    trên server thì màu xanh cho tất cả, khi code trên server bị thay đổi 
    
    - Muốn làm CI cần:
        + Source code của anh em 
        + Server chứa code để gom code
        + Unit test cho toàn dự án để cho xanh đỏ
        + Kích hoạt quy trình chạy unit test khi có ai sửa code trên server
        + Phải notify được xanh đỏ tới team member khi có vấn đề 
        + Tự động việc làm ở trên không cần chạy bằng cơm --> ta cấu hình server và những thứ liên quan để
        tạo quy trình xanh đỏ 1 cách tự động
        --> Rẽ nhánh đi làm CI/CD: không cần code app, code cho quy trình xanh đỏ, deploy lên khai báo
        hành động từ code --> chất lượng code app lên server 
    - CI Tool: là phần mềm lắng nghe server code xem có ai cập nhật code không nếu có sẽ kích hoạt bộ unit test
    kiểm tra xanh đỏ 
    XANH --> Không vấn đề
    ĐỎ --> tự động gửi mail chửi dev vừa đưa code lên 
    Lặp lại liên tục được gọi là continuous intergration
    
    Ngày xưa gihub làm server chứa code để cho tool khác lo: Jenkin, Circle CI
    Ngày nay github tích hợp tool lắng nghe vào trong github gọi là github action
    Tất cả CI Tool dưa trên nguyên tắc 
        - Nó có 1 tập lệnh cấu hình sẵn, mình lựa chọn thao tác muốn dùng 
        - Ví dụ yêu cầu github báo cho tool biết ai vừa sửa code
        - Kích hoạt bộ lệnh gom code về server nào đó
        - Gọi người kiến biên dịch code đã gom và chạy test và build file .jar .war
        - Lệnh qua ui click option
        - Gõ lệnh trong tập kịch bản có đuôi mở rộng là .YML .YAML
    
    * Chơi CI với github action phải tạ file yaml trên project để cứ ai sửa code thì file này đc chạy
    - Vấn đề là java project có nhiều style bố trí code khác nhau (code giồng nhau thư mục bố trí code khác nhau)
        + ANT
        + MAVEN
        + GRADLE
    
    - File YML cũng phải bố trí khác nhau nếu khác cấu trúc code 
    */
}
