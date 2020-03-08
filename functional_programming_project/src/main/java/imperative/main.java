package imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class main {
    public static void main(String[] args) {
        // wrapping our list in an array
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("David", Gender.MALE),
            new Person("Jemma", Gender.FEMALE),
            new Person("Rachel", Gender.FEMALE),
            new Person("Jack", Gender.MALE)
        );

        System.out.println("// Imperative approach");
        // Imperative approach (for finding out how many females we have)
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female : females){
            System.out.println(female);
        }

        System.out.println("// Declarative approach 1");
        // Declarative Approach:
        // This uses streams with collections
        people.stream()
                // filters all females
                .filter(person -> Gender.FEMALE.equals(person.gender))
                // stores output in a list
                .collect(Collectors.toList())
                // prints every element in the new list
                .forEach(System.out::println);

        System.out.println("// Declarative approach 2 (stored stream)");
        //You can also store streams as lists
        List<Person> fPeople = people.stream()
                // filters all females
                .filter(person -> Gender.FEMALE.equals(person.gender))
                // stores output in a list
                .collect(Collectors.toList());

        fPeople.forEach(System.out::println);

    }

    // nested static class
    static class Person {
        // final means it can no longer be changed
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
