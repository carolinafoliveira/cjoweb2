package br.edu.ifspcjo.ads.web2.view;

import java.util.List;
import java.util.Scanner;

import br.edu.ifspcjo.ads.web2.controller.EmployeesController;
import br.edu.ifspcjo.ads.web2.model.Employee;
import br.edu.ifspcjo.ads.web2.model.HourlyEmployee;
import br.edu.ifspcjo.ads.web2.model.SalariedEmployee;

public class App {

    private static final EmployeesController employeesController =
        new EmployeesController();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int menuOption;

        do {

            System.out.println();
            System.out.println("==== MENU ====");
            System.out.println("1 - Adicionar novo funcionário");
            System.out.println("2 - Gerar folha de pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            menuOption = teclado.nextInt();
            teclado.nextLine();

            switch (menuOption) {

                case 1:

                    System.out.print("Digite o nome do funcionário: ");
                    String name = teclado.nextLine();

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpf = teclado.nextLine();

                    System.out.println("Tipo de contrato:");
                    System.out.println("1 - Assalariado");
                    System.out.println("2 - Horista");
                    System.out.print("Escolha uma opção: ");
                    int contractOption = teclado.nextInt();
                    teclado.nextLine();

                    Employee employee;
                    switch (contractOption) {
                        case 1:
                            System.out.print("Digite o salário: ");
                            double salary = teclado.nextDouble();
                            teclado.nextLine();
                            employee = new SalariedEmployee(name, cpf, salary);
                            break;
                        case 2:
                            System.out.print("Horas trabalhadas: ");
                            int numberOfHoursWorked = teclado.nextInt();

                            System.out.print("Valor por hora: ");
                            double valueOfHoursWorked = teclado.nextDouble();
                            teclado.nextLine();
                            employee = new HourlyEmployee(
                                name, cpf, numberOfHoursWorked, valueOfHoursWorked);
                            break;
                        default:
                            System.out.println("Tipo de contrato inválido.");
                            employee = null;
                    }

                    if (employee != null) {
                        employeesController.save(employee);
                        System.out.println("Funcionário cadastrado com sucesso!");
                    }

                    break;

                case 2:
                    List<Employee> employees = employeesController.getEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        double totalPayroll = 0;
                        System.out.println("==== FOLHA DE PAGAMENTO ====");
                        for (Employee registeredEmployee : employees) {
                            double income = registeredEmployee.calculateIncome();
                            System.out.printf("%s: R$ %.2f%n",
                                registeredEmployee.getName(), income);
                            totalPayroll += income;
                        }
                        System.out.printf("Total: R$ %.2f%n", totalPayroll);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (menuOption != 0);

        teclado.close();
    }
}