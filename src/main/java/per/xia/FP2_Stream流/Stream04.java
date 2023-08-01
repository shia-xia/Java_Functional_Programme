package per.xia.FP2_Stream流;

import org.junit.Test;
import per.xia.entity.Author;
import per.xia.utils.AuthorUtils;

import java.util.Optional;

/**
 * @Description stream流中，终结操作---查找与匹配
 *                                   Match
 *                                   1. allMatch(Predicate p)：检查是否匹配所有元素
 *                                   2. anyMatch(Predicate p)：检查是否至少匹配一个元素
 *                                   3. noneMatch(Predicate p)：检查是否没有匹配所有元素
 *                                   Find
 *                                   4. findFirst()：返回第一个元素
 *                                   5. findAny()：返回当前流中的任意元素
 * @Author XJY
 * @Date 2023/7/31 17:33
 **/
public class Stream04 {

    //match:匹配
    @Test
    public void matchTest(){
        //1. anyMatch : 检查是否至少匹配一个元素
        boolean age = AuthorUtils.getAuthors().stream()
                //判断是否有大于等于20岁的作者
                .anyMatch(author -> author.getAge() >= 20);
        System.out.println(age);
        //2. allMatch : 检查是否匹配所有元素
        boolean allAge = AuthorUtils.getAuthors().stream()
                //判断是否所有的作者都大于等于20岁
                .allMatch(author -> author.getAge() >= 20);
        System.out.println(allAge);
        //3. noneMatch : 检查是否没有匹配所有元素
        boolean noneAge = AuthorUtils.getAuthors().stream()
                //判断是否所有的作者不都大于100岁
                .noneMatch(author -> author.getAge() >= 100);
        System.out.println(noneAge);
    }

    //find:查找
    @Test
    public void findTest(){
        Optional<Integer> any = AuthorUtils.getAuthors().stream()
                .distinct()
                .map(author -> author.getAge())
                .filter(age -> age > 28)
                //随机返回一个元素，用的不多
                .findAny();
        //ifPresent()方法，如果有值则执行Consumer接口的实现代码，并且该值会作为参数传给Consumer对象
        any.ifPresent(System.out::println);

        Optional<Author> author = AuthorUtils.getAuthors().stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                //返回第一个元素
                .findFirst();
        author.ifPresent(author1 -> System.out.println(author1.getName()));
    }

}
