class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill_trees.length; i++) {
            String cur = skill_trees[i];
            int idx = 0;
            boolean flag = true;
            for(int j = 0; j < skill_trees[i].length(); j++) {
                int cur_idx = skill.indexOf(Character.toString(skill_trees[i].charAt(j)));
                if(cur_idx == -1) continue;
                else if(cur_idx != idx) {
                    flag = false;
                    break;
                } else idx++;
            }
            if(flag) answer++;
        }
        return answer;
    }
}