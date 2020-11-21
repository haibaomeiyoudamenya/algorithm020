package leetcode.editor.cn;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 581 👎 0

class 加一{
 public static void main(String[] args) {
    Solution solution = new 加一().new Solution();
 }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length -1] == 9){
            digits[digits.length -1] = 0;
            if (digits.length > 1){
                for (int i = digits.length - 2; i >= 0; i--) {
                    if (digits[i] == 9){
                        digits[i] = 0;
                        if (i == 0){
                            int[] newDigits = new int[digits.length +1];
                            for (int j = 0; j < digits.length; j++) {
                                newDigits[j + 1] = digits[j];
                            }
                            newDigits[0] = 1;
                            digits = newDigits;
                        }
                    }else {
                        digits[i] = digits[i] + 1;
                        break;
                    }

                }
            }else {
                int[] newDigits = new int[digits.length + 1];
                for (int j = 0; j < digits.length; j++) {
                    newDigits[j + 1] = digits[j];
                }
                newDigits[0] = 1;
                digits = newDigits;
            }
        }else {
            digits[digits.length -1] = digits[digits.length -1] + 1;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length -1 ; i >= 0; i--) {
                if (digits[i] == 9){
                    digits[i] = 0;
                }else {
                    digits[i] += 1;
                    return digits;
                }
            }
            //最高位需要进位 有默认值
            digits = new int[digits.length +1];
            digits[0] = 1;
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}