package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import all.Player;
import enemies.Enemy;
import towers.Tower;

class PropertiesWindow extends JFrame implements ActionListener {

	private DescribeEnemy de;
	private DescribeTower dt;
	private JPanel container = new JPanel();
	private CustomButton button = new CustomButton("Upgrade", "button");

	public PropertiesWindow() {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(this);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}

	public void display(Tower t) {

		container.removeAll();

		dt = new DescribeTower(t);

		this.setTitle(t.getName() + " Properties");
		this.setSize(300, 200);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setIconImage(null);

		container.setLayout(new BorderLayout());
		container.add(dt, BorderLayout.CENTER);

		button.addActionListener(this);
		button.setPreferredSize(new Dimension(20, 20));

		container.add(button, BorderLayout.SOUTH);

		this.add(container);
		this.setResizable(false);
		this.setVisible(true);

	}

	public void display(Enemy e) {

		container.removeAll();

		de = new DescribeEnemy(e);

		this.setTitle(e.getName() + " Properties");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setIconImage(null);

		container.setLayout(new BorderLayout());
		container.add(de, BorderLayout.CENTER);

		this.add(container);
		this.setResizable(false);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

		if (Player.getCurrentMoney() >= dt.getTower().getUpgradeCost()) {

			dt.getTower().upgrade();
			dt.repaint();
			Player.setCurrentMoney(Player.getCurrentMoney() - (long)dt.getTower().getUpgradeCost());

		} else {

			button.setText("You don\'t have enough money !");
			button.repaint();

		}

	}

}