package com.tankgame1.version1_1;

/**
 * Author: 魏守鑫
 * Date: 2018/5/25
 * Description: 坦克游戏，己方坦克能移动
 * Version: 1.1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class TankGame extends JFrame{
    MyPannel mp;

    public TankGame(){
        mp = new MyPannel();

        this.add(mp);

        this.addKeyListener(mp);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame tg = new TankGame();
    }
}

//我的画板
class MyPannel extends JPanel implements KeyListener {
    MyTank myTank = null;
    Vector<EnemyTank> enemyTank = new Vector<EnemyTank>();
    int enemyTankNumber = 3;    //敌方坦克数量

    public MyPannel() {
        myTank = new MyTank(100, 100);

        for(int i=0; i<enemyTankNumber; i++){
            EnemyTank et = new EnemyTank((i+1)*50,0);
            enemyTank.add(et);
        }
    }

    //重写paint方法
    public void paint(Graphics g){
        super.paint(g);

        //设置背景颜色为黑色
        g.fillRect(0,0,400,300);
        //创建自己的坦克
        drawTank(myTank.getX(),myTank.getY(),g,myTank.getDirect(),myTank.type);
        //创建敌方坦克
        for (int i=0; i<enemyTank.size(); i++){
            EnemyTank et = enemyTank.get(i);
            drawTank(et.getX(),et.getY(),g,et.getDirect(),et.type);
        }
    }

    //画出坦克,direct(0~3):表示坦克方向为上下左右, type(0~1)：表示己方和对方坦克
    public void drawTank(int x, int y, Graphics g, int direct, int type){
        //设置颜色,敌方CYAN，己方yellow
        switch(type){
            case 0:
                g.setColor(Color.yellow);
                break;
            case 1:
                g.setColor(Color.CYAN);
                break;
        }
        switch(direct){
            case 0:  //向上
                //左边的矩形
                g.fill3DRect(x,y,5,30,false);
                //右边的矩形
                g.fill3DRect(x+15,y,5,30,false);
                //中间的矩形
                g.fill3DRect(x+5,y+5,10,20,false);
                //中间的圆
                g.fillOval(x+5,y+10, 10,10);
                //中间的线
                g.drawLine(x+10,y+15,x+10,y);

                break;

            case 1:  //向下
                //左边的矩形
                g.fill3DRect(x,y,5,30,false);
                //右边的矩形
                g.fill3DRect(x+15,y,5,30,false);
                //中间的矩形
                g.fill3DRect(x+5,y+5,10,20,false);
                //中间的圆
                g.fillOval(x+5,y+10, 10,10);
                //中间的线
                g.drawLine(x+10,y+15,x+10,y+30);

                break;

            case 2:  //向左
                g.fill3DRect(x,y,30,5,false);
                g.fill3DRect(x,y+15,30,5,false);
                g.fill3DRect(x+5,y+5,20,10,false);
                g.fillOval(x+10,y+5, 10,10);
                g.drawLine(x+15,y+10,x,y+10);

                break;

            case 3:  //向右
                g.fill3DRect(x,y,30,5,false);
                g.fill3DRect(x,y+15,30,5,false);
                g.fill3DRect(x+5,y+5,20,10,false);
                g.fillOval(x+10,y+5, 10,10);
                g.drawLine(x+15,y+10,x+30,y+10);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            myTank.setDirect(0);
            myTank.moveUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            myTank.setDirect(1);
            myTank.moveDown();
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            myTank.setDirect(2);
            myTank.moveLeft();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            myTank.setDirect(3);
            myTank.moveRight();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

