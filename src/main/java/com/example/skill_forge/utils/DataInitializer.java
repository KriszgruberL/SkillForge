package com.example.skill_forge.utils;

import com.example.skill_forge.models.entity.*;
import com.example.skill_forge.models.entity.enums.Result;
import com.example.skill_forge.models.entity.enums.Role;
import com.example.skill_forge.models.entity.enums.Status;
import com.example.skill_forge.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;
    private final InstitutionRepository institutionRepository;
    private final CourseRepository courseRepository;
    private final SessionRepository sessionRepository;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder, AddressRepository addressRepository, InstitutionRepository institutionRepository, CourseRepository courseRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
        this.institutionRepository = institutionRepository;
        this.courseRepository = courseRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        String pwd = passwordEncoder.encode("Test1234=");
//        try {
//            User user = new User();
//            user.setUsername("user");
//            user.setPassword(pwd);
//            user.setEmail("user@test.com");
//            user.setEnabled(true);
//            user.setRoles(Collections.singleton(Role.USER));
//
//            User admin = new User();
//            admin.setUsername("admin");
//            admin.setPassword(pwd);
//            admin.setEmail("admin@test.com");
//            admin.setEnabled(true);
//            admin.setRoles(Collections.singleton(Role.ADMIN));
//
//
//            Address address = new Address();
//            address.setStreet("Rue");
//            address.setNumber("1");
//            address.setAdditional("ab");
//            address.setZipcode("4000");
//            address.setCity("Ville");
//            address.setCountry("Belgique");
//
//            Institution institution = new Institution();
//            institution.setName("institution");
//            institution.setAddress(address);
//
//            Session s = new Session();
//            s.setSessionsDays(Collections.singleton(DayOfWeek.FRIDAY));
//            s.setStartTime(LocalTime.parse("15:30"));
//            s.setEndTime(LocalTime.parse("18:30"));
//            s.setUser(user);
//
//            Session s2 = new Session();
//            s2.setSessionsDays(Collections.singleton(DayOfWeek.TUESDAY));
//            s2.setStartTime(LocalTime.parse("17:30"));
//            s2.setEndTime(LocalTime.parse("21:30"));
//            s2.setUser(user);
//
//            Session s3 = new Session();
//            s3.setSessionsDays(Collections.singleton(DayOfWeek.WEDNESDAY));
//            s3.setStartTime(LocalTime.parse("17:30"));
//            s3.setEndTime(LocalTime.parse("21:30"));
//            s3.setUser(user);
//
//            Course course = new Course();
//            course.setName("Algo");
//            course.setUeCode("288954D2");
//            course.setStatus(Status.NOT_STARTED);
//            course.setStartDate(LocalDate.parse("2023-09-18"));
//            course.setEndDate(LocalDate.parse("2024-06-17"));
//            course.setProgram("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam dictum, odio eget facilisis consectetur, tortor risus lacinia massa, vitae ornare neque urna in quam. Nullam lectus purus, luctus ac arcu vitae, porta suscipit odio. Vestibulum accumsan lacus in magna laoreet tempor. Donec scelerisque a nisl nec sollicitudin. Mauris fringilla tortor non enim accumsan, eu dignissim felis consequat. Mauris congue sed justo vitae sodales.");
//            course.setTerminalCapacities("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam dictum, odio eget facilisis consectetur, tortor risus lacinia massa, vitae ornare neque urna in quam. Nullam lectus purus, luctus ac arcu vitae, porta suscipit odio. Vestibulum accumsan lacus in magna laoreet tempor. Donec scelerisque a nisl nec sollicitudin. Mauris fringilla tortor non enim accumsan, eu dignissim felis consequat. Mauris congue sed justo vitae sodales.");
//            course.setTeacher("Pouet pouet");
//            course.setInstitutionId(institution);
//            course.setSessions(Set.of(s));
//            s.setCourseId(course);
//
//            Course course2 = new Course();
//            course2.setName("ERP");
//            course2.setUeCode("21644d2");
//            course2.setStatus(Status.FINISHED);
//            course2.setResult(Result.PASSED);
//            course2.setStartDate(LocalDate.parse("2023-09-18"));
//            course2.setEndDate(LocalDate.parse("2023-12-23"));
//            course2.setProgram("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam dictum, odio eget facilisis consectetur, tortor risus lacinia massa, vitae ornare neque urna in quam. Nullam lectus purus, luctus ac arcu vitae, porta suscipit odio. Vestibulum accumsan lacus in magna laoreet tempor. Donec scelerisque a nisl nec sollicitudin. Mauris fringilla tortor non enim accumsan, eu dignissim felis consequat. Mauris congue sed justo vitae sodales.");
//            course2.setTerminalCapacities("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam dictum, odio eget facilisis consectetur, tortor risus lacinia massa, vitae ornare neque urna in quam. Nullam lectus purus, luctus ac arcu vitae, porta suscipit odio. Vestibulum accumsan lacus in magna laoreet tempor. Donec scelerisque a nisl nec sollicitudin. Mauris fringilla tortor non enim accumsan, eu dignissim felis consequat. Mauris congue sed justo vitae sodales.");
//            course2.setTeacher("Prof");
//            course2.setInstitutionId(institution);
//            course.setSessions(Set.of(s2));
//            s2.setCourseId(course2);
//
//
//            Course course3 = new Course();
//            course3.setName("OS");
//            course3.setUeCode("54474545dr");
//            course3.setStatus(Status.IN_PROGRESS);
//            course3.setStartDate(LocalDate.parse("2023-09-19"));
//            course3.setEndDate(LocalDate.parse("2023-12-24"));
//            course3.setProgram("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam dictum, odio eget facilisis consectetur, tortor risus lacinia massa, vitae ornare neque urna in quam. Nullam lectus purus, luctus ac arcu vitae, porta suscipit odio. Vestibulum accumsan lacus in magna laoreet tempor. Donec scelerisque a nisl nec sollicitudin. Mauris fringilla tortor non enim accumsan, eu dignissim felis consequat. Mauris congue sed justo vitae sodales.");
//            course3.setTerminalCapacities("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam dictum, odio eget facilisis consectetur, tortor risus lacinia massa, vitae ornare neque urna in quam. Nullam lectus purus, luctus ac arcu vitae, porta suscipit odio. Vestibulum accumsan lacus in magna laoreet tempor. Donec scelerisque a nisl nec sollicitudin. Mauris fringilla tortor non enim accumsan, eu dignissim felis consequat. Mauris congue sed justo vitae sodales.");
//            course3.setTeacher("Prof");
//            course3.setInstitutionId(institution);
//            course.setSessions(Set.of(s3));
//            s3.setCourseId(course3);
//
//
//
//            userRepository.save(user);
//            userRepository.save(admin);
//            institutionRepository.save(institution);
//            addressRepository.save(address);
//            sessionRepository.save(s);
//            sessionRepository.save(s2);
//            sessionRepository.save(s3);
//
//
//
//            courseRepository.save(course);
//            courseRepository.save(course2);
//            courseRepository.save(course3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




    }
}

