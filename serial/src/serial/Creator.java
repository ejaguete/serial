package serial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;

public class Creator {

	private JFrame frmObjectCreator;
	private JTextField job_levelText;
	private ArrayList<Object> objects = new ArrayList<Object>();
	private JTextField party_tankText;
	private JTextField party_healText;
	private JTextField party_d1Text;
	private JTextField party_d2Text;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creator window = new Creator();
					window.frmObjectCreator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Creator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmObjectCreator = new JFrame();
		frmObjectCreator.setTitle("Object Creator");
		frmObjectCreator.setBounds(100, 100, 450, 405);
		frmObjectCreator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmObjectCreator.getContentPane().setLayout(null);
		
		JLabel classLabel = new JLabel("Select a class to create:");
		classLabel.setBounds(10, 11, 262, 14);
		classLabel.setLabelFor(frmObjectCreator);
		classLabel.setHorizontalAlignment(SwingConstants.LEFT);
		frmObjectCreator.getContentPane().add(classLabel);
		
		JLabel fieldLabel = new JLabel("Fill in the appropriate fields:");
		fieldLabel.setBounds(10, 69, 262, 14);
		frmObjectCreator.getContentPane().add(fieldLabel);
		fieldLabel.setVisible(false);

		
		JLabel consoleLabel = new JLabel("Console");
		consoleLabel.setBounds(10, 216, 46, 14);
		frmObjectCreator.getContentPane().add(consoleLabel);
		
		JLabel consoleText = new JLabel("");
		consoleText.setVerticalAlignment(SwingConstants.TOP);
		consoleText.setHorizontalAlignment(SwingConstants.LEFT);
		consoleText.setBounds(10, 235, 414, 86);
		frmObjectCreator.getContentPane().add(consoleText);
		
		
		JPanel cardsPanel = new JPanel();
		cardsPanel.setBounds(10, 86, 414, 124);
		frmObjectCreator.getContentPane().add(cardsPanel);
		cardsPanel.setLayout(new CardLayout(0, 0));

		JPanel panel_empty = new JPanel();
		cardsPanel.add(panel_empty, "empty");


		JPanel panel_job = new JPanel();
		cardsPanel.add(panel_job, "Job");
		panel_job.setVisible(false);
		panel_job.setLayout(null);

		JLabel job_nameLabel = new JLabel("Name :");
		job_nameLabel.setBounds(0, 38, 90, 14);
		panel_job.add(job_nameLabel);
		job_nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		JComboBox job_nameBox = new JComboBox();
		job_nameBox.setBounds(98, 35, 150, 20);
		panel_job.add(job_nameBox);
		job_nameBox.setModel(new DefaultComboBoxModel(new String[] {"", "Arcanist", "Archer", "Conjurer", "Gladiator", "Marauder", "Pugilist", "Rogue", "Thaumaturge"}));

		JLabel job_levelLabel = new JLabel("Level :");
		job_levelLabel.setBounds(0, 63, 90, 14);
		panel_job.add(job_levelLabel);
		job_levelLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		job_levelText = new JTextField();
		job_levelText.setBounds(98, 60, 150, 20);
		panel_job.add(job_levelText);
		job_levelText.setColumns(10);
		
		JLabel job_note = new JLabel("*integer between 1 to 100");
		job_note.setBounds(258, 63, 146, 14);
		panel_job.add(job_note);
		
		JPanel panel_party = new JPanel();
		cardsPanel.add(panel_party, "Party");
		panel_party.setLayout(null);
		
		JLabel party_tankLabel = new JLabel("Tank Name :");
		party_tankLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		party_tankLabel.setBounds(0, 11, 90, 14);
		panel_party.add(party_tankLabel);
		
		party_tankText = new JTextField();
		party_tankText.setBounds(101, 8, 150, 20);
		panel_party.add(party_tankText);
		party_tankText.setColumns(10);
		
		JLabel party_healLabel = new JLabel("Healer Name :");
		party_healLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		party_healLabel.setBounds(0, 36, 90, 14);
		panel_party.add(party_healLabel);
		
		party_healText = new JTextField();
		party_healText.setColumns(10);
		party_healText.setBounds(101, 33, 150, 20);
		panel_party.add(party_healText);
		
		JLabel party_d1Label = new JLabel("DPS Name (1) :");
		party_d1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		party_d1Label.setBounds(0, 61, 90, 14);
		panel_party.add(party_d1Label);
		
		party_d1Text = new JTextField();
		party_d1Text.setColumns(10);
		party_d1Text.setBounds(101, 58, 150, 20);
		panel_party.add(party_d1Text);
		
		JLabel part_d2Label = new JLabel("DPS Name (2) :");
		part_d2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		part_d2Label.setBounds(0, 86, 90, 14);
		panel_party.add(part_d2Label);
		
		party_d2Text = new JTextField();
		party_d2Text.setColumns(10);
		party_d2Text.setBounds(101, 83, 150, 20);
		panel_party.add(party_d2Text);
		
		JLabel party_note = new JLabel("<html>Note:<br>Fields may be left blank if you do not wish to specify a player for the role.");
		party_note.setBounds(272, 11, 132, 89);
		panel_party.add(party_note);
		
		JPanel panel_ilevel = new JPanel();
		cardsPanel.add(panel_ilevel, "ilvl");
		panel_ilevel.setLayout(null);
		
		JLabel ilvl_label = new JLabel("List of iLevels :");
		ilvl_label.setHorizontalAlignment(SwingConstants.RIGHT);
		ilvl_label.setBounds(0, 47, 100, 14);
		panel_ilevel.add(ilvl_label);
		
		textField = new JTextField();
		textField.setBounds(102, 44, 200, 20);
		panel_ilevel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("*iLevel list may only contain up to 8 items");
		lblNewLabel.setBounds(102, 71, 216, 14);
		panel_ilevel.add(lblNewLabel);
		
		JComboBox selectClassBox = new JComboBox();
		selectClassBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selstr = selectClassBox.getSelectedItem().toString();
				if(!selstr.equals(""))
					fieldLabel.setVisible(true);
				else
					fieldLabel.setVisible(false);
				
				CardLayout c = (CardLayout) (cardsPanel.getLayout());
				if(selstr.contains("Job"))
					c.show(cardsPanel, "Job");
				
				else if(selstr.contains("Party")) 
					c.show(cardsPanel, "Party");
				
				else if(selstr.contains("ILevel"))
					c.show(cardsPanel, "ilvl");
				
				else 
					c.show(cardsPanel, "empty");
			}
		});
		selectClassBox.setBounds(10, 30, 414, 28);
		selectClassBox.setMaximumRowCount(5);
		selectClassBox.setModel(new DefaultComboBoxModel(new String[] {"", "Job : contains only primitives", "Party : contains object references", "Ilevels : contains an array of primitives", "Alliance : contains an array of object references", "Player : contains a collection of object references"}));
		selectClassBox.setToolTipText("");
		frmObjectCreator.getContentPane().add(selectClassBox);
		
		JButton buttonEnter = new JButton("Confirm");
		buttonEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg;
				String selstr = selectClassBox.getSelectedItem().toString();
				
				if(selstr.contains("Job")) {
					String name = job_nameBox.getSelectedItem().toString();
					String levelstr = job_levelText.getText();
					
					int level = 0;
					if(levelstr.matches("\\d+")) {
						level = Integer.parseInt(levelstr);
					}
					
					boolean levelOK = (level>=1) && (level<=100);
					if(!name.equals("") && levelOK) {
						objects.add(new Job(name,level));
						msg = "<html>OK : created a Job object!<br>";
						// reset fields
						job_nameBox.setSelectedIndex(0);
						job_levelText.setText("");
					} else {
						msg = "<html>Object creation unsuccessful, please resolve the following:";
						if(name.equals(""))
							msg += "<br>ERROR : name field is empty";
						if(!levelOK)
							msg += "<br>ERROR : level field must be an integer between 1 and 100";
					}
				} else if(selstr.contains("Party")) {
					String t = party_tankText.getText();
					String h = party_healText.getText();
					String d1 = party_d1Text.getText();
					String d2 = party_d2Text.getText();
					
					Player tank = null;
					Player heal = null;
					Player dps1 = null;
					Player dps2 = null;
					
					if(!t.equals("")) 
						tank = new Player(t);
					if(!h.equals(""))
						heal = new Player(h);
					if(!d1.equals(""))
						dps1 = new Player(d1);
					if(!d2.equals(""))
						dps2 = new Player(d2);
					
					objects.add(new Party(tank,heal,dps1,dps2));
					msg = "<html>OK : created a Party object!";
					
					if((tank==null) || (heal==null) || dps1==null || dps2==null)
						msg += "<br>CAUTION : one or more party member slots are empty";
					
				} else // user clicked confirm when no class was chosen
					msg = "<html>ERROR : you have not chosen a class to create";
				
				msg += "<br>Number of objects created: " + objects.size();
				consoleText.setText(msg);
			}
		});
		
		buttonEnter.setBounds(162, 332, 89, 23);
		frmObjectCreator.getContentPane().add(buttonEnter);
		


	}
}
