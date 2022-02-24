import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Add_Food extends JFrame
{
    JTextField productName = new JTextField();
    JTextField productQnt = new JTextField();
    JTextField productPrice = new JTextField();
    JTextField productExpiration = new JTextField();

    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Go Back");

    JLabel nameLabel = new JLabel("Name:");
    JLabel qntLabel = new JLabel("Quantity:");
    JLabel priceLabel = new JLabel("Price:");
    JLabel expirationLabel = new JLabel("Expiration Date:");

    public Add_Food()
    {
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(44,44,44));
        textPanel.setBounds(0,30, 320, 470);
        textPanel.setLayout(null);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(44,44,44));
        buttonPanel.setBounds(0,30, 320, 470);
        buttonPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        submitButton.setFocusable(false);
        submitButton.setForeground(new Color(255,255,255));
        submitButton.setBackground(new Color(59,60,67));

        backButton.setFocusable(false);
        backButton.setForeground(new Color(255,255,255));
        backButton.setBackground(new Color(59,60,67));

        productName.setPreferredSize(new Dimension(250,25));
        productName.setBounds(130, 20, 165, 25);

        productQnt.setPreferredSize(new Dimension(250,25));
        productQnt.setBounds(130, 50, 165, 25);

        productPrice.setPreferredSize(new Dimension(250,25));
        productPrice.setBounds(130, 80, 165, 25);

        productExpiration.setPreferredSize(new Dimension(250,25));
        productExpiration.setBounds(130, 110, 165, 25);

        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial",Font.PLAIN,16));
        nameLabel.setBounds(10, 20, 165, 25);

        qntLabel.setForeground(Color.WHITE);
        qntLabel.setFont(new Font("Arial",Font.PLAIN,16));
        qntLabel.setBounds(10, 50, 165, 25);

        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(new Font("Arial",Font.PLAIN,16));
        priceLabel.setBounds(10, 80, 165, 25);

        expirationLabel.setForeground(Color.WHITE);
        expirationLabel.setFont(new Font("Arial",Font.PLAIN,16));
        expirationLabel.setBounds(10, 110, 165, 25);

        textPanel.add(nameLabel);
        textPanel.add(productName);

        textPanel.add(qntLabel);
        textPanel.add(productQnt);

        textPanel.add(priceLabel);
        textPanel.add(productPrice);

        textPanel.add(expirationLabel);
        textPanel.add(productExpiration);

        this.setTitle("Add Clothing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(320,220);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(44,44,44));
        this.add(textPanel);
        buttonPanel.add(backButton);
        buttonPanel.add(submitButton);
        this.add(buttonPanel);
        ImageIcon img = new ImageIcon("D:\\Proiect PI2\\src\\icon.png");
        this.setIconImage(img.getImage());

        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Add_Categories();
            }
        });

        submitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String nameText, quantityText, priceText, dateText;
                if(productName.getText().isEmpty() || productQnt.getText().isEmpty() || productPrice.getText().isEmpty() || productExpiration.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(new JFrame(), "You need to fill all the fields!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    nameText = productName.getText();
                    quantityText = productQnt.getText();
                    priceText = productPrice.getText();
                    dateText = productExpiration.getText();

                    String cnnString =
                            "jdbc:sqlserver://bd2021.database.windows.net;"
                                    + "database=lucamitroidb;"
                                    + "user=lucamitroiuser;"
                                    + "password=r5KRnP4f3j6WY;"
                                    + "encrypt=true;"
                                    + "trustServerCertificate=false;"
                                    + "loginTimeout=30;";
                    try
                    {
                        Connection myconn = DriverManager.getConnection(cnnString);
                        Statement myStmt = myconn.createStatement();
                        myStmt.executeUpdate("INSERT INTO Product(productName, quantity, price) VALUES ('" + nameText + "'," +quantityText + ", " + priceText + ")");
                        myStmt.executeUpdate("INSERT INTO Food(idFood, expirationDate) VALUES (SCOPE_IDENTITY(), '" + dateText + "')");
                        myStmt.close();
                        myconn.close();
                        dispose();
                        new Add_Categories();
                    }
                    catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }
            }
        });
    }
}
