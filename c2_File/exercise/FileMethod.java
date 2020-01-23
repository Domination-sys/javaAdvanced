package javaAdvanced.c2_File.exercise;

import java.io.*;

public class FileMethod {

    //复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile
    public static void copyFile(File copyFile, File dstFile){
        byte[] buffer = new byte[1024];
        try(
                FileInputStream fis = new FileInputStream(copyFile);
                FileOutputStream fos = new FileOutputStream(dstFile);
        ){
            while(true){
                int actuallyRead = fis.read(buffer);
                if(-1==actuallyRead)
                    break;
                fos.write(buffer,0,actuallyRead);
                //flush是吧数据立即写到硬盘中，而不是等buffer满了才写
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制文件夹,把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
    public static void copyFloder(File copyFloder,File dstFloder){
        if(!copyFloder.exists()|copyFloder.isFile()|!copyFloder.isDirectory())
            return;
        if(!dstFloder.exists())
            dstFloder.mkdirs();
        File[] fileList = dstFloder.listFiles();
        for(File file:fileList){
            if(file.isFile()){
                File newFile = new File(dstFloder,file.getName());
                copyFile(file,newFile);
            }
            if(file.isDirectory()){
                File newFloder = new File(dstFloder,file.getName());
                copyFloder(file,newFloder);
            }
        }
    }

    //查找文件夹中的关键词
    public static void search(File srcFile,String search){
        if(srcFile.getName().contains(search))
            System.out.println("位于 "
                    + srcFile.getAbsolutePath() +
                    " 的: "
                    +srcFile.getName()+
                    " 名称包含关键词"+search);
        if(srcFile.exists()|srcFile.canRead()){
            if(readContent(srcFile).contains(search))
                System.out.println("位于 "
                        + srcFile.getAbsolutePath() +
                        " 的: "
                        +srcFile.getName()+
                        " 文件内容中包含关键词"+search);
            if(srcFile.isDirectory()){
                File[] fileList = srcFile.listFiles();
                for(File file:fileList)
                    search(file,search);
            }
        }
    }
    private static String readContent(File file){
        try(
            FileReader fr = new FileReader(file);
        ){
            char[] all = new char[(int)file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
