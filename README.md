# Student_management_system
This repo was used to learn Spring boot 
Using Spring boot , Spring MVC , Spring Data JPA , MySQL
Within the application I did testing for repository layer,I tested the application against the real production database,
which can be useful for verifying the behavior of the application in a more realistic environment 
by using @AutoConfigureTestDatabase(replace = Replace.NONE) annotation.

In this example, @Transactional ensures that the entire test method runs within a transaction.
By using @Transactional I ensure that the entire test method runs within a transaction.
The @Rollback annotation is used to explicitly indicate that the changes made to the database within the test method
should be rolled back at the end of the test. 
By combining these annotations, I can control the transaction and rollback behavior even when using a real database.
