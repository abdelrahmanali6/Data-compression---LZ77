import java.util.ArrayList;

public class LZ77 {
    public static ArrayList<ArrayList<Integer>> Compression(String pattern)
    {
        String added ="";
        String temp="";
        int pos = 0;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i< pattern.length(); i++)
        {
            if(added.length() == 0)
            {
                added+=pattern.charAt(i);
                ArrayList<Integer> initial = new ArrayList<Integer>();
                initial.add(0);
                initial.add(0);
                initial.add((int)pattern.charAt(0));
                arr.add(initial);
            }
            else
            {
                temp+=pattern.charAt(i);

                if(added.contains(temp))
                {
                    pos=added.indexOf(temp);
                }
                else
                {
                    ArrayList<Integer> initial = new ArrayList<Integer>();
                    initial.add(added.length()-pos);
                    initial.add(temp.length()-1);
                    initial.add((int)temp.charAt(temp.length()-1));
                    arr.add(initial);
                    System.out.println(temp);
                    added+=temp;
                    temp="";
                }
            }
        }
        if(temp !="")
        {
            ArrayList<Integer> initial = new ArrayList<Integer>();
            initial.add(added.indexOf(temp));
            initial.add(temp.length()-1);
            initial.add((int)temp.charAt(temp.length()-1));
            arr.add(initial);
        }

        return arr;
    }

    public static String Decompress(ArrayList<ArrayList<Integer>> arr)
    {
        String str="";
        int x =0;
        for(int i=0; i<arr.size(); i++)
        {
            System.out.println(str);
            if(arr.get(i).get(0) == 0)
            {
                x = arr.get(i).get(2);
                str += Character.toString((char)x);
            }
            else
            {
                str += str.substring((str.length()-arr.get(i).get(0)),(str.length()-arr.get(i).get(0))+ (arr.get(i).get(1)));
                x = arr.get(i).get(2);
                str += Character.toString((char)x);
            }
        }
        return str;
    }

}