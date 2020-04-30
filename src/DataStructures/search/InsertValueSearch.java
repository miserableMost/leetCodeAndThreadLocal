package DataStructures.search;

/**
 * 适用：关键字分布均匀，数据量较大时使用
 */
public class InsertValueSearch {
    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100 ; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr,0,arr.length - 1,99);
        System.out.println(index);
        //System.out.println(Arrays.toString(arr));
    }
    //编写插值查找算法

    /**
     * 插值查找算法也要求数组有序
     * @param arr   数组
     * @param left   左边索引
     * @param right  右边索引
     * @param findVal  如果找到。返回对应的下标
     * @return
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
            System.out.println("查找次数·");
            //注意：findVal < arr[0] || findVal > arr[arr.length-1]两个条件必须需要，否则得到的mid可能越界
            if(left > right || findVal < arr[0] || findVal > arr[arr.length-1]){
                return -1;
            }
            //自适应公式
            int mid = left + (right - left) * (findVal - arr[left])/(arr[right] - arr[left]);
            int midVal = arr[mid];
            if(findVal > midVal){
                //说明应该向右边递归
                return insertValueSearch(arr,mid+1,right,findVal);
            }else if(findVal < midVal){
                return insertValueSearch(arr,left,mid - 1,findVal);
            }else{
                return mid;
            }

        }


}
