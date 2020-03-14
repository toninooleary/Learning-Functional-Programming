package streams;

import java.util.List;

public class _Stream {

    public static void main(String[] args) {
        // wrapping our list in an array
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("David", Gender.MALE),
                new Person("Jemma", Gender.FEMALE),
                new Person("Rachel", Gender.FEMALE),
                new Person("Jack", Gender.MALE)
        );

        //people.stream()
        //        .map()

    }

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
