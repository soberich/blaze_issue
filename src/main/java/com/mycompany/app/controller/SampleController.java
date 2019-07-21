/*
 * Copyright 2014 - 2019 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mycompany.app.controller;

import com.mycompany.app.model.Cat;
import com.mycompany.app.model.Person;
import com.mycompany.app.repository.CatSimpleViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Controller
public class SampleController {

    @Autowired
    CatSimpleViewRepository catRepo;

    @PersistenceContext
    EntityManager em;

    @GetMapping("/")
    @ResponseBody
    String home() {
        return catRepo.findAll().toString();
    }

    @Transactional
    @PostMapping("/")
    @ResponseBody
    String home1() {
        Cat wow = new Cat("wow", 12, new Person("Rick" + LocalDateTime.now()));
        em.persist(wow);
        return wow.toString();
    }

}
