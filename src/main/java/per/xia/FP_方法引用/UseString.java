package per.xia.FP_方法引用;

/**
 * @Description 定义了一个函数式接口:用来映射成员的关系
 * @Author XJY
 * @Date 2023/8/2 00:47
 **/
@FunctionalInterface
public interface UseString {
    String use(String str,int start,int length);
}
