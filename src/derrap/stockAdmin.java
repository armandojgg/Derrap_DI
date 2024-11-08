package derrap;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

public class stockAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnEmpleados, btnConsProvee,
			btnConsultarPedidos, btnCrearProvee, btnCrearPedidos, btnModificarOEliminarProvee,
			btnModificarOEliminarPedidos, btnConsultarStock;
	private JLabel lblAdmin, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap;
	private JTextField textFieldBuscador;
	private JLabel lblSegundoIcono, lblPreciosSer, lblProveedores, lblPedidos;
	private JTable tabla;
	private JScrollPane scrollPane;
	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;

	/**
	 * Create the frame.
	 */
	public stockAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menú - ADMIN"); // Título de la ventana en cuestión
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoderrap.jpg")).getImage());
		setBounds(100, 100, 1020, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		conectarBaseDatos();

		// J P A N E L S
		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBounds(0, 74, 181, 271);
		contentPane.add(panelOpcionesMenu);
		panelOpcionesMenu.setBackground(new Color(128, 0, 0)); // Color del fondo del botón azul oscuro.
		panelOpcionesMenu.setLayout(null);
		
		panelOpcionesMenu_1 = new JPanel();
		panelOpcionesMenu_1.setLayout(null);
		panelOpcionesMenu_1.setBackground(new Color(255, 0, 0));
		panelOpcionesMenu_1.setBounds(0, 0, 1004, 74);
		contentPane.add(panelOpcionesMenu_1);

		panelOpcionesMenu_2 = new JPanel();
		panelOpcionesMenu_2.setLayout(null);
		panelOpcionesMenu_2.setBackground(Color.RED);
		panelOpcionesMenu_2.setBounds(0, 343, 181, 341);
		contentPane.add(panelOpcionesMenu_2);
		
		// B O T O N E S
		
		// B O T O N  H O M E
		btnHome = new JButton("Home");
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(128, 0, 0));
		btnHome.setBounds(0, 0, 181, 39);
		panelOpcionesMenu.add(btnHome);
		
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeAdmin frame = new homeAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		// B O T O N  C L I E N T E S
		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(128, 0, 0));
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setBounds(0, 39, 181, 39);
		panelOpcionesMenu.add(btnClientes);

		btnClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientesAdmin frame = new clientesAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		// B O T O N  V E H I C U L O S
		btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setForeground(Color.WHITE);
		btnVehiculos.setBackground(new Color(128, 0, 0));
		btnVehiculos.setBounds(0, 77, 181, 39);
		panelOpcionesMenu.add(btnVehiculos);

		btnVehiculos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vehiculosAdmin frame = new vehiculosAdmin();
				frame.setVisible(true);
				dispose();

			}
		});

		// B O T O N  O R D E N E S
		btnOrdenes = new JButton("Ordenes");
		btnOrdenes.setForeground(Color.WHITE);
		btnOrdenes.setBackground(new Color(128, 0, 0));
		btnOrdenes.setBounds(0, 115, 181, 39);
		panelOpcionesMenu.add(btnOrdenes);

		btnOrdenes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenesAdmin frame = new ordenesAdmin();
				frame.setVisible(true);
				dispose();
			}

		});

		// B O T O N  P R E C I O
		btnPrecio = new JButton("Precio");
		btnPrecio.setForeground(Color.WHITE);
		btnPrecio.setBackground(new Color(128, 0, 0));
		btnPrecio.setBounds(0, 153, 181, 39);
		panelOpcionesMenu.add(btnPrecio);

		btnPrecio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				precioAdmin frame = new precioAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		// B O T O N  S T O C K
		btnStock = new JButton("Stock");
		btnStock.setForeground(Color.WHITE);
		btnStock.setBackground(new Color(128, 0, 0));
		btnStock.setBounds(0, 192, 181, 39);
		panelOpcionesMenu.add(btnStock);

		btnStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		// B O T O N  E M P L E A D O S
		btnEmpleados = new JButton("Empleados");
		btnEmpleados.setForeground(Color.WHITE);
		btnEmpleados.setBackground(new Color(128, 0, 0));
		btnEmpleados.setBounds(0, 231, 181, 39);
		panelOpcionesMenu.add(btnEmpleados);
		btnEmpleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empleadosAdmin frame = new empleadosAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		btnConsProvee = new JButton("Consultar proveedores");
		btnConsProvee.setBackground(new Color(0, 255, 0));
		btnConsProvee.setForeground(new Color(255, 255, 255));
		btnConsProvee.setBounds(250, 297, 213, 45);
		contentPane.add(btnConsProvee);

		btnConsProvee.setVisible(true);

		btnConsultarPedidos = new JButton("Consultar pedidos");
		btnConsultarPedidos.setBackground(new Color(0, 255, 0));
		btnConsultarPedidos.setForeground(new Color(255, 255, 255));
		btnConsultarPedidos.setBounds(609, 297, 213, 45);
		contentPane.add(btnConsultarPedidos);

		btnConsultarPedidos.setVisible(true);

		btnCrearProvee = new JButton("Crear");
		btnCrearProvee.setBackground(new Color(0, 255, 0));
		btnCrearProvee.setForeground(new Color(255, 255, 255));
		btnCrearProvee.setBounds(250, 359, 213, 45);
		contentPane.add(btnCrearProvee);

		btnCrearProvee.setVisible(true);

		btnCrearPedidos = new JButton("Crear");
		btnCrearPedidos.setBackground(new Color(0, 255, 0));
		btnCrearPedidos.setForeground(new Color(255, 255, 255));
		btnCrearPedidos.setBounds(609, 359, 213, 45);
		contentPane.add(btnCrearPedidos);
		btnCrearPedidos.setVisible(true);

		btnModificarOEliminarProvee = new JButton("Modificar o eliminar");
		btnModificarOEliminarProvee.setBackground(new Color(0, 255, 0));
		btnModificarOEliminarProvee.setForeground(new Color(255, 255, 255));
		btnModificarOEliminarProvee.setBounds(250, 418, 213, 45);
		contentPane.add(btnModificarOEliminarProvee);

		btnModificarOEliminarProvee.setVisible(true);

		btnModificarOEliminarPedidos = new JButton("Modificar o eliminar");
		btnModificarOEliminarPedidos.setBackground(new Color(0, 255, 0));
		btnModificarOEliminarPedidos.setForeground(new Color(255, 255, 255));
		btnModificarOEliminarPedidos.setBounds(609, 418, 213, 45);
		contentPane.add(btnModificarOEliminarPedidos);

		btnModificarOEliminarPedidos.setVisible(true);

		btnConsultarStock = new JButton("Consultar STOCK");
		btnConsultarStock.setBackground(new Color(0, 0, 160));
		btnConsultarStock.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnConsultarStock.setForeground(new Color(255, 255, 255));
		btnConsultarStock.setBounds(448, 488, 183, 74);
		contentPane.add(btnConsultarStock);
		
		btnConsultarStock.setVisible(true);

		btnConsultarStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// -----------------------------------------
				// B O T O N E S
				// ----------------------------------------
				btnConsProvee.setVisible(false);
				btnConsultarPedidos.setVisible(false);
				btnCrearProvee.setVisible(false);
				btnCrearPedidos.setVisible(false);
				btnModificarOEliminarProvee.setVisible(false);
				btnModificarOEliminarPedidos.setVisible(false);
				btnConsultarStock.setVisible(false);

				// L A B E L S
				// ----------------------------------------------

				lblSegundoIcono.setVisible(true);
				lblPreciosSer.setVisible(true);
				lblProveedores.setVisible(false);
				lblPedidos.setVisible(false);

				// T E X T F I E L D
				// ---------------------------------------------------
				textFieldBuscador.setVisible(true);
				mostrartablastock();
			}
		});

		// J L A B E L S

		lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(22, 25, 79, 26);
		panelOpcionesMenu_1.add(lblAdmin);

		lblLogOut = new JLabel("Log Out");
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(new Color(255, 255, 255));
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogOut.setBounds(848, 28, 68, 25);
		panelOpcionesMenu_1.add(lblLogOut);

		lblPoweredDerrap = new JLabel("Powered by DERRAP");
		lblPoweredDerrap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoweredDerrap.setForeground(new Color(255, 255, 255));
		lblPoweredDerrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoweredDerrap.setBounds(22, 291, 149, 39);
		panelOpcionesMenu_2.add(lblPoweredDerrap);

		lblPreciosSer = new JLabel("Precios de los servicios:");
		lblPreciosSer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPreciosSer.setBounds(434, 136, 226, 14);
		contentPane.add(lblPreciosSer);

		lblPreciosSer.setVisible(true);

		lblProveedores = new JLabel("Proveedores");
		lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProveedores.setBounds(279, 234, 148, 52);
		contentPane.add(lblProveedores);

		lblProveedores.setVisible(true);

		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPedidos.setBounds(635, 234, 148, 52);
		contentPane.add(lblPedidos);

		lblPedidos.setVisible(true);

		// J T E X T F I E L D
		textFieldBuscador = new JTextField();
		textFieldBuscador.setBounds(672, 128, 213, 36);
		contentPane.add(textFieldBuscador);
		textFieldBuscador.setColumns(10);
		textFieldBuscador.setVisible(true);

//		// F O C U S  L I S T E N E R  B U S C A D O R
		textFieldBuscador.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (textFieldBuscador.getText().equals("🔍 Buscar")) {
					textFieldBuscador.setText("");
					textFieldBuscador.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (textFieldBuscador.getText().isEmpty()) {
					textFieldBuscador.setText("🔍 Buscar");
					textFieldBuscador.setForeground(Color.GRAY);
				}
			}
		});

		if (textFieldBuscador.getText().isEmpty()) {
			textFieldBuscador.setText("🔍 Buscar");
			textFieldBuscador.setForeground(Color.GRAY);
		}
		
		// Cambiar el estado del botón actual
		btnStock.setEnabled(false); // Deshabilitar
		btnStock.setBackground(Color.WHITE); // Cambiar fondo a blanco
		setLocationRelativeTo(null); // Se centra la ventana en la pantalla
		
		
		// I M A G E N E S
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/home_imagen.png")); // Revisa la ruta
		Image imagenoriginal = imagen.getImage();
		Image imagenreescalada = imagenoriginal.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenreescalada);
		lblIconoCasa = new JLabel(iconoRedimensionado);
		lblIconoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCasa.setBounds(119, 15, 62, 48);
		panelOpcionesMenu_1.add(lblIconoCasa);

		ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal2 = imagen2.getImage();
		Image imagenreescalada2 = imagenoriginal2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado2 = new ImageIcon(imagenreescalada2);
		lblIcono = new JLabel(iconoRedimensionado2);
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setBounds(750, 0, 102, 74);
		panelOpcionesMenu_1.add(lblIcono);
		
		ImageIcon imagen3 = new ImageIcon(this.getClass().getResource("/imagenes/logout_imagen.png")); // Revisa la ruta
		Image imagenoriginal3 = imagen3.getImage();
		Image imagenreescalada3 = imagenoriginal3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado3 = new ImageIcon(imagenreescalada3);
		lblImagenLogOut = new JLabel(iconoRedimensionado3);
		lblImagenLogOut.setBounds(926, 15, 50, 48);
		panelOpcionesMenu_1.add(lblImagenLogOut);

		lblImagenLogOut.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				eleccionlogin eleccionlogin = new eleccionlogin();
				eleccionlogin.setVisible(true);
				dispose(); // Cerrar el JFrame actual si es necesario
			}
		});
		
		ImageIcon imagen4 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal4 = imagen4.getImage();
		Image imagenreescalada4 = imagenoriginal4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado4 = new ImageIcon(imagenreescalada4);
		lblSegundoIcono = new JLabel(iconoRedimensionado4);
		lblSegundoIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoIcono.setBounds(200, 85, 145, 100);
		contentPane.add(lblSegundoIcono);
		lblSegundoIcono.setVisible(true);
		
		// F O C U S A B L E

		lblSegundoIcono.setFocusable(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				lblSegundoIcono.requestFocus();
			}
		});
	}
	
	private void mostrartablastock() {
		String[] nombreColumnas = { "ID Cliente", "Nombre Cliente", "Fecha de Registro", "Matrícula Asociada",
				"Estado de la Orden" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(nombreColumnas);
		tabla = new JTable(model);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(191, 196, 800, 402);
		contentPane.add(scrollPane);
		// Conexión a la base de datos y ejecución de la consulta
		try {
			stm = cn.createStatement();
			String selectStock = "SELECT c.dni AS 'ID Cliente', c.nombre AS 'Nombre Cliente', c.fecha_registro AS 'Fecha de Registro', "
					+ "v.matricula AS 'Matrícula Asociada', o.estado_orden AS 'Estado de la Orden'"
					+ " FROM derrapdb.cliente c" + " JOIN derrapdb.vehiculo v ON c.dni = v.cliente_dni"
					+ " JOIN derrapdb.orden_reparacion o ON v.matricula = o.vehiculo_matricula;";
			resultado = stm.executeQuery(selectStock);
			while (resultado.next()) {
				String idCliente = resultado.getString("ID Cliente");
				String nombreCliente = resultado.getString("Nombre Cliente");
				String fechaRegistro = resultado.getString("Fecha de Registro");
				String matriculaAsociada = resultado.getString("Matrícula Asociada");
				String estadoOrden = resultado.getString("Estado de la Orden");
				model.addRow(new Object[] { idCliente, nombreCliente, fechaRegistro, matriculaAsociada, estadoOrden });
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultado != null)
					resultado.close();
				if (stm != null)
					stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void conectarBaseDatos() {
		try {
			cn = conexion.conexion_correcta();
			stm = cn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
