package com.yulmaso.fact.factservice.service.impl

import com.yulmaso.fact.factservice.model.News
import com.yulmaso.fact.factservice.repository.NewsRepository
import com.yulmaso.fact.factservice.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NewsServiceImpl: NewsService {

    @Autowired
    private lateinit var repository: NewsRepository

    override fun getAll(): List<News> = repository.getAllNews()

    override fun getById(id: Long): News = repository.getOne(id)

    override fun save(item: News): News = repository.save(item)

    override fun remove(id: Long) = repository.deleteById(id)
}