package cc;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class FileHelper {

    public static String chooseSourceFile(String requestText) {
        String result = null;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(requestText);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            result = fileChooser.getSelectedFile().toString();
        } else {
            System.out.println("Вы не выбрали требуемый файл. Попробуйте снова.");
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return result;
    }
}
