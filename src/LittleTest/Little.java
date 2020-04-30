package LittleTest;

public class Little {
    //此测试证明，由M复制出来的数组，随M变化而变化
    public static void main(String[] args) {
        /*int[][] M = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        *//*System.out.println(M[0][0]);*//*
        int[][] newArray = M;
        M[0][0] = 10;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[0].length; j++) {
                System.out.print(newArray[i][j]+" ");
            }
            System.out.println(",");
        }*/
        String s = 10 + 5 + "sdd";
        System.out.println(s);
    }
}
