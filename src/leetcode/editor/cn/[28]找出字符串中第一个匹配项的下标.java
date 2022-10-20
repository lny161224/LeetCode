//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 1603 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int P = 131;
        int n = haystack.length();
        int L = needle.length();
        int[] h = new int[n];
        int[] p = new int[n];
        h[0] = haystack.charAt(0);
        p[0] = 1;
        // 计算h的hash值
        for (int i = 1; i < n; i++) {
            h[i] = h[i - 1] * P + haystack.charAt(i);
            p[i] = p[i - 1] * P;
        }
        // 计算n的hash值
        int hash = 0;
        for (int i = 0; i < L; i++) hash = hash * P + needle.charAt(i);
        System.out.println(hash);
        // 在h中找与n长的字符串,匹配hash值
        int Hash = 0;
        if (h[L - 1] == hash) return 0;
//        for(int e:p)System.out.println(e);
        for (int i = 1; i + L - 1 < n; i++) {
            Hash = h[i + L - 1] - h[i - 1] * p[L];
            System.out.println(Hash);
            if (Hash == hash) return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
