package java_version;

public class TuringDemoTask {

    static boolean isValidInput(String s) {
        boolean isValidSeq = true;
        boolean isValidLoop = true;

         if(s.length() % 2 != 0)
             return false;

        for(int i = 0, j = 0; i<s.length()/2; i++, j+=2) {
            char c = s.charAt(j);
            char c1 = s.charAt(j+1);
            char l = s.charAt(i);
            char l1 = s.charAt(s.length() - 1 - i);

            isValidSeq = isValidSeq && (c=='('&&c-c1==-1 || c=='['&&c-c1==-2 || c=='{'&&c-c1==-2);
            isValidLoop = isValidLoop && (l=='('&&l-l1==-1 || l=='['&&l-l1==-2 || l=='{'&&l-l1==-2);
        }
        return isValidSeq || isValidLoop;
    }

    public static void main(String[] args) {
        System.out.println('(' - ')');
        System.out.println('[' - ']');
        System.out.println('{' - '}');

        System.out.println(isValidInput("][][][]{}{}()["));
        System.out.println(isValidInput("[][][]{}{}()"));
        System.out.println(isValidInput("[][][]{}{}("));
        System.out.println(isValidInput("[[{{((()))}}]]"));
        System.out.println(isValidInput("[[{{((()))}}]"));
        System.out.println(isValidInput("[[{{((()))]}]"));
        System.out.println(isValidInput("[[{{(({)))}]"));
    }
}
