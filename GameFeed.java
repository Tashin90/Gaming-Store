import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFeed extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JButton[] gameButtons;
    JButton backBtn, paymentBtn;
    Font defaultFont;
    Color myColor;
    ImageIcon gameImage,logoIcon;
    JLabel imageLabel;   

    public GameFeed() {
        super("QuantumQuest - Game Feed");
        this.setBounds(400, 120, 1200, 740);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        defaultFont = new Font("Cambria", Font.BOLD, 15);

        panel = new JPanel();
        panel.setLayout(null);

        ImageIcon logoIcon = new ImageIcon("logo.png");
        this.setIconImage(logoIcon.getImage());

        String[] gameNames = {"A~80$", "B~130$", "C~25$", "D~5$", "F~25$", "G~50$", "H~20$", "I~100$", "J~58$", "K~90$"};
        gameButtons = new JButton[gameNames.length];


        for (int i = 0; i < gameNames.length; i++) {
            int row = i / 5; 
            int col = i % 5; 
            gameButtons[i] = new JButton(gameNames[i]);
            gameButtons[i].setBounds(70 + (col * 235), 320 + (row * 280), 100, 30);
            gameButtons[i].setFont(defaultFont);
            gameButtons[i].addMouseListener(this);
            gameButtons[i].addActionListener(this);
            panel.add(gameButtons[i]);
        }

        paymentBtn = new JButton("Proceed to Payment");
        paymentBtn.setBounds(200, 667, 200, 30);
        paymentBtn.setFont(defaultFont);
        paymentBtn.setBackground(Color.ORANGE);
        paymentBtn.setOpaque(true);
        paymentBtn.addMouseListener(this);
        paymentBtn.addActionListener(this);
        panel.add(paymentBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(920, 667, 100, 30);
        backBtn.setFont(defaultFont);
        backBtn.setBackground(Color.RED);
        backBtn.setOpaque(true);
        backBtn.addMouseListener(this);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        gameImage = new ImageIcon("4.png");
        imageLabel = new JLabel(gameImage);
        imageLabel.setBounds(0, 0, 1200, 675);
        panel.add(imageLabel); 

        this.add(panel);
        this.setVisible(true);
        //for exception
        Exception();
    }

    private void Exception() {
        int a = 1;
        int b = 0;

        try {
            int result = a / b;
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
            // Display an error message to the user
            JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Division Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == paymentBtn) {
            new Payment(); 
            this.dispose(); 
        } else if (e.getSource() == backBtn) {
            new Welcome(); 
            this.dispose(); 
        } else {
            for (JButton gameButton : gameButtons) {
                if (e.getSource() == gameButton) {
                    JOptionPane.showMessageDialog(this, gameButton.getText() + " selected!");
                }
            }
        }
    }

    public void mouseClicked(MouseEvent me) {}
    
    public void mousePressed(MouseEvent me) {}
    
    public void mouseReleased(MouseEvent me) {}
    
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == paymentBtn) {
            paymentBtn.setBackground(Color.BLUE);
            paymentBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.BLUE);
            backBtn.setForeground(Color.WHITE);
        } else {
            for (JButton gameButton : gameButtons) {
                if (me.getSource() == gameButton) {
                    gameButton.setBackground(Color.BLUE);
                    gameButton.setForeground(Color.WHITE);
                }
            }
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == paymentBtn) {
            paymentBtn.setBackground(Color.ORANGE);
            paymentBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.RED);
            backBtn.setForeground(Color.BLACK);
        } else {
            for (JButton gameButton : gameButtons) {
                if (me.getSource() == gameButton) {
                    gameButton.setBackground(null);
                    gameButton.setForeground(Color.BLACK);
                }
            }
        }
    }
}
