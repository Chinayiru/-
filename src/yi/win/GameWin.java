package yi.win;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import yi.obj.*;
import yi.until.GameUntil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @aythor yi
 * @data 2022/11/24  14:35:32
 * @Description
 */
public class GameWin extends JFrame {

    //    界面 0 开始 1 暂停 2
    public static int state = 0;
    //        双缓存图片
    Image offScreenImage = null;
    //    背景
    int width = 450;
    int height = 700;
    //    子弹重绘次数
    int count = 1;
    //    得分
    public static int score = 0;

    //    敌机数量
    int enemyCount = 0;

    BgObj bgobj = new BgObj(GameUntil.bgImg, 0, -1000, 2);
    //    我方飞机
    public PlaneObj planeObj = new PlaneObj(GameUntil.planeImg, 200, 550, 20, 30, 0, this);
    //    敌方boss
    public BossObj bossObj = null;//new BossObj(GameUntil.bossImg, 250, 35, 155, 100, 5, this);


    public void launch() {
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setTitle("飞机大战");


        GameUntil.gameObjList.add(bgobj);
        GameUntil.gameObjList.add(planeObj);
//        GameUntil.gameObjList.add(bossObj);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                    repaint();
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 32) {
                    switch (state) {
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                        default:

                    }
                }
            }
        });
        while (true) {
            if (state == 1) {
                createObj();
                repaint();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, width, height);
        if (state == 0) {
            gImage.drawImage(GameUntil.bgImg, 0, 0, null);
            gImage.drawImage(GameUntil.logeImg, -60, 60, null);
            gImage.drawImage(GameUntil.bossImg, 125, 160, null);
            GameUntil.drawWord(gImage, "点击任意位置开始", Color.yellow, 20, 135, 500);
//            gImage.setColor(Color.yellow);
//            gImage.setFont(new Font("仿宋", Font.BOLD, 20));
//            gImage.drawString("点击任意位置开始", 135, 500);
        }

        if (state == 1) {
//            bgobj.paintSelf(gImage);
//            planeObj.paintSelf(gImage);
            for (int i = 0; i < GameUntil.gameObjList.size(); i++) {
                GameUntil.gameObjList.get(i).paintSelf(gImage);
            }
            GameUntil.gameObjList.removeAll(GameUntil.removeList);
        }
        if (state == 3) {
//            失败
            gImage.drawImage(GameUntil.bgImg, 0, 0, null);
            GameUntil.drawWord(gImage, "失败", Color.RED, 20, 135, 500);
//            gImage.setColor(Color.RED);
//            gImage.setFont(new Font("仿宋", Font.BOLD, 20));
//            gImage.drawString("失败", 135, 500);
        }

        if (state == 4) {
//            通过
            gImage.drawImage(GameUntil.bgImg, 0, 0, null);
            GameUntil.drawWord(gImage, "成功", Color.RED, 20, 135, 500);

        }


        GameUntil.drawWord(gImage, score + "分", Color.green, 20, 30, 100);
        g.drawImage(offScreenImage, 0, 0, null);
        count++;
        System.out.println(GameUntil.gameObjList.size());
    }

    //    批量创建敌机和子弹
    void createObj() {
        //    我方子弹
        if (count % 15 == 0) {
            GameUntil.shellObjList.add(new ShellObj(GameUntil.shellImg, planeObj.getX() + 3, planeObj.getY() - 16, 14, 29, 5, this));
            GameUntil.gameObjList.add(GameUntil.shellObjList.get(GameUntil.shellObjList.size() - 1));
        }

        //    敌方飞机
        if (count % 15 == 0) {
            GameUntil.enemyObjList.add(new EnemyObj(GameUntil.EnemyImg, (int) (Math.random() * 12) * 50, 0, 197, 134, 5, this));
            GameUntil.gameObjList.add(GameUntil.enemyObjList.get(GameUntil.enemyObjList.size() - 1));
            enemyCount++;
        }

        //        敌方子弹
        if (count % 15 == 0 && bossObj != null) {
            GameUntil.bulletObjList.add(new BulletObj(GameUntil.bulletImg, bossObj.getX() + 65, bossObj.getY() + 130, 15, 25, 5, this));
            GameUntil.gameObjList.add(GameUntil.bulletObjList.get(GameUntil.bulletObjList.size() - 1));
        }

        if (enemyCount > 20 && bossObj == null) {
            bossObj = new BossObj(GameUntil.bossImg, 250, 35, 155, 100, 5, this);
            GameUntil.gameObjList.add(bossObj);
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
