java-se-desktop-template
========================
This project is ment to be a start point to create a Java Standard Edition Desktop Application. For practical reasons, I'have tried to cover some of the most popular technologies such as JPA (with Hibernate implementation), Java Jobs (with Quartz) and Swing for GUI.
java-se-desktop-template is a management system for users and roles, so you'll have an Administration Dropdown, were you can select "Users" and "Roles" to open each window. This will simply display a list of users and users roles.

### Technologies stack

* [Java 7 Swing for User Graphical Interface](http://docs.oracle.com/javase/8/docs/technotes/guides/swing/)
* [Quarts Scheduler 2.2.1 for Chron Jobs](http://quartz-scheduler.org/)
* [Hibernate JPA 4.3.1 for Object Relation Mapping](http://hibernate.org/orm/)

### Project setup
I've decided to use Postgresql as rdbms, but of course you can choose anyone supported by JPA (maybe you should change some implementation details like id generation, and connection string in config file). 

```xml
es (19 sloc)  1.166 kb RawBlameHistory   
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/jsetemplate_db</property>
        <property name="hibernate.connection.username">postgres</property>
        <property name="connection.password">pg_admin</property>
        <property name="connection.pool_size">1</property>
        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
        <property name="show_sql">false</property>
        <property name="hbm2ddl.auto">update</property>
        <property name="hibernate.current_session_context_class">thread</property>
  
        <mapping class="com.mrodriguez.jsetemplate.persistence.entities.UserEntity" />
        <mapping class="com.mrodriguez.jsetemplate.persistence.entities.UserRoleEntity" />
        
    </session-factory>
</hibernate-configuration>
```
You should take special care in the following parameter:
**hibernate.connection.url** : the database connection string (note that each rdbms has different connection string format and driver).
**hibernate.connection.username** : user to connecto to the database.
**connection.password** : password to connecto to the database.
**hbm2ddl.auto** : Automatically validates or exports schema DDL to the database when the SessionFactory is created. In ohter words, if set to update will create the database in case the entities structure does not exists.

That would be all you need to setup to make this project works, so try to add some test data for the users and roles and run it.
