package yi.until;

import yi.obj.BulletObj;
import yi.obj.EnemyObj;
import yi.obj.GameObj;
import yi.obj.ShellObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @aythor yi
 * @data 2022/11/24  14:42:43
 * @Description
 */
public class GameUntil {
    //    背景图片
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("static/imgs/星云1(xingyun1)_爱给网_aigei_com.jpg");

    //    敌机图片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("static/imgs/A4-3(a4-3)_爱给网_aigei_com.png");

    //    爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("static/imgs/wsparticle 烟03(wsparticle_smok_爱给网_aigei_com.png");

    //    LOGE图片
    public static Image logeImg = Toolkit.getDefaultToolkit().getImage("static/imgs/徽标(LOGO)_爱给网_aigei_com.png");

    //    自飞机1
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("static/imgs/smallplane 封面(smallplane_cover_爱给网_aigei_com.png");

    //    敌方飞机
    public static Image EnemyImg = Toolkit.getDefaultToolkit().getImage("static/imgs/A2-2(a2-2)_爱给网_aigei_com.png");

    //    我方子弹
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("static/imgs/wsparticle tailinga_0(wspartic_爱给网_aigei_com.png");

    //    敌方子弹
    public static Image bulletImg = Toolkit.getDefaultToolkit().getImage("static/imgs/wsparticle_24_爱给网_aigei_com.png");

    //    所有物体集合
    public static List<GameObj> gameObjList = new ArrayList<>();

    //    子弹集合
    public static List<ShellObj> shellObjList = new ArrayList<>();

    //    敌机集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();

    //    敌方子弹集合
    public static List<BulletObj> bulletObjList = new ArrayList<>();

    //    输出元素集合
    public static List<GameObj> removeList = new ArrayList<>();

    //    绘制字符串的工具类
    public static void drawWord(Graphics gImage, String str, Color color, int size, int x, int y) {
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }
}
