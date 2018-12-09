package horse;

import java.util.Arrays;
import java.util.Scanner;

public class Horse {
	//开始位置x,y
	int i,j;
	//记录位置和上一次的位置
	static int OldLocationx,OldLocationy,NewLocationx,NewLocationy;
	
	//记录操作次数
	static int record =0;
	//存在操作位置
	int Recordx[]=new int[100],Recordy[]=new int[100];
	
	//存放下一步的位置
	int NextLocationx[]=new int[20],NextLocationy[]=new int[20],NextLocation[] = new int[10];
	//存放下一步的标志位
	int Flag=0;
	char a[][]={{'m','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.'}
	,{'.','.','.','.','.','.','.','.'},
	{'.','.','.','.','.','.','.','.'}
	};
	int Sizex=1,Sizey=1;
	char test[][]=new char[Sizex][Sizey];
	public static void main(String args[])
	{
		OldLocationx=0;
		OldLocationy=0;
		Horse tt = new Horse();
		tt.DoIt();
		//tt.test();
	}
	
	public void test()
	{
		Scanner scanner  = new Scanner(System.in);
		Scanner scanner1  = new Scanner(System.in);
		System.out.println("请输入你想要的棋盘大小：");
		Sizex=scanner.nextInt();
		Sizey=scanner1.nextInt();
		for(int i =0;i<Sizex;i++)
		{
			for(int j = 0;j<Sizey;j++)
			{
				test[i][j]='.';
			}
		}
		for(char[] tt :test)
		{
			System.out.println(tt);
		}
	}
	public void Judge()
	{
		
	}
	
	public void DoIt()
	{
		//show();
		Scanner scanner  = new Scanner(System.in);
		while(true)
		{
			JudgeNext(OldLocationx,OldLocationy);
			show();
			int i =scanner.nextInt();
			if(i==1)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx+1>3 || OldLocationy+2>7)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx+=1;
				OldLocationy+=2;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else if(i==2)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx+2>3 || OldLocationy+1>7)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx+=2;
				OldLocationy+=1;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else if(i==3)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx-2<0 || OldLocationy-1<0)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx-=2;
				OldLocationy-=1;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else if(i==4)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx-1<0 || OldLocationy-2<0)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx-=1;
				OldLocationy-=2;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else if(i==5)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx-1<0 || OldLocationy+2>7)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx-=1;
				OldLocationy+=2;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else if(i==6)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx-2<0 || OldLocationy+1>7)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx+=2;
				OldLocationy+=1;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else if(i==7)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx+1>3 || OldLocationy-2<0)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx+=1;
				OldLocationy-=2;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else if(i==8)
			{
				Recordx[record]=OldLocationx;
				Recordy[record]=OldLocationy;
				record++;
				if(OldLocationx+2>3 || OldLocationy-1<0)
				{
					System.out.println("该步已经越界");
					continue;
				}
				OldLocationx+=2;
				OldLocationy-=1;
				a[Recordx[record-1]][Recordy[record-1]]='.';
				a[OldLocationx][OldLocationy]='m';
			}
			else 
			{
				System.out.println("请输入（1-8）的值进行跳跃");
			}
		}
	}
	
	public void InitLocation()
	{
		
	}
	
	public void show()
	{
		for(char[] test :a)
		{
			System.out.println(test);
		}
	}
	
	public void InitNext()
	{
		for(int i =0;i<Flag;i++)
		{
			NextLocationx[i]=0;
			NextLocationy[i]=0;
			NextLocation[i]=0;
		}
	}
	
	public void JudgeNext(int x,int y)
	{
		if(Flag!=0)
		{
			//先进行一个把刚才的初始化
			for(int j =0;j<4;j++)
			{
				for(int i =0;i<8;i++)
				{
					if((a[j][i]!='.') && a[j][i]!='m')
					a[j][i]='.';
				}
			}
			InitNext();
			Flag=0;
		}
		//判断可执行的下一步
		//1
		if(x+1<=3 && y+2<8)
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x+1;
			NextLocationy[Flag]=y+2;
			NextLocation[Flag]=1;
			Flag++;
		}
		//2
		if(x+2<=3 && y+1<8)
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x+2;
			NextLocationy[Flag]=y+1;
			NextLocation[Flag]=2;
			Flag++;
		}
		//3
		if(x-2>=0 && y-1>=0)
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x-2;
			NextLocationy[Flag]=y-1;
			NextLocation[Flag]=3;
			Flag++;
		}
		//4
		if(x-1>=0 && y-2>=0)
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x-1;
			NextLocationy[Flag]=y-2;
			NextLocation[Flag]=4;
			Flag++;
		}
		//5
		if(x-1>=0 && y+2<8)
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x-1;
			NextLocationy[Flag]=y+2;
			NextLocation[Flag]=5;
			Flag++;
		}
		//6
		if(x-2>=0 && y+1<8)
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x-2;
			NextLocationy[Flag]=y+1;
			NextLocation[Flag]=6;
			Flag++;
		}
		//7
		if(x+1<=3 && y-2>=0)
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x+1;
			NextLocationy[Flag]=y-2;
			NextLocation[Flag]=7;
			Flag++;
		}
		//8
		if((x+2<=3) && (y-1>=0))
		{
			//这是一个可执行的下一步
			NextLocationx[Flag]=x+2;
			NextLocationy[Flag]=y-1;
			NextLocation[Flag]=8;
			Flag++;
		}
		Create();
	}
	
	public void Create()
	{
		if(Flag==0)return;
		for(int i =0;i<Flag;i++)
		{
			switch(NextLocation[i])
			{
			case 1:a[NextLocationx[i]][NextLocationy[i]]='1';break;
			case 2:a[NextLocationx[i]][NextLocationy[i]]='2';break;
			case 3:a[NextLocationx[i]][NextLocationy[i]]='3';break;
			case 4:a[NextLocationx[i]][NextLocationy[i]]='4';break;
			case 5:a[NextLocationx[i]][NextLocationy[i]]='5';break;
			case 6:a[NextLocationx[i]][NextLocationy[i]]='6';break;
			case 7:a[NextLocationx[i]][NextLocationy[i]]='7';break;
			case 8:a[NextLocationx[i]][NextLocationy[i]]='8';break;
			default:break;
			}
			
		}
	}
}
