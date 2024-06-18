package com.example.photohub.infra.file.config

import com.example.photohub.infra.env.file.S3Properties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client

@Configuration
class S3Config(
    private val s3Properties: S3Properties
) {

    @Bean
    fun awsS3Client(): S3Client =
        S3Client.builder()
            .credentialsProvider {
                AwsBasicCredentials.create(
                    s3Properties.accessKey,
                    s3Properties.secretKey
                )
            }
            .region(Region.of(s3Properties.region))
            .build()
}