import java.util.*;

class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        k--; // 0-based로 변경

        for (int i = 0; i < n; i++) {

            int index = (int)(k / factorial);

            answer[i] = numbers.get(index);
            numbers.remove(index);

            if (i == n - 1) {
                break;
            }

            k %= factorial;

            factorial /= (n - 1 - i);
        }

        return answer;
    }
}