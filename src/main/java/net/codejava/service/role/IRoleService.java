package net.codejava.service.role;

import net.codejava.model.Role;
import net.codejava.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
