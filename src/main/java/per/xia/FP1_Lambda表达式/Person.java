package per.xia.FP1_Lambda表达式;

/**
 * @Description 定义一个接口用以函数式编程测试
 * @Author XJY
 * @Date 2023/7/30 21:41
 **/
public interface Person {
    void say(String name,int age);
    //作为函数式编程的接口只能有一个抽象方法，否则会报错
    //public void sayHello();
    //接口中的默认方法作用：1。实现现有接口的向下兼容
    //                  2。默认的实现一些方法，不需要子类去实现
    default void sayHello() {
        System.out.println("Hello world!");
    }
}
