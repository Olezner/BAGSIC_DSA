import java.util.Scanner;

public class OE1{

    public static void Traverse(){
        {
            int arrnum[] = {5,7,2,4,3};
            int limit = 5;
            int i = 0;

            System.out.println("The original array elements are : \n");
            for(i = 0; i<limit; i++)
            {
                System.out.println(arrnum[i]);
            }
        }
    }
    
    public static void Delete(){
        {
            int arrnum[] = {5,7,2,4,3};
            int limit = 5;
            int i = 0, k = 0;

            System.out.println("The original array elements are : \n");
            for(i = 0; i<limit; i++)
            {
                System.out.println(arrnum[i]);
            }
            
            k = limit;

            while(k < limit) {
                arrnum[k-2] = arrnum[k];
                k = k + 1;

            }
        
            limit = limit - 3;
            System.out.println("The array elements after deletion: \n");
              
            for (i = 0; i<limit; i++)
            {
                System.out.println(arrnum[i]);
            }
            
        }
    }

    public static void Search(){
        {
            int arrnum[] = {5,7,2,4,3};
            int limit = 5;
            int i = 0, k = 0, arr = 5;
            int search_num;
            int position;

            System.out.println("The original array elements are : \n");
            for(i = 0; i<limit; i++)
            {
                System.out.println(arrnum[i]);
            }

            for (i =0; i < limit; i++)
            {
                if(arrnum[i] == arrnum[k]);

                position = i;
                System.out.println("The position of the number is :" + position);
            }
            
        }
        
        
    }

    public static void Update(){
        {
            int arrnum[] = {5,7,2,4,3};
            int limit = 5;
            int i = 0, k = 0;

            System.out.println("The original array elements are : \n");
            for(i = 0; i<limit; i++)
            {
                System.out.println(arrnum[i]);
            }
            
            System.out.println("The array elements after updation : \n");
            
		    arrnum[1] = 2;
		    arrnum[2] = 4;
		    System.out.println(arrnum[0]);
		    System.out.println(arrnum[1]);
		    System.out.println(arrnum[2]);
		    System.out.println(arrnum[3]);
            System.out.println(arrnum[4]);
        }
        
    }
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);

        System.out.println("Choose which array implementation to use:");
        System.out.println("[1] Traverse");
        System.out.println("[2] Delete");
        System.out.println("[3] Search");
        System.out.println("[4] Update");

        String menu = read.nextLine();
        switch(menu){
            
            case "1":
            Traverse();
            break;

            case "2":
            Delete();
            break;

            case "3":
            Search();
            break;

            case "4":
            Update();
            break;
        }
    }
    
}