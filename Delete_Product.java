import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Delete_Product extends JFrame
{

    JButton submitButton = new JButton("Delete Product");
    JButton backButton = new JButton("Go Back");

    public Delete_Product()
    {
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(44,44,44));
        textPanel.setBounds(0,30, 320, 470);
        textPanel.setLayout(null);

        List<Product> allProducts_List = new ArrayList<>();
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

            ResultSet myRs = myStmt.executeQuery("SELECT * FROM Product");
            while (myRs.next()) {
                allProducts_List.add(new Product(myRs.getString("idProduct"), myRs.getString("productName"), myRs.getInt("quantity"), myRs.getDouble("price")));
            }
            myRs.close();
            myStmt.close();
            myconn.close();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        Object[] data = new Object[allProducts_List.size()];
        for(int i = 0; i < allProducts_List.size(); i++)
        {
            data[i] = allProducts_List.get(i).getId();
        }

        JComboBox cb=new JComboBox(data);
        cb.setBounds(33, 30,270,35);


        submitButton.setFocusable(false);
        submitButton.setForeground(new Color(255,255,255));
        submitButton.setBackground(new Color(59,60,67));

        backButton.setFocusable(false);
        backButton.setForeground(new Color(255,255,255));
        backButton.setBackground(new Color(59,60,67));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(44,44,44));
        buttonPanel.setBounds(0,30, 320, 470);
        buttonPanel.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        textPanel.add(cb);

        this.setTitle("Delete a Product");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350,180);
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
                new FrameClass();
            }
        });

        submitButton.addActionListener(new ActionListener()
        {
            String id;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String cnnString = "jdbc:sqlserver://bd2021.database.windows.net;"
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
                    Object text = cb.getSelectedItem();

                    for(Product product: allProducts_List)
                    {
                        if(product.getId().equals((String)text))
                            id = product.getName();
                    }

                    myStmt.executeUpdate("DELETE FROM Clothing WHERE idClothing = " + id);
                    myStmt.executeUpdate("DELETE FROM ElectronicDevice WHERE idElectronicDevice = " + id);
                    myStmt.executeUpdate("DELETE FROM Food WHERE idFood = " + id);
                    myStmt.executeUpdate("DELETE FROM Furniture WHERE idFurniture = " + id);
                    myStmt.executeUpdate("DELETE FROM Tools WHERE idTools = " + id);
                    myStmt.executeUpdate("DELETE FROM Product WHERE idProduct = " + id);

                    myStmt.close();
                    myconn.close();
                    dispose();
                    new FrameClass();
                }
                catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
    }

}
