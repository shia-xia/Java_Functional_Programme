package per.xia.FP2_Stream流;

import org.junit.Test;
import per.xia.utils.AuthorUtils;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * @Description reduce的使用：对流中的数据按照你指定的计算方式计算出一个结果：
 *                                                  1。 reduce两个参数的重载形式
 *                                                  2。 reduce一个参数的重载形式：将流的第一个元素作为初始值
 * @Author XJY
 * @Date 2023/7/31 18:07
 **/
public class Stream05 {
    // 两个参数的重载形式:reduce(T identity, BinaryOperator)

    // 1。reduce的使用：求累计的和，返回值是传入初始值的类型
    @Test
    public void reduceTest01(){
        Integer sumAge = AuthorUtils.getAuthors().stream()
                .distinct()
                .map(author -> author.getAge())
                //传入初始化值，和遍历元素的处理方法，获得最终值
                .reduce(0, (sum, age) -> sum + age);
        System.out.println(sumAge);
    }

    // 同样是求累计的和，但是这里的初始值是通过流的第一个元素获得的，返回值是Optional类型
    @Test
    public void reduceTes04(){
        Optional<Integer> sumAge = AuthorUtils.getAuthors().stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce((sum, age) -> sum + age);
        sumAge.ifPresent(System.out::println);
    }

    //2。 reduce使用：求最大值
    @Test
    public void reduceTest02(){
        Integer maxAge = AuthorUtils.getAuthors().stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, age) -> result > age ? result : age);
        System.out.println(maxAge);
    }

    //3。 reduce使用：求最小值
    @Test
    public void reduce03() {
        Integer minAge = AuthorUtils.getAuthors().stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, age) -> result > age ? age : result);
        System.out.println(minAge);
    }


}
