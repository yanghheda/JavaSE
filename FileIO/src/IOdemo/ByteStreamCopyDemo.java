package IOdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流练习：复制文件（支持图片、视频、文本等所有类型）
 */
public class ByteStreamCopyDemo {
    public static void main(String[] args) {
        // 源文件（建议替换为你本地的文件路径，如图片、txt）
        String srcPath = "123.png";
        // 目标文件
        String destPath = "456.png";

        // 声明流对象（try-with-resources语法：自动关闭流，无需手动close）
        try (FileInputStream fis = new FileInputStream(srcPath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[1024]; // 缓冲区（1KB），减少IO次数，提升效率
            int len; // 每次读取的字节数

            // 循环读取：read(buffer)返回读取的字节数，-1表示读取完毕
            while ((len = fis.read(buffer)) != -1) {
                // 写入：只写入实际读取的字节数（避免最后一次缓冲区不满的问题）
                fos.write(buffer, 0, len);
            }
            System.out.println("文件复制成功！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}