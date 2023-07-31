package cc;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class FileHelper {
    private static final String DEFAULT_DIRECTORY = "C:\\work\\РЦ\\files\\";

    public static String chooseSourceFile(String requestText) {
        String result = null;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(requestText);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        JFileChooser fileChooser = new JFileChooser(DEFAULT_DIRECTORY);
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            result = fileChooser.getSelectedFile().toString();
        } else {
            System.out.println("Вы не выбрали требуемый файл. Попробуйте снова.");
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return result;
    }

    public static String chooseSourceDirectory(String requestText) {
        String result = null;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(requestText);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        JFileChooser fileChooser = new JFileChooser(DEFAULT_DIRECTORY);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            result = fileChooser.getSelectedFile().toString();
        } else {
            System.out.println("Вы не выбрали требуемый каталог. Попробуйте снова.");
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return result;
    }
}
