import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardDetailsPage extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JButton submitBtn, backBtn;
    JLabel headlineLabel, nameLabel, cardLabel, cvcLabel, validityLabel, cardTypeLabel,psimg;
    ImageIcon psimgIcon, logoIcon;
    JTextField nameField, cardField, cvcField, validityField;
    Font defaultFont, headlineFont;
    Color myColor;
    String paymentType;
    JComboBox<String> cardTypeComboBox;

    public CardDetailsPage(String paymentType) {
        super("QuantumQuest - " + paymentType + " Payment");
        this.paymentType = paymentType;

        this.setBounds(400, 120, 1200, 655);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myColor = new Color(100, 199, 186);
        defaultFont = new Font("Cambria", Font.PLAIN, 18);
        headlineFont = new Font("Cambria", Font.BOLD, 30);

        logoIcon = new ImageIcon("logo.png"); 
        this.setIconImage(logoIcon.getImage());

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(null);

       

        headlineLabel = new JLabel(paymentType + " Details", SwingConstants.CENTER);
        headlineLabel.setBounds(450, 160, 300, 40);  
        headlineLabel.setFont(headlineFont);  
        headlineLabel.setForeground(Color.BLACK);  
        panel.add(headlineLabel);  


       
        cardTypeLabel = new JLabel("Select Card Type:");
cardTypeLabel.setBounds(400, 250, 200, 40);  
cardTypeLabel.setFont(defaultFont);  
cardTypeLabel.setForeground(Color.BLACK);  
panel.add(cardTypeLabel);  


        
        String[] cardTypes = { "MasterCard", "Visa", "American Express" };
        cardTypeComboBox = new JComboBox<>(cardTypes);  
cardTypeComboBox.setBounds(600, 250, 200, 30);  
cardTypeComboBox.setFont(defaultFont);   
panel.add(cardTypeComboBox);

        
        nameLabel = new JLabel("Name:");  
nameLabel.setBounds(400, 300, 200, 40);  
nameLabel.setFont(defaultFont);  
nameLabel.setForeground(Color.BLACK);  
panel.add(nameLabel);  


       

        nameField = new JTextField();  
nameField.setBounds(600, 300, 200, 30);  
nameField.setFont(defaultFont);  
nameField.setForeground(Color.BLACK);  
 
panel.add(nameField);  


       
        cardLabel = new JLabel("Card Number:");  
cardLabel.setBounds(400, 350, 200, 40);  
cardLabel.setFont(defaultFont);  
cardLabel.setForeground(Color.BLACK);  
panel.add(cardLabel);  


       
        cardField = new JTextField();  
cardField.setBounds(600, 350, 200, 30);  
cardField.setFont(defaultFont);  
cardField.setForeground(Color.BLACK);  
 
panel.add(cardField); 


       

        cvcLabel = new JLabel("CVC Code:");  
cvcLabel.setBounds(400, 400, 200, 40);  
cvcLabel.setFont(defaultFont);  
cvcLabel.setForeground(Color.BLACK);  
panel.add(cvcLabel);  


        
        cvcField = new JTextField();  
cvcField.setBounds(600, 400, 200, 30);  
cvcField.setFont(defaultFont);  
cvcField.setForeground(Color.BLACK);    
panel.add(cvcField);  


       
        validityLabel = new JLabel("Validity Date (MM/YY):");  
validityLabel.setBounds(400, 450, 250, 40);  
validityLabel.setFont(defaultFont);  
validityLabel.setForeground(Color.BLACK);  
panel.add(validityLabel);  


      
        validityField = new JTextField();  
validityField.setBounds(600, 450, 200, 30);  
validityField.setFont(defaultFont);  
validityField.setForeground(Color.BLACK);  

panel.add(validityField);  


       

        submitBtn = new JButton("Submit");  
submitBtn.setBounds(600, 520, 200, 40);  
submitBtn.setFont(defaultFont);  
submitBtn.setBackground(Color.ORANGE);  
submitBtn.setOpaque(true);  

submitBtn.addMouseListener(this);  
submitBtn.addActionListener(this);  
panel.add(submitBtn);  


        
        backBtn = new JButton("Back");  
backBtn.setBounds(400, 520, 200, 40); 
backBtn.setFont(defaultFont);  
backBtn.setBackground(Color.ORANGE);  
backBtn.setOpaque(true);  

backBtn.addMouseListener(this);  
backBtn.addActionListener(this);  
panel.add(backBtn);  


        psimgIcon = new ImageIcon("7.png");  
        psimg = new JLabel(psimgIcon);
        psimg.setBounds(0, 0, 1200, 675);
        panel.add(psimg);

        this.add(panel);
        this.setVisible(true);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 40);
        button.setFont(defaultFont);
        button.setBackground(Color.ORANGE);
        button.setOpaque(true);
       
        button.addMouseListener(this);
        button.addActionListener(this);
        return button;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 30);
        label.setFont(defaultFont);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 200, 30);
        textField.setFont(defaultFont);
        
        return textField;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String selectedCardType = (String) cardTypeComboBox.getSelectedItem();
            String name = nameField.getText();
            String cardNumber = cardField.getText();
            String cvc = cvcField.getText();
            String validity = validityField.getText();

            
            if (name.isEmpty() || cardNumber.isEmpty() || cvc.isEmpty() || validity.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                
                JOptionPane.showMessageDialog(this, "Payment Successful!\nCard Type: " + selectedCardType, "Success", JOptionPane.INFORMATION_MESSAGE);
                
                
                new PaymentSuccess();
                this.dispose(); 
            }
        } else if (e.getSource() == backBtn) {
            new Payment(); 
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
