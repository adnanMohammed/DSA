

public class ConvertminToMaxHeap {

    public int[] minToMaxHeap(int[] nums) {
       int size=nums.length; int start=size/2;
        for (int i = start-1; i >=0 ; i--) {
            heapDown(nums,i);
        }
        return nums;
    }

    private void heapDown(int[] nums,int index) {
        if (index >= (nums.length / 2))
            return;
        int max = index;
        if (left(index) < nums.length && nums[left(index)] > nums[index])
            max = left(index);

        if (right(index) < nums.length && nums[right(index)]>nums[max])
            max = right(index);

        if (max != index) {
            swap(nums, index, max);
            heapDown(nums, max);
        }
    }

    private void swap(int[] nums, int max, int i) {
        int temp=nums[i];
        nums[i]=nums[max];
        nums[max]=temp;
    }
    private int left(int index) {
        return (2*index)+1;
    }

    private int right(int index) {
        return (2*index)+2;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        ConvertminToMaxHeap c=new ConvertminToMaxHeap();
        int[] ans=c.minToMaxHeap(nums);
        System.out.println("ans="+ans);


    }
}
