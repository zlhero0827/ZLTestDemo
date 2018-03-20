import java.io.File;

public class FileDemo {
    public static void delFolder(String folderPath){
        //删所有内容
        delAllFiles(folderPath);
        //删空文件件
        String filePath = folderPath.toString();
        File myFilePath = new File(filePath);
        myFilePath.delete();//删空文件夹
    }

    //删所有文件
    public static boolean delAllFiles(String path){
        boolean flag = false;
        File file = new File(path);
        if(!file.exists()){
            return flag;
        }
        if(!file.isDirectory()){
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for(int i=0; i<tempList.length; i++){
            if(path.endsWith(File.separator)){
                temp = new File(path + tempList);
            }else{
                temp = new File(path + File.separator + tempList[i]);
            }
            if(temp.isFile()){
                temp.delete();
            }
            if(temp.isDirectory()){
                delAllFiles(path + File.separator+tempList[i]);//先删文件夹里边的内容
                delFolder(path + File.separator + tempList[i]); //再删空文件夹
                flag =true;
            }
        }
        return flag;
    }
}
