import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreOwnerGUI extends JFrame {
    private JButton addStore= new JButton("Add Store");
    private JButton deleteStore= new JButton("Delete Store");
    private JButton addProductStore= new JButton("Add product to your store");
    private JButton showStat= new JButton("Show statistics");
    private JButton mostViewed= new JButton("Get the most viewed product");
    private JButton exploreViews= new JButton("Explore the number of views for a product");
    private JButton explore= new JButton("Explore");
    private JButton viewProduct= new JButton("View specific product details");
    private JButton addSugg= new JButton("Suggest");
    private JLabel userName=new JLabel("Username: ");
    private JLabel name;
    private JLabel type = new JLabel("Type: ");
    private JLabel myType;
    private JLabel spaces=new JLabel("                                                                                                                                                                                                 ");
    private JLabel spaces1=new JLabel("                                                                                                                                                                                                       ");
    Platform platform;
    public StoreOwnerGUI(){
        setTitle("Account");
        setSize(800,300);
        setLayout(new FlowLayout());
        name=new JLabel("Dalia Alaa");
        myType=new JLabel("Store Owner");
        add(userName);
        add(name);
        add(spaces);
        add(type);
        add(myType);
        add(spaces1);
        add(explore);
        add(viewProduct);
        add(addStore);
        add(deleteStore);
        add(addProductStore);
        add(addSugg);
        add(mostViewed);
        add(exploreViews);
        add(showStat);
        explore.addActionListener(new action());
        viewProduct.addActionListener(new action());
        addStore.addActionListener(new action());
        deleteStore.addActionListener(new action());
        addProductStore.addActionListener(new action());
        addSugg.addActionListener(new action());
        mostViewed.addActionListener(new action());
        exploreViews.addActionListener(new action());
        showStat.addActionListener(new action());
    }
    public StoreOwnerGUI(Platform p){
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
        add(addStore);
        add(deleteStore);
        add(addProductStore);
        add(addSugg);
        add(mostViewed);
        add(exploreViews);
        add(showStat);
        explore.addActionListener(new action());
        viewProduct.addActionListener(new action());
        addStore.addActionListener(new action());
        deleteStore.addActionListener(new action());
        addProductStore.addActionListener(new action());
        addSugg.addActionListener(new action());
        mostViewed.addActionListener(new action());
        exploreViews.addActionListener(new action());
        showStat.addActionListener(new action());
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
            if(x.equals(addStore)){
                AddGUI gui=new AddGUI(platform.StoreCtrl, platform.UserCtrl);
                gui.setVisible(true);
            }
            if(x.equals(deleteStore)){

            }
            if(x.equals(addProductStore)){
                AddGUI gui=new AddGUI(platform.StoreCtrl,platform.ProductCtrl, platform.UserCtrl);
                gui.setVisible(true);
            }
            if(x.equals(addSugg)){
                AddGUI gui=new AddGUI(platform.SuggestionCtrl);
                gui.setVisible(true);
            }
            if(x.equals(mostViewed)){
                String n=JOptionPane.showInputDialog(null, "Enter the name of the store");
                int StoreIndex=platform.StoreCtrl.SearchStore(n);
                if(StoreIndex!=-1 && ((StoreOwner) platform.UserCtrl.CurrentUser).SearchMyStores(n)==true){
                    platform.StoreCtrl.CurrentStore=platform.StoreCtrl.Stores.get(StoreIndex);
                    JOptionPane.showMessageDialog(null,platform.StoreCtrl.GetMostViewedProduct()+" is the most viewed product");
                }
                else{
                    JOptionPane.showMessageDialog(null,"This store doesn't exist","Alert",JOptionPane.ERROR_MESSAGE);
                }
            }
            if(x.equals(exploreViews)){
                String n=JOptionPane.showInputDialog(null,"Enter the name of the store");
                int StoreIndex=platform.StoreCtrl.SearchStore(n);
                if(StoreIndex!=-1 && ((StoreOwner) platform.UserCtrl.CurrentUser).SearchMyStores(n)==true){
                    String Pname=JOptionPane.showInputDialog(null,"Enter product name");
                    platform.StoreCtrl.CurrentStore=platform.StoreCtrl.Stores.get(StoreIndex);
                    JOptionPane.showMessageDialog(null,"Its number of views is "+platform.StoreCtrl.ExploreProductViews(Pname)+" view");
                }
                else{
                    JOptionPane.showMessageDialog(null,"This store doesn't exist","Alert",JOptionPane.ERROR_MESSAGE);
                }
            }
            if(x.equals(showStat)){

            }
        }
    }
}
