import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageGUI extends JFrame {
    private JButton register= new JButton("Register");
    private JButton login= new JButton("Login");
    private JLabel userName=new JLabel("Username ");
    private JLabel pass=new JLabel("Password ");
    private JLabel spaces=new JLabel("                                                                                                                                                                             ");
    private JLabel rig=new JLabel("You don't have an account? ");
    private JTextField inputText=new JTextField(65);
    private JTextField inputText2=new JTextField(65);
    Platform platform;
    public MainPageGUI(Platform p){
        platform=p;
        setTitle("Login or Sign-up");
        setSize(800,300);
        setLayout(new FlowLayout());
        add(userName);
        add(inputText);
        add(pass);
        add(inputText2);
        add(login);
        add(spaces);
        add(rig);
        add(register);
        login.addActionListener(new action());
        register.addActionListener(new action());
    }
    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(login)){
                String n=inputText.getText();
                String p=inputText2.getText();
                if(platform.UserCtrl.Login(n,p)){
                    //System.out.println(platform.UserCtrl.CurrentUser.getName());
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
                    else{
                        AdminGUI y=new AdminGUI(platform);
                        y.setVisible(true);
                        y.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    }
                }
                else{
                    inputText.setText("");
                    inputText2.setText("");
                    JOptionPane.showMessageDialog(null,"You've entered a wrong username or password!");
                }
            }
            if(x.equals(register)){
                RegisterFormGUI y=new RegisterFormGUI(platform);
                y.setVisible(true);
                y.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        }
    }
}
