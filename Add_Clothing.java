import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Add_Clothing extends JFrame
{
    JTextField productName = new JTextField();
    JTextField productQnt = new JTextField();
    JTextField productPrice = new JTextField();
    JTextField productMaterial = new JTextField();
    JTextField productType = new JTextField();
    JTextField productSize = new JTextField();
    JTextField productSex = new JTextField();

    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Go Back");

    JLabel nameLabel = new JLabel("Name:");
    JLabel qntLabel = new JLabel("Quantity:");
    JLabel priceLabel = new JLabel("Price:");
    JLabel materialLabel = new JLabel("Material:");
    JLabel typeLabel = new JLabel("Type:");
    JLabel sizeLabel = new JLabel("Size:");
    JLabel sexLabel = new JLabel("Sex:");

    public Add_Clothing()
    {
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(44,44,44));
        textPanel.setBounds(0,30, 320, 470);
        textPanel.setLayout(null);
        //textPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);

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
        productName.setBounds(100, 20, 165, 25);

        productQnt.setPreferredSize(new Dimension(250,25));
        productQnt.setBounds(100, 50, 165, 25);

        productPrice.setPreferredSize(new Dimension(250,25));
        productPrice.setBounds(100, 80, 165, 25);

        productMaterial.setPreferredSize(new Dimension(250,25));
        productMaterial.setBounds(100, 110, 165, 25);

        productType.setPreferredSize(new Dimension(250,25));
        productType.setBounds(100, 140, 165, 25);

        productSize.setPreferredSize(new Dimension(250,25));
        productSize.setBounds(100, 170, 165, 25);

        productSex.setPreferredSize(new Dimension(250,25));
        productSex.setBounds(100, 200, 165, 25);

        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial",Font.PLAIN,16));
        nameLabel.setBounds(10, 20, 165, 25);

        qntLabel.setForeground(Color.WHITE);
        qntLabel.setFont(new Font("Arial",Font.PLAIN,16));
        qntLabel.setBounds(10, 50, 165, 25);

        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(new Font("Arial",Font.PLAIN,16));
        priceLabel.setBounds(10, 80, 165, 25);

        materialLabel.setForeground(Color.WHITE);
        materialLabel.setFont(new Font("Arial",Font.PLAIN,16));
        materialLabel.setBounds(10, 110, 165, 25);

        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(new Font("Arial",Font.PLAIN,16));
        typeLabel.setBounds(10, 140, 165, 25);

        sizeLabel.setForeground(Color.WHITE);
        sizeLabel.setFont(new Font("Arial",Font.PLAIN,16));
        sizeLabel.setBounds(10, 170, 165, 25);

        sexLabel.setForeground(Color.WHITE);
        sexLabel.setFont(new Font("Arial",Font.PLAIN,16));
        sexLabel.setBounds(10, 200, 165, 25);

        textPanel.add(nameLabel);
        textPanel.add(productName);

        textPanel.add(qntLabel);
        textPanel.add(productQnt);

        textPanel.add(priceLabel);
        textPanel.add(productPrice);

        textPanel.add(materialLabel);
        textPanel.add(productMaterial);

        textPanel.add(typeLabel);
        textPanel.add(productType);

        textPanel.add(sizeLabel);
        textPanel.add(productSize);

        textPanel.add(sexLabel);
        textPanel.add(productSex);

        this.setTitle("Add Clothing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(290,320);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(44,44,44));
        this.add(textPanel);
        this.setLocationRelativeTo(null);
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
            String nameText, quantityText, priceText, materialText, typeText, sexText, sizeText;
            if(productName.getText().isEmpty() || productQnt.getText().isEmpty() || productPrice.getText().isEmpty() || productMaterial.getText().isEmpty() || productType.getText().isEmpty() || productSex.getText().isEmpty() || productSize.getText().isEmpty())
            //new Error_Screen();
            {
                JOptionPane.showMessageDialog(new JFrame(), "You need to fill all the fields!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                nameText = productName.getText();
                quantityText = productQnt.getText();
                priceText = productPrice.getText();
                materialText = productMaterial.getText();
                typeText = productType.getText();
                sizeText = productSize.getText();
                sexText = productSex.getText();

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
                    myStmt.executeUpdate("INSERT INTO Clothing(idClothing, material, clothingType, size, sex) VALUES (SCOPE_IDENTITY(),'" + materialText +"', '" + typeText + "', '" + sizeText + "', '" + sexText + "')");
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
