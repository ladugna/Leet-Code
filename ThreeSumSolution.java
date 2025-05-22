import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSumSolution {
        public List<List<Integer>> threeSum(int[] nums) {
            // Sort the array to efficiently handle duplicates and use the two-pointer technique.
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            int n = nums.length;

            // Iterate through the array with 'i' as the first element of the triplet.
            // We go up to n - 2 because we need at least two more elements (left and right).
            for (int i = 0; i < n-2 ; i++) {
                // Skip duplicate values for nums[i] to avoid duplicate triplets.
                // If i > 0 and the current element is the same as the previous one,
                // we've already considered triplets starting with that value.
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // Initialize two pointers: 'left' starts after 'i', 'right' starts at the end.
                int left = i + 1;
                int right = n - 1;

                // Use the two-pointer approach to find the remaining two numbers.
                while (left < right) {
                    int currentSum = nums[i] + nums[left] + nums[right];

                    if (currentSum == 0) {
                        // Found a triplet that sums to zero.
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Skip duplicate values for nums[left] and nums[right]
                        // to ensure unique triplets.
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Move pointers to the next distinct elements.
                        left++;
                        right--;
                    } else if (currentSum < 0) {
                        // Sum is too small, need a larger value, so move 'left' pointer.
                        left++;
                    } else { // currentSum > 0
                        // Sum is too large, need a smaller value, so move 'right' pointer.
                        right--;
                    }
                }
            }
            return result;
        }
    }
