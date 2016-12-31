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
	//���ô���
	public RegisterFrame(){
		this.setTitle("��������˺�ע��");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//���ô�����ƺ���
		createComps();
		createBasic();
	}
	//����������
	private void createComps(){
		Font myFont = new Font("΢���ź�", Font.PLAIN, 16);
		regBtn = new JButton("ע��");
		exitBtn = new JButton("�˳�");
		useridText = new JTextField();
		passwordText = new JPasswordField();
		pwcheckText = new JPasswordField();
		useridLabel = new JLabel("�������˺ţ��ֻ����룩:");
		passwordLabel = new JLabel("����������6-16λ:");
		pwcheckLabel = new JLabel("���ٴ���������:");
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
			//������¼��
			if (e.getSource() == regBtn){
				account = useridText.getText();
				passward = new String(passwordText.getPassword());
				//�˶��˺ż������ʽ
				if (account.matches("^(13\\d|15[036-9]|18[89])\\d{8}")){      //���ֻ������˺�
					String pwcheck = new String(pwcheckText.getPassword());
					if (passward.length() >= 6 && passward.length() <= 16){
						if (pwcheck.equals(passward)){
							JOptionPane.showMessageDialog(null, "ע��ɹ����¼��");
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
						//����������ʹ˴�ע����Ϣ
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
							JOptionPane.showMessageDialog(null, "�����������벻һ��");
						}
					}else{
						JOptionPane.showMessageDialog(null, "�����ʽ����");
					}
				}else{
					JOptionPane.showMessageDialog(null, "�˺Ÿ�ʽ����");
				}
			}
			//�����˳����������¼����
			else if(e.getSource() == exitBtn){
				RegisterFrame.this.dispose();    //�رյ�ǰ����
				LoginFrame login = new LoginFrame();//�򿪵�¼����
				login.setVisible(true);
			}
		}
	}
	//���ñ�������
	private void createBasic(){
		ImageIcon img = new ImageIcon("2.jpg");		// ���Ǳ���ͼƬ
		JLabel imgLabel = new JLabel(img);		    // ������ͼ���ڱ�ǩ�			
		imgLabel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.getLayeredPane().add(imgLabel,new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 		
	}
}
