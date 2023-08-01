package per.xia.FP_FunctionalInterface;

import org.junit.Test;
import per.xia.entity.Author;
import per.xia.entity.Book;
import per.xia.utils.AuthorUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Author XJY
 * @Date 2023/8/1 17:22
 **/
public class FunctionalInterfaceImp {

    @Test
    public void testFPInterface(){
         AuthorUtils.getAuthors().stream()
                .distinct()
                .flatMap(new Function<Author, Stream<Book>>() {     //函数型接口
                    @Override
                    public Stream<Book> apply(Author author) {
                        return author.getBooks().stream();
                    }
                })
                .filter(new Predicate<Book>() {             //判断型接口
                    @Override
                    public boolean test(Book book) {
                        return book.getName().length() > 3;
                    }
                })
                .distinct()
                .forEach(new Consumer<Book>() {         //消费型接口
                    @Override
                    public void accept(Book book) {
                        System.out.println(book.getName());
                    }
                });
    }

    //Predicate的默认方法：and(),or(),negate()。主要是用于自定义函数式接口的时候使用！
    @Test
    public void predicateFuncTest(){
        AuthorUtils.getAuthors().stream()
                .distinct()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()>20;
                    }
                }.and(author -> author.getAge()<30))
                .forEach(author -> System.out.println(author.getName()));
    }
}
