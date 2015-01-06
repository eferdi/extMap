
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author dingding
 */

public class IndiaMapo extends JFrame
{
    DisplayCanvas canvas;


    public IndiaMapo()
    {
        super();

        Container container = getContentPane();

        canvas = new DisplayCanvas();
        //ScrollPane scrollPane = new ScrollPane();
        //Scrollbar scrollbar = new Scrollbar();
        //scrollPane.add(scrollbar);
        //scrollPane.add(canvas);

        container.add(canvas);



        JPanel panel = new JPanel();
        panel.setBounds(0,0,100,900);
        getContentPane().add(panel, BorderLayout.WEST);

        JButton ZoominButton = new JButton("+");
        ZoominButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.increment();
            }
        });

        ZoominButton.setHorizontalAlignment(SwingConstants.LEADING);
        ZoominButton.setVerticalAlignment(SwingConstants.TOP);
        panel.add(ZoominButton);

        JButton ZoomoutButton = new JButton("-");
        ZoomoutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.decrement();
            }
        });
        panel.add(ZoomoutButton);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        setSize(900, 800);

        setVisible(true);
    }

    public static void main(String arg[])
    {
        new IndiaMapo();
    }
}

