package cc;
/*
������ ��������� �����
 */

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Scanner;

public class FileDecoder {
    private static final String SOURCE_CODEPAGE = "ISO8859_5"; //Cp866 ��� DOS, Cp1251 ��� Windows-1251, KOI8_R ��� ���-8
    private static final String DEST_CODEPAGE = "windows-1251";

    public static void main(String[] args) {
        String sourcePath = getSourceFile();
        if (sourcePath != null) {
            String destPath = getDestinationFile(sourcePath);
            Charset charsetSource = Charset.forName(SOURCE_CODEPAGE);
            Charset charsetDest = Charset.forName(DEST_CODEPAGE);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath), charsetSource));
                 PrintStream writer = new PrintStream(destPath, charsetDest)) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    writer.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getSourceFile() {
        String result;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("������� ���� � �����:");
        result = keyboard.nextLine();
        try (FileInputStream fis = new FileInputStream(result)) {
        } catch (IOException e) {
            result = null;
            System.out.println("���� � ����� ������ �������");
            ;
        } finally {
            keyboard.close();
            return result;
        }
    }

    private static String getDestinationFile(String sourceFile) {
        String sourceFileName = Path.of(sourceFile).getFileName().toString();
        int pointIndex = sourceFileName.indexOf(".");
        String destFileName = sourceFileName.substring(0, pointIndex) + "_copy." +
                sourceFileName.substring(pointIndex + 1);
        return Path.of(sourceFile).getParent().resolve(Path.of(destFileName)).toString();
    }
}
