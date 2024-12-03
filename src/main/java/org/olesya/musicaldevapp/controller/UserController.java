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
import java.util.List;
import java.util.UUID;

public class UserController {
    @FXML
    private TableView<User> usersTable;

    @FXML
    private TableColumn<User, UUID> userIdUsersTable;

    @FXML
    private TableColumn<User, UUID> roleIdUsersTable;

    @FXML
    private TableColumn<User, String> usernameUsersTable;

    @FXML
    private TableColumn<User, Integer> userAgeUsersTable;

    @FXML
    private TableColumn<User, String> passwordUsersTable;

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
        userIdUsersTable.setCellValueFactory(new PropertyValueFactory<>("userId"));
        roleIdUsersTable.setCellValueFactory(new PropertyValueFactory<>("roleId"));
        usernameUsersTable.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userAgeUsersTable.setCellValueFactory(new PropertyValueFactory<>("password"));
        passwordUsersTable.setCellValueFactory(new PropertyValueFactory<>("userAge"));
    }

    private void baseFillTable() throws CommonException {
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        List<User> users = userRepository.getAllUsers();
        userObservableList.addAll(users);
        usersTable.setItems(userObservableList);
    }
}
