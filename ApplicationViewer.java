import javax.swing.*;
import java.awt.*;
import java.io.*;

class ApplicationViewer extends JFrame {
    JPanel panel;
    JTextArea textArea;
    JScrollPane scrollPane;
    Color c1;

    public ApplicationViewer() {
        super("All Applications");
        setBounds(150, 100, 600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        c1 = new Color(196, 229, 56);
        panel.setBackground(c1);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(20, 20, 540, 520);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 20, 540, 520);

        
        panel.add(scrollPane);

        add(panel);

        loadApplications();
    }

    public void loadApplications() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("applications.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                textArea.append(line + "\n");
            }
            br.close();
        } catch (IOException e) {
            textArea.setText("No applications found.");
        }
    }
}
