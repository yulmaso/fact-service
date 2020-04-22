package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.User
import com.yulmaso.fact.factservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired

class UserServiceImpl: UserService {
    @Autowired
    private var repository: UserRepository? = null

    override fun getAll(): List<User> = repository!!.findAll()

    override fun getById(id: Long): User = repository!!.getOne(id)

    override fun save(item: User): User = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}