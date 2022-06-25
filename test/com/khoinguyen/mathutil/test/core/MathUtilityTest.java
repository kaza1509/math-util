/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoinguyen.mathutil.test.core;

import com.khoinguyen.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author kazaf
 */
public class MathUtilityTest {
    //đây là class sẽ sử dụng các hàm junit
    //để kiểm thử kiểm tra code chính - tính giai thừa bên core.mathutil
    
    //có quy tắc đặt tên hàm kiểm thử nhưng thường sẽ là nói lên m
    //đầu vào phải đúng
    //@Test Junit phối hợp với JVM --> phía hậu trường là public static void main()
    //Có nhiều @Test ứng với nhiều case khác nhau 
    @Test
    public void testGetFactorialGivenRightArgumentReturnWell() {
        int n = 0; //test thử tình huống tử tế đầu vào
        long expected = 1;
        //long actual = ;//gọi hàm cần test bên core
        long actual = MathUtil.getFactorial(n);
        
        //so sánh expected với actual dùng xanh xanh đỏ đỏ framework
        Assert.assertEquals(expected, actual);
        //Hàm giúp so sánh hai giá trị nào đó có giống nhau không nếu giống thảy ra màu xanh 
        //code ngon ít nhất cho case đang test, nếu thảy màu đỏ nếu expected và actual không giống nhau 
        //Hàm í đã bị sai expected # actual --> sai 
        
        //gộp case
        Assert.assertEquals(1, MathUtil.getFactorial(1)); //muốn 1! == 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); //muốn 2! == 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); //muốn 3! == 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); //muốn 4! == 24
        Assert.assertEquals(120, MathUtil.getFactorial(5)); //muốn 5! == 120
        Assert.assertEquals(720, MathUtil.getFactorial(6)); //muốn 6! == 720
    }
    
    //hàm getF() thiết kế hai tình huống
    //1 đưa data tử tế 0...20 -> tình huống đúng n!
    //2. đưa data vào cà chớn, thiết kế của hàm đẩy ra ngoại lệ 
    //ta kì vọng ngoại lệ xuất hiện -> rất mong ngoại lệ xuất hiện với n cà chớn này 
    
    //input -5 
    //expexted: IllegalArgumentExeption xuất hiện 
    //assertEqual() không thể dùng để so sánh hai ngoại lệ
    //equals() là bằng nhau hay không trên value
    
    @Test(expected = IllegalArgumentException.class)//khi hàm test được chạy kì ném về ngoại lệ numberFormatException
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5);
        //hàm @Test hay hàm getF() chạy ném về ngoại lệ numberFormatException 
    }
    
    //cách khác để bắt ngoại lệ xuất hiện
    //xài lambda
    //hàm sẽ ném về ngoại lệ nếu nhận vào 21
    //tôi cần thấy màu xanh khi ném ra ngoại lệ
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsExceptionTryCatch() {
        //xem hàm có ném về ngoại lệ hay không khi n cà chớn 
        //chủ động kiểm soát ngoại lệ
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bắt try catch thì xanh nhưng ko chắc ngoại lệ có xuất hiện hay không
            //--> phải có đoạn code xem ngoại lệ xuất hiện hay không IllegalArgumentEcception
            Assert.assertEquals("Invalid argurment n must be between 0..20", e.getMessage());
            
        }
    }
    
    /*
    DDT - DATA DRIVEN TESTING là kĩ thuật kiểm thử hướng data chuẩn bị sẵn là kĩ thuật tách lời gọi hàm cần
    test ra một chỗ - data đầu vào expected ra chỗ khác - nhồi/nap feed đám data này vào lời gọi hàm giúp"
    nhìn code test dễ ràng, trong sáng, tách biệt chuẩn bị data ra 1 chỗ --> tập chung vào việc build bộ data
    test không bị trộn lẫn với đám data này vì việc kiểm thử đòi hỏi tính chặt chẽ, cẩn thận, code test cũng
    phải đẹp, chuẩn, bảo trì 
    
    - Trong giới công nghiệp, các công ty phần mềm, tập data test thì để trong file exel trong hàng cột, trong
    text file dùng tab để phân tách giá trị dang CSV
    - Nhúng trực tiếp trong code nhưng tách so với unit test
    - Để trong table chưa toàn bộ data để test không phải database chính
    - Kĩ thuật DDT trong sáng dễ hiểu, dễ đánh giá code thiếu case hay không, tình huống dùng hàm đã đủ đại
    diện hay chưa 
    - Chốt deal - DDT chẳng qua tách cặp data ra 1 chỗ và đặt cho chúng biến tương ứng rồi đưa vào hàm
    - DDT là tham số mới kiểu tham số hóa của unit test - PARAMETERZIED - Tham số hóa data test
    
    Input(n)        Expected(n!)
    0               1           [0]
    1               1           [1]
    2               2           [2]
    3               6           [3]
    4               24          [4]
    5               120         [5]
    6               720         [6]
    
    */
}
