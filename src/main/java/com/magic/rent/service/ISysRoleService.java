package com.magic.rent.service;

import java.util.Map;

/**
 * Created by wu on 2016/11/22.
 */
public interface ISysRoleService {

    boolean insertRolesByUserID(Map<String, Integer> userAndRole);
}
