import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JButton creditBtn, debitBtn, backBtn;
    JLabel headlineLabel,welimage;
    ImageIcon welimg,logoIcon;
    Font defaultFont, headlineFont;
    Color myColor;

    public Payment() {
        super("QuantumQuest - Payment");
        this.setBounds(400, 120, 1200, 655);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myColor = new Color(100, 199, 186);
        defaultFont = new Font("Cambria", Font.PLAIN, 18);
        headlineFont = new Font("Cambria", Font.BOLD, 30);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(null);

        headlineLabel = new JLabel("PAYMENT", SwingConstants.CENTER);
        headlineLabel.setBounds(500, 230, 200, 40);
        headlineLabel.setFont(headlineFont);  
        headlineLabel.setForeground(Color.BLACK);
        panel.add(headlineLabel);


        ImageIcon logoIcon = new ImageIcon("logo.png");
        this.setIconImage(logoIcon.getImage());

        creditBtn = new JButton("Credit Card");
        creditBtn.setBounds(500, 300, 200, 40);
        creditBtn.setFont(defaultFont);
        creditBtn.setForeground(Color.BLACK);
        creditBtn.addActionListener(this);
        creditBtn.addMouseListener(this);
        panel.add(creditBtn);

        debitBtn = new JButton("Debit Card");
        debitBtn.setBounds(500, 360, 200, 40);
        debitBtn.setFont(defaultFont);
        debitBtn.setForeground(Color.BLACK);
        debitBtn.addActionListener(this);
        debitBtn.addMouseListener(this);
        panel.add(debitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(500, 420, 200, 40);
        backBtn.setFont(defaultFont);
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(this);
        backBtn.addMouseListener(this);
        panel.add(backBtn);

        welimg = new ImageIcon("5.png");
        welimage = new JLabel(welimg);
        welimage.setBounds(0, 0, 1200, 675);
        panel.add(welimage);

        this.add(panel);
        this.setVisible(true);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 40);
        button.setFont(defaultFont);
        button.setBackground(Color.ORANGE);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        button.addMouseListener(this);
        button.addActionListener(this);
        return button;
    }
    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == creditBtn) {
            new CardDetailsPage("Credit Card"); 
            this.dispose();
        } else if (e.getSource() == debitBtn) {
            new CardDetailsPage("Debit Card");
        } else if (e.getSource() == backBtn) {
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
