package yi.obj;

import yi.win.GameWin;

import java.awt.*;

/**
 * @aythor yi
 * @data 2022/11/24  15:24:28
 * @Description
 */
public class BgObj extends GameObj {
    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public BgObj() {
        super();
    }

    @Override
    public void paintSelf(Graphics gImages) {
        super.paintSelf(gImages);
        y += speed;
        if (y >= 0) {
            y = -200;
        }
    }
}
