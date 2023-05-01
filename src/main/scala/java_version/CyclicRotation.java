package java_version;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CyclicRotation {

    public static int[] solution(int[] A, int K) {
        int[] B = new int[A.length];
        int index = 0;

        for (int i = 0; i < A.length; i++) {
           index = i + K - 1;
            if (i + K - 1 > A.length - 1)
                index = (A.length - 1 - i) - 1;

            B[i] = A[index];
        }

        return B;
    }

    static Character findMost(String s) {
        char mostChar = ' ';
        int mostCount = 0;

        Map<Character, Integer> vocab = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < 'A' || c > 'z')
                continue;

            vocab.put(c, vocab.getOrDefault(c, 0) + 1);

            if (vocab.getOrDefault(c, 0) > mostCount) {
                mostCount = vocab.get(c);
                mostChar = c;
            }
        }
        return mostChar;
    }
    
    public static void main(String[] args) {
        int a[] = new int[] {1, 2, 3, 4};
        int b[] = new int[] {3, 8, 9, 7, 6};
        int k[] = new int[1];
        String s = "";
//
//        System.out.println(Arrays.toString(solution(a, 4)));
//        System.out.println(Arrays.toString(solution(b, 3)));
        System.out.println((int) 'A');
        System.out.println((int) 'a');
        System.out.println(findMost("Heeeeello"));
    }
}
