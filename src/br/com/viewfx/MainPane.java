package br.com.viewfx;

import org.tbee.javafx.scene.layout.MigPane;

public class MainPane {
    public MigPane mainPane(){
        mainPane = new MigPane("ins 50", "[][center][]");
        mainPane.setId("mainPanel");
        
        mainPane.add(dp.insertDressPane(), "cell 1 0, hidemode 3, grow, push");
        mainPane.add(cp.clientPane(), "cell 1 0, hidemode 3, grow, push");
        mainPane.add(ep.employeePane(), "cell 1 0, hidemode 3, grow, push");
        mainPane.add(dp.selectDressPane(), "cell 1 0, hidemode 3, grow, push");
        mainPane.add(sp.selectClient(), "cell 1 0, hidemode 3, grow, push");
        mainPane.add(sp.selectEmployee(), "cell 1 0, hidemode 3, grow, push");
        
        return mainPane;
    }

    public static void setMainPane(MigPane mainPane) {
        MainPane.mainPane = mainPane;
    }
    
    public static MigPane getMainPane() {
        return mainPane;
    }
    
    private static MigPane mainPane;

    ClientPane cp = new ClientPane();
    EmployeePane ep = new EmployeePane();
    DressPane dp = new DressPane();
    SearchPane sp = new SearchPane();
    
}
