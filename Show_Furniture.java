import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

public class Show_Furniture extends JFrame
{
    JButton button1;
    public Show_Furniture()
    {
        List<Furniture> allProducts_List = new ArrayList<>();
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

            ResultSet myRs = myStmt.executeQuery("SELECT * FROM FullFurniture");
            while (myRs.next()) {
                allProducts_List.add(new Furniture(myRs.getString("idProduct"), myRs.getString("productName"), myRs.getInt("quantity"), myRs.getDouble("price"), myRs.getString("furnitureType"), myRs.getString("material"), myRs.getString("environment") ));
            }
            myRs.close();
            myStmt.close();
            myconn.close();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }



        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(44,44,44));
        String[] columnNames = {"ID",
                "Name",
                "Quantity",
                "Price",
                "Type",
                "Material",
                "Environment"
        };

        Object[][] data = new Object[allProducts_List.size()][1000];
        for(int i = 0; i < allProducts_List.size(); i++)
        {
            data[i][0] = allProducts_List.get(i).getName();
            data[i][1] = allProducts_List.get(i).getId();
            data[i][2] = allProducts_List.get(i).getQuantity();
            data[i][3] = allProducts_List.get(i).getPrice();
            data[i][4] = allProducts_List.get(i).getFurnitureType();
            data[i][5] = allProducts_List.get(i).getMaterial();
            data[i][6] = allProducts_List.get(i).getEnvironment();
        }

        button1 = new JButton();
        button1.setPreferredSize(new Dimension(200, 50));
        button1.setText("Go Back");
        button1.setFocusable(false);
        button1.setForeground(new Color(255,255,255));
        button1.setBackground(new Color(59,60,67));

        JTable table = new JTable(data, columnNames);
        table.setRowHeight(50);
        table.setFont(new Font("Arial", Font.PLAIN, 16));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        this.setTitle("All Products");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(800,800);
        this.getContentPane().setBackground(new Color(44,44,44));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("D:\\Proiect PI2\\src\\icon.png");
        this.setIconImage(img.getImage());
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        buttonsPanel.add(button1);
        scrollPane.setSize(100,200);
        this.add(scrollPane/*, BorderLayout.PAGE_START*/);
        this.add(buttonsPanel, BorderLayout.PAGE_END);

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Show_All1();
            }
        });
    }
}
