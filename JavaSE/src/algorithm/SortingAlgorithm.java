package algorithm;

import java.util.Arrays;

/**
 * 排序算法
 */
public class SortingAlgorithm {

    /**
     * 1、冒泡排序
     * 思路：外层循环从0到length-1，内循环从当前外层的元素的下一个位置开始，依次和外层的元素比较，出现逆序就交换，通过与相邻元素的比较
     * 和交换来把小的数交换到最前面。
     * 冒泡排序优化版,趟数最少,交换次数最少
     */
    private void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("------第" + (i + 1) + "趟" + "------");
            // 假定每趟开始前数字是按顺序排好的
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 交换了说明不是按顺序排好的 flag置为false
                if (arr[j] > arr[j + 1]) {
                    System.out.println("第" + (j + 1) + "次交换：" + arr[j] + "和" + arr[j + 1]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                } else {
                    System.out.println("第" + (j + 1) + "次未交换");
                }
                System.out.println(Arrays.toString(arr));
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 2、选择排序
     * 思路：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后
     * 放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * 用选择法对5个整数从小到大排序
     *         9    7   6   5   2
     * 第一趟  2	    7	6	5	9   找到最小值和第一个交换
     * 第二趟  2	    5	6	7	9   找到最小值和第二个交换
     * 第三趟  2	    5	6	7	9   找到最小值和第三个交换
     * 第四趟  2  	5	6	7	9   找到最小值和第四个交换
     */
    private void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("------第" + (i + 1) + "趟------");
            // 假定该趟最小值为该趟开始的第一个元素
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    min = j;
                }
            }
            // 交换位置
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 3、插入排序
     * 思路：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。可以理解为玩扑克牌时的理牌；
     * 用插入排序法对几个整数从小到大排序
     *         9 5 6 7 2
     * 第一次  9
     * 第二次  5 9
     * 第三次  5 6 9
     * 第四次  5 6 7 9
     * 第五次  2 5 6 7 9
     */
    private void insertSort(int[] arr) {
        // 从第二个数开始
        for (int i = 1; i < arr.length; i++) {
            System.out.println("插入"+arr[i]);
            // 记录该数据
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                System.out.println(arr[j + 1] + "与" + arr[j] + "交换");
                // 交换
                arr[j + 1] = arr[j];
                //下标向前移动
                j--;
            }
            // 将数据放到对应位置
            arr[j + 1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 4、希尔排序
     * 思路：希尔排序是插入排序的一种高效率的实现，也叫缩小增量排序。先将整个待排记录序列分割成为若干子序列分别进行直接插入排序，待
     * 整个序列中的记录基本有序时再对全体记录进行一次直接插入排序。
     */
    private void shellSort(int[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n/3) { //动态定义间隔序列
            h = 3*h +1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && (arr[j] < arr[j - h]); j -= h) {
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j-h]= temp;
                }
            }
            h /=3;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 5、快速排序
     * 思路：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进
     * 行排序，以达到整个序列有序。
     */
    private void quickSort(int[] arr, int low, int high) {
        int left = low, right = high;
        // 1.选取基准
        int pivot = arr[left];
        System.out.println(pivot);
        // 2.将数组分成左右两部分
        while(left < right){
            // 如果没有比基准值小的，比较下一个，直到有比基准值小的交换位置，然后又从前往后比较
            while(left < right && arr[right] >= pivot){
                right--;
            }
            if(left < right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                // 交换后,arr[left]没必要跟基准在比较了
                left++;
            }
            // 如果没有比基准值大的，比较下一个，直到有比基准值大的交换位置，然后又从后往前比较
            while(left < right && arr[left] <= pivot){
                left++;
            }
            // 交换位置
            if(left < right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                // 交换后,arr[high]没必要跟基准在比较了
                right--;
            }
        }
        // 此时第一次循环比较结束，基准值的位置已经确定了。左边的值都比基准值小，右边的值都比基准值大，
        // 但是两边的顺序还有可能是不一样的，进行下面的递归调用
        if(left > low){
            quickSort(arr,low,left-1);
        }
        if(right < high){
            quickSort(arr,right+1,high);
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = {13, 4, 9, 11, 7, 23, 18};
        // int[] arr = {18, 9, 7, 6, 4, 3 , 1};
        // int[] arr = {5, 4, 3, 2, 1};
        SortingAlgorithm sa = new SortingAlgorithm();
        // sa.BubbleSort(arr);
        sa.quickSort(arr,0,arr.length-1);
    }
}