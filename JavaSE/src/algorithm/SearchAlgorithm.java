package algorithm;

/**
 * 查找算法
 */
public class SearchAlgorithm {

    /**
     * 顺序查找
     * 基本思想：顺序查找也称为线形查找，属于无序查找算法。从数据结构线形表的一端开始，顺序扫描，依次将扫描到的结点关键字与给定值k
     * 相比较，若相等则表示查找成功；若扫描结束仍没有找到关键字等于k的结点，表示查找失败。
     * 复杂度分析：
     * 　　查找成功时的平均查找长度为：（假设每个数据元素的概率相等） ASL = 1/n(1+2+3+…+n) = (n+1)/2 ;
     * 　　当查找不成功时，需要n+1次比较，时间复杂度为O(n);
     * 　　所以，顺序查找的时间复杂度为O(n)。
     */
    private int sequenceSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 说明：元素必须是有序的，如果是无序的则要先进行排序操作。
     * 基本思想：也称为是折半查找，属于有序查找算法。用给定值k先与中间结点的关键字比较，中间结点把线形表分成两个子表，若相等则查找
     * 成功；若不相等，再根据k与该中间结点关键字的比较结果确定下一步查找哪个子表，这样递归进行，直到查找到或查找结束发现表中没有这
     * 样的结点。
     * 复杂度分析：最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为O(log2n)；
     */
    private int binarySearch(int[] arr, int value) {
        int min = 0, max = arr.length - 1, mid;
        // (max + min)/2;
        mid = (max + min) >> 1;
        while (arr[mid] != value) {
            if (value > arr[mid]) {
                min = mid + 1;
            } else if (value < arr[mid]) {
                max = mid - 1;
            }
            if (max < min) {
                return -1;
            }
            mid = (max + min) >> 1;
        }
        return mid;
    }

    /**
     * 插值查找
     * 基本思想：基于二分查找算法，将查找点的选择改进为自适应选择，可以提高查找效率。当然，差值查找也属于有序查找。
     * 注：对于表长较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好的多。反之，数组中如果分布非常不
     * 均匀，那么插值查找未必是很合适的选择。
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(log2(log2n))。
     */
    private int insertionSearch(int[] arr, int value, int low, int high) {
        int mid = low + (value - arr[low]) / (arr[high] - arr[low]) * (high - low);
        System.out.println("----------"+ mid +"---------");
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return insertionSearch(arr, value, low, mid - 1);
        } else if (arr[mid] < value) {
            return insertionSearch(arr, value, mid + 1, high);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        SearchAlgorithm sa = new SearchAlgorithm();
        int i = sa.insertionSearch(arr, 7,0,arr.length-1);
        System.out.println(i);
    }

}
