package HuaWeiCode.demo4;

import java.io.*;
import java.util.ArrayList;


public class Main {

    private static ArrayList<String> testdata;
    private static ArrayList<String> resultdata;

    public static void main(String[] args) {


        double start = System.currentTimeMillis();
        testdata = new ArrayList<>();
        resultdata = new ArrayList<>();
        //新建一个list

        readFile();

        Method method = new Method();
//        Method1 method = new Method1();
        method.generateGraph(testdata);
        ArrayList<ArrayList<Integer>> lists = method.findLoopPath();


        method.sortByDic(lists);
        writeFile(lists);
        double end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");

    }

    //读测试文件
    private static void readFile(){

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

    }



    private static void writeFile( ArrayList<ArrayList<Integer>> list){
        String path = "E:\\projects\\student\\result.txt";

        try {
            File file = new File(path);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(list.size()+"\r\n");
            for(ArrayList<Integer> li : list){
                if(li.size()<=2) continue;
                for (int i = 0; i < li.size() - 1; i++) {
                    out.write(li.get(i)+",");
                }
                out.write(li.get(li.size() - 1) + "");


                out.write("\r\n");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
