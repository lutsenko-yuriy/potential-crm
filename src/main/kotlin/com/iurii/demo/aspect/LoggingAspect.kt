package com.iurii.demo.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Aspect
@Component
class LoggingAspect {

    private val logger = Logger.getLogger(javaClass.name)

    @Pointcut("execution(public * com.iurii.demo.controller.*.*(..))")
    fun forControllers() { }

    @Pointcut("execution(public * com.iurii.demo.service.*.*(..))")
    fun forServices() { }

    @Pointcut("execution(public * com.iurii.demo.dao.*.*(..))")
    fun forDAOs() { }

    @Pointcut("forControllers() || forServices() || forDAOs()")
    fun forNecessaryMethods() {}

    @Before("forNecessaryMethods()")
    fun before(joinPoint: JoinPoint) {
        logger.info("=======> Before running the method ${joinPoint.signature.toShortString()}")
        logger.info("=======> With arguments: ${joinPoint.args.contentToString()}")
    }
}