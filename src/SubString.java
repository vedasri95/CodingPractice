import java.util.ArrayList;
import java.util.HashSet;

public class SubString {

    static String findSubString(String str)
    {
        int len1 = str.length();
        HashSet<Character> pat = new HashSet<Character>();

        for(char c : str.toCharArray())
            pat.add(c);
        int len2 = pat.size();
        if (len1 < len2)
        {
            System.out.println("No such window exists");
            return "";
        }

        int hash_str[] = new int[256];
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
        int count = 0; // count of characters
        for (int j = 0; j < len1 ; j++)
        {
            // count occurrence of characters of string
            hash_str[str.charAt(j)]++;

            // If string's char matches with pattern's char
            // then increment count
            if (hash_str[str.charAt(j)] <= 1 )
                count++;
            // if all the characters are matched
            if (count == len2)
            {
                while ( hash_str[str.charAt(start)] > 1)
                {
                    hash_str[str.charAt(start)]--;
                    start++;
                }
                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1)
        {
            System.out.println("No such window exists");
            return "";
        }

        ArrayList<Integer>[] htable = new ArrayList[3];
        htable[0] = new ArrayList<Integer>();

        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index + min_len);
    }

    public static void main(String[] args)
    {

        System.out.print("Smallest window is : " +
                findSubString("ABCD"));
    }
}
