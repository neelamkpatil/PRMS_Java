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

	public UserService() {
		super();
		// Sorry. This implementation is wrong. To be fixed.
		factory = new DAOFactoryImpl();
		urdao = factory.getUserDAO();
	}
	public ArrayList<User> searchPrograms(User urso) {
		ArrayList<User> list = new ArrayList<User>();
		try {
			list = (ArrayList<User>) urdao.searchMatching(urso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<User> findRPByCriteria(User rp) {
		ArrayList<User> currentList = new ArrayList<User>();

		try {
			currentList = (ArrayList<User>) urdao.searchMatching(rp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currentList;

	}

	public User findRP(String rpName) {
		User currentur = new User();
		currentur.setName(rpName);
		try {
			currentur = ((ArrayList<User>) urdao
					.searchMatching(currentur)).get(0);
			return currentur;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentur;

	}

	public ArrayList<User> findAllUR() {
		ArrayList<User> currentList = new ArrayList<User>();
		try {
			currentList = (ArrayList<User>) urdao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentList;

	}
        
	public void processCreate(User ur) {
		try {
			urdao.create(ur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processModify(User ur) {
		
			try {
				urdao.save(ur);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void processDelete(String name) {

            try {
                User ur = new User(name);
                urdao.delete(ur);
            } catch (NotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	}
    
}
