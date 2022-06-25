/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoinguyen.mathutil.main;

import com.khoinguyen.mathutil.core.MathUtil;

/**
 *
 * @author kazaf
 */
public class Main {
    public static void main(String[] args){
        //Thử nghiệm hàm tính giai thừa coi đúng thiết kế hay không
        //ta phải đưa ra các tình huống sử dụng hàm trong thực tế
        //ví dụ: -5, 0, 20, 21 coi tính được không --> testcase --> 1 tình huống được đưa vào sử dụng
        // giả lập hành vi sài của ai đó --> testcase
        //testcase là 1 tình huống sử dụng app mà nó bao gồm data đầu vào cụ thể, output đầu ra ứng với xử lí
        //của hàm --> dùng đầu vào để xử lí 
        //so sánh xem kết quả có đúng như kì vọng hay không (actual value) ứng với hàm expected ở trên
        //xem kết quả có như kì vọng hay không
        long expected = 120;//kì vọng 120 nếu tính 5!
        int n = 5;
        long actual = MathUtil.getFactorial(n);
        System.out.println("5! = "+expected+" expected");
        System.out.println("5! = "+actual+" actual");
        
    }
}
