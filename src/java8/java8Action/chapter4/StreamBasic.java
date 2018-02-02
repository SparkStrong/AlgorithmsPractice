package java8.java8Action.chapter4;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasic {
    public static void main(String[] args) {
//        getHighCaloricDishesName(Dish.menu);

//        List<Dish> vegetarianDishes = Dish.menu.stream()
////                .filter(d -> !d.isVegetarian())  // 取反
////                .filter(Dish::isVegetarian)  // 取正
//                .filter( ((Predicate<Dish>) Dish::isVegetarian ).negate()) // 取反
//                .collect(Collectors.toList());
//        vegetarianDishes.forEach(d->System.out.println(d.getName()));

//        sumCaloricDishes(Dish.menu);

        List<Dish> dishes = new ArrayList<>();
//        sumCaloricDishes2(dishes);
//        sumCaloricDishes(dishes);

        int res = highestCaloricDishes(Dish.menu);
//        System.out.println(res);

        Stream<Integer> a = Stream.of(res);
        a.forEach(System.out::println);
    }

    public static List<String> getHighCaloricDishesName(List<Dish> dishes) {
        List<String> dishesName = Dish.menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        dishesName.forEach(System.out::println);

        return dishesName;
    }

    public static Integer sumCaloricDishes(List<Dish> dishes) {
        int sum =  dishes.stream()
                .map(Dish::getCalories)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
        return sum;
    }

    public static void sumCaloricDishes2(List<Dish> dishes) {
        Optional<Integer> sum = dishes.stream()
                .map(Dish::getCalories)
                .reduce((a, b) -> a + b);

        int res = dishes.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        if (sum.isPresent()) {
            System.out.println("sum = " + sum);
        } else {
            System.out.println("sum no exist!");
        }
    }

    public static int highestCaloricDishes(List<Dish> dishes) {
        OptionalInt highestCaloric = dishes.stream()
                .mapToInt(Dish::getCalories)
                .max();
        if (highestCaloric.isPresent()) {
            System.out.println("highestCaloric = " + highestCaloric);
        } else {
            System.out.println("highestCaloric not exist!");
        }

        return highestCaloric.orElse(-1);
    }
}