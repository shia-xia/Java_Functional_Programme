package per.xia.FP3_Optional;

import org.junit.Test;
import per.xia.entity.Author;
import per.xia.entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


/**
 * @Description optional类封装对象，能够在对象为null的情况下避免空指针异常:
 *                              1。 optional的创建:of()、ofNullable()、empty(),最长用的是ofNullable()
 *                              2。 optional的获取：get()\orElseGet()\orElseThrow(),推荐使用orElseGet()
 * @Author XJY
 * @Date 2023/7/31 22:02
 **/
public class Optional {

    //创建 Optional.ofNullable()
    public static java.util.Optional<Author> getAuthors(){
        Author author = new Author(1L, "小米姑娘", 18, "123234234234", null);
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));
        author.setBooks(books1);
        // 推荐创建方法
        return java.util.Optional.ofNullable(author);

        // ofNullable() 方法可以封装一个空集
        //return Optional.ofNullable(null);
    }

    //判断 ifPresent()
    @Test
    public void optionalTest01(){
        // 安全消费
        getAuthors().ifPresent(author -> System.out.println(author.getName()));
    }

    //消费 orElseGet()
    @Test
    public void optionalTest02(){
        // get() 非安全获取，不推荐
        //Author author = getAuthors().get();
        //System.out.println(author);

        //orElseGet() 会默认提供一个制定的对象，在null时候，用该对象替换null来防止空指针
        Author author1 = getAuthors().orElseGet(() -> new Author());
        System.out.println(author1.getName());

        //orElseThrow() 如果获取到空指针会抛出指定的异常
        Author author;
        try {
            author = getAuthors().orElseThrow(() -> new RuntimeException("null异常"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(author.getName());
    }

    //过滤filter
    @Test
    public void optionalFilterTest(){
        java.util.Optional<Author> author1 = getAuthors().filter(author -> author.getName().length() > 2);
        author1.ifPresent(author -> System.out.println(author.getName()));
    }

    //转化map
    @Test
    public void optionalMapTest(){
        getAuthors().map(author -> author.getBooks())       //optional 对象的map
                .ifPresent(books -> books.stream()
                                        .map(book -> book.getName())    //stream流的map
                                        .forEach(name-> System.out.println(name)));
    }
}
