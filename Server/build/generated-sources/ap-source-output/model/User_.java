package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T16:22:14")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> ip;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> nickname;
    public static volatile ListAttribute<User, User> contacts;
    public static volatile SingularAttribute<User, String> status;

}