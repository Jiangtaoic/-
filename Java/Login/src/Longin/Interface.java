package Longin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Interface extends JFrame{
	private JButton regBtn;
	private JButton logBtn;
	private JButton exitBtn;
	private JLabel logoLabel,logoLabel2;
	public Interface(){
		this.setTitle("南天白云");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 410);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createComps();
		createBasic();
	}
	//设置背景
    private void createBasic(){
		ImageIcon img = new ImageIcon("1.jpg");		// 这是背景图片
		JLabel imgLabel = new JLabel(img);		    // 将背景图放在标签里。			
		imgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getLayeredPane().add(imgLabel, new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 
	}
    private void createComps(){
		Font myFont = new Font("微软雅黑",Font.PLAIN,16);//设置窗体
		regBtn = new JButton();    //注册键
		logBtn = new JButton();    //登录键
		exitBtn = new JButton();   //退出键
		logoLabel = new JLabel("南天");
		logoLabel.setForeground(Color.white );
		logoLabel.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		logoLabel.setHorizontalAlignment(JLabel.CENTER);
		logoLabel.setBounds(140, 0, 120, 120);
     	logoLabel2 = new JLabel("白云");
     	logoLabel2.setForeground(Color.blue);
		logoLabel2.setFont(new Font("微软雅黑", Font.PLAIN, 48));
	    logoLabel2.setHorizontalAlignment(JLabel.CENTER);
		logoLabel2.setBounds(240, 0, 120, 120);
		exitBtn.setBounds(226, 312, 72, 36);
		regBtn.setBounds(226, 227, 72, 36);
		logBtn.setBounds(226, 149, 72, 36);
		regBtn.setText("注册");
		regBtn.setFont(myFont);
		exitBtn.setText("退出");
		exitBtn.setFont(myFont);
		logBtn.setText("登录");
		logBtn.setFont(myFont);
		logBtn.setBackground(Color.white );
		regBtn.setBackground(Color.white );
		exitBtn.setBackground(Color.white );
		this.setLayout(null);
		this.getContentPane().add(regBtn);
		this.getContentPane().add(logBtn);
		this.getContentPane().add(exitBtn);
		this.getContentPane().add(logoLabel);
		this.getContentPane().add(logoLabel2);
		//调用登录，注册，退出函数
		log();
		reg();
		Exit();
	}
    //登录函数
	public void log(){
		logBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
							Interface.this.dispose();//关闭当前界面
							LoginFrame login = new LoginFrame();//打开登录界面
							login.setVisible(true);
	          }
		});
	}
	//注册函数
	public void reg(){
		regBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Interface.this.dispose();//关闭当前窗口
				RegisterFrame regFrm = new RegisterFrame();//打开注册窗口
				regFrm.setVisible(true);
			}
			});
	}
	//退出系统
	public void Exit(){
		exitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Interface.this.dispose();   //关闭当前窗口
			}
			});
	}
}
