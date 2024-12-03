package org.olesya.musicaldevapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Setter;
import org.olesya.musicaldevapp.data.entity.*;
import org.olesya.musicaldevapp.data.repository.*;
import org.olesya.musicaldevapp.utils.CommonException;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TestingController {
    @FXML
    private TableView<Testing> testingTable;

    @FXML
    private TableColumn<Testing, UUID> testIdTestingTable;

    @FXML
    private TableColumn<Testing, UUID> projectIdTestingTable;

    @FXML
    private TableColumn<Testing, File> testContentTestingTable;

    @FXML
    private TableColumn<Testing, LocalDate> createDateTestingTable;

    @FXML
    private TableColumn<Testing, LocalDate> lastChangeDateTestingTable;

    @FXML
    private TableColumn<Testing, String> fileExtensionTestingTable;

    private AnalyticsRepository analyticsRepository;
    private DevelopmentRepository developmentRepository;
    private ModerationRepository moderationRepository;
    private ProjectRepository projectRepository;
    private ProjectUserRepository projectUserRepository;
    private RequirementTypeRepository requirementTypeRepository;
    private RoleRepository roleRepository;
    private TestingRepository testingRepository;
    private UserRepository userRepository;

    @Setter
    private User currentUser;

    public void initialize() throws SQLException, CommonException {
        analyticsRepository = new AnalyticsRepository();
        developmentRepository = new DevelopmentRepository();
        moderationRepository = new ModerationRepository();
        projectRepository = new ProjectRepository();
        projectUserRepository = new ProjectUserRepository();
        requirementTypeRepository = new RequirementTypeRepository();
        roleRepository = new RoleRepository();
        testingRepository = new TestingRepository();
        userRepository = new UserRepository();
        setCellValueFactories();
        baseFillTable();
    }

    private void setCellValueFactories() {
        testIdTestingTable.setCellValueFactory(new PropertyValueFactory<>("testId"));
        projectIdTestingTable.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        testContentTestingTable.setCellValueFactory(new PropertyValueFactory<>("testContent"));
        createDateTestingTable.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        lastChangeDateTestingTable.setCellValueFactory(new PropertyValueFactory<>("lastChangeDate"));
        fileExtensionTestingTable.setCellValueFactory(new PropertyValueFactory<>("fileExtension"));
    }

    private void baseFillTable() throws CommonException {
        ObservableList<Testing> testingObservableList = FXCollections.observableArrayList();
        List<Testing> testings = testingRepository.getAllTestings();
        testingObservableList.addAll(testings);
        testingTable.setItems(testingObservableList);
    }
}
