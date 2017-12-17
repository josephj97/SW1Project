import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFormGUI extends JFrame{
    private JButton register= new JButton("Register");
    private JLabel userName=new JLabel("Username ");
    private JLabel pass=new JLabel("Password ");
    private JLabel spaces=new JLabel("                                                                                                                                                                              ");
    private JRadioButton typea= new JRadioButton("Normal User", true);
    private JRadioButton typeb= new JRadioButton("Store Owner");
    private JTextField inputText=new JTextField(65);
    private JTextField inputText2=new JTextField(65);
    private ButtonGroup TypeGroup= new ButtonGroup();
    Platform platform;
    public RegisterFormGUI(Platform p){
        platform=p;
        setTitle("Sign-up");
        setSize(800,300);
        setLayout(new FlowLayout());
        add(userName);
        add(inputText);
        TypeGroup.add(typea);
        TypeGroup.add(typeb);
        add(typea);
        add(typeb);
        add(spaces);
        add(pass);
        add(inputText2);
        add(register);
        register.addActionListener(new action());
    }
    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(register)){
                String n=inputText.getText();
                String p=inputText2.getText();
                String t="";
                if(typea.isSelected()){
                    t="Normal";
                }
                if(typeb.isSelected()){
                    t="StoreOwner";
                }
                if(platform.UserCtrl.Register(n,p,t)){
                    platform.UserCtrl.PrintUsers();
                    if(platform.UserCtrl.CurrentUser.Type.equals("Normal")){
                        NormalUserGUI y=new NormalUserGUI(platform);
                        y.setVisible(true);
                        y.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    }
                    else if(platform.UserCtrl.CurrentUser.Type.equals("StoreOwner")){
                        StoreOwnerGUI y=new StoreOwnerGUI(platform);
                        y.setVisible(true);
                        y.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    }
                }
                else {
                    inputText.setText("");
                    inputText2.setText("");
                    typea.setSelected(true);
                    typeb.setSelected(false);
                    JOptionPane.showMessageDialog(null,"This username is already exists!");
                }
            }
        }
    }
}
