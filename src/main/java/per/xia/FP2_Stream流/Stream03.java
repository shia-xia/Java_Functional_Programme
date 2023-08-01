package per.xia.FP2_Stream流;

import org.junit.Test;
import per.xia.utils.AuthorUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description Stream流的终结操作01：
 *                              1. forEach(Consumer c)：内部迭代
 *                              2. count()：返回流中元素的总个数
 *                              3. max/min(Comparator c)：返回流中最大值/最小值
 *                              4. collect:返回流中的数据，返回值为一个集合: 通过Collectors类的静态方法
 *                                              1. stream --> list
 *                                              2. stream --> set
 *                                              3. stream --> map
 * @Author XJY
 * @Date 2023/7/31 16:14
 **/
public class Stream03 {
    @Test
    public void countTest(){
        //获得一共有多少本不同的书
        long bookNUm = AuthorUtils.getAuthors().stream()
                .distinct()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(bookNUm);
    }

    @Test
    public void maxTest(){
        // 返回所有书籍中，评分最高的分数
        Optional<Integer> maxScore = AuthorUtils.getAuthors().stream()
                .distinct()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .map(book -> book.getScore())
                .max((o1, o2) -> o1 - o2);

        System.out.println(maxScore.get());
    }

    @Test
    public void collectLIstTest(){
        // 把所有作者的名字，放入一个list集合        (stream-->list)
        List<String> authorList = AuthorUtils.getAuthors().stream()
                .distinct()
                .map(author -> author.getName())
                .collect(Collectors.toList());
        System.out.println(authorList);
    }

    @Test
    public void collectSetTest(){
        // 将所有的书名，放入一个set集合 (stream-->set)
        Set<String> bookNameSet = AuthorUtils.getAuthors().stream()
                .distinct()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .map(book -> book.getName())
                .collect(Collectors.toSet());
        System.out.println(bookNameSet);
    }

    @Test
    public void collectMapTest(){
        // 获取一个Map集合，map的key为作者名，value为作者的书名组成的数组 (stream-->map)
        Map<String, List<String>> bookMap = AuthorUtils.getAuthors().stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks().stream().map(book->book.getName()).collect(Collectors.toList())));
        System.out.println(bookMap);
    }
}
