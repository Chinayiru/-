package yi.obj;

import yi.until.GameUntil;
import yi.win.GameWin;

import java.awt.*;

/**
 * @aythor yi
 * @data 2022/11/25  10:21:16
 * @Description
 */
public class BulletObj extends GameObj {
    public BulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if (this.getRec().intersects(this.frame.planeObj.getRec())) {
            GameWin.state = 3;
        }
        if (y > 700) {
            this.x = -300;
            this.y = 300;
            GameUntil.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
