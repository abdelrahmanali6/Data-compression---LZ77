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

      return arr;
  }

}