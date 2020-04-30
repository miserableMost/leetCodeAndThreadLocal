package Test;

import java.io.*;

class Test {


    public static void main(String[] args) throws IOException {
      /* File file = new File("E:\\我做的视频\\20190703_162610.mp4");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("copy.mp4");
        byte[] bys = new byte[1024];
        int len = 0;
        while((len = fis.read(bys)) != -1){
            fos.write(bys,0,len);
        }*/
        FileReader fr = new FileReader("a.txt");
        int len = 0;
        char[] bys = new char[1024];
        while((len = fr.read(bys)) != -1){
            System.out.println(bys);
        }
       /* OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"));
        osw.write("起去你妹");
        osw.flush();
        osw.close();*/

    }
}
interface Person {
    int num = 1;
    void show();
}
interface Man {
    int num2 = 0;
    void show3();
}
interface me extends Man,Person {
    void show2();
}
class Student implements me {
    int num2 = 9;


    @Override
    public void show2() {

    }

    @Override
    public void show() {

    }

    @Override
    public void show3() {

    }
}
/*
class Teacher extends Person {

}*/
