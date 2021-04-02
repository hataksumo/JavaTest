package indi.zhifa.learn.common.math;

/**
 * ZFMath Created by IntelliJ IDEA.
 *
 * @author: 芝法酱
 * @create 2021/3/10 15:26
 */
public final class ZfMath {

    static final int[] binaryNum = {
            0x1, 0x2, 0x4, 0x8,
            0x10, 0x20, 0x40, 0x80,
            0x100, 0x200, 0x400, 0x800,
            0x1000, 0x2000, 0x4000, 0x8000,
            0x10000, 0x20000, 0x40000, 0x80000,
            0x100000, 0x200000, 0x400000, 0x800000,
            0x1000000, 0x2000000, 0x4000000, 0x8000000,
            0x10000000, 0x20000000, 0x40000000, 0x80000000};

    public static double pow(double pBase, int pExponent) {
        boolean neg = false;
        if (pExponent < 0) {
            neg = true;
        }
        double result = 1.0;
        double base = pBase;
        for (int i = 0; i < 32; i++) {
            if (pExponent < binaryNum[i]) {
                break;
            }
            if ((pExponent & binaryNum[i]) > 0) {
                result *= base;
            }
            base = base * base;
        }
        if (neg) {
            return 1.0 / result;
        } else {
            return result;
        }
    }
}
