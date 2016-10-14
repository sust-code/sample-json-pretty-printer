package src.ui;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class MainWindow extends JFrame {
    private ToolBar toolbar;
    private EditorPanel panel; 

    private Container pane;

    public MainWindow() {
        setTitle("Beautifier v1.0");
        setPreferredSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        // set layout 
        setLayout(new BorderLayout());

        pane = getContentPane();

        //TODO: You need to add event listeners for Toolbar combo boxes
        toolbar = new ToolBar();
        add(toolbar, BorderLayout.PAGE_START);

        panel = new EditorPanel();
        add(panel, BorderLayout.CENTER);

    }
    public void lunch(){
        pack();
        setVisible(true);  
    }
}
