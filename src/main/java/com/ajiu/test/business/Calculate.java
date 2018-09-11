package com.ajiu.test.business;

/**
 * description: 业务代码，将来会在加、减方法的执行前后织入增强代码
 * @author: JiuDongDong
 * date: 2018/9/11.
 */
public interface Calculate {
    // 加
    double add(int a, int b);
    // 减
    double minus(int a, int b);
    // 除
    double divide(int a, int b);
}
