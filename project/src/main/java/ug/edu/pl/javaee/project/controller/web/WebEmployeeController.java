package ug.edu.pl.javaee.project.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ug.edu.pl.javaee.project.domain.Employee;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.service.EmployeeService;
import ug.edu.pl.javaee.project.service.SmartphoneService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class WebEmployeeController {
    private final EmployeeService employeeService;
    private final SmartphoneService smartphoneService;

    public WebEmployeeController(@Autowired EmployeeService employeeService,@Autowired SmartphoneService smartphoneService) {
        this.employeeService = employeeService;
        this.smartphoneService = smartphoneService;
    }

    @GetMapping("/employee")
    public String employees(Model model) {
        model.addAttribute("allEmployeesFromDB", employeeService.allEmployees());
        return "employee-all";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("Error found in addEmployee");
            return "redirect:/employee";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/newEmployeeForm")
    public String newEmployeeForm(Model model) {
        Employee employee = new Employee();
        Iterable<Smartphone> listSmartphones = smartphoneService.allSmartphones();
        model.addAttribute("employee", employee);
        model.addAttribute("listSmartphones", listSmartphones);
        return "employee-new";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/smartphone";
    }
    @GetMapping("/updateEmployeeForm/{id}")
    public String updateEmployeeForm(@PathVariable ( value = "id") Long id, Model model) {
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        Iterable<Smartphone> listSmartphones = smartphoneService.allSmartphones();
        model.addAttribute("employee", employee);
        model.addAttribute("listSmartphones", listSmartphones);
        return "employee-update";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("Error found in updateEmployee");
            return "redirect:/employee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/employee";
    }
}
