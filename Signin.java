 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signin extends JFrame implements ActionListener, MouseListener {
    JPanel panel;
    JLabel userLabel, passLabel, signinimg,successLabel;
    ImageIcon signinimgIcon,logoIcon;
    JTextField userText;
    JPasswordField passText;
    JButton loginBtn, backBtn;
    Font myFont;
    Color myColor;

    public Signin() {
        super("QuantumQuest - Sign In");
        this.setBounds(400, 120, 1200, 655);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        myFont = new Font("Cambria", Font.BOLD, 15);
        myColor = new Color(100, 199, 186);
        panel.setBackground(myColor);

        logoIcon = new ImageIcon("logo.png"); 
        this.setIconImage(logoIcon.getImage());

        successLabel = new JLabel("Welcome Back");
        successLabel.setBounds(150, 100, 400, 40);
        successLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        //successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(successLabel);

        successLabel = new JLabel("Sign In");
        successLabel.setBounds(150, 175, 400, 40);
        successLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        successLabel.setBackground(Color.WHITE);
        //successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(successLabel);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(195, 250, 100, 30);
        userLabel.setFont(myFont);
        userLabel.setBackground(Color.WHITE);
        userLabel.setOpaque(true);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(350, 250, 150, 30);
        userText.setBackground(Color.WHITE);
        userText.setOpaque(true);
        panel.add(userText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(195, 320, 100, 30);
        passLabel.setFont(myFont);
        passLabel.setBackground(Color.WHITE);
        passLabel.setOpaque(true);
        panel.add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(350, 320, 150, 30);
        panel.add(passText);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(200, 480, 100, 30);
        loginBtn.setFont(myFont);
        loginBtn.addActionListener(this);
        loginBtn.addMouseListener(this);
        panel.add(loginBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(370, 480, 100, 30);
        backBtn.setFont(myFont);
        backBtn.setBackground(Color.RED);
        backBtn.addActionListener(this);
        backBtn.addMouseListener(this);
        panel.add(backBtn);

        signinimgIcon = new ImageIcon("2.png");
        signinimg = new JLabel(signinimgIcon);
        signinimg.setBounds(0, 0, 1200, 675);
        panel.add(signinimg);

        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (loginBtn.getText().equals(command)) {
            String username = userText.getText();
            String password = new String(passText.getPassword());

            JOptionPane.showMessageDialog(this, "Welcome, " + username + "!");
            new GameFeed(); 
            this.dispose(); 
        } else if (backBtn.getText().equals(command)) {
            new Welcome(); 
            this.dispose(); 
        }
    }

    public void mouseClicked(MouseEvent me) {}

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setBackground(Color.BLUE);
            loginBtn.setForeground(Color.RED);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.BLUE);
            backBtn.setForeground(Color.RED);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setBackground(Color.LIGHT_GRAY);
            loginBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.RED);
            backBtn.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new Signin();
    }
}
