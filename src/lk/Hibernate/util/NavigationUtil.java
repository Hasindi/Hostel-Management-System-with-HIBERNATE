package lk.Hibernate.util;

import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public interface NavigationUtil {
    void loadUi(String location) throws IOException;
    void CloseWindowUi(AnchorPane a) throws IOException;
}
