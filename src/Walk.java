/*
4F9D39, DEB456, 3DA8B9, A57CA7, 26A84A, 2FCFA3, 3AAB09, 89CBF5
1, 2, L, 2
5, 3, A, 4
3, 5, B, 2
6, 7, R, 5
4, 7, L, 6
*/
import java.util.Arrays;
import java.util.Scanner;

//Isaiah Cruz
//Metuchen High School

public class Walk {

    private int[][] array;
    
public Walk()
{
}

public void init()
    {array = new int[8][8];
        
    String[] input = new String[6];
    String[] output = new String[5];
    
    Scanner s = new Scanner(System.in);
    System.out.println("INPUT:\n");
    for(int k = 0; k < input.length; k++)
        {System.out.print((k + 1) + ". ");
        input[k] = s.nextLine();
        System.out.println();
        }
    
    setupArray(parseString(input[0]));
    
    for(int k = 1; k < 6; k++)
        {output[k - 1] = followOrders(parseString(input[k]));
        }
    }

public String hexToOctal(String hex)
    {return Integer.toString(Integer.parseInt(hex, 16), 8);
    }

public String parseString(String str)
    {String fullStr = "";
    for(int k = 0; k < str.length(); k++)
        {if(str.substring(k, k + 1).equals(","))
            fullStr += " ";
        else
            fullStr += str.substring(k, k + 1);
        }
    return fullStr;
    }

public void setupArray(String str)
    {Scanner s = new Scanner(str);
    
    String[] row = new String[8];
    
    int i = 0;
    while(s.hasNext())
        {row[i] = s.next();
        i++;
        }
    
    for(int k = 0; k < 8; k++)
        {for(int j = 0; j < 8; j++)
            {array[k][j] = Integer.parseInt(row[k].substring(j, j + 1));
            }
        }
    }

public String followOrders(String str)
    {int[] pos = new int[2];
    
    Scanner s = new Scanner(str);
    pos[0] = s.nextInt();
    pos[1] = s.nextInt();
    
    String dirStr = s.next();
    int dir = 0;
    switch(dirStr)
        {case "L":
            {dir
            }
        }
    }

public static void main(String[] args)
    {new Walk().init();
    }
    
}
