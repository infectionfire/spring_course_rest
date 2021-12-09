package com.ivanovsergei.spring.rest.controller;

import com.ivanovsergei.spring.rest.entity.Employee;
import com.ivanovsergei.spring.rest.exception_handling.EmployeeIncorrectData;
import com.ivanovsergei.spring.rest.exception_handling.NoSuchEmployeeException;
import com.ivanovsergei.spring.rest.service.EmployeeService;
import org.dom4j.io.ElementModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//управляет рест запросами и ответами
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){

    List<Employee> allEmployees = employeeService.getAllEmployees();
    return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){//с помощью аннтоации передается число в метод и выводится результат
        Employee employee = employeeService.getEmployee(id);

        if (employee ==null){//если работник не найден, вылетит ошибка
            throw new NoSuchEmployeeException("There is no employee with ID = "+ id + " in Database");
        }
        return employee;//json получается автоматически при помощи спринга и джексон датабайнд
    }

//    //локальная обработка исключений, заменена на глобальную
//    @ExceptionHandler//ловим исключение по неверному ид работника (отсутствующий ид в базе)
//    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception){
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());//берем сообщение из параметра конструктора исключения
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//
//    @ExceptionHandler//ловим исключение по вводу символов в ид работника
//    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception){
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());//берем сообщение из параметра конструктора исключения
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }

    @PostMapping("/employees")//пост запрос для добавления
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);

        return employee;//спринг и джексон автоматически конветрируют
    }
}
