package com.queryjet.www.common;

import com.google.common.base.Strings;
import com.queryjet.www.domain.common.Log;
import com.queryjet.www.service.common.LogService;
import com.queryjet.www.service.member.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;

/**
 * Created by jin on 15. 10. 13..
 */
@RequestMapping(value="/common")
@Controller
public class CommonLog {

    @Autowired
    UserService userService;

    @Autowired
    LogService logService;

    @RequestMapping(value = "/log", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String receiptEditProcess(HttpServletRequest request,HttpServletResponse response, Log log,Principal principal) throws Exception {
        String result = "success";
        try {
            if(principal!=null && !Strings.isNullOrEmpty(principal.getName())){
                int userNo = this.userService.selectNoByUserId(principal.getName());
                log.setUserNo(userNo);
            }
            log.setInsertDate(new Date());
            this.logService.insert(log);
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            result = "error";
        }
        return result;
    }
}
