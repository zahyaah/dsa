import java.util.*; 

class MyStack {
    private Queue<Integer> first; 
    private Queue<Integer> second; 

    public MyStack() {
        this.first = new LinkedList<>(); 
        this.second = new LinkedList<>();     
    }
    
    public void push(int x) {
        // add new element to the second queue
        second.offer(x);
        
        // transfr all elements from first to second
        while (!first.isEmpty()) {
            second.offer(first.poll());
        }
        
        // swap the queues
        Queue<Integer> temp = first;
        first = second;
        second = temp;
    }
    
    public int pop() {
        if (empty()) 
            throw new RuntimeException("Stack is Empty");
        
        return first.poll(); 
    }
    
    public int top() {
        if (empty()) 
            throw new RuntimeException("Stack is Empty");
        
        return first.peek(); 
    }
    
    public boolean empty() {
        return first.isEmpty(); 
    }
}

public class Solution {
    public static void main(String[] args) {
        MyStack m = new MyStack(); 
        m.push(10);
        m.push(20);
        System.out.println(m.pop());
        System.out.println(m.empty());
        m.pop(); 
        System.out.println(m.empty());
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */