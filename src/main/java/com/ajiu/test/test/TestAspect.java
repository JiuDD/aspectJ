package com.ajiu.test.test;

import com.ajiu.test.business.Calculate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 测试静态代理
 * @author: JiuDongDong
 * date: 2018/9/11.
 */
public class TestAspect {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Calculate calculate = applicationContext.getBean("calculateImpl", Calculate.class);
        // 前置通知
        double add = calculate.add(1, 32);
        System.out.println(add);


        // 异常通知
        double divide = calculate.divide(6, 0);
        System.out.println(divide);
    }
}
