package voductai.furama_resort.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.employee.User;
import voductai.furama_resort.config.MyUserDetail;
import voductai.furama_resort.repository.employee.IUserRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if(user == null){
           throw new UsernameNotFoundException("User not defined");
        }
        return new MyUserDetail(user);
    }
}
