package java_version;

import java.util.*;

public class RepeatedArrays {

    static List<String> solution(String[] k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> vocab = new HashMap<>();

        for (String s : k) {
            String[] t = s.split("");
            for (String n : t) {
                vocab.put(n, vocab.getOrDefault(n, 0) + 1);
            }
        }

        Set<String> keys = vocab.keySet();
        for (String key : keys) {
            int m = vocab.get(key);
            while (m / k.length > 0) {
                ans.add(key);
                m /= k.length;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        return ans;
    }

    static List<String> solution2(String[] k) {
        List<String> ans = new ArrayList<>();
        boolean stillThat = false;

        if (k.length == 0)
            return List.of("");

        for (int i = 0; i < k[0].length(); i++) {
            stillThat = true;
            for (int j = 1; j < k.length; j++) {
                if (k[j].contains(String.valueOf(k[0].charAt(i)))) {
                    k[j] = k[j].replaceFirst(String.valueOf(k[0].charAt(i)), "");
                } else {
                    stillThat = false;
                    break;
                }
            }
            if (stillThat) ans.add(String.valueOf(k[0].charAt(i)));
        }

        return ans;
    }


    public static void main(String[] args) {
        String[] s = new String[]{"sallom", "solla", "sohill"};
        String[] s2 = new String[]{"weekend", "ending", "weekly"};
        String[] s3 = new String[]{"monthly", "yearly", "annually"};
        String[] s4 = new String[]{"summer", "mountains", "motherland"};
        String[] s5 = new String[]{"gossip", "source", "certain"};
        System.out.println(solution2(s));
        System.out.println(solution2(s2));
        System.out.println(solution2(s3));
        System.out.println(solution2(s4));
        System.out.println(solution2(s5));
    }
}
