import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentSuccess extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    ImageIcon welimg,logoIcon;
    JButton backBtn;
    JLabel successLabel,welimage;
    Font defaultFont;
    Color myColor;

    public PaymentSuccess() {
        super("QuantumQuest - Payment Success");
        this.setBounds(400, 120, 1200, 655);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        myColor = new Color(100, 199, 186);
        defaultFont = new Font("Cambria", Font.ITALIC, 20);
        
        
        panel = new JPanel();
        panel.setLayout(null);

        ImageIcon logoIcon = new ImageIcon("logo.png");
        this.setIconImage(logoIcon.getImage());

        successLabel = new JLabel("Payment Successful!", SwingConstants.CENTER);
successLabel.setBounds(400, 150, 400, 40);
successLabel.setFont(new Font("Cambria", Font.BOLD, 30));  
successLabel.setForeground(Color.BLACK);  
panel.add(successLabel);

backBtn = new JButton("Back to Game Feed");
backBtn.setBounds(500, 300, 200, 40);  
backBtn.setFont(defaultFont);  
backBtn.setForeground(Color.BLACK);  
backBtn.setBackground(Color.ORANGE);  
backBtn.setOpaque(true);  
backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));  
backBtn.addActionListener(this); 
backBtn.addMouseListener(this);  
panel.add(backBtn);  

welimg = new ImageIcon("8.png");
welimage = new JLabel(welimg);
welimage.setBounds(0, 0, 1200, 675);
panel.add(welimage);



        this.add(panel);
        this.setVisible(true);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 50);
        button.setFont(defaultFont);
        button.setBackground(Color.ORANGE);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true)); 
        button.addMouseListener(this);
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            new GameFeed();
            this.dispose(); 
        }
    }

    public void mouseClicked(MouseEvent me) {}

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() instanceof JButton) {
            JButton button = (JButton) me.getSource();
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() instanceof JButton) {
            JButton button = (JButton) me.getSource();
            button.setBackground(Color.ORANGE);
            button.setForeground(Color.BLACK);
        }
    }
}

