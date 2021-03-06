package cn.com.showings.pojo;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by wuxinzhe on 16/9/25.
 */
public class MethodKey implements Serializable{
    private static final long serialVersionUID = 6060404081067325953L;
    private String className;
    private String methodName;

    public MethodKey(){}

    public MethodKey(String fullName){
        this.className = StringUtils.stripFilenameExtension(fullName);
        this.methodName = StringUtils.getFilenameExtension(fullName);
    }

    public MethodKey(Method method) {
        super();
        this.className = method.getDeclaringClass().getName();
        this.methodName = method.getName();
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFullMethodName(){
        return this.className + "." + this.methodName;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MethodKey))return false;

        MethodKey target = (MethodKey)obj;

        if(this.className.equals(target.getClassName()) &&
                this.methodName.equals(target.getMethodName()))return true;

        return false;
    }

    @Override
    public String toString() {
        return "MethodKey{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
