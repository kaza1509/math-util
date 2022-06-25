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
            {6, 720},
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
    */
}
