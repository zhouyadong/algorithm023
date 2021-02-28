package com.exercise.week08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Java：   [242]有效的字母异位词
 **/


public class ValidAnagram {
    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 326 👎 0

    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        // TO TEST
        String s = "ab";
        String t = "a";
        System.out.println(solution.isAnagram(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 使用map代替array
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {

            Map<Character, Integer> cacheMap = new HashMap<>();
            int slen = s.length(), tlen = t.length();
            for (int i = 0; i < slen; i++) {
                Integer ret = cacheMap.getOrDefault(s.charAt(i), 0);
                cacheMap.put(s.charAt(i), ret + 1);

            }
            for (int i = 0; i < tlen; i++) {
                Integer ret = cacheMap.get(t.charAt(i));
                if (null == ret) {
                    return Boolean.FALSE;
                }
                cacheMap.put(t.charAt(i), ret - 1);
            }
            for (Integer value : cacheMap.values()) {
                if (value != 0) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }

        /**
         * 计数排序
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram4(String s, String t) {

            int cache[] = new int[26];
            int slen = s.length(), tlen = t.length();
            for (int i = 0; i < slen; i++) {
                int index = s.charAt(i) - 'a';
                cache[index]++;
            }
            for (int i = 0; i < tlen; i++) {
                int index = t.charAt(i) - 'a';
                if (cache[index]-- == 0) {
                    return Boolean.FALSE;
                }
            }

            for (int value : cache) {
                if (value != 0) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }


        // 进阶问题：当出现unicode字符时，字符串的长度不可控，
        // 在isAnagram2基础上，需要使用hash缓存结果，并且使用
        public boolean isAnagram3(String s, String t) {
            int len;
            if (null != s && null != t && (len = s.length()) == t.length()) {//无效判断
                Map<Character, Integer> temMap = new HashMap<Character, Integer>();
                for (int i = 0; i < len; i++) {
                    Character key = s.charAt(i);
                    Integer value = temMap.getOrDefault(key, 0);
                    temMap.put(key, value += 1);
                }

                for (int i = 0; i < len; i++) {
                    Character key = t.charAt(i);
                    Integer value = temMap.get(key);
                    if (null == value || 0 == value) {
                        return Boolean.FALSE;
                    } else {
                        value--;
                        temMap.put(key, value);
                    }
                }

                for (Map.Entry<Character, Integer> entry : temMap.entrySet()) {
                    if (entry.getValue() != 0) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }

            return Boolean.FALSE;
        }

        //三次遍历，
        // 1、使用数组（长度为26，）缓存s结果，遍历每个元素时+1，
        // 2、遍历t每个元素时从数组中-1，出现小于0直接返回false
        // 3、遍历数组检查全部value是否都是0；
        public boolean isAnagram2(String s, String t) {

            int len;
            if (null != s && null != t && (len = s.length()) == t.length()) {//无效判断
                int[] temArray = new int[26];
                char a = 'a';
                for (int i = 0; i < len; i++) {
                    temArray[s.charAt(i) - a]++;//遍历每个元素时+1，
                }
                for (int i = 0; i < len; i++) {
                    int index = t.charAt(i) - a;
                    temArray[index]--;
                    if (temArray[index] < 0) {//遇到多一次的情况，肯定不符合
                        return Boolean.FALSE;
                    }
                }
                for (int i = 0; i < 26; i++) {
                    if (temArray[i] != 0) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        //暴力法：排序后做equals判断
        //时间复杂度O(nlog n)，空间复杂度O(n)，如果参数类型换成char[]，空间复杂度为O(logn)
        public boolean isAnagram1(String s, String t) {

            boolean ret;
            if (null != s && null != t && s.length() == t.length()) {//无效判断
                char[] sc = s.toCharArray();
                char[] tc = t.toCharArray();//空间复杂度O(n)
                Arrays.sort(sc);
                Arrays.sort(tc);//时间复杂度O(nlog n)、空间复杂度O(log n)
                ret = Arrays.equals(sc, tc);//时间复杂度O(n)
            } else {
                ret = Boolean.FALSE;
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}