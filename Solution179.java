import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Additive number is a string whose digits can form additive sequence. A valid
 * additive sequence should contain at least three numbers. Except for the first
 * two numbers, each subsequent number in the sequence must be the sum of the
 * preceding two. Given a string containing only digits '0'-'9', write a
 * function to determine if it's an additive number. Note: Numbers in the
 * additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3
 * is invalid
 * 
 * Example 1: Input: "112358" Output: true Explanation: The digits can form an
 * additive sequence: 1, 1, 2, 3, 5, 8. 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 =
 * 8
 * 
 * 
 * Example 2: Input: "199100199" Output: true Explanation: The additive sequence
 * is: 1, 99, 100, 199. 1 + 99 = 100, 99 + 100 = 199
 * 
 * 
 * Constraints:
 * 
 * num consists only of digits '0'-'9'. 1 <= num.length <= 35 Follow up: How
 * would you handle overflow for very large input integers?
 */

class Solution179 {
    public String largestNumber(int[] nums) {

        StringBuilder result = new StringBuilder();

        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }

        int maxLength = 1;
        int temp = maxNum;
        while (temp / 10 > 0) {
            maxLength += 1;
            temp /= 10;
        }

        int[] plusNums = nums.clone();
        for (int i = 0; i < plusNums.length; i++) {
            while (plusNums[i] < Math.pow(10, maxLength - 1)) {
                plusNums[i] *= 10;
            }
        }

        for (int i = 0; i < plusNums.length; i++) {
            int maxIndex = 0;
            for (int j = 1; j < plusNums.length; j++) {
                if (plusNums[maxIndex] <= 0) {
                    maxIndex = j;
                } else if (plusNums[maxIndex] < plusNums[j]
                        || (plusNums[maxIndex] == plusNums[j] && nums[maxIndex] > nums[j])) {
                    maxIndex = j;
                }
            }
            plusNums[maxIndex] = -1;
            result.append(nums[maxIndex]);
        }
        System.out.println();
        return result.toString();

    }

    public static void main(String[] args) {
        Solution179 s = new Solution179();

        System.out.println(s.largestNumber(new int[] { 10, 1 }));
        System.out.println(s.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
        System.out.println(s.largestNumber(new int[] { 1113, 1113 }));
    }
}