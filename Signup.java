import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements MouseListener, ActionListener {
    
    JPanel panel;
    JLabel nameLabel,genderLabel, userLabel, emailLabel, passLabel, confirmPassLabel, signimg, successLabel;
    ImageIcon signimgIcon, logoIcon;
    JTextField nameText, userText, emailText;
    JPasswordField passText, confirmPassText;
    JRadioButton m, f;
    ButtonGroup genderGroup;
    JButton createAccountBtn, backBtn;
    Font defaultFont, myFont;
    Color myColor;

    public Signup() {
        
        super("QuantumQuest - Sign Up");
        this.setBounds(400, 120, 1200, 655);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        myColor = new Color(100, 199, 186);
        defaultFont = new Font("Cambria", Font.BOLD, 15);
        myFont = new Font("Serif", Font.BOLD, 20); 
    
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor);

        ImageIcon logoIcon = new ImageIcon("logo.png");
        this.setIconImage(logoIcon.getImage());

        successLabel = new JLabel("New Here?");
        successLabel.setBounds(650, 100, 400, 40);
        successLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        //successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(successLabel);

        successLabel = new JLabel("Create Account");
        successLabel.setBounds(650, 155, 400, 40);
        successLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        //successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(successLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(720, 210, 150, 30);
        nameLabel.setFont(defaultFont);
        nameLabel.setBackground(Color.WHITE);
        nameLabel.setOpaque(true);
        panel.add(nameLabel);
    
        nameText = new JTextField();
        nameText.setBounds(890, 210, 150, 30);
        nameText.setBackground(Color.PINK);
        panel.add(nameText);
        //User Done
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(720, 290, 150, 30);
        emailLabel.setFont(defaultFont);
        emailLabel.setBackground(Color.WHITE);
        emailLabel.setOpaque(true);
        panel.add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(890, 290, 150, 30);
        emailText.setBackground(Color.PINK);
        panel.add(emailText);
        //email Done

        userLabel = new JLabel("Username:");
        userLabel.setBounds(720, 250, 150, 30);
        userLabel.setFont(defaultFont);
        userLabel.setBackground(Color.WHITE);
        userLabel.setOpaque(true);
        panel.add(userLabel);
    
        userText = new JTextField();
        userText.setBounds(890, 250, 150, 30);
        userText.setBackground(Color.PINK);
        panel.add(userText);
        
        //user Done
        passLabel = new JLabel("Password:");
        passLabel.setBounds(720, 340, 150, 30);
        passLabel.setFont(defaultFont);
        passLabel.setBackground(Color.WHITE);
        passLabel.setOpaque(true);
        panel.add(passLabel);
    
        passText = new JPasswordField();
        passText.setBounds(890, 340, 150, 30);
        panel.add(passText);
    
        confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setBounds(720, 380, 150, 30);
        confirmPassLabel.setFont(defaultFont);
        confirmPassLabel.setBackground(Color.WHITE);
        confirmPassLabel.setOpaque(true);
        panel.add(confirmPassLabel);
    
        confirmPassText = new JPasswordField();
        confirmPassText.setBounds(890, 380, 150, 30);
        panel.add(confirmPassText);
    

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(720, 420, 150, 30);
        genderLabel.setBackground(Color.WHITE);
        genderLabel.setFont(defaultFont);
        genderLabel.setOpaque(true);
        panel.add(genderLabel);

        m = new JRadioButton("Male");
        m.setBounds(890, 420, 70, 30);
        m.setBackground(myColor);
        panel.add(m);

        f = new JRadioButton("Female");
        f.setBounds(970, 420, 80, 30);
        f.setBackground(myColor);
        panel.add(f);

        genderGroup = new ButtonGroup();
        genderGroup.add(m);
        genderGroup.add(f);





        //createeee Done
        createAccountBtn = new JButton("Create Account");
        createAccountBtn.setBounds(730, 530, 150, 30);
        createAccountBtn.setFont(defaultFont);
        createAccountBtn.addMouseListener(this);
        createAccountBtn.addActionListener(this);
        panel.add(createAccountBtn);
    
        //create
        backBtn = new JButton("Back");
        backBtn.setBounds(930, 530, 100, 30);
        backBtn.setBackground(Color.RED);
        backBtn.setFont(defaultFont);
        backBtn.addMouseListener(this);
        backBtn.addActionListener(this);
        panel.add(backBtn);
    
        signimgIcon = new ImageIcon("3.png"); 
        signimg = new JLabel(signimgIcon);
        signimg.setBounds(0, 0, 1200, 655);
        panel.add(signimg);
    
        this.add(panel); 
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountBtn) {
            String password = new String(passText.getPassword());
            String confirmPassword = new String(confirmPassText.getPassword());

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
            } else {
                JOptionPane.showMessageDialog(this, "Account created successfully!");
                new Signin(); 
                this.dispose(); 
            }
        } else if (e.getSource() == backBtn) {
            new Welcome(); 
            this.dispose(); 
        }
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == createAccountBtn) {
            createAccountBtn.setBackground(Color.BLUE);
            createAccountBtn.setForeground(Color.RED);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.BLUE);
            backBtn.setForeground(Color.RED);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == createAccountBtn) {
            createAccountBtn.setBackground(Color.GREEN);
            createAccountBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.RED);
            backBtn.setForeground(Color.BLACK);
        }
    }
}
