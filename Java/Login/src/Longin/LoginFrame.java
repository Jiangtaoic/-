 package Longin;
 
import java.io.*;
import java.net.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginFrame extends JFrame{
	String n;
	String account,passward;
	private JButton exitBtn;
	private JButton logBtn;
	private JTextField useridText;
	private JPasswordField passwordText;
	private JLabel useridLabel;
	private JLabel passwordLabel;
	public LoginFrame(){
		this.setTitle("南天白云登录");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 460);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//调用窗体函数
		createComps();
		createBasic();
	}
	//设置背景
    private void createBasic(){
		ImageIcon img = new ImageIcon("2.jpg");		// 这是背景图片
		JLabel imgLabel = new JLabel(img);		    // 将背景图放在标签里。			
		imgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 
	}
    //窗体设计
    private void createComps(){
		Font myFont = new Font("微软雅黑", Font.PLAIN, 16);  
		exitBtn = new JButton();
		logBtn = new JButton();
		useridText = new JTextField();
		passwordText = new JPasswordField();
		useridLabel = new JLabel("账号:");
		useridLabel.setFont(myFont);
		passwordLabel = new JLabel("密码:");
		passwordLabel.setFont(myFont);
		useridLabel.setBounds(100, 200, 40, 20);
		useridText.setBounds(160, 200, 220, 20);
		passwordLabel.setBounds(100, 250, 40, 20);
		passwordText.setBounds(160, 250, 220, 20);
		exitBtn.setBounds(260, 300, 120, 40);
		logBtn.setBounds(100, 300, 120, 40);
		exitBtn.setText("退出");
		exitBtn.setFont(myFont);
		logBtn.setText("登录");
		logBtn.setFont(myFont);
		this.setLayout(null);
		this.getContentPane().add(exitBtn);
		this.getContentPane().add(logBtn);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(useridLabel);
		this.getContentPane().add(useridText);
		//调用登录，退出函数
		log();
		Exit();
	}
    //登录函数
	public void log(){
		//触发登录键后
		logBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 PrintWriter os = null;
				 BufferedReader is = null;
				 Socket server;
				 //与服务器端建立连接，核对账户信息
				try {    
				    server = new Socket("192.168.31.93", 4446);
				    os = new PrintWriter(server.getOutputStream());
				    is = new BufferedReader(new InputStreamReader(server.getInputStream()));
				}catch(Exception e1){
					e1.printStackTrace();
				}     
				String inputString = " ";
				account = useridText.getText();
				passward = new String(passwordText.getPassword());
				//核对账号格式
				if(account.matches("^(13\\d|15[036-9]|18[89])\\d{8}")){
					if(passward.length() >= 6 && passward.length() <= 16){
						LoginFrame.this.dispose();
						inputString = "denglu";
			    	    os.println(inputString);
						os.flush();
			    	    os.println(account);
						os.flush();
			    	    os.println(passward);
						os.flush();
						os.println("tuichu");
						os.flush();
						//从服务器接收信息 
					    try {
							n = is.readLine();
							is.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    //判断登录是否成功
						if(n.equals("1") == true)
							JOptionPane.showMessageDialog(null, "登录成功！");
						//登录失败则重新登录
						else
							{
							JOptionPane.showMessageDialog(null, "登录失败，请重新登录！");
							LoginFrame.this.dispose();
							LoginFrame login = new LoginFrame();
							login.setVisible(true);
							}
						os.close();
					}else{JOptionPane.showMessageDialog(null, "密码格式错误");}
				}else{JOptionPane.showMessageDialog(null, "账号格式错误");}	
			}
		});
	}
	//触发退出键，退出到起始界面
	public void Exit(){
		exitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame.this.dispose();     //关闭当前界面
				Interface inter = new Interface();//打开起始界面
				inter.setVisible(true);
			}
			});
	}
}

