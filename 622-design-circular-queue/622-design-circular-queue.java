class MyCircularQueue {
    final int[] q;
    private int headIdx,cnt,sz;
    public MyCircularQueue(int k) {
        q=new int[k];
        
        cnt = 0;
        sz=k;
        headIdx=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        
        q[(headIdx+cnt)%sz] = value;
        cnt++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        headIdx=(headIdx+1)%sz;
        cnt=cnt-1;
        return true;
    }
    
    public int Front() {
        if(isEmpty())return -1;
        return q[headIdx];
    }
    
    public int Rear() {
        if(isEmpty())return -1;
        
        return q[(headIdx+cnt-1)%sz];
    }
    
    public boolean isEmpty() {
        return cnt==0;
    }
    
    public boolean isFull() {
        return cnt==sz;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */