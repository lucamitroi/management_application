import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class FrameClass extends JFrame
{
    JButton button1, button2, button3, button4;

    public FrameClass()
    {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(44,44,44));
        buttonsPanel.setBounds(0,30, 320, 470);
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Border border = BorderFactory.createLineBorder(new Color(44,44,44), 3);
        JLabel SelectOption_Label = new JLabel();
        SelectOption_Label.setText("Select an option:");
        SelectOption_Label.setBorder(border);
        SelectOption_Label.setVerticalAlignment(JLabel.TOP);
        SelectOption_Label.setForeground(Color.WHITE);
        SelectOption_Label.setFont(new Font("Arial",Font.BOLD,16));
        this.add(SelectOption_Label);
        this.setLayout(null);
        SelectOption_Label.setBounds(100, 5, 150, 25);

        button1 = new JButton();
        button1.setPreferredSize(new Dimension(200, 50));
        button1.setText("Show all products");
        button1.setFocusable(false);
        button1.setForeground(new Color(255,255,255));
        button1.setBackground(new Color(59,60,67));

        button2 = new JButton();
        button2.setPreferredSize(new Dimension(200, 50));
        button2.setText("Add new products");
        button2.setFocusable(false);
        button2.setForeground(new Color(255,255,255));
        button2.setBackground(new Color(59,60,67));

        button3 = new JButton();
        button3.setPreferredSize(new Dimension(200, 50));
        button3.setText("Delete products");
        button3.setFocusable(false);
        button3.setForeground(new Color(255,255,255));
        button3.setBackground(new Color(59,60,67));

        button4 = new JButton();
        button4.setPreferredSize(new Dimension(200, 50));
        button4.addActionListener(e -> System.exit(0));
        button4.setText("Exit");
        button4.setFocusable(false);
        button4.setForeground(new Color(255,255,255));
        button4.setBackground(new Color(59,60,67));

        this.setTitle("Management application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(320,320);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(44,44,44));
        buttonsPanel.add(button1, CENTER_ALIGNMENT);
        buttonsPanel.add(button2, CENTER_ALIGNMENT);
        buttonsPanel.add(button3, CENTER_ALIGNMENT);
        buttonsPanel.add(button4, CENTER_ALIGNMENT);
        this.add(buttonsPanel);
        ImageIcon img = new ImageIcon("D:\\Proiect PI2\\src\\icon.png");
        this.setIconImage(img.getImage());

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Show_All1();
            }
        });

        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Add_Categories();
            }
        });

        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Delete_Product();
            }
        });
    }
}
