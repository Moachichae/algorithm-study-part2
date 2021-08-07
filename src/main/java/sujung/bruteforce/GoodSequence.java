package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class GoodSequence {
    private static int N;
    private static boolean finished;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            N = parseInt(br.readLine());
            sb = new StringBuilder();

            go(0);
        }
    }

    private static void go(int index) {
        if (finished) return;

        if (index >= N) {
            System.out.println(sb.toString());
            finished = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            if (isGood()) {
                go(index + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isGood() {
        if (sb.length() >= 2) {
            int length = sb.length();
            for (int i = 1; i <= length / 2; i++) {
                String first = sb.substring(length - i - i, length - i);
                String second = sb.substring(length - i, length);
                if (first.equals(second)) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
