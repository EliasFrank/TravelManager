package com.hl.service;

import com.hl.dao.UserDao;
import com.hl.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author hl2333
 */
public interface MyUserService extends UserDetailsService {
}
