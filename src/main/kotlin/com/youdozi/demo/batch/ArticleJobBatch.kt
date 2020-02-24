package com.youdozi.demo.batch

import com.youdozi.demo.batch.articleBatch.ArticleItemProcessor
import com.youdozi.demo.batch.articleBatch.ArticleItemReader
import com.youdozi.demo.batch.articleBatch.ArticleItemReaderListener
import com.youdozi.demo.batch.articleBatch.ArticleItemWriter
import com.youdozi.demo.entity.Article
import com.youdozi.demo.entity.TempArticle
import com.youdozi.demo.repository.TempArticleRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import javax.persistence.EntityManagerFactory


@Configuration
@EnableBatchProcessing
@PropertySource("classpath:application.properties")
class ArticleJobBatch {

    @Autowired
    private lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    private lateinit var articleItemReader: ArticleItemReader

    @Autowired
    private lateinit var articleItemReaderListener: ArticleItemReaderListener

    @Autowired
    private lateinit var articleItemProcessor: ArticleItemProcessor

    @Autowired
    private lateinit var tempArticleRepository: TempArticleRepository

    @Autowired
    private lateinit var entityManagerFactory: EntityManagerFactory

    @Bean
    fun taskExecutor(): ThreadPoolTaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 12
        executor.maxPoolSize = 24
        executor.setQueueCapacity(500)
        executor.setThreadNamePrefix("spring-batch")
        executor.initialize()
        return executor
    }

    @Bean
    fun articleJob(jobs: JobBuilderFactory): Job {
        return jobs.get("articleJob")
                   .start(articleBatch())
                   .build()
        }

    @Bean
    @Throws(Exception::class)
    fun articleBatch(): Step {
        return stepBuilderFactory.get("articleBatch").chunk<Article, TempArticle>(100)
            .reader(articleItemReader.articleReader(entityManagerFactory))
            .listener(articleItemReaderListener)
            .processor(articleItemProcessor)
            .writer(ArticleItemWriter(tempArticleRepository))
            .taskExecutor(taskExecutor())
            .build()
    }
}
