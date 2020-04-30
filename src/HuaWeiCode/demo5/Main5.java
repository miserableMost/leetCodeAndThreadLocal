package HuaWeiCode.demo5;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;


public class Main5 {

    private static ArrayList<String> testdata;
    private static ArrayList<String> resultdata;
    //使用并发安全的CopyOnWriteArrayList
    private static CopyOnWriteArrayList<CopyOnWriteArrayList<Integer>> lists;
    public static void main(String[] args) {

        double starttime = System.currentTimeMillis();

        testdata = new ArrayList<>();
        resultdata = new ArrayList<>();
        //新建一个list
        lists = new CopyOnWriteArrayList<>();
        readFile();

        Method2 method = new Method2();
//        Method1 method = new Method1();
        method.generateGraph(testdata);
        method.findLoop(lists);



        method.sortByDic(lists);
        writeFile1(lists);

        double endtime = System.currentTimeMillis();
        System.out.println("程序运行时间:" + (endtime-starttime) + "ms");
    }

    //读测试文件
    private static void readFile(){
        System.out.println("开始读入文件....");
        String pathname = "E:\\data\\test_data4.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader))
        {
            String s;
            while ((s = br.readLine()) != null) {
                testdata.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读入完成......");
    }

    //写入结果
    private static void writeFile(ArrayList<String> list){
        String path = "E:\\projects\\student\\result.txt";
        System.out.println("开始写入文件...");
        try {
            File file = new File(path);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : list){
                out.write(s+"\r\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeFile1( CopyOnWriteArrayList<CopyOnWriteArrayList<Integer>> list){
        String path = "E:\\projects\\student\\resultthread0028.txt";
        System.out.println("开始写入文件...");
        try {
            File file = new File(path);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(list.size()+"\r\n");
            for(CopyOnWriteArrayList<Integer> li : list){
                if(li.size()<=2) continue;
                for(Integer i : li){
                    out.write(i+",");
                }
                out.write("\r\n");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeFile2(ArrayList<Integer>[] arr){
        String path = "C:\\Users\\91659\\Desktop\\HUAWEI_code2020\\data\\projects\\student\\result.txt";

        try {
            File file = new File(path);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(arr.length+"\r\n");
            for(ArrayList<Integer> li : arr){
                if(li.size()<=2) continue;
                for(int i=0; i<li.size(); i++){
                    if(i<li.size()-1){
                        out.write(li.get(i)+",");
                    }else {
                        out.write(li.get(i).toString());
                    }
                }
                out.write("\r\n");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
