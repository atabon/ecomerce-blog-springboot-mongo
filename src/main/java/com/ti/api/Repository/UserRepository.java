package com.ti.api.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ti.api.Model.Post;
import com.ti.api.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // requette personnalisee avec query
    @org.springframework.data.mongodb.repository.Query(value = "{'title': ?0 }", fields = "{'posts':1,'_id':0}")
    public Post wherePostTitlte(String title);

}
