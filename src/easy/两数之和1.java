package src.easy;

import java.util.HashMap;

/**
 * @Author bxdu
 * @Date 2022年12月21日 22:39
 **/
public class 两数之和1 {
    /**
     * easy
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */

    /*
     * 1.暴力求解
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1;j < len; j++){
                if(nums[i] + nums[j] == target){
                    int[] newArray = {i,j};
                    return newArray;
                }
            }
        }
        return null;
    }
    /*
     * 2.哈希表
     * 使用哈希表的方法，一开始简单的以为先遍历数组建立哈希表，再遍历数组在哈希表里找值，看了题解的代码，一度认为代码少了一次遍历，
     * 想了半天才明白错的是我。 两个元素x，y必然是一前一后出现的，如果存在符合条件的解，在遍历到x时，哈希表里没有符合的y，此时把x加入到了哈希表里，
     * 当遍历到y时，就可以在哈希表里找到对应的x了，所以只需要一次遍历，妙啊。
     *
     * 此题注意，用两次遍历反而不行。
     * 第一次遍历先建立哈希表，有数据重复的可能。
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = nums.length;
        for(int i = 0;i < len; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0};
    }
}
