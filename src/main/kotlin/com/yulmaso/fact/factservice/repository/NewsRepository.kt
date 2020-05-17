package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.News
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface NewsRepository: JpaRepository<News, Long> {

    @Query(value = "SELECT * FROM news ORDER BY time DESC", nativeQuery = true)
    fun getAllNews(): List<News>
}