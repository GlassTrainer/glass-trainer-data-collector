package arduino.app;

import arduino.services.SerialPortConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Serhat CAN on 02.05.2015.
 */
public class CollectorUI extends JPanel {

    // UI Elements
    private JButton btnStart;
    private JButton btnStop;
    private JTextField txtTrainingName;
    private JLabel lblResult;
    private JLabel lblException;

    // Connection and other elements
    private SerialPortConnection connection;

    public CollectorUI() {
        prepareGUI();
    }

    private void prepareGUI() {
        btnStart            = new JButton("Start");
        btnStop             = new JButton("Stop");
        txtTrainingName     = new JTextField(20);
        lblResult           = new JLabel();
        lblException        = new JLabel();
        lblException.setForeground(Color.RED);

        add(btnStart);
        add(btnStop);
        add(txtTrainingName);
        add(lblResult);
        add(lblException);

        btnStart.addActionListener(new DataCollectorStartEvent());
        btnStop.addActionListener(new DataCollectorStopEvent());
    }


    private class DataCollectorStartEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String trainingName = txtTrainingName.getText();
            lblResult.setText("Training name is " + trainingName);
            connection = new SerialPortConnection();
            try {
                connection.initialize(trainingName);
            } catch (SerialPortConnection.ComPortNotFoundException e1) {
                lblException.setText("Com port not found!");
            }
        }
    }

    private class DataCollectorStopEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lblResult.setText("Training stopped.");
            connection.close();
        }
    }

    public static void main(String[] args) {
        CollectorUI collectorUI = new CollectorUI();

        JFrame frame = new JFrame("Tenant Terror");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(6, 1));
        frame.add(collectorUI);
        frame.setVisible(true);

    }

}
