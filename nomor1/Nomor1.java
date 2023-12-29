package nomor1;

import java.awt.EventQueue;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Nomor1 extends JFrame {

    private JPanel basePanel = null;
    private JLabel labelKonversi = null;
    private JTextField fields = null;
    private JComboBox<String> comboBoxS = null;
    private JLabel labelHasil = null;
    private JTextField fieldR = null;
    private JComboBox<String> comboBoxR = null;
    private JButton buttonConversi = null;
    private JButton buttonClean = null;
    private String[] label = new String[]{
        "KM", "HM", "DAM", "M", "DM", "CM", "MM"
    };

    public Nomor1() {
        initUI();
    }

    private void initUI() {
        setTitle("KONVERSI-NOMOR 1");
        setContentPane(getBasePanel());
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel getBasePanel() {
        if (basePanel == null) {
            basePanel = new JPanel();
//            basePanel.add(getLabelKonversi());
            basePanel.add(getComboBoxS());
            basePanel.add(getFields());

//            basePanel.add(getLabelHasil());
            basePanel.add(getComboBoxR());
            basePanel.add(getFieldR());

            basePanel.add(getButtonConversi());
            basePanel.add(getButtonClean());

        }
        return basePanel;

    }

    private JLabel getLabelKonversi() {
        if (labelKonversi == null) {
            labelKonversi = new JLabel("Konversi Panjang:");

        }
        return labelKonversi;

    }

    private JTextField getFields() {
        if (fields == null) {
            fields = new JTextField(10);

        }
        return fields;

    }

    private JLabel getLabelHasil() {
        if (labelHasil == null) {
            labelHasil = new JLabel("Hasil Konversi:");

        }
        return labelHasil;

    }

    private JTextField getFieldR() {
        if (fieldR == null) {
            fieldR = new JTextField(10);

        }
        return fieldR;

    }

    private JButton getButtonConversi() {
        if (buttonConversi == null) {
            buttonConversi = new JButton("Convert ->");
            buttonConversi.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                    int pilihanInputan;
//                    int pilihanOutput;
//                    double panjang;
//
//                    panjang = Double.parseDouble(fields.getText());
//                    pilihanInputan = comboBoxS.getSelectedIndex();
//                    pilihanOutput = comboBoxR.getSelectedIndex();
//
//                    switch (pilihanInputan) {
//                        case 0:
//                            panjang *= 1000; // mm to m
//                            break;
//                        case 1:
//                            panjang *= 100; // cm to m
//                            break;
//                        case 2:
//                            panjang *= 10; // dm to m
//                            break;
//                        case 3:
//                            // m to m, no conversion needed
//                            break;
//                        case 4:
//                            panjang /= 10; // dam to m
//                            break;
//                        case 5:
//                            panjang /= 100; // hm to m
//                            break;
//                        case 6:
//                            panjang /= 1000; // km to m
//                            break;
//                    }
//
//                    switch (pilihanOutput) {
//                        case 0:
//                            panjang /= 1000; // m to mm
//                            break;
//                        case 1:
//                            panjang /= 100; // m to cm
//                            break;
//                        case 2:
//                            panjang /= 10; // m to dm
//                            break;
//                        case 3:
//                            // m to m, no conversion needed
//                            break;
//                        case 4:
//                            panjang *= 10; // m to dam
//                            break;
//                        case 5:
//                            panjang *= 100; // m to hm
//                            break;
//                        case 6:
//                            panjang *= 1000; // m to km
//                            break;
//                    }
//
//                    fieldR.setText(String.valueOf(panjang));
                    int indexIn = comboBoxS.getSelectedIndex();
                    int indexOut = comboBoxR.getSelectedIndex();

                    String sInput = fields.getText();
                    double input = Double.parseDouble(sInput);
                    double output = convert(indexIn, indexOut, input);
                    fieldR.setText("" + String.format("%.06f", output) );

                    //fieldCM.setText(String.valueOf(Double.parseDouble(fieldKM.getText()) * 100_000));
                }

                private double convert(int dari, int ke, double value) {
                    double result = value;
                    //convert ke km
                    double km = value / Math.pow(10, dari);
                    result = km * Math.pow(10, ke);
                    return result;

                }
            });
        }
        return buttonConversi;
    }

    private JComboBox getComboBoxS() {
        comboBoxS = new JComboBox<>(label);
        return comboBoxS;

    }

    private JComboBox getComboBoxR() {
        comboBoxR = new JComboBox<>(label);
        return comboBoxR;

    }

    private JButton getButtonClean() {
        if (buttonClean == null) {
            buttonClean = new JButton("Clean");
            buttonClean.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fieldR.setText("");
                    fields.setText("");
                }
            });

        }
        return buttonClean;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Nomor1 myWindow = new Nomor1();

            }
        });

    }

}
