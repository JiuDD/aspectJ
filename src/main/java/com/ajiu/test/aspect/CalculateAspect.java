package com.ajiu.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * description: 切面程序，记录日志
 *      // @Before：前置通知，在方法执行前进行通知
 *      // @After： 后置通知，在方法执行后进行通知，不管方法是正常结束还是抛异常
 *      // @AfterReturning： 返回通知，只有在方法正常执行完毕，返回执行结果后进行通知
 *      // @AfterThrowing： 异常通知，只有在方法抛出异常时才通知
 *      // @Order: 假如同一个切点要织入多个切面程序，则会按order大小顺序，0的优先级最高
 * @author: JiuDongDong
 * date: 2018/9/11.
 */
@Aspect// 表示这个类是切面程序
@Component// 让Spring去管理这个切面程序，自动为目标类创建代理
public class CalculateAspect {

    // 切入点表达式：
    // 第1个 * 代表任意类型的返回值和任意类型的方法修饰符如final、static
    // 第2个 * 代表CalculateImpl类里的所有方法
    // 方法名要写全限定名，方法里的“..”表示任意个参数
    @Before("execution(* com.ajiu.test.business.CalculateImpl.*(..))")
    @Order(2)
    public void before() {
        System.out.println("方法之前执行");
    }

    // 第1个 * 代表不限定返回值类型的public方法
    // 方法的形参里加入JoinPoint对象，可以在运行时，自动地将切入点的信息带过来
    @After("execution(public * com.ajiu.test.business.CalculateImpl.add(..))")
    @Order(1)
    public void after(JoinPoint joinPoint) {
        // 不管方法是否正常执行结束（抛异常）都执行
        System.out.println("方法之后执行");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("当前方法名称：" + methodName);
    }

    // 切点表达式的含义：方法的修饰符（如public static final）不限，任意方法名称，任意参数
    // 如何获取方法执行的返回值：切点表达式加入returning，告诉Spring我要获取返回值
    @Order(0)
    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("方法返回执行结果之后执行");
        // 获取方法执行的返回值
        System.out.println("方法执行结果：" + result);
    }

    // 异常通知，切点表达式里声明异常，让Spring把异常信息传递进来
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("方法抛出异常之后执行");
        System.out.println(e.getMessage());
    }

}
