package HuaWeiCode.demo2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main2 {

    private static ArrayList<String> testdata;
    private static ArrayList<String> resultdata;

    public static void main(String[] args) {
        testdata = new ArrayList<>();
        resultdata = new ArrayList<>();
        readFile();

        Method method = new Method();
        //1.建有向图
        HashMap<Integer, Set<Integer>> graph = method.generateGraph(testdata);
//        method.graphtest(graph);
        //2.查找所有循环路径
        ArrayList<ArrayList<Integer>> lists = method.findCirlePath(graph);
//        for(ArrayList<Integer> li : lists){
//            System.out.println(li.toString());
//        }

        writeFile1(lists);

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
        String path = "E:\\projects\\student\\result.txt";

        try {
            File file = new File(path);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(list.size()+"\r\n");
            for(ArrayList<Integer> li : list){
                for(Integer i : li){
                    out.write(i+",");
                }
                out.write("\r\n");
                out.flush();
            }

//            for(String s : list){
//                out.write(s+"\r\n");
//                out.flush();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
