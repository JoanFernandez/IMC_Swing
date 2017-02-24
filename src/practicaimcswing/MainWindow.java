package practicaimcswing;

import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame implements ActionListener {
        
        private JTextField weight;
        private JTextField height;
    
        public MainWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(350, 400);
		setVisible(true);
                setResizable(false);
                
                WindowListener listener = new WindowAdapter() {
                    public void windowClosing(WindowEvent w) {
                        int response = JOptionPane.showConfirmDialog(null, " Are you sure?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    }
                };
        
                addWindowListener(listener);
                
                Container cp = getContentPane();
                cp.setLayout(new FlowLayout());
                                               
                //TextField creation           
                weight = new JTextField(20);
                weight.setMargin(new Insets(10,10,10,10));                                                
                
                height = new JTextField(20);
                height.setMargin(new Insets(10,10,10,10));
                
                JLabel heightLb = new JLabel("Height");
                JLabel weightLb = new JLabel("Weight");
                
                JButton compute = new JButton("Compute");
                compute.setActionCommand("compute");
                compute.addActionListener(this);
                
                JButton clear = new JButton("Clear");
                clear.setActionCommand("clear");
                clear.addActionListener(this);
                
                cp.add(weightLb);
                cp.add(weight);
                cp.add(heightLb);
                cp.add(height);
                cp.add(compute);
                cp.add(clear);
                
                
                initializeMenu();
        }
        
        private void initializeMenu()
        {
        
            JMenuBar menu = new JMenuBar();
            
            //File
            JMenu menuFile = new JMenu("File");
            menuFile.setToolTipText("File menu");
            
            JMenuItem mnExit = new JMenuItem("Exit");
            mnExit.setToolTipText("Exit from application");
            mnExit.setActionCommand("exit");
            mnExit.addActionListener(this);
            
            menuFile.add(mnExit);            
            menu.add(menuFile);
                       
            //Edit
            JMenu menuEdit = new JMenu("Edit");
            menuFile.setToolTipText("Edit menu");            
            
            JMenuItem mnCopy = new JMenuItem("Clear");
            mnCopy.setActionCommand("clear");
            mnCopy.addActionListener(this);                        
            
            JMenuItem mnPaste = new JMenuItem("Compute");
            mnPaste.setActionCommand("compute");
            mnPaste.addActionListener(this);
            
            menuEdit.add(mnCopy);
            menuEdit.add(mnPaste);        
            menu.add(menuEdit);
            
            //Help
            JMenu menuHelp = new JMenu("Help");
            menuFile.setToolTipText("Help menu");
                        
            JMenuItem mnHelp = new JMenuItem("Help");
            mnHelp.setActionCommand("help");
            mnHelp.addActionListener(this);                        
            
            JMenuItem mnAbout = new JMenuItem("About");
            mnAbout.setActionCommand("about");
            mnAbout.addActionListener(this);
            
            menuHelp.add(mnHelp);
            menuHelp.add(mnAbout);
            menu.add(menuHelp);
            
            setJMenuBar(menu);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand())
        {
            case "exit":
                int dialog = JOptionPane.showConfirmDialog (null, "Are you sure?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
                if(dialog == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }                
            break;
            
            case "clear":
                weight.setText("");
                height.setText("");
            break;
            
            case "compute":
                try
                {
                    double heightNumber = Double.parseDouble(height.getText());
                    double weightNumber = Double.parseDouble(weight.getText());                                       
                    
                    double finalHeight = heightNumber*heightNumber;
                    
                    double imc = weightNumber/finalHeight;
                    JOptionPane.showMessageDialog(this, "The IMC is: "+imc);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Values must be a number!");
                }                
            break;
            
            case "help":
                JOptionPane.showMessageDialog(this, "This is an IMC calculator");
            break;
            
            case "about":
                JOptionPane.showMessageDialog(this, "Version 1.0 / Joan Fernández");
            break;
            
            default:
                JOptionPane.showMessageDialog(this, "Has clicat la opció: " + e.getActionCommand());
            break;                                
        }               
    }
}