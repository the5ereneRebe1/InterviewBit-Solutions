package Problems;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(LargestNumber.solution(new int[] { 3, 1, 4, 1, 5, 9 }));
    }

    public static int printResult(int[] l, int pos1, int pos2) {
        int num = 0;
        // TODO: generate the number
        for (int i = l.length-1; i >=0; i--) {
            if (i != pos1 && i != pos2)
                num = num * 10 + l[i];
        }
        return num;
    }

    public static int solution(int[] l) {
        int sum = 0;
        for (int i : l)
            sum += i;

        Arrays.sort(l);
        int remainder = sum % 3;
        if(remainder == 0) 
            return printResult(l, -1, -1);
        if (remainder == 1) {
            int[] rem = new int[2];
            rem[0] = -1;
            rem[1] = -1;
            for (int i = 0; i < l.length; i++) {
                if (l[i] % 3 == 1)
                    return printResult(l, i, -1);
                if (l[i] % 3 == 2) {
                    if (rem[0] == -1)
                        rem[0] = i;
                    else if (rem[1] == -1)
                        rem[1] = i;
                }
            }
            if (rem[0] != -1 && rem[1] != -1)
                return printResult(l, rem[0], rem[1]);
        } else if (remainder == 2) {
            int[] rem = new int[2];
            rem[0] = -1;
            rem[1] = -1;
            for (int i = 0; i < l.length; i++) {
                if (l[i] % 3 == 2)
                    return printResult(l, i, -1);
                if (l[i] % 3 == 1) {
                    if (rem[0] == -1)
                        rem[0] = i;
                    else if (rem[1] == -1)
                        rem[1] = i;
                }
            }
            if (rem[0] != -1 && rem[1] != -1)
                return printResult(l, rem[0], rem[1]);
        }
        return 0;
    }
}
