package sg.edu.nus.iss.phoenix.schedule.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.schedule.dao.ScheduleDAO;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

public class ReviewSelectScheduleService {
    DAOFactoryImpl factory;
    ScheduleDAO psdao;

    /*
        Constructor for ReviewSelectSchdeule class .
        Initializes schedule dao class.
        */
    public ReviewSelectScheduleService() {
        super();
        // TODO Auto-generated constructor stub
        factory = new DAOFactoryImpl();
        psdao = factory.getScheduleDAO();
    }
     /**
     * Method to get review select schedule
     *
     * @return ArrayList of program slots
     */
    public List<ProgramSlot> reviewSelectSchedule() {
        List<ProgramSlot> data = null;
        try {
            data = psdao.loadAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewSelectScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
