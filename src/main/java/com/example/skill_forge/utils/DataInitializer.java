package com.example.skill_forge.utils;

import com.example.skill_forge.models.entity.Address;
import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.models.entity.Institution;
import com.example.skill_forge.models.entity.User;
import com.example.skill_forge.models.entity.enums.Role;
import com.example.skill_forge.repositories.AddressRepository;
import com.example.skill_forge.repositories.CourseRepository;
import com.example.skill_forge.repositories.InstitutionRepository;
import com.example.skill_forge.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner{

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final AddressRepository addressRepository;
        private final InstitutionRepository institutionRepository;
        private final CourseRepository courseRepository;

        public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder, AddressRepository addressRepository, InstitutionRepository institutionRepository, CourseRepository courseRepository) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.addressRepository = addressRepository;
            this.institutionRepository = institutionRepository;
            this.courseRepository = courseRepository;
        }

        @Override
        public void run(String... args) throws Exception {

            String pwd = passwordEncoder.encode("Test1234=");

//            User user = new User();
//            user.setUsername("user");
//            user.setPassword(pwd);
//            user.setEmail("user@test.com");
//            user.setEnabled(true);
//            user.setRoles(Collections.singleton(Role.USER));
//            userRepository.save(user);
//
//            User admin = new User();
//            admin.setUsername("admin");
//            admin.setPassword(pwd);
//            admin.setEmail("admin@test.com");
//            admin.setEnabled(true);
//            admin.setRoles(Collections.singleton(Role.ADMIN));
//            userRepository.save(admin);
//
//            Address address = new Address();
//            address.setStreet("Rue");
//            address.setNumber("1");
//            address.setAdditional("ab");
//            address.setZipcode("4000");
//            address.setCity("Ville");
//            address.setCountry("Belgique");
//            addressRepository.save(address);
//
//            Institution institution = new Institution();
//            institution.setName("institution");
//            institution.setAddress(address);
//            institutionRepository.save(institution);
//
//            Course course = new Course();
//            course.setName("Algo");
//            course.setUeCode("288954D2");
//            course.setStartDate(LocalDate.now().minusDays(15));
//            course.setEndDate(LocalDate.now());
//            course.setTeacher("Pouet pouet");
//            course.setInstitutionId(institution);
//            courseRepository.save(course);
//
//            institution.setCoursesGiven(Set.of(course));
//



        }
    }

