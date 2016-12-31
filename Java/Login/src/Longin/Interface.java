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
		this.setTitle("�������");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 410);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createComps();
		createBasic();
	}
	//���ñ���
    private void createBasic(){
		ImageIcon img = new ImageIcon("1.jpg");		// ���Ǳ���ͼƬ
		JLabel imgLabel = new JLabel(img);		    // ������ͼ���ڱ�ǩ�			
		imgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getLayeredPane().add(imgLabel, new	Integer(Integer.MIN_VALUE));
		JPanel cp = (JPanel)this.getContentPane();			 
		cp.setOpaque(false); 
	}
    private void createComps(){
		Font myFont = new Font("΢���ź�",Font.PLAIN,16);//���ô���
		regBtn = new JButton();    //ע���
		logBtn = new JButton();    //��¼��
		exitBtn = new JButton();   //�˳���
		logoLabel = new JLabel("����");
		logoLabel.setForeground(Color.white );
		logoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 48));
		logoLabel.setHorizontalAlignment(JLabel.CENTER);
		logoLabel.setBounds(140, 0, 120, 120);
     	logoLabel2 = new JLabel("����");
     	logoLabel2.setForeground(Color.blue);
		logoLabel2.setFont(new Font("΢���ź�", Font.PLAIN, 48));
	    logoLabel2.setHorizontalAlignment(JLabel.CENTER);
		logoLabel2.setBounds(240, 0, 120, 120);
		exitBtn.setBounds(226, 312, 72, 36);
		regBtn.setBounds(226, 227, 72, 36);
		logBtn.setBounds(226, 149, 72, 36);
		regBtn.setText("ע��");
		regBtn.setFont(myFont);
		exitBtn.setText("�˳�");
		exitBtn.setFont(myFont);
		logBtn.setText("��¼");
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
		//���õ�¼��ע�ᣬ�˳�����
		log();
		reg();
		Exit();
	}
    //��¼����
	public void log(){
		logBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
							Interface.this.dispose();//�رյ�ǰ����
							LoginFrame login = new LoginFrame();//�򿪵�¼����
							login.setVisible(true);
	          }
		});
	}
	//ע�ắ��
	public void reg(){
		regBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Interface.this.dispose();//�رյ�ǰ����
				RegisterFrame regFrm = new RegisterFrame();//��ע�ᴰ��
				regFrm.setVisible(true);
			}
			});
	}
	//�˳�ϵͳ
	public void Exit(){
		exitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Interface.this.dispose();   //�رյ�ǰ����
			}
			});
	}
}
