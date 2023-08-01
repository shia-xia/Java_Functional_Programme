package per.xia.FP_方法引用;

import org.junit.Test;
import per.xia.entity.Author;
import per.xia.utils.AuthorUtils;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Description 方法的引用: 1. 方法体中只有一个方法的调用
 *                        2. 所有的参数（如果有）都按照顺序传入引用的方法中 --> 就是隐藏了方法的参数
 *              方法引用的基本格式： 类名或者对象名::方法名
 *
 * @Author XJY
 * @Date 2023/8/2 00:06
 **/
public class AbbreviateMethod {

    //类的静态方法引用
    @Test
    public void abbMethodTest01() {
        AuthorUtils.getAuthors().stream()
                .distinct()
                // 其实无论多长的方法体，原则上都可以被抽取到类中单独构成方法，
                // 然后在lambda表达式中，形成方法的引用
                .flatMap(author -> author.getBooks().stream())
                // 调用了某个类的静态方法，
                // 并且我们把要重写的抽象方法中所有的参数都按照顺序传入，
                // 就可以引用类的静态方法--->类名::方法名
                .distinct()
                //.forEach(book -> System.out.println(book))
                .forEach(System.out::println);
    }

    //对象方法引用
    @Test
    public void abbMethodTest02() {
        StringBuilder sb = new StringBuilder();
        AuthorUtils.getAuthors().stream()
                .map(author -> author.getName())
                //.forEach(name->sb.append(name));
                .forEach(sb::append);
        System.out.println(sb);
    }

    //构造器方法引用
    @Test
    public void abbMethodTest03() {
        AuthorUtils.getAuthors().stream()
                .distinct()
                .map(Author::getName)

                //注意：此处出现构造器方法，且符合引用条件
                //.map(name -> new StringBuilder(name))
                .map(StringBuilder::new)

                .map(sb -> sb.append("-xia").toString())
                .forEach(System.out::println);
    }

    // 引用类的实例方法
    @Test
    public void abbMethodTest04() {

        //String subAuthorName = subAuthorName("夏璟源", new UseString() {
        //    @Override
        //    public String use(String str, int start, int length) {
        //        return str.substring(start, length);
        //    }
        //});

        //String subAuthorName = subAuthorName("夏璟源", (str, start, length) -> str.substring(start, length));

        String subAuthorName = subAuthorName("夏璟源", String::substring);
        System.out.println(subAuthorName);
    }

    //定义使用
    public static String subAuthorName(String str, UseString useString) {
        int start = 0;
        int length = 1;
        return useString.use(str, start, length);
    }
}