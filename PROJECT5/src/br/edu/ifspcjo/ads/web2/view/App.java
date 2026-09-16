package br.edu.ifspcjo.ads.web2.view;

import br.edu.ifspcjo.ads.web2.controller.EmployeesController;
import br.edu.ifspcjo.ads.web2.model.Employee;
import br.edu.ifspcjo.ads.web2.model.HourlyEmployee;
import br.edu.ifspcjo.ads.web2.model.SalariedEmployee;

public class App {

    private static EmployeesController employeesController = 
        new EmployeesController();

    public static void main(String[] args) throws Exception{
        Employee employee1 = 
            new SalariedEmployee("Adriana", "1234", 3000);

        employeesController.save(employee1);
        System.out.println(employee1);
        System.out.println(employee1.calculateIncome());
        
        Employee employee2 =
            new HourlyEmployee("Juliana", "5678", 10, 365);
        System.out.println(employee2.calculateIncome());
    }
    
}
