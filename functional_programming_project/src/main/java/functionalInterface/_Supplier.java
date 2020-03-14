package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        // Non-functional method
        System.out.println(getDBConnectionUrl());

        // Functional method
        System.out.println(getDbConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl () {
        return "jbks://localhost:3465/users";
    }

    static Supplier<String> getDbConnectionUrlSupplier = ()
            -> "jbks://localhost:3465/users";
}
