package com.example.demo.demo;


class Thread1 extends  Thread{
    private Object on;
    private String tnmame;

    public Thread1(Object on,String tname){
        this.on = on;
        this.tnmame = tname;
    }

    @Override
    public void run() {
        synchronized (on){
            for (int i=0;i<100;i++){
                System.out.println(tnmame+"---"+i);
            }
        }

    }

    public Object getOn() {
        return on;
    }

    public void setOn(Object on) {
        this.on = on;
    }

    public String getTnmame() {
        return tnmame;
    }

    public void setTnmame(String tnmame) {
        this.tnmame = tnmame;
    }
}
