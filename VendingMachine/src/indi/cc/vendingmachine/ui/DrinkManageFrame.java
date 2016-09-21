package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class DrinkManageFrame extends JDialog {
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private JDialog jd;
	private Vector<Drink> drinks;
	private int count = 0;
	private Administrator admin;
		/**
		 * 
		 * @param owner ���ĸ�����
		 * @param title ������
		 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
		 */
		public DrinkManageFrame(JFrame owner, String title, boolean modal,Administrator admin){
			super(owner, title, modal);
			this.admin = admin;
			  initComponents();
			  WindowUtil.setFrameCenter(this);
		        this.setResizable(false);
		        this.setVisible(true);
		}
	             
	    private void initComponents() {
	    	AdminManageHelper helper = new AdminManageHelper();	
	    	drinks = helper.getAllDrink();	//�����������
	    	
	        jLabel2 = new javax.swing.JLabel();
	        jSeparator1 = new javax.swing.JSeparator();
	        jSeparator2 = new javax.swing.JSeparator();
	        jTextField1 = new javax.swing.JTextField(drinks.get(count).getId());
	        jTextField1.setEditable(false);//���ò��ɱ༭
	        jLabel3 = new javax.swing.JLabel();
	        jTextField2 = new javax.swing.JTextField(drinks.get(count).getDrinkName());
	        jTextField2.setEditable(false);//���ò��ɱ༭
	        jLabel4 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField(drinks.get(count).getPrice()+"Ԫ");
	        jTextField3.setEditable(false);//���ò��ɱ༭
	        jSeparator3 = new javax.swing.JSeparator();
	        jSeparator4 = new javax.swing.JSeparator();
	        jLabel1 = new javax.swing.JLabel();
	        jTextField4 = new javax.swing.JTextField(drinks.get(count).getQuantity()+"ƿ");
	        jTextField4.setEditable(false);//���ò��ɱ༭
	        jButton4 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();
	        jButton7 = new javax.swing.JButton();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton(new ImageIcon(drinks.get(0).getDrinkImg()));	//ͼƬ��ť
	        

	
	        jLabel2.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jLabel2.setText("��ţ�");
	
	        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
	
	       
	
	        jLabel3.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jLabel3.setText("��������");
	
	        
	
	        jLabel4.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jLabel4.setText("�۸�");
	
	       
	
	        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
	
	        jLabel1.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jLabel1.setText("������");
	
	        jButton4.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jButton4.setText("��һ��");
	        jButton4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(count<=0){
						JOptionPane.showMessageDialog(jd, "�Ѿ�����ǰһ����!!");
						return ;
					}else{
						count--;
						updateContent();
					}
				}
			});
	
	        jButton5.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jButton5.setText("��һ��");
	       jButton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(count>=drinks.size()-1){
					JOptionPane.showMessageDialog(jd, "�Ѿ������һ����!!");
					return ;
				}else{
					count++;
					updateContent();
				}
			}
		});
	
	        jButton6.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jButton6.setText("�޸�������Ϣ");
	       jButton6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UpdateDrinkFrame drinkFrame = new UpdateDrinkFrame(jd, "�޸�������Ϣ", true, drinks.get(count));
				drinks = helper.getAllDrink();	//������������
				updateContent();	//����״̬
			}
		});
	
	        jButton7.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
	        jButton7.setText("ɾ��������");
	        jButton7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AdminManageHelper helper = new AdminManageHelper();
					if(helper.deleteDrink(drinks.get(count))){
						JOptionPane.showMessageDialog(jd, "ɾ���ɹ�!!");
						drinks = helper.getAllDrink();	//������������
						if(count==0){	//ɾ�����ǵ�һ��
							//����Ҫ�ı�
						}else{	//�������
							count--;
						}
						updateContent();//����״̬
						return ;
					}else {
						JOptionPane.showMessageDialog(jd, "ɾ��ʧ��!!");
						return ;
					}
					
				}
			});

        jButton1.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jButton1.setText("����������");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AddDrinkFrame drinkFrame = new AddDrinkFrame(jd, "����������", true,admin);
				drinks = helper.getAllDrink();	//������������
				updateContent();//����״̬
			}
		});

        jButton2.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jButton2.setText("���������");
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AddQuantityDrinkFrame drinkFrame = new AddQuantityDrinkFrame(jd, "����"+drinks.get(count).getDrinkName()+"����", true,drinks.get(count),admin);
				updateContent();//����״̬
			}
		});

        jButton3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                        .addComponent(jTextField4)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        
        
        
    }
	    //���½����е�����
	    private void updateContent(){
	    	jTextField1.setText(drinks.get(count).getId());
	    	jTextField2.setText(drinks.get(count).getDrinkName());
	    	jTextField3.setText(drinks.get(count).getPrice()+"Ԫ");
	    	jTextField4.setText(drinks.get(count).getQuantity()+"ƿ");
	    	jButton3.setIcon(new ImageIcon(drinks.get(count).getDrinkImg()));
	    	jButton3.updateUI();
        }
   

                
}