package per.xia.FP2_Stream流;

import org.junit.Test;
import per.xia.utils.AuthorUtils;

import java.util.Arrays;

/**
 * @Description stream常用的中间操作
 *         // filter()：过滤流中的某些元素,如果返回值为true，则该元素继续留在流中，否则就不包含在新的流中
 *         // distinct()：去重，通过流中元素的 hashCode() 和 equals() 去除重复元素,如果是自定义类型，需要重写对象的hashCode()和equals()方法
 *
 *         // map(Function f)：映射，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
 *         // flatMap(Function f)：将流中的每个值都换成另一个流，然后把所有流连接成一个流
 *
 *         // sorted()：自然排序，流中元素需实现 Comparable 接口
 *         // sorted(Comparator com)：定制排序，自定义 Comparator 接口的实现类
 *
 *         // limit()：截断流，使其元素不超过给定数量
 *         // skip()：跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 * @Author XJY
 * @Date 2023/7/31 10:23
 **/
public class Stream02 {

    @Test
    public void filterTest() {
        // filter()：过滤流中的某些元素,如果返回值为true，则该元素继续留在流中，否则就不包含在新的流中
        AuthorUtils.getAuthors().stream()
                .distinct()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    @Test
    public void mapTest() {
        // map(Function f)：映射，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        AuthorUtils.getAuthors().stream()
                .distinct()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .forEach(age -> System.out.println(age));
    }
    @Test
    public void distinctTest() {
        // distinct()：去重，通过流中元素的 hashCode() 和 equals() 去除重复元素,如果是自定义类型，需要重写对象的hashCode()和equals()方法

    }

    @Test
    public void sortedTest(){
       // sorted()：自然排序，流中元素需实现 Comparable 接口
        AuthorUtils.getAuthors().stream()
                //默认的年龄排序
                .sorted()
                .forEach(author -> System.out.println(author));

       // sorted(Comparator com)：定制排序，自定义 Comparator 接口的实现类
        AuthorUtils.getAuthors().stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())//在使用comparable接口时，通过两数相减的值来判断
                .forEach(author -> System.out.println(author));
    }

    @Test
    public void limitTest(){
        // limit()：截断流，使其元素不超过给定数量
        AuthorUtils.getAuthors().stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getAge()));
    }

    @Test
    public void skipTest(){
        // skip()：跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        AuthorUtils.getAuthors().stream()
                .distinct()
                .sorted((o1,o2)->o2.getAge() - o1.getAge())
                .skip(1)        //此处跳过了流的第一个数据
                .map(author -> author.getName())
                .forEach(name -> System.out.println(name));
    }

    @Test
    public void flatMapTest(){
        // flatMap(Function f)：将流中的每个值都换成另一个流，然后把所有流连接成一个流
        //1. 将流中的每个值都换成另一个流
        AuthorUtils.getAuthors().stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }
    @Test
    public void flatMapTest02(){
        // flatMap(Function f)：将流中的每个值都换成另一个流，然后把所有流连接成一个流
        AuthorUtils.getAuthors().stream()
                .distinct() //对作者去重
                .flatMap(author -> author.getBooks().stream())
                .distinct() //对书籍去重
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct() //对分类去重
                .forEach(bookCategory-> System.out.println(bookCategory));
    }
}
