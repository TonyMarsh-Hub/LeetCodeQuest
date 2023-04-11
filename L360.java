public class L360 {
    /*题目: 给定一个一元二次方程的系数，和一个数组
       将数组中的值做这个一元二次方程的输入，然后将结果组成新的排好序的数组返回。

       这道题是977的加强版，在977中计算的是平方(a=2 b=0 c=0的特殊情况)，
       而这道题计算的是一个给定的一元二次方程。
     */

    /*思路: 大致上和977是一样的，但是要分a > 0 和 a < 0两种情况考虑*/

    int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // 双指针，相向而行，逼近对称轴
        int i = 0, j = nums.length - 1;
        // 如果开口朝上，越靠近对称轴函数值越小
        // 如果开口朝下，越靠近对称轴函数值越大
        int p = a > 0 ? nums.length - 1 : 0;
        int[] res = new int[nums.length];
        // 执行合并两个有序数组的逻辑
        while (i <= j) {
            int v1 = f(nums[i], a, b, c);
            int v2 = f(nums[j], a, b, c);
            if (a > 0) {
                // 如果开口朝上，越靠近对称轴函数值越小
                if (v1 > v2) {
                    res[p--] = v1;
                    i++;
                } else {
                    res[p--] = v2;
                    j--;
                }
            } else {
                // 如果开口朝下，越靠近对称轴函数值越大
                if (v1 > v2) {
                    res[p++] = v2;
                    j--;
                } else {
                    res[p++] = v1;
                    i++;
                }
            }
        }
        return res;
    }


}
