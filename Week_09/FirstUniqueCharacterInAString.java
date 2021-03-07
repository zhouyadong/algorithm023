package com.exercise.week09;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Java：   [387]字符串中的第一个唯一字符
 **/


public class FirstUniqueCharacterInAString {
    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 354 👎 0

    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int firstUniqChar(String s) {


            int len = s.length();
            if (len > 0) {
                Map<Character, Integer> cache = new HashMap<>();
                for (int i = 0; i < len; i++) {
                    Integer tem = cache.getOrDefault(s.charAt(i), 0);
                    cache.put(s.charAt(i), tem + 1);
                }
                for (int i = 0; i < len; i++) {
                    if (cache.get(s.charAt(i)) == 1) {
                        return i;
                    }
                }
            }
            return -1;
        }


        public int firstUniqChar1(String s) {

            Map<Character, Integer> cache = new LinkedHashMap<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                Integer value = cache.getOrDefault(s.charAt(i), 0);
                cache.put(s.charAt(i), value + 1);
            }
            for (int i = 0; i < len; i++) {
                Integer value = cache.get(s.charAt(i));
                if (value == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}