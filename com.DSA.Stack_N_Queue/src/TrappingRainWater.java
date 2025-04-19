public class TrappingRainWater {

    public int trapOptimal(int[] height) {
        int n = height.length, L = 0, R = n - 1;
        int Lmax = 0, Rmax = 0, totalCount = 0;

        while (L < R) {
            if (height[L] <= height[R]) {
                if (height[L] < Lmax)
                    totalCount += Lmax - height[L];
                else if (height[L] > Lmax)
                    Lmax = height[L];

                L++;
            } else {
                if (height[R] > Rmax)
                    Rmax = height[R];
                else if (height[R] < Rmax)
                    totalCount += Rmax - height[R];

                R--;
            }
        }
        return totalCount;
    }

    public int trap(int[] height) {
        int n = height.length, sum = 0;

        for (int i = 0; i < n; i++) {
            int[] leftMax = leftMax(height);
            int[] rightMax = rightMax(height);
            if (leftMax[i] > height[i] && rightMax[i] > height[i])
                sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }

    private int[] leftMax(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int j = 1; j < n; j++) {
            leftMax[j] = Math.max(leftMax[j - 1], height[j]);
        }
        return leftMax;
    }

    private int[] rightMax(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        return rightMax;
    }
}


class TrappingRainWaterMain{
    public static void main(String[] args) {
    TrappingRainWater tw=new TrappingRainWater();
    int[] height={0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int res=tw.trapOptimal(height);
    }
}