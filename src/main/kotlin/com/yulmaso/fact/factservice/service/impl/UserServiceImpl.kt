package com.yulmaso.fact.factservice.service.impl

import com.yulmaso.fact.factservice.model.User
import com.yulmaso.fact.factservice.repository.UserRepository
import com.yulmaso.fact.factservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl: UserService {
    @Autowired
    private var repository: UserRepository? = null

    override fun getAll(): List<User> = repository!!.findAll()

    override fun getById(id: Long): User = repository!!.getOne(id)

    override fun getByUsername(username: String): Optional<User> = repository!!.findByUsername(username)

    override fun save(item: User): User = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}