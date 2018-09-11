package com.ajiu.test.business;

import org.springframework.stereotype.Component;

/**
 * description: 业务代码，将来会在加、减方法的执行前后织入增强代码
 * @author: JiuDongDong
 * date: 2018/9/11.
 */
@Component
public class CalculateImpl implements Calculate {
    // 加
    @Override
    public double add(int a, int b) {
        return a + b;
    }

    // 减
    @Override
    public double minus(int a, int b) {
        return a - b;
    }

    // 除
    @Override
    public double divide(int a, int b) {
        return a / b;
    }
}
