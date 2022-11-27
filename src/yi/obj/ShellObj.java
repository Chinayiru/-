package yi.obj;

import yi.until.GameUntil;
import yi.win.GameWin;

import java.awt.*;

/**
 * @aythor yi
 * @data 2022/11/24  16:32:12
 * @Description
 */
public class ShellObj extends GameObj {
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -= speed;

        if (y < 0) {
            this.x = -100;
            this.y = 100;
            GameUntil.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
