package HuaWeiCode.demo7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main7 {

    private static ArrayList<String> testdata;
    private static ArrayList<String> resultdata;
    private static Graph<Integer> graph = new Graph<>(true);

    public static void main(String[] args) {

        double starttime = System.currentTimeMillis();

        testdata = new ArrayList<>();
        resultdata = new ArrayList<>();
        //新建一个list

        readFile();

       /* Method method = new Method();
//        Method1 method = new Method1();
        //method.generateGraph(testdata);
        ArrayList<ArrayList<Integer>> lists = method.findLoopPath();*/
        //生成有向图
        generateGraph(testdata);
        //使用johnSon算法
        AllCyclesInDirectedGraphJohnson tar = new AllCyclesInDirectedGraphJohnson();
        List<List<Vertex<Integer>>> result = tar.simpleCyles(graph);

        //使用Tarjan算法
      /*  AllCyclesInDirectedGraphTarjan tar2 = new AllCyclesInDirectedGraphTarjan();
        List<List<Vertex<Integer>>> result = tar2.findAllSimpleCycles(graph);*/

        //排序
        sortByDic(result);
      /*  method.sortByDic(lists);*/
        write(result);

        double endtime = System.currentTimeMillis();
        System.out.println("runtime :  " + (endtime-starttime) + "ms");
    }


    //生成有向图
    public static void generateGraph(ArrayList<String> list){

        for(String str : list) {
            int indx1 = 0;
            while (str.charAt(indx1) != ',') indx1++;
            int indx2 = indx1 + 1;
            while (str.charAt(indx2) != ',') indx2++;
            int from = Integer.valueOf(str.substring(0, indx1));
            int to = Integer.valueOf(str.substring(indx1 + 1, indx2));
            graph.addEdge(from,to);


        }
        System.out.println();
    }
    //排序按照新图
    public static void sortByDic(List<List<Vertex<Integer>>> list) {
        Collections.sort(list, new Comparator<List<Vertex<Integer>>>() {
            @Override
            public int compare(List<Vertex<Integer>> o1, List<Vertex<Integer>> o2) {
                if(o1.size() == o2.size()) {
                    int i = 0;
                    while(i <= o1.size() && o1.get(i) == o2.get(i)) {
                        i ++;
                    }
                    if(i > o1.size()) {
                        return 0;
                    }else {
                        return (int) (o1.get(i).id - o2.get(i).id);

                    }
                }else {
                    return o1.size() - o2.size();
                }

            }
        });

    }

    //读测试文件
    private static void readFile(){
        System.out.println("开始读入文件....");
        String pathname = "E:\\data\\test_data2.txt";
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
        String path = "E:\\projects\\student\\result2.txt";
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

    private static void write(List<List<Vertex<Integer>>> result){
        String path = "E:\\projects\\student\\result.txt";
        System.out.println("开始写入文件...");
        try {
            File file = new File(path);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(result.size()+"\r\n");
            for(List<Vertex<Integer>> ve : result){
                if(ve.size()<=2) continue;
                for(Vertex v : ve){
                    out.write(v.id+",");
                }
                out.write("\r\n");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeFile1( ArrayList<ArrayList<Integer>> list){
        String path = "\\projects\\student\\result.txt";
        System.out.println("开始写入文件...");
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
