package pers.wc.leetcode;

public class T1491 {
    public static void main(String[] args) {
        int[] salary = {4000, 3001, 1000, 2000, 1001};
        System.out.printf("%.5f", average(salary));
    }

    /**
     * 去掉最低工资和最高工资后的工资平均值
     *
     * @param salary 整数数组，salary[i]表示第 i 个员工的工资，每个数都是唯一的
     * @return 返回去掉最低工资和最高工资以后，剩下员工工资的平均值
     */
    public static double average(int[] salary) {
        double sumSalary = 0;
        int minSalary = salary[0];
        int maxSalary = salary[0];
        for (int temp : salary) {
            if (minSalary > temp) {
                minSalary = temp;
            }
            if (maxSalary < temp) {
                maxSalary = temp;
            }
            sumSalary += temp;
        }
        sumSalary = sumSalary - minSalary - maxSalary;
        return (sumSalary / (salary.length - 2));
    }
}
