[TOC]

# 1.Queue分析
	队列是只允许在一端进行插入操作，而在另一端进行删除操作的线性表。
	插入的一端称为队尾，删除的一端称为队头。

## 1.1.源码分析
	Queue是一个接口，定义了6个操作来实现增、删、查，同时继承了Collection接口。

### 1.1.1.增	
	boolean add (E e);
	boolean offer (E e);

	相同点：都可以添加元素，接口都可能抛出:ClassCastException、NullPointerException、IllegalArgumentException。
	区别：当超出容量限制时，add接口抛出IllegalStateException，而offer在这种情况下返回false。
	
### 1.1.2.删
	E remove ()
	E poll ()

	相同点：返回队列头部元素，并删除该元素
	区别： 如果队列为空，remove抛出异常NoSuchElementException，poll返回null。

### 1.1.3.查		
	E element();
	E peek();

	相同点：返回队列头部元素，不删除该元素
	区别： 如果队列为空，element抛出异常NoSuchElementException，peek返回null。

# 2.PriorityQueue分析

	PriorityQueue是一个优先队列，与FIFO队列的区别在于，优先队列每次出队的元素都是优先级最高的元素，而元素的优先级由Comparator指定。

	jdk中使用堆来维护元素的优先级。

## 2.1.定义

<code>
public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {

</code>

	PriorityQueue继承了AbstractQueue并实现了Serializable接口，AbstractQueue实现了Queue。

## 2.2.
