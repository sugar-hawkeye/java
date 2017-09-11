package demo.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by wim on 2017/8/16.
 */

//r：以只读方式打开指定文件。如果试图对该RandomAccessFile指定的文件执行写入方法则会抛出IOException
//rw：以读取、写入方式打开指定文件。如果该文件不存在，则尝试创建文件
//rws：以读取、写入方式打开指定文件。相对于rw模式，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备，
//     默认情形下(rw模式下),是使用buffer的,只有cache满的或者使用RandomAccessFile.close()关闭流的时候儿才真正的写到文件
//rwd：与rws类似，只是仅对文件的内容同步更新到磁盘，而不修改文件的元数据

public class RandomFileDemo {

    private String path;
    private String mode;

    public RandomFileDemo (String path, String mode) {
        this.path = path;
        this.mode = mode;

    }

    private RandomAccessFile getRandomAccessFile (){
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, mode);
            return randomAccessFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized void read() {
        RandomAccessFile randomAccessFile = getRandomAccessFile();
        byte[] temp = new byte[1024];
        int hasRead = 0;
        try {
            while ((hasRead=randomAccessFile.read(temp)) > 0){
                System.out.println(new String(temp,0,hasRead));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void write(String content) {
        RandomAccessFile randomAccessFile = getRandomAccessFile();
        byte[] bytes = content.getBytes();

        try {
            for (int i = 0; i < bytes.length; i++) {
                randomAccessFile.writeByte(bytes[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        String content = "r：以只读方式打开指定文件。如果试图对该RandomAccessFile指定的文件执行写入方法则会抛出IOException\n" +
                "rw：以读取、写入方式打开指定文件。如果该文件不存在，则尝试创建文件\n" +
                "rws：以读取、写入方式打开指定文件。相对于rw模式，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备，默认情形下(rw模式下),是使用buffer的,只有cache满的或者使用RandomAccessFile.close()关闭流的时候儿才真正的写到文件\n" +
                "rwd：与rws类似，只是仅对文件的内容同步更新到磁盘，而不修改文件的元数据";
        String path = "/Users/wim/Desktop/resource/file.txt";
        RandomFileDemo demo = new RandomFileDemo(path,"rw");
        demo.write(content);
        demo.read();
    }
}
