package per.xia.FP_高级用法;

import org.junit.Test;
import per.xia.entity.Author;
import per.xia.utils.AuthorUtils;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * @Description 使用更多的stream流方法，来减少stream的操作步骤：
 *                  例如：map对基本数据类型的操作
 * @Author XJY
 * @Date 2023/8/2 01:12
 **/
public class AdvanceUsage {
    @Test
    public void advanceUsageTest01(){
        //1. 常规方法：会导致大量装箱、拆箱的过程
        AuthorUtils.getAuthors().stream()
                .map(Author::getAge)
                .map(age->age+10)
                .filter(age->age>25)
                .map(age->age+10)
                .forEach(System.out::println);

        AuthorUtils.getAuthors().stream()
                //此处，直接将stream转化成基本数据类型的流，减少了后续
                //操作中，频繁的装箱、拆箱过程
                .mapToInt(Author::getAge)
                .map(age->age+10)
                .filter(age->age>25)
                .map(age->age+16)
                .forEach(System.out::println);
    }

    /*
        并行流-->Stream.parallel()：将流中数据分拆到不同的线程中来执行
     */
    public  static Stream<Integer> createStream(){
        //  创建单行流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //  创建并行流
        integerStream.parallel();
        return integerStream;
    }
    @Test
    public void streamParallelTest(){
        OptionalInt reduce = createStream()
                //peek方法是stream流的一个调试方法，
                // 参数是一个消费类接口
                .peek(integer -> System.out.println(integer+":::"+Thread.currentThread().getName()))
                .mapToInt(num -> num)
                .reduce((result, num) -> result + num);
        reduce.ifPresent(System.out::println);
    }
}
