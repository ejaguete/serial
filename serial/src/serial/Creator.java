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

public class Creator {

	private JFrame frmObjectCreator;
	private JTextField job_levelText;
	private ArrayList<Object> fieldValues = new ArrayList<Object>();

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
		frmObjectCreator.setBounds(100, 100, 450, 300);
		frmObjectCreator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmObjectCreator.getContentPane().setLayout(null);
		
		JLabel classLabel = new JLabel("Select a class to create:");
		classLabel.setBounds(10, 11, 262, 14);
		classLabel.setLabelFor(frmObjectCreator);
		classLabel.setHorizontalAlignment(SwingConstants.LEFT);
		frmObjectCreator.getContentPane().add(classLabel);

		// JOB PANEL

		JPanel panel_job = new JPanel();
		panel_job.setBounds(10, 94, 414, 112);
		frmObjectCreator.getContentPane().add(panel_job);
		panel_job.setLayout(null);
		panel_job.setVisible(false);

		JLabel job_nameLabel = new JLabel("Name :");
		job_nameLabel.setBounds(0, 14, 61, 14);
		panel_job.add(job_nameLabel);
		job_nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		JComboBox job_nameBox = new JComboBox();
		job_nameBox.setBounds(66, 11, 131, 20);
		panel_job.add(job_nameBox);
		job_nameBox.setModel(new DefaultComboBoxModel(new String[] {"", "Arcanist", "Archer", "Conjurer", "Gladiator", "Marauder", "Pugilist", "Rogue", "Thaumaturge"}));

		JLabel job_levelLabel = new JLabel("Level :");
		job_levelLabel.setBounds(0, 39, 61, 14);
		panel_job.add(job_levelLabel);
		job_levelLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		job_levelText = new JTextField();
		job_levelText.setBounds(66, 36, 131, 20);
		panel_job.add(job_levelText);
		job_levelText.setColumns(10);
		
		// END : JOB PANEL
		
		JLabel fieldLabel = new JLabel("Fill in the appropriate fields:");
		fieldLabel.setBounds(10, 69, 262, 14);
		frmObjectCreator.getContentPane().add(fieldLabel);
		fieldLabel.setVisible(false);

		JComboBox selectClassBox = new JComboBox();
		selectClassBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selstr = selectClassBox.getSelectedItem().toString();
				if(!selstr.equals(""))
					fieldLabel.setVisible(true);
				else
					fieldLabel.setVisible(false);
				
				if(selstr.contains("Job")){
					panel_job.setVisible(true);
				} else {
					panel_job.setVisible(false);
				}
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
				String job = job_nameBox.getSelectedItem().toString();
				int level = Integer.parseInt(job_levelText.getText());
		
			}
		});
		buttonEnter.setBounds(165, 217, 89, 23);
		frmObjectCreator.getContentPane().add(buttonEnter);
	}
}
