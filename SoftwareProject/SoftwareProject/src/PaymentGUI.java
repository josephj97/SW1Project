
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JFrame{
    private JButton cash= new JButton("Pay by cash");
    private JButton visa= new JButton("Pay  by visa");
    private JButton voucher= new JButton("Pay by voucher card");
    private JLabel msg=new JLabel("Choose a way for payment                                                                                                                                                                                                      ");
    PaymentController paymentCtrl;
    VoucherController voucherCtrl;
    public PaymentGUI(PaymentController p, VoucherController v){
        paymentCtrl=p;
        voucherCtrl=v;
        setTitle("Payment");
        setSize(800,300);
        setLayout(new FlowLayout());
        add(msg);
        add(cash);
        add(visa);
        add(voucher);
        cash.addActionListener(new action());
        visa.addActionListener(new action());
        voucher.addActionListener(new action());
    }
    private class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(cash)){
                paymentCtrl.PayByCash();
            }
            else if(x.equals(visa)){
                String n=JOptionPane.showInputDialog(null, "Enter Card Holder Name");
                String tmp= JOptionPane.showInputDialog(null,"Enter Card Number" );
                long num=Long.parseLong(tmp);
                tmp= JOptionPane.showInputDialog(null,"Enter Card Password");
                long pass=Long.parseLong(tmp);
                paymentCtrl.PayByVisa(n,num,pass);
            }
            else if(x.equals(voucher)){
                int voucherID=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Voucher's ID"));
                int voucherIndex=voucherCtrl.SearchVouchers(voucherID);
                if(voucherIndex==-1){
                    JOptionPane.showMessageDialog(null, "You've entered a wrong ID!", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    paymentCtrl.PayByVoucher(voucherCtrl.VoucherCards.get(voucherIndex));
                }
            }
            dispose();
        }
    }
}
