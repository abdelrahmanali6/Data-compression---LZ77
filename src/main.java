import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        String str = "ABAABABAABBBBBBBBBBBBA";
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        arr = LZ77.Compression(str);
        for(int i=0; i<arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }
        System.out.println(LZ77.Decompress(arr));
    }
}