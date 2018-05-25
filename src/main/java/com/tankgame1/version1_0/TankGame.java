package com.tankgame1.version1_0;
/**
 * Author: 魏守鑫
 * Date: 2018/5/24
 * Description: 坦克游戏
 * Version: 1.0
 */

import javax.swing.*;
import java.awt.*;

public class TankGame extends JFrame{
    MyPannel mp;

    public TankGame(){
        mp = new MyPannel();

        this.add(mp);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame tg = new TankGame();
    }
}

//我的画板
class MyPannel extends JPanel{
    MyTank myTank;

    public MyPannel() {
        myTank = new MyTank(100, 100);
    }

    //重写paint方法
    public void paint(Graphics g){
        super.paint(g);

        //设置背景颜色为黑色
        g.fillRect(0,0,400,300);
        drawTank(myTank.getX(),myTank.getY(),g,0,0);
    }

    //画出坦克,direct(0~3):表示坦克方向为上下左右, type(0~1)：表示己方和对方坦克
    public void drawTank(int x, int y, Graphics g, int direct, int type){
        ////设置颜色,敌方CYAN，己方yellow
        switch(type){
            case 0:
                g.setColor(Color.yellow);
                break;
            case 1:
                g.setColor(Color.CYAN);
                break;
        }
        switch(direct){
            case 0:
                //左边的矩形
                g.fill3DRect(x,y,5,30,false);
                //右边的矩形
                g.fill3DRect(x+15,y,5,30,false);
                //中间的矩形
                g.fill3DRect(x+5,y+5,10,20,false);
                //中间的圆
                g.fillOval(x+5,y+10, 10,10);
                //中间的线
                g.drawLine(x+10,y+15,x+10,myTank.getY());

                break;

        }
    }
}

//坦克类
class Tank{
    //坦克在屏幕的横坐标
    int x = 0 ;
    //坦克在屏幕的纵坐标
    int y = 0;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

//自己的坦克
class MyTank extends Tank{
    public MyTank(int x, int y) {
        super(x, y);
    }
}

