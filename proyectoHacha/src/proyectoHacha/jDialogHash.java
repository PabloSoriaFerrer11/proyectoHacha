package proyectoHacha;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class jDialogHash extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldHash1;
	private JTextField textFieldHash2;
	private JTextField textFieldResol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jDialogHash dialog = new jDialogHash();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jDialogHash() {
		setBounds(100, 100, 454, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Comparar Hashes");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 11, 414, 34);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("Primer Archivo");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccionFicheroHash(textFieldHash1);
				}
			});
			btnNewButton.setBounds(297, 115, 127, 34);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnSegundoArchivo = new JButton("Segundo Archivo");
			btnSegundoArchivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccionFicheroHash(textFieldHash2);
				}
			});
			btnSegundoArchivo.setBounds(297, 217, 127, 34);
			contentPanel.add(btnSegundoArchivo);
		}
		
		textFieldHash1 = new JTextField();
		textFieldHash1.setEditable(false);
		textFieldHash1.setBounds(10, 115, 277, 34);
		contentPanel.add(textFieldHash1);
		textFieldHash1.setColumns(10);
		
		textFieldHash2 = new JTextField();
		textFieldHash2.setEditable(false);
		textFieldHash2.setColumns(10);
		textFieldHash2.setBounds(10, 217, 277, 34);
		contentPanel.add(textFieldHash2);
		
		textFieldResol = new JTextField();
		textFieldResol.setEditable(false);
		textFieldResol.setBounds(169, 311, 86, 20);
		contentPanel.add(textFieldResol);
		textFieldResol.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Comparar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						todoCodigo.compararHash(textFieldHash1, textFieldHash2, textFieldResol );
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void seleccionFicheroHash(JTextField textField) {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		
		//Guardamos la seleccion archivo
		int seleccion = fc.showOpenDialog(this);
		
		//Al darle a aceptar
		if(seleccion == JFileChooser.APPROVE_OPTION) {
			
			File fich = fc.getSelectedFile();
			
			String rutaFichero = fich.getAbsolutePath(); 
			
			todoCodigo.sacarHash(rutaFichero, textField);
			
					
		}
		
	}
}
