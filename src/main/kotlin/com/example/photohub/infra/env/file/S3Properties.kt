package com.example.photohub.infra.env.file

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("aws.s3")
class S3Properties(
    val accessKey: String,
    val secretKey: String,
    val region: String,
    val bucketName: String,
    val fileNamePrefix: String,
    val bucketUrl: String
)