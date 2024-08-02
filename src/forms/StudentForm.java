package forms;

import db.DBConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Objects;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

public class StudentForm extends JDialog {
    private JPanel MainPanel;
    private JTextField idField;
    private JTextField nameLatinField;
    private JTextField nameKhmerField;
    private JComboBox<String> genderComboBox;
    private DatePicker datePicker;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton resetButton;
    private JTable studentTable;
    private JPanel yourPanel;

    private void initializeDatePicker() {
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
        datePicker = new DatePicker(dateSettings);
        yourPanel.add(datePicker);
    }

    public StudentForm(JFrame parent) {
        super(parent);
        setContentPane(MainPanel);
        initializeDatePicker();
        setTitle("Student Form");
        setMinimumSize(new Dimension(600, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addButton.addActionListener(e -> createData());
        updateButton.addActionListener(e -> updateData());
        deleteButton.addActionListener(e -> deleteData());
        resetButton.addActionListener(e -> resetFields());

        // Fetch and display data when the form is loaded
        displayData();

        setVisible(true);
    }

    public StudentForm() {
        initializeDatePicker();
        setTitle("Student Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setContentPane(MainPanel);

        addButton.addActionListener(e -> createData());
        updateButton.addActionListener(e -> updateData());
        deleteButton.addActionListener(e -> deleteData());
        resetButton.addActionListener(e -> resetFields());

        // Fetch and display data when the form is loaded
        displayData();
    }

    private void createData() {
        String nameLatin = nameLatinField.getText();
        String nameKhmer = nameKhmerField.getText();
        String gender = Objects.requireNonNull(genderComboBox.getSelectedItem()).toString();
        String dateOfBirth = datePicker.getText();

        String query = "INSERT INTO student (name_latin, name_khmer, gender_id, date_of_birth) " +
                "VALUES (?, ?, (SELECT id FROM gender WHERE gender_name = ?), ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nameLatin);
            preparedStatement.setString(2, nameKhmer);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, dateOfBirth);
            preparedStatement.executeUpdate();
            displayData(); // Refresh display data
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateData() {
        int id = Integer.parseInt(idField.getText());
        String nameLatin = nameLatinField.getText();
        String nameKhmer = nameKhmerField.getText();
        String gender = Objects.requireNonNull(genderComboBox.getSelectedItem()).toString();
        String dateOfBirth = datePicker.getText();

        String query = "UPDATE student SET name_latin = ?, name_khmer = ?, gender_id = (SELECT id FROM gender WHERE gender_name = ?), date_of_birth = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nameLatin);
            preparedStatement.setString(2, nameKhmer);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, dateOfBirth);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            displayData(); // Refresh display data
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteData() {
        int id = Integer.parseInt(idField.getText());

        String query = "DELETE FROM student WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            displayData(); // Refresh display data
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void resetFields() {
        idField.setText("");
        nameLatinField.setText("");
        nameKhmerField.setText("");
        genderComboBox.setSelectedIndex(0);
        datePicker.clear();
    }

    private void displayData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name (Latin)");
        model.addColumn("Name (Khmer)");
        model.addColumn("Gender");
        model.addColumn("Date of Birth");

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT s.id, s.name_latin, s.name_khmer, g.gender_name, s.date_of_birth " +
                     "FROM student s JOIN gender g ON s.gender_id = g.id")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameLatin = resultSet.getString("name_latin");
                String nameKhmer = resultSet.getString("name_khmer");
                String genderName = resultSet.getString("gender_name");
                String dateOfBirth = resultSet.getDate("date_of_birth").toString();

                model.addRow(new Object[]{id, nameLatin, nameKhmer, genderName, dateOfBirth});
            }

            studentTable.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
