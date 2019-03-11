package offer;

public class Of10_minNumberInRotateArray_optimize {

    public static int findMin(int[] nums){
        int n = nums.length -1;
        if (n < 0) return -1;
        while (n >0 && nums[n] == nums[0]) n--;//去掉数组开始和结尾相等的情况，那么此时后半部分都比一个元素小
        // ，那么此时使用二分法，第一个比头元素小的就是结果值
        if (nums[n] >= nums[0]) return nums[0];//如果没有任何逆转
        int l = 0,r = n;
        while (l < r){
            int mid = l + r >> 1;//todo   >>1
            if (nums[mid] < nums[0]){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,0,1,2,2};
        System.out.println(findMin(arr));;
    }
}
