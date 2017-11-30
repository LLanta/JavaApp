package Spin;

import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class ThreadForLoopA extends Thread{
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
		   System.out.println("rnum1 "+Spin.getRnum1());
		   Spin.lblReel1.setLocation(Spin.lblReel1.getX(), Spin.panel.getY()+Spin.lblReel1.getHeight()/2);
		   //Spin.lblReel11.setLocation(Spin.lblReel11.getX(), Spin.panel.getY()+Spin.lblReel11.getHeight()/2-100);
		   
		   for(int y=0;y<3;y++) {
			   for(int i=0;i<Spin.img.length;i++) { 
				   //if(y==0&&i==0) i=last; // last pamti zadnju sliku koja se vrtila pa drugi put kad se vrti poène od nje
				//	last =i;
	    	for(int x=0;x<(Spin.panel.getHeight()+Spin.lblReel1.getHeight())/2/5;x++) {
	    		
	    		//System.out.println(i);
	    		Spin.lblReel1.setLocation(Spin.lblReel1.getX(), Spin.lblReel1.getY()+5);
	    	
		    	try {
					TimeUnit.MICROSECONDS .sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
		    
		    	
					
				Spin.lblReel1.setIcon(new ImageIcon(Spin.path+Spin.img[arr[i]]));
				Spin.lblReel1.setLocation(Spin.lblReel1.getX(), 0-Spin.lblReel1.getHeight());
		    		
				
					
				if(!(Spin.getRnum1()==arr[i]&&y==2))
				for(int x=0;x<(Spin.panel.getHeight()+Spin.lblReel1.getHeight())/2/5;x++) {
					   Spin.lblReel1.setLocation(Spin.lblReel1.getX(), Spin.lblReel1.getY()+5);
					 
					    try {
								TimeUnit.MICROSECONDS .sleep(1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    	
						
						
		   }
				
				System.out.println("iA"+i); 
				if(Spin.getRnum1()==arr[i]&&y==2) { 
					for(int x=0;x<30+(Spin.panel.getHeight()+Spin.lblReel1.getHeight())/2/2;x++) {
						   Spin.lblReel1.setLocation(Spin.lblReel1.getX(), Spin.lblReel1.getY()+2);
						 
						    try {
									TimeUnit.MICROSECONDS .sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    	
							
							
			   }
					for(int x=0;x<45;x++) {
						   Spin.lblReel1.setLocation(Spin.lblReel1.getX(), Spin.lblReel1.getY()-2);
						 
						    try {
									TimeUnit.MICROSECONDS .sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    				
			   }
					for(int x=0;x<30;x++) {
						   Spin.lblReel1.setLocation(Spin.lblReel1.getX(), Spin.lblReel1.getY()+1);
						 
						    try {
									TimeUnit.MICROSECONDS .sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    				
			   }
					System.out.println("a a "+arr[i]); 
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