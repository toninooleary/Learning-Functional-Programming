package imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
