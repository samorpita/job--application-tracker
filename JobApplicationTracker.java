import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class JobApplicationTracker extends JFrame implements ActionListener {
    JPanel panel;
    JLabel nameLabel, genderLabel, jobTypeLabel, skillLabel, locationLabel, categoryLabel, commentLabel;
    JLabel emailLabel, phoneLabel, expLabel, resumeLabel, linkedinLabel, githubLabel, salaryLabel, langLabel, imageLabel;
    JTextField nameField, skillField, locationField, emailField, phoneField, resumeField, linkedinField, githubField, salaryField;
    JTextArea commentsField;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JCheckBox fullTime, partTime, remote;
    JComboBox categoryCombo, expCombo, langCombo;
    JButton submitBtn, viewBtn;
    Color c1;

    JobApplicationTracker() {
        setTitle("Job Application Tracker");
        setBounds(100, 100, 700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        c1 = new Color(196, 229, 56);
        panel.setBackground(c1);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 100, 30);
        nameField = new JTextField();
        nameField.setBounds(200, 30, 200, 30);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 70, 100, 30);
        male = new JRadioButton("Male");
        male.setBounds(200, 70, 70, 30);
        female = new JRadioButton("Female");
        female.setBounds(280, 70, 80, 30);
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        jobTypeLabel = new JLabel("Job Type:");
        jobTypeLabel.setBounds(50, 110, 100, 30);
        fullTime = new JCheckBox("Full Time");
        fullTime.setBounds(200, 110, 100, 30);
        partTime = new JCheckBox("Part Time");
        partTime.setBounds(300, 110, 100, 30);
        remote = new JCheckBox("Remote");
        remote.setBounds(400, 110, 100, 30);

        skillLabel = new JLabel("Skills:");
        skillLabel.setBounds(50, 150, 100, 30);
        skillField = new JTextField();
        skillField.setBounds(200, 150, 200, 30);

        locationLabel = new JLabel("Location:");
        locationLabel.setBounds(50, 190, 100, 30);
        locationField = new JTextField();
        locationField.setBounds(200, 190, 200, 30);

        categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(50, 230, 100, 30);
        String[] categories = { "AI RESEARCHER", "Web Developer", "App Developer", "Data Analyst", "UI/UX Designer" };
        categoryCombo = new JComboBox(categories);
        categoryCombo.setBounds(200, 230, 200, 30);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 270, 100, 30);
        emailField = new JTextField();
        emailField.setBounds(200, 270, 200, 30);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 310, 100, 30);
        phoneField = new JTextField();
        phoneField.setBounds(200, 310, 200, 30);

        expLabel = new JLabel("Experience:");
        expLabel.setBounds(50, 350, 100, 30);
        String[] expList = { "Fresher", "1-2 years", "3-5 years", "5+ years" };
        expCombo = new JComboBox(expList);
        expCombo.setBounds(200, 350, 200, 30);

        resumeLabel = new JLabel("Resume Path:");
        resumeLabel.setBounds(50, 390, 120, 30);
        resumeField = new JTextField();
        resumeField.setBounds(200, 390, 200, 30);

        linkedinLabel = new JLabel("LinkedIn:");
        linkedinLabel.setBounds(50, 430, 100, 30);
        linkedinField = new JTextField();
        linkedinField.setBounds(200, 430, 200, 30);

        githubLabel = new JLabel("GitHub:");
        githubLabel.setBounds(50, 470, 100, 30);
        githubField = new JTextField();
        githubField.setBounds(200, 470, 200, 30);

        salaryLabel = new JLabel("Expected Salary:");
        salaryLabel.setBounds(50, 510, 120, 30);
        salaryField = new JTextField();
        salaryField.setBounds(200, 510, 200, 30);

        langLabel = new JLabel("Preferred Language:");
        langLabel.setBounds(50, 550, 150, 30);
        String[] langs = { "Java", "C++", "Python", "JavaScript" };
        langCombo = new JComboBox(langs);
        langCombo.setBounds(200, 550, 200, 30);

        commentLabel = new JLabel("Comments:");
        commentLabel.setBounds(50, 590, 100, 30);
        commentsField = new JTextArea();
        commentsField.setBounds(200, 590, 300, 50);

        ImageIcon icon = new ImageIcon("P1.png");
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(450, 30, 200, 200);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(200, 660, 100, 30);
        submitBtn.addActionListener(this);

        viewBtn = new JButton("View Applications");
        viewBtn.setBounds(320, 660, 180, 30);
        viewBtn.addActionListener(this);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(genderLabel);
        panel.add(male);
        panel.add(female);
        panel.add(jobTypeLabel);
        panel.add(fullTime);
        panel.add(partTime);
        panel.add(remote);
        panel.add(skillLabel);
        panel.add(skillField);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(categoryLabel);
        panel.add(categoryCombo);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(expLabel);
        panel.add(expCombo);
        panel.add(resumeLabel);
        panel.add(resumeField);
        panel.add(linkedinLabel);
        panel.add(linkedinField);
        panel.add(githubLabel);
        panel.add(githubField);
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(langLabel);
        panel.add(langCombo);
        panel.add(commentLabel);
        panel.add(commentsField);
        panel.add(imageLabel);
        panel.add(submitBtn);
        panel.add(viewBtn);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            try {
                PrintWriter pw = new PrintWriter(new FileWriter("applications.txt", true));
                pw.println("Name: " + nameField.getText());
                pw.println("Gender: " + (male.isSelected() ? "Male" : "Female")));
                pw.print("Job Type: ");
                if (fullTime.isSelected()) pw.print("Full Time ");
                if (partTime.isSelected()) pw.print("Part Time ");
                if (remote.isSelected()) pw.print("Remote ");
                pw.println();
                pw.println("Skills: " + skillField.getText());
                pw.println("Location: " + locationField.getText());
                pw.println("Category: " + categoryCombo.getSelectedItem());
                pw.println("Email: " + emailField.getText());
                pw.println("Phone: " + phoneField.getText());
                pw.println("Experience: " + expCombo.getSelectedItem());
                pw.println("Resume Path: " + resumeField.getText());
                pw.println("LinkedIn: " + linkedinField.getText());
                pw.println("GitHub: " + githubField.getText());
                pw.println("Expected Salary: " + salaryField.getText());
                pw.println("Preferred Language: " + langCombo.getSelectedItem());
                pw.println("Comments: " + commentsField.getText());
                pw.println("-----------------------------");
                pw.close();

                JOptionPane.showMessageDialog(this, "Application Submitted!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == viewBtn) {
            ApplicationViewer av = new ApplicationViewer();
            av.setVisible(true);
        }
    }
}
