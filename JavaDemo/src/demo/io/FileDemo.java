package demo.io;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by wim on 2017/7/26.
 */
public class FileDemo {

    public void createNewFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                if (file.createNewFile()){
                    System.out.println("创建成功");
                }
                else {
                    System.out.println("创建失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()){
                System.out.println("删除成功");
            }
            else {
                System.out.println("删除失败");
            }
        }
        else {
            System.out.println("文件不存在");
        }
    }

    public void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()){
                System.out.println("创建文件夹成功");
            }
            else {
                System.out.println("创建文件夹失败");
            }
        }
    }

    public void listAll(String path) {
        File file = new File(path);
        String[] files = file.list();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    public void listFile(String path) {
        File file = new File(path);
        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File tempFile = new File(dir, name);
                if (tempFile.isFile()) {
                    return true;
                }
                return false;
            }
        });
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }



    public static void main(String[] args) throws IOException {
        String curPath  = "/Users/wim/Desktop/resource";
        String path = "/Users/wim/Desktop/resource/file.txt";
        FileDemo fileDemo = new FileDemo();
        fileDemo.createNewFile(path);
//        fileDemo.deleteFile(path);

        String dirPath = "/Users/wim/Desktop/resource/temp";
        fileDemo.createDir(dirPath);

        fileDemo.listFile(curPath);
    }
}
