package IOdemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 转换流练习：指定编码读取文本文件（解决中文乱码问题）
 */
public class ConvertStreamDemo {
    public static void main(String[] args) {
        String filePath = "gbk_file.txt"; // 假设该文件是GBK编码

        // InputStreamReader：字节流转字符流，指定编码
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "GBK"); // 指定GBK编码
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            System.out.println("=== 按GBK编码读取文件 ===");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // 也可以指定UTF-8编码写入
            // OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf8_file.txt"), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}