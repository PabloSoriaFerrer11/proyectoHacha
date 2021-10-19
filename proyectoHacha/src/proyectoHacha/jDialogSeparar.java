package proyectoHacha;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JProgressBar;

public class jDialogSeparar extends JDialog {
	int cosas;

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRuta;
	private JTextField jTextFieldDirectorio;
	private JTextField jTextFieldFichero;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */

	public jDialogSeparar() {
		setBounds(100, 100, 554, 551);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Separar Archivos\r\n");
			lblNewLabel.setBounds(10, 11, 295, 30);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u00BFEn cuantas partes quieres romper el archivo?");
			lblNewLabel_1.setBounds(10, 52, 395, 42);
			contentPanel.add(lblNewLabel_1);
		}
		
		//-----------------------------------
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner.setBounds(444, 63, 63, 20);
			contentPanel.add(spinner);
		
		//--------------------------------------------
			
		Panel panel = new Panel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 262, 518, 215);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton jButtonSeleccionar = new JButton("Seleccionar...");
		jButtonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionFichero();
			}
		});
		jButtonSeleccionar.setBounds(135, 31, 260, 160);
		panel.add(jButtonSeleccionar);
		{
			JLabel jLabelRuta = new JLabel("Ruta Archivo Seleccionado");
			jLabelRuta.setBounds(10, 97, 186, 14);
			contentPanel.add(jLabelRuta);
		}
		
		//------------------------------------------
		
		textFieldRuta = new JTextField();
		textFieldRuta.setEditable(false);
		textFieldRuta.setBounds(206, 94, 301, 20);
		contentPanel.add(textFieldRuta);
		textFieldRuta.setColumns(10);
		
		JLabel jLabelDirectorio = new JLabel("Directorio Archivo");
		jLabelDirectorio.setBounds(10, 122, 136, 14);
		contentPanel.add(jLabelDirectorio);
		
		jTextFieldDirectorio = new JTextField();
		jTextFieldDirectorio.setEditable(false);
		jTextFieldDirectorio.setBounds(206, 119, 301, 20);
		contentPanel.add(jTextFieldDirectorio);
		jTextFieldDirectorio.setColumns(10);
		{
			JLabel jLabelFichero = new JLabel("Nombre Fichero");
			jLabelFichero.setBounds(10, 147, 120, 14);
			contentPanel.add(jLabelFichero);
		}
		{
			jTextFieldFichero = new JTextField();
			jTextFieldFichero.setEditable(false);
			jTextFieldFichero.setBounds(206, 144, 301, 20);
			contentPanel.add(jTextFieldFichero);
			jTextFieldFichero.setColumns(10);
		}
		
			JProgressBar progressBar = new JProgressBar();
			progressBar.setBounds(141, 211, 264, 20);
			progressBar.setValue(0);
			progressBar.setStringPainted(true);
			contentPanel.add(progressBar);

		

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cortar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						todoCodigo.cortarArchivo(textFieldRuta, spinner, jTextFieldDirectorio, progressBar );
						
						setVisible(false);
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



	protected void seleccionFichero() {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		
		//Guardamos la seleccion archivo
		int seleccion = fc.showOpenDialog(this);
		
		//Al darle a aceptar
		if(seleccion == JFileChooser.APPROVE_OPTION) {
			
			File fich = fc.getSelectedFile();
			
			String rutaFichero = fich.getAbsolutePath(); 
			
			textFieldRuta.setText(rutaFichero);
			
			todoCodigo.infoAdicional(rutaFichero, jTextFieldDirectorio, jTextFieldFichero);			
		}
		
	}
}
