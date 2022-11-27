package yi.obj;

import yi.until.GameUntil;
import yi.win.GameWin;

import java.awt.*;

/**
 * @aythor yi
 * @data 2022/11/25  10:15:34
 * @Description
 */
public class BossObj extends GameObj {

    int life = 10;

    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (x > 500 || x < -50) {
            speed = -speed;
        }
        x += speed;
        for (ShellObj shellObj : GameUntil.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {
                shellObj.setX(-100);
                shellObj.setY(100);
                GameUntil.removeList.add(shellObj);
                life--;
            }
            if (life <= 0) {
                GameWin.state = 4;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
