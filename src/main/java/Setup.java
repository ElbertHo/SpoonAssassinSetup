/**
 * Setup a spoon assasins game
 * Reads in the necessary names from the names file in the docs folder
 * @author Elbert Ho
 * @version 1.0
 */
import java.util.*;
import java.io.*;
public class Setup
{
  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);
    System.out.println("Setup starting...");
    System.out.println("Reading names from file...");
    ArrayList<String> names = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("../../docs/Names.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
         names.add(line);
      }
    }
    catch(IOException ex)
    {
      System.out.println("Error, file not found.");
    }
    int numNames = names.size();
    Collections.shuffle(names);
    HashMap<String, String> targets = new HashMap<String, String>();
    for(int i = 0; i < numNames - 1; i++)
    {
      targets.put(names.get(i), names.get(i + 1));
    }
    targets.put(names.get(numNames-1), names.get(0));
    Collections.shuffle(names);
    for(int i = 0; i < numNames; i++)
    {
      String person = names.get(i);
      String target = targets.get(person);
      System.out.print(person + " please come up. (Press ENTER when ready)");
      kb.nextLine();
      System.out.print("Your target is " + target + ". (Press ENTER to move on)");
      kb.nextLine();
      for(int k = 0; k < 30; k++)
      {
        System.out.println();
      }
    }
    System.out.println("Finished!");
  }
}
