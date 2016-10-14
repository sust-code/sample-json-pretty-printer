import javax.swing.UIManager;
import src.ui.MainWindow;

public class Application {
    public static void main(String args[]) {
        try {
            // Set Windows Look and Feel if possible
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (Exception e) {
            // We did our best
        }
        MainWindow app = new MainWindow(); 
        app.lunch();
    }
}