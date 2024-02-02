package ec.edu.puce.SistemaElectronico.formulario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormularioRegistrarEstudiante extends JInternalFrame implements ActionListener {
    private JTextField txtNombre;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private DefaultTableModel model;
    private JTable table;
    private int idCounter = 1; // Inicializar el contador en 1

    public FormularioRegistrarEstudiante() {
        getContentPane().setBackground(new Color(245, 243, 148));
        setTitle("CREAR ESTUDIANTE");
        setBounds(100, 100, 441, 308);
        getContentPane().setLayout(null);

        // Campo de texto para el nombre del estudiante
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        txtNombre.addActionListener(this);
        txtNombre.setBounds(139, 18, 231, 19);
        getContentPane().add(txtNombre);

        // Botones para Agregar y Cancelar
        btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnAgregar.setBackground(new Color(85, 219, 95));
        btnAgregar.addActionListener(this);
        btnAgregar.setBounds(30, 58, 144, 25);
        getContentPane().add(btnAgregar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnCancelar.setBackground(new Color(85, 219, 95));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(215, 58, 152, 25);
        getContentPane().add(btnCancelar);

        // Tabla para mostrar los estudiantes
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 94, 416, 163);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica al hacer clic en la tabla
            }
        });

        // Encabezados de la tabla
        model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nombre"});
        table.setModel(model);
        scrollPane.setViewportView(table);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(23, 21, 87, 14);
        getContentPane().add(lblNombre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            agregarFila();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }

    private void agregarFila() {
        // Obtener valores de los campos
        String nombre = txtNombre.getText();
        String formattedId = String.format("%03d", idCounter++); // Formatear el ID como "001", "002", etc.

        // Validar que el campo no esté vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' debe estar lleno", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lógica para agregar una fila a la tabla
        Object[] rowData = {formattedId, nombre};
        model.addRow(rowData);

        // Limpiar campo después de agregar la fila
        txtNombre.setText("");
    }
}

