package com.wl.servlet;

import com.alibaba.fastjson.JSON;
import com.wl.dao.RegistrationDao;
import com.wl.entity.Registration;
import com.wl.resp.RegistrationResp;
import com.wl.resp.RespEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by shizhouyong on 2016/12/7.
 */
@WebServlet("/registration/add")
public class RegistrationServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private RegistrationDao registrationDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        PrintWriter out = resp.getWriter();;
        Registration registration = new Registration();
        List<String> paramList = new ArrayList<>();
        Enumeration<String> registrationNames = req.getParameterNames();    //获取参数列表

        RegistrationResp registrationResp = new RegistrationResp();
        int account = 0;
        while (registrationNames.hasMoreElements()) {
            String param = req.getParameter(registrationNames.nextElement());
            if(!param.equals("")){
                paramList.add(param);
                account++;
            }
        }

        if(account!=3){
            String jsonStr = JSON.toJSONString(RespEnum.PARAMETER_NUMBER_ERR.getResponse());
            out.write(jsonStr);
            if (out != null) {
                out.close();
            }
            return;
        }

        registration.setParamList(paramList);
        int row = registrationDao.addRegistration(registration);
        if(row == -1){
            String jsonStr = JSON.toJSONString(RespEnum.DATA_INSERT_ERROR.getResponse());
            out.write(jsonStr);
            if (out != null) {
                out.close();
            }
            return;
        } else {
            registration.setId(row);
        }

        registrationResp.setRegistration(registration);
        String jsonStr = JSON.toJSONString(registrationResp);
        out.write(jsonStr);

        if (out != null) {
            out.close();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        registrationDao = new RegistrationDao();
    }
}
