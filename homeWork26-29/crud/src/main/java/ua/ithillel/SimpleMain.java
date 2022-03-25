package ua.ithillel;

import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;

public class SimpleMain {
    public static void main(String[] args) throws BusinessException {
        try {
            EmployeeManageService ems = new EmployeeManageService();
            DepartmentManageService dms = new DepartmentManageService();
            Employee nazarov = new Employee(1L, null, "Назаров Максим Давидович", 35000);
            Long nazarovId = ems.add(nazarov);
            Employee alexandrova = new Employee(1L, nazarovId, "Александрова Аиша Игоревна", 35000);
            Long alexandrovaId = ems.add(alexandrova);
            Employee stepanov = new Employee(1L, alexandrovaId, "Степанов Виктор Андреевич", 45000);
            ems.add(stepanov);
            System.out.println(ems.findAll());
            ems.delete(nazarov.getId());
            System.out.println(ems.get(nazarov.getId()));
            ems.update(new Employee(stepanov.getId(), 1L, alexandrovaId, "Степанов Виктор Андреевич", 55000));
            System.out.println(ems.findAll());
            Department admins = new Department(1L, "Административный отдел");
            Department urist = new Department(2L, "Юридический отдел");
            Department kredit = new Department(3L, "Кредитный отдел");
            Department buhalt = new Department(4L, "Отдел бухгалтерского учета и отчетности");

            dms.add(admins);
            dms.add(urist);
            dms.add(kredit);
            dms.add(buhalt);
            System.out.println(dms.findAll());
            dms.delete(admins.getId());
            System.out.println(dms.get(admins.getId()));
            dms.update(new Department(urist.getId(), "Юристы"));
            System.out.println(dms.findAll());
        } catch (BusinessException e) {
            e.printStackTrace();
        }


    }
}
