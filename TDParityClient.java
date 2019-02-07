import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
public class TDParityClient{
 
public static void main(String args[])
{
	
	 Socket socket            = null; 
	    DataInputStream  input   = null; 
	     DataOutputStream out     = null; 
	Scanner sc=new Scanner(System.in);
System.out.println("Enter no.of Messages:");
int h=sc.nextInt();
int[][] d=new int[h][5];
int[][] d1=new int[h+1][6];
for(int i=0;i<h;i++)
{
System.out.println("Enter"+i+" data bits of 5:");
for(int j=0;j<5;j++)
{
	d[i][j]=sc.nextInt();
}
}
for(int i=0;i<h;i++) {
	int sum=0;
	for(int j=0;j<5;j++)
		{
		d1[i][j]=d[i][j];
		sum+=d[i][j];
		}
if(sum%2==0)
	d1[i][5]=0;
else
	d1[i][5]=1;
}

for(int j=0;j<6;j++)
{int sum1=0;
	for(int i=0;i<h;i++)
	{
		sum1+=d1[i][j];
	}
	if(sum1%2==0)
		d1[h][j]=0;
	else
		d1[h][j]=1;

}

try
{ 
    socket = new Socket("local host",5000); 
    System.out.println("Connected"); 


    input  = new DataInputStream(System.in);  
    out    = new DataOutputStream(socket.getOutputStream()); 
} 
catch(UnknownHostException u) 
{ 
    System.out.println(u); 
} 
catch(IOException i) 
{ 
    System.out.println(i); 
} 

for(int i=0;i<=h;i++)
{
	System.out.print("\n");
	for(int j=0;j<6;j++)
	{
		 try
    { 
        out.writeUTF(Integer.toString(d1[i][j])); 
    } 
    catch(IOException ex) 
    { 
        System.out.println(ex); 
    } 
	}
}

try
{ 

out.writeUTF(Integer.toString(9)); 
} 
catch(IOException ex) 
{ 
System.out.println(ex); 
} 
try
{ 
    input.close(); 
    out.close(); 
    socket.close(); 
} 
catch(IOException i) 
{ 
    System.out.println(i); 
} 
System.out.println("The 2D Parity is:\n");
for(int i=0;i<=4;i++)
{System.out.print("\n");
	for(int j=0;j<6;j++)
	{
		System.out.print(d1[i][j]+ " ");
	}
}
} 

}		

