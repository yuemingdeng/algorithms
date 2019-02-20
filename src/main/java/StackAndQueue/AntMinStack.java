package StackAndQueue;

import java.util.Stack;

public class AntMinStack {
    Stack<Integer> stack; //存储值
    Stack<Integer> min;//存储最小值

    public AntMinStack(){
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int data){
        stack.push(data);
        if (min.isEmpty() || data <= min.peek()){
            min.push(data);
        }
    }
    public int pop() throws Exception{
        if (stack.isEmpty()){
            throw new Exception("EmptyStackException");
        }
        if (stack.peek() == min.peek()){
            min.pop();
        }
        return stack.pop();
    }
    public int min() throws Exception {
        if (min.isEmpty()) {
            throw new Exception("EmptyStackException");
        }
        return min.peek();
    }

    public static void main(String[] args) throws Exception{
        AntMinStack antMinStack = new AntMinStack();
        for (int i = 20; i >= 0; i--) {
            antMinStack.push(i);
            System.out.println("入栈："+i+",最小值为："+antMinStack.min());
        }
        for (int i = 0; i <= 19; i++) {
            System.out.println("出栈："+antMinStack.pop()+"最小值为："+antMinStack.min());
        }
    }
}
