public class Main {

    public static void main(String[] args) {
        System.out.println( hIndex(new int[]{3,0,6,1,5}) );
    }

    public static int hIndex(int[] citations) {

        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        int count = 0;
        for(int i = n; i >= 0; i--) {
            // there reason we keep adding to count is we have started from end
            // therefore the ones we left behind certainly have at least h citations [more case]
            // when we hit 3, sum of number of papers with at least 3 citations gets bigger than
            // index, thus we have found h index
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }

}
