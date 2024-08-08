package com.example.photohub.infra.file

import com.example.photohub.global.Path
import com.example.photohub.infra.env.file.S3Properties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component

@Component
class S3Initializer(
    private val s3Properties: S3Properties
) : BeanPostProcessor {

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        if (bean is S3Manager) {
            S3BaseUrlJoiner.init(
                Path.join(s3Properties.bucketUrl, s3Properties.bucketName)
            )
        }

        return bean
    }
}