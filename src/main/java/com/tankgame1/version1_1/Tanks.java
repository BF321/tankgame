package com.tankgame1.version1_1;

/**
 * Author: 魏守鑫
 * Date: 2018/5/25
 * Description: 所有的坦克类
 * Version:
 */

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
class MyTank extends Tank{
    public MyTank(int x, int y) {
        super(x, y);
        type = 0;
    }

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

class EnemyTank extends Tank{
    public EnemyTank(int x, int y) {
        super(x, y);
        type = 1;
    }
}

