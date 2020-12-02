package com.hl.service.impl;

import com.hl.dao.UserDao;
import com.hl.domain.Role;
import com.hl.domain.UserInfo;
import com.hl.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hl2333
 */
@Service("userService")
@Transactional(rollbackFor = {})
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    private UserDao userDao;

    /*@Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByName(username);
//        String password = passwordEncoder.encode(userInfo.getPassword());
        List<GrantedAuthority> authorities = getAutorities(userInfo.getRoles());
//                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER, ROLE_ADMIN");
        User user = new User(userInfo.getUsername(),
                "{noop}" + userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,
                true,true,true,
                authorities);
        return user;
    }

    private List<GrantedAuthority> getAutorities(List<Role> roles) {
        List<GrantedAuthority> list = new ArrayList<>();

        for (Role role :
                roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
