package src.ui;

// UI stuff
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

// Highlighting
import src.fmt.Highlighter;

// Formatting
// import src.fmt.Formatter;

public class EditorPanel extends JPanel{
    private JTextPane text_pane;
    private JTextPane prev_pane;
    private JSplitPane splitPane; 

    // Use this field to check if formatting is enabled
    // However you must find a way to set it when a user 
    // change from "Highlight only", to "Highlight & format"
    private boolean format = false;

    public EditorPanel(){  
        // Setup GUI Components
        initUI();

        // Set documents event listener
        setEvents();
    }

    public void initUI(){
        // Layout
        setLayout(new BorderLayout());

        // Preview Pane
        prev_pane = new JTextPane();
        prev_pane.setEditable(false);
        prev_pane.setBackground(Color.BLACK);

        JScrollPane prev_scroll = new JScrollPane(prev_pane);

        // Editor Pane
        text_pane = new JTextPane();
        JScrollPane text_scroll = new JScrollPane(text_pane);
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, text_scroll, prev_scroll);
        splitPane.setResizeWeight(0.5);
        splitPane.setOneTouchExpandable(false);
        splitPane.setEnabled( true );

        add(splitPane);
    }
    private void setEvents(){
        text_pane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDocument();
            }
        });
    }
    // All highlighting & Formating logic goes here
    private void updateDocument(){
        // We must do format also 
        if (this.format ){
            // Ok, then do formating first
            doformat();
        }

        // At the end do highlighting too
        dohighlight();
    }
    private void doformat(){
        // Add your formatting logic here
    }
    
    private void dohighlight(){
        Highlighter h = new Highlighter();
        prev_pane.setDocument(h.apply(text_pane.getText()));
    }

}