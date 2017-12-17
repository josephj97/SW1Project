import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {
    private JButton addBrand= new JButton("Add brand");
    private JButton deleteBrand= new JButton("Delete brand");
    private JButton updateBrand= new JButton("Update brand");
    private JButton addProduct= new JButton("Add product");
    private JButton deleteProduct= new JButton("Delete product");
    private JButton updateProduct= new JButton("Update product");
    private JButton explore= new JButton("Explore");
    private JButton viewProduct= new JButton("View specific product details");
    private JButton deleteSugg= new JButton("Delete suggestion");
    private JButton showSugg= new JButton("Show suggestion");
    private JButton provideVoucher= new JButton("Provide voucher cards to store");
    private JLabel userName=new JLabel("Username: ");
    private JLabel name;
    private JLabel type = new JLabel("Type: ");
    private JLabel myType;
    private JLabel spaces=new JLabel("                                                                                                                                                                                                 ");
    private JLabel spaces1=new JLabel("                                                                                                                                                                                                       ");
    Platform platform;
    public AdminGUI(){
        setTitle("Account");
        setSize(800,300);
        setLayout(new FlowLayout());
        name=new JLabel("Dalia Alaa");
        myType=new JLabel("Administrator");
        add(userName);
        add(name);
        add(spaces);
        add(type);
        add(myType);
        add(spaces1);
        add(explore);
        add(viewProduct);
        add(addBrand);
        add(updateBrand);
        add(deleteBrand);
        add(addProduct);
        add(updateProduct);
        add(deleteProduct);
        add(showSugg);
        add(deleteSugg);
        add(provideVoucher);
        explore.addActionListener(new action());
        viewProduct.addActionListener(new action());
        addBrand.addActionListener(new action());
        updateBrand.addActionListener(new action());
        deleteBrand.addActionListener(new action());
        addProduct.addActionListener(new action());
        updateProduct.addActionListener(new action());
        deleteProduct.addActionListener(new action());
        showSugg.addActionListener(new action());
        deleteSugg.addActionListener(new action());
        provideVoucher.addActionListener(new action());
    }
    public AdminGUI(Platform p){
        platform=p;
        setTitle("Account");
        setSize(800,300);
        setLayout(new FlowLayout());
        name=new JLabel(platform.UserCtrl.CurrentUser.getName());
        myType=new JLabel(platform.UserCtrl.CurrentUser.Type);
        add(userName);
        add(name);
        add(spaces);
        add(type);
        add(myType);
        add(spaces1);
        add(explore);
        add(viewProduct);
        add(addBrand);
        add(updateBrand);
        add(deleteBrand);
        add(addProduct);
        add(updateProduct);
        add(deleteProduct);
        add(showSugg);
        add(deleteSugg);
        add(provideVoucher);
        explore.addActionListener(new action());
        viewProduct.addActionListener(new action());
        addBrand.addActionListener(new action());
        updateBrand.addActionListener(new action());
        deleteBrand.addActionListener(new action());
        addProduct.addActionListener(new action());
        updateProduct.addActionListener(new action());
        deleteProduct.addActionListener(new action());
        showSugg.addActionListener(new action());
        deleteSugg.addActionListener(new action());
        provideVoucher.addActionListener(new action());
    }
    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(explore)){
                String n=JOptionPane.showInputDialog(null, "Enter the store name you want to explore");
                platform.StoreCtrl.explore(n);
            }
            if(x.equals(viewProduct)){
                String n=JOptionPane.showInputDialog(null, "Enter the name of product you want");
                int ProductIndex=platform.ProductCtrl.SearchProduct(n);
                if(ProductIndex==-1){
                    JOptionPane.showMessageDialog(null, "This product is not found!", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    platform.ProductCtrl.Products.get(ProductIndex).ShowInfo();
                }
            }
            if(x.equals(addBrand)){
                AddGUI gui= new AddGUI(platform.BrandCtrl);
                gui.setVisible(true);
            }
            if(x.equals(updateBrand)){

            }
            if(x.equals(deleteBrand)){

            }
            if(x.equals(addProduct)){
                AddGUI gui=new AddGUI(platform.ProductCtrl, platform.BrandCtrl);
                gui.setVisible(true);
            }
            if(x.equals(updateProduct)){

            }
            if(x.equals(deleteProduct)){

            }
            if(x.equals(showSugg)){
                platform.SuggestionCtrl.ShowSuggestions();
            }
            if(x.equals(deleteSugg)){

            }
            if(x.equals(provideVoucher)){
                AddGUI gui= new AddGUI(platform.StoreCtrl, platform.VoucherCtrl);
                gui.setVisible(true);
            }
        }
    }
}
