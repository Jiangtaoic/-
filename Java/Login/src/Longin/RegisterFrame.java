package Longin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class RegisterFrame extends JFrame{
	String account,passward;
	private JButton regBtn,exitBtn;
	private JTextField useridText;
	private JPasswordField passwordText;
	private JPasswordField pwcheckText;
	private JLabel useridLabel;
	private JLabel passwordLabel;
	private JLabel pwcheckLabel;
	//设置窗体
	public RegisterFrame(){
		this.setTitle("南天白云账号注册");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//调用窗体设计函数
		createComps();
		createBasic();
	}
	//窗体组成设计
	private void createComps(){
		Font myFont = new Font("微软雅黑", Font.PLAIN, 16);
		regBtn = new JButton("注册");
		exitBtn = new JButton("退出");
		useridText = new JTextField();
		passwordText = new JPasswordField();
		pwcheckText = new JPasswordField();
		useridLabel = new JLabel("请输入账号（手机号码）:");
		passwordLabel = new JLabel("请输入密码6-16位:");
		pwcheckLabel = new JLabel("请再次输入密码:");
		regBtn.setBounds(120, 340, 100, 40);
		regBtn.setFont(myFont);
		exitBtn.setBounds(260, 340, 100, 40);
		exitBtn.setFont(myFont);
		useridLabel.setBounds(120, 200, 240, 20);
		useridLabel.setFont(myFont);
		useridText.setBounds(120, 220, 240, 20);
		passwordLabel.setBounds(120, 240, 240, 20);
		passwordLabel.setFont(myFont);
		passwordText.setBounds(120, 260, 240, 20);
		pwcheckLabel.setBounds(120, 280, 240, 20);
		pwcheckLabel.setFont(myFont);
		pwcheckText.setBounds(120, 300, 240, 20);
		this.setLayout(null);
		this.getContentPane().add(regBtn);
		this.getContentPane().add(exitBtn);
		this.getContentPane().add(useridText);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(pwcheckText);
		this.getContentPane().add(useridLabel);
		this.getContentPane().add(pwcheckLabel);
		this.getContentPane().add(passwordLabel);
		MyListener myListener = new MyListener();
		regBtn.addActionListener(myListener);
		exitBtn.addActionListener(myListener);
	}
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//触发登录键
			if (e.getSource() == regBtn){
				account = useridText.getText();
				passward = new String(passwordText.getPassword());
				//核对账号及密码格式
				if (account.matches("^(13\\d|15[036-9]|18[89])\\d{8}")){      //以手机号作账号
					String pwcheck = new String(pwcheckText.getPassword());
					if (passward.length() >= 6 && passward.length() <= 16){
						if (pwcheck.equals(passward)){
							JOptionPane.showMessageDialog(null, "注册成功请登录！");
							RegisterFrame.this.dispose();
							LoginFrame login = new LoginFrame();
							login.setVisible(true);
							String inputString= " ";
							PrintWriter os = null;
							 Socket server;
						try {    
							    server = new Socket("192.168.31.93", 4446);
							    os = new PrintWriter(server.getOutputStream());
							}catch(Exception e1){
								e1.printStackTrace();
							}
						//向服务器发送此次注册信息
						inputString = "zhuce";
			    	    os.println(inputString);
						os.flush();
			    	    os.println(account);
						os.flush();
			    	    os.println(passward);
						os.flush();
						os.println("tuichu");
						os.flush();
						os.close();
						}else{
							JOptionPane.showMessageDialog(null, "两次密码输入不一致");
						}
					}else{
						JOptionPane.showMessageDialog(null, "密码格式错误");
					}
				}else{
					JOptionPane.showMessageDialog(null, "账号格式错误");
				}
			}
			//触发退出键，到达登录界面
			else if(e.getSource() == exitBtn){
				RegisterFrame.this.dispose();    //关闭当前窗口
				LoginFrame login = new LoginFrame();//打开登录窗口
				login.setVisible(true);
			}
		}
	}
	//设置背景函数
	private void createBasic(){
		ImageIcon img = new ImageIcon("2.jpg");		// 这是背景图片
		JLabel imgLabel = new JLabel(img);		    // 将背景图放在标签里。			
		imgLabel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 		
	}
}
