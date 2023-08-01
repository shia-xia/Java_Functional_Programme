package per.xia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//用于后期的去重使用
public class Author implements Comparable<Author> {
    //id
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //简介
    private String intro;;
    //作品
    private List<Book> books;

    //自然排序法，是一个类型默认的排序方式，如果使用中出现了自定义的方法
    // 那么，我们可以重写Comparator接口，来实现自定义排序规则
    @Override
    public int compareTo(Author o) {
        //两个比较对象相减的值
        return o.getAge() - this.getAge();
    }
}