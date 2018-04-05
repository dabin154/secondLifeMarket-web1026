package com.thread.test;

public class NewThreadExtendsThread extends Thread{
    
    private String name;                 
    
    public NewThreadExtendsThread(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        super.run();
    }
    
    

}
