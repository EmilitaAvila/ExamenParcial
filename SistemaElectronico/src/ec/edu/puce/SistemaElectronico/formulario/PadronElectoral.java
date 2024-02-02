package ec.edu.puce.SistemaElectronico.formulario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class PadronElectoral extends JInternalFrame implements ActionListener {
    private DefaultTableModel modeloCandidatos;
    private JTable tablaCandidatos;
    private DefaultTableModel modeloEstudiantes;
    private JTable tablaEstudiantes;
    private JButton btnSalir;
    private JLabel lblCandidatos;
    private JLabel lblEstudiantes;
    private JComboBox<String> comboBoxCursos;

    public PadronElectoral() {
        getContentPane().setBackground(new Color(245, 243, 148));
        setTitle("SELECCIONAR CURSO");
        setBounds(100, 100, 492, 511);
        getContentPane().setLayout(null);

        // Inicializar comboBoxCursos
        comboBoxCursos = new JComboBox<String>();
        comboBoxCursos.setBounds(10, 438, 150, 25);
        getContentPane().add(comboBoxCursos);
        comboBoxCursos.addActionListener(this);

        // Inicializar la tabla y el modelo para Candidatos
        JScrollPane scrollPaneCandidatos = new JScrollPane();
        scrollPaneCandidatos.setBounds(10, 36, 457, 163);
        getContentPane().add(scrollPaneCandidatos);

        tablaCandidatos = new JTable();
        tablaCandidatos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableCandidatosMouseClicked(evt);
            }
        });

        modeloCandidatos = new DefaultTableModel(new Object[][]{}, new String[]{"Lista de Candidatos registrados"});
        tablaCandidatos.setModel(modeloCandidatos);
        scrollPaneCandidatos.setViewportView(tablaCandidatos);

        // Inicializar la tabla y el modelo para Estudiantes
        JScrollPane scrollPaneEstudiantes = new JScrollPane();
        scrollPaneEstudiantes.setBounds(10, 264, 457, 163);
        getContentPane().add(scrollPaneEstudiantes);

        tablaEstudiantes = new JTable();
        tablaEstudiantes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableEstudiantesMouseClicked(evt);
            }
        });

        modeloEstudiantes = new DefaultTableModel(new Object[][]{}, new String[]{"Lista de Estudiantes registrados"});
        tablaEstudiantes.setModel(modeloEstudiantes);
        scrollPaneEstudiantes.setViewportView(tablaEstudiantes);

        // Otros componentes GUI...

        // Llamar al método para actualizar los cursos en el JComboBox
        actualizarComboBoxCursos();
    }

    // Agregar este método para actualizar los cursos en el JComboBox
    private void actualizarComboBoxCursos() {
        // Lógica para actualizar el comboBoxCursos con datos de cursos
        // Por ejemplo:
        comboBoxCursos.addItem("Curso 1");
        comboBoxCursos.addItem("Curso 2");
        // Agregar más cursos según sea necesario...
    }

    // Agregar este método para actualizar la tabla de Candidatos
    public void actualizarTablaCandidatos(List<Object[]> candidatos) {
        SwingUtilities.invokeLater(() -> {
            // Limpiar la tabla
            modeloCandidatos.setRowCount(0);

            // Agregar los candidatos de la lista a la tabla
            for (Object[] candidato : candidatos) {
                modeloCandidatos.addRow(candidato);
            }
        });
    }

    // Agregar este método para actualizar la tabla de Estudiantes
    public void actualizarTablaEstudiantes(List<Object[]> estudiantes) {
        SwingUtilities.invokeLater(() -> {
            // Limpiar la tabla
            modeloEstudiantes.setRowCount(0);

            // Agregar los estudiantes de la lista a la tabla
            for (Object[] estudiante : estudiantes) {
                modeloEstudiantes.addRow(estudiante);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBoxCursos) {
            // Lógica para manejar la selección de cursos en comboBoxCursos
            // Por ejemplo: Cargar datos relacionados con el curso seleccionado
            // Puede querer llamar a métodos como actualizarTablaCandidatos y
            // actualizarTablaEstudiantes aquí basándose en el curso seleccionado.
        } else if (e.getSource() == btnSalir) {
            // Manejar la acción de btnSalir si es necesario
        }
        // Agregar más lógica de actionPerformed según sea necesario...
    }

    private void tableCandidatosMouseClicked(MouseEvent evt) {
        // Lógica al hacer clic en la tabla de Candidatos
    }

    private void tableEstudiantesMouseClicked(MouseEvent evt) {
        // Lógica al hacer clic en la tabla de Estudiantes
    }
}

