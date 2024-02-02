package ec.edu.puce.SistemaElectronico.formulario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FormularioRegistrarCandidato extends JInternalFrame implements ActionListener {
    private JTextField txtNombre;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private DefaultTableModel model;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private int idCounter = 300; // Inicializar el contador en 300
    private List<Object[]> candidatos; // Lista para almacenar los candidatos

    public FormularioRegistrarCandidato() {
        getContentPane().setBackground(new Color(245, 243, 148));
        setTitle("CREAR CANDIDATO");
        setBounds(100, 100, 443, 385);
        getContentPane().setLayout(null);

        // Inicializar la lista de candidatos
        candidatos = new ArrayList<>();

        // Campo de texto para el ID del candidato
        textField = new JTextField();
        textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        textField.setBounds(139, 18, 231, 19);
        textField.setEditable(false);
        textField.setText(String.valueOf(idCounter++)); // Establecer y luego incrementar el ID
        getContentPane().add(textField);

        // Campo de texto para el nombre del candidato
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        txtNombre.addActionListener(this);
        txtNombre.setBounds(139, 48, 231, 19);
        getContentPane().add(txtNombre);

        // Campo de texto para el partido del candidato
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        textField_1.setBounds(139, 78, 231, 19);
        getContentPane().add(textField_1);

        // Botones para Nuevo, Agregar Mesa y Cancelar
        btnGuardar = new JButton("Agregar Candidato");
        btnGuardar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnGuardar.setBackground(new Color(85, 219, 95));
        btnGuardar.addActionListener(this);
        btnGuardar.setBounds(41, 122, 144, 25);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnCancelar.setBackground(new Color(85, 219, 95));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(223, 122, 159, 25);
        getContentPane().add(btnCancelar);

        // Tabla para mostrar los candidatos
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 170, 416, 163);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica al hacer clic en la tabla
            }
        });

        // Encabezados de la tabla
        model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nombre", "Partido"});
        table.setModel(model);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(42, 21, 49, 14);
        getContentPane().add(lblNewLabel);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(42, 51, 81, 14);
        getContentPane().add(lblNombre);

        JLabel lblPartido = new JLabel("Lista:");
        lblPartido.setBounds(42, 81, 71, 14);
        getContentPane().add(lblPartido);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == txtNombre || e.getSource() == btnGuardar) {
            agregarFila();
        } else if (e.getSource() == btnCancelar) {
            limpiarYCerrar();
        }
    }

    private void limpiarYCerrar() {
        // Cerrar el formulario
        dispose();
    }

    private void agregarFila() {
        // Obtener valores de los campos
        String nombre = txtNombre.getText();
        String partido = textField_1.getText();

        // Verificar que se hayan ingresado datos
        if (nombre.isEmpty() || partido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el ID actual y luego incrementar el contador
        String id = String.valueOf(idCounter++);

        // Lógica para agregar una fila a la lista de candidatos
        Object[] rowData = {id, nombre, partido};
        candidatos.add(rowData);

        // Limpiar campos después de agregar la fila
        txtNombre.setText("");
        textField_1.setText("");

        // Establecer el nuevo ID en el campo correspondiente
        textField.setText(String.valueOf(idCounter));

        // Actualizar la tabla con los datos de la lista de candidatos
        actualizarTabla();
    }

    private void actualizarTabla() {
        // Limpiar la tabla
        model.setRowCount(0);

        // Agregar los candidatos almacenados en la lista a la tabla
        for (Object[] candidato : candidatos) {
            model.addRow(candidato);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FormularioRegistrarCandidato frame = new FormularioRegistrarCandidato();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

