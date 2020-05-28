package com.cxq.java.io.file.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by alm.ccic.chenxiaoq on 2018-06-27.
 */
public class FileSplitAndCombine {

    public void deleteFile(File path){
        if(path.exists()){
            if(path.isDirectory()){
                for(File file : path.listFiles()){
                    deleteFile(file);
                }
            }else{
                path.delete();
            }
        }
    }

    /**
     * 拆文件
     */
    public void fileSplit(){
        System.out.println("==> 请输入需要拆分的文件 ...");
        File path = null;
        while(true){
            Scanner scanner = new Scanner(System.in);
            path = new File(scanner.next());

            System.out.println("==> 输入的文件路径为：" + path.getAbsolutePath());
            if(path.exists()){
                if(path.isDirectory()){
                    System.out.println("==> 输入文件为目录，请重新输入 ...");
                    continue;
                }
                break;
            }
            System.out.println("==> 输入文件为不存在，请重新输入 ...");
        }

        System.out.println("==> 请输入拆分文件大小，单位【M】 ...");
        long fileSize = 0;
        while(true){
            Scanner scanner = new Scanner(System.in);
            try{
                fileSize = Integer.parseInt(scanner.nextLine()) * 1024 * 1024;
                if(fileSize >= 0){
                    break;
                }
                System.out.println("==> 输入数据无效，请重新输入");
            }catch (Exception e){
                System.out.println("==> 输入数据异常，" + e.getMessage());
            }
        }


        //拆分后文件存放路径（存在在当前目录下）
        String dir = (new File("")).getAbsolutePath() + File.separator
                + (path.getName().contains(".") ? path.getName().substring(0,path.getName().lastIndexOf("."))
                : path.getName());
        File desFile = new File(dir);
        if(desFile.exists()){
            System.out.println("==> 清理目标文件目录：" + desFile.getAbsolutePath());
            this.deleteFile(desFile);
        }
        desFile.mkdir();
        doFileSplit(path, desFile, fileSize); //拆分
    }

    public void doFileSplit(File file, File desFile, long fileSize){
        FileInputStream is = null;
        FileOutputStream os = null;
        try{
            System.out.println("==================================================================================");
            System.out.println("====> 开始拆分文件 : " + file.getAbsolutePath() );
            System.out.println("==> 拆分的源文件大小为【" + file.length() + "】");
            is = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int count = 0, index = 0, sum = 0;
            File out = new File(desFile.getAbsolutePath() + File.separator + index);
            os = new FileOutputStream(out);
            while((count = is.read(buffer,0,1024)) > 0){
                os.write(buffer,0,count);
                sum += count;
                if(sum >= fileSize){
                    System.out.println("==> 拆分文件索引【" + index + "】，文件大小【" + out.length() + "】");
                    out = new File(desFile.getAbsolutePath() + File.separator + (++ index));
                    os = new FileOutputStream(out);
                    sum = 0;
                }
            }
            System.out.println("==> 拆分文件索引【" + index + "】，文件大小【" + out.length() + "】");
            os.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("====> 拆分文件结束：" + file.getAbsolutePath());
            System.out.println("==================================================================================");
        }
    }

    public void fileCombine(){
        System.out.println("==> 请输入文件目录 ...");
        File path = null;
        while(true){
            Scanner scanner = new Scanner(System.in);
            path = new File(scanner.next());

            System.out.println("==> 输入的文件路径为：" + path.getAbsolutePath());
            if(path.exists()){
                if(!path.isDirectory()){
                    System.out.println("==> 输入的文件路径不是文件夹，请重新输入 ...");
                    continue;
                }
                break;
            }
            System.out.println("==> 输入的文件路径不存在，请重新输入 ...");
        }

        System.out.println("==> 请输入合并后的文件后缀名，无后缀可直接输入【0】 ...");
        String suffix = "";
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(!"0".equals(suffix)){
            suffix = line;
        }

        //合并后文件存放路径（存在在当前目录下）
        String dir = (new File("")).getAbsolutePath() + File.separator
                +  path.getName() + ("".equals(suffix) ? "" : "." + suffix);
        System.out.println("==> 合并后的文件路径为：" + dir);
        File desFile = new File(dir);
        if(desFile.exists() && !desFile.isDirectory()){
            System.out.println("==> 清理目标文件 :" + desFile.getAbsolutePath());
            desFile.delete();
        }
        doCombine(path, desFile);

    }

    public List<File> fileSort(File[] files){
        List<File> fileList = new ArrayList<File>(Arrays.asList(files));
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(Integer.parseInt(o1.getName()) > Integer.parseInt(o2.getName())){
                    return 1;
                }
                if(Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName())){
                    return -1;
                }
                return 0;
            }
        });
        return fileList;
    }


    public void doCombine(File path,File desFile){
        FileOutputStream os = null;
        FileInputStream is = null;
        try{
            System.out.println("==================================================================================");
            System.out.println("====> 开始合并文件" + desFile.getAbsolutePath());
            os = new FileOutputStream(desFile);
            List<File> fileList = fileSort(path.listFiles());
            for(int index = 0; index < fileList.size(); index ++){
                File file = fileList.get(index);
                System.out.println("==> 合并的子文件路径索引【" + index + "】，路径【" + file.getAbsolutePath() + "】");
                byte[] buffer = new byte[1024];
                is = new FileInputStream(file);
                int count = 0;
                while((count = is.read(buffer,0,1024)) > 0){
                    os.write(buffer,0,count);
                }
            }
            os.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("====> 合并文件结束" + desFile.getAbsolutePath());
        System.out.println("==================================================================================");
    }

    public static void main(String[] args){
        System.out.println("==> 请选择操作模式【“1”：拆分文件；“2”：合并文件】 ...");
        String operate = null;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            operate = scanner.nextLine();
            if("1".equals(operate) || "2".equals(operate)){
                break;
            }
            System.out.println("==> 输入的操作模式错误，请重新输入 ...");
        }

        FileSplitAndCombine splitAndCombine = new FileSplitAndCombine();
        long startTime = System.currentTimeMillis();
        switch (operate){
            case "1" : splitAndCombine.fileSplit(); break;
            case "2" : splitAndCombine.fileCombine(); break;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("======> 操作完成，实际耗时：" + (endTime - startTime));

    }
}
