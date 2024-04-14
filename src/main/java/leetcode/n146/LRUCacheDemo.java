package leetcode.n146;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenfei7 on 2024/4/14.
 */
public class LRUCacheDemo {

    Map<Integer, Node<Integer, Integer>> map;

    //map负责查找，构建一个虚拟的双向链表，它里面安放的是一个个Node节点，作为数据载体。
    DoubleLinkedList doubleLinkedList;
    private int capacity;

    public LRUCacheDemo(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.remove(node);
        doubleLinkedList.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, new Node<>(key, value));

            doubleLinkedList.remove(map.get(key));
            doubleLinkedList.add(map.get(key));
        } else {
            if (map.size() == capacity) {
                map.remove(doubleLinkedList.getLast().key);
                doubleLinkedList.remove(doubleLinkedList.getLast());
            }
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.add(node);
        }
    }

    //1.构建一个Node节点，作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    //2.构建一个虚拟的双向链表，里面安放的就是我们的Node
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        //2.1 构造方法
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //2.2 添加到头
        public void add(Node<K, V> node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        //2.3 删除节点
        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        //2.4 获得最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(2);
        lruCacheDemo.put(1, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(2, 2);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(4, 4);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.get(3);
        System.out.println(lruCacheDemo.map.keySet());

    }

}
