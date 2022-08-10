package me.jaypark.java8.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER) //  TYPE_USE -> TYPE_PARAMETER를 포함해서 TYPE을 선언하는 모든곳에 사용하고싶을때
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class) // 컨테이너가 가지고있는 리탠션과, 타겟정보는 컨테이너에 담을 어노테이션과 같거나 더 넓어야 한다.
public @interface Chicken {
    String value();
}
