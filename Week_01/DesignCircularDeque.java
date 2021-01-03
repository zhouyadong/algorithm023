package com.homework.week01;

/**
 * Java：设计循环双端队列
 **/
public class DesignCircularDeque {
    //设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 68 👎 0

    public static void main(String[] args) {
        MyCircularDeque solution = new DesignCircularDeque().new MyCircularDeque(10);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {

        //默认无效值
        private static final int defaultValue = -1;
        //底层使用数组实现
        private int[] dataArray;

        //定义容量大小：其中size-1为实际容量,始终在末位存在一个空位
        private int size;

        //头指针：当在前面增加元素时，head--，删除时，head++；应为是循环双向队列，注意消除负数计算相对位置
        private int head;

        //尾指针：当在后面增加元素时 tail++，删除时，tail--；应为是循环双向队列，注意消除负数计算相对位置
        private int tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.size = k + 1;
            dataArray = new int[this.size];
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            boolean ret = Boolean.FALSE;
            if (!this.isFull()) {
                this.head = (this.head -1 + this.size) % this.size;
                dataArray[this.head] = value;
                ret = Boolean.TRUE;
            }

            return ret;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            boolean ret = Boolean.FALSE;
            if (!this.isFull()) {
                dataArray[this.tail] = value;
                this.tail = (this.tail + 1) % this.size;
                ret = Boolean.TRUE;
            }

            return ret;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            boolean ret = Boolean.FALSE;
            if (!this.isEmpty()) {
                this.head = (this.head + 1) % this.size;
                ret = Boolean.TRUE;
            }

            return ret;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {

            boolean ret = Boolean.FALSE;
            if (!this.isEmpty()) {
                this.tail = ((this.tail - 1) + this.size) % this.size;
                ret = Boolean.TRUE;
            }

            return ret;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {

            if (this.isEmpty()) {
                return defaultValue;
            }
            return this.dataArray[this.head];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {

            if (this.isEmpty()) {
                return defaultValue;
            }
            //消除tail=0
            int index = ((this.tail - 1) + this.size) % this.size;
            return this.dataArray[index];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {

            return this.head == this.tail;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {

            return ((this.tail + 1) % this.size) == this.head;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)


}