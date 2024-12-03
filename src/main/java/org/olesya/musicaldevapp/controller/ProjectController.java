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

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ProjectController {
    @FXML
    private TableView<Project> projectTable;

    @FXML
    private TableColumn<Project, UUID> projectIdProjectTable;

    @FXML
    private TableColumn<Project, String> projectNameProjectTable;

    @FXML
    private TableColumn<Project, LocalDate> createDateProjectTable;

    @FXML
    private TableColumn<Project, LocalDate> lastChangeDateProjectTable;

    @FXML
    private TableColumn<Project, String> versionProjectTable;

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
        projectIdProjectTable.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        projectNameProjectTable.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        createDateProjectTable.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        lastChangeDateProjectTable.setCellValueFactory(new PropertyValueFactory<>("lastChangeDate"));
        versionProjectTable.setCellValueFactory(new PropertyValueFactory<>("version"));
    }

    private void baseFillTable() throws CommonException {
        ObservableList<Project> projectObservableList = FXCollections.observableArrayList();
        List<Project> projects = projectRepository.getAllProjects();
        projectObservableList.addAll(projects);
        projectTable.setItems(projectObservableList);
    }
}
