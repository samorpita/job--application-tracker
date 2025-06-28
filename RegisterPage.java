import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RegisterPage extends JFrame implements ActionListener {
    JPanel panel;
    JLabel userLabel, passLabel, titleLabel;
    JTextField userField;
    JPasswordField passField;
    JButton registerBtn, backBtn;
    Font f1;
    Color c1, c2, c3;

    public RegisterPage() {
        setTitle("Register Page");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);

        c1 = new Color(196, 229, 56);
        c2 = new Color(111, 30, 81);
        c3 = new Color(255, 255, 255);

        f1 = new Font("Cambria", Font.BOLD, 24);

        titleLabel = new JLabel("REGISTER");
        titleLabel.setBounds(180, 30, 200, 30);
        titleLabel.setFont(f1);
        titleLabel.setForeground(c2);
        panel.add(titleLabel);

        userLabel = new JLabel("New Username:");
        userLabel.setBounds(50, 90, 100, 25);
        panel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(180, 90, 200, 25);
        panel.add(userField);

        passLabel = new JLabel("New Password:");
        passLabel.setBounds(50, 130, 100, 25);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(180, 130, 200, 25);
        panel.add(passField);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(180, 180, 90, 30);
        registerBtn.setBackground(c1);
        registerBtn.addActionListener(this);
        panel.add(registerBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(290, 180, 90, 30);
        backBtn.setBackground(c1);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        panel.setBackground(c3);
        panel.setBounds(0, 0, 500, 400);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerBtn) {
            String username = userField.getText();
            String password = String.valueOf(passField.getPassword());

            if (!username.isEmpty() && !password.isEmpty()) {
                try (PrintWriter pw = new PrintWriter(new FileWriter("users.txt", true))) {
                    pw.println(username + "," + password);
                    JOptionPane.showMessageDialog(this, "Registration successful!");
                    dispose();
                    new LoginPage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty");
            }
        } else if (e.getSource() == backBtn) {
            dispose();
            new LoginPage();
        }
    }
}
