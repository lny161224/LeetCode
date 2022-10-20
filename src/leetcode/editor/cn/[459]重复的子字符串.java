//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 801 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int P = 131;
        int[] h= new int[s.length()];
        int[] p = new int[s.length()];
        h[0] = s.charAt(0);
        p[0] = 1;
        // 计算s的hash值
        for(int i = 1;i<s.length();i++){
            h[i] = h[i-1]*P+s.charAt(i);
            p[i] = p[i-1]*P;
        }
        int hash = 0;
        for(int i=0;i<s.length()/2;i++) {
            // 只计算子串长度是整串的公因数的情况
            int flag = 1;
            if (s.length() % (i + 1) == 0) {
                hash = h[i];
                for (int j = 1; j < s.length() / (i + 1); j++) {
                    int begin = j * (i + 1);
                    int end = (j + 1) * (i + 1) - 1;
                    int Hash = h[end] - h[begin - 1] * p[i + 1];
                    // 只要出现了不匹配直接跳出循环，节省时间
                    if (hash != Hash){
                        flag = 0;
                        break;
                    }
                }
                // 只有完全匹配的情况才返回true
                if (flag==1) return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
