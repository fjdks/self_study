class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int product = 1;
        for(int i = 0; i < num_list.length; i++) {
            product *= num_list[i];
            sum += num_list[i];
        }
        return (product < (sum * sum)) ? 1 : 0;
    }
}