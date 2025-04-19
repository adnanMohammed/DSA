public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        //your code goes here
        int five = 0, ten = 0, twenty = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                five++;

            else if (bills[i] == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            } else {
                if (five == 0)
                    return false;
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;

    }
}

class LemonadeChangeMain{
    public static void main(String[] args) {
     int[] bills = {5, 5, 10, 5, 20};
     LemonadeChange lc=new LemonadeChange();
     lc.lemonadeChange(bills);
    }
}