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

public class RoleController {
    @FXML
    private TableView<Role> rolesTable;

    @FXML
    private TableColumn<Role, UUID> roleIdRolesTable;

    @FXML
    private TableColumn<Role, String> roleNameRolesTable;

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
        roleIdRolesTable.setCellValueFactory(new PropertyValueFactory<>("roleId"));
        roleNameRolesTable.setCellValueFactory(new PropertyValueFactory<>("roleName"));
    }

    private void baseFillTable() throws CommonException {
        ObservableList<Role> roleObservableList = FXCollections.observableArrayList();
        List<Role> roles = roleRepository.getAllRoles();
        roleObservableList.addAll(roles);
        rolesTable.setItems(roleObservableList);
    }
}
