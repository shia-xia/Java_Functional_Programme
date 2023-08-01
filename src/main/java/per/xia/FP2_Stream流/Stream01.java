package per.xia.FP2_Stream流;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description     使用stream的优势：1。惰性求值，在没有调用终结方法之前，中间操作不会执行
 *                                  2。流是一次性的，不会重复调用
 *                                  3。使用流计算数据并不会影响原数据（除非乱操作！）
 *                  不同数据类型，stream流的创建方式：
 * @Author XJY
 * @Date 2023/7/31 09:58
 **/
public class Stream01 {
    // 1。通过单列集合创建
    @Test
    public void collectionCreate() {
        List<String> list = new ArrayList<>();
        list.add("小米姑娘");
        list.add("小米姑娘2");
        list.add("小米姑娘3");
        Stream<String> stream = list.stream();
        stream.distinct()
                .filter(s -> s.contains("3"))
                .forEach(s -> System.out.println(s));

        //Stream<String> parallelStream = list.parallelStream();
    }

    // 2。通过数组创建
    @Test
    public void arrayCreate() {
        Integer[] arr = {1,2,3,2,5,7};
        // 1.调用Arrays中的静态方法stream
        //Stream<Integer> arrStream = Arrays.stream(arr);

        // 2.调用Stream中的静态方法of
        Stream<Integer> stream = Stream.of(arr);
        stream.distinct()
                .filter(num -> num >2 && num <7)
                .forEach(num -> System.out.println(num));
    }

    //3。set集合创建
    @Test
    public void setCreate() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"小米姑娘");
        map.put(2,"小米姑娘2");
        map.put(2,"小米姑娘4");
        map.put(3,"小米姑娘3");
        //set多列集合中，需要将多列转化为单列来创建stream流
        map.entrySet().stream()
                .distinct() // 去重是根据key去重的
                .filter(entry -> entry.getKey() > 1)
                .forEach(entry -> System.out.println(entry.getValue()));
    }
}

