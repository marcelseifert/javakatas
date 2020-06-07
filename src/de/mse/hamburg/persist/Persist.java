package de.mse.hamburg.persist;

import java.util.Arrays;

final class Persist {

    public static int persistence(long n) {
        if( n < 0) return 0;
        int countOfMultiply = 0;
        return reduceToSingleDigit(n, countOfMultiply);
    }

    private static int reduceToSingleDigit(long n, int countOfMultiply) {
       if( n < 10) return countOfMultiply;
       long reducedValue = Arrays.stream(String.valueOf(n).split("")).mapToLong(Long::parseLong).reduce( (a, b) -> a*b).getAsLong();
       ++countOfMultiply;
       if( reducedValue > 9) {
           countOfMultiply = reduceToSingleDigit(reducedValue, countOfMultiply);
       }
       return countOfMultiply;
    }

    public static int moreFancyPersistence(long n) {
        int times = 0;
        while (n >= 10) {
            n = Long.toString(n).chars().reduce(1, (r, i) -> r * (i - '0'));
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.printf("%s%n", persistence(25));
    }
}
