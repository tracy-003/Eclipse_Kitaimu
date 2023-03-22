import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

public class ScreenGPT extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;

    private Thread thread;
    private SimpleDateFormat dateFormat;
    private Font font;
    private Point mousePosition;
    
    private Color backgroundColor;
    private Color fontColor;

    public ScreenGPT() {
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        font = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        backgroundColor = Color.WHITE;
        fontColor = Color.BLACK;

        setPreferredSize(new Dimension(400, 300));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePosition = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point newPosition = e.getLocationOnScreen();
                Point oldPosition = getLocation();
                int dx = newPosition.x - mousePosition.x - oldPosition.x;
                int dy = newPosition.y - mousePosition.y - oldPosition.y;
                setLocation(oldPosition.x + dx, oldPosition.y + dy);
            }
        });

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(fontColor);
        g.setFont(font);
        String time = dateFormat.format(new Date());
        Rectangle rect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int x = rect.width - g.getFontMetrics().stringWidth(time) - 20;
        int y = rect.height - 50;
        g.drawString(time, x, y);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Clock");
        ScreenGPT clock = new ScreenGPT();
        frame.add(clock);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 255, 100));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
