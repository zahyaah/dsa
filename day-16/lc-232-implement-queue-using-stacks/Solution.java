import java.util.*; 
class MyQueue {
    private Stack<Integer> first; 
    private Stack<Integer> second; 
    public MyQueue() {
        this.first = new Stack<>(); 
        this.second = new Stack<>(); 
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {      
        if (empty()) 
            throw new RuntimeException("Queue is empty");  
        
        if (second.isEmpty()) {
            while (!first.isEmpty())
                second.push(first.pop());
        }
        return second.pop(); 
    }
    
    public int peek() {
        if (empty())
            throw new RuntimeException("Queue is empty");
        if (second.isEmpty()) {
            while (!first.isEmpty())
                second.push(first.pop());
        }
        return second.peek();
    }
    
    public boolean empty() {
        return first.isEmpty() && second.isEmpty(); 
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue n = new MyQueue(); 
        n.push(10);
        n.push(20);

        System.out.println(n.pop());
        System.out.println(n.peek());
        System.out.println(n.empty());
        n.pop(); 
        n.pop();
    }
}