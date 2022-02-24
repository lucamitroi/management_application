import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Categories extends JFrame
{
    JButton button1, button2, button3, button4, button5, button6;

    public static void SelectOption_Label_Method(JFrame frame)
    {
        Border border = BorderFactory.createLineBorder(new Color(44,44,44), 3);
        JLabel SelectOption_Label = new JLabel();
        SelectOption_Label.setText("Add product:");
        SelectOption_Label.setBorder(border);
        SelectOption_Label.setVerticalAlignment(JLabel.TOP);
        SelectOption_Label.setForeground(Color.WHITE);
        SelectOption_Label.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(SelectOption_Label);
        frame.setLayout(null);
        SelectOption_Label.setBounds(100, 5, 150, 25);
    }

    public Add_Categories()
    {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(44,44,44));
        buttonsPanel.setBounds(0,30, 320, 770);
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        button1 = new JButton();
        button1.setPreferredSize(new Dimension(200, 50));
        button1.setText("Clothing");
        button1.setFocusable(false);
        button1.setForeground(new Color(255,255,255));
        button1.setBackground(new Color(59,60,67));

        button2 = new JButton();
        button2.setPreferredSize(new Dimension(200, 50));
        button2.setText("Electronic Devices");
        button2.setFocusable(false);
        button2.setForeground(new Color(255,255,255));
        button2.setBackground(new Color(59,60,67));

        button3 = new JButton();
        button3.setPreferredSize(new Dimension(200, 50));
        button3.setText("Food");
        button3.setFocusable(false);
        button3.setForeground(new Color(255,255,255));
        button3.setBackground(new Color(59,60,67));

        button4 = new JButton();
        button4.setPreferredSize(new Dimension(200, 50));
        button4.setText("Furniture");
        button4.setFocusable(false);
        button4.setForeground(new Color(255,255,255));
        button4.setBackground(new Color(59,60,67));

        button5 = new JButton();
        button5.setPreferredSize(new Dimension(200, 50));
        button5.setText("Tools");
        button5.setFocusable(false);
        button5.setForeground(new Color(255,255,255));
        button5.setBackground(new Color(59,60,67));

        button6 = new JButton();
        button6.setPreferredSize(new Dimension(200, 50));
        button6.setText("Go Back");
        button6.setFocusable(false);
        button6.setForeground(new Color(255,255,255));
        button6.setBackground(new Color(59,60,67));

        this.setTitle("Add product");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(320,420);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(44,44,44));
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("D:\\Proiect PI2\\src\\icon.png");
        this.setIconImage(img.getImage());
        buttonsPanel.add(button1, CENTER_ALIGNMENT);
        buttonsPanel.add(button2, CENTER_ALIGNMENT);
        buttonsPanel.add(button3, CENTER_ALIGNMENT);
        buttonsPanel.add(button4, CENTER_ALIGNMENT);
        buttonsPanel.add(button5, CENTER_ALIGNMENT);
        buttonsPanel.add(button6, CENTER_ALIGNMENT);

        this.add(buttonsPanel);

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Add_Clothing();
            }
        });

        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Add_Electronic_Devices();
            }
        });

        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Add_Food();
            }
        });

        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Add_Furniture();
            }
        });

        button5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Add_Tools();
            }
        });

        button6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new FrameClass();
            }
        });
        SelectOption_Label_Method(this);
    }
}
