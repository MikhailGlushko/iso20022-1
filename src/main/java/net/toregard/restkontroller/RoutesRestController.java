package net.toregard.restkontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.toregard.entities.Role;
import net.toregard.entities.Routes;
import net.toregard.persistence.RoleRepository;
import net.toregard.persistence.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RoutesRestController {
    private final static Logger logger = LoggerFactory.getLogger(RoutesRestController.class);
    @Autowired
    private RoutesRepository routesRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value= "/getroutes",produces = "application/json")
    public List<Routes> getroutes() {
        return routesRepository.findAll();
     }

    @RequestMapping(value= "/getroles",produces = "application/json")
    public List<Role> getroles() {
        List<Role> roles = roleRepository.findAll();
        logger.info("LOGGER ROLLER "+roles.toString());
        return roles;
    }
}
