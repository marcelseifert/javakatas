package de.mse.hamburg.diamond;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class Diamond {

    public static String print(int n) {
        if (n < 0 || n % 2 == 0) {
            return null;
        }
        int halfDiamondRow = (int) Math.ceil(n / 2d);
        StringBuffer sb = new StringBuffer();
        drawStars(halfDiamondRow, 1, sb);
        if (n > 1) {
            calcStars(2, sb, halfDiamondRow);
            drawStars(halfDiamondRow, 1, sb);
        }

        return sb.toString();
    }

    private static void drawStars(int halfDiamondRow, int step, StringBuffer sb) {
        int countStars = step + (step - 1);
        for (int i = step; i < halfDiamondRow; i++) {
            sb.append(" ");
        }
        for (int i = 0; i < countStars; i++) {
            sb.append("*");
        }
        sb.append(System.lineSeparator());
    }

    static void calcStars(int step, StringBuffer sb, int halfDiamondRow) {
        drawStars(halfDiamondRow, step, sb);
        if (step < halfDiamondRow) {
            calcStars(step + 1, sb, halfDiamondRow);
            drawStars(halfDiamondRow, step, sb);
        }
    }

    public static void main(String[] args) {
        System.out.printf("%s%n", print(23));
    }

    public static String printLambdaVersion(final int n) {
        if (n < 0 || n % 2 == 0) {
            return null;
        }

        return IntStream.range(0, n * 2)
                .filter(i -> i % 2 > 0)
                .map(i -> i > n ? n - (i - n) : i)
                .mapToObj(i -> " ".repeat((n - i) / 2) + "*".repeat(i) + "\n")
                .collect(Collectors.joining());
    }
}
