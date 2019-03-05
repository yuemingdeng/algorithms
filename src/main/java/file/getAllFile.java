package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class getAllFile {
    /**
     * 递归获取某路径下的所有文件,并输出
     */
    public static List<String> getFilesNames(String path, List<String> list) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fi : files) {
                if (fi.isDirectory()) {
                    getFilesNames(fi.getPath(), list);
                } else {
                    list.add("文件： " + fi.getPath());
                }
            }
        } else {
            list.add("文件： " + file.getPath());
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        List<String> list1 = getFilesNames("E:\\games", list);
        for (String ss : list1) {
            System.out.println(ss);
        }
    }
}
