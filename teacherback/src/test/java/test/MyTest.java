package test;

import com.neuedu.util.ControllerUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyTest {
    public static void main(String[] args) throws Exception {
        BufferedImage qrCode = ControllerUtil.createQRCode("http://www.traning-ai.cn/online",158,158,0);
        BufferedImage cover = ImageIO.read(new File("D:\\8.jpg"));
        BufferedImage tag = new BufferedImage(750 , 1497, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = tag.createGraphics();
        graphics.drawImage(cover, 0,0,750,1497,null);
        graphics.drawImage(qrCode,498,1225,158,158,null);
        ImageIO.write(tag,"png",new File("d:\\fda.png"));
    }
}
