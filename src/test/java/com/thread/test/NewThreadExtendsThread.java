package com.thread.test;

public class NewThreadExtendsThread extends Thread {

    private String name;

    public NewThreadExtendsThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.printf("%s is running %d\n", name, i);

        }
    }
}

