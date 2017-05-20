package com.music.web.util;

import com.music.web.constant.CommonConstants;

import java.io.*;

/**
 *  文件工具类
 * Created by Administrator on 2017/4/24.
 */
public class FileUtil {

    public static String getPostfix(String path) {
        if (path == null || CommonConstants.EMPTY.equals(path.trim())) {
            return CommonConstants.EMPTY;
        }
        if (path.contains(CommonConstants.POINT)) {
            return path.substring(path.lastIndexOf(CommonConstants.POINT) + 1, path.length());
        }
        return CommonConstants.EMPTY;
    }


    //将数据写进文件中
    public static Boolean writeDataToFile(String content,File file)throws  Exception{
        boolean flag = true;
        //判断文件是否存在
        try{

            if(!file.exists()){
                file.createNewFile();
            }

            //写入数据
            String str = new String(); //原有txt内容
            String s1 = new String();//内容更新

            BufferedReader input = new BufferedReader(new FileReader(file));
            while ((str = input.readLine()) != null) {
                s1 += str + "\n";
            }

            input.close();
            s1 += content;

            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(s1);
            output.close();

        }catch(Exception e){
            flag = false;
            e.printStackTrace();
        }

        return  flag;

    }

    /**
     * 读TXT文件内容
     * @param fileName
     * @return
     */
    public static String readTxtFile(File fileName)throws Exception{
        String result=null;
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        try{
            fileReader=new FileReader(fileName);
            bufferedReader=new BufferedReader(fileReader);
            try{
                String read=null;
                while((read=bufferedReader.readLine())!=null){
                    result=result+read+"\r\n";
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(bufferedReader!=null){
                bufferedReader.close();
            }
            if(fileReader!=null){
                fileReader.close();
            }
        }

        return result;
    }

}
