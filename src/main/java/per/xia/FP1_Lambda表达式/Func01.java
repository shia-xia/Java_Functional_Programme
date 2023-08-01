package per.xia.FP1_Lambda表达式;

/**
 * @Description 函数式编程存在的意义： 更清晰的体现了用什么数据干什么方法的意义
 *                              1。 代码更简洁易读
 *                              2。 便于并行化处理
 *                              3。 便于进行参数传递
 *                              4。 便于进行Lambda表达式的使用
 *                              5。 便于进行方法引用
 *                              6。 便于进行类型推断
 *                              7。 便于进行构造方法引用
 *               函数式编程的条件：1。接口中只有一个抽象方法，便于推断
 *               函数式编程的特点：只关心参数列表（要处理的数据）和方法实现的过程，不关注谁的方法，叫什么名字（类名和函数名）
 * @ClassName Func01
 * @Author XJY
 * @Date 2023/7/30 21:26
 **/

public class Func01 {
    //public static void main(String[] args) {
    //    /*
    //       面向对象的写法，代码冗余，可读性差
    //     */
    //    new Thread(new Runnable() {
    //        @Override
    //        public void run() {
    //            System.out.println("Hello world!");
    //        }
    //    }).start();
    //}

    /*
       函数式编程的条件：1。接口中只有一个抽象方法，便于推断
     */
    //public static void main(String[] args) {
    //new Thread(() -> System.out.println("我是函数式调用!")).start();
    //}


    public static void main(String[] args) {
        doWork("小米姑娘",20,(name,age) -> System.out.println(name+"是函数"+age+"式调用!"));
    }
    public static void doWork(String name, int age, Person person) {
        person.say(name,age);
        sayHello(person);  //opt+cmd+m 提取方法
    }

    private static void sayHello(Person person) {
        person.sayHello(); // 接口中的默认方法
    }
}
