package per.xia.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 用于数据测试的对象类型，
 *              *** 自定义的数据类型，需要重写equals方法，否则会出现错误 ***
 * @Author XJY
 * @Date 2023/7/31 10:34
 **/
@Data
//如果是我们自定义的数据类型，那么equals方法只比较对象的地址，而不是对象的内容，所以我们需要重写equals方法
@EqualsAndHashCode // 该注解生成equals和hashCode方法和下列注释中的方法等价
public class BO {
    public String name;
    public Integer age;

    //@Override
    //public boolean equals(Object o) {
    //    if (this == o) return true;
    //    if (o == null || getClass() != o.getClass()) return false;
    //    BO bo = (BO) o;
    //    return Objects.equals(name, bo.name) && Objects.equals(age, bo.age);
    //}
    //
    //@Override
    //public int hashCode() {
    //    return Objects.hash(name, age);
    //}
}
