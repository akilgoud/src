
//-*- mode:java; encoding:utf-8 -*-
// vim:set fileencoding=utf-8:
//http://terai.xrea.jp/Swing/RatingLabel.html
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.List;
import java.util.Arrays;
import javax.swing.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        super(new GridLayout(2,2));
        //PI Diagona Icons Pack 1.0 - Download Royalty Free Icons and Stock Images For Web & Graphics Design
        //http://www.freeiconsdownload.com/Free_Downloads.asp?id=60
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("31g.png"));
        ImageProducer ip = defaultIcon.getImage().getSource();

        // 1
        List<ImageIcon> list = Arrays.asList(
            makeStarImageIcon(ip, new float[]{1.0f,0.5f,0.5f}),
            makeStarImageIcon(ip, new float[]{0.5f,1.0f,0.5f}),
            makeStarImageIcon(ip, new float[]{1.0f,0.5f,1.0f}),
            makeStarImageIcon(ip, new float[]{0.5f,0.5f,1.0f}),
            makeStarImageIcon(ip, new float[]{1.0f,1.0f,0.5f}));
        add(makeStarRatingPanel("gap=0", new LevelBar(defaultIcon, list, 0)));

        // 2
        list = Arrays.asList(
            makeStarImageIcon(ip, new float[]{0.2f,0.5f,0.5f}),
            makeStarImageIcon(ip, new float[]{0.0f,1.0f,0.2f}),
            makeStarImageIcon(ip, new float[]{1.0f,1.0f,0.2f}),
            makeStarImageIcon(ip, new float[]{0.8f,0.4f,0.2f}),
            makeStarImageIcon(ip, new float[]{1.0f,0.1f,0.1f}));
        add(makeStarRatingPanel("gap=1+1", new LevelBar(defaultIcon, list, 1) {
           protected void repaintIcon(int index) {
                for(int i=0;i<labelList.size();i++)
                  labelList.get(i).setIcon(i<=index?iconList.get(index):defaultIcon);
                repaint();
            }
        }));

        // 3
        list = Arrays.asList(
            makeStarImageIcon(ip, new float[]{.6f,.6f,.0f}),
            makeStarImageIcon(ip, new float[]{.7f,.7f,.0f}),
            makeStarImageIcon(ip, new float[]{.8f,.8f,.0f}),
            makeStarImageIcon(ip, new float[]{.9f,.9f,.0f}),
            makeStarImageIcon(ip, new float[]{1.0f,1.0f,.0f}));
        add(makeStarRatingPanel("gap=2+2", new LevelBar(defaultIcon, list, 2)));

        // 4
        ImageIcon yStar = makeStarImageIcon(ip, new float[]{1.0f,1.0f,.0f});
        list = Arrays.asList(yStar, yStar, yStar, yStar, yStar);
        add(makeStarRatingPanel("gap=1+1", new LevelBar(defaultIcon, list, 1)));
        setPreferredSize(new Dimension(320, 240));
    }
    private JPanel makeStarRatingPanel(String title, final LevelBar label) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(BorderFactory.createTitledBorder(title));
        p.add(new JButton(new AbstractAction("clear") {
            @Override public void actionPerformed(ActionEvent e) {
                label.clear();
            }
        }));
        p.add(label);
        return p;
    }
    private ImageIcon makeStarImageIcon(ImageProducer ip, float[] filter) {
        return new ImageIcon(createImage(new FilteredImageSource(ip, new SelectedImageFilter(filter))));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("RatingLabel");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class LevelBar extends JPanel implements MouseListener, MouseMotionListener{
    private final int gap;
    protected final List<ImageIcon> iconList;
    protected final List<JLabel> labelList = Arrays.asList(
        new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
    );
    protected final ImageIcon defaultIcon;
    private int clicked = -1;
    public LevelBar(ImageIcon defaultIcon, List<ImageIcon> list, int gap) {
        super(new GridLayout(1, 5, gap*2, gap*2));
        this.defaultIcon = defaultIcon;
        this.iconList = list;
        this.gap = gap;
        for(JLabel l:labelList) {
            l.setIcon(defaultIcon);
            add(l);
        }
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void clear() {
        clicked = -1;
        repaintIcon(clicked);
    }
    public int getLevel() {
        return clicked;
    }
    public void setLevel(int l) {
        clicked = l;
        repaintIcon(clicked);
    }
    private int getSelectedIconIndex(Point p) {
        for(int i=0;i<labelList.size();i++) {
            Rectangle r = labelList.get(i).getBounds();
            r.grow(gap, gap);
            if(r.contains(p)) return i;
        }
        return -1;
    }
    protected void repaintIcon(int index) {
        for(int i=0;i<labelList.size();i++) {
            labelList.get(i).setIcon(i<=index?iconList.get(i):defaultIcon);
        }
        repaint();
    }
    @Override public void mouseMoved(MouseEvent e) {
        repaintIcon(getSelectedIconIndex(e.getPoint()));
    }
    @Override public void mouseEntered(MouseEvent e) {
        repaintIcon(getSelectedIconIndex(e.getPoint()));
    }
    @Override public void mouseClicked(MouseEvent e) {
        clicked = getSelectedIconIndex(e.getPoint());
    }
    @Override public void mouseExited(MouseEvent e) {
        repaintIcon(clicked);
    }
    @Override public void mouseDragged(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
}
class SelectedImageFilter extends RGBImageFilter {
    private final float[] filter;
    public SelectedImageFilter(float[] filter) {
        this.filter = filter;
        canFilterIndexColorModel = false;
    }
//     @Override public int filterRGB(int x, int y, int argb) {
//         Color color = new Color(argb, true);
//         float[] array = new float[4];
//         color.getComponents(array);
//         return new Color(array[0]*filter[0], array[1]*filter[1], array[2]*filter[2], array[3]).getRGB();
//     }
    @Override public int filterRGB(int x, int y, int argb) {
        int r = (int)(((argb >> 16) & 0xff) * filter[0]);
        int g = (int)(((argb >>  8) & 0xff) * filter[1]);
        int b = (int)(((argb      ) & 0xff) * filter[2]);
        return (argb & 0xff000000) | (r<<16) | (g<<8) | (b);
    }
}
