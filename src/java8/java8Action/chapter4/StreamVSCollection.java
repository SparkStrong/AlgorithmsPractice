package java8.java8Action.chapter4;

import java.util.*;
import java.util.stream.Collectors;

public class StreamVSCollection {

    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("####################");

        getLowCaloricDishesNameInStream(Dish.menu).forEach(System.out::println);
    }

    /**
     * 获取较低卡路里的菜单的名称,使用传统的方法
     * @param dishes 多种菜
     * @return 低卡路里菜的名称列表
     */
    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for (Dish dish: dishes) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        List<String> lowCaloricDishesName = new ArrayList<>();

        lowCaloricDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

//        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
//            @Override
//            public int compare(Dish d1, Dish d2) {
//                return Integer.compare(d1.getCalories(), d2.getCalories());
//            }
//        });

        for (Dish dish: lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNameInStream(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
