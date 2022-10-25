package com.Himanshu.TTN.SpringRestApiExample.InternalizationandHateos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class UserService {
    private static List<User> userList = new ArrayList<>();


    //setting up values of Employee bean
    static
    {
        userList.add(new User("Himanshu",101,23));
        userList.add(new User("Aman",102,22));
        userList.add(new User("lalit",103,23));
        userList.add(new User("Aman",104,22));


    }

    //returns all Employee data using List in json format
    public List<User> findAll()
    {
        return userList;
    }

    //method which will match and return the employee details according to id
    public User findOne(int id)
    {

        //functional programming
        Predicate<? super User> predicate =
                employee -> employee.getId()==(id);


        //concerting List to stream
        //orElse if id is not found to handle exception
        //but no response will come
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    public User findUser(String userName)
    {

        //functional programming
        Predicate<? super User> predicate =
                employee -> employee.getName().equals(userName);


        //concerting List to stream
        //orElse if id is not found to handle exception
        //but no response will come
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    //save the Employee which is newly created
    // and return it and display in json
    public static User save(User employee)
    {
        userList.add(employee);
        return employee;
    }
    public void delete ( int id)
    {
        //deleting by id
        userList.removeIf(e -> Objects.equals(e.getId(), id));

    }










}

