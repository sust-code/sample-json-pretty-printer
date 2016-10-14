package src.ui;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class ToolBar extends JToolBar {
    private JComboBox<String> tab_menu;
    private JComboBox<String> options_menu;

    public ToolBar() {
        // disable dragging
        setFloatable(false);

        initUI();
    }
    public void initUI() {
        // Set Layout
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Theme Selection Menu
        String[] options = { "Highlight only", "Highlight & Format" };
        options_menu = new JComboBox<String>(options);

        // Tab Size Sellection Menu
        String[] tab_size = { "2", "4", "8" };
        tab_menu = new JComboBox<String>(tab_size);

        // add necessary components  
        add(new JLabel("Options "));
        add(options_menu);
        add(new JLabel("Tab size "));
        add(tab_menu);
    }
}