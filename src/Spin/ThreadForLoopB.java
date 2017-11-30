package Spin;

import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class ThreadForLoopB extends Thread{
	  // variables for your Thread ...
		private Spin a=new Spin();
		static int last;
		static boolean running=false;
	   @Override
	   public void run(){
		   boolean ended=false;
		   running=true;
		   
		   
		   
		   int [] arr=new int[Spin.img.length];
		   for(int i=0;i<Spin.img.length;i++) arr[i]=i;
		   shuffleArray(arr);
		   for(int s:arr) {
			   System.out.println(s+", ");
		   }
		   System.out.println("rnum2 "+Spin.getRnum2());
		   Spin.lblReel2.setLocation(Spin.lblReel2.getX(), Spin.panel1.getY()+Spin.lblReel2.getHeight()/2);
		   //Spin.lblReel21.setLocation(Spin.lblReel21.getX(), Spin.panel1.getY()+Spin.lblReel21.getHeight()/2-100);
		   
		   for(int y=0;y<3;y++) {
			   for(int i=0;i<Spin.img.length;i++) { 
				  // if(y==0&&i==0) i=last; // last pamti zadnju sliku koja se vrtila pa drugi put kad se vrti poène od nje
					//last =i;
	    	for(int x=0;x<(Spin.panel1.getHeight()+Spin.lblReel2.getHeight())/2/5;x++) {
	    		
	    		//System.out.println(i);
	    		Spin.lblReel2.setLocation(Spin.lblReel2.getX(), Spin.lblReel2.getY()+5);
	    	
		    	try {
					TimeUnit.MICROSECONDS .sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
		    
		    	
					
				Spin.lblReel2.setIcon(new ImageIcon(Spin.path+Spin.img[arr[i]]));
				Spin.lblReel2.setLocation(Spin.lblReel2.getX(), 0-Spin.lblReel2.getHeight());
		    		
				
					
			
				if(!(Spin.getRnum2()==arr[i]&&y==2))
					for(int x=0;x<(Spin.panel1.getHeight()+Spin.lblReel2.getHeight())/2/5;x++) {
						   Spin.lblReel2.setLocation(Spin.lblReel2.getX(), Spin.lblReel2.getY()+5);
						 
						    try {
									TimeUnit.MICROSECONDS .sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    	
							
							
			   }
					
					System.out.println("iB"+i); 
					if(Spin.getRnum2()==arr[i]&&y==2) { 
						for(int x=0;x<30+(Spin.panel1.getHeight()+Spin.lblReel2.getHeight())/2/2;x++) {
							   Spin.lblReel2.setLocation(Spin.lblReel2.getX(), Spin.lblReel2.getY()+2);
							 
							    try {
										TimeUnit.MICROSECONDS .sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						    	
								
								
				   }
						for(int x=0;x<45;x++) {
							   Spin.lblReel2.setLocation(Spin.lblReel2.getX(), Spin.lblReel2.getY()-2);
							 
							    try {
										TimeUnit.MICROSECONDS .sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						    				
				   }
						for(int x=0;x<30;x++) {
							   Spin.lblReel2.setLocation(Spin.lblReel2.getX(), Spin.lblReel2.getY()+1);
							 
							    try {
										TimeUnit.MICROSECONDS .sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						    				
				   }
						
					System.out.println("a b "+arr[i]); 
				break; // ako je zadnji krug
				
				}
		}
		    
		    
		    
	   }
		   running=false;
	   }
	   static void shuffleArray(int[] ar)
	   {
	     // If running on Java 6 or older, use `new Random()` on RHS here
	     Random rnd = ThreadLocalRandom.current();
	     for (int i = ar.length - 1; i > 0; i--)
	     {
	       int index = rnd.nextInt(i + 1);
	       // Simple swap
	       int a = ar[index];
	       ar[index] = ar[i];
	       ar[i] = a;
	     }
	   }
	}