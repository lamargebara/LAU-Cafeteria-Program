import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Resturant extends JFrame {

	private JPanel contentPane;
	private JTextField currencyinputLabel;
	JFrame frame;
	public double total;
	public double tax;
	public double subtotal;
	int mealtotal = 0;
	int drinktotal = 0;

	// Launch app.

	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resturant frame = new Resturant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.

	public Resturant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(255, 255, 255));
		menuPanel.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		menuPanel.setBounds(6, 58, 644, 453);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);

		JLabel food1Label = new JLabel("Chicken Sub");
		food1Label.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		food1Label.setBounds(29, 48, 158, 28);
		menuPanel.add(food1Label);

		JLabel food2Label = new JLabel("HotDog");
		food2Label.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		food2Label.setBounds(29, 88, 144, 33);
		menuPanel.add(food2Label);

		JLabel food3Label = new JLabel("Hamburger");
		food3Label.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		food3Label.setBounds(29, 133, 147, 28);
		menuPanel.add(food3Label);

		JLabel drinksLabel = new JLabel("Drinks");
		drinksLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		drinksLabel.setBounds(29, 173, 167, 28);
		menuPanel.add(drinksLabel);

		JLabel QuantityLabel = new JLabel("Quantity");
		QuantityLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		QuantityLabel.setBounds(314, 6, 144, 28);
		menuPanel.add(QuantityLabel);

		JCheckBox checkbox = new JCheckBox("");
		checkbox.setBounds(314, 223, 30, 23);
		menuPanel.add(checkbox);

		JLabel deliveryLabel = new JLabel("Delivery");
		deliveryLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		deliveryLabel.setBounds(359, 223, 114, 23);
		menuPanel.add(deliveryLabel);

		JComboBox comboBox1 = new JComboBox();
		String drinks[] = { "Select a drink: ", "Water", "Orange juice", "Ice tea", "Pepsi", "7UP" };
		comboBox1.setModel(new DefaultComboBoxModel(drinks));
		comboBox1.setBounds(20, 219, 188, 27);
		menuPanel.add(comboBox1);

		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(46, 139, 87));
		separator1.setBounds(29, 34, 585, 12);
		menuPanel.add(separator1);

		JLabel FoodMenuLabel = new JLabel("Food Menu");
		FoodMenuLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		FoodMenuLabel.setBounds(29, 6, 158, 28);
		menuPanel.add(FoodMenuLabel);

		JSpinner spinner1 = new JSpinner();
		spinner1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		spinner1.setBounds(324, 53, 71, 26);
		menuPanel.add(spinner1);

		JSpinner spinner2 = new JSpinner();
		spinner2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		spinner2.setBounds(324, 95, 71, 26);
		menuPanel.add(spinner2);

		JSpinner spinner3 = new JSpinner();
		spinner3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		spinner3.setBounds(324, 138, 71, 26);
		menuPanel.add(spinner3);

		JSpinner spinner4 = new JSpinner();
		spinner4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		spinner4.setBounds(324, 178, 71, 26);
		menuPanel.add(spinner4);

		JLabel CostOfDelivery = new JLabel("Cost of Drinks");
		CostOfDelivery.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		CostOfDelivery.setBounds(20, 278, 196, 28);
		menuPanel.add(CostOfDelivery);

		JLabel CostOfMeal = new JLabel("Cost of Meal");
		CostOfMeal.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		CostOfMeal.setBounds(20, 331, 167, 28);
		menuPanel.add(CostOfMeal);

		JLabel DeliveryFee = new JLabel("Delivery Fee");
		DeliveryFee.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		DeliveryFee.setBounds(20, 385, 167, 28);
		menuPanel.add(DeliveryFee);

		JLabel drinkcostLabel = new JLabel("");
		drinkcostLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		drinkcostLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		drinkcostLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		drinkcostLabel.setBounds(314, 276, 159, 30);
		menuPanel.add(drinkcostLabel);

		JLabel mealcostLabel = new JLabel("");
		mealcostLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mealcostLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		mealcostLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		mealcostLabel.setBounds(314, 329, 159, 30);
		menuPanel.add(mealcostLabel);

		JLabel deliveryfeeLabel = new JLabel("");
		deliveryfeeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		deliveryfeeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		deliveryfeeLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		deliveryfeeLabel.setBounds(314, 383, 159, 30);
		menuPanel.add(deliveryfeeLabel);

		JSeparator separator1_1 = new JSeparator();
		separator1_1.setForeground(new Color(46, 139, 87));
		separator1_1.setBounds(29, 258, 585, 12);
		menuPanel.add(separator1_1);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblPrice.setBounds(500, 6, 114, 28);
		menuPanel.add(lblPrice);

		JLabel lblLl = new JLabel("8000 L.L");
		lblLl.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblLl.setBounds(480, 48, 114, 28);
		menuPanel.add(lblLl);

		JLabel lblLl_1 = new JLabel("6000 L.L");
		lblLl_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblLl_1.setBounds(480, 93, 114, 28);
		menuPanel.add(lblLl_1);

		JLabel lblLl_2 = new JLabel("7000 L.L");
		lblLl_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblLl_2.setBounds(480, 133, 114, 28);
		menuPanel.add(lblLl_2);

		JLabel lblLl_3 = new JLabel("3500 L.L");
		lblLl_3.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblLl_3.setBounds(480, 173, 114, 28);
		menuPanel.add(lblLl_3);

		JPanel receiptPanel = new JPanel();
		receiptPanel.setBackground(new Color(255, 255, 255));
		receiptPanel.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		receiptPanel.setBounds(1012, 61, 338, 450);
		contentPane.add(receiptPanel);
		receiptPanel.setLayout(null);

		JLabel receiptLabel = new JLabel("Receipt");
		receiptLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiptLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		receiptLabel.setBounds(86, 21, 151, 35);
		receiptPanel.add(receiptLabel);

		JLabel receiptResultPanel = new JLabel("");
		receiptResultPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		receiptResultPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		receiptResultPanel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		receiptResultPanel.setBounds(18, 68, 299, 359);
		receiptPanel.add(receiptResultPanel);

		////////
		JTextArea rtextArea = new JTextArea();
		rtextArea.setBounds(39, 83, 260, 328);
		receiptPanel.add(rtextArea);

		JPanel currencyPanel = new JPanel();
		currencyPanel.setBorder(new LineBorder(new Color(220, 220, 220), 4, true));
		currencyPanel.setBounds(662, 58, 338, 248);
		contentPane.add(currencyPanel);
		currencyPanel.setLayout(null);

		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(
				new DefaultComboBoxModel(new String[] { "Choose Currency:", "US Dollars", "Lebanese Pounds" }));
		comboBox2.setBounds(69, 21, 188, 27);
		currencyPanel.add(comboBox2);

		currencyinputLabel = new JTextField();
		currencyinputLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		currencyinputLabel.setColumns(10);
		currencyinputLabel.setBounds(38, 74, 256, 40);
		currencyPanel.add(currencyinputLabel);

		JLabel currencyResultLabel = new JLabel("");
		currencyResultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		currencyResultLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		currencyResultLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		currencyResultLabel.setBounds(87, 137, 159, 30);
		currencyPanel.add(currencyResultLabel);

		// done button
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// combox2 values US or Lebanese pounds
				int currency = comboBox2.getSelectedIndex();
				String input = currencyinputLabel.getText();
				double amount = Integer.parseInt(input);
				if (currency == 1) {
					// convert lebanese lira to dollars
					double lira = amount * 3.900;
					currencyResultLabel.setText(Double.toString(lira) + "L.L");
				} else if (currency == 2) {
					// convert dollars to lebanese lira
					double dollars = amount / 3900;
					currencyResultLabel.setText(String.format("$%.2f", dollars));
				}
			}
		});
		btnDone.setBounds(100, 197, 146, 29);
		currencyPanel.add(btnDone);

		JPanel resultsPanel = new JPanel();
		resultsPanel.setBackground(new Color(255, 255, 255));
		resultsPanel.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		resultsPanel.setBounds(662, 321, 338, 190);
		contentPane.add(resultsPanel);
		resultsPanel.setLayout(null);

		JLabel taxLabel = new JLabel("");
		taxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		taxLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		taxLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		taxLabel.setBounds(172, 24, 159, 30);
		resultsPanel.add(taxLabel);

		JLabel subTotalLabel = new JLabel("");
		subTotalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		subTotalLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		subTotalLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		subTotalLabel.setBounds(172, 70, 159, 30);
		resultsPanel.add(subTotalLabel);

		JLabel totalLabel = new JLabel("");
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		totalLabel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		totalLabel.setBounds(172, 128, 159, 30);
		resultsPanel.add(totalLabel);

		JLabel TaxLabel = new JLabel("VAT");
		TaxLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		TaxLabel.setBounds(17, 24, 59, 30);
		resultsPanel.add(TaxLabel);

		JLabel SubTotalLabel = new JLabel("Sub Total");
		SubTotalLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		SubTotalLabel.setBounds(18, 77, 124, 23);
		resultsPanel.add(SubTotalLabel);

		JLabel TotalLabel = new JLabel("Total");
		TotalLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		TotalLabel.setBounds(17, 128, 125, 30);
		resultsPanel.add(TotalLabel);

		JLabel titleLabel = new JLabel("LAU Cafeteria");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 29));
		titleLabel.setBounds(517, 6, 238, 43);
		contentPane.add(titleLabel);

//		double total = new ArrayList<Integer>();
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// prices of each item

				int chknprice = 8000;
				int hotdogprice = 6000;
				int hamburgerprice = 7000;
				int alldrinksprice = 3500;

				// get quantity of each item ordered
				int chknsubQuantity = (int) spinner1.getValue();
				int hotdogQuantity = (int) spinner2.getValue();
				int hamburgerQuantity = (int) spinner3.getValue();
				int drinkQuantity = (int) spinner4.getValue();

				// add to arraylist
//				total.add(chknsubQuantity);
//				total.add(hotdogQuantity);
//				total.add(hamburgerQuantity);
//				total.add(drinkQuantity);

				// calculate sum

				mealtotal = chknsubQuantity * chknprice + hotdogQuantity * hotdogprice
						+ hamburgerQuantity * hamburgerprice;
				drinktotal = drinkQuantity * alldrinksprice;
				// display totals
				mealcostLabel.setText(Integer.toString(mealtotal) + " L.L");
				drinkcostLabel.setText(Integer.toString(drinktotal) + " L.L");
				if (checkbox.isSelected()) {
					deliveryfeeLabel.setText("2000 L.L");
				}

				// tax
				tax = 0.11;
				taxLabel.setText("11%");

				// subtotal
				subtotal = mealtotal + drinktotal;
				subTotalLabel.setText(Double.toString(subtotal) + " L.L");

				// total
				total = (subtotal * tax) + mealtotal + drinktotal;
				totalLabel.setText(Double.toString(total) + " L.L");

			}

		});
		btnTotal.setForeground(new Color(0, 0, 0));
		btnTotal.setFont(new Font("SansSerif", Font.PLAIN, 24));
		btnTotal.setBounds(57, 573, 179, 50);
		contentPane.add(btnTotal);

		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String mealtot = Integer.toString(mealtotal);
				String drinktot = Integer.toString(drinktotal);
				String tot = Double.toString(total);
				String vat = Double.toString(tax);
				String sub = Double.toString(subtotal);
				if (checkbox.isSelected()) {
					String toString = "Meal total: " + mealtot + " L.L\n\nDrinks total: " + drinktot
							+ " L.L\n\nDelivery: 2000 L.L\n\nVAT: " + vat + "%\n\nSubtotal: " + sub + " L.L\n\nTotal: "
							+ tot + " L.L";

					rtextArea.setText(toString);
					sendfile(toString);

				} else {
					String toString = "Meal total: " + mealtot + " L.L\n\nDrinks total: " + drinktot + " L.L\n\nVAT: "
							+ vat + "%\n\nSubtotal: " + sub + " L.L\n\nTotal: " + tot + " L.L";

					rtextArea.setText(toString);

					sendfile(toString);
				}

			}
		});
		btnReceipt.setForeground(new Color(0, 0, 0));
		btnReceipt.setFont(new Font("SansSerif", Font.PLAIN, 24));
		btnReceipt.setBounds(408, 573, 179, 50);
		contentPane.add(btnReceipt);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reset spinners
				spinner1.getModel().setValue(0);
				spinner2.getModel().setValue(0);
				spinner3.getModel().setValue(0);
				spinner4.getModel().setValue(0);
				// reset labels to null
				drinkcostLabel.setText(null);
				mealcostLabel.setText(null);
				deliveryfeeLabel.setText(null);
				currencyinputLabel.setText(null);
				currencyResultLabel.setText(null);
				taxLabel.setText(null);
				subTotalLabel.setText(null);
				totalLabel.setText(null);

				// reset combobox
				comboBox1.setSelectedIndex(0);
				comboBox2.setSelectedIndex(0);

				// uncheck checkbox
				checkbox.setSelected(false);
				/// reset reciept
				rtextArea.setText("");
			}
		});
		btnReset.setForeground(new Color(255, 0, 0));
		btnReset.setFont(new Font("SansSerif", Font.PLAIN, 24));
		btnReset.setBounds(1171, 573, 179, 50);
		contentPane.add(btnReset);

		JButton btnlogout = new JButton("Logout");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnlogout.setBounds(1233, 16, 117, 29);
		contentPane.add(btnlogout);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setFont(new Font("SansSerif", Font.PLAIN, 24));
		btnPrint.setBounds(741, 573, 179, 50);
		contentPane.add(btnPrint);
	}

	public static void sendfile(String rec) {
		try {
			File file = new File("reciept.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(rec);

			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
