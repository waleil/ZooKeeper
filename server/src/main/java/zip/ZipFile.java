package zip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Auther: csx
 * @Date: 2022/3/27 22:22
 * @Description:
 */
public class ZipFile {
    public static void main(String[] args) throws Exception {

        //建立文件对象
        File file=new File("D:\\ssl\\test.zip");
        //创建zip输出流
        FileOutputStream fileOut = new FileOutputStream(file);
        ZipOutputStream zipOut = new ZipOutputStream(fileOut);

        //创建zipEntry对象
        ZipEntry zipEntry = new ZipEntry("my.txt");
        //将ZipEntry对象添加到Zip输出流中
        zipOut.putNextEntry(zipEntry);
        //向my.txt文件中写入数据
        zipOut.write("大家好，我时老杜".getBytes());
        zipOut.closeEntry();
        zipOut.close();
    }
}
