package cn.com.showings.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * Created by wu on 2016/11/4.
 */
public class BaseController {

    @Autowired
    protected MessageSourceAccessor messageSourceAccessor;
}
