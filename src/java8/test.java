package java8;

import util.Person;

/**
 * Created by Nack on 2017/9/27.
 */
public class test {
    public static void main(String[] args) {
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(1, "123");

        Person person = new Person("1"), p2 = null;
        Person[] persons = new Person[1];
        persons[0] = person;
        p2 = person;
        person.setName("23");

        System.out.println(person.toString());
        System.out.println(p2.toString());
        System.out.println(persons[0].toString());
    }
}
