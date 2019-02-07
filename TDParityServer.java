import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.*;
public class TDParityServer {
public static void main(String args[])
{
	Socket          socket   = null; 
  ServerSocket    server   = null; 
   DataInputStream in       =  null; 
   int[][] d=new int[4][5];
   int[][] d1=new int[5][6];
   try
   { 
       server = new ServerSocket(5000); 
       System.out.println("Server started"); 

       System.out.println("Waiting for a client ..."); 

       socket = server.accept(); 
       System.out.println("Client accepted"); 

       in = new DataInputStream( 
           new BufferedInputStream(socket.getInputStream())); 

int i=0,j=0;
String line1="";
       while (!(line1= in.readUTF()).equals(Integer.toString(9))) 
       { 
           try
           { 

               d1[i%5][j%6]=Integer.parseInt(line1);
    if(j%6==5)          
   i++;
   j++;
           } 
           catch(Exception ex) 
           { 
               System.out.println(ex); 
           } 
    
       } 
       System.out.println("Closing connection"); 

       socket.close(); 
       in.close(); 
   } 
   catch(IOException i) 
   { 
       System.out.println(i); 
   } 
   
   Scanner sc=new Scanner(System.in);
int k=9;
for(int i=0;i<4;i++) {
	int sum=0;
	for(int j=0;j<5;j++)
		{
		d[i][j]=d1[i][j];
		sum+=d[i][j];
		}
if(sum%2==d1[i][5])
	k=0;
else
{k=1;
	break;
}
}
for(int j=0;j<5;j++)
{int sum1=0;
	for(int i=0;i<=3;i++)
	{
		sum1+=d[i][j];
	}
	if(sum1%2==d1[4][j])
		k=0;
	else
	{k=1;
		break;
	}
}


System.out.println("The 2D Parity is:\n");
for(int i=0;i<=4;i++)
{System.out.print("\n");
	for(int j=0;j<6;j++)
	{
		System.out.print(d1[i][j]+ " ");
	}
}
if(k==1)
	System.out.println("\nError Detected");
else
	System.out.println("\nNo Error Detected");

}		
}
