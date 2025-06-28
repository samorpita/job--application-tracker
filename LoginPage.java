import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginPage extends JFrame implements ActionListener {
    JPanel panel;
    JLabel userLabel, passLabel, titleLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn, registerBtn;
    Font f1;
    Color c1, c2, c3;

    public LoginPage() {
        setTitle("Login Page");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);

        c1 = new Color(196, 229, 56);
        c2 = new Color(111, 30, 81);
        c3 = new Color(255, 255, 255);

        f1 = new Font("Cambria", Font.BOLD, 24);

        titleLabel = new JLabel("LOGIN");
        titleLabel.setBounds(180, 30, 200, 30);
        titleLabel.setFont(f1);
        titleLabel.setForeground(c2);
        panel.add(titleLabel);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 90, 100, 25);
        panel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(150, 90, 200, 25);
        panel.add(userField);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 25);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150, 130, 200, 25);
        panel.add(passField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 180, 90, 30);
        loginBtn.setBackground(c1);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(260, 180, 90, 30);
        registerBtn.setBackground(c1);
        registerBtn.addActionListener(this);
        panel.add(registerBtn);

        panel.setBackground(c3);
        panel.setBounds(0, 0, 500, 400);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String username = userField.getText();
            String password = String.valueOf(passField.getPassword());

            try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
                String line;
                boolean found = false;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                   JobApplicationTracker app = new JobApplicationTracker();
                   app.setVisible(true);  
                   dispose();

                }


                 else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password!");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == registerBtn) {
            new RegisterPage();
            dispose();
        }
    }
}

