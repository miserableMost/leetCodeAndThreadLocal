package findJob.second.gcroots;

/**
 * @author 李聪
 * @date 2020/1/25 11:01
 */
public class HelloGC {
    public static void main(String[] args) throws Exception {
        long totalMemory = Runtime.getRuntime().totalMemory();   //返回java虚拟机中的内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();    //返回Java虚拟机试图使用的最大内存量
        System.out.println("TOTAL_MEMORY(-Xms) = "+totalMemory + "(字节)、"+(totalMemory/(double)1024/1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = "+maxMemory + "(字节)、" + (maxMemory / (double)1024 / 20124) + "MB");
    }
}
//如何查看一个正在运行的java程序，它的某个JVM参数是否开启？具体指多少？