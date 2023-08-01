package per.xia.FP_FunctionalInterface;

/**
 * @Description 函数式接口：只有一个抽象方法的接口
 *              常见的函数式接口：
 *                      1。 Consumer   消费消费接口
 *                      2。 Supplier   生产型接口
 *                      3。 Function   计算转换型接口
 *                      4。 Predicate  判断型接口
 *              jdk自定义了很多常用的函数型接口给我们使用，可以查看package java.util.function;里面提供的接口，来选择性使用！
 * @Author XJY
 * @Date 2023/8/1 17:08
 **/
@FunctionalInterface        // jdk默认注解，用于校验该接口是否是函数式的。如果不是会报错
public interface FunctionalInterface01 {
    void run();
}
