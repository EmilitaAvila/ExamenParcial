package ec.edu.puce.SistemaElectronico.formulario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormularioCrearMesa extends JInternalFrame implements ActionListener {
    private JButton btnGuardar;
    private JButton btnCancelar;
    private DefaultTableModel model;
    private JTable table;
    private int numeroMesa = 1;  // Variable para asignar números de mesa
    private JComboBox<String> comboBox;
    private JTextField txtNombre;
    private JLabel lblNewLabel_1;

    public FormularioCrearMesa() {
        getContentPane().setBackground(new Color(245, 243, 148));
        setTitle("CREAR MESA");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        // Botones para Nuevo, Agregar Mesa y Cancelar
        btnGuardar = new JButton("Agregar");
        btnGuardar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnGuardar.setBackground(new Color(85, 219, 95));
        btnGuardar.addActionListener(this);
        btnGuardar.setBounds(31, 122, 237, 25);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnCancelar.setBackground(new Color(85, 219, 95));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(278, 122, 268, 25);
        getContentPane().add(btnCancelar);

        // Tabla para mostrar las mesas
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 158, 562, 180);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica al hacer clic en la tabla
            }
        });

        // Encabezados de la tabla
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Nombre de la Mesa", "Número de Mesa"});
        table.setModel(model);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Nombre de la mesa (Inicial de su nombre)");
        lblNewLabel.setBounds(10, 19, 300, 37);
        getContentPane().add(lblNewLabel);

        // ComboBox para seleccionar la letra
        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Selecciona......", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
        comboBox.setBounds(262, 26, 170, 22);
        getContentPane().add(comboBox);

        // Campo de texto para mostrar el nombre de la mesa
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        txtNombre.setBounds(234, 67, 120, 22);
        getContentPane().add(txtNombre);
        
        lblNewLabel_1 = new JLabel("Letra Seleccionada:");
        lblNewLabel_1.setBounds(91, 71, 126, 14);
        getContentPane().add(lblNewLabel_1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            agregarFila();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }

    private void agregarFila() {
        // Obtener la letra seleccionada
        String letraSeleccionada = (String) comboBox.getSelectedItem();

        // Verificar si se ha seleccionado una letra válida
        if (letraSeleccionada.equals("Selecciona......")) {
            JOptionPane.showMessageDialog(this, "Selecciona una letra válida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lógica para agregar una fila a la tabla
        String nombreMesa = letraSeleccionada;
        model.addRow(new Object[]{nombreMesa, numeroMesa});
        txtNombre.setText(nombreMesa);
        numeroMesa++;  // Incrementar el número de mesa para la siguiente
    }
}
