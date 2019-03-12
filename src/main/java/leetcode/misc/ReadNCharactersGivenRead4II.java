package leetcode.misc;

/**
 * Runtime: 2 ms, faster than 94.15% of Java online submissions for Read N Characters Given Read4 II - Call multiple times.
 */
public class ReadNCharactersGivenRead4II {

    int li = 0;
    int remLocal = 0;
    char[] local = new char[4];

    public int read(char[] buf, int n) {

        int bi = 0;
        int read = 0;

        // Take care of remaining chars in local buffer
        int lim = Math.min(n, remLocal);
        for (int k = 0; k < lim; k++) {
            buf[bi] = local[li];
            li++;
            n--;
            read++;
            bi++;
            remLocal--;
        }

        while (n != 0) {
            remLocal = read4(local);
            if (remLocal == 0)
                return read;
            lim = Math.min(remLocal, n);
            li = 0;

            for (li = 0; li < lim; li++) {
                buf[bi] = local[li];
                bi++;
                n--;
                read++;
                remLocal--;
            }
        }
        return read;
    }

    int read4(char[] buff) {
        // leetcode provided implementation
        return 0;
    }
}
