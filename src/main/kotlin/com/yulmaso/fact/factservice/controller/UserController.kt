package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Event
import com.yulmaso.fact.factservice.model.User
import com.yulmaso.fact.factservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    private var service: UserService? = null

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Long) = service!!.getById(id)

    @GetMapping
    fun getAllUsers(): List<User> = service!!.getAll()

    @PostMapping
    fun saveUser(@RequestBody item: User) = service!!.save(item)

    @DeleteMapping("/remove/{id}")
    fun removeUser(@PathVariable("id") id: Long) = service!!.remove(id)
}