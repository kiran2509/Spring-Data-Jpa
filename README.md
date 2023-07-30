# Spring-Data-Jpa

This is about spring data JPA tutorial
JPA provides builtin queries based on the instance variables of class and also it's combination.
In this code tested with queries like
1. JPL Query
2. Native Query
3. Native Named Query
4. Builtin queries
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

Below is the mapping between the entities has been implemented and tested in the code.
Student(M)  -  (M)Course (1)  -  (1)CourseMaterial
                   (1)
                    |     - 1:M or M:1
                   (M)
                 Teacher
1. OneToOne
2. OneToMany
3. ManyToOne
4. ManyToMany

Tested all repository classes.
All the test classes has been in the test directory.



   
    
