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
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;

public class Creator {

	JFrame frmObjectCreator;
	private JTextField job_levelText;
	private JTextField party_tankText;
	private JTextField party_healText;
	private JTextField party_d1Text;
	private JTextField party_d2Text;
	private JTextField ilvl_text;
	private JTextField all_partyText1;
	private JTextField all_partyText2;
	private JTextField all_partyText3;

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
		consoleLabel.setBounds(10, 244, 46, 14);
		frmObjectCreator.getContentPane().add(consoleLabel);
		
		JLabel consoleText = new JLabel("");
		consoleText.setVerticalAlignment(SwingConstants.TOP);
		consoleText.setHorizontalAlignment(SwingConstants.LEFT);
		consoleText.setBounds(10, 259, 414, 62);
		frmObjectCreator.getContentPane().add(consoleText);
		
		
		JPanel cardsPanel = new JPanel();
		cardsPanel.setBounds(10, 86, 414, 147);
		frmObjectCreator.getContentPane().add(cardsPanel);
		cardsPanel.setLayout(new CardLayout(0, 0));

		JPanel panel_empty = new JPanel();
		cardsPanel.add(panel_empty, "empty");
		
		JPanel panel_alliance = new JPanel();
		cardsPanel.add(panel_alliance, "Alliance");
		panel_alliance.setLayout(null);
		
		JLabel all_partyLabel1 = new JLabel("Party A :");
		all_partyLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		all_partyLabel1.setBounds(0, 11, 100, 14);
		panel_alliance.add(all_partyLabel1);
		
		all_partyText1 = new JTextField();
		all_partyText1.setBounds(110, 8, 201, 20);
		panel_alliance.add(all_partyText1);
		all_partyText1.setColumns(10);
		
		JLabel all_partyLabel2 = new JLabel("Party B :");
		all_partyLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		all_partyLabel2.setBounds(0, 35, 100, 14);
		panel_alliance.add(all_partyLabel2);
		
		all_partyText2 = new JTextField();
		all_partyText2.setColumns(10);
		all_partyText2.setBounds(110, 32, 201, 20);
		panel_alliance.add(all_partyText2);
		
		JLabel all_partyLabel3 = new JLabel("Party C :");
		all_partyLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		all_partyLabel3.setBounds(0, 60, 100, 14);
		panel_alliance.add(all_partyLabel3);
		
		all_partyText3 = new JTextField();
		all_partyText3.setColumns(10);
		all_partyText3.setBounds(110, 57, 201, 20);
		panel_alliance.add(all_partyText3);
		
		JLabel all_note = new JLabel("<html>Each party can have max. 4 player names,<br>\r\neach name is separated by a single space");
		all_note.setBounds(73, 59, 331, 88);
		panel_alliance.add(all_note);


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
		ilvl_label.setBounds(0, 11, 100, 14);
		panel_ilevel.add(ilvl_label);
		
		ilvl_text = new JTextField();
		ilvl_text.setBounds(104, 8, 200, 20);
		panel_ilevel.add(ilvl_text);
		ilvl_text.setColumns(10);
		
		JLabel ilvl_note = new JLabel("<html>Note:<br>\r\niLevel list may only contain up to 8 items, separated by a single space.<br>\r\nOrder goes [tank] [healer] [dps1] [dps2]<br>\r\nIf you wish to leave a role blank write \"null\"");
		ilvl_note.setBounds(29, 23, 377, 90);
		panel_ilevel.add(ilvl_note);
		
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
				
				else if(selstr.contains("Ilevels")) {
					c.show(cardsPanel, "ilvl");
				}
				else if(selstr.contains("Alliance"))
					c.show(cardsPanel, "Alliance");
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
					
					msg = setJobFields(name,levelstr);
					
					// reset fields
					job_nameBox.setSelectedIndex(0);
					job_levelText.setText("");	
					
				} else if(selstr.contains("Party")) {
					String t = party_tankText.getText();
					String h = party_healText.getText();
					String d1 = party_d1Text.getText();
					String d2 = party_d2Text.getText();
					
					//reset fields
					msg = setPartyFields(t,h,d1,d2);
					party_tankText.setText("");
					party_healText.setText("");
					party_d1Text.setText("");
					party_d2Text.setText("");
					
				} else if(selstr.contains("Ilevel")) {
					String list = ilvl_text.getText();
					msg = setIlvlFields(list);
					
					//reset field
					ilvl_text.setText("");
					
				} else if(selstr.contains("Alliance")) {
					String p1 = all_partyText1.getText();
					String p2 = all_partyText2.getText();
					String p3 = all_partyText3.getText();
					msg = setAllianceFields(new String[] {p1,p2,p3});
					
					//reset fields
					all_partyText1.setText("");
					all_partyText2.setText("");
					all_partyText3.setText("");
					
				} else // user clicked confirm when no class was chosen
					msg = "<html>ERROR : you have not chosen a class to create";
				
				System.out.println(Sender.objects.size());
				msg += "<br># objects created: " + Sender.objects.size();
				consoleText.setText(msg);
			}
		});
		
		buttonEnter.setBounds(162, 332, 89, 23);
		frmObjectCreator.getContentPane().add(buttonEnter);
	}
	
	private String setJobFields(String name, String levelstr) {
		String msg = "<html>Object creation unsuccessful, please resolve the following:";;
		
		int level = 0;
		if(levelstr.matches("\\d+")) {
			level = Integer.parseInt(levelstr);
		}
		
		boolean levelOK = (level>=1) && (level<=100);
		if(!name.equals("") && levelOK) {
			Sender.objects.add(new Job(name,level));
			msg = "<html>OK : created a Job object!";
		} else {
			
			if(name.equals(""))
				msg += "<br>ERROR : name field is empty";
			if(!levelOK)
				msg += "<br>ERROR : level field must be an integer between 1 and 100";
		}
		return msg;
	}
	
	private String setPartyFields(String t, String h, String d1, String d2) {
		String msg;
		
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
		
		Sender.objects.add(new Party(tank,heal,dps1,dps2));
		msg = "<html>OK : created a Party object!";
		
		if((tank==null) || (heal==null) || dps1==null || dps2==null)
			msg += "<br>CAUTION : one or more party member slots are empty";
		
		return msg;
	}
	
	private String setIlvlFields(String list) {
		String msg = "ERROR : something is wrong with your list";
		try {
			String[] split = list.split("\\s+");
			int[] ilvls = new int[split.length];
			for (int i=0;i<ilvls.length;i++) {
				ilvls[i] = Integer.parseInt(split[i]);
			}
			Sender.objects.add(new Ilevels(ilvls));
			msg = "<html>OK : created an ILevel object!";
		} catch(PatternSyntaxException e) {}
		return msg;
	}
	
	private String setAllianceFields(String[] parties) {
		String msg = "<html>ERROR : something is wrong with one or more lists";
		Player tank = null;
		Player heal = null;
		Player dps1 = null;
		Player dps2 = null;
		Party[] ps = new Party[3];
		
		try {
			for(int i=0;i<3;i++) {
				String[] split = parties[i].split("\\s+");
				if(split.length==4) {
					if(split[0]!="null")
						tank = new Player(split[0]);
					if(split[1]!="null")
						heal = new Player(split[1]);
					if(split[2]!="null")
						dps1 = new Player(split[2]);
					if(split[3]!="null")
						dps2 = new Player(split[3]);
					
					ps[i] = new Party(tank,heal,dps1,dps2);
				} else {
					break;
				}
			}
			if(ps[0]!=null && ps[1]!=null && ps[2]!=null) {
				Sender.objects.add(new Alliance(ps[0],ps[1],ps[2]));
				msg = "<html>OK : created an ILevel object!";
			}
		} catch(PatternSyntaxException e) {}
		return msg;
	}
}
