package demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wim on 2017/8/3.
 */
public class TwoSum {
//    public int[] twoSum(int[] nums, int target){
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= target){
//                for (int j = i+1; j < nums.length; j++) {
//                    if (nums[j] <= target){
//                        if (nums[i] + nums[j] == target){
//                            result[0] = i;
//                            result[1] = j;
//                            break;
//                        }
//                    }
//                    else {
//                        continue;
//                    }
//                }
//            }
//            else {
//                continue;
//            }
//        }
//        return result;
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = {1,3,14,12,10,5,9,0,11};
        int target = 15;

        TwoSum sum = new TwoSum();
        int [] result = sum.twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
