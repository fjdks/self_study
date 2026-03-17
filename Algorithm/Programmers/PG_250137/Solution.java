class Solution {
    public int healing(int hp, int recoveryAmount, int maxHp) {
        for(int i = 0; i < recoveryAmount; i++) {
            if((hp + 1) > maxHp) break;
            hp++;
        }
        return hp;
    }
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int hp = health;
        int duration = 0;
        int monster = 0;
        while(time <= attacks[attacks.length - 1][0]) {
            if(time < attacks[monster][0]) {
                duration++;
                hp = healing(hp, bandage[1], health);
                if(duration == bandage[0]) {
                    duration = 0;
                    hp = healing(hp, bandage[2], health);
                }
            } else if(time == attacks[monster][0]) {
                hp -= attacks[monster][1];
                if(hp <= 0) {
                    hp = -1;
                    break;
                }
                duration = 0;
                monster++;
            }
            time++;
        }
        
        return hp;
    }
}