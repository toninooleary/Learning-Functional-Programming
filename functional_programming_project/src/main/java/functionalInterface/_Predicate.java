package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        // non-functional method
        System.out.println("Without predicate:");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("070000"));
        System.out.println(isPhoneNumberValid("09000435453"));

        // Functional method
        System.out.println("\nWith Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("070000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000435453"));

        System.out.println(
                "Is phone number valid and contains number 4 = " +
                        isPhoneNumberValidPredicate.and(containsNumber4).test("070000")
        );

        System.out.println(
                "Is phone number valid and contains number 4 = " +
                        isPhoneNumberValidPredicate.or(containsNumber4).test("09000435453")
        );
    }

    static boolean isPhoneNumberValid (String phoneNumber){
        return phoneNumber.startsWith("07") & phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") & phoneNumber.length() == 11;

    static Predicate<String> containsNumber4 = phoneNumber ->
            phoneNumber.contains("3");
}
