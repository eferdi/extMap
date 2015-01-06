import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.util.*;

class DisplayCanvas extends JPanel implements MouseListener
{
    private int currRefX = 0, currRefY = 0;
    private int currPosX = 0, currPosY = 0;
    private int markerPlayerX = 1800, markerPlayerY = 1300;
    private double scaleBy = 1;
    private double scaleMax = 3;
    private double scaleMin = 0.2;
    private  Vector markers = new Vector();
    private Image map = getToolkit().getImage("C:\\Users\\Edward Teach\\Pictures\\stratis.jpg");
    private Image markerPlayer = getToolkit().getImage("C:\\Users\\Edward Teach\\Pictures\\marker_test.gif");

    public DisplayCanvas()
    {
        setBackground(Color.green);
        setSize(900, 800);
        addMouseListener(this);

        addMouseWheelListener(new MouseAdapter()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                super.mouseWheelMoved(e);
                //TODO zoom into mouse position
                if(e.getWheelRotation() > 0)
                {
                    decrement();
                }
                else
                {
                    increment();
                }
            }
        });

        addMouseMotionListener(new MouseInputListener()
        {
            @Override
            public void mouseEntered(MouseEvent me) {}
            @Override
            public void mouseExited(MouseEvent me) {}
            @Override
            public void mouseClicked(MouseEvent mea) {}
            @Override
            public void mouseReleased(MouseEvent me) {}
            @Override
            public void mousePressed(MouseEvent me) {}
            @Override
            public void mouseMoved(MouseEvent me) {}
            @Override
            public void mouseDragged(MouseEvent me)
            {
                moveMapWithMouse(me.getX(), me.getY());
                repaint();
            }
        });

        MediaTracker mt = new MediaTracker(this);
        mt.addImage(map, 0);
        mt.addImage(markerPlayer, 1);
        try
        {
            mt.waitForAll();
        }
        catch (Exception e)
        {
            System.out.println("Exception while loading map and markers.");
        }
    }

    private void moveMapWithMouse(int mouseX, int mouseY)
    {
        //TODO link the scale factor with the moveXY values
        if (currRefX != mouseX)
        {
            int markerPlayerNewPosX = markerPlayerX;
            int moveXBy = +(mouseX - currRefX);
            if (moveXBy < 0)
            {
                moveXBy = moveXBy * -1;
            }
            if (currRefX > mouseX)
            {
                currPosX -= moveXBy;
                markerPlayerNewPosX -= moveXBy;
                currRefX = mouseX;
            }
            else
            {
                currPosX += moveXBy;
                markerPlayerNewPosX += moveXBy;
                currRefX = mouseX;
            }


            if (currPosX > 0)
            {
                currPosX = 0;
            }
            else
            {
                markerPlayerX = markerPlayerNewPosX;
            }
        }

        if (currRefY != mouseY)
        {
            int markerPlayerNewPosY = markerPlayerY;
            int moveYBy = +(mouseY - currRefY);
            if (moveYBy < 0)
            {
                moveYBy = moveYBy * -1;
            }
            if (currRefY > mouseY)
            {
                currPosY -= moveYBy;
                markerPlayerNewPosY -= moveYBy;
                currRefY = mouseY;
            }
            else
            {
                currPosY += moveYBy;
                markerPlayerNewPosY += moveYBy;
                currRefY = mouseY;
            }

            if(currPosY > 0)
            {
                currPosY = 0;
            }
            else
            {
                markerPlayerY = markerPlayerNewPosY;
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        g2D.transform(AffineTransform.getScaleInstance(this.scaleBy, this.scaleBy));
        g2D.drawImage(map, currPosX, currPosY, map.getWidth(this), map.getHeight(this), null);
        g2D.drawImage(markerPlayer, markerPlayerX, markerPlayerY, markerPlayer.getWidth(this), markerPlayer.getHeight(this), null);
        g2D.dispose();
    }

    //TODO zoom in and out in the center of the map
    public void increment()
    {
        this.scaleBy += 0.1;
        if(this.scaleBy > this.scaleMax)
        {
            this.scaleBy = this.scaleMax;
        }
        repaint();
    }

    public void decrement()
    {
        this.scaleBy -= 0.1;
        if(this.scaleBy < this.scaleMin)
        {
            this.scaleBy = this.scaleMin;
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        currRefX = e.getX();
        currRefY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}