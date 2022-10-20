//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 354 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        int cnt = 0;
        for(int i=0;i<s.length();i++)
            if (s.charAt(i)==' ')cnt++;
        char[] ans = new char[2*cnt+s.length()];
        int j = 0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i)==' '){
                ans[j++] = '%';
                ans[j++] = '2';
                ans[j++] = '0';
            }
            else ans[j++] = s.charAt(i);
        }
        return String.valueOf(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
