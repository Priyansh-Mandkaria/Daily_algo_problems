// Last updated: 6/22/2026, 1:38:09 PM
class Solution {

    class Bean {
        int damage;
        int health;
        int timeToKill;
        double ratio;
        
        Bean(int d, int h) {
            damage = d;
            health = h;
            timeToKill = (int) Math.ceil((1.0*health)/pow);
            ratio = (1.0*timeToKill)/damage;
        }
    }
    int pow;
    public long minDamage(int power, int[] damage, int[] health) {
        pow = power;
        long damagePerSecond = 0l;
        for(int d : damage) {
            damagePerSecond += d;
        }


        PriorityQueue<Bean> pq = new PriorityQueue<Bean>((a,b) -> a.ratio > b.ratio ? 1 : -1);
        
        for(int i=0; i<damage.length; i++) {
            pq.add(new Bean(damage[i], health[i]));
        }

        long res = 0l;

        while(pq.size() > 0) {
            Bean b = pq.remove();
            res += damagePerSecond*(b.timeToKill);
            damagePerSecond -= b.damage;
        }

        return res;

    }
}