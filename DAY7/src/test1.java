import java.util.Scanner;
public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
		int check = 0;
		int count = 0;
		
		while(true)
		{
			for(int i=0;i<9;i++)
			{
				if(game[i]==1)
				{
					System.out.print("벽 ");
				}
				else if(game[i]==2)
				{
					System.out.print("나 ");
					check = i;
				}
				else
				{
					System.out.print(game[i]+" ");
				}
			}
			System.out.println();
			
			
			System.out.println("[1]왼쪽 [2]오른쪽");
			int num = sc.nextInt();
			
			if(count>4 || count<-4)
			{
				System.out.println("더이상 움직임수 없습니디.");
				break;
			}
			
			if(num == 1)
			{
				if(game[check-1] == 1)
				{
					System.out.println("벽을 만나 움직일 수 없습니다.");
					System.out.println("벽 부수기 -> 3");
				}
				else
				{
					game[check-1] = game[check];
					game[check] = 0;
					count++;
					System.out.println("count1 " + count);
				}
			}
			
			if(num == 2)
			{
				if(game[check+1] == 1)
				{
					System.out.println("벽을 만나 움직일 수 없습니다.");
					System.out.println("벽 부수기 -> 3");
				}
				else
				{
					game[check+1] = game[check];
					game[check] = 0;
					count--;
					System.out.println("count2 " + count);
				}
			}
			
			if(num == 3)
			{
				game[check-1]=0;
				game[check+1]=0;
			}
			System.out.println("마지막:"+count);
			}
		}
	}