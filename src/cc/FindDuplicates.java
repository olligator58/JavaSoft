package cc;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    private static final String[] EXC_SYMBOLS = {"!"}; // �������, ������� ������������ ��� ������ ������

    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        String fileName = FileHelper.chooseSourceFile("�������� ����, � ������� ����� �������� �����");

        if (fileName != null) {
            int doublesCounter = 0;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    for (String symbol : EXC_SYMBOLS) {
                        line = line.replaceAll(symbol, "");
                    }
                    if (words.contains(line)) {
                        System.out.println(String.format("�����: %s", line));
                        doublesCounter++;
                    } else {
                        words.add(line);
                    }
                }
                if (doublesCounter == 0) {
                    System.out.println(String.format("����� �� ����������. ����� ���������� ��������: %d", words.size()));
                } else {
                    System.out.println(String.format("���������� %s ������", doublesCounter));
                }
            } catch (IOException ignored) {
            }
        }
    }
}
