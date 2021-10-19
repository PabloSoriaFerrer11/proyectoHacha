package proyectoHacha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Visual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual frame = new Visual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ---------------------------------------------------------------------------------------------------------------
	 */
	public Visual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROYECTO HACHA");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 28));
		lblNewLabel.setBounds(88, 11, 270, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pablo Soria Ferrer");
		lblNewLabel_1.setBounds(311, 376, 113, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2DAM");
		lblNewLabel_2.setBounds(311, 396, 113, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u00BFQue acci\u00F3n desea realizar?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.ITALIC, 18));
		lblNewLabel_3.setBounds(10, 122, 414, 59);
		contentPane.add(lblNewLabel_3);
		
		//----------------------------------------------------------
		
		JButton jButtonJuntar = new JButton("Juntar Archivos");
		jButtonJuntar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jDialogJuntar dialJuntar = new jDialogJuntar();
				dialJuntar.setVisible(true);
			}
		});
		jButtonJuntar.setBounds(27, 220, 135, 73);
		contentPane.add(jButtonJuntar);
		
		//------------------------------------------------------------
		
		JButton jButtonSeparar = new JButton("Separar Archivos");
		jButtonSeparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jDialogSeparar dialSeparar = new jDialogSeparar();
				dialSeparar.setVisible(true);				
			}
		});
		jButtonSeparar.setBounds(268, 220, 135, 73);
		contentPane.add(jButtonSeparar);
		
		//-------------------------------------------------------------
		
		JButton jButtonSalir = new JButton("Salir");
		jButtonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jButtonSalir.setBounds(172, 376, 86, 23);
		contentPane.add(jButtonSalir);
		
		JButton btnNewButton = new JButton("Hash");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jDialogHash jHash = new jDialogHash();
				jHash.setVisible(true);
			}
		});
		btnNewButton.setBounds(172, 270, 86, 23);
		contentPane.add(btnNewButton);
		
	}
}
