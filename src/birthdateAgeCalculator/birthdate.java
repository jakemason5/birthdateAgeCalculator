package birthdateAgeCalculator;

import java.time.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class birthdate 
{  
	 static int year = 0;
	   static int month = 0;
	   static int day = 0;
	   static LocalDate pdate;
	   static LocalDate now;
	   static Period diff;
	
	
   public static void main(String[] args)
    {
	   
	  //Text display to prompt user input and show what they should type
	   JTextField display = new JTextField("Enter your date of birth YYYY-MM-DD");
	   display.setEditable(false);
	   
	   //Text display to accept user input
	   JTextField prompt = new JTextField(10);
	   prompt.setToolTipText("Enter your date of birth YYYY-MM-DD");
	   
	   //Text field to display the users age after calculation
	   JTextField answer = new JTextField(10);
	   
	   //Button to start the calculation
	   JButton start = new JButton("Go");
	   
	   //Adding the listener to the button
	   start.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event) {
			   String date = prompt.getText();//getting the users input
			   String[] ordered = date.split("-");//splitting the input into date parts
			   year = Integer.parseInt(ordered[0]);//getting the years
			   month = Integer.parseInt(ordered[1]);//getting the month
			   day = Integer.parseInt(ordered[2]);//getting the day

			   //accepting the input of the users birth
			   pdate = LocalDate.of(year, month, day);

			   //getting todays date
			   now = LocalDate.now();

			   //calculating the difference. 
			   //To increase performance I included the months and the days for people to calculate their ages
			   diff = Period.between(pdate, now);
			   if(diff.getMonths() == 1) {
				   if(diff.getDays() == 1){
				         answer.setText("You are " + diff.getYears() + " years " + diff.getMonths() + " month and " + diff.getDays() + " day old ");

				     }
				     else{
				         answer.setText("You are " + diff.getYears() + " years " + diff.getMonths() + " month and " + diff.getDays() + " days old ");
				     }
			   }
			   else {
				   if(diff.getDays() == 1){
				         answer.setText("You are " + diff.getYears() + " years " + diff.getMonths() + " months and " + diff.getDays() + " day old ");

				     }
				     else{
				         answer.setText("You are " + diff.getYears() + " years " + diff.getMonths() + " months and " + diff.getDays() + " days old ");
				     }
			   }
				   
			     
		   }
		});
	   
	   
	   JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		//Putting everything on the panel and frame for display
		GridLayout layout = new GridLayout(3,3);
		panel.setPreferredSize(new Dimension(550, 300));
		panel.setLayout(layout);
		panel.add(display, BorderLayout.NORTH);
		panel.add(start, BorderLayout.SOUTH);
		panel.add(prompt,BorderLayout.CENTER);
		panel.add(answer, BorderLayout.EAST);
		frame.setSize(550, 300);
		frame.setTitle("Critical Thinking");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);            
    }
}