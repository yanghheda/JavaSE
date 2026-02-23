package IOdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流练习：带缓冲的文本文件读写（效率更高，适合大文本）
 */
public class CharStreamReadWriteDemo {
    public static void main(String[] args) {
        // 写入文本文件
        writeText("test.txt", "Hello Java IO!\n你好，Java IO流！\n这是第三行内容。");

        // 读取文本文件
        readText("test.txt");
    }

    /**
     * 写入文本内容到文件
     * @param filePath 文件路径
     * @param content 要写入的内容
     */
    private static void writeText(String filePath, String content) {
        // BufferedWriter：缓冲字符输出流，提升写入效率
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content); // 写入内容
            System.out.println("文本写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按行读取文本文件内容
     * @param filePath 文件路径
     */
    private static void readText(String filePath) {
        // BufferedReader：缓冲字符输入流，按行读取更方便
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; // 存储每行内容
            System.out.println("=== 读取文本内容 ===");
            // readLine()：读取一行，返回null表示读取完毕
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}