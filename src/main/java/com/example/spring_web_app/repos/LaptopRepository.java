package com.example.spring_web_app.repos;

import com.example.spring_web_app.domain.Laptop;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends CrudRepository<Laptop, Integer> {
}
