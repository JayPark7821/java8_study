package me.jaypark.java8.annotation;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
public class App {

    public static void main(@Chicken("양념") String[] args) throws @Chicken("양념") RuntimeException {
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c ->  {
            System.out.println("c.value() = " + c.value());
        });

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println("c.value() = " + c.value());
        });

        List<@Chicken("양념")  String> names = Arrays.asList("jay");
    }

    static class FeelsLikeChicken<@Chicken("양념") T>{

        public static <@Chicken("양념") C> void print(@Chicken("양념") C c) {
            System.out.println("c = " + c);
        }

    }

}
