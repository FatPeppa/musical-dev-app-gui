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

public class DevelopmentController {
    @FXML
    private TableView<Development> developmentTable;

    @FXML
    private TableColumn<Development, UUID> fileIdDevelopmentTableColumn;

    @FXML
    private TableColumn<Development, UUID> projectIdDevelopmentTableColumn;

    @FXML
    private TableColumn<Development, File> codeFileDevelopmentTableColumn;

    @FXML
    private TableColumn<Development, String> versionDevelopmentTableColumn;

    @FXML
    private TableColumn<Development, LocalDate> createDateDevelopmentTableColumn;

    @FXML
    private TableColumn<Development, LocalDate> lastChangeDateDevelopmentTableColumn;

    @FXML
    private TableColumn<Development, String> fileExtensionDevelopmentTableColumn;

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
        fileIdDevelopmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("fileId"));
        projectIdDevelopmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        codeFileDevelopmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("codeFile"));
        versionDevelopmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("version"));
        createDateDevelopmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        lastChangeDateDevelopmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastChangeDate"));
        fileExtensionDevelopmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("fileExtension"));
    }

    private void baseFillTable() throws CommonException {
        ObservableList<Development> developmentObservableList = FXCollections.observableArrayList();
        List<Development> developments = developmentRepository.getAllDevelopment();
        developmentObservableList.addAll(developments);
        developmentTable.setItems(developmentObservableList);
    }
}
