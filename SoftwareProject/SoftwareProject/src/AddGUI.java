import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGUI extends JFrame {
    private JButton addStore= new JButton("Add Store");
    private JButton addStoreProduct= new JButton("Add Product to the store");
    private JButton sugg= new JButton("Add Suggestion");
    private JButton addProduct= new JButton("Add Product");
    private JButton addBrand= new JButton("Add Brand");
    private JButton provideVoucher= new JButton("Provide voucher cards to the store");
    private JLabel name=new JLabel("Name: ");
    private JLabel address=new JLabel("Address (non): ");
    private JLabel type=new JLabel("Type (Online/Onsite): ");
    private JLabel link=new JLabel("Link: ");
    private JLabel extra ;
    private JLabel spaces=new JLabel("                                                                                                                                                                                                 ");
    private JLabel spaces1=new JLabel("                                                                                                                                                                                                       ");
    private JTextField text1=new JTextField(50);
    private JTextField text2=new JTextField(50);
    private JTextField text3=new JTextField(50);
    private JTextField text4=new JTextField(50);
    private JTextField text5=new JTextField(50);
    BrandController brandCtrl;
    ProductController productCtrl;
    StoreController storeCtrl;
    VoucherController voucherCtrl;
    UserController userCtrl;
    SuggestionController suggestionCtrl;
    public AddGUI(StoreController s, UserController u){
        storeCtrl=s;
        userCtrl=u;
        setTitle("Add Store");
        setSize(800,300);
        setLayout(new FlowLayout());
        add(name);
        add(text1);
        add(address);
        add(text2);
        add(type);
        add(text3);
        add(link);
        add(text4);
        add(addStore);
        addStore.addActionListener(new action());
    }
    public AddGUI(StoreController s, ProductController p, UserController u){
        storeCtrl=s;
        productCtrl=p;
        userCtrl=u;
        setTitle("Add Product To Store");
        setSize(800,300);
        setLayout(new FlowLayout());
        name.setText("Product name: ");
        add(name);
        add(text1);
        address.setText("Store name: ");
        add(address); // store name
        add(text2);
        add(addStoreProduct);
        addStoreProduct.addActionListener(new action());
    }
    public AddGUI(SuggestionController s){
        suggestionCtrl=s;
        setTitle("Suggest");
        setSize(800,300);
        setLayout(new FlowLayout());
        add(name);
        add(text1);
        type.setText("Type (Brand/Product): ");
        add(type);
        add(text2);
        add(sugg);
        sugg.addActionListener(new action());
    }
    public AddGUI(ProductController p, BrandController b){
        productCtrl=p;
        brandCtrl=b;
        setTitle("Add Product");
        setSize(800,300);
        setLayout(new FlowLayout());
        add(name);
        add(text1);
        address.setText("Price: ");
        add(address); //price
        add(text2);
        link.setText("Category: ");
        add(link);  // category
        add(text3);
        add(type);
        add(text4);
        extra= new JLabel("Brand name: ");
        add(extra); // brand name
        add(text5);
        add(addProduct);
        addProduct.addActionListener(new action());
    }
    public AddGUI(BrandController b){
        brandCtrl=b;
        setTitle("Add Brand");
        setSize(800,300);
        setLayout(new FlowLayout());
        add(name);
        add(text1);
        address.setText("Company name: ");
        add(address); // company name
        add(text2);
        add(addBrand);
        addBrand.addActionListener(new action());
    }
    public AddGUI(StoreController s, VoucherController v){
        storeCtrl=s;
        voucherCtrl=v;
        setTitle("Provide voucher cards to store");
        setSize(800,300);
        setLayout(new FlowLayout());
        name.setText("Store name: ");
        add(name);
        add(text1);
        address.setText("Number of cards to be provided: ");
        add(address); // no. of cards
        add(text2);
        add(provideVoucher);
        provideVoucher.addActionListener(new action());
    }
    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(addBrand)){
                String n=text1.getText();
                String companyName=text2.getText();
                if(brandCtrl.AddBrand(n,companyName)){
                    JOptionPane.showMessageDialog(null,"You've added the Brand successfully!" );
                }
                else {
                    JOptionPane.showMessageDialog(null,"The brand already exists!", "Alert", JOptionPane.ERROR_MESSAGE );
                }
                brandCtrl.PrintBrands();
                dispose();
            }
            if(x.equals(addProduct)){
                String n=text1.getText();
                double p=Double.parseDouble(text2.getText());
                String c=text3.getText();
                String t=text4.getText();
                String b=text5.getText();
                int brandIndex=brandCtrl.SearchBrand(b);
                if(brandIndex==-1){
                    JOptionPane.showMessageDialog(null,"This brand is not found in the platform!","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else if(productCtrl.AddProduct(n,p,c,t,brandCtrl.Brands.get(brandIndex))){
                    JOptionPane.showMessageDialog(null, "You've added the product successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"This product already exists!","Alert", JOptionPane.ERROR_MESSAGE);
                }
                productCtrl.PrintProducts();
                dispose();
            }
            if(x.equals(provideVoucher)){
                //voucherCtrl.PrintVouchers();
                String n=text1.getText();
                int stroreIndex=storeCtrl.SearchStore(n);
                if(stroreIndex==-1){
                    JOptionPane.showMessageDialog(null, "The store is not found", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int numCards=Integer.parseInt(text2.getText());
                    voucherCtrl.ProvideToStore(storeCtrl.Stores.get(stroreIndex),numCards);
                    for (int i=0;i<storeCtrl.Stores.get(stroreIndex).VoucherCards.size();i++){
                        storeCtrl.Stores.get(stroreIndex).VoucherCards.get(i).GetID();
                    }
                }
                dispose();
            }
            if(x.equals(addStore)){
                String n=text1.getText();
                String address=text2.getText();
                String t=text3.getText();
                String l=text4.getText();
                if(storeCtrl.AddStore(n,address, t, l, (StoreOwner) userCtrl.CurrentUser)){
                    JOptionPane.showMessageDialog(null, "You've added the store successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"This store cannot be added!" , "Alert",JOptionPane.ERROR_MESSAGE);
                }
                storeCtrl.PrintStores();
                dispose();
            }
            if (x.equals(addStoreProduct)){
                String n=text1.getText();
                String sName=text2.getText();
                int productIndex=productCtrl.SearchProduct(n);
                if(productIndex==-1){
                    JOptionPane.showMessageDialog(null,"This product is not found in the platform!","Alert",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if(storeCtrl.AddProductToStore(productCtrl.Products.get(productIndex),sName,(StoreOwner) userCtrl.CurrentUser)){
                        JOptionPane.showMessageDialog(null,"You've added the Product successfully!");
                        storeCtrl.Stores.get(storeCtrl.SearchStore(sName)).ShowStoreProducts();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"This product is already exists in you store!");
                    }
                    dispose();
                }
            }
            if (x.equals(sugg)){
                String n=text1.getText();
                String t=text2.getText();
                if (suggestionCtrl.AddSuggestion(n,t)){
                    JOptionPane.showMessageDialog(null,"You've submitted your suggestion successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The suggestion already exists!","Alert", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        }
    }
}
