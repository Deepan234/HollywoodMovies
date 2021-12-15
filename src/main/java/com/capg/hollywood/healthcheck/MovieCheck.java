package com.capg.hollywood.healthcheck;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

@Component("moviesAPI")
public class MovieCheck implements CompositeHealthContributor {



private Map<String, HealthContributor> contributors = new LinkedHashMap<>();



@Autowired
public MovieCheck(DatabaseHealthCheck databaseHealthCheck) {
contributors.put("database", databaseHealthCheck);
}



@Override
public HealthContributor getContributor(String name) {
return contributors.get(name);
}



@Override
public Iterator<NamedContributor<HealthContributor>> iterator() {
return contributors.entrySet().stream()
.map((entry) ->
NamedContributor.of(entry.getKey(),
entry.getValue())).iterator();
}



}