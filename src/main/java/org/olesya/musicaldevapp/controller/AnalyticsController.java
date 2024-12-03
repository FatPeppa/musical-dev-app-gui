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

public class AnalyticsController {
    @FXML
    private TableView<Analytics> analyticsTable;

    @FXML
    private TableColumn<Analytics, UUID> requirementIdAnalyticsTableColumn;

    @FXML
    private TableColumn<Analytics, UUID> projectIdAnalyticsTableColumn;

    @FXML
    private TableColumn<Analytics, UUID> requirementTypeIdAnalyticsTableColumn;

    @FXML
    private TableColumn<Analytics, File> requirementContentAnalyticsTableColumn;

    @FXML
    private TableColumn<Analytics, LocalDate> createDateAnalyticsTableColumn;

    @FXML
    private TableColumn<Analytics, LocalDate> lastChangeDateAnalyticsTableColumn;

    @FXML
    private TableColumn<Analytics, String> fileExtensionAnalyticsTableColumn;

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
        requirementIdAnalyticsTableColumn.setCellValueFactory(new PropertyValueFactory<>("requirementId"));
        projectIdAnalyticsTableColumn.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        requirementTypeIdAnalyticsTableColumn.setCellValueFactory(new PropertyValueFactory<>("requirementTypeId"));
        requirementContentAnalyticsTableColumn.setCellValueFactory(new PropertyValueFactory<>("requirementContent"));
        createDateAnalyticsTableColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));
        lastChangeDateAnalyticsTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastChangeDate"));
        fileExtensionAnalyticsTableColumn.setCellValueFactory(new PropertyValueFactory<>("fileExtension"));
    }

    private void baseFillTable() throws CommonException {
        ObservableList<Analytics> analyticsObservableList = FXCollections.observableArrayList();
        List<Analytics> analytics = analyticsRepository.getAllAnalytics();
        analyticsObservableList.addAll(analytics);
        analyticsTable.setItems(analyticsObservableList);
    }
}
