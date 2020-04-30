package medium2;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 */
public class T223_computeArea_9_24 {
    public static void main(String[] args) {
        int i = computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println(i);
    }
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = (C - A) * (D - B);
        int s2 = (G - E) * (H - F);
        if(H < B || D < F || C < E || G < A){
            return s1 + s2;
        } else {
            int sub = (Math.min(D, H) - Math.max(B, F)) * (Math.min(C, G) - Math.max(A, E));
            return s1 + s2 - sub;
        }

    }
}
