package app;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Question4 {

	private JFrame frame;
	private JTextField firstNum;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question4 window = new Question4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Question4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First  Number");
		lblNewLabel.setBounds(43, 34, 93, 23);
		frame.getContentPane().add(lblNewLabel);
		
		firstNum = new JTextField();
		firstNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char charTyped = e.getKeyChar();
				if(!(Character.isDigit(charTyped)) && charTyped != '.'){
					e.consume();
				}
				
			}
		});
		firstNum.setBounds(43, 68, 86, 20);
		frame.getContentPane().add(firstNum);
		firstNum.setColumns(10);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setBounds(212, 36, 111, 19);
		frame.getContentPane().add(lblSecondNumber);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char charTyped = e.getKeyChar();
				if(!(Character.isDigit(charTyped)) && charTyped != '.'){
					e.consume();
				}
			}
		});
		textField.setBounds(212, 68, 145, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "What do you want to do?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(42, 125, 315, 129);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton mulRadio = new JRadioButton("Mutiplication");
		buttonGroup.add(mulRadio);
		mulRadio.setBounds(19, 33, 109, 23);
		panel.add(mulRadio);
		
		JRadioButton divRadio = new JRadioButton("Division");
		buttonGroup.add(divRadio);
		divRadio.setBounds(185, 33, 109, 23);
		panel.add(divRadio);
		
		JRadioButton addRadio = new JRadioButton("Addition");
		buttonGroup.add(addRadio);
		addRadio.setBounds(19, 79, 109, 23);
		panel.add(addRadio);
		
		JRadioButton subRadio = new JRadioButton("Subtraction");
		buttonGroup.add(subRadio);
		subRadio.setBounds(185, 79, 109, 23);
		panel.add(subRadio);
		
		JLabel answer = new JLabel("");
		answer.setBounds(242, 332, 81, 29);
		frame.getContentPane().add(answer);
		
		JLabel warning = new JLabel("");
		warning.setBounds(43, 99, 192, 19);
		frame.getContentPane().add(warning);
		
		JButton btnPerformOperation = new JButton("Perform Operation");
		btnPerformOperation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double num1 =0;
				double num2 = 0;
			
				try{
					num1 = Double.parseDouble(firstNum.getText());
				}catch(NumberFormatException nfe ){
					warning.setText("Enter a valid input at box 1");
				}
				
				try{
					num2 = Double.parseDouble(textField.getText());
				}catch(NumberFormatException nfe ){
					warning.setText("Enter a valid input at box 2");
				}
				
				
				
				
				
				if(mulRadio.isSelected()){
					double mul = num1* num2;
					answer.setText(String.valueOf(mul));
				}else if(addRadio.isSelected()){
					double add = num1 + num2; 
					answer.setText(String.valueOf(add));
				}else if(subRadio.isSelected()){
					double sub = num1 - num2;
					answer.setText(String.valueOf(sub));
				}else if(divRadio.isSelected()){
					double div = num1/num2;
					answer.setText(String.valueOf(div));
				}
				
			}
		});
		btnPerformOperation.setBounds(105, 276, 183, 29);
		frame.getContentPane().add(btnPerformOperation);
		
		JLabel lblTheResultOf = new JLabel("The result of the operation is: ");
		lblTheResultOf.setBounds(43, 332, 183, 29);
		frame.getContentPane().add(lblTheResultOf);
		
		
		
		
	}
}
