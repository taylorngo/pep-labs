public class CharComparison {
    /**
     * Given an array of char, determine if the array A belongs to the left or to the right of char array B lexigraphically.
     * That means its position in a dictionary, eg:
     * cat < dog < mouse
     * cat < car < care
     * You will need to compare an index of both arrays against each other as you iterate with a for loop.
     *
     * @param a an array of char.
     * @param b an array of char.
     * @return -1 if A is less than B, 1 if A is greater than B, and 0 if the two arrays are identical.
     */
    public int compare(char[] a, char[] b){
        int len = Math.min(a.length, b.length);
        for(int i = 0; i < len; i++){
                int ascii1 = (int) a[i], ascii2 = (int) b[i];
                if(ascii1 != ascii2){
                if(ascii1 - ascii2 < 0)
                    return -1;
                if(ascii1 - ascii2 > 0)
                    return 1;
            }
        }
        return 0;
    }
}
