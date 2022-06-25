/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoinguyen.mathutil.core;

/**
 *
 * @author kazaf
 */
public class MathUtil {
    //trong class này cung cấp ra ngoài nhiều hàm xử lí toán học
    //clone class Math của JDK
    //hàm thư viện sai chung cho ai đó mà không lưu lại trạng thái --> hàm static
    
    //hàm giai thừa!!!
    //không có giai thừa âm
    //0! = 1! = 1
    //giai thừa hàm đồ thị dốc, tăng nhanh về giá trị 
    //20 giai thừa 18 con số 0, vừa kịp đủ cho kiểu long. 21 giai thừa tràn kiểu long
    //tính giai thừa từ 0 - 20
    
    public static long getFactorial(int n) {
        if(n < 0 || n > 20) 
            throw new IllegalArgumentException("Invalid argurment n must be between 0..20");
        
        if(n == 0 || n == 1)
            return 1;
        
        long product = 1;
        for (int i = 1; i <= n; i++)
            product *= i;
        return product;
    }
}
