import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NormalUserGUI extends JFrame {
    private JButton explore= new JButton("Explore");
    private JButton viewProduct= new JButton("View specific product details");
    private JButton addCart= new JButton("Add product to cart");
    private JButton remCart= new JButton("Remove product from cart");
    private JButton showCart= new JButton("Show your cart");
    private JButton buy= new JButton("Buy cart");
    private JLabel userName=new JLabel("Username: ");
    private JLabel name;
    private JLabel type = new JLabel("Type: ");
    private JLabel myType;
    private JLabel spaces=new JLabel("                                                                                                                                                                                                 ");
    private JLabel spaces1=new JLabel("                                                                                                                                                                                                       ");
    Platform platform;
    public NormalUserGUI(){
        setTitle("Account");
        setSize(800,300);
        setLayout(new FlowLayout());
        name=new JLabel("Dalia Alaa");
        myType=new JLabel("Normal user");
        add(userName);
        add(name);
        add(spaces);
        add(type);
        add(myType);
        add(spaces1);
        add(explore);
        add(viewProduct);
        add(addCart);
        add(remCart);
        add(showCart);
        add(buy);
        explore.addActionListener(new action());
        viewProduct.addActionListener(new action());
        addCart.addActionListener(new action());
        remCart.addActionListener(new action());
        showCart.addActionListener(new action());
        buy.addActionListener(new action());
    }
    public NormalUserGUI(Platform p){
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
        add(addCart);
        add(remCart);
        add(showCart);
        add(buy);
        explore.addActionListener(new action());
        viewProduct.addActionListener(new action());
        addCart.addActionListener(new action());
        remCart.addActionListener(new action());
        showCart.addActionListener(new action());
        buy.addActionListener(new action());
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
            if(x.equals(addCart)){
                platform.CartCtrl.SetCart(platform.UserCtrl.CurrentUser);
                String n=JOptionPane.showInputDialog(null,"Enter the name of the product you want to add to the cart");
                int ProductIndex=platform.ProductCtrl.SearchProduct(n);
                if(ProductIndex==-1){
                    JOptionPane.showMessageDialog(null, "This product doesn't exist!", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if(platform.CartCtrl.AddToCart(platform.ProductCtrl.Products.get(ProductIndex))){
                        JOptionPane.showMessageDialog(null, "Added successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Cannot be added!", "Alert", JOptionPane.ERROR_MESSAGE);
                    }
                }
                platform.CartCtrl.ShowCart();
            }
            if(x.equals(remCart)){
                platform.CartCtrl.SetCart(platform.UserCtrl.CurrentUser);
            }
            if(x.equals(showCart)){
                platform.CartCtrl.SetCart(platform.UserCtrl.CurrentUser);
                platform.CartCtrl.ShowCart();
            }
            if(x.equals(buy)){
                platform.CartCtrl.SetCart(platform.UserCtrl.CurrentUser);
                double totalPrice=platform.CartCtrl.BuyCart();
                if(totalPrice==0){
                    JOptionPane.showMessageDialog(null, "Your cart is empty!", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    platform.PaymentCtrl.SetPrice(totalPrice);
                    PaymentGUI pGUI=new PaymentGUI(platform.PaymentCtrl, platform.VoucherCtrl);
                    pGUI.setVisible(true);
                }
            }
        }
    }
}
