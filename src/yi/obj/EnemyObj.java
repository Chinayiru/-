package yi.obj;

import yi.until.GameUntil;
import yi.win.GameWin;

import java.awt.*;

/**
 * @aythor yi
 * @data 2022/11/24 itime
 * @Description
 */
public class EnemyObj extends GameObj {
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
//        敌方碰撞我方
        if (this.getRec().intersects(this.frame.planeObj.getRec())) {
            GameWin.state = 3;
        }
        if (y>700) {
            this.x = -200;
            this.y = 200;
            GameUntil.removeList.add(this);
        }
//        碰撞检查
        for (ShellObj shellObj : GameUntil.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {
//                System.out.println("1");
//                敌机检查
                shellObj.setX(-50);
                shellObj.setY(50);
                this.x = -200;
                this.y = 200;
                GameUntil.removeList.add(shellObj);
                GameUntil.removeList.add(this);
                GameWin.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
