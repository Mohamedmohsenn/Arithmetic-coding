import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;

public class Arthithmetic_Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arthithmetic_Gui frame = new Arthithmetic_Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Arthithmetic_Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1290, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField.setBounds(219, 18, 274, 123);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblEnterTheWord = new JLabel("Enter the word :");
		lblEnterTheWord.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblEnterTheWord.setForeground(Color.DARK_GRAY);
		lblEnterTheWord.setBounds(37, 56, 170, 39);
		contentPane.add(lblEnterTheWord);

		JButton btnNewButton = new JButton("Compression");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x = textField.getText().toString();
				Compression b = new Compression(x);
				try {
					for (int i = 0; i < x.length(); i++) {
						if (x.charAt(i) == '1' || x.charAt(i) == '2'
								|| x.charAt(i) == '3' || x.charAt(i) == '4'
								|| x.charAt(i) == '5' || x.charAt(i) == '6'
								|| x.charAt(i) == '7' || x.charAt(i) == '8'
								|| x.charAt(i) == '9') {
							Exception e = null;
							throw e;
						}
					}
					textField_1.setText(b.makeCompression());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Enter valid characters");
				}
			}
		});
		btnNewButton.setBounds(37, 263, 456, 132);
		contentPane.add(btnNewButton);
		final Decompression d = new Decompression();
		JButton btnNewButton_1 = new JButton("Decompression");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float z = Float.parseFloat(textField_2.getText());

				d.value = z;
				d.inputSize = Integer.parseInt(textField_4.getText());
				 
				textField_3.setText(d.Decompress());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(639, 492, 601, 113);
		contentPane.add(btnNewButton_1);

		JLabel label = new JLabel("");
		label.setBounds(68, 475, 56, 16);
		contentPane.add(label);

		JLabel text_field1 = new JLabel("The Value is : ");
		text_field1.setForeground(Color.DARK_GRAY);
		text_field1.setFont(new Font("Tahoma", Font.BOLD, 20));
		text_field1.setBounds(37, 534, 148, 91);
		contentPane.add(text_field1);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLUE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_1.setBounds(219, 519, 274, 113);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEnterTheValue = new JLabel("Enter the value :");
		lblEnterTheValue.setForeground(Color.DARK_GRAY);
		lblEnterTheValue.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblEnterTheValue.setBounds(703, 47, 181, 57);
		contentPane.add(lblEnterTheValue);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLUE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_2.setBounds(932, 25, 308, 123);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblTheTextIs = new JLabel("The Text is :");
		lblTheTextIs.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTheTextIs.setBounds(639, 633, 170, 39);
		contentPane.add(lblTheTextIs);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLUE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_3.setBounds(808, 618, 432, 68);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblWordsNumber = new JLabel("Words number :");
		lblWordsNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWordsNumber.setForeground(Color.DARK_GRAY);
		lblWordsNumber.setBounds(1001, 161, 124, 32);
		contentPane.add(lblWordsNumber);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_4.setBounds(1124, 166, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		table = new JTable();
		table.setBounds(672, 405, 222, -191);
		contentPane.add(table);

		table_1 = new JTable();
		table_1.setForeground(Color.BLUE);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		final DefaultTableModel model = new DefaultTableModel(new Object[][] {

		}, new String[] { "Symbol", "Prob" });
		table_1.setModel(model);

		table_1.setBounds(639, 236, 601, 208);
		contentPane.add(table_1);

		JLabel lblSymbol = new JLabel("symbol");
		lblSymbol.setForeground(Color.RED);
		lblSymbol.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSymbol.setBounds(735, 204, 148, 27);
		contentPane.add(lblSymbol);

		JLabel lblProb = new JLabel("probability");
		lblProb.setForeground(Color.RED);
		lblProb.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProb.setBounds(1011, 201, 153, 32);
		contentPane.add(lblProb);

		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] row = new Object[2];
				Item c = new Item();
				row[0] = textField_5.getText();
				c.symbol = textField_5.getText().charAt(0);
				row[1] = Float.parseFloat(textField_6.getText());
				c.prob = Float.parseFloat(textField_6.getText());
				d.items.add(c);
				model.addRow(row);
				int n = d.items.size();
				// One by one move boundary of unsorted subarray
				for (int i = 0; i < n - 1; i++) {
					// Find the minimum element in unsorted array
					int min = i;
					for (int j = i + 1; j < n; j++) {
						if (d.items.get(j).symbol < d.items.get(min).symbol) {
							min = j;
						}
					}
					char temp = d.items.get(min).symbol;
					d.items.get(min).symbol = d.items.get(i).symbol;
					d.items.get(i).symbol = temp;

					float temp2 = d.items.get(min).prob;
					d.items.get(min).prob = d.items.get(i).prob;
					d.items.get(i).prob = temp2;
				}
				for (int i = 0; i < d.items.size(); i++) {
					if (i == 0) {
						d.items.get(i).lower = 0;
						d.items.get(i).higher = d.items.get(i).prob;
					} else {
						d.items.get(i).lower = d.items.get(i - 1).higher;
						d.items.get(i).higher = d.items.get(i).lower
								+ d.items.get(i).prob;
					}
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(1011, 457, 97, 25);
		contentPane.add(btnAdd);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_5.setBounds(649, 457, 181, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_6.setBounds(852, 457, 148, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				d.items.clear();
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(1124, 457, 97, 25);
		contentPane.add(btnClear);
	}
}
