import java.util.*;

class Compare_Version_Number {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i=0;
        //append extra zeros for version with smaller length
        int len = Math.max(v1.length, v2.length);

        while(i < len) {
            // Handle case "1.0.0.0 & 1.0" both should be equal
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }

            i++;
        }

        return 0;
    }

    public static void main(String args[]) {
        String version1 = "1.2";
        String version2 = "1.10";

        Compare_Version_Number compareVersionNumber = new Compare_Version_Number();

        System.out.println(compareVersionNumber.compareVersion(version1, version2));
    }
}