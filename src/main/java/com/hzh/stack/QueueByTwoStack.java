package com.hzh.stack;

public class QueueByTwoStack<E extends Object> {
    private ArrayStack<E> stackPre;
    private ArrayStack<E> stackPost;

    int head,tail;

    public QueueByTwoStack(){
        stackPre = new ArrayStack<>();
        stackPost = new ArrayStack<>();
    }

    public void enQueue(E data){
        try {
            stackPre.push(data);
        }catch (IndexOutOfBoundsException var0){
            System.out.println("第一个栈已满，数据转移");
            if(stackPost.isFull()){
                throw new IndexOutOfBoundsException("队满");
            }
            while (!stackPre.isEmpty()){
                stackPost.push(stackPre.pop());
            }
        }
    }

    public E deQueue(){
        E deMember = null;
        try{
            deMember = stackPost.pop();
        }catch (IndexOutOfBoundsException var1){
            System.out.println("第二个栈为空，从第一个栈拉取数据");
            if(stackPre.isEmpty()){
                throw new IndexOutOfBoundsException("队空");
            }
            while(!stackPre.isEmpty()){
                stackPost.push(stackPre.pop());
            }
            deMember = stackPost.pop();
        }
        return deMember;
    }
}
