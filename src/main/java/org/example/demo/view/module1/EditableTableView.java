package org.example.demo.view.module1;

import atlantafx.base.theme.Styles;
import cn.hutool.core.util.ReflectUtil;
import com.sun.javafx.PlatformUtil;
import de.saxsys.mvvmfx.FxmlView;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.control.tableview2.cell.TextField2TableCell;
import org.example.demo.entity.PersonEntity;
import org.example.demo.entity.TableItemEntity;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class EditableTableView implements FxmlView<EditableTableViewModel>, Initializable {
    public TableView<TableItemEntity> tableView;
    public TableColumn<TableItemEntity, String> column1;
    public TableColumn<TableItemEntity, String> column2;
    public TableColumn<TableItemEntity, String> column3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Styles.toggleStyleClass(tableView, Styles.BORDERED);

        column1.setCellFactory(TextField2TableCell.forTableColumn());
        column1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getColumn1())
        );
        column1.setOnEditCommit(e -> {
            e.getRowValue().setColumn1(e.getNewValue());
            tableView.refresh();
        });

        column2.setCellFactory(TextField2TableCell.forTableColumn());
        column2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getColumn2())
        );
        column2.setOnEditCommit(e -> {
            e.getRowValue().setColumn2(e.getNewValue());
            tableView.refresh();
        });

        column3.setCellFactory(TextField2TableCell.forTableColumn());
        column3.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().getColumn3())
        );
        column3.setOnEditCommit(e -> {
            e.getRowValue().setColumn3(e.getNewValue());
            tableView.refresh();
        });
    }

    public void onAddButtonClick(ActionEvent actionEvent) {
        tableView.getItems().add(new TableItemEntity());
    }

    public void onSaveButtonClick(ActionEvent actionEvent) {
        System.out.println(tableView.getItems());
    }
}

