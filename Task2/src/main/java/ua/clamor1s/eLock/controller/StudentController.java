package ua.clamor1s.eLock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.clamor1s.eLock.dto.request.StudentRequest;
import ua.clamor1s.eLock.dto.response.GroupResponse;
import ua.clamor1s.eLock.dto.response.StudentGroupResponse;
import ua.clamor1s.eLock.dto.response.StudentResponse;
import ua.clamor1s.eLock.facade.GroupFacade;
import ua.clamor1s.eLock.facade.StudentFacade;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentFacade studentFacade;
    private final GroupFacade groupFacade;

    @GetMapping
    public String index(Model model) {
        List<StudentResponse> students = studentFacade.getAllStudents();
        List<GroupResponse> groups = groupFacade.getAllGroups();
        List<StudentGroupResponse> studentGroups = studentFacade.getAllStudentGroups();
        model.addAttribute("students", students);
        model.addAttribute("groups", groups);
        model.addAttribute("studentGroups", studentGroups);
        return "student/index";
    }

    @PostMapping
    public String create(@ModelAttribute("student") StudentRequest studentRequest,
                         Model model) {
        studentFacade.createStudent(studentRequest);
        List<StudentResponse> students = studentFacade.getAllStudents();
        model.addAttribute("students", students);
        return "fragments/student/students :: studentsFragment";
    }

    @PutMapping("/{studentId}")
    public String update(@PathVariable Long studentId,
                         @ModelAttribute("student") StudentRequest studentRequest,
                         Model model) {
        studentFacade.updateStudent(studentId, studentRequest);
        List<StudentResponse> students = studentFacade.getAllStudents();
        model.addAttribute("students", students);
        return "fragments/student/students :: studentsFragment";
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Long studentId, Model model) {
        studentFacade.deleteStudent(studentId);
        List<StudentResponse> students = studentFacade.getAllStudents();
        model.addAttribute("students", students);
        return "fragments/student/students :: studentsFragment";
    }
}
