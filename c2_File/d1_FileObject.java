package javaAdvanced.c2_File;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class d1_FileObject {
    public static void main(String[] args) throws IOException {

        //创建文件对象
        File file = new File("/Users/wangbotao/IdeaProjects/JavaSE/BTjava/src/javaAdvanced/c2_File/WangBaiTao.zuishuai");
        System.out.println("file的绝对路径是"+file.getAbsolutePath());

        //文件常用方法
        System.out.println("当前文件是："+file);
        System.out.println("当前文件是否存在"+file.exists());
        System.out.println("当前文件是否是文件夹"+file.isDirectory());
        System.out.println("当前文件是否是文件"+file.isFile());
        System.out.println("当前文件长度"+file.length());
        long time = file.lastModified();
        Date date = new Date(time);
        System.out.println("文件最后修改时间为"+date);

        //其他常用方法
        File f= file;

        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        f.list();

        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[]fs= f.listFiles();

        // 以字符串形式返回获取所在文件夹
        f.getParent();

        // 以文件形式返回获取所在文件夹
        f.getParentFile();

        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f.mkdir();

        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();

        // 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
        f.createNewFile();

        // 所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();

        // 列出所有的盘符c: d: e: 等等
        f.listRoots();

        // 刪除文件
        f.delete();

        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();
    }
}