import javax.swing.*;
import java.awt.*;

/**
 * @author ziv
 * @date 2019/12/24  9:29
 */
class ImagePanel extends JPanel{
    private Image image;
    private int width;
    private int height;
    ImagePanel(Image image, int width, int height){
        this.image = image;
        this.width = width;
        this.height = height;
        //setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, width, height,this);
    }
}
class BackgroundPanel extends JLabel {
    private static final long serialVersionUID = -6352788025440244338L;
    private Image image = null;
    public BackgroundPanel(Image image) {
        this.image = image;
    }
    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件  
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public static void main(String[] args){
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
//        panel.setLayout(null);

        // 创建 JLabel
        Image image=new ImageIcon("sensor.png").getImage();
        JPanel jPanel = new ImagePanel(image,200,200);
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        panel.add(jPanel);
    }
}

//public class image extends JFrame{
//
//    private JPanel jpanel;
//    private ImageIcon imageIcon;
//    private JLabel imageLabel;
//
//    public image(){
//        imageIcon = new ImageIcon("sensor.png"); //写入文件路径
//        imageLabel = new JLabel(imageIcon);  //初始化JLabel
//        jpanel = new JPanel();
//        this.add(BorderLayout.CENTER,jpanel);
//        this.setVisible(true); //设置为显示
//        this.pack();
//        //设置jframe的大小
//        this.setBounds(new Rectangle(100,100,imageIcon.getIconWidth(),imageIcon.getIconHeight()));
//        jpanel.add(BorderLayout.CENTER,imageLabel);
//    }
//    public static void main(String[] args){
//        image testJPanel = new image();
//    }
//}
