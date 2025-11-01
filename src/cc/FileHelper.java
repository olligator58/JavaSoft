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
        JOptionPane.showMessageDialog(null, requestText, "Выберите файл", JOptionPane.INFORMATION_MESSAGE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        JFileChooser fileChooser = new JFileChooser(DEFAULT_DIRECTORY);
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            result = fileChooser.getSelectedFile().toString();
        } else {
            System.out.println("Вы не выбрали требуемый файл. Попробуйте снова.");
            JOptionPane.showMessageDialog(null, "Вы не выбрали требуемый файл. Попробуйте снова.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return result;
    }

    public static String chooseSourceDirectory(String requestText) {
        String result = null;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(requestText);
        JOptionPane.showMessageDialog(null, requestText, "Выберите каталог", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Вы не выбрали требуемый каталог. Попробуйте снова.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return result;
    }
}
