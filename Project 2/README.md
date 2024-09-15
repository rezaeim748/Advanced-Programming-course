
# Project Title: University Management System

## Overview
This project implements a basic university management system designed to automate various student and faculty activities. The system is divided into multiple phases. Each phase builds upon the previous one, adding new features and improvements.

In this project, a portal is developed for three main types of users: 
- **Admin**
- **Professor**
- **Student**

Each user type has distinct functionalities, such as adding students and professors (Admin), managing classes (Professor), and enrolling in courses and checking grades (Student).

## Features Implemented (Phase 1 and 2)

### Phase 1: Graphical User Interface (GUI)
In the first phase, we developed the GUI for the system. The interface was designed to resemble existing university management systems like SAMAD and Portal, providing a familiar experience for users. This phase focused on building the fundamental layout and functionality of the system:
- **Admin Panel**: Admin can manage students, professors, and classes.
- **Student Panel**: Students can view their profile, course information, and manage their account balance.
- **Professor Panel**: Professors can manage their class information and view student grades.

### Phase 2: File Handling and Error Management
The second phase introduced backend functionality to handle user data and exceptions:
- **Data Persistence**: User information and system data are now saved to files, enabling the application to retain information between sessions.
- **Error Handling**: Comprehensive exception handling has been added to manage invalid inputs and other issues. This includes user authentication errors, file I/O errors, and data validation checks.
- **Improved Logic**: The core functionality of the GUI has been enhanced to work seamlessly with the backend logic. Key components such as buttons, menus, and other elements now fully interact with the underlying system.

## How to Run
1. Make sure you have Java installed on your system.
2. Compile and run the project using the following commands:
   ```bash
   javac *.java
   java Main
   ```

## Future Enhancements
The next phase (not implemented yet) will introduce network capabilities to enable communication between multiple instances of the application. 
