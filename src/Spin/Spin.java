package Spin;


import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;

public class Spin{
	private static int [] rNums=new int [4];
	private JFrame frame=new JFrame();
	public static JPanel panel = new JPanel();
	public static JPanel panel1 = new JPanel();
	public static JPanel panel2 = new JPanel();
	public static JPanel panel3 = new JPanel();
	public static String path="images\\";
	public static String [] img;
	public static JLabel lblReel1=new JLabel(""); 
	public static JLabel lblReel2=new JLabel("");
	public static JLabel lblReel3=new JLabel("");
	public static JLabel lblReel4=new JLabel("");
	public int f=0;
	//buttons
	private static JRadioButton rdbtn50;
	private static JRadioButton rdbtn33;
	private static JRadioButton rdbtn10;
	
	private final JLabel label = new JLabel("");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spin set=new Spin();
		set.setGUI();
		
	}
	private void setGUI() {
		 
		getImg();
		frame.setBounds(100, 100, 682, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label.setBounds(0, 104, 666, 255);
		//Background
		ImageIcon MyImage = new ImageIcon("res\\img\\rolls.png");
		Image im = MyImage.getImage();
		Image newImg = im.getScaledInstance(650, 200, Image.SCALE_DEFAULT);
	    ImageIcon image= new ImageIcon(newImg);
	    //
	    
	    LineBorder line = new LineBorder(new Color(0, 200, 0), 2, true);//dark green border
	    
	    panel1.setBounds(172, 145, 158, 157);
	   // panel1.setBorder(line);
	    frame.getContentPane().add(panel1);
	    panel1.setLayout(null);
	    
	    lblReel2.setBounds(22, 29, 111, 122);
	    panel1.add(lblReel2);
	    lblReel2.setIcon(new ImageIcon(path+img[2]));
	    

	    panel2.setBounds(328, 145, 143, 157);
	   // panel2.setBorder(line);
	    frame.getContentPane().add(panel2);
	    panel2.setLayout(null);
	    lblReel3.setBounds(22, 29, 111, 122);
	    panel2.add(lblReel3);
	    lblReel3.setIcon(new ImageIcon(path+img[3]));
	   
	
	    
	    lblReel1.setBounds(22, 29, 111, 122);
	    panel.add(lblReel1);
	    lblReel1.setIcon(new ImageIcon(path+img[1]));
	    
	    	
	    panel.setBounds(28, 145, 143, 157);
	    //panel.setBorder(line);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    panel3.setLayout(null);
		panel3.setBounds(473, 145, 143, 157);
		frame.getContentPane().add(panel3);
		
		
		lblReel4.setBounds(22, 29, 111, 122);
		lblReel4.setIcon(new ImageIcon(path+img[0]));
		panel3.add(lblReel4);
	    		
	    		
	    		
	    label.setIcon(image);
		frame.getContentPane().add(label);
		
		label.setOpaque(true);
				
		//Buttons
		rdbtn50 = new JRadioButton("50%");
		rdbtn50.setBounds(0, 245, 109, 23);
		rdbtn50.setSelected(true);
		rdbtn33 = new JRadioButton("33%");
		rdbtn33.setBounds(0, 271, 109, 23);
		rdbtn10 = new JRadioButton("10%");
		rdbtn10.setBounds(0, 296, 109, 23);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn50);
		group.add(rdbtn33);
		group.add(rdbtn10);
		    
		
				panel.setOpaque(false);
				panel1.setOpaque(false);
				panel2.setOpaque(false);
				panel3.setOpaque(false);
				
				
		frame.setVisible(true);
		frame.addMouseListener(new MouseAdapter() {
				      public void mouseClicked(MouseEvent e) {
				    	  if (e.getButton() == MouseEvent.BUTTON1){
				    		  
				    		  if (!ThreadForLoopA.running&&!ThreadForLoopB.running&&!ThreadForLoopC.running) {
				    			  calculateRands();
				    		  	ThreadForLoopA threadA = new ThreadForLoopA();
				    		  	threadA.start();
								ThreadForLoopB threadB = new ThreadForLoopB();
								threadB.start();
								ThreadForLoopC threadC = new ThreadForLoopC();
								threadC.start();
								ThreadForLoopD threadD = new ThreadForLoopD();
								threadD.start();
				    		  }
				    	  }
				    	  if (e.getButton() == MouseEvent.BUTTON3) {
				    		  
				              System.out.println("click2");
				    	  	JFrame frame1 = new JFrame("Options");
				    	  	JPanel panelA = new JPanel(new GridLayout(1,3));
				    	  	JPanel panelB = new JPanel(new GridLayout(7,2));
				  
				    	    //JPanel panel = new JPanel();
				    	    //frame1.getContentPane().add(panel);
				    	    JLabel lblProb = new JLabel("Probability:");
							lblProb.setBounds(22, 275, 71, 14);
							panelA.add(lblProb);
							panelA.add(rdbtn50);
							panelA.add(rdbtn33);
							panelA.add(rdbtn10);

							
							
					        
			
							
							frame1.getContentPane().add(panelA,BorderLayout.NORTH);

							frame1.setVisible(true);
					    	frame1.setSize(frame.getWidth(),frame.getHeight());
					  
				    	    }
				    	  
				      }
		});
			
		
	}
	
	
	
	private void calculateRands() {
		boolean isWin=false;
		int prob=0;
		int numOfPics= img.length;
		if(rdbtn50.isSelected()) prob=50;
		if(rdbtn33.isSelected()) prob=33;
		if(rdbtn10.isSelected()) prob=10;
		
		Random ran = new Random();
		int randNum = ran.nextInt(101) + 1;
		if(randNum<prob) isWin=true;
		
		if(isWin==true) {
			randNum = ran.nextInt(numOfPics-1) + 1;
			rNums[0]=rNums[1]=rNums[2]=rNums[3]=randNum;
		}
		else {
			for(int i=0;i<4;i++) {
				randNum = ran.nextInt(numOfPics-1) + 1;
				rNums[i]= randNum;
			}
		}
	}
	
	public static int getRnum1() {
		return rNums[0];
	}
	
	public static int getRnum2() {
		return rNums[1];
	}
	
	public static int getRnum3() {
		return rNums[2];
	}
	
	
	public static int getRnum4() {
		return rNums[3];
	}
	
	private void getImg() {
		
		File x=new File(path);
		img=x.list();
    		
		
	}
}
