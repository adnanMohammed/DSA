public class arrayRepresentsMinHeapOrNot {

    public boolean isHeap(int[] nums) {
        int end=nums.length/2;
        for (int i = 0; i < end; i++) {
            if (nums[i]>nums[left(i)] || nums[i]>nums[right(i)])
                return false;
        }
        return true;
    }

    private int left(int index) {
        return (2*index)+1;
    }
    private int right(int index) {
        return (2*index)+2;
    }


}
