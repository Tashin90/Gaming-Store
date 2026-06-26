import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener, MouseListener {
    JPanel panel;
    JButton signinBtn, signupBtn;
    JLabel welimage;
    ImageIcon welimg,logoIcon;
    Font defaultFont, hoverFont;

    public Welcome() {
        super("QuantumQuest");
        this.setBounds(400, 120, 1200, 655);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        defaultFont = new Font("Arial", Font.PLAIN, 18);  
        hoverFont = new Font("Arial", Font.BOLD, 20);    
        
        ImageIcon logoIcon = new ImageIcon("logo.png");
        this.setIconImage(logoIcon.getImage());

        signinBtn = new JButton("Sign in");
        signinBtn.setBounds(350, 485, 150, 50);
        signinBtn.setFont(defaultFont);  
        signinBtn.setForeground(Color.BLACK);  
        signinBtn.addActionListener(this);
        signinBtn.addMouseListener(this);  
        panel.add(signinBtn);

        signupBtn = new JButton("Sign up");
        signupBtn.setBounds(680, 485, 150, 50);
        signupBtn.setFont(defaultFont);  
        signupBtn.setForeground(Color.BLACK);  
        signupBtn.addActionListener(this);
        signupBtn.addMouseListener(this);  
        panel.add(signupBtn);

        welimg = new ImageIcon("1.png");
        welimage = new JLabel(welimg);
        welimage.setBounds(0, 0, 1200, 675);
        panel.add(welimage);

        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signinBtn) {
            new Signin();
            this.dispose();
        } else if (e.getSource() == signupBtn) {
            new Signup();
            this.dispose();
        }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == signinBtn) {
            signinBtn.setText("Go ahead!");
            signinBtn.setForeground(Color.BLUE); 
            signinBtn.setFont(hoverFont);  
        } else if (e.getSource() == signupBtn) {
            signupBtn.setText("Join us!");
            signupBtn.setForeground(Color.GREEN);  
            signupBtn.setFont(hoverFont);  
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == signinBtn) {
            signinBtn.setText("Sign in");
            signinBtn.setForeground(Color.BLACK);  
            signinBtn.setFont(defaultFont);  
        } else if (e.getSource() == signupBtn) {
            signupBtn.setText("Sign up");
            signupBtn.setForeground(Color.BLACK);  
            signupBtn.setFont(defaultFont);  
        }
    }
}
