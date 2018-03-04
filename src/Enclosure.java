//Isaiah Cruz
//Metuchen High School

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Enclosure {

public Enclosure()
{
}

/*
    Separates the equation into an ArrayList of its symbols
*/

public ArrayList<Integer> seperateEquation(String eq)
    {ArrayList<Integer> syms = new ArrayList();
    for(int i = 0; i < eq.length(); i++)
        {String s = eq.substring(i, i + 1);
        try
            {if(Integer.parseInt(s) >= 0) 
                {syms.add(0);
                }
            }  
        catch(NumberFormatException e)
            {switch (s) 
                {case "{":case "}":
                    syms.add(4);
                    break;
                case "[":case "]":
                    syms.add(3);
                    break;
                case "(":case ")":
                    syms.add(2);
                    break;
                case "+":case "-":case "*":case "/":
                    syms.add(1);
                    break;
                }
            }
        }
    return syms;
    }

public ArrayList<Integer> findPos (String eq)
    {ArrayList<Integer> syms = seperateEquation(eq);
    int sym = 0;
    int[] otherSym = {0, 0};
    if(syms.indexOf(4) == syms.lastIndexOf(4) && syms.indexOf(4) > -1)
        {sym = 4;
        otherSym = new int[]{2, 3};
        }
    else if(syms.indexOf(3) == syms.lastIndexOf(3) && syms.indexOf(3) > -1)
        {sym = 3;
        otherSym = new int[]{2, 4};
        }
    else if(syms.indexOf(2) == syms.lastIndexOf(2) && syms.indexOf(2) > -1)
        {sym = 2;
        otherSym = new int[]{3, 4};
        }
    else
        throw new RuntimeException();
    int pos = syms.indexOf(sym);
    int dir = 0;
    int max = 0;
    int min = 0;
   
    System.out.println("sym: " + sym);
    System.out.println("pos: " + pos);
    
    switch (sym)
        {case 4:
            {if(eq.substring(pos, pos + 1).equals("{"))
                {min = pos;
                max = eq.length();
                }
            else
                {min = 0;
                max = pos;
                dir = 1;
                }
            break;
            }
        case 3:
            {if(eq.substring(pos, pos + 1).equals("["))
                {min = pos;
                max = eq.length();
                }
            else
                {min = 0;
                max = pos;
                dir = 1;
                }
            break;
            }
        case 2:
            {if(eq.substring(pos, pos + 1).equals("("))
                {min = pos;
                max = eq.length();
                }
            else
                {min = 0;
                max = pos;
                dir = 1;
                }
            break;
            }
        }
    
    ArrayList<Integer> positions = new ArrayList();
    for(int i = min; i < max; i++)
        {int sum1 = 0;
        int sum2 = 0;
        int opsum = 0;
        if((syms.get(i) > 0 && syms.get(i) != sym) || i == min || i == max - 1)
            {int j = 0;
            if(dir == 0)
                {for(j = min; j < i; j++)
                    {if(syms.get(j) == otherSym[0])
                        sum1 += 1;
                    else if(syms.get(j) == otherSym[1])
                        sum2 += 1;
                    if(syms.get(j) == 1)
                        opsum += 1;
                    }
                if(j > 1 && syms.get(j - 1) == 1 && j != max - 1)
                    opsum = 0;
                }
            else if(dir == 1)
                {int end = 0;
                j = i + dir;
                if(syms.get(j) == 1 && i != 0)
                    end = max;
                else if(sym > syms.get(i)&& i == 0)
                    end = -1;
                for(j += end; j < max; j++)
                    {if(syms.get(j) == otherSym[0])
                        sum1 += 1;
                    else if(syms.get(j) == otherSym[1])
                        sum2 += 1;
                    if(syms.get(j) == 1)
                        opsum += 1;
                    }
                }
            if(syms.get(i) > 0)
                opsum += 1;
            if(sum1 % 2 == 0 && sum2 % 2 == 0 && opsum > 1)
                {int end = 0;
                if(i == 0 && sym > syms.get(i))
                    end = -1;
                else if(i == eq.length() - 1 && sym > syms.get(eq.length() - 1))
                    end = 1;
                positions.add(i + dir + end + 1);
                }
            }
        }
    return positions;
    }

public void init()
    {for(int i = 0; i < 5; i++)
        {System.out.println("Type in equation (no spaces):");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        ArrayList<Integer> pos = findPos(str);
        String output = "";
        
        for(int n : pos)
            {output += n + ", ";
            }
        System.out.println("\n" + (i + 1) + ". " + output.substring(0, output.length() - 2) + "\n");
        System.out.print("---------------------------------------\n\n");
        }
    }

public static void main(String[] args)
    {new Enclosure().init();
    }
 
}