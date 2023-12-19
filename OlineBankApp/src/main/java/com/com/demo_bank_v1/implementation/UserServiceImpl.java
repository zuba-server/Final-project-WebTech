//package com.com.demo_bank_v1.implementation;
//
//import com.com.demo_bank_v1.models.User;
//import com.com.demo_bank_v1.repository.UserRepository;
//import com.com.demo_bank_v1.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository; // Assuming you have a UserRepository
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Override
//    public User getCurrentUser() {
//        // Implement the logic to get the current user (e.g., from a database)
//        // For simplicity, let's assume there's a method findByUsername in the repository
//        // You may need to adapt this based on your actual data model and authentication mechanism
//        String currentUsername = "exampleUsername"; // Replace with your logic to get the current username
//        return userRepository.findByUsername(currentUsername);
//    }
//}
