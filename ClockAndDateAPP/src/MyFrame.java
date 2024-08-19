import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem pmam,usMonth,euMonth,trMonth;
	JMenuItem hour24;
	SimpleDateFormat timeFormat; 
	SimpleDateFormat dayFormat; 
	SimpleDateFormat dateFormat;
	String date;
	String day;
	String time;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Date and Clock");
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(500,350));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		trMonth = new JMenuItem("Set Date Format to TR");
		usMonth = new JMenuItem("Set Date Format to US");
		euMonth = new JMenuItem("Set Date Format to EU");
		pmam = new JMenuItem("Set Hour in am/pm");
		hour24 = new JMenuItem("Set Hour in Day 0-23");
		
		hour24.addActionListener(this);
		menu = new JMenu("Settings");
		menuBar = new JMenuBar();
		pmam.addActionListener(this);
		
		
		
		timeFormat = new SimpleDateFormat("HH:mm:ss");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("yyyy MMMMM dd");
		
	
		
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,60));
		
		dateLabel= new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
		
		timeLabel = new JLabel();
		
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,100));
		timeLabel.setText(time);
		timeLabel.setBackground(Color.black);
		timeLabel.setForeground(Color.GREEN);
		timeLabel.setOpaque(true);
		
		usMonth.addActionListener(this);
		euMonth.addActionListener(this);
		trMonth.addActionListener(this);
		
		
		menu.add(pmam);
		menu.add(hour24);
		menu.add(trMonth);
		menu.add(usMonth);
		menu.add(euMonth);
		menuBar.add(menu);
		
		
		this.setJMenuBar(menuBar);
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		setTime();
	}
	public void setTime() {
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pmam) {
			timeFormat = new SimpleDateFormat("hh:mm:ss a");
			timeLabel.setFont(new Font(timeLabel.getFont().getFontName(),Font.PLAIN,73));
			
		}
		if(e.getSource()==hour24) {
			timeFormat = new SimpleDateFormat("HH:mm:ss");
			timeLabel.setFont(new Font(timeLabel.getFont().getFontName(),Font.PLAIN,100));
		}
		if(e.getSource()==usMonth) {
			dateFormat = new SimpleDateFormat("MMMMM dd yyyy");
		
		}
		if(e.getSource()==euMonth) {
			dateFormat = new SimpleDateFormat("yyyy MMMMM dd");
			
		
		}
		if(e.getSource()==trMonth) {
			dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
			
		
		}
	}
	
	
}
