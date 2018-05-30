package com.tankgame2.version2_0;

/**
 * Author: 魏守鑫
 * Date: 2018/5/30
 * Description: 所有的成员类
 * Version: 2.0
 */

//子弹类
class Shot implements Runnable{
    int x;
    int y;
    int direct;
    int speed = 5;

    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true){
            //延时50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x -= speed;
                    break;
                case 3:
                    x += speed;
                    break;
            }

            //判断子弹何时死亡
            if (x<0||x>400||y<0||y>300){
                isLive = false;
                break;
            }

        }
    }
}

//坦克类
class  Tank{
    //坦克在屏幕的横坐标
    int x = 0 ;
    //坦克在屏幕的纵坐标
    int y = 0;
    //坦克的移动速度
    int speed = 5;
    //坦克的方向 0~3:上下左右
    int direct = 0;
    //坦克的类型，0：己方，1：敌方
    int type;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

//自己的坦克
class MyTank extends Tank {
    //子弹
    Shot s = null;

    public MyTank(int x, int y) {
        super(x, y);
        type = 0;
    }

    //开火
    public void shotEnemy(){

        switch (direct){
            case 0:
                s = new Shot(x+10, y, 0);
                break;

            case 1:
                s = new Shot(x+10, y+30, 1);
                break;

            case 2:
                s = new Shot(x, y+10, 2);
                break;

            case 3:
                s = new Shot(x+30, y+10, 3);
                break;
        }

        //启动子弹线程
        Thread t = new Thread(s);
        t.start();

    }

    //向上移动
    public void moveUp(){
        y -= speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }

    public void moveRight(){
        x += speed;
    }
}

class EnemyTank extends Tank {
    public EnemyTank(int x, int y) {
        super(x, y);
        type = 1;
    }
}

