package proyectoHacha;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class jDialogJuntar extends JDialog {
	
	private Visual principal;
		
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRuta;
	private JTextField textFieldArchivo;
	private JTextField textFieldPartes;
	private JTextField textFieldLongitud;
	private JTextField textFieldNombre;
	private JTextField textFieldRutaPartes;
	private JTextField textFieldExtension;

	public jDialogJuntar() {
		setBounds(100, 100, 554, 551);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Juntar Archivos");
		lblNewLabel.setBounds(10, 11, 205, 36);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		contentPanel.add(lblNewLabel);
		
		//----------------------------------------------
		
		JButton jButtonElegir = new JButton("Elegir XML...");
		jButtonElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionArchivo();
				ManejoXML.leerXML(textFieldRuta.getText(), textFieldPartes,textFieldLongitud,textFieldNombre, textFieldRutaPartes, textFieldExtension);
			}
		});
		jButtonElegir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jButtonElegir.setBounds(211, 120, 112, 45);
		contentPanel.add(jButtonElegir);
		
		//--------------------------------------------------
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona un XML con la informacion");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 58, 508, 36);
		contentPanel.add(lblNewLabel_1);
		
		textFieldRuta = new JTextField();
		textFieldRuta.setEditable(false);
		textFieldRuta.setBounds(211, 211, 317, 20);
		contentPanel.add(textFieldRuta);
		textFieldRuta.setColumns(10);
		
		textFieldArchivo = new JTextField();
		textFieldArchivo.setEditable(false);
		textFieldArchivo.setBounds(211, 263, 317, 20);
		contentPanel.add(textFieldArchivo);
		textFieldArchivo.setColumns(10);
		
		JLabel jLabelRuta = new JLabel("Ruta Archivo XML: ");
		jLabelRuta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabelRuta.setBounds(51, 214, 150, 14);
		contentPanel.add(jLabelRuta);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Archivo XML: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(51, 266, 150, 14);
		contentPanel.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 306, 518, 162);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textFieldPartes = new JTextField();
		textFieldPartes.setEditable(false);
		textFieldPartes.setBounds(24, 46, 86, 20);
		panel.add(textFieldPartes);
		textFieldPartes.setColumns(10);
		
		textFieldLongitud = new JTextField();
		textFieldLongitud.setEditable(false);
		textFieldLongitud.setBounds(143, 46, 86, 20);
		panel.add(textFieldLongitud);
		textFieldLongitud.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Partes:");
		lblNewLabel_3.setBounds(24, 21, 86, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Longitud:");
		lblNewLabel_4.setBounds(143, 21, 86, 14);
		panel.add(lblNewLabel_4);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(280, 46, 86, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre: ");
		lblNewLabel_5.setBounds(280, 21, 86, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ruta de las partes: ");
		lblNewLabel_3_1.setBounds(24, 90, 440, 14);
		panel.add(lblNewLabel_3_1);
		
		//------------------------------------------------
		
		textFieldRutaPartes = new JTextField();
		textFieldRutaPartes.setEditable(false);
		textFieldRutaPartes.setColumns(10);
		textFieldRutaPartes.setBounds(24, 115, 456, 20);
		panel.add(textFieldRutaPartes);
		
		textFieldExtension = new JTextField();
		textFieldExtension.setEditable(false);
		textFieldExtension.setColumns(10);
		textFieldExtension.setBounds(394, 46, 86, 20);
		panel.add(textFieldExtension);
		
		JLabel lblNewLabel_5_1 = new JLabel("Extension:");
		lblNewLabel_5_1.setBounds(394, 21, 86, 14);
		panel.add(lblNewLabel_5_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton jButtonJuntar = new JButton("Juntar");
				jButtonJuntar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						todoCodigo.comprobarFichero(textFieldPartes.getText(), textFieldLongitud.getText(), textFieldNombre.getText(), textFieldRutaPartes.getText(), textFieldExtension.getText());
						setVisible(false);
					}
				});
				jButtonJuntar.setActionCommand("OK");
				buttonPane.add(jButtonJuntar);
				getRootPane().setDefaultButton(jButtonJuntar);
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
		//------------------------------------------------------
	}
	
	protected void seleccionArchivo() {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		
		//Guardamos la seleccion archivo
		int seleccion = fc.showOpenDialog(this);
		
		//Al darle a aceptar
		if(seleccion == JFileChooser.APPROVE_OPTION) {
			
			File fich = fc.getSelectedFile();
			
			String rutaFichero = fich.getAbsolutePath(); 
			
			textFieldRuta.setText(rutaFichero);
			textFieldArchivo.setText(fich.getName());
			
		}
		
	}
}
