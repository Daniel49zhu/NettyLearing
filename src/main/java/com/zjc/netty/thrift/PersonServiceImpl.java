package com.zjc.netty.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param:" + username);
        return new Person(){{
            this.setAge(20);
            this.setUsername(username);
            this.setMarried(false);
        }};
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param:" );
        System.out.println(person.getAge());
        System.out.println(person.getUsername() );
        System.out.println(person.isMarried() );
    }
}
