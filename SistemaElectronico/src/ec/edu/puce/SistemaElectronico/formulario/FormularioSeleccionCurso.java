package ec.edu.puce.SistemaElectronico.formulario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioSeleccionCurso extends JInternalFrame implements ActionListener {
    private JButton btnGuardar;
    private DefaultTableModel model;
    private JTable table;
    private JButton btnSalir;
    private JComboBox<String> comboBoxCursos;
    private JButton btnNuevo;
    private JLabel lblNewLabel;

    public FormularioSeleccionCurso() {
        getContentPane().setBackground(new Color(245, 243, 148));
        setTitle("SELECCIONAR CURSO");
        setBounds(100, 100, 446, 364);
        getContentPane().setLayout(null);

        btnGuardar = new JButton("Registrar");
        btnGuardar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnGuardar.setBackground(new Color(85, 219, 95));
        btnGuardar.addActionListener(this);
        btnGuardar.setBounds(236, 65, 146, 25);
        getContentPane().add(btnGuardar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 128, 416, 163);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        model = new DefaultTableModel(new Object[][]{}, new String[]{"Curso Registrado"});
        table.setModel(model);
        scrollPane.setViewportView(table);

        btnNuevo = new JButton("Nuevo");
        btnNuevo.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnNuevo.setBackground(new Color(85, 219, 95));
        btnNuevo.setBounds(52, 65, 146, 25);
        btnNuevo.addActionListener(this);
        getContentPane().add(btnNuevo);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnSalir.setBackground(new Color(85, 219, 95));
        btnSalir.setBounds(154, 299, 117, 25);
        btnSalir.addActionListener(this);
        getContentPane().add(btnSalir);

        comboBoxCursos = new JComboBox<>();
        comboBoxCursos.setModel(new DefaultComboBoxModel<>(new String[]{"Selecciona.....", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo", "Octavo", "Noveno", "Décimo", "Primero de Bachillerato", "Segundo de Bachillerato", "Tercero de Bachillerato"}));
        comboBoxCursos.setBounds(154, 15, 239, 22);
        getContentPane().add(comboBoxCursos);
        
        lblNewLabel = new JLabel("Ingrese su Curso: ");
        lblNewLabel.setBounds(27, 19, 117, 14);
        getContentPane().add(lblNewLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            agregarFila();
        } else if (e.getSource() == btnNuevo) {
            nuevo();
        } else if (e.getSource() == btnSalir) {
            dispose();
        }
    }

    private void agregarFila() {
        String cursoSeleccionado = (String) comboBoxCursos.getSelectedItem();
        model.addRow(new Object[]{cursoSeleccionado});
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        // Lógica al hacer clic en la tabla
    }

    private void nuevo() {
        comboBoxCursos.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioSeleccionCurso());
    }
}
