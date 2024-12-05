class Solution {
    public int solution(int[] stones, int k) {
        int low = 1;
        int high = Integer.MAX_VALUE; 
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canCross(stones, k, mid)) {
                result = mid; 
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }

        return result;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int count = 0;

        for (int stone : stones) {
            if (stone < people) {
                count++;
                if (count >= k) {
                    return false; 
                }
            } else {
                count = 0; 
            }
        }

        return true; 
    }
}
