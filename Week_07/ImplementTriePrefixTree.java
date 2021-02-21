package com.homework.week07;

/**
 * Java：✔[208]实现 Trie (前缀树)
 **/


public class ImplementTriePrefixTree {
    //实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 523 👎 0

    public static void main(String[] args) {
//        Solution solution = new ImplementTriePrefixTree().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private boolean endFlag;

        private Trie[] children;

        public Trie() {
            this.children = new Trie[26];
        }

        public void insert(String word) {

            if (null != word && word.length() > 0) {
                int len = word.length();
                Trie current = this;
                for (int i = 0; i < len; i++) {
                    int index = word.charAt(i) - 'a';
                    if (null == current.children[index]) {
                        current.children[index] = new Trie();
                    }
                    current = current.children[index];
                }
                current.endFlag = Boolean.TRUE;
            }
        }

        private Trie checkPrefix(String prefix) {

            if (null != prefix && prefix.length() > 0) {
                int len = prefix.length();
                Trie current = this;
                for (int i = 0; i < len; i++) {
                    int index = prefix.charAt(i) - 'a';
                    current = current.children[index];
                    if (null == current) {
                        return null;
                    }
                }
                return current;
            }
            return null;
        }


        public boolean search(String word) {

            Trie trie = this.checkPrefix(word);
            return null != trie && trie.endFlag;
        }

        public boolean startsWith(String prefix) {

            Trie trie = this.checkPrefix(prefix);
            return null != trie;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)















//    class Trie {
//
//        private boolean endFlag;
//
//        private Trie[] children;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public Trie() {
//            this.children = new Trie[26];
//        }
//
//        /**
//         * Inserts a word into the trie.
//         */
//        public void insert(String word) {
//            if (null != word && word.length() > 0) {
//                Trie current = this;
//                int len = word.length();
//                for (int i = 0; i < len; i++) {
//                    int index = word.charAt(i) - 'a';
//                    if (null == current.children[index]) {
//                        current.children[index] = new Trie();
//                    }
//                    current = current.children[index];
//                }
//                current.endFlag = Boolean.TRUE;
//            }
//        }
//
//        private Trie checkPrefix(String prefix) {
//
//            Trie trie;
//            if (null != prefix && prefix.length() > 0) {
//                trie = this;
//                int len = prefix.length();
//                for (int i = 0; i < len; i++) {
//                    int index = prefix.charAt(i) - 'a';
//                    trie = trie.children[index];
//                    if (null == trie) {
//                        return null;
//                    }
//                }
//            } else {
//                trie = null;
//            }
//            return trie;
//        }
//
//        /**
//         * Returns if the word is in the trie.
//         */
//        public boolean search(String word) {
//
//            Trie trie = this.checkPrefix(word);
//            return null != trie && trie.endFlag;
//        }
//
//        /**
//         * Returns if there is any word in the trie that starts with the given prefix.
//         */
//        public boolean startsWith(String prefix) {
//
//            Trie trie = this.checkPrefix(prefix);
//            return null != trie;
//        }
//    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}