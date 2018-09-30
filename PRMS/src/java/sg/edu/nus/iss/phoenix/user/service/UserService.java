/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.user.dao.UserDao;
import sg.edu.nus.iss.phoenix.user.entity.User;

/**
 *
 * @author wangzuxiu
 */
public class UserService {

    DAOFactoryImpl factory;
    UserDao urdao;

    /*
        Constructor for UserService class.
        Initializes user dao class.
     */
    public UserService() {
        super();
        factory = new DAOFactoryImpl();
        urdao = factory.getUserDAO();
    }

    /**
     * Method to search user in programs assigned
     *
     * @param urso user object
     * @return ArrayList of users
     */
    public ArrayList<User> searchPrograms(User urso) {
        ArrayList<User> list = new ArrayList<User>();
        try {
            list = (ArrayList<User>) urdao.searchMatching(urso);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return list;
    }

    /**
     * Method to find user by criteria
     *
     * @param ur user object
     * @return ArrayList of users
     */
    public ArrayList<User> findURByCriteria(User ur) {
        ArrayList<User> currentList = new ArrayList<User>();

        try {
            currentList = (ArrayList<User>) urdao.searchMatching(ur);
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return currentList;

    }

    /**
     * Method to find User
     *
     * @param urId userId string
     * @return user object
     */
    public User findUR(String urId) {
        User currentur = new User();

        try {
            currentur = (User) urdao.searchMatching(urId);
            return currentur;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return currentur;

    }

    /**
     * Method to get all Users
     *
     * @return ArrayList of users
     */
    public ArrayList<User> findAllUR() {
        ArrayList<User> currentList = new ArrayList<User>();
        try {
            currentList = (ArrayList<User>) urdao.loadAll();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return currentList;

    }

    /**
     * Method to create user
     *
     * @param ur user object.
     *
     */
    public void processCreate(User ur) {
        try {
            urdao.create(ur);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Method to modify user
     *
     * @param ur user object.
     *
     */
    public void processModify(User ur) {

        try {
            urdao.save(ur);
        } catch (NotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    /**
     * Method to delete user
     *
     * @param name of the user.
     *
     */
    public void processDelete(String name) {

        try {
            User ur = new User(name);
            urdao.delete(ur);
        } catch (NotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Method to check if user is assigned to program slot
     *
     * @param user user object.
     * @return boolean true on success.
     *
     */
    public boolean checkIsAssigned(User user) throws SQLException {

        boolean flag = urdao.checkIsAssigned(user);

        return flag;
    }

    /**
     * Method to check if user already exists.
     *
     * @param user user object.
     * @return boolean true on success.
     * @throws SQLException
     *
     */
    public boolean checkIsExist(User user) throws SQLException {

        boolean flag = urdao.checkIsExist(user);

        return flag;
    }

}
