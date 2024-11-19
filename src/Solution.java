class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;

        boolean positive = x > 0;
        String absNum = x >= 0 ? new StringBuffer(String.valueOf(x)).reverse().toString() : new StringBuffer(String.valueOf(x).substring(1)).reverse().toString();
        String newNum = null;
        for (int i = 0; i < absNum.length(); i++) {
            if (absNum.charAt(i) != '0') {
                newNum = absNum.substring(i);
                break;
            }
        }

        if (overflow(newNum, positive)) {
            return 0;
        } else {
            return Integer.parseInt(positive ? newNum : "-" + newNum);
        }
    }

    public boolean overflow(String num, boolean positive) {
        String positiveMax = "2147483647";
        String negetiveMin = "2147483648";

        if (positive) {
            return num.length() > positiveMax.length() || num.length() == positiveMax.length() && num.compareToIgnoreCase(positiveMax) > 0;
        } else {
            return num.length() > negetiveMin.length() || num.length() == negetiveMin.length() && num.compareToIgnoreCase(negetiveMin) > 0;
        }
    }

}