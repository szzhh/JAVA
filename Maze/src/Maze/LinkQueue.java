package Maze;

public class LinkQueue<T> {
    // 指向头节点(队头)
    private Entry<T> front;
    // 指向尾节点(队尾)
    private Entry<T> rear;
    // 记录队列节点的个数
    private int count;

    /**
     * 初始化，front和rear都指向头节点
     */
    public LinkQueue(){
        this.front = this.rear = new Entry<>(null, null);
    }

    /**
     * 入队操作
     * @param val
     */
    public void offer(T val){
        Entry<T> node = new Entry<>(val, null);
        this.rear.next = node;
        this.rear = node;
        this.count++;
    }

    /**
     * 出队操作
     * @return
     */
    public T poll(){
        T val = null;
        if(this.front.next != null){
            val = this.front.next.data;
            this.front.next = this.front.next.next;
            // 删除队列最后一个元素，要把rear指向front，队列才能判空
            if(this.front.next == null){
                this.rear = this.front;
            }
            this.count--;
        }
        return val;
    }

    public T peek(){
        T val = null;
        if(this.front.next != null){
            val = this.front.next.data;
        }
        return val;
    }

    /**
     * 判断队列空
     * @return
     */
    public boolean isEmpty(){
        return this.front == this.rear;
    }

    /**
     * 返回队列元素的个数
     * @return
     */
    public int size(){
        return this.count;
    }

    /**
     * 节点类型定义
     * @param <T>
     */
    static class Entry<T>{
        T data;
        Entry<T> next;

        public Entry(T data, Entry<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}