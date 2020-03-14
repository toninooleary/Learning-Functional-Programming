# Learning-Functional-Programming
Learning about functional programming and its distinctions from imperative programming

# Lambda expressions

Lambdas allow you to do function like operations. These can be passed into other methods or variables. Generally it adds clarity to code.

        (Person p) -> p.getGender() == Person.Sex.MALE
        // Returns true or false

# Streams:
- Streams can be used as an alternative to for loop operations on lists.

# Using the **Function** package:

[Package java.util.function](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html "Package java.util.function")

- .filter will filter an input. e.g. filter, takes a lambda as input.    
        .filter(lambda expression)
- .collect will collect any operations performed into a data type.
        .collect(Collectors.toList())
- .forEach will perform operations on these new list

# Predicates (Complex example)

This is an example of a predicate in use. It will return true or false based on the statement it is given.

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        
        List<Person> fPeople = people.stream()
                // filters all females
                .filter(personPredicate)
                // stores output in a list
                .collect(Collectors.toList());

We can simplify this by removing its instance as a variable:

        List<Person> fPeople = people.stream()
                // filters all females
                .filter(person -> Gender.FEMALE.equals(person.gender))
                // stores output in a list
                .collect(Collectors.toList());

# Functional Interfaces

# Functions

A "Function" will accept one input and give a result

        Function<T, R>

"T" represents the input datatype
"R" repersents the output datatype

        e.g. Function<Integer, Integer>

In use, its declaration will look like this:

        Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

This statement will do the same thing as:

        static int increment(int number){
                return number + 1;
        }

## .apply()

.apply() is used to apply these functions to variables/values its passed.

        incrementByOneFunction.apply(integer);

# Chaining functions:

You can chain two functions together to create a different function.

You do this using the .andThen() method. You pass this the second function you want to use.

        Function<Integer, Integer> addBy1AndMultiplyBy10 = 
                incrementByOneFunction.andThen(multiplyBy10Function);

        System.out.println(addBy1AndMultiplyBy10.apply(1));

# Bifunctions:

- It is the same as a function, but it takes two arguments and produces one output.

# Consumers:

- A cosumer is like a void method. It takes an input, does an operation, and provides no output.

        greetCustomerConsumer.accept(jack);

        static Consumer<Customer> greetCustomerConsumer = 
                customer -> System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + customer.customerPhoneNumber);

- .accept is used to apply the consumer to a value.

# BiConsumer:

- The same as a consumer but takes two arguments.

# Predicates (simplified):

- A predicate performs boolean operations. It is the same as a boolean method.

        boolVal = isPhoneNumberValidPredicate.test("09000435453");
        
        static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
                phoneNumber.startsWith("07") & phoneNumber.length() == 11;

- To use a predicate on a value you use .test.

- BiPredicates also exist.

# Supplier:

- A supplier returns a value. It takes no arguments. It is the same as a getter method.

        url = getDbConnectionUrlSupplier.get();

        static Supplier<String> getDbConnectionUrlSupplier = ()
            -> "jbks://localhost:3465/users";

to call the Supplier, you use .get()

# Streams:

- ...

# Aditional notes:

#### Static:

- static keyword - It is used for a constant variable or method that will be the same for every instance of a class.

- static is in memory all the time

- It can be used without creating an instance of a class.

- You can just do .functionName.staticMethod to call the method.

- A static variable will be shared between all instances of the class.

#### ? : operator

- This operator is a visually simplified if statement. it is used for assigning a value based on an input.

- [? : operator good example and summary](http://www.cafeaulait.org/course/week2/43.html "? : operator")