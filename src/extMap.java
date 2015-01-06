import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class extMap extends JFrame
{
    displayMap mapCanvas;
    public extMap()
    {
        super();

        Container container = getContentPane();
        mapCanvas = new displayMap();

        container.add(mapCanvas);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,100,900);
        getContentPane().add(panel, BorderLayout.WEST);

        JButton buttonZoomIn = new JButton("+");
        buttonZoomIn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mapCanvas.increment();
            }
        });
        panel.add(buttonZoomIn);

        JButton buttonZoomOut = new JButton("-");
        buttonZoomOut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mapCanvas.decrement();
            }
        });
        panel.add(buttonZoomOut);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        //setSize(900, 800);
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String arg[])
    {
        new extMap();
    }
}

