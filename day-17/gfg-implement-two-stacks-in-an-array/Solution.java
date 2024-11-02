class twoStacks {
    private int[] arr; 
    private int top1, top2, size; 

    twoStacks() {
        this.size = 100; 
        this.arr = new int[size];
        this.top1 = -1; 
        this.top2 = size; 
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        if (top1 < top2-1) {
            top1++; 
            arr[top1] = x; 
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if (top1 < top2-1) {
            top2--; 
            arr[top2] = x; 
        }
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        }
        return -1; 
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if (top2 < size)
            return arr[top2++];
        return -1; 
    }
}


public class Solution {
    public static void main(String[] args) {
        twoStacks ok = new twoStacks(); 
        ok.push1(2);
        ok.push1(3);
        ok.push2(4);
        System.out.println(ok.pop1());
        System.out.println(ok.pop2());
        System.out.println(ok.pop2());
    }
}