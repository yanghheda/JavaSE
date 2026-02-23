package filedemo;

import java.io.File;
import java.io.IOException;

/**
 * File类基础操作练习：创建/删除文件/目录、判断文件属性
 */
public class FileBasicDemo {
    public static void main(String[] args) {
        // 1. 定义文件路径（注意：Windows用\\，Linux/Mac用/）
        File file = new File("test.txt");
        File dir = new File("testDir\\subDir"); // 多级目录

        try {
            // 2. 判断文件是否存在，不存在则创建
            if (!file.exists()) {
                boolean isCreated = file.createNewFile(); // 创建文件
                System.out.println("文件创建结果：" + isCreated);
            }

            // 3. 判断目录是否存在，不存在则创建（mkdir()只能创建单级，mkdirs()创建多级）
            if (!dir.exists()) {
                boolean isDirCreated = dir.mkdirs(); // 创建多级目录
                System.out.println("目录创建结果：" + isDirCreated);
            }

            // 4. 获取文件/目录的属性信息
            System.out.println("=== 文件属性 ===");
            System.out.println("是否为文件：" + file.isFile());
            System.out.println("是否为目录：" + file.isDirectory());
            System.out.println("文件路径：" + file.getPath());
            System.out.println("绝对路径：" + file.getAbsolutePath());
            System.out.println("文件大小（字节）：" + file.length());

            // 5. 删除文件/目录（删除目录时需确保目录为空）
            boolean isFileDeleted = file.delete();
            System.out.println("文件删除结果：" + isFileDeleted);
            // 先删除子目录，再删除父目录
            boolean isSubDirDeleted = new File("testDir/subDir").delete();
            boolean isDirDeleted = new File("testDir").delete();
            System.out.println("目录删除结果：" + (isSubDirDeleted && isDirDeleted));

        } catch (IOException e) {
            e.printStackTrace(); // 捕获创建文件时的异常
        }
    }
}