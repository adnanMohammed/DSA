public class maxScoreFromCards {

    //Brute force approach
    public int maxScore(int[] cardScore, int k) {
        //your code goes here
        int n = cardScore.length;
        int maxPoint = 0;

        for (int i = k - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i; j > i - k; j--) {
                if (j < 0)
                    sum += cardScore[n + j];
                else sum += cardScore[j];
            }
            maxPoint = Math.max(maxPoint, sum);
        }

        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += cardScore[j % n];
            }
            maxPoint = Math.max(maxPoint, sum);
        }
        return maxPoint;
    }


    public int maxScore1(int[] cardScore, int k) {
        int n = cardScore.length;
        int sum = 0, maxPoint = 0, L = 0, R = 0;

        while (R >= 0) {
            if (R < k) {
                sum += cardScore[R];
                R++;
            } else {
                while (R > 0) {
                    maxPoint = Math.max(maxPoint, sum);
                    R--;
                    sum -= cardScore[R];
                    L--;
                    sum += cardScore[n + L];
                }

                break;
            }
        }

        R = n - 1;
        L = n - 1;
        sum = 0;

        while (L <= R) {
            if (L >= n - k) {
                sum += cardScore[L];
                L--;
            } else {
                while (L < n-1) {
                    maxPoint = Math.max(maxPoint, sum);
                    L++;
                    sum -= cardScore[L];
                    R++;
                    sum += cardScore[R - n];
                }
                break;
            }
        }
        return maxPoint;

    }

    public int maxScore1Optimized(int[] cardScore, int k) {
        int Lsum=0,Rsum=0,sum=0;
        int n= cardScore.length, L=k-1,R=n-1;

        for (int i = 0; i <k ; i++)
            sum+=cardScore[i];

        int maxSum=sum;

        while (L>=0){
            sum-=cardScore[L];
            sum+=cardScore[R];
            L--;R--;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;

    }
}


class maxScoreFromCardsMain {
    public static void main(String[] args) {
        maxScoreFromCards c = new maxScoreFromCards();
        int[] cardScore = {96,90,41,82,39,74,64,50,30};
        int k = 8;
        c.maxScore1Optimized(cardScore, k);
    }
}