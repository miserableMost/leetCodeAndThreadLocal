package HuaWeiCode.mutiThreadDemo;

import java.io.*;
import java.util.ArrayList;


public class Main {

    private static ArrayList<String> testdata;
    private static ArrayList<String> resultdata;

    public static void main(String[] args) throws InterruptedException {

        double starttime = System.currentTimeMillis();

        testdata = new ArrayList<>();
        resultdata = new ArrayList<>();
        readFile();

        Method method = new Method();
//        Method1 method = new Method1();
        method.generateGraph(testdata);
        ArrayList<ArrayList<Integer>> lists = method.findLoopPathByMultiThread();
        method.sortByDic(lists);
        writeFile1(lists);

        double endtime = System.currentTimeMillis();
        System.out.println("程序运行时间:" + (endtime-starttime) + "ms");
    }

    //读测试文件
    private static void readFile(){
        String pathname = "E:\\data\\test_data.txt";
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
    }

    //写入结果
    private static void writeFile(ArrayList<String> list){
        String path = "E:\\projects\\student\\result.txt";

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

    private static void writeFile1(ArrayList<ArrayList<Integer>> list){
        String path = "E:\\projects\\student\\resultok2.txt";

        try {
            File file = new File(path);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(list.size()+"\r\n");
            for(ArrayList<Integer> li : list){
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