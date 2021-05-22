package helpers;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalReport {

    public  static void  main (String[] args) {

        String ruta = System.getProperty("user.dir") + "\\build\\reports\\cucumber\\";
        File report = new File(ruta+"JbReport");

        List<String> jsonFiles= new ArrayList<>();
        jsonFiles.add(ruta+"report.json");

        Configuration configuration = new Configuration(report,"JBGROUP RestAssured");
        configuration.setBuildNumber("100000");
        configuration.addClassifications("Owner","Humberto");
        configuration.addClassifications("Env","Calidad");
        configuration.addClassifications("Tipo","Local");
        configuration.addClassifications("Branch","master");

        ReportBuilder reportBuilder= new ReportBuilder(jsonFiles,configuration);
        reportBuilder.generateReports();

    }

}
