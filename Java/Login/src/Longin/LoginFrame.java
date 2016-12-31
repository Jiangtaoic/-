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
		this.setTitle("������Ƶ�¼");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 460);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//���ô��庯��
		createComps();
		createBasic();
	}
	//���ñ���
    private void createBasic(){
		ImageIcon img = new ImageIcon("2.jpg");		// ���Ǳ���ͼƬ
		JLabel imgLabel = new JLabel(img);		    // ������ͼ���ڱ�ǩ�			
		imgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 
	}
    //�������
    private void createComps(){
		Font myFont = new Font("΢���ź�", Font.PLAIN, 16);  
		exitBtn = new JButton();
		logBtn = new JButton();
		useridText = new JTextField();
		passwordText = new JPasswordField();
		useridLabel = new JLabel("�˺�:");
		useridLabel.setFont(myFont);
		passwordLabel = new JLabel("����:");
		passwordLabel.setFont(myFont);
		useridLabel.setBounds(100, 200, 40, 20);
		useridText.setBounds(160, 200, 220, 20);
		passwordLabel.setBounds(100, 250, 40, 20);
		passwordText.setBounds(160, 250, 220, 20);
		exitBtn.setBounds(260, 300, 120, 40);
		logBtn.setBounds(100, 300, 120, 40);
		exitBtn.setText("�˳�");
		exitBtn.setFont(myFont);
		logBtn.setText("��¼");
		logBtn.setFont(myFont);
		this.setLayout(null);
		this.getContentPane().add(exitBtn);
		this.getContentPane().add(logBtn);
		this.getContentPane().add(passwordLabel);
		this.getContentPane().add(passwordText);
		this.getContentPane().add(useridLabel);
		this.getContentPane().add(useridText);
		//���õ�¼���˳�����
		log();
		Exit();
	}
    //��¼����
	public void log(){
		//������¼����
		logBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 PrintWriter os = null;
				 BufferedReader is = null;
				 Socket server;
				 //��������˽������ӣ��˶��˻���Ϣ
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
				//�˶��˺Ÿ�ʽ
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
						//�ӷ�����������Ϣ 
					    try {
							n = is.readLine();
							is.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    //�жϵ�¼�Ƿ�ɹ�
						if(n.equals("1") == true)
							JOptionPane.showMessageDialog(null, "��¼�ɹ���");
						//��¼ʧ�������µ�¼
						else
							{
							JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������µ�¼��");
							LoginFrame.this.dispose();
							LoginFrame login = new LoginFrame();
							login.setVisible(true);
							}
						os.close();
					}else{JOptionPane.showMessageDialog(null, "�����ʽ����");}
				}else{JOptionPane.showMessageDialog(null, "�˺Ÿ�ʽ����");}	
			}
		});
	}
	//�����˳������˳�����ʼ����
	public void Exit(){
		exitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame.this.dispose();     //�رյ�ǰ����
				Interface inter = new Interface();//����ʼ����
				inter.setVisible(true);
			}
			});
	}
}

