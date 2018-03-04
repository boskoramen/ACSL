/*
8,9,Q,6,7,K,A,5,9,8
75,J,7,Q,T,A,6,2,3,4,5
50,7,K,T,8,3,Q,9,7,2,3
63,3,6,8,T,7,7,T,3,5,8
79,A,9,7,T,A,9,T,A,6,4
50,A,T,Q,A,T,K,J,T,A,7
*/
import java.util.Arrays;
import java.util.Scanner;

//Isaiah Cruz
//Metuchen High School

public class NinetyNine {

public NinetyNine()
{
}

/*
    Plays the hand
    first_h = first player's hand | second_h = second player's hand
    setup is the setup of each game
*/

public int[] parseRealString(String player)
    {int[] val = new int[5];
    Scanner s = new Scanner(player);
    int i = 0;
    while(s.hasNext())
        {String card = s.next();
        if(card.equals("T"))
            {val[i] = 10;
            }
        else if(card.equals("A"))
            {val[i] = 14;
            }
        else if(card.equals("K"))
            {val[i] = 13;
            }
        else if(card.equals("Q"))
            {val[i] = 12;
            }
        else if(card.equals("J"))
            {val[i] = 11;
            }
        else
            val[i] = Integer.parseInt(card);
        i++;
        }
    return val;
    }

public int[] play(String first_h, String second_h, String setup)
    {setup = setup.replace(",", " ");
    Scanner s = new Scanner(setup);
    int current_player = 2;
    int total = Integer.parseInt(s.next());
    int last_total = total;
    int[][] points = new int[2][5];
    points[0] = parseRealString(first_h);
    points[1] = parseRealString(second_h);
    
    while(total <= 99)
        {Arrays.sort(points[current_player % 2]);
        last_total = total;
        int a_point = points[current_player % 2][points[0].length / 2];
        if(a_point == 10)
            a_point = -10;
        if(a_point == 9)
            a_point = 0;
        if(a_point == 7)
            {if(total <= 92)
                   a_point = 7;
            else a_point = 1;
            }
        
        total += a_point;
        
        if(s.hasNext())
            {int[] point = parseRealString(s.next());
            int next = point[0];
            points[current_player % 2][points[0].length / 2] = next;
            }
        if((last_total <= 33 && total >= 34) || (last_total <= 55 && total >= 56) || (last_total <= 77 && total >= 78))
            total += 5;
        else if((total <= 33 && last_total >= 34) || (total <= 55 && last_total >= 56) || (total <= 77 && last_total >= 78))
            total += 5;
        
        current_player++;
        }
        
    return new int[]{total, (current_player % 2) + 1};
    }

public void init()
{String[] input = new String[6];
Scanner s = new Scanner(System.in);
for(int k = 0; k < input.length; k++)
    {input[k] = s.nextLine();
    }
String first_h = input[0].substring(0, 10).replace(",", " ");
String second_h = input[0].substring(10).replace(",", " ");

System.out.println("\nOUTPUT:");

for(int k = 1; k < input.length; k++)
    {String setup = input[k];
    int[] result = play(first_h, second_h, setup);
    System.out.println(k + ". " + result[0] + ", Player #" + result[1]);
    }
}

public static void main(String[] args)
{new NinetyNine().init();
}
    
}
