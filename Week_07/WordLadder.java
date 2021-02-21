package com.homework.week07;

import java.util.*;

/**
 * Java：   [127]单词接龙
 **/


public class WordLadder {
    //字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 684 👎 0

    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        // TO TEST
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            Set<String> rules = new HashSet<>(wordList);
            // 校验
            if (rules.contains(endWord)) {
                Set<String> begins = new HashSet<>();
                Set<String> ends = new HashSet<>();
                Set<String> visiteds = new HashSet<>();
                begins.add(beginWord);
                ends.add(endWord);
                int level = 1;
                while (!begins.isEmpty() && !ends.isEmpty()) {
                    level++;
                    //检查begins、ends从较小者开始
                    if (begins.size() > ends.size()) {
                        Set<String> tems = begins;
                        begins = ends;
                        ends = tems;
                    }
                    Set<String> nextLevel = new HashSet<>();
                    for (String begin : begins) {
                        char[] values = begin.toCharArray();
                        int len = values.length;
                        for (int i = 0; i < len; i++) {
                            char old = values[i];
                            for (char c = 'a'; c <= 'z'; c++) {//尝试替换每一个字符
                                if (c == old) {
                                    continue;
                                }
                                values[i] = c;
                                String target = String.valueOf(values);
                                if (rules.contains(target)) {
                                    if (ends.contains(target)) {//找到
                                        return level;
                                    } else if (!visiteds.contains(target)) {//继续处理
                                        visiteds.add(target);
                                        nextLevel.add(target);
                                    }
                                }
                            }
                            values[i] = old;
                        }
                    }
                    begins = nextLevel;
                }
            }
            return 0;
        }























        public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

            Set<String> ruleSet = new HashSet<>(wordList);
            if (!ruleSet.contains(endWord)) {
                return 0;
            }
            Set<String> begins = new HashSet<>();
            Set<String> ends = new HashSet<>();
            begins.add(beginWord);
            ends.add(endWord);
            int level = 1;
            Set<String> visited = new HashSet<String>();
            while (!begins.isEmpty() && !ends.isEmpty()) {
                if (begins.size() > ends.size()) {//选择较小集合开始
                    Set<String> current = begins;
                    begins = ends;
                    ends = current;
                }
                Set<String> tems = new HashSet<>();//搜集下一层元素
                level += 1;//层数加1
                for (String word : begins) {//遍历当前层的元素，获取下一层
                    char[] values = word.toCharArray();
                    int len = values.length;
                    for (int i = 0; i < len; i++) {//每个字符都可以替换
                        char old = values[i];
                        for (char start = 'a'; start <= 'z'; start++) {//每个字符都可以替换
                            if (old == start) {//跳过相同字符
                                continue;
                            }
                            values[i] = start;//替换一个字符
                            String tem = String.valueOf(values);//获得结果
                            if (ruleSet.contains(tem)) {//检查是否在规则范围内
                                //判断是否在ends
                                if (ends.contains(tem)) {//找到了
                                    return level;
                                } else if (!visited.contains(tem)) {//未找到时，如果
                                    visited.add(tem);//记录已试过
                                    tems.add(tem);//记录这一层每次处理的结果
                                }
                            }
                        }
                        values[i] = old;//一次只能改变一个字符，需要恢复，才能继续尝试改变下一个
                    }
                }
                //将当前层的处理结果设置为下一次要处理的begins
                begins = tems;
            }
            return 0;
        }

        public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
            // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> wordSet = new HashSet<>(wordList);
            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
                return 0;
            }
            wordSet.remove(beginWord);

            // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
            int step = 1;
            while (!queue.isEmpty()) {
                int currentSize = queue.size();
                for (int i = 0; i < currentSize; i++) {
                    // 依次遍历当前队列中的单词
                    String currentWord = queue.poll();
                    // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                    if (checkLetter(currentWord, endWord, queue, visited, wordSet)) {
                        return step + 1;
                    }
                }
                step++;
            }
            return 0;
        }

        public boolean checkLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {

            char[] charArray = currentWord.toCharArray();
            for (int i = 0; i < endWord.length(); i++) {
                // 先保存，然后恢复
                char originChar = charArray[i];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (k == originChar) {
                        continue;
                    }
                    charArray[i] = k;
                    String nextWord = String.valueOf(charArray);
                    if (wordSet.contains(nextWord)) {
                        if (nextWord.equals(endWord)) {
                            return true;
                        }
                        if (!visited.contains(nextWord)) {
                            queue.add(nextWord);
                            // 注意：添加到队列以后，必须马上标记为已经访问
                            visited.add(nextWord);
                        }
                    }
                }
                // 恢复
                charArray[i] = originChar;
            }
            return false;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)


}