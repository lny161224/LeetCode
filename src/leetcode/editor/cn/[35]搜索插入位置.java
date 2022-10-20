//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 1721 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int find(int[] nums, int a, int b, int target) {
        int flag = -1;
        if (a >= b) flag = target == nums[a] ? a : -1;
        else {
            int mid_index = (a + b) / 2;
            int mid = nums[mid_index];
            if (target == mid) flag = mid_index;
            else if (target < mid) flag = find(nums, a, mid_index - 1, target);
            else flag = find(nums, mid_index + 1, b, target);
        }
        return flag;
    }
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0)return 0;
        else{
            int flag = find(nums,0,nums.length-1,target);
            if(flag==-1){
                for(int i = 0;i<nums.length;i++) if(nums[i]>target)return i;
                return nums.length;
            }
            return flag;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
