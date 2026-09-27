/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ripfumelo ngobeni
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class HospitalGUI extends JFrame {
    private Operations operations;
    private JComboBox<String> comboReport;
    private JTextArea textArea;
    private JButton btnProcess, btnSave;
    private JMenuItem menuExit, menuProcess, menuSave, menuClear;

    public HospitalGUI(Operations ops) {
        super("Hospital Operations - GUI");
        this.operations = ops;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Top panel with combo and buttons
        JPanel topPanel = new JPanel();
        comboReport = new JComboBox<>(new String[] {
            "Total Operations (All Years)",
            "Year 1 Total Operations",
            "Year 2 Total Operations"
        });
        btnProcess = new JButton("Process");
        btnSave = new JButton("Save Data");

        topPanel.add(new JLabel("Select report:"));
        topPanel.add(comboReport);
        topPanel.add(btnProcess);
        topPanel.add(btnSave);

        // Text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuExit = new JMenuItem("Exit");
        fileMenu.add(menuExit);

        JMenu toolsMenu = new JMenu("Tools");
        menuProcess = new JMenuItem("Process");
        menuSave = new JMenuItem("Save Data");
        menuClear = new JMenuItem("Clear");
        toolsMenu.add(menuProcess);
        toolsMenu.add(menuSave);
        toolsMenu.add(menuClear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(scroll, BorderLayout.CENTER);

        // Action listeners
        btnProcess.addActionListener(e -> doProcess());
        menuProcess.addActionListener(e -> doProcess());

        btnSave.addActionListener(e -> doSave());
        menuSave.addActionListener(e -> doSave());

        menuClear.addActionListener(e -> textArea.setText(""));
        menuExit.addActionListener(e -> dispose());

        // show
        setVisible(true);
    }

    private void doProcess() {
        int selection = comboReport.getSelectedIndex(); // 0=all,1=year1,2=year2
        StringBuilder sb = new StringBuilder();
        sb.append("Hospital Operations Report\n");
        sb.append("============================\n");
        switch (selection) {
            case 0:
                sb.append("Report: Total Operations (All Years)\n");
                sb.append("Year 1 Total: ").append(operations.getYearTotal(1)).append("\n");
                sb.append("Year 2 Total: ").append(operations.getYearTotal(2)).append("\n");
                sb.append("Overall Total: ").append(operations.getTotal()).append("\n");
                break;
            case 1:
                sb.append("Report: Year 1 Total Operations\n");
                sb.append("Year 1 Total: ").append(operations.getYearTotal(1)).append("\n");
                break;
            case 2:
                sb.append("Report: Year 2 Total Operations\n");
                sb.append("Year 2 Total: ").append(operations.getYearTotal(2)).append("\n");
                break;
        }
        textArea.setText(sb.toString());
    }

    private void doSave() {
        String content = textArea.getText();
        if (content == null || content.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nothing to save. Please Process first.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write(content);
            JOptionPane.showMessageDialog(this, "Data saved to data.txt", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main to launch the GUI with the provided totals (Year1=1150, Year2=1050)
    public static void main(String[] args) {
        // Using the totals the user provided
        Operations ops = new Operations(1150, 1050);
        SwingUtilities.invokeLater(() -> new HospitalGUI(ops));
    }
}